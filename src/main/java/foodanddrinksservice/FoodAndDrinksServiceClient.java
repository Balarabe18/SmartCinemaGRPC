package foodanddrinksservice;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest;
import foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse;
import foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest;
import foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse;
import foodanddrinksservice.FoodAndDrinksServiceProto.Item;
import foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest;
import foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate;
import foodanddrinksservice.FoodAndDrinksServiceGrpc;

public class FoodAndDrinksServiceClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                .usePlaintext()
                .build();

        // Add a shutdown hook to close the channel gracefully
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC channel");
            channel.shutdown();
        }));

        FoodAndDrinksServiceGrpc.FoodAndDrinksServiceBlockingStub blockingStub = FoodAndDrinksServiceGrpc.newBlockingStub(channel);
        FoodAndDrinksServiceGrpc.FoodAndDrinksServiceStub asyncStub = FoodAndDrinksServiceGrpc.newStub(channel);

        try {
            // Place an order
            PlaceOrderRequest placeOrderRequest = PlaceOrderRequest.newBuilder()
                    .setSeatId("A12")
                    .addOrder(Item.newBuilder().setItemName("Popcorn").setQuantity(1).build())
                    .addOrder(Item.newBuilder().setItemName("Drink").setQuantity(2).build())
                    .build();
            PlaceOrderResponse placeOrderResponse = blockingStub.placeOrder(placeOrderRequest);
            System.out.println("PlaceOrder Response: " + placeOrderResponse.getMessage());

            // Check order status
            CheckOrderStatusRequest checkOrderStatusRequest = CheckOrderStatusRequest.newBuilder()
                    .setOrderId("ORDER_ID_TO_CHECK") // Replace with a valid order ID
                    .build();
            CheckOrderStatusResponse checkOrderStatusResponse = blockingStub.checkOrderStatus(checkOrderStatusRequest);
            System.out.println("CheckOrderStatus Response: " + checkOrderStatusResponse.getStatus());

            // Stream order updates
            OrderUpdatesRequest updatesRequest = OrderUpdatesRequest.newBuilder()
                    .setCustomerId("CUSTOMER_ID")
                    .build();
            asyncStub.streamOrderUpdates(updatesRequest, new StreamObserver<OrderUpdate>() {
                @Override
                public void onNext(OrderUpdate orderUpdate) {
                    System.out.println("OrderUpdate: " + orderUpdate.getMessage());
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("StreamObserver onError: " + t.getMessage());
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    System.out.println("Completed receiving order updates");
                }
            });

            // Keep the client running to receive streaming updates
            Thread.sleep(10000); // Keep the client alive for 10 seconds to receive updates

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.shutdown();
        }
    }
}


