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

    // In-memory database to store order status
    private static Map<String, String> orderDatabase = new HashMap<>();

    public static void main(String[] args) throws Exception {
        // Create and start the gRPC server on port 50053
        Server server = ServerBuilder.forPort(50053)
                .addService(new FoodAndDrinksServiceImpl()) // Add the service implementation to the server
                .build()
                .start();
        
        // Print a message indicating that the server has started
        System.out.println("Server started on port 50053");
        
        // Keep the server running until terminated
        server.awaitTermination();
    }

    // Implementation of the FoodAndDrinksService gRPC service
    static class FoodAndDrinksServiceImpl extends FoodAndDrinksServiceGrpc.FoodAndDrinksServiceImplBase {

        @Override
        public void placeOrder(PlaceOrderRequest request,
                               StreamObserver<PlaceOrderResponse> responseObserver) {
            // Generate a unique order ID
            String orderId = "ORDER_" + System.currentTimeMillis();
            // Store the order status in the database
            orderDatabase.put(orderId, "PLACED");

            // Build the response to indicate the order has been placed
            PlaceOrderResponse response = PlaceOrderResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Order placed with ID: " + orderId)
                    .build();
            // Send the response to the client
            responseObserver.onNext(response);
            // Indicate that the response is complete
            responseObserver.onCompleted();
        }

        @Override
        public void checkOrderStatus(CheckOrderStatusRequest request,
                                     StreamObserver<CheckOrderStatusResponse> responseObserver) {
            // Retrieve the order ID from the request
            String orderId = request.getOrderId();
            // Get the status of the order from the database, defaulting to "Order ID not found"
            String status = orderDatabase.getOrDefault(orderId, "Order ID not found");

            // Build the response with the order status
            CheckOrderStatusResponse response = CheckOrderStatusResponse.newBuilder()
                    .setStatus(status)
                    .build();
            // Send the response to the client
            responseObserver.onNext(response);
            // Indicate that the response is complete
            responseObserver.onCompleted();
        }

        @Override
        public void streamOrderUpdates(OrderUpdatesRequest request,
                                       StreamObserver<OrderUpdate> responseObserver) {
            // Simulate streaming order updates
            String orderId = "ORDER_" + System.currentTimeMillis(); // Simulate a real order ID
            String[] updates = {
                "Order has been accepted",
                "Order is being prepared",
                "Order has been sent",
                "Order has arrived"
            };

            // Send each update to the client
            for (String update : updates) {
                OrderUpdate orderUpdate = OrderUpdate.newBuilder()
                        .setOrderId(orderId)
                        .setStatus(update)
                        .setMessage(update)
                        .build();
                // Send the update to the client
                responseObserver.onNext(orderUpdate);
                try {
                    // Simulate delay between updates
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Indicate that the streaming is complete
            responseObserver.onCompleted();
        }
    }
}
