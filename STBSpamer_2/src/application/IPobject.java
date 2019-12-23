package application;

import java.util.ArrayList;

import javafx.scene.control.Label;

public class IPobject {

	private String jsonkey;
	private String ip;
	ArrayList<String> json_keys;
	
	public IPobject(String _key, String _ip)
	{
		this.jsonkey = _key;
		this.ip = _ip;
		System.out.println("Key=" + _key + " ip="+_ip);
	}
	
	public String getJsonKey()
	{
		return this.jsonkey;
	}
	public String getIpadress()
	{
		return this.ip;
	}
	
}
