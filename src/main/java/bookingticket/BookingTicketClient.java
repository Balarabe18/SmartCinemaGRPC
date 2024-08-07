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
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        MovieBookingServiceGrpc.MovieBookingServiceBlockingStub blockingStub = MovieBookingServiceGrpc.newBlockingStub(channel);
        MovieBookingServiceGrpc.MovieBookingServiceStub asyncStub = MovieBookingServiceGrpc.newStub(channel);

        // Book a ticket
        BookingRequest bookingRequest = BookingRequest.newBuilder()
                .setMoviename("Inception")
                .setSeatId(2)
                .setStarttime("2024-08-10T19:30:00")
                .build();
        BookingResponse bookingResponse = blockingStub.bookingTicket(bookingRequest);
        System.out.println("BookingTicket Response: " + bookingResponse.getMessage());

        // Cancel a ticket
        CancelRequest cancelRequest = CancelRequest.newBuilder()
                .setBookingid("BOOKING_ID_TO_CANCEL") // Replace with a valid booking ID
                .build();
        CancelResponse cancelResponse = blockingStub.cancelTicket(cancelRequest);
        System.out.println("CancelTicket Response: " + cancelResponse.getMessage());

        // Stream booking updates
        BookingUpdatesRequest updatesRequest = BookingUpdatesRequest.newBuilder()
                .setUserid("USER_ID")
                .build();
        asyncStub.streamBookingUpdates(updatesRequest, new StreamObserver<BookingUpdate>() {
            @Override
            public void onNext(BookingUpdate bookingUpdate) {
                System.out.println("BookingUpdate: " + bookingUpdate.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Completed receiving booking updates");
            }
        });

        // Keep the client running to receive streaming updates
        try {
            Thread.sleep(5000); // Keep the client alive for 5 seconds to receive updates
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        channel.shutdown();
    }
}
