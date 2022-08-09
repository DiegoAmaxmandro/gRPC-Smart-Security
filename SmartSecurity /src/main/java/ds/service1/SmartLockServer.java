package ds.service1;

//required java packages for the program. Depends on your logic.
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Logger;

import ds.service1.SmartLockGrpc.SmartLockImplBase;

//required grpc package for the server side
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

//This is ImplBase class that was generated from the proto file.
//You need to change this location for your projects. NOTICE: The class is in StringsServiceGrpc.java -> StringsServiceImplBase class (this Base class is generated from proto file option java_outer_classname)

//Extend the ImplBase imported class here. It is an Interface file with required rpc methods
public class SmartLockServer extends SmartLockImplBase {

	// First we create a logger to show server side logs in the console. logger
	// instance will be used to log different events at the server console.
	private static final Logger logger = Logger.getLogger(SmartLockServer.class.getName());

	// Main method would contain the logic to start the server. For throws keyword
	// refer https://www.javatpoint.com/throw-keyword
	// NOTE: THIS LOGIC WILL BE SAME FOR ALL THE TYPES OF SERVICES
	public static void main(String[] args) throws IOException, InterruptedException {

		// The StringServer is the current file name/ class name. Using an instance of
		// this class different methods could be invoked by the client.
		SmartLockServer smartLockserver = new SmartLockServer();

		// This is the port number where server will be listening to clients. Refer -
		// https://en.wikipedia.org/wiki/Port_(computer_networking)
		int port = 50060;

		// Here, we create a server on the port defined in in variable "port" and attach
		// a service "stringserver" (instance of the class) defined above.
		Server server = ServerBuilder.forPort(port) // Port is defined in line 34
				.addService(smartLockserver) // Service is defined in line 31
				.build() // Build the server
				.start(); // Start the server and keep it running for clients to contact.

		// Giving a logging information on the server console that server has started
		logger.info("Server started, listening on " + port);

		// Server will be running until externally terminated.
		server.awaitTermination();
	}

	@Override
	public void unlockDoors(UnlockRequest request, StreamObserver<UnlockResponse> responseObserver) {
		System.out.println("starting the server..." + "\n");

		String openDoors = request.getUnlockRequest();

		UnlockResponse.Builder response = UnlockResponse.newBuilder();

		if (openDoors == "myHome") {
			response.setUnlockAproval("Doors unlocked successfully");
		} else {

			response.setUnlockAproval("You entered the wrong access code, please try again");

		}

		responseObserver.onNext(response.build());
		// responseObserver.onError(response.build());
		responseObserver.onCompleted();
	}

	@Override
     public StreamObserver<LockRequest> lockDoorsAndWindows(StreamObserver<LockResponsee> responseObserver) {
		

		return new StreamObserver<LockRequest>() {
			
			String lockConfirmation = "";
			
			public void onNext(LockRequest lockId) {
				System.out.println("Getting ... " + lockId.getLockId());
				
				
				lockConfirmation = "The object number " + lockId.getLockId() + "is now locked!";
				System.out.println(lockConfirmation);
			}
			
			

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

		@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}



		};
	}
			
	
}
		
		

