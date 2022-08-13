package ds.service3;

import ds.service3.CCTVServiceGrpc.CCTVServiceImplBase;
import io.grpc.stub.StreamObserver;

public class CCTVservice extends CCTVServiceImplBase {

	@Override
	public StreamObserver<ImagesRequest> camerasViewing(StreamObserver<ImagesResponse> responseObserver) {

		return new StreamObserver<ImagesRequest>() {

			@Override
			public void onNext(ImagesRequest request) {
				StringBuffer sb = new StringBuffer();

				int camId = 1;

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

	@Override
	public void petAlert(PetAlertRequest request, StreamObserver<PetAlertResponse> responseObserver) {

		System.out.println("starting the server..." + "\n");

		String petAlert = request.getPetAlert();

		PetAlertResponse.Builder response = PetAlertResponse.newBuilder();

		if (petAlert.equals("Pet detected")) {
			response.setAlarmsOff("Alarm not triggered");
		} else {

			response.setAlarmsOff("Alarm triggered!");

		}

		responseObserver.onNext(response.build());
		responseObserver.onCompleted();

	}

}
