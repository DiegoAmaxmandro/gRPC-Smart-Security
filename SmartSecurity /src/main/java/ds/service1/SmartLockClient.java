package ds.service1;



import java.util.Random;
import javax.jmdns.ServiceInfo;
import ds.service1.SmartLockGrpc.SmartLockBlockingStub;
import ds.service1.SmartLockGrpc.SmartLockStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import jmDNS_Service.DiscoveryService;

public class SmartLockClient {

	public static SmartLockStub asyncStub;
	private static ServiceInfo info;
	public static void main(String[] args) throws InterruptedException {
		
	
	String service_type = "_SmartLock._tcp.local.";
	setInfo(DiscoveryService.discoverService(service_type));
	
	
	ManagedChannel chanel = ManagedChannelBuilder.forAddress("localhost", 55566).usePlaintext().build();
	

	SmartLockBlockingStub SmartLocStub = SmartLockGrpc.newBlockingStub(chanel);

	UnlockRequest Unlockrequest = UnlockRequest.newBuilder().setUnlockRequest("myHome").build();

	asyncStub=SmartLockGrpc.newStub(chanel);
	UnlockResponse response = SmartLocStub.unlockDoors(Unlockrequest);

	System.out.println("************* METHOD 1 *********");System.out.println(response.getUnlockAproval());System.out.println();// just
																																// to
																																// get
																																// space
																																// between
																																// lines

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

	public static ServiceInfo getInfo() {
		return info;
	}

	public static void setInfo(ServiceInfo info) {
		SmartLockClient.info = info;
	}

	

}
