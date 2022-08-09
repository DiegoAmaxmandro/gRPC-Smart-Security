package ds.service1;

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
    comments = "Source: SmartLockService.proto")
public final class SmartLockGrpc {

  private SmartLockGrpc() {}

  public static final String SERVICE_NAME = "SmartLock.SmartLock";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service1.UnlockRequest,
      ds.service1.UnlockResponse> getUnlockDoorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UnlockDoors",
      requestType = ds.service1.UnlockRequest.class,
      responseType = ds.service1.UnlockResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.service1.UnlockRequest,
      ds.service1.UnlockResponse> getUnlockDoorsMethod() {
    io.grpc.MethodDescriptor<ds.service1.UnlockRequest, ds.service1.UnlockResponse> getUnlockDoorsMethod;
    if ((getUnlockDoorsMethod = SmartLockGrpc.getUnlockDoorsMethod) == null) {
      synchronized (SmartLockGrpc.class) {
        if ((getUnlockDoorsMethod = SmartLockGrpc.getUnlockDoorsMethod) == null) {
          SmartLockGrpc.getUnlockDoorsMethod = getUnlockDoorsMethod = 
              io.grpc.MethodDescriptor.<ds.service1.UnlockRequest, ds.service1.UnlockResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "SmartLock.SmartLock", "UnlockDoors"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.UnlockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.UnlockResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartLockMethodDescriptorSupplier("UnlockDoors"))
                  .build();
          }
        }
     }
     return getUnlockDoorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service1.LockRequest,
      ds.service1.LockResponsee> getLockDoorsAndWindowsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lockDoorsAndWindows",
      requestType = ds.service1.LockRequest.class,
      responseType = ds.service1.LockResponsee.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service1.LockRequest,
      ds.service1.LockResponsee> getLockDoorsAndWindowsMethod() {
    io.grpc.MethodDescriptor<ds.service1.LockRequest, ds.service1.LockResponsee> getLockDoorsAndWindowsMethod;
    if ((getLockDoorsAndWindowsMethod = SmartLockGrpc.getLockDoorsAndWindowsMethod) == null) {
      synchronized (SmartLockGrpc.class) {
        if ((getLockDoorsAndWindowsMethod = SmartLockGrpc.getLockDoorsAndWindowsMethod) == null) {
          SmartLockGrpc.getLockDoorsAndWindowsMethod = getLockDoorsAndWindowsMethod = 
              io.grpc.MethodDescriptor.<ds.service1.LockRequest, ds.service1.LockResponsee>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "SmartLock.SmartLock", "lockDoorsAndWindows"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.LockRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service1.LockResponsee.getDefaultInstance()))
                  .setSchemaDescriptor(new SmartLockMethodDescriptorSupplier("lockDoorsAndWindows"))
                  .build();
          }
        }
     }
     return getLockDoorsAndWindowsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SmartLockStub newStub(io.grpc.Channel channel) {
    return new SmartLockStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SmartLockBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SmartLockBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SmartLockFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SmartLockFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class SmartLockImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Unary RPC
     * </pre>
     */
    public void unlockDoors(ds.service1.UnlockRequest request,
        io.grpc.stub.StreamObserver<ds.service1.UnlockResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUnlockDoorsMethod(), responseObserver);
    }

    /**
     * <pre>
     *Client Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service1.LockRequest> lockDoorsAndWindows(
        io.grpc.stub.StreamObserver<ds.service1.LockResponsee> responseObserver) {
      return asyncUnimplementedStreamingCall(getLockDoorsAndWindowsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUnlockDoorsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.service1.UnlockRequest,
                ds.service1.UnlockResponse>(
                  this, METHODID_UNLOCK_DOORS)))
          .addMethod(
            getLockDoorsAndWindowsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.service1.LockRequest,
                ds.service1.LockResponsee>(
                  this, METHODID_LOCK_DOORS_AND_WINDOWS)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartLockStub extends io.grpc.stub.AbstractStub<SmartLockStub> {
    private SmartLockStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartLockStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartLockStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartLockStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary RPC
     * </pre>
     */
    public void unlockDoors(ds.service1.UnlockRequest request,
        io.grpc.stub.StreamObserver<ds.service1.UnlockResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUnlockDoorsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Client Streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service1.LockRequest> lockDoorsAndWindows(
        io.grpc.stub.StreamObserver<ds.service1.LockResponsee> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getLockDoorsAndWindowsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartLockBlockingStub extends io.grpc.stub.AbstractStub<SmartLockBlockingStub> {
    private SmartLockBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartLockBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartLockBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartLockBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary RPC
     * </pre>
     */
    public ds.service1.UnlockResponse unlockDoors(ds.service1.UnlockRequest request) {
      return blockingUnaryCall(
          getChannel(), getUnlockDoorsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SmartLockFutureStub extends io.grpc.stub.AbstractStub<SmartLockFutureStub> {
    private SmartLockFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SmartLockFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SmartLockFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SmartLockFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary RPC
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.service1.UnlockResponse> unlockDoors(
        ds.service1.UnlockRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUnlockDoorsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UNLOCK_DOORS = 0;
  private static final int METHODID_LOCK_DOORS_AND_WINDOWS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SmartLockImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SmartLockImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UNLOCK_DOORS:
          serviceImpl.unlockDoors((ds.service1.UnlockRequest) request,
              (io.grpc.stub.StreamObserver<ds.service1.UnlockResponse>) responseObserver);
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
        case METHODID_LOCK_DOORS_AND_WINDOWS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.lockDoorsAndWindows(
              (io.grpc.stub.StreamObserver<ds.service1.LockResponsee>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SmartLockBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SmartLockBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service1.SmartLockServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SmartLock");
    }
  }

  private static final class SmartLockFileDescriptorSupplier
      extends SmartLockBaseDescriptorSupplier {
    SmartLockFileDescriptorSupplier() {}
  }

  private static final class SmartLockMethodDescriptorSupplier
      extends SmartLockBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SmartLockMethodDescriptorSupplier(String methodName) {
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
      synchronized (SmartLockGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SmartLockFileDescriptorSupplier())
              .addMethod(getUnlockDoorsMethod())
              .addMethod(getLockDoorsAndWindowsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
