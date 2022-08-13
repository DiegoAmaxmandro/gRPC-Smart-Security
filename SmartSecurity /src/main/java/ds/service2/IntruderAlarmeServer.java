package ds.service2;

import java.io.IOException;
import java.util.logging.Logger;
import io.grpc.Server;
import io.grpc.ServerBuilder;



public class IntruderAlarmeServer {
	
	private static final Logger logger = Logger.getLogger(IntruderAlarmeService.class.getName());
	

	public static void main(String[] args) throws IOException, InterruptedException {

		Server server = ServerBuilder.forPort(5555).addService(new IntruderAlarmeService()).build();

		server.start();

		logger.info("Server started at. " + server.getPort()); 

		server.awaitTermination();
	}
	

}
