package application;
	
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	@FXML
	private ToggleButton btn_run;//������ ������ ������
	@FXML
	private  Button btn_ipAdd;//���������� ip
	@FXML
	private Button btn_ipDelete;//�������� ip
	@FXML
	private TextField ipEdit;//���� ����� ip ������
	@FXML 
	private TextField intervalEdit;// �������� ������ ������
	@FXML
	private TextField APIEdit;//��������� ����
	@FXML
	private TextField pause_edit;//����� ����� ��������� ������� default
	@FXML
	private ListView ip_list_view;//����������� ������������������ ip �������
	@FXML
	private CheckBox scriptChoise;
	@FXML
	private TextArea script_area;
	private ListView ip_list_view_mirror;
	
	//���� ������ ��������� �� UI
	
	private static ArrayList<IPobject> hostData;//������ ������������ STB
	private static RequestEngine HttpEngine;
	private static ScriptEngine scriptHttpEngine;
	private boolean run_spam_status;
	private String CommandFromUI;
	private static ArrayList<String> Command;
	private long interval;
	private long pause_command;
	String dataIP = "data.txt";
	private static ArrayList<String> ippool;//����������
	
	private void Init()//������������� ��������� ������
	{
		this.hostData = new ArrayList<IPobject>();
		HttpEngine = new RequestEngine();
		System.out.println(hostData.size());
		this.Command = new ArrayList<String>();
		this.ippool = new ArrayList<String>();
	}
		
	private void lastChanse(Parent _root)
	{
		ObservableList<Node> _Node = _root.getChildrenUnmodifiable();
		System.out.println(_Node.size());
		for (Node T: _Node)
		{
			try {
				if (T.getId().equals("ip_list_view"))
				{
					System.out.println("����� ������ add");
					this.ip_list_view_mirror = (ListView) T;
				}
			 } catch (Exception e)
			{
				 
			}
		}
	}
	private void ReadData() throws IOException
	{
		 FileInputStream fstream = new FileInputStream(dataIP);//��������� ������������ ip
		 
		   BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		   String strLine;
			while ((strLine = br.readLine()) != null){
			      System.out.println(strLine);
			      ippool.add(strLine);
			   }
			fstream.close();
			br = null;
			
			for (String ip:ippool)
				{
			    	//list_view_render(ip);
			    	mirror_ip_list_render(ip);
					add_ip_in_hostData("Right", ip);
				}
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		
		Init();//������������� ���� ������ ���������
		Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		lastChanse(root);
		ReadData();
	
		System.out.println(hostData.size());
		primaryStage.setTitle("������� ������ STB version 3.0. UglyMod");
		primaryStage.setMaxHeight(730);
		primaryStage.setMaxWidth(840);
		primaryStage.show();
		
		
	}
	
	//�������� ������������ ������
	
	@FXML
	private void Run()
	{
		System.out.println("������ btn_run ����������");
		HttpEngine.interval = new Long(intervalEdit.getText());
		HttpEngine.ipSTB = hostData;
		System.out.println("CheckBox: " + scriptChoise.isSelected());	
		
		if (scriptChoise.isSelected()) {
			System.out.println("��������� �������");
			run_spam_status = btn_run.isSelected();
	    	if (run_spam_status)
	    	{
	    		System.out.println("���� ����");
	    		ScriptInit();
	    		scriptHttpEngine.RunSpamThread();
	    		
	    	} else {
	    		scriptHttpEngine.StopSpamThread();
	    		System.out.println("���� ����");
	    	}
		} else {
			run_spam_status = btn_run.isSelected();
	    	if (run_spam_status)
	    	{	    		
	    		HttpEngine.RunSpamThread();
	    		btn_run.setText("���������� �����");
	    	} else {
	    		HttpEngine.StopSpamThread();
	    		btn_run.setText("C���� ������");
	    	}
		}
		
		
	}
	
	private void ScriptInit()
	{
		this.CommandFromUI = script_area.getText();
		Command = commandBuilder(this.CommandFromUI);
		pause_command = new Long(pause_edit.getText());
		interval = new Long(intervalEdit.getText());
		System.out.println(CommandFromUI);
		
		for (IPobject ip : this.hostData)//����� ������� �� ip �����
    	{    
			ip.json_keys = this.Command;
    	}
		
		ScriptSpamInit();
	}
	
	private void ScriptSpamInit()
	{
		this.scriptHttpEngine = new ScriptEngine(hostData, interval, pause_command);
		
	}
	
		
	
	private ArrayList<String> commandBuilder(String TextAreaData)
	{
		ArrayList<String> builder = new ArrayList<String>();
		String delimetr = "\n";
		String[] sub;
		sub = TextAreaData.split(delimetr);
		for (int i=0; i < sub.length; i++)
		{
			builder.add(sub[i]);
			System.out.println(sub[i] + " " + i);
		}	
		return builder;
	}
	
	
	@FXML
	private void AddButton()
	{
		System.out.println("������ btn_ipAdd ����������: ipEdit "+ipEdit.getText());
		System.out.println("ipEdit: "+ ipEdit.toString());
		System.out.println("intervalEdit: "+ intervalEdit.toString());
		System.out.println("APIEdit: "+ APIEdit.toString());
		System.out.println("pause_edit: "+ pause_edit.toString());
		System.out.println("ip_list_view "+ ip_list_view.getId());
		System.out.println(APIEdit.getText() + " " + ipEdit.getText());
		
		add_ip_in_hostData(APIEdit.getText(), ipEdit.getText());
		list_view_render(ipEdit.getText());
	}
	
	@FXML
	private void DeleteButton()
	{
		System.out.println("������ btn_ipDelete ����������");
		DeleteItem();
	}
	
	private void DeleteItem()
	{
		//Action ������ �������� �������� �� list_view
		int a = ip_list_view.getSelectionModel().getSelectedIndex();
		
        System.out.println(hostData.get(a).getIpadress());
        ip_list_view.getItems().remove(a);
        hostData.remove(a);
	}
	
	
	private void add_ip_in_hostData(String _key, String _ip)
	{
		//����� ������� ���� ������ ������� ��� �������� ������.
		try {
			System.out.println("Key=" + _key + " ip="+_ip);
			hostData.add(new IPobject(_key, _ip));
			System.out.println(hostData.size());
			System.out.println("IPObject ��� ��������");			
		}
		catch (Exception e){
			System.out.println("IPObject �� ��� ��������");	
			e.printStackTrace();
		}
	}
	
	private void list_view_render(String new_host_ip)
	{
		//����� ��������� � ipListUI ����� ������������� �����
		ip_list_view.getItems().add(new_host_ip);
	}
	private void mirror_ip_list_render(String _T)
	{
		this.ip_list_view_mirror.getItems().add(_T);
	}
	
	
	@FXML
	private void OpenPdu() throws Exception
	{
		Stage PDUstage = new Stage();
		PDUController remote = new PDUController();
		remote.start(PDUstage);
	}
	
	@FXML
	private void AboutView() throws Exception
	{
		int a = ip_list_view.getSelectionModel().getSelectedIndex();
		String info = ip_list_view.getItems().get(a).toString();
		
		Stage AboutStage = new Stage();
		AboutSTB infogetter = new AboutSTB();
		infogetter.receiver_info = info;
		infogetter.start(AboutStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
