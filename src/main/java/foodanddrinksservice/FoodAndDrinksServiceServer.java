package foodanddrinksservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest;
import foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse;
import foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest;
import foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse;
import foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest;
import foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate;
import foodanddrinksservice.FoodAndDrinksServiceGrpc;

import java.util.HashMap;
import java.util.Map;

public class FoodAndDrinksServiceServer {

    private static Map<String, String> orderDatabase = new HashMap<>();
    private static Map<String, OrderUpdate> orderUpdatesDatabase = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50053)
                .addService(new FoodAndDrinksServiceImpl())
                .build()
                .start();
        System.out.println("Server started on port 50053");
        server.awaitTermination();
    }

    static class FoodAndDrinksServiceImpl extends FoodAndDrinksServiceGrpc.FoodAndDrinksServiceImplBase {

        @Override
        public void placeOrder(PlaceOrderRequest request,
                               StreamObserver<PlaceOrderResponse> responseObserver) {
            String orderId = "ORDER_" + System.currentTimeMillis();
            orderDatabase.put(orderId, "PLACED");

            PlaceOrderResponse response = PlaceOrderResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Order placed with ID: " + orderId)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void checkOrderStatus(CheckOrderStatusRequest request,
                                     StreamObserver<CheckOrderStatusResponse> responseObserver) {
            String orderId = request.getOrderId();
            String status = orderDatabase.getOrDefault(orderId, "Order ID not found");

            CheckOrderStatusResponse response = CheckOrderStatusResponse.newBuilder()
                    .setStatus(status)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void streamOrderUpdates(OrderUpdatesRequest request,
                                       StreamObserver<OrderUpdate> responseObserver) {
            // Simulate sending updates
            for (int i = 0; i < 5; i++) {
                OrderUpdate update = OrderUpdate.newBuilder()
                        .setOrderId("ORDER_" + i)
                        .setStatus("PREPARING")
                        .setMessage("Order is being prepared")
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

