package ds.service1;


import java.util.Random;
import ds.service1.SmartLockGrpc.SmartLockBlockingStub;
import ds.service1.SmartLockGrpc.SmartLockStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;



public class SmartLockClient {
	
	public static SmartLockStub asyncStub;
	
	public static void main(String[] args) {
		
		
		ManagedChannel chanel = ManagedChannelBuilder.forAddress("localhost", 5556).usePlaintext().build();
		
		SmartLockBlockingStub SmartLocStub =  SmartLockGrpc.newBlockingStub(chanel);
		
		
		UnlockRequest Unlockrequest = UnlockRequest.newBuilder().setUnlockRequest("myHome").build();
		
		asyncStub = SmartLockGrpc.newStub(chanel);
		UnlockResponse response = SmartLocStub.unlockDoors(Unlockrequest);
		
		System.out.println("************* METHOD 1 *********");
		System.out.println(response.getUnlockAproval());
		System.out.println();//just to get space between lines
		
		System.out.println("************* METHOD 2 *********");
		lockId();
		
		
		chanel.shutdown();
		
	}
	
	public static void lockId() {
		
		
		StreamObserver<LockResponsee> responseObserver = new StreamObserver<LockResponsee>() {
			
			
			@Override
			public void onNext(LockResponsee lockId) {
				System.out.println("Getting ... " + lockId.getLockConfirmation());
				
			}

			@Override
			public void onError(Throwable t) {
				
				
			}

			@Override
			public void onCompleted() {
				System.out.println("Completed .....");
				
			}

			
			
		};
		
	
		
		StreamObserver<LockRequest> requestObserver = asyncStub.lockDoorsAndWindows(responseObserver);
			
			
			
		try {
			
			
			requestObserver.onNext(LockRequest.newBuilder().setLockId(1).build());
			requestObserver.onNext(LockRequest.newBuilder().setLockId(2).build());
			requestObserver.onNext(LockRequest.newBuilder().setLockId(3).build());
			requestObserver.onNext(LockRequest.newBuilder().setLockId(4).build());
			

			System.out.println("Sending request to close doors and windows...");

			
			requestObserver.onCompleted();


			
			Thread.sleep(new Random().nextInt(5000) + 800);
			

		} catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
	}

}
