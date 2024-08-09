package cinemaservice;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import cinemaservice.CinemaServiceProto.ScheduleRequest;
import cinemaservice.CinemaServiceProto.ScheduleResponse;
import cinemaservice.CinemaServiceProto.UpdateScheduleRequest;
import cinemaservice.CinemaServiceProto.UpdateScheduleResponse;
import cinemaservice.CinemaServiceProto.CinemaStatusRequest;
import cinemaservice.CinemaServiceProto.CinemaStatus;
import cinemaservice.CinemaServiceGrpc;

public class CinemaServiceClient {

    public static void main(String[] args) {
        // Create a gRPC channel to connect to the server on localhost at port 50052
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext() // Disable TLS for simplicity
                .build();

        // Create blocking and asynchronous stubs for the CinemaService
        CinemaServiceGrpc.CinemaServiceBlockingStub blockingStub = CinemaServiceGrpc.newBlockingStub(channel);
        CinemaServiceGrpc.CinemaServiceStub asyncStub = CinemaServiceGrpc.newStub(channel);

        // Create a request to schedule a movie
        ScheduleRequest scheduleRequest = ScheduleRequest.newBuilder()
                .setMoviename("Avatar") // Set the name of the movie
                .setStartingtime("2024-08-10T19:30:00") // Set the starting time
                .setDurationtime(180) // Set the duration of the movie in minutes
                .build();
        
        // Send the schedule request and receive the response using the blocking stub
        ScheduleResponse scheduleResponse = blockingStub.scheduleMovie(scheduleRequest);
        // Print the response message to the console
        System.out.println("ScheduleMovie Response: " + scheduleResponse.getMessage());

        // Create a request to update an existing schedule
        UpdateScheduleRequest updateScheduleRequest = UpdateScheduleRequest.newBuilder()
                .setScheduleId("SCHEDULE_ID_TO_UPDATE") // Replace with a valid schedule ID
                .setUpdatetime("2024-08-11T20:00:00") // Set the new update time
                .build();
        
        // Send the update schedule request and receive the response using the blocking stub
        UpdateScheduleResponse updateScheduleResponse = blockingStub.updateSchedule(updateScheduleRequest);
        // Print the response message to the console
        System.out.println("UpdateSchedule Response: " + updateScheduleResponse.getMessage());

        // Create a request to stream cinema status updates
        CinemaStatusRequest statusRequest = CinemaStatusRequest.newBuilder()
                .setCinemaId("CINEMA_ID") // Set the cinema ID
                .build();
        
        // Send the status request and handle the stream of responses using the asynchronous stub
        asyncStub.streamCinemaStatus(statusRequest, new StreamObserver<CinemaStatus>() {
            @Override
            public void onNext(CinemaStatus cinemaStatus) {
                // Handle each CinemaStatus update received from the server
                System.out.println("CinemaStatus: " + cinemaStatus.getMoviename() +
                        ", Status: " + cinemaStatus.getStatus() +
                        ", Climate: " + cinemaStatus.getClimate() +
                        ", Occupancy: " + cinemaStatus.getOccupancy());
            }

            @Override
            public void onError(Throwable t) {
                // Handle any errors encountered during streaming
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                // Print a message when the streaming is complete
                System.out.println("Completed receiving cinema status updates");
            }
        });

        // Keep the client running to receive streaming updates
        try {
            // Extend the sleep time to keep the client alive longer for receiving updates
            Thread.sleep(30000); // Keep the client alive for 30 seconds
        } catch (InterruptedException e) {
            // Handle interruptions while sleeping
            e.printStackTrace();
        }

        // Shutdown the channel to clean up resources
        channel.shutdown();
    }
}
