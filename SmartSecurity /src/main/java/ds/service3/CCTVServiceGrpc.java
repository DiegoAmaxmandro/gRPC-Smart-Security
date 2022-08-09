package ds.service3;

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
    comments = "Source: CCTVService.proto")
public final class CCTVServiceGrpc {

  private CCTVServiceGrpc() {}

  public static final String SERVICE_NAME = "CCTVService.CCTVService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.service3.ImagesRequest,
      ds.service3.ImagesResponse> getCamerasViewingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CamerasViewing",
      requestType = ds.service3.ImagesRequest.class,
      responseType = ds.service3.ImagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.service3.ImagesRequest,
      ds.service3.ImagesResponse> getCamerasViewingMethod() {
    io.grpc.MethodDescriptor<ds.service3.ImagesRequest, ds.service3.ImagesResponse> getCamerasViewingMethod;
    if ((getCamerasViewingMethod = CCTVServiceGrpc.getCamerasViewingMethod) == null) {
      synchronized (CCTVServiceGrpc.class) {
        if ((getCamerasViewingMethod = CCTVServiceGrpc.getCamerasViewingMethod) == null) {
          CCTVServiceGrpc.getCamerasViewingMethod = getCamerasViewingMethod = 
              io.grpc.MethodDescriptor.<ds.service3.ImagesRequest, ds.service3.ImagesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "CCTVService.CCTVService", "CamerasViewing"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.ImagesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.ImagesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CCTVServiceMethodDescriptorSupplier("CamerasViewing"))
                  .build();
          }
        }
     }
     return getCamerasViewingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.service3.PetAlertRequest,
      ds.service3.PetAlertResponse> getPetAlertMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PetAlert",
      requestType = ds.service3.PetAlertRequest.class,
      responseType = ds.service3.PetAlertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ds.service3.PetAlertRequest,
      ds.service3.PetAlertResponse> getPetAlertMethod() {
    io.grpc.MethodDescriptor<ds.service3.PetAlertRequest, ds.service3.PetAlertResponse> getPetAlertMethod;
    if ((getPetAlertMethod = CCTVServiceGrpc.getPetAlertMethod) == null) {
      synchronized (CCTVServiceGrpc.class) {
        if ((getPetAlertMethod = CCTVServiceGrpc.getPetAlertMethod) == null) {
          CCTVServiceGrpc.getPetAlertMethod = getPetAlertMethod = 
              io.grpc.MethodDescriptor.<ds.service3.PetAlertRequest, ds.service3.PetAlertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "CCTVService.CCTVService", "PetAlert"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.PetAlertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.service3.PetAlertResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new CCTVServiceMethodDescriptorSupplier("PetAlert"))
                  .build();
          }
        }
     }
     return getPetAlertMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CCTVServiceStub newStub(io.grpc.Channel channel) {
    return new CCTVServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CCTVServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CCTVServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CCTVServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CCTVServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CCTVServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Bidirectional streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service3.ImagesRequest> camerasViewing(
        io.grpc.stub.StreamObserver<ds.service3.ImagesResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getCamerasViewingMethod(), responseObserver);
    }

    /**
     * <pre>
     *Unary RCP
     * </pre>
     */
    public void petAlert(ds.service3.PetAlertRequest request,
        io.grpc.stub.StreamObserver<ds.service3.PetAlertResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getPetAlertMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCamerasViewingMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.service3.ImagesRequest,
                ds.service3.ImagesResponse>(
                  this, METHODID_CAMERAS_VIEWING)))
          .addMethod(
            getPetAlertMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ds.service3.PetAlertRequest,
                ds.service3.PetAlertResponse>(
                  this, METHODID_PET_ALERT)))
          .build();
    }
  }

  /**
   */
  public static final class CCTVServiceStub extends io.grpc.stub.AbstractStub<CCTVServiceStub> {
    private CCTVServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CCTVServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CCTVServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CCTVServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *Bidirectional streaming RPC
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.service3.ImagesRequest> camerasViewing(
        io.grpc.stub.StreamObserver<ds.service3.ImagesResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getCamerasViewingMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *Unary RCP
     * </pre>
     */
    public void petAlert(ds.service3.PetAlertRequest request,
        io.grpc.stub.StreamObserver<ds.service3.PetAlertResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getPetAlertMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CCTVServiceBlockingStub extends io.grpc.stub.AbstractStub<CCTVServiceBlockingStub> {
    private CCTVServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CCTVServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CCTVServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CCTVServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary RCP
     * </pre>
     */
    public ds.service3.PetAlertResponse petAlert(ds.service3.PetAlertRequest request) {
      return blockingUnaryCall(
          getChannel(), getPetAlertMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CCTVServiceFutureStub extends io.grpc.stub.AbstractStub<CCTVServiceFutureStub> {
    private CCTVServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CCTVServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CCTVServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CCTVServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Unary RCP
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ds.service3.PetAlertResponse> petAlert(
        ds.service3.PetAlertRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getPetAlertMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PET_ALERT = 0;
  private static final int METHODID_CAMERAS_VIEWING = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CCTVServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CCTVServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PET_ALERT:
          serviceImpl.petAlert((ds.service3.PetAlertRequest) request,
              (io.grpc.stub.StreamObserver<ds.service3.PetAlertResponse>) responseObserver);
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
        case METHODID_CAMERAS_VIEWING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.camerasViewing(
              (io.grpc.stub.StreamObserver<ds.service3.ImagesResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CCTVServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CCTVServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.service3.CCTVServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CCTVService");
    }
  }

  private static final class CCTVServiceFileDescriptorSupplier
      extends CCTVServiceBaseDescriptorSupplier {
    CCTVServiceFileDescriptorSupplier() {}
  }

  private static final class CCTVServiceMethodDescriptorSupplier
      extends CCTVServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CCTVServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CCTVServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CCTVServiceFileDescriptorSupplier())
              .addMethod(getCamerasViewingMethod())
              .addMethod(getPetAlertMethod())
              .build();
        }
      }
    }
    return result;
  }
}
