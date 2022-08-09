package ds.service2;

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
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: IntruderAlarmService.proto")
public final class IntruderAlarmGrpc {

  private IntruderAlarmGrpc() {}

  public static final String SERVICE_NAME = "IntruderAlarm.IntruderAlarm";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service2.AlertRequest,
      ds.service2.AlertResponse> getIntruderAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IntruderAlert",
      requestType = ds.service2.AlertRequest.class,
      responseType = ds.service2.AlertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.service2.AlertRequest,
      ds.service2.AlertResponse> getIntruderAlertMethod() {
    io.grpc.MethodDescriptor<ds.service2.AlertRequest, ds.service2.AlertResponse> getIntruderAlertMethod;
    if ((getIntruderAlertMethod = IntruderAlarmGrpc.getIntruderAlertMethod) == null) {
      synchronized (IntruderAlarmGrpc.class) {
        if ((getIntruderAlertMethod = IntruderAlarmGrpc.getIntruderAlertMethod) == null) {
          IntruderAlarmGrpc.getIntruderAlertMethod = getIntruderAlertMethod = 
              io.grpc.MethodDescriptor.<ds.service2.AlertRequest, ds.service2.AlertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "IntruderAlarm.IntruderAlarm", "IntruderAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.AlertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.AlertResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new IntruderAlarmMethodDescriptorSupplier("IntruderAlert"))
                  .build();
          }
        }
     }
     return getIntruderAlertMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service2.LightRequest,
      ds.service2.LightResponse> getLightOnAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LightOnAlert",
      requestType = ds.service2.LightRequest.class,
      responseType = ds.service2.LightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service2.LightRequest,
      ds.service2.LightResponse> getLightOnAlertMethod() {
    io.grpc.MethodDescriptor<ds.service2.LightRequest, ds.service2.LightResponse> getLightOnAlertMethod;
    if ((getLightOnAlertMethod = IntruderAlarmGrpc.getLightOnAlertMethod) == null) {
      synchronized (IntruderAlarmGrpc.class) {
        if ((getLightOnAlertMethod = IntruderAlarmGrpc.getLightOnAlertMethod) == null) {
          IntruderAlarmGrpc.getLightOnAlertMethod = getLightOnAlertMethod = 
              io.grpc.MethodDescriptor.<ds.service2.LightRequest, ds.service2.LightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "IntruderAlarm.IntruderAlarm", "LightOnAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.LightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service2.LightResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new IntruderAlarmMethodDescriptorSupplier("LightOnAlert"))
                  .build();
          }
        }
     }
     return getLightOnAlertMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static IntruderAlarmStub newStub(io.grpc.Channel channel) {
    return new IntruderAlarmStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IntruderAlarmBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new IntruderAlarmBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static IntruderAlarmFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new IntruderAlarmFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class IntruderAlarmImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Unary RPC
     * </pre>
     */
    public void intruderAlert(ds.service2.AlertRequest request,
        io.grpc.stub.StreamObserver<ds.service2.AlertResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getIntruderAlertMethod(), responseObserver);
    }

    /**
     * <pre>
     *Server Stream RPC
     * </pre>
     */
    public void lightOnAlert(ds.service2.LightRequest request,
        io.grpc.stub.StreamObserver<ds.service2.LightResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLightOnAlertMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getIntruderAlertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.service2.AlertRequest,
                ds.service2.AlertResponse>(
                  this, METHODID_INTRUDER_ALERT)))
          .addMethod(
            getLightOnAlertMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                ds.service2.LightRequest,
                ds.service2.LightResponse>(
                  this, METHODID_LIGHT_ON_ALERT)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class IntruderAlarmStub extends io.grpc.stub.AbstractStub<IntruderAlarmStub> {
    private IntruderAlarmStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IntruderAlarmStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntruderAlarmStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IntruderAlarmStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary RPC
     * </pre>
     */
    public void intruderAlert(ds.service2.AlertRequest request,
        io.grpc.stub.StreamObserver<ds.service2.AlertResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getIntruderAlertMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Server Stream RPC
     * </pre>
     */
    public void lightOnAlert(ds.service2.LightRequest request,
        io.grpc.stub.StreamObserver<ds.service2.LightResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLightOnAlertMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class IntruderAlarmBlockingStub extends io.grpc.stub.AbstractStub<IntruderAlarmBlockingStub> {
    private IntruderAlarmBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IntruderAlarmBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntruderAlarmBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IntruderAlarmBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary RPC
     * </pre>
     */
    public ds.service2.AlertResponse intruderAlert(ds.service2.AlertRequest request) {
      return blockingUnaryCall(
          getChannel(), getIntruderAlertMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Server Stream RPC
     * </pre>
     */
    public java.util.Iterator<ds.service2.LightResponse> lightOnAlert(
        ds.service2.LightRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getLightOnAlertMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class IntruderAlarmFutureStub extends io.grpc.stub.AbstractStub<IntruderAlarmFutureStub> {
    private IntruderAlarmFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private IntruderAlarmFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IntruderAlarmFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new IntruderAlarmFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.service2.AlertResponse> intruderAlert(
        ds.service2.AlertRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getIntruderAlertMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_INTRUDER_ALERT = 0;
  private static final int METHODID_LIGHT_ON_ALERT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final IntruderAlarmImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(IntruderAlarmImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INTRUDER_ALERT:
          serviceImpl.intruderAlert((ds.service2.AlertRequest) request,
              (io.grpc.stub.StreamObserver<ds.service2.AlertResponse>) responseObserver);
          break;
        case METHODID_LIGHT_ON_ALERT:
          serviceImpl.lightOnAlert((ds.service2.LightRequest) request,
              (io.grpc.stub.StreamObserver<ds.service2.LightResponse>) responseObserver);
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

  private static abstract class IntruderAlarmBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IntruderAlarmBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service2.IntruderAlarmServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IntruderAlarm");
    }
  }

  private static final class IntruderAlarmFileDescriptorSupplier
      extends IntruderAlarmBaseDescriptorSupplier {
    IntruderAlarmFileDescriptorSupplier() {}
  }

  private static final class IntruderAlarmMethodDescriptorSupplier
      extends IntruderAlarmBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    IntruderAlarmMethodDescriptorSupplier(String methodName) {
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
      synchronized (IntruderAlarmGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new IntruderAlarmFileDescriptorSupplier())
              .addMethod(getIntruderAlertMethod())
              .addMethod(getLightOnAlertMethod())
              .build();
        }
      }
    }
    return result;
  }
}
