package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class AboutSTB extends Application implements javafx.fxml.Initializable {

	@FXML
	private TextField textfield_url;
	@FXML
	private Button btn_get;
	@FXML
	private WebView webview;
	
	private Stage Window;
	String receiver_info;
	String receiver_ip;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	private void Runner()
	{
		System.out.println(receiver_info);
		System.out.println(receiver_info.length());
		receiver_ip = new String(receiver_info.substring(0, receiver_info.length()-12));
		System.out.println(receiver_ip);
	}

	@Override
	public void start(Stage primary) throws Exception {
		// TODO Auto-generated method stub
		this.Window = primary;

            VBox root = new VBox();
            Scene scene = new Scene(root,400,400); 
            final WebView browser = new WebView();
            final WebEngine webEngine = browser.getEngine();
            root.getChildren().add(browser);
            Runner();
            Window.setScene(scene);
            Window.setTitle(receiver_info + " " + "GET запрос на API /receiver-info");
            Window.show();
            webEngine.load(receiver_ip + "receiver-info");	        	
	}

}
