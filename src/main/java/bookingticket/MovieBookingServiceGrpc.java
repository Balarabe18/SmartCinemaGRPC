package bookingticket;

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
    comments = "Source: bookingticket.proto")
public final class MovieBookingServiceGrpc {

  private MovieBookingServiceGrpc() {}

  public static final String SERVICE_NAME = "MovieBookingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<bookingticket.BookingTicketProto.BookingRequest,
      bookingticket.BookingTicketProto.BookingResponse> getBookingTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BookingTicket",
      requestType = bookingticket.BookingTicketProto.BookingRequest.class,
      responseType = bookingticket.BookingTicketProto.BookingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<bookingticket.BookingTicketProto.BookingRequest,
      bookingticket.BookingTicketProto.BookingResponse> getBookingTicketMethod() {
    io.grpc.MethodDescriptor<bookingticket.BookingTicketProto.BookingRequest, bookingticket.BookingTicketProto.BookingResponse> getBookingTicketMethod;
    if ((getBookingTicketMethod = MovieBookingServiceGrpc.getBookingTicketMethod) == null) {
      synchronized (MovieBookingServiceGrpc.class) {
        if ((getBookingTicketMethod = MovieBookingServiceGrpc.getBookingTicketMethod) == null) {
          MovieBookingServiceGrpc.getBookingTicketMethod = getBookingTicketMethod = 
              io.grpc.MethodDescriptor.<bookingticket.BookingTicketProto.BookingRequest, bookingticket.BookingTicketProto.BookingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MovieBookingService", "BookingTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  bookingticket.BookingTicketProto.BookingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  bookingticket.BookingTicketProto.BookingResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MovieBookingServiceMethodDescriptorSupplier("BookingTicket"))
                  .build();
          }
        }
     }
     return getBookingTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<bookingticket.BookingTicketProto.CancelRequest,
      bookingticket.BookingTicketProto.CancelResponse> getCancelTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelTicket",
      requestType = bookingticket.BookingTicketProto.CancelRequest.class,
      responseType = bookingticket.BookingTicketProto.CancelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<bookingticket.BookingTicketProto.CancelRequest,
      bookingticket.BookingTicketProto.CancelResponse> getCancelTicketMethod() {
    io.grpc.MethodDescriptor<bookingticket.BookingTicketProto.CancelRequest, bookingticket.BookingTicketProto.CancelResponse> getCancelTicketMethod;
    if ((getCancelTicketMethod = MovieBookingServiceGrpc.getCancelTicketMethod) == null) {
      synchronized (MovieBookingServiceGrpc.class) {
        if ((getCancelTicketMethod = MovieBookingServiceGrpc.getCancelTicketMethod) == null) {
          MovieBookingServiceGrpc.getCancelTicketMethod = getCancelTicketMethod = 
              io.grpc.MethodDescriptor.<bookingticket.BookingTicketProto.CancelRequest, bookingticket.BookingTicketProto.CancelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "MovieBookingService", "CancelTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  bookingticket.BookingTicketProto.CancelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  bookingticket.BookingTicketProto.CancelResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new MovieBookingServiceMethodDescriptorSupplier("CancelTicket"))
                  .build();
          }
        }
     }
     return getCancelTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<bookingticket.BookingTicketProto.BookingUpdatesRequest,
      bookingticket.BookingTicketProto.BookingUpdate> getStreamBookingUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamBookingUpdates",
      requestType = bookingticket.BookingTicketProto.BookingUpdatesRequest.class,
      responseType = bookingticket.BookingTicketProto.BookingUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<bookingticket.BookingTicketProto.BookingUpdatesRequest,
      bookingticket.BookingTicketProto.BookingUpdate> getStreamBookingUpdatesMethod() {
    io.grpc.MethodDescriptor<bookingticket.BookingTicketProto.BookingUpdatesRequest, bookingticket.BookingTicketProto.BookingUpdate> getStreamBookingUpdatesMethod;
    if ((getStreamBookingUpdatesMethod = MovieBookingServiceGrpc.getStreamBookingUpdatesMethod) == null) {
      synchronized (MovieBookingServiceGrpc.class) {
        if ((getStreamBookingUpdatesMethod = MovieBookingServiceGrpc.getStreamBookingUpdatesMethod) == null) {
          MovieBookingServiceGrpc.getStreamBookingUpdatesMethod = getStreamBookingUpdatesMethod = 
              io.grpc.MethodDescriptor.<bookingticket.BookingTicketProto.BookingUpdatesRequest, bookingticket.BookingTicketProto.BookingUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "MovieBookingService", "StreamBookingUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  bookingticket.BookingTicketProto.BookingUpdatesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  bookingticket.BookingTicketProto.BookingUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new MovieBookingServiceMethodDescriptorSupplier("StreamBookingUpdates"))
                  .build();
          }
        }
     }
     return getStreamBookingUpdatesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MovieBookingServiceStub newStub(io.grpc.Channel channel) {
    return new MovieBookingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MovieBookingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MovieBookingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MovieBookingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MovieBookingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class MovieBookingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void bookingTicket(bookingticket.BookingTicketProto.BookingRequest request,
        io.grpc.stub.StreamObserver<bookingticket.BookingTicketProto.BookingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getBookingTicketMethod(), responseObserver);
    }

    /**
     */
    public void cancelTicket(bookingticket.BookingTicketProto.CancelRequest request,
        io.grpc.stub.StreamObserver<bookingticket.BookingTicketProto.CancelResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelTicketMethod(), responseObserver);
    }

    /**
     */
    public void streamBookingUpdates(bookingticket.BookingTicketProto.BookingUpdatesRequest request,
        io.grpc.stub.StreamObserver<bookingticket.BookingTicketProto.BookingUpdate> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamBookingUpdatesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBookingTicketMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                bookingticket.BookingTicketProto.BookingRequest,
                bookingticket.BookingTicketProto.BookingResponse>(
                  this, METHODID_BOOKING_TICKET)))
          .addMethod(
            getCancelTicketMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                bookingticket.BookingTicketProto.CancelRequest,
                bookingticket.BookingTicketProto.CancelResponse>(
                  this, METHODID_CANCEL_TICKET)))
          .addMethod(
            getStreamBookingUpdatesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                bookingticket.BookingTicketProto.BookingUpdatesRequest,
                bookingticket.BookingTicketProto.BookingUpdate>(
                  this, METHODID_STREAM_BOOKING_UPDATES)))
          .build();
    }
  }

  /**
   */
  public static final class MovieBookingServiceStub extends io.grpc.stub.AbstractStub<MovieBookingServiceStub> {
    private MovieBookingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MovieBookingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieBookingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MovieBookingServiceStub(channel, callOptions);
    }

    /**
     */
    public void bookingTicket(bookingticket.BookingTicketProto.BookingRequest request,
        io.grpc.stub.StreamObserver<bookingticket.BookingTicketProto.BookingResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBookingTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelTicket(bookingticket.BookingTicketProto.CancelRequest request,
        io.grpc.stub.StreamObserver<bookingticket.BookingTicketProto.CancelResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamBookingUpdates(bookingticket.BookingTicketProto.BookingUpdatesRequest request,
        io.grpc.stub.StreamObserver<bookingticket.BookingTicketProto.BookingUpdate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamBookingUpdatesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MovieBookingServiceBlockingStub extends io.grpc.stub.AbstractStub<MovieBookingServiceBlockingStub> {
    private MovieBookingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MovieBookingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieBookingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MovieBookingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public bookingticket.BookingTicketProto.BookingResponse bookingTicket(bookingticket.BookingTicketProto.BookingRequest request) {
      return blockingUnaryCall(
          getChannel(), getBookingTicketMethod(), getCallOptions(), request);
    }

    /**
     */
    public bookingticket.BookingTicketProto.CancelResponse cancelTicket(bookingticket.BookingTicketProto.CancelRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelTicketMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<bookingticket.BookingTicketProto.BookingUpdate> streamBookingUpdates(
        bookingticket.BookingTicketProto.BookingUpdatesRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamBookingUpdatesMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MovieBookingServiceFutureStub extends io.grpc.stub.AbstractStub<MovieBookingServiceFutureStub> {
    private MovieBookingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MovieBookingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MovieBookingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MovieBookingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<bookingticket.BookingTicketProto.BookingResponse> bookingTicket(
        bookingticket.BookingTicketProto.BookingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBookingTicketMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<bookingticket.BookingTicketProto.CancelResponse> cancelTicket(
        bookingticket.BookingTicketProto.CancelRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelTicketMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BOOKING_TICKET = 0;
  private static final int METHODID_CANCEL_TICKET = 1;
  private static final int METHODID_STREAM_BOOKING_UPDATES = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MovieBookingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MovieBookingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BOOKING_TICKET:
          serviceImpl.bookingTicket((bookingticket.BookingTicketProto.BookingRequest) request,
              (io.grpc.stub.StreamObserver<bookingticket.BookingTicketProto.BookingResponse>) responseObserver);
          break;
        case METHODID_CANCEL_TICKET:
          serviceImpl.cancelTicket((bookingticket.BookingTicketProto.CancelRequest) request,
              (io.grpc.stub.StreamObserver<bookingticket.BookingTicketProto.CancelResponse>) responseObserver);
          break;
        case METHODID_STREAM_BOOKING_UPDATES:
          serviceImpl.streamBookingUpdates((bookingticket.BookingTicketProto.BookingUpdatesRequest) request,
              (io.grpc.stub.StreamObserver<bookingticket.BookingTicketProto.BookingUpdate>) responseObserver);
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

  private static abstract class MovieBookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MovieBookingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return bookingticket.BookingTicketProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MovieBookingService");
    }
  }

  private static final class MovieBookingServiceFileDescriptorSupplier
      extends MovieBookingServiceBaseDescriptorSupplier {
    MovieBookingServiceFileDescriptorSupplier() {}
  }

  private static final class MovieBookingServiceMethodDescriptorSupplier
      extends MovieBookingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MovieBookingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MovieBookingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MovieBookingServiceFileDescriptorSupplier())
              .addMethod(getBookingTicketMethod())
              .addMethod(getCancelTicketMethod())
              .addMethod(getStreamBookingUpdatesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
