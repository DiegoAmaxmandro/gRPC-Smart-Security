package ds.service1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import ds.service1.SmartLockGrpc.SmartLockImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;




public class SmartLockServer extends SmartLockImplBase {
	

	public static void main(String[] args) throws IOException, InterruptedException {
		SmartLockServer smartLockServer = new SmartLockServer();// Instantiating the server
		
		Properties pro = smartLockServer.getProperties();// Getting properties for the server
		smartLockServer.ServiceRegister(pro);//Making the register
		
		int port = Integer.valueOf(pro.getProperty("service_port"));//Declaring the port of the server
		
		
		try {
			//Initializing  and building the server
			Server server = ServerBuilder.forPort(port).addService(smartLockServer).build().start();
			
			System.out.println("SmartLock Server running on " + port);
			
			server.awaitTermination();
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
private Properties getProperties() {//Getting the properties from the file properties to use on the register of the server.
		
		Properties pro = null;		
		
		 try (InputStream input = new FileInputStream("/Users/diegolemos/git/repository/SmartSecurity /src/main/resources/SmartLock.properties")) {

	            pro = new Properties();

	            // load a properties file
	            pro.load(input);

	            // get the property value and print it out
	            System.out.println("Starting Smartlock grpc server ...");
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
	

	//Method to run the first RPC of the proto file, unary RPC
	@Override
	public void unlockDoors(UnlockRequest request, StreamObserver<UnlockResponse> responseObserver) {
		System.out.println("starting the server..." + "\n");

		String openDoors = request.getUnlockRequest();

		UnlockResponse.Builder response = UnlockResponse.newBuilder();// building the object to get the response.
		
		//A condition just to validate the entry of the password.
		if (openDoors.equals("myHome") ) {
			response.setUnlockAproval("Doors unlocked successfully");
		} else {

			response.setUnlockAproval("You entered the wrong access code, please try again");

		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	//Method to run the second RPC of the proto file, Client Streaming RPC
	@Override
	public StreamObserver<LockRequest> lockDoorsAndWindows(StreamObserver<LockResponsee> responseObserver) {

		return new StreamObserver<LockRequest>() {
			String lockConfirmation = "The door or windown number: ";
			
			@Override
			public void onNext(LockRequest lockId) {
				System.out.println("Getting ... \n" + lockId.getLockId());

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
