package ds.service1;



import ds.service1.SmartLockGrpc.SmartLockImplBase;
import io.grpc.stub.StreamObserver;



public class SmartLockService extends SmartLockImplBase {
	
	@Override
	public void unlockDoors(UnlockRequest request, StreamObserver<UnlockResponse> responseObserver) {
		System.out.println("starting the server..." + "\n");

		String openDoors = request.getUnlockRequest();

		UnlockResponse.Builder response = UnlockResponse.newBuilder();

		if (openDoors.equals("myHome") ) {
			response.setUnlockAproval("Doors unlocked successfully");
		} else {

			response.setUnlockAproval("You entered the wrong access code, please try again");

		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

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
