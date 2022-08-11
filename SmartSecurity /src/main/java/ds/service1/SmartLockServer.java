package ds.service1;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;




public class SmartLockServer {
	
	private static final Logger logger = Logger.getLogger(SmartLockServer.class.getName());
	

	public static void main(String[] args) throws IOException, InterruptedException {

		Server server = ServerBuilder.forPort(5557).addService(new SmartLockService()).build();

		server.start();

		logger.info("Server started at. " + server.getPort()); 

		server.awaitTermination();
	}
	
	
	

	

}
