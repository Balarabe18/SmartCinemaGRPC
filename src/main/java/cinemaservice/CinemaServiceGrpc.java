package cinemaservice;

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
    comments = "Source: cinemaservice.proto")
public final class CinemaServiceGrpc {

  private CinemaServiceGrpc() {}

  public static final String SERVICE_NAME = "CinemaService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cinemaservice.CinemaServiceProto.ScheduleRequest,
      cinemaservice.CinemaServiceProto.ScheduleResponse> getScheduleMovieMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ScheduleMovie",
      requestType = cinemaservice.CinemaServiceProto.ScheduleRequest.class,
      responseType = cinemaservice.CinemaServiceProto.ScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cinemaservice.CinemaServiceProto.ScheduleRequest,
      cinemaservice.CinemaServiceProto.ScheduleResponse> getScheduleMovieMethod() {
    io.grpc.MethodDescriptor<cinemaservice.CinemaServiceProto.ScheduleRequest, cinemaservice.CinemaServiceProto.ScheduleResponse> getScheduleMovieMethod;
    if ((getScheduleMovieMethod = CinemaServiceGrpc.getScheduleMovieMethod) == null) {
      synchronized (CinemaServiceGrpc.class) {
        if ((getScheduleMovieMethod = CinemaServiceGrpc.getScheduleMovieMethod) == null) {
          CinemaServiceGrpc.getScheduleMovieMethod = getScheduleMovieMethod = 
              io.grpc.MethodDescriptor.<cinemaservice.CinemaServiceProto.ScheduleRequest, cinemaservice.CinemaServiceProto.ScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CinemaService", "ScheduleMovie"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cinemaservice.CinemaServiceProto.ScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cinemaservice.CinemaServiceProto.ScheduleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CinemaServiceMethodDescriptorSupplier("ScheduleMovie"))
                  .build();
          }
        }
     }
     return getScheduleMovieMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cinemaservice.CinemaServiceProto.UpdateScheduleRequest,
      cinemaservice.CinemaServiceProto.UpdateScheduleResponse> getUpdateScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSchedule",
      requestType = cinemaservice.CinemaServiceProto.UpdateScheduleRequest.class,
      responseType = cinemaservice.CinemaServiceProto.UpdateScheduleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cinemaservice.CinemaServiceProto.UpdateScheduleRequest,
      cinemaservice.CinemaServiceProto.UpdateScheduleResponse> getUpdateScheduleMethod() {
    io.grpc.MethodDescriptor<cinemaservice.CinemaServiceProto.UpdateScheduleRequest, cinemaservice.CinemaServiceProto.UpdateScheduleResponse> getUpdateScheduleMethod;
    if ((getUpdateScheduleMethod = CinemaServiceGrpc.getUpdateScheduleMethod) == null) {
      synchronized (CinemaServiceGrpc.class) {
        if ((getUpdateScheduleMethod = CinemaServiceGrpc.getUpdateScheduleMethod) == null) {
          CinemaServiceGrpc.getUpdateScheduleMethod = getUpdateScheduleMethod = 
              io.grpc.MethodDescriptor.<cinemaservice.CinemaServiceProto.UpdateScheduleRequest, cinemaservice.CinemaServiceProto.UpdateScheduleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CinemaService", "UpdateSchedule"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cinemaservice.CinemaServiceProto.UpdateScheduleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cinemaservice.CinemaServiceProto.UpdateScheduleResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CinemaServiceMethodDescriptorSupplier("UpdateSchedule"))
                  .build();
          }
        }
     }
     return getUpdateScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cinemaservice.CinemaServiceProto.CinemaStatusRequest,
      cinemaservice.CinemaServiceProto.CinemaStatus> getStreamCinemaStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamCinemaStatus",
      requestType = cinemaservice.CinemaServiceProto.CinemaStatusRequest.class,
      responseType = cinemaservice.CinemaServiceProto.CinemaStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cinemaservice.CinemaServiceProto.CinemaStatusRequest,
      cinemaservice.CinemaServiceProto.CinemaStatus> getStreamCinemaStatusMethod() {
    io.grpc.MethodDescriptor<cinemaservice.CinemaServiceProto.CinemaStatusRequest, cinemaservice.CinemaServiceProto.CinemaStatus> getStreamCinemaStatusMethod;
    if ((getStreamCinemaStatusMethod = CinemaServiceGrpc.getStreamCinemaStatusMethod) == null) {
      synchronized (CinemaServiceGrpc.class) {
        if ((getStreamCinemaStatusMethod = CinemaServiceGrpc.getStreamCinemaStatusMethod) == null) {
          CinemaServiceGrpc.getStreamCinemaStatusMethod = getStreamCinemaStatusMethod = 
              io.grpc.MethodDescriptor.<cinemaservice.CinemaServiceProto.CinemaStatusRequest, cinemaservice.CinemaServiceProto.CinemaStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "CinemaService", "StreamCinemaStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cinemaservice.CinemaServiceProto.CinemaStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cinemaservice.CinemaServiceProto.CinemaStatus.getDefaultInstance()))
                  .setSchemaDescriptor(new CinemaServiceMethodDescriptorSupplier("StreamCinemaStatus"))
                  .build();
          }
        }
     }
     return getStreamCinemaStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CinemaServiceStub newStub(io.grpc.Channel channel) {
    return new CinemaServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CinemaServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CinemaServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CinemaServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CinemaServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CinemaServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void scheduleMovie(cinemaservice.CinemaServiceProto.ScheduleRequest request,
        io.grpc.stub.StreamObserver<cinemaservice.CinemaServiceProto.ScheduleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getScheduleMovieMethod(), responseObserver);
    }

    /**
     */
    public void updateSchedule(cinemaservice.CinemaServiceProto.UpdateScheduleRequest request,
        io.grpc.stub.StreamObserver<cinemaservice.CinemaServiceProto.UpdateScheduleResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateScheduleMethod(), responseObserver);
    }

    /**
     */
    public void streamCinemaStatus(cinemaservice.CinemaServiceProto.CinemaStatusRequest request,
        io.grpc.stub.StreamObserver<cinemaservice.CinemaServiceProto.CinemaStatus> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamCinemaStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getScheduleMovieMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cinemaservice.CinemaServiceProto.ScheduleRequest,
                cinemaservice.CinemaServiceProto.ScheduleResponse>(
                  this, METHODID_SCHEDULE_MOVIE)))
          .addMethod(
            getUpdateScheduleMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                cinemaservice.CinemaServiceProto.UpdateScheduleRequest,
                cinemaservice.CinemaServiceProto.UpdateScheduleResponse>(
                  this, METHODID_UPDATE_SCHEDULE)))
          .addMethod(
            getStreamCinemaStatusMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                cinemaservice.CinemaServiceProto.CinemaStatusRequest,
                cinemaservice.CinemaServiceProto.CinemaStatus>(
                  this, METHODID_STREAM_CINEMA_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class CinemaServiceStub extends io.grpc.stub.AbstractStub<CinemaServiceStub> {
    private CinemaServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaServiceStub(channel, callOptions);
    }

    /**
     */
    public void scheduleMovie(cinemaservice.CinemaServiceProto.ScheduleRequest request,
        io.grpc.stub.StreamObserver<cinemaservice.CinemaServiceProto.ScheduleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getScheduleMovieMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateSchedule(cinemaservice.CinemaServiceProto.UpdateScheduleRequest request,
        io.grpc.stub.StreamObserver<cinemaservice.CinemaServiceProto.UpdateScheduleResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateScheduleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamCinemaStatus(cinemaservice.CinemaServiceProto.CinemaStatusRequest request,
        io.grpc.stub.StreamObserver<cinemaservice.CinemaServiceProto.CinemaStatus> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamCinemaStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CinemaServiceBlockingStub extends io.grpc.stub.AbstractStub<CinemaServiceBlockingStub> {
    private CinemaServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public cinemaservice.CinemaServiceProto.ScheduleResponse scheduleMovie(cinemaservice.CinemaServiceProto.ScheduleRequest request) {
      return blockingUnaryCall(
          getChannel(), getScheduleMovieMethod(), getCallOptions(), request);
    }

    /**
     */
    public cinemaservice.CinemaServiceProto.UpdateScheduleResponse updateSchedule(cinemaservice.CinemaServiceProto.UpdateScheduleRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateScheduleMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<cinemaservice.CinemaServiceProto.CinemaStatus> streamCinemaStatus(
        cinemaservice.CinemaServiceProto.CinemaStatusRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamCinemaStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CinemaServiceFutureStub extends io.grpc.stub.AbstractStub<CinemaServiceFutureStub> {
    private CinemaServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CinemaServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CinemaServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CinemaServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cinemaservice.CinemaServiceProto.ScheduleResponse> scheduleMovie(
        cinemaservice.CinemaServiceProto.ScheduleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getScheduleMovieMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cinemaservice.CinemaServiceProto.UpdateScheduleResponse> updateSchedule(
        cinemaservice.CinemaServiceProto.UpdateScheduleRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateScheduleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SCHEDULE_MOVIE = 0;
  private static final int METHODID_UPDATE_SCHEDULE = 1;
  private static final int METHODID_STREAM_CINEMA_STATUS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CinemaServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CinemaServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SCHEDULE_MOVIE:
          serviceImpl.scheduleMovie((cinemaservice.CinemaServiceProto.ScheduleRequest) request,
              (io.grpc.stub.StreamObserver<cinemaservice.CinemaServiceProto.ScheduleResponse>) responseObserver);
          break;
        case METHODID_UPDATE_SCHEDULE:
          serviceImpl.updateSchedule((cinemaservice.CinemaServiceProto.UpdateScheduleRequest) request,
              (io.grpc.stub.StreamObserver<cinemaservice.CinemaServiceProto.UpdateScheduleResponse>) responseObserver);
          break;
        case METHODID_STREAM_CINEMA_STATUS:
          serviceImpl.streamCinemaStatus((cinemaservice.CinemaServiceProto.CinemaStatusRequest) request,
              (io.grpc.stub.StreamObserver<cinemaservice.CinemaServiceProto.CinemaStatus>) responseObserver);
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

  private static abstract class CinemaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CinemaServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cinemaservice.CinemaServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CinemaService");
    }
  }

  private static final class CinemaServiceFileDescriptorSupplier
      extends CinemaServiceBaseDescriptorSupplier {
    CinemaServiceFileDescriptorSupplier() {}
  }

  private static final class CinemaServiceMethodDescriptorSupplier
      extends CinemaServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CinemaServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CinemaServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CinemaServiceFileDescriptorSupplier())
              .addMethod(getScheduleMovieMethod())
              .addMethod(getUpdateScheduleMethod())
              .addMethod(getStreamCinemaStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
