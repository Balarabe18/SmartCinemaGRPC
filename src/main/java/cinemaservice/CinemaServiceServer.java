package cinemaservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import cinemaservice.CinemaServiceGrpc;
import cinemaservice.CinemaServiceProto.*;

import java.io.IOException;

public class CinemaServiceServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create and start a gRPC server on port 50052
        Server server = ServerBuilder.forPort(50052)
                .addService(new CinemaServiceImpl()) // Add the service implementation
                .build() // Build the server
                .start(); // Start the server
        
        // Print a message indicating the server has started
        System.out.println("Server started on port 50052");
        
        // Keep the server running and wait for termination
        server.awaitTermination();
    }

    // Implementation of the CinemaService gRPC service
    static class CinemaServiceImpl extends CinemaServiceGrpc.CinemaServiceImplBase {

        @Override
        public void scheduleMovie(ScheduleRequest request, StreamObserver<ScheduleResponse> responseObserver) {
            // Create a response indicating success and the movie scheduled
            ScheduleResponse response = ScheduleResponse.newBuilder()
                    .setSuccess(true) // Indicate that the scheduling was successful
                    .setMessage("Movie scheduled: " + request.getMoviename()) // Provide a message with the movie name
                    .build();
            
            // Send the response to the client
            responseObserver.onNext(response);
            // Mark the response as completed
            responseObserver.onCompleted();
        }

        @Override
        public void updateSchedule(UpdateScheduleRequest request, StreamObserver<UpdateScheduleResponse> responseObserver) {
            // Create a response indicating success and the schedule ID updated
            UpdateScheduleResponse response = UpdateScheduleResponse.newBuilder()
                    .setSuccess(true) // Indicate that the schedule update was successful
                    .setMessage("Schedule updated for ID: " + request.getScheduleId()) // Provide a message with the schedule ID
                    .build();
            
            // Send the response to the client
            responseObserver.onNext(response);
            // Mark the response as completed
            responseObserver.onCompleted();
        }

        @Override
        public void streamCinemaStatus(CinemaStatusRequest request, StreamObserver<CinemaStatus> responseObserver) {
            // Simulate streaming cinema status updates
            for (int i = 0; i < 5; i++) {
                // Build a CinemaStatus object with simulated data
                CinemaStatus status = CinemaStatus.newBuilder()
                        .setMoviename("Movie " + i) // Simulate different movie names
                        .setStatus("Playing") // Simulate the cinema status
                        .setClimate("Cool") // Simulate the cinema climate
                        .setOccupancy(50 + i) // Simulate increasing occupancy
                        .build();
                
                // Send the status update to the client
                responseObserver.onNext(status);
                
                // Simulate a delay between status updates
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace(); // Handle interrupted exception
                }
            }
            // Mark the streaming as completed
            responseObserver.onCompleted();
        }
    }
}
