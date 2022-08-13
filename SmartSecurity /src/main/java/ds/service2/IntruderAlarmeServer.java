package ds.service2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import ds.service2.IntruderAlarmGrpc.IntruderAlarmImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;



public class IntruderAlarmeServer extends IntruderAlarmImplBase {
	
	
	

	public static void main(String[] args) throws IOException, InterruptedException {

		IntruderAlarmeServer intruderAlarmeServer = new IntruderAlarmeServer();
		
		Properties pro = intruderAlarmeServer.getProperties();
		intruderAlarmeServer.ServiceRegister(pro);
		
		int port = Integer.valueOf(pro.getProperty("service_port"));
		
		
		try {
			Server server = ServerBuilder.forPort(port).addService(intruderAlarmeServer).build().start();
			
			System.out.println("IntruderAlarm Server running on " + port);
			
			server.awaitTermination();
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
private Properties getProperties() {
		
		Properties pro = null;		
		
		 try (InputStream input = new FileInputStream("/Users/diegolemos/git/repository/SmartSecurity /src/main/resources/IntruderAlarmService.properties")) {

	            pro = new Properties();

	            // load a properties file
	            pro.load(input);

	            // get the property value and print it out
	            System.out.println("Starting IntruderAlarm grpc server ...");
	            System.out.println("Service registered with type: " + pro.getProperty("service_type"));
	            System.out.println("Service name: " +pro.getProperty("service_name"));
	            System.out.println("Service description: " +pro.getProperty("service_description"));
		        System.out.println("Service on port: " +pro.getProperty("service_port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return pro;
	}
	
	
	private  void ServiceRegister(Properties pro) {
		
		 try {
	            
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = pro.getProperty("service_type") ;
	            String service_name = pro.getProperty("service_name")  ;
	            
	            int service_port = Integer.valueOf( pro.getProperty("service_port") );

	            
	            String service_description_properties = pro.getProperty("service_description");
	            
	            
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
	            
	            
	            Thread.sleep(1000);


	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	}
	

	@Override
	public void intruderAlert(AlertRequest request, StreamObserver<AlertResponse> responseObserver) {
		System.out.println("starting the server..." + "\n");

		boolean intruderAlert = request.getIntruder();

		AlertResponse.Builder response = AlertResponse.newBuilder();

		if (intruderAlert) {
			response.setSentHelp("Help is on the way!");
		} else {

			response.setSentHelp("It's all good in the house!");

		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void lightOnAlert(LightRequest request, StreamObserver<LightResponse> responseObserver) {
		
		 boolean lights = request.getLightTrigger();
	
		do {
			
			responseObserver.onNext(LightResponse.newBuilder().setLightsOn("The lights is on!").build());
			
		}while(lights);
		
		responseObserver.onCompleted();
		
		
		
	}

	
	

}
