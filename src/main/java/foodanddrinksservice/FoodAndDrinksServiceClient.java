package foodanddrinksservice;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest;
import foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse;
import foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest;
import foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse;
import foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest;
import foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate;
import foodanddrinksservice.FoodAndDrinksServiceGrpc;

public class FoodAndDrinksServiceClient {

    public static void main(String[] args) {
        // Create a gRPC channel to connect to the server on localhost at port 50053
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                .usePlaintext() // Disable TLS for simplicity
                .build();

        // Add a shutdown hook to close the channel gracefully when the application is terminated
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC channel");
            channel.shutdown();
        }));

        // Create blocking and asynchronous stubs for the FoodAndDrinksService
        FoodAndDrinksServiceGrpc.FoodAndDrinksServiceBlockingStub blockingStub = FoodAndDrinksServiceGrpc.newBlockingStub(channel);
        FoodAndDrinksServiceGrpc.FoodAndDrinksServiceStub asyncStub = FoodAndDrinksServiceGrpc.newStub(channel);

        try {
            // Create a request to place an order
            PlaceOrderRequest placeOrderRequest = PlaceOrderRequest.newBuilder()
                    .setSeatId("A12") // Set the seat ID for the order
                    // Add items to the order
                    .addOrder(foodanddrinksservice.FoodAndDrinksServiceProto.Item.newBuilder().setItemName("Popcorn").setQuantity(1).build())
                    .addOrder(foodanddrinksservice.FoodAndDrinksServiceProto.Item.newBuilder().setItemName("Drink").setQuantity(2).build())
                    .build();
            
            // Send the place order request and receive the response using the blocking stub
            PlaceOrderResponse placeOrderResponse = blockingStub.placeOrder(placeOrderRequest);
            // Print the response message to the console
            System.out.println("PlaceOrder Response: " + placeOrderResponse.getMessage());

            // Create a request to check the status of an order
            CheckOrderStatusRequest checkOrderStatusRequest = CheckOrderStatusRequest.newBuilder()
                    .setOrderId("ORDER_ID_TO_CHECK") // Replace with a valid order ID
                    .build();
            
            // Send the check order status request and receive the response using the blocking stub
            CheckOrderStatusResponse checkOrderStatusResponse = blockingStub.checkOrderStatus(checkOrderStatusRequest);
            // Print the status of the order to the console
            System.out.println("CheckOrderStatus Response: " + checkOrderStatusResponse.getStatus());

            // Create a request to stream order updates
            OrderUpdatesRequest updatesRequest = OrderUpdatesRequest.newBuilder()
                    .setCustomerId("CUSTOMER_ID") // Set the customer ID for the updates
                    .build();
            
            // Send the order updates request and handle the stream of responses using the asynchronous stub
            asyncStub.streamOrderUpdates(updatesRequest, new StreamObserver<OrderUpdate>() {
                @Override
                public void onNext(OrderUpdate orderUpdate) {
                    // Handle each OrderUpdate received from the server
                    System.out.println("OrderUpdate: " + orderUpdate.getMessage());
                }

                @Override
                public void onError(Throwable t) {
                    // Handle any errors encountered during streaming
                    System.err.println("StreamObserver onError: " + t.getMessage());
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    // Print a message when the streaming is complete
                    System.out.println("Completed receiving order updates");
                }
            });

            // Keep the client running to receive streaming updates
            Thread.sleep(10000); // Keep the client alive for 10 seconds to receive updates

        } catch (Exception e) {
            // Handle any exceptions that occur during the execution
            e.printStackTrace();
        } finally {
            // Shutdown the channel to clean up resources
            channel.shutdown();
        }
    }
}
