package ds.service3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import ds.service3.CCTVServiceGrpc.CCTVServiceBlockingStub;
import ds.service3.CCTVServiceGrpc.CCTVServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import jmDNS_Service.DiscoveryService;
import jmDNS_Service.DiscoveryService.myServiceListener;

public class CCTVClient {
	public static CCTVServiceStub asyncStub;
	private static ServiceInfo info;

	public static void main(String[] args) throws InterruptedException {
		
		
		//Calling the method Discovery Service
		String service_type = "_CCTV._tcp.local.";
		info = DiscoveryService.discoverService(service_type);
		
		//Building the channel
		ManagedChannel chanel = ManagedChannelBuilder.forAddress("localhost", 55570).usePlaintext().build();
		
		CCTVServiceBlockingStub CCTVLocStub = CCTVServiceGrpc.newBlockingStub(chanel);//Isntatianting the channel

		PetAlertRequest PetAlertRequest = ds.service3.PetAlertRequest.newBuilder().setPetAlert("Pet detected").build();

		PetAlertResponse response = CCTVLocStub.petAlert(PetAlertRequest);

		System.out.println("************* METHOD 1 *********");
		System.out.println(response.getAlarmsOff());
		System.out.println();// just to get space between lines

		asyncStub = CCTVServiceGrpc.newStub(chanel);
		
		//Calling the method that request the server
		cctvViewing();

		chanel.shutdown();
	}
	//Method to send the request to the server
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
		CCTVClient.info = info;
	}
	
	




}
