package ds.service2;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import ds.service2.IntruderAlarmGrpc.IntruderAlarmBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import ds.service2.IntruderAlarmGrpc.IntruderAlarmStub;


public class IntruderAlarmeClient {
	public static IntruderAlarmStub asyncStub;
	public static IntruderAlarmBlockingStub IntruderAlertStub;
	public static void main(String[] args) throws InterruptedException {

		discoverService("_IntruderAlarm._tcp.local");
		ManagedChannel chanel = ManagedChannelBuilder.forAddress("localhost", 55567).usePlaintext().build();
		
		
		AlertRequest  Alertrequest = AlertRequest.newBuilder().setIntruder(true).build();
		
		
		
		IntruderAlertStub = IntruderAlarmGrpc.newBlockingStub(chanel);
		
		asyncStub = IntruderAlarmGrpc.newStub(chanel);
		
		AlertResponse response1 = IntruderAlertStub.intruderAlert(Alertrequest);
		
		
		System.out.println("************* METHOD 1 *********");
		System.out.println(response1.getSentHelp());
		System.out.println();//just to get space between lines
		
		System.out.println("************* METHOD 2 *********");
		ligthsOnBlocking();
		
		chanel.shutdown();
	
	}
	
	
	
	

	public static void ligthsOn(){
		LightRequest request = LightRequest.newBuilder().setLightTrigger(true).build();
		
		StreamObserver<LightResponse> responseObserver = new StreamObserver<LightResponse>() {

			@Override
			public void onNext(LightResponse lightTrigger) {
				System.out.println("Getting ... " + lightTrigger.getLightsOn());
				
				
			}

			@Override
			public void onError(Throwable t) {
				
				
			}

			@Override
			public void onCompleted() {
			System.out.println("Completed .....");
				
			}
			
			
			
		};
		
		 asyncStub.lightOnAlert(request,responseObserver);
		 try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
	public static void ligthsOnBlocking() {
	
		
		
		//We need to change the setLightTrigger to true to get answer from the server.
		LightRequest request = LightRequest.newBuilder().setLightTrigger(false).build();
	
		
		
		try {
			
			Iterator<LightResponse> responces = IntruderAlertStub.lightOnAlert(request);
			
			
			while(responces.hasNext()) {
				LightResponse ligt = responces.next();
				System.out.println(ligt.getLightsOn());				
			}

		} catch (StatusRuntimeException e) {
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
