package cinemaservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import cinemaservice.CinemaServiceGrpc;
import cinemaservice.CinemaServiceProto.*;

import java.io.IOException;

public class CinemaServiceServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50052)
                .addService(new CinemaServiceImpl())
                .build()
                .start();
        
        System.out.println("Server started on port 50052");
        server.awaitTermination();
    }

    static class CinemaServiceImpl extends CinemaServiceGrpc.CinemaServiceImplBase {

        @Override
        public void scheduleMovie(ScheduleRequest request, StreamObserver<ScheduleResponse> responseObserver) {
            ScheduleResponse response = ScheduleResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Movie scheduled: " + request.getMoviename())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void updateSchedule(UpdateScheduleRequest request, StreamObserver<UpdateScheduleResponse> responseObserver) {
            UpdateScheduleResponse response = UpdateScheduleResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Schedule updated for ID: " + request.getScheduleId())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void streamCinemaStatus(CinemaStatusRequest request, StreamObserver<CinemaStatus> responseObserver) {
            for (int i = 0; i < 5; i++) {
                CinemaStatus status = CinemaStatus.newBuilder()
                        .setMoviename("Movie " + i)
                        .setStatus("Playing")
                        .setClimate("Cool")
                        .setOccupancy(50 + i)
                        .build();
                responseObserver.onNext(status);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            responseObserver.onCompleted();
        }
    }
}

