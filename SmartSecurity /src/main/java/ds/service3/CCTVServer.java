package ds.service3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import ds.service3.CCTVServiceGrpc.CCTVServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class CCTVServer extends CCTVServiceImplBase {

	public static void main(String[] args) throws IOException, InterruptedException {

		CCTVServer cctvServer = new CCTVServer();// Instantiating the server

		Properties pro = cctvServer.getProperties();// Getting properties for the server
		cctvServer.ServiceRegister(pro);//Making the register

		int port = Integer.valueOf(pro.getProperty("service_port"));

		try {
			//Initializing  and building the server
			Server server = ServerBuilder.forPort(port).addService(cctvServer).build().start();

			System.out.println("CCTV Server running on " + port);

			server.awaitTermination();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
private Properties getProperties() {//Getting the properties from the file properties to use on the register of the server.
		
		Properties pro = null;		
		
		 try (InputStream input = new FileInputStream("/Users/diegolemos/git/repository/SmartSecurity /src/main/resources/CCTVService.properties")) {

	            pro = new Properties();

	            // load a properties file
	            pro.load(input);

	            // get the property value and print it out
	            System.out.println("Starting CCTV grpc server ...");
	            System.out.println("Service registered with type: " + pro.getProperty("service_type"));
	            System.out.println("Service name: " +pro.getProperty("service_name"));
	            System.out.println("Service description: " +pro.getProperty("service_description"));
		        System.out.println("Service on port: " +pro.getProperty("service_port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return pro;
	}
	
//Method to make the register of the dns of the server
	private  void ServiceRegister(Properties pro) {
		
		 try {
	            //Declaring the jmDNS
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
	
	//Method to respond  the request of the intruder CCTV service
	@Override
	public StreamObserver<ImagesRequest> camerasViewing(StreamObserver<ImagesResponse> responseObserver) {

		return new StreamObserver<ImagesRequest>() {

			@Override
			public void onNext(ImagesRequest request) {
				StringBuffer sb = new StringBuffer();

				int camId = 1;
				//The loop goes though the requests to simulate diferents images coming out 
				for (int i = 0; i < 5; i++) {
					sb.append(request.getRequestImages() + "Camera Id number: " + camId + "\n");
					camId++;
				}
				
				ImagesResponse answer = ImagesResponse.newBuilder().setResponseImages(sb.toString()).build();
				
				responseObserver.onNext(answer);
			}

			@Override
			public void onError(Throwable t) {

			}

			@Override
			public void onCompleted() {
				responseObserver.onCompleted();

			}

		};
	}

	//Method to respond  the request of the intruder CCTV service
	@Override
	public void petAlert(PetAlertRequest request, StreamObserver<PetAlertResponse> responseObserver) {

		System.out.println("starting the server..." + "\n");

		String petAlert = request.getPetAlert();

		PetAlertResponse.Builder response = PetAlertResponse.newBuilder();
		//A condition to give the response to the client depending of the input in the request
		if (petAlert.equals("Pet detected")) {
			response.setAlarmsOff("Alarm not triggered");
		} else {

			response.setAlarmsOff("Alarm triggered!");

		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();

	}

	

	
	
}