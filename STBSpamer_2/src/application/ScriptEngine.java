package application;

import java.util.ArrayList;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;


public class ScriptEngine {
	
	private ArrayList<IPobject> ipSTB;
	private long interval;
	private long pause_command;
	private Thread spam;

	
	public void RunSpamThread()
	{
		spam = new spamThread();
		spam.start();
	}
	public void StopSpamThread()
	{
		spam.stop();
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
							
							for (String key : ip.json_keys)
							{
								STB.setJsonKey(key);
								STB.Call();
								System.out.println("json command: " + key );
								try {
									Thread.sleep(pause_command);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							STB = null;
		            	}
		          }
		}

	}
	
	public ScriptEngine( ArrayList<IPobject> _ipSTB, long _interval, long _pause_command)
	{
		this.ipSTB = _ipSTB;
		this.interval = _interval;
		this.pause_command = _pause_command;
	}
	
	public static DefaultHttpClient getThreadSafeClient()  {

	    DefaultHttpClient client = new DefaultHttpClient();
	    ClientConnectionManager mgr = client.getConnectionManager();
	    HttpParams params = client.getParams();
	    client = new DefaultHttpClient(new ThreadSafeClientConnManager(params, mgr.getSchemeRegistry()), params);
	    return client;
	}

}
