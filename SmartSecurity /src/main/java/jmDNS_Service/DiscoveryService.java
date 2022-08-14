package jmDNS_Service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class DiscoveryService {

	public static class myServiceListener implements ServiceListener {
		
		@Override
		public void serviceAdded(ServiceEvent event) {
			System.out.println("Service Added " + event.getInfo());
			
		}

		@Override
		public void serviceRemoved(ServiceEvent event) {
			System.out.println("Service Removed " + event.getInfo());
			
		}

		@Override
		public void serviceResolved(ServiceEvent event) {
			System.out.println("Service Resolved " + event.getInfo());
			
		}


		
	}

	public static ServiceInfo discoverService(String service_type) throws InterruptedException  {
		ServiceInfo serviceInfo = null;

		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

			

			jmdns.addServiceListener(service_type, new  myServiceListener());

			Thread.sleep(10000);
		
			
			jmdns.close();

		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return serviceInfo;
	}

}
