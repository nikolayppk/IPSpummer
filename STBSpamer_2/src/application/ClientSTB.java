package application;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;



public class ClientSTB {

	private String ip;
	private String value;
	private HttpClient client;
	private JSONObject json;
	private HttpResponse response;
	private HttpPost post;
	private StringEntity se;
	
	
	public ClientSTB(String _ip, String _value, HttpClient _client)
	{
		this.ip = _ip;
		this.value = _value;
		this.client = _client;
	}
	
	public ClientSTB(IPobject IP, HttpClient _client, Logger _log)
	{
		this.ip = IP.getIpadress();
		this.value = IP.getJsonKey();
		this.client = _client;
	}
	
	public ClientSTB(IPobject IP, HttpClient _client)
	{
		this.ip = IP.getIpadress();
		this.value = IP.getJsonKey();
		this.client = _client;
	}
	
	public void setJsonKey(String key) 
	{
		this.value = key;
	}
	
	public void Call() 
	{
		
				System.out.println("ClientSTB ip: "+ip+" json_key: "+value);
				String url = ip;//целевой адрес	
				//this.client = getThreadSafeClient();
		        HttpConnectionParams.setConnectionTimeout(client.getParams(), 1000); //Timeout Limit
		        
		        this.json = new JSONObject();
		        post = new HttpPost(url);
		        try {
					json.put("key", value);
					System.out.println(json.toString()+" "+url);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
		        try {
					se = new StringEntity(json.toString());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
		        se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
		        post.setEntity(se);
		        
		        //response = client.execute(post);		   
		        try {
					client.execute(post);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
		        System.out.println("ClientSTB отработал");
		 }

	public DefaultHttpClient getThreadSafeClient()  {

	    DefaultHttpClient client = new DefaultHttpClient();
	    ClientConnectionManager mgr = client.getConnectionManager();
	    HttpParams params = client.getParams();
	    client = new DefaultHttpClient(new ThreadSafeClientConnManager(params, mgr.getSchemeRegistry()), params);
	    return client;
	}
	
}
