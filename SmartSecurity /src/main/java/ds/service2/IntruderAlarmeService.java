package ds.service2;

import ds.service2.IntruderAlarmGrpc.IntruderAlarmImplBase;
import io.grpc.stub.StreamObserver;

public class IntruderAlarmeService extends IntruderAlarmImplBase {
	
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
