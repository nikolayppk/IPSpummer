package application;

import java.util.ArrayList;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;

public class RequestEngine {

	
	long interval;
	ArrayList<IPobject> ipSTB;
	private Thread SingleCommand;
	
	public void RunSpamThread()
	{
		SingleCommand = new spamThread();
		SingleCommand.start();
	}
	public void StopSpamThread()
	{
		SingleCommand.stop();
	}
	
	private class spamThread extends Thread
	{
		@Override
		public void run()
		{
			HttpClient client = getThreadSafeClient();
			while (true){
	             
				//интервал опроса приемника (в секундах)
				try {
					Thread.sleep(interval*1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
		            	for (IPobject ip : ipSTB)//обход массива по ip стеку
		            	{    
							ClientSTB STB = new ClientSTB(ip, client);
							STB.Call();
							//STB.Call();
							//STB.Call();
							STB = null;
		            	}
		          }
	         }

	}
	
	public static DefaultHttpClient getThreadSafeClient()  {

	    DefaultHttpClient client = new DefaultHttpClient();
	    ClientConnectionManager mgr = client.getConnectionManager();
	    HttpParams params = client.getParams();
	    client = new DefaultHttpClient(new ThreadSafeClientConnManager(params, mgr.getSchemeRegistry()), params);
	    return client;
	}
	
	
}
