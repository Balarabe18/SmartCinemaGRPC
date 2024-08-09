package bookingticket;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import bookingticket.BookingTicketProto.BookingRequest;
import bookingticket.BookingTicketProto.BookingResponse;
import bookingticket.BookingTicketProto.CancelRequest;
import bookingticket.BookingTicketProto.CancelResponse;
import bookingticket.BookingTicketProto.BookingUpdatesRequest;
import bookingticket.BookingTicketProto.BookingUpdate;
import bookingticket.MovieBookingServiceGrpc;

public class BookingTicketClient {

    public static void main(String[] args) {
        // Create a gRPC channel to communicate with the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext() // Disable SSL for simplicity
                .build();

        // Create a blocking stub for synchronous calls
        MovieBookingServiceGrpc.MovieBookingServiceBlockingStub blockingStub = MovieBookingServiceGrpc.newBlockingStub(channel);

        // Create an async stub for asynchronous calls
        MovieBookingServiceGrpc.MovieBookingServiceStub asyncStub = MovieBookingServiceGrpc.newStub(channel);

        // Book a ticket
        // Build a BookingRequest with movie details
        BookingRequest bookingRequest = BookingRequest.newBuilder()
                .setMoviename("Inception")
                .setSeatId(2)
                .setStarttime("2024-08-10T19:30:00")
                .build();
        // Call the bookingTicket method on the blockingStub
        BookingResponse bookingResponse = blockingStub.bookingTicket(bookingRequest);
        // Print the booking confirmation message
        System.out.println("BookingTicket Response: " + bookingResponse.getMessage());

        // Cancel a ticket
        // Build a CancelRequest with the booking ID to cancel
        CancelRequest cancelRequest = CancelRequest.newBuilder()
                .setBookingid("BOOKING_ID_TO_CANCEL") // Replace with a valid booking ID
                .build();
        // Call the cancelTicket method on the blockingStub
        CancelResponse cancelResponse = blockingStub.cancelTicket(cancelRequest);
        // Print the cancellation confirmation message
        System.out.println("CancelTicket Response: " + cancelResponse.getMessage());

        // Stream booking updates
        // Build a BookingUpdatesRequest with the user ID
        BookingUpdatesRequest updatesRequest = BookingUpdatesRequest.newBuilder()
                .setUserid("USER_ID")
                .build();
        // Call the streamBookingUpdates method on the asyncStub
        asyncStub.streamBookingUpdates(updatesRequest, new StreamObserver<BookingUpdate>() {
            @Override
            public void onNext(BookingUpdate bookingUpdate) {
                // Handle each booking update received from the server
                System.out.println("BookingUpdate: " + bookingUpdate.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                // Handle any errors encountered during streaming
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                // Handle the completion of streaming updates
                System.out.println("Completed receiving booking updates");
            }
        });

        // Keep the client running to receive streaming updates
        try {
            Thread.sleep(5000); // Keep the client alive for 5 seconds to receive updates
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown the channel to close the connection to the server
        channel.shutdown();
    }
}