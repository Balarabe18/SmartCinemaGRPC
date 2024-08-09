package bookingticket;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import bookingticket.BookingTicketProto.BookingRequest;
import bookingticket.BookingTicketProto.BookingResponse;
import bookingticket.BookingTicketProto.CancelRequest;
import bookingticket.BookingTicketProto.CancelResponse;
import bookingticket.BookingTicketProto.BookingUpdatesRequest;
import bookingticket.BookingTicketProto.BookingUpdate;
import bookingticket.MovieBookingServiceGrpc;

import java.util.HashMap;
import java.util.Map;

public class BookingTicketServer {

    // In-memory database to store booking information. The key is the booking ID and the value is the status.
    private static Map<String, String> bookingDatabase = new HashMap<>();

    public static void main(String[] args) throws Exception {
        // Create and start a gRPC server that listens on port 50051
        Server server = ServerBuilder.forPort(50051)
                .addService(new MovieBookingServiceImpl()) // Add the implementation of the service
                .build()
                .start();
        System.out.println("Server started on port 50051");
        server.awaitTermination(); // Wait for the server to be terminated
    }

    // Implementation of the MovieBookingService gRPC service
    static class MovieBookingServiceImpl extends MovieBookingServiceGrpc.MovieBookingServiceImplBase {

        // Handle booking ticket requests
        @Override
        public void bookingTicket(BookingRequest request,
                                  StreamObserver<BookingResponse> responseObserver) {
            // Generate a unique booking ID based on the current time
            String bookingId = "BOOKING_" + System.currentTimeMillis();
            // Add the booking to the in-memory database with a status of "BOOKED"
            bookingDatabase.put(bookingId, "BOOKED");

            // Build the response with success status and booking ID
            BookingResponse response = BookingResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Booking confirmed with ID: " + bookingId)
                    .build();
            // Send the response to the client
            responseObserver.onNext(response);
            // Indicate that the response is complete
            responseObserver.onCompleted();
        }

        // Handle canceling ticket requests
        @Override
        public void cancelTicket(CancelRequest request,
                                 StreamObserver<CancelResponse> responseObserver) {
            // Extract the booking ID from the request
            String bookingId = request.getBookingid();
            // Check if the booking ID exists in the database
            if (bookingDatabase.containsKey(bookingId)) {
                // Remove the booking from the database
                bookingDatabase.remove(bookingId);
                // Build a successful response indicating the booking was canceled
                CancelResponse response = CancelResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Booking cancelled: " + bookingId)
                        .build();
                // Send the response to the client
                responseObserver.onNext(response);
                // Indicate that the response is complete
                responseObserver.onCompleted();
            } else {
                // Build a failed response indicating the booking ID was not found
                CancelResponse response = CancelResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Booking ID not found: " + bookingId)
                        .build();
                // Send the response to the client
                responseObserver.onNext(response);
                // Indicate that the response is complete
                responseObserver.onCompleted();
            }
        }

        // Handle streaming booking updates requests
        @Override
        public void streamBookingUpdates(BookingUpdatesRequest request,
                                         StreamObserver<BookingUpdate> responseObserver) {
            // Simulate sending booking updates
            for (Map.Entry<String, String> entry : bookingDatabase.entrySet()) {
                // Build a booking update message
                BookingUpdate update = BookingUpdate.newBuilder()
                        .setBookingid(entry.getKey())
                        .setStatus(entry.getValue())
                        .setMessage("Update for booking ID: " + entry.getKey())
                        .build();
                // Send the update to the client
                responseObserver.onNext(update);
                try {
                    // Simulate a delay in sending updates
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // Indicate that the streaming of updates is complete
            responseObserver.onCompleted();
        }
    }
}
