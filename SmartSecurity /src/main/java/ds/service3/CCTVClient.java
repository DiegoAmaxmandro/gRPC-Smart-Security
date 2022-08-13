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

public class CCTVClient {
	public static CCTVServiceStub asyncStub;
	
	public static void main(String[] args) throws InterruptedException {
		
		discoverService("_CCTV._tcp.local.");
		
		ManagedChannel chanel = ManagedChannelBuilder.forAddress("localhost", 55570).usePlaintext().build();
		
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

	public static void discoverService(String service_type) throws InterruptedException {
		try {

			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			

			// Add a service listener
			jmdns.addServiceListener(service_type, new ServiceListener() {
				public void serviceAdded(ServiceEvent event) {
					System.out.println("Service added: " + event.getInfo() + event.getName());
					
				}

				public void serviceRemoved(ServiceEvent event) {
					System.out.println("Service removed: " + event.getInfo());
				}

				public void serviceResolved(ServiceEvent event) {
					System.out.println("Service resolved: " + event.getInfo());
					
					ServiceInfo info = event.getInfo();
					int port = info.getPort();
					String path = info.getNiceTextString().split("=")[1];
					String url = "http://localhost:" + port + "/" + path;
					System.out.println(" --- sending request to " + url);
			}
			});

			Thread.sleep(10000);

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	
	}

}
