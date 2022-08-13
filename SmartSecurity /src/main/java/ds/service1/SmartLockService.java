package ds.service1;

//On this class I created just the methods to run the services and I started the server in other class.

import ds.service1.SmartLockGrpc.SmartLockImplBase;
import io.grpc.stub.StreamObserver;



public class SmartLockService extends SmartLockImplBase {
	
	
	//Method to run the first RPC of the proto file, unary RPC
	@Override
	public void unlockDoors(UnlockRequest request, StreamObserver<UnlockResponse> responseObserver) {
		System.out.println("starting the server..." + "\n");

		String openDoors = request.getUnlockRequest();

		UnlockResponse.Builder response = UnlockResponse.newBuilder();// building the object to get the response.
		
		//A condition just to validate the entry of the password.
		if (openDoors.equals("myHome") ) {
			response.setUnlockAproval("Doors unlocked successfully");
		} else {

			response.setUnlockAproval("You entered the wrong access code, please try again");

		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	//Method to run the second RPC of the proto file, Client Streaming RPC
	@Override
	public StreamObserver<LockRequest> lockDoorsAndWindows(StreamObserver<LockResponsee> responseObserver) {

		return new StreamObserver<LockRequest>() {
			String lockConfirmation = "The door or windown number: ";
			
			@Override
			public void onNext(LockRequest lockId) {
				System.out.println("Getting ... " + lockId.getLockId());

				lockConfirmation += lockId.getLockId() + " is now locked! \n";
				System.out.println(lockConfirmation);
			}

			@Override
			public void onError(Throwable t) {
				

			}

			@Override
     		public void onCompleted() {
				LockResponsee respons = LockResponsee.newBuilder().setLockConfirmation(lockConfirmation).build();
				responseObserver.onNext(respons);
		        responseObserver.onCompleted();

		}

		};
	}	
	
	
	

}
