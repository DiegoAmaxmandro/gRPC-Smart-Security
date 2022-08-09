package ds.service1;

//required java packages for the program. Depends on your logic.
import java.io.IOException;
import java.util.logging.Logger;

import com.google.protobuf.Empty;
import com.google.protobuf.Message;

import ds.service3.CCTVServiceGrpc.CCTVServiceImplBase;
//This is ImplBase class that was generated from the proto file.
//You need to change this location for your projects. NOTICE: The class is in StringsServiceGrpc.java -> StringsServiceImplBase class (this Base class is generated from proto file option java_outer_classname)
import grpc.examples.unarystrings.StringsServiceGrpc.StringsServiceImplBase;
//required grpc package for the server side
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class SmartLockServer extends CCTVServiceImplBase {

//First we create a logger to show server side logs in the console. logger instance will be used to log different events at the server console.
	private static final Logger logger = Logger.getLogger(SmartLockServer.class.getName());

//Main method would contain the logic to start the server.	For throws keyword refer https://www.javatpoint.com/throw-keyword
//NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
	 public static void main(String[] args) throws IOException, InterruptedException {
		    
		 // The StringServer is the current file name/ class name. Using an instance of this class different methods could be invoked by the client.
		 	SmartLockServer stringserver = new SmartLockServer();

		 	// This is the port number where server will be listening to clients. Refer - https://en.wikipedia.org/wiki/Port_(computer_networking) 
		    int port = 50055;
		    
		    // Here, we create a server on the port defined in in variable "port" and attach a service "stringserver" (instance of the class) defined above.
		    Server server = ServerBuilder.forPort(port) // Port is defined in line 34
		        .addService(stringserver) // Service is defined in line 31
		        .build() // Build the server
		        .start(); // Start the server and keep it running for clients to contact.
		    
		    // Giving a logging information on the server console that server has started
		    logger.info("Server started, listening on " + port);
		    		    
		    // Server will be running until externally terminated.
		    server.awaitTermination();
	 }
	
//These RPC methods have been defined in the proto files. The interface is already present in the ImplBase File.
//	NOTE - YOU MAY NEED TO MODIFY THIS LOGIC FOR YOUR PROJECTS BASED ON TYPE OF THE RPC METHODS 
//For override Refer - https://docs.oracle.com/javase/8/docs/api/java/lang/Override.html	 
	@Override  
	public void empty(Message request, StreamObserver<Empty> responseObserver) {
		System.out.println("empty message "+ request.getDetail());
			
		//will generate an error CANCELLED: HTTP/2 error code: CANCEL
		Empty reply = Empty.newBuilder().build();
		
		// sending an empty response. No value is there.
		responseObserver.onNext(reply); 
		
	//	StatusRuntimeException er = new StatusRuntimeException(Status.ABORTED);
	//	responseObserver.onError(er);
	  
		responseObserver.onCompleted();
	}


	// This is the second RPC method defined in proto file. It accepts an argument and return one.
	@Override
	public void reverse(StringRequest request, StreamObserver<StringResponse> responseObserver) {
		
		System.out.print("receiving revesre message ");
		
		// Retrieve the value from the request of the client
		StringBuilder stb = new StringBuilder(request.getVal());
		
		// LOGIC of THE METHOD 
		// NOTE: YOU MAY NEED TO MODIFY THIS LOGIC HERE.
		String output = stb.reverse().toString();
		
		// Preparing the reply for the client. Here, response is build and with the value (output) computed by above logic.  
		StringResponse reply = StringResponse.newBuilder().setVal(output).build();
		
		// Sending the reply for each request.
		responseObserver.onNext(reply);
		
		responseObserver.onCompleted();
	}


	
	
}
}