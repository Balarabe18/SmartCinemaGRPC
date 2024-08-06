package foodanddrinksservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: foodanddrinksservice.proto")
public final class FoodAndDrinksServiceGrpc {

  private FoodAndDrinksServiceGrpc() {}

  public static final String SERVICE_NAME = "FoodAndDrinksService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest,
      foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse> getPlaceOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PlaceOrder",
      requestType = foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest.class,
      responseType = foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest,
      foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse> getPlaceOrderMethod() {
    io.grpc.MethodDescriptor<foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest, foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse> getPlaceOrderMethod;
    if ((getPlaceOrderMethod = FoodAndDrinksServiceGrpc.getPlaceOrderMethod) == null) {
      synchronized (FoodAndDrinksServiceGrpc.class) {
        if ((getPlaceOrderMethod = FoodAndDrinksServiceGrpc.getPlaceOrderMethod) == null) {
          FoodAndDrinksServiceGrpc.getPlaceOrderMethod = getPlaceOrderMethod = 
              io.grpc.MethodDescriptor.<foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest, foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "FoodAndDrinksService", "PlaceOrder"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FoodAndDrinksServiceMethodDescriptorSupplier("PlaceOrder"))
                  .build();
          }
        }
     }
     return getPlaceOrderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest,
      foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse> getCheckOrderStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckOrderStatus",
      requestType = foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest.class,
      responseType = foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest,
      foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse> getCheckOrderStatusMethod() {
    io.grpc.MethodDescriptor<foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest, foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse> getCheckOrderStatusMethod;
    if ((getCheckOrderStatusMethod = FoodAndDrinksServiceGrpc.getCheckOrderStatusMethod) == null) {
      synchronized (FoodAndDrinksServiceGrpc.class) {
        if ((getCheckOrderStatusMethod = FoodAndDrinksServiceGrpc.getCheckOrderStatusMethod) == null) {
          FoodAndDrinksServiceGrpc.getCheckOrderStatusMethod = getCheckOrderStatusMethod = 
              io.grpc.MethodDescriptor.<foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest, foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "FoodAndDrinksService", "CheckOrderStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new FoodAndDrinksServiceMethodDescriptorSupplier("CheckOrderStatus"))
                  .build();
          }
        }
     }
     return getCheckOrderStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest,
      foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate> getStreamOrderUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamOrderUpdates",
      requestType = foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest.class,
      responseType = foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest,
      foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate> getStreamOrderUpdatesMethod() {
    io.grpc.MethodDescriptor<foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest, foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate> getStreamOrderUpdatesMethod;
    if ((getStreamOrderUpdatesMethod = FoodAndDrinksServiceGrpc.getStreamOrderUpdatesMethod) == null) {
      synchronized (FoodAndDrinksServiceGrpc.class) {
        if ((getStreamOrderUpdatesMethod = FoodAndDrinksServiceGrpc.getStreamOrderUpdatesMethod) == null) {
          FoodAndDrinksServiceGrpc.getStreamOrderUpdatesMethod = getStreamOrderUpdatesMethod = 
              io.grpc.MethodDescriptor.<foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest, foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "FoodAndDrinksService", "StreamOrderUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new FoodAndDrinksServiceMethodDescriptorSupplier("StreamOrderUpdates"))
                  .build();
          }
        }
     }
     return getStreamOrderUpdatesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FoodAndDrinksServiceStub newStub(io.grpc.Channel channel) {
    return new FoodAndDrinksServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FoodAndDrinksServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FoodAndDrinksServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FoodAndDrinksServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FoodAndDrinksServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FoodAndDrinksServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void placeOrder(foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest request,
        io.grpc.stub.StreamObserver<foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPlaceOrderMethod(), responseObserver);
    }

    /**
     */
    public void checkOrderStatus(foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest request,
        io.grpc.stub.StreamObserver<foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckOrderStatusMethod(), responseObserver);
    }

    /**
     */
    public void streamOrderUpdates(foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest request,
        io.grpc.stub.StreamObserver<foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamOrderUpdatesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPlaceOrderMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest,
                foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse>(
                  this, METHODID_PLACE_ORDER)))
          .addMethod(
            getCheckOrderStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest,
                foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse>(
                  this, METHODID_CHECK_ORDER_STATUS)))
          .addMethod(
            getStreamOrderUpdatesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest,
                foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate>(
                  this, METHODID_STREAM_ORDER_UPDATES)))
          .build();
    }
  }

  /**
   */
  public static final class FoodAndDrinksServiceStub extends io.grpc.stub.AbstractStub<FoodAndDrinksServiceStub> {
    private FoodAndDrinksServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FoodAndDrinksServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FoodAndDrinksServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FoodAndDrinksServiceStub(channel, callOptions);
    }

    /**
     */
    public void placeOrder(foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest request,
        io.grpc.stub.StreamObserver<foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkOrderStatus(foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest request,
        io.grpc.stub.StreamObserver<foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckOrderStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamOrderUpdates(foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest request,
        io.grpc.stub.StreamObserver<foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamOrderUpdatesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FoodAndDrinksServiceBlockingStub extends io.grpc.stub.AbstractStub<FoodAndDrinksServiceBlockingStub> {
    private FoodAndDrinksServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FoodAndDrinksServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FoodAndDrinksServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FoodAndDrinksServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse placeOrder(foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest request) {
      return blockingUnaryCall(
          getChannel(), getPlaceOrderMethod(), getCallOptions(), request);
    }

    /**
     */
    public foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse checkOrderStatus(foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest request) {
      return blockingUnaryCall(
          getChannel(), getCheckOrderStatusMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate> streamOrderUpdates(
        foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamOrderUpdatesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FoodAndDrinksServiceFutureStub extends io.grpc.stub.AbstractStub<FoodAndDrinksServiceFutureStub> {
    private FoodAndDrinksServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FoodAndDrinksServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FoodAndDrinksServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FoodAndDrinksServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse> placeOrder(
        foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPlaceOrderMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse> checkOrderStatus(
        foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckOrderStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PLACE_ORDER = 0;
  private static final int METHODID_CHECK_ORDER_STATUS = 1;
  private static final int METHODID_STREAM_ORDER_UPDATES = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FoodAndDrinksServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FoodAndDrinksServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PLACE_ORDER:
          serviceImpl.placeOrder((foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderRequest) request,
              (io.grpc.stub.StreamObserver<foodanddrinksservice.FoodAndDrinksServiceProto.PlaceOrderResponse>) responseObserver);
          break;
        case METHODID_CHECK_ORDER_STATUS:
          serviceImpl.checkOrderStatus((foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusRequest) request,
              (io.grpc.stub.StreamObserver<foodanddrinksservice.FoodAndDrinksServiceProto.CheckOrderStatusResponse>) responseObserver);
          break;
        case METHODID_STREAM_ORDER_UPDATES:
          serviceImpl.streamOrderUpdates((foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdatesRequest) request,
              (io.grpc.stub.StreamObserver<foodanddrinksservice.FoodAndDrinksServiceProto.OrderUpdate>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class FoodAndDrinksServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FoodAndDrinksServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return foodanddrinksservice.FoodAndDrinksServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FoodAndDrinksService");
    }
  }

  private static final class FoodAndDrinksServiceFileDescriptorSupplier
      extends FoodAndDrinksServiceBaseDescriptorSupplier {
    FoodAndDrinksServiceFileDescriptorSupplier() {}
  }

  private static final class FoodAndDrinksServiceMethodDescriptorSupplier
      extends FoodAndDrinksServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FoodAndDrinksServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FoodAndDrinksServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FoodAndDrinksServiceFileDescriptorSupplier())
              .addMethod(getPlaceOrderMethod())
              .addMethod(getCheckOrderStatusMethod())
              .addMethod(getStreamOrderUpdatesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
