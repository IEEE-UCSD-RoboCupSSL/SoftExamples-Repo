package MyProto;

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
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: rpc.proto")
public final class exampleGrpc {

  private exampleGrpc() {}

  public static final String SERVICE_NAME = "example";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<MyProto.Rpc.greet,
      MyProto.Rpc.greet> getSayHiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sayHi",
      requestType = MyProto.Rpc.greet.class,
      responseType = MyProto.Rpc.greet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<MyProto.Rpc.greet,
      MyProto.Rpc.greet> getSayHiMethod() {
    io.grpc.MethodDescriptor<MyProto.Rpc.greet, MyProto.Rpc.greet> getSayHiMethod;
    if ((getSayHiMethod = exampleGrpc.getSayHiMethod) == null) {
      synchronized (exampleGrpc.class) {
        if ((getSayHiMethod = exampleGrpc.getSayHiMethod) == null) {
          exampleGrpc.getSayHiMethod = getSayHiMethod =
              io.grpc.MethodDescriptor.<MyProto.Rpc.greet, MyProto.Rpc.greet>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sayHi"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MyProto.Rpc.greet.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  MyProto.Rpc.greet.getDefaultInstance()))
              .setSchemaDescriptor(new exampleMethodDescriptorSupplier("sayHi"))
              .build();
        }
      }
    }
    return getSayHiMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static exampleStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<exampleStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<exampleStub>() {
        @java.lang.Override
        public exampleStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new exampleStub(channel, callOptions);
        }
      };
    return exampleStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static exampleBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<exampleBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<exampleBlockingStub>() {
        @java.lang.Override
        public exampleBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new exampleBlockingStub(channel, callOptions);
        }
      };
    return exampleBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static exampleFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<exampleFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<exampleFutureStub>() {
        @java.lang.Override
        public exampleFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new exampleFutureStub(channel, callOptions);
        }
      };
    return exampleFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class exampleImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHi(MyProto.Rpc.greet request,
        io.grpc.stub.StreamObserver<MyProto.Rpc.greet> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHiMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHiMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                MyProto.Rpc.greet,
                MyProto.Rpc.greet>(
                  this, METHODID_SAY_HI)))
          .build();
    }
  }

  /**
   */
  public static final class exampleStub extends io.grpc.stub.AbstractAsyncStub<exampleStub> {
    private exampleStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected exampleStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new exampleStub(channel, callOptions);
    }

    /**
     */
    public void sayHi(MyProto.Rpc.greet request,
        io.grpc.stub.StreamObserver<MyProto.Rpc.greet> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHiMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class exampleBlockingStub extends io.grpc.stub.AbstractBlockingStub<exampleBlockingStub> {
    private exampleBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected exampleBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new exampleBlockingStub(channel, callOptions);
    }

    /**
     */
    public MyProto.Rpc.greet sayHi(MyProto.Rpc.greet request) {
      return blockingUnaryCall(
          getChannel(), getSayHiMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class exampleFutureStub extends io.grpc.stub.AbstractFutureStub<exampleFutureStub> {
    private exampleFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected exampleFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new exampleFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<MyProto.Rpc.greet> sayHi(
        MyProto.Rpc.greet request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHiMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HI = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final exampleImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(exampleImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HI:
          serviceImpl.sayHi((MyProto.Rpc.greet) request,
              (io.grpc.stub.StreamObserver<MyProto.Rpc.greet>) responseObserver);
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

  private static abstract class exampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    exampleBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return MyProto.Rpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("example");
    }
  }

  private static final class exampleFileDescriptorSupplier
      extends exampleBaseDescriptorSupplier {
    exampleFileDescriptorSupplier() {}
  }

  private static final class exampleMethodDescriptorSupplier
      extends exampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    exampleMethodDescriptorSupplier(String methodName) {
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
      synchronized (exampleGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new exampleFileDescriptorSupplier())
              .addMethod(getSayHiMethod())
              .build();
        }
      }
    }
    return result;
  }
}
