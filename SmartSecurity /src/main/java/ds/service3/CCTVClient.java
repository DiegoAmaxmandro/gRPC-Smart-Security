package ds.service3;


import java.util.Random;
import ds.service3.CCTVServiceGrpc.CCTVServiceBlockingStub;
import ds.service3.CCTVServiceGrpc.CCTVServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class CCTVClient {
	public static CCTVServiceStub asyncStub;
	
	public static void main(String[] args) {
		
		ManagedChannel chanel = ManagedChannelBuilder.forAddress("localhost", 5559).usePlaintext().build();
		
		CCTVServiceBlockingStub CCTVLocStub =  CCTVServiceGrpc.newBlockingStub(chanel);
		
		PetAlertRequest PetAlertRequest = ds.service3.PetAlertRequest.newBuilder().setPetAlert("Pet detected").build();
		
		PetAlertResponse response =  CCTVLocStub.petAlert(PetAlertRequest);
		
		System.out.println("************* METHOD 1 *********");
		System.out.println(response.getAlarmsOff());
		System.out.println();//just to get space between lines
		
		
		asyncStub = CCTVServiceGrpc.newStub(chanel);
		
		cctvViewing();
		
		
		
		chanel.shutdown();
	}
	
	public static void cctvViewing() {
		
		StreamObserver<ImagesResponse> responserObserver = new StreamObserver<ImagesResponse>() {

			@Override
			public void onNext(ImagesResponse response) {
				System.out.println("Images live : \n" + response.getResponseImages());
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				
				System.out.println("server Completed ...");
				
			}
			
			
		};
		
		StreamObserver<ImagesRequest> requestObserver = asyncStub.camerasViewing(responserObserver);
		
		try {
			
			requestObserver.onNext(ImagesRequest.newBuilder().setRequestImages("Image").build());
		
			
			System.out.println("Requesting Images...");
			
			
			Thread.sleep(new Random().nextInt(1000) + 500);
			
		}catch (RuntimeException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
	}
}
