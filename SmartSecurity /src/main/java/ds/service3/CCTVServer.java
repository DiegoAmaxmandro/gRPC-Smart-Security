package ds.service3;

import java.io.IOException;
import java.util.logging.Logger;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class CCTVServer {
	
private static final Logger logger = Logger.getLogger(CCTVServer.class.getName());
	

	public static void main(String[] args) throws IOException, InterruptedException {

		Server server = ServerBuilder.forPort(5559).addService(new CCTVservice()).build();

		server.start();

		logger.info("Server started at. " + server.getPort()); 

		server.awaitTermination();
	}

}
