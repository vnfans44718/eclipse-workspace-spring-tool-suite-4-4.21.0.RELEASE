package chat.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ChatClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField chatTF;
	private JScrollPane scrollPane;
	private JTextArea displayTA;

	/****** ClientClient[Thread]객체 멤버필드로 선언 ******/
	private ClientClient client;
	public static void main(String[] args) throws Exception{

		ChatClientFrame frame = new ChatClientFrame();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public ChatClientFrame() throws Exception {
		setAlwaysOnTop(true);
		setTitle("채팅클라이언트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		displayTA = new JTextArea();
		displayTA.setFont(new Font("나눔고딕코딩", Font.BOLD, 17));
		displayTA.setEditable(false);
		scrollPane.setViewportView(displayTA);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.SOUTH);

		chatTF = new JTextField();
		chatTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/********클라이언트에서 서버로 데이타전송********/
				String chatString=chatTF.getText();
				chatTF.setText("");
				if(chatString.trim().equals("")){
					chatTF.requestFocus();
					return;	
		        }
				client.send("["+client.getUserId()+"]"+chatString);
				chatTF.requestFocus();
				/*********************************************/
			}
		});
		chatTF.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(chatTF);
		chatTF.setColumns(38);

		JButton sendB = new JButton("전송");
		sendB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/********클라이언트에서 서버로 데이타전송********/
				String chatString=chatTF.getText();
				chatTF.setText("");
				if(chatString.trim().equals("")){
					chatTF.requestFocus();
					return;	
		        }
				client.send("["+client.getUserId()+"]"+chatString);
				chatTF.requestFocus();
				/*********************************************/
			}
		});
		panel.add(sendB);

		/******** ClientClient객체생성(Thread) *******/
		Socket socket=new Socket("192.168.15.31",8888);
		client=new ClientClient(socket);
		client.start();
		

	}// 생성자

	private void displayMessage(String msg) {
		displayTA.append(msg + "\n");
		int maxSize = scrollPane.getVerticalScrollBar().getMaximum();
		scrollPane.getVerticalScrollBar().setValue(maxSize);
	}

	/**************************************************************
	  - 클라이언트쪽소켓을 사용하여 서버와 통신을 담당하는 클래스
	  - 서버와연결된 소켓1개를 가지고있는클래스 
	  - 클라이언트의 정보를가지고있는클래스 
	  - 클라이언트당 1개의객체가생성
	 ****************************************************************/
	public class ClientClient extends Thread{
		private String userId;
		private Socket socket;
		private PrintWriter out;
		private BufferedReader in;
		public ClientClient(Socket socket) throws Exception{
			this.socket=socket;
			this.in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.userId = socket.getLocalAddress().getHostAddress()
					+"["+socket.getLocalPort()+"]";
		}
		/*
		 * 클라이언트에서 서버로 데이타 전송
		 */
		public void send(String message) {
			out.println(message);
			out.flush();
			
		}
		/*
		 * 서버에서 보내는 데이타를 읽기
		 */
		@Override
		public void run() {
			try {
				while(true) {
					System.out.println("가.ClientClient:서버로부터 오는 데이타를 읽기위해 쓰레드 무한대기(blocking)");
					String chatString = in.readLine();
					System.out.println("나.ClientClient:서버로부터 오는 데이타를 클라이언트채팅창에 보여준다. ");
					displayMessage(chatString);
				}
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		
	}//end inner class

}//end outer class








