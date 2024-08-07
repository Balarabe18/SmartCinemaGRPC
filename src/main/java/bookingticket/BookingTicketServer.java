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

    private static Map<String, String> bookingDatabase = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(new MovieBookingServiceImpl())
                .build()
                .start();
        System.out.println("Server started on port 50051");
        server.awaitTermination();
    }

    static class MovieBookingServiceImpl extends MovieBookingServiceGrpc.MovieBookingServiceImplBase {

        @Override
        public void bookingTicket(BookingRequest request,
                                  StreamObserver<BookingResponse> responseObserver) {
            String bookingId = "BOOKING_" + System.currentTimeMillis();
            bookingDatabase.put(bookingId, "BOOKED");

            BookingResponse response = BookingResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Booking confirmed with ID: " + bookingId)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void cancelTicket(CancelRequest request,
                                 StreamObserver<CancelResponse> responseObserver) {
            String bookingId = request.getBookingid();
            if (bookingDatabase.containsKey(bookingId)) {
                bookingDatabase.remove(bookingId);
                CancelResponse response = CancelResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Booking cancelled: " + bookingId)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {
                CancelResponse response = CancelResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Booking ID not found: " + bookingId)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        }

        @Override
        public void streamBookingUpdates(BookingUpdatesRequest request,
                                         StreamObserver<BookingUpdate> responseObserver) {
            // Simulate sending updates
            for (Map.Entry<String, String> entry : bookingDatabase.entrySet()) {
                BookingUpdate update = BookingUpdate.newBuilder()
                        .setBookingid(entry.getKey())
                        .setStatus(entry.getValue())
                        .setMessage("Update for booking ID: " + entry.getKey())
                        .build();
                responseObserver.onNext(update);
                try {
                    Thread.sleep(1000); // Simulate delay
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            responseObserver.onCompleted();
        }
    }
}

