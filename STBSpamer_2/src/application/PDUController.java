package application;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PDUController extends Application implements javafx.fxml.Initializable{

	Stage Window;
	
	@FXML
	Button btn_off;
	@FXML
	Button btn_clock;
	@FXML
	Button btn_1;
	@FXML
	Button btn_2;
	@FXML
	Button btn_3;
	@FXML
	Button btn_4;
	@FXML
	Button btn_5;
	@FXML
	Button btn_6;
	@FXML
	Button btn_7;
	@FXML
	Button btn_8;
	@FXML
	Button btn_9;
	@FXML
	Button btn_0;
	@FXML
	Button btn_reshetka;
	@FXML
	Button btn_zvezda;
	@FXML
	Button btn_green;
	@FXML
	Button btn_red;
	@FXML
	Button btn_blue;
	@FXML
	Button btn_yellow;
	@FXML
	Button btn_menu;
	@FXML
	Button btn_back;
	@FXML
	Button btn_rec;
	@FXML
	Button btn_up;
	@FXML
	Button btn_select;
	@FXML
	Button btn_left;
	@FXML
	Button btn_right;
	@FXML
	Button btn_down;
	@FXML
	TextField host_addres;
	
	private DefaultHttpClient main_client;
	private String settings_ip;
	private String json_key;
 	
	@FXML
	public void Btn_PowerOff()
	{
		System.out.println("ID элемента: "+ btn_off.getId());
		settings_ip = host_addres.getText();
		json_key = btn_off.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_0()
	{
		System.out.println("ID элемента: "+ btn_0.getId());
		settings_ip = host_addres.getText();
		json_key = btn_0.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_1()
	{
		System.out.println("ID элемент: "+ btn_1.getId());
		settings_ip = host_addres.getText();
		json_key = btn_1.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_2()
	{
		System.out.println("ID элемента: "+ btn_2.getId());
		settings_ip = host_addres.getText();
		json_key = btn_2.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_3()
	{
		System.out.println("ID элемента: "+ btn_3.getId());
		settings_ip = host_addres.getText();
		json_key = btn_3.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_4()
	{
		System.out.println("ID элемента: "+ btn_4.getId());
		settings_ip = host_addres.getText();
		json_key = btn_4.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_5()
	{
		System.out.println("ID элемента: "+ btn_5.getId());
		settings_ip = host_addres.getText();
		json_key = btn_0.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_6()
	{
		System.out.println("ID элемента: "+ btn_6.getId());
		settings_ip = host_addres.getText();
		json_key = btn_6.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_7()
	{
		System.out.println("ID элемента: "+ btn_7.getId());
		settings_ip = host_addres.getText();
		json_key = btn_7.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_8()
	{
		System.out.println("ID элемента: "+ btn_8.getId());
		settings_ip = host_addres.getText();
		json_key = btn_8.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_9()
	{
		System.out.println("ID элемента: "+ btn_9.getId());
		settings_ip = host_addres.getText();
		json_key = btn_9.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_clock()
	{
		System.out.println("ID элемента: "+ btn_clock.getId());
		settings_ip = host_addres.getText();
		json_key = btn_clock.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_reshetka()
	{
		System.out.println("ID элемента: "+ btn_reshetka.getId());
		settings_ip = host_addres.getText();
		json_key = btn_reshetka.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_zvezda()
	{
		System.out.println("ID элемента: "+ btn_zvezda.getId());
		settings_ip = host_addres.getText();
		json_key = btn_zvezda.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_red()
	{
		System.out.println("ID элемента: "+ btn_red.getId());
		settings_ip = host_addres.getText();
		json_key = btn_red.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_green()
	{
		System.out.println("ID элемента: "+ btn_green.getId());
		settings_ip = host_addres.getText();
		json_key = btn_green.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_blue()
	{
		System.out.println("ID элемента: "+ btn_blue.getId());
		settings_ip = host_addres.getText();
		json_key = btn_blue.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_yellow()
	{
		System.out.println("ID элемента: "+ btn_5.getId());
		settings_ip = host_addres.getText();
		json_key = btn_yellow.getId();
		ThreadCreator();
	}
	@FXML
	public void Btn_back()
	{
		System.out.println("ID элемента: "+ btn_back.getId());
		settings_ip = host_addres.getText();
		json_key = btn_back.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_menu()
	{
		System.out.println("ID элемента: "+ btn_menu.getId());
		settings_ip = host_addres.getText();
		json_key = btn_menu.getId();
		ThreadCreator();
	}
	@FXML
	public void Btn_rec()
	{
		System.out.println("ID элемента: "+ btn_rec.getId());
		settings_ip = host_addres.getText();
		json_key = btn_rec.getId();
		ThreadCreator();
	}
	
	
	@FXML
	public void Btn_up()
	{
		System.out.println("ID элемента: "+ btn_up.getId());
		settings_ip = host_addres.getText();
		json_key = btn_up.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_select()
	{
		System.out.println("ID элемента: "+ btn_select.getId());
		settings_ip = host_addres.getText();
		json_key = btn_select.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_left()
	{
		System.out.println("ID элемента: "+ btn_left.getId());
		settings_ip = host_addres.getText();
		json_key = btn_left.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_right()
	{
		System.out.println("ID элемента: "+ btn_5.getId());
		settings_ip = host_addres.getText();
		json_key = btn_right.getId();
		ThreadCreator();
	}
	
	@FXML
	public void Btn_down()
	{
		System.out.println("ID элемента: "+ btn_down.getId());
		settings_ip = host_addres.getText();
		json_key = btn_down.getId();
		ThreadCreator();
	}
	
	private void ThreadCreator()
	{
		System.out.println("ThreadCreator() host: "+settings_ip+" json_key: "+json_key);
		Thread request = new RequestThread();
		request.start();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage primary) throws Exception {
		// TODO Auto-generated method stub
		this.Window = primary;
		System.out.println("Создание PDU UI из под PDU Controller");
		Parent rooty = FXMLLoader.load(getClass().getResource("PDU.fxml"));
		Scene scene = new Scene(rooty);
		primary.setScene(scene);
		primary.setTitle("PDU - как бы пульт...");
		primary.setMaxHeight(790);
		primary.setMaxWidth(290);
		primary.show();
	}
	
	
	private class RequestThread extends Thread
	{
		private String ip;
		private String key;
		
		public void Settings(String _setIP, String _setKey)
		{
			this.ip = _setIP;
			this.key = _setKey;
		}
		
		@Override
		public void run()
		{
			System.out.println("Поток запроса стартова");
			HttpClient client = getThreadSafeClient();
			ClientSTB Request = new ClientSTB(settings_ip, json_key, client);
			Request.Call();
			Request = null;
			System.out.println("Поток запроса отработал");

		}
		
		private DefaultHttpClient getThreadSafeClient()  {

		    DefaultHttpClient client = new DefaultHttpClient();
		    ClientConnectionManager mgr = client.getConnectionManager();
		    HttpParams params = client.getParams();
		    client = new DefaultHttpClient(new ThreadSafeClientConnManager(params, mgr.getSchemeRegistry()), params);
		    return client;
		}
	}
}
