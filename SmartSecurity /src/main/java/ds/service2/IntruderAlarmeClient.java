package ds.service2;



import java.util.Iterator;
import javax.jmdns.ServiceInfo;
import ds.service2.IntruderAlarmGrpc.IntruderAlarmBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import jmDNS_Service.DiscoveryService;
import ds.service2.IntruderAlarmGrpc.IntruderAlarmStub;


public class IntruderAlarmeClient {
	public static IntruderAlarmStub asyncStub;
	public static IntruderAlarmBlockingStub IntruderAlertStub;
	private static ServiceInfo info;
	public static void main(String[] args) throws InterruptedException {

		
		String service_type = "_IntruderAlarm._tcp.local.";
		setInfo(DiscoveryService.discoverService(service_type));
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





	public static ServiceInfo getInfo() {
		return info;
	}





	public static void setInfo(ServiceInfo info) {
		IntruderAlarmeClient.info = info;
	}
	
	
	
}
