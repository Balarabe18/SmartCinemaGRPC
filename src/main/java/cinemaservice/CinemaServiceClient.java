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
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        CinemaServiceGrpc.CinemaServiceBlockingStub blockingStub = CinemaServiceGrpc.newBlockingStub(channel);
        CinemaServiceGrpc.CinemaServiceStub asyncStub = CinemaServiceGrpc.newStub(channel);

        // Schedule a movie
        ScheduleRequest scheduleRequest = ScheduleRequest.newBuilder()
                .setMoviename("Avatar")
                .setStartingtime("2024-08-10T19:30:00")
                .setDurationtime(180)
                .build();
        ScheduleResponse scheduleResponse = blockingStub.scheduleMovie(scheduleRequest);
        System.out.println("ScheduleMovie Response: " + scheduleResponse.getMessage());

        // Update a schedule
        UpdateScheduleRequest updateScheduleRequest = UpdateScheduleRequest.newBuilder()
                .setScheduleId("SCHEDULE_ID_TO_UPDATE") // Replace with a valid schedule ID
                .setUpdatetime("2024-08-11T20:00:00")
                .build();
        UpdateScheduleResponse updateScheduleResponse = blockingStub.updateSchedule(updateScheduleRequest);
        System.out.println("UpdateSchedule Response: " + updateScheduleResponse.getMessage());

        // Stream cinema status
        CinemaStatusRequest statusRequest = CinemaStatusRequest.newBuilder()
                .setCinemaId("CINEMA_ID")
                .build();
        asyncStub.streamCinemaStatus(statusRequest, new StreamObserver<CinemaStatus>() {
            @Override
            public void onNext(CinemaStatus cinemaStatus) {
                System.out.println("CinemaStatus: " + cinemaStatus.getMoviename() +
                        ", Status: " + cinemaStatus.getStatus() +
                        ", Climate: " + cinemaStatus.getClimate() +
                        ", Occupancy: " + cinemaStatus.getOccupancy());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Completed receiving cinema status updates");
            }
        });

        // Keep the client running to receive streaming updates
        try {
            // Extend the sleep time to keep the client alive longer
            Thread.sleep(30000); // Keep the client alive for 30 seconds to receive updates
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        channel.shutdown();
    }
}
