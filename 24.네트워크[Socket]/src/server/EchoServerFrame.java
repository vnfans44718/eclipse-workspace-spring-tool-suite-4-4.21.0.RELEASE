package server;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class EchoServerFrame extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea displayTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EchoServerFrame frame = new EchoServerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EchoServerFrame() {
		setAlwaysOnTop(true);
		setTitle("EchoServer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		displayTA = new JTextArea();
		displayTA.setFont(new Font("나눔고딕코딩", Font.BOLD, 16));
		scrollPane.setViewportView(displayTA);
		/********* EchoServerThread start ********/
		EchoServerThread echoServerThread=new EchoServerThread();
		echoServerThread.start();
		/*****************************************/
		
	}//생성자끝
	public void displayLog(String log) {
		displayTA.append(log+"\n");
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
	}
	/******************** EchoServerThread start**************************/
	/*
	 0.EchoServerThread:ServerSocket생성(9999)
     1.EchoServerThread:클라이언드연결요청쓰레드가대기
	 2.EchoServerThread:클라이언드와연결된 서버쪽소켓
	 3.EchoServerThread:서버쪽소켓으로부터 입력,출력스트림생성
	 4.EchoServerThread:입력스트림을사용해서 클라이언트전송데이타읽기
	 5.EchoServerThread:클라이언트로부터읽은데이타
	 6.EchoServerThread:클라이언트에 데이타쓰기
	 7.EchoServerThread:클라이언드와연결된 서버쪽소켓닫기
	*/ 
	public class EchoServerThread extends Thread{
		@Override
		public void run() {
			try {
				displayLog("0.EchoServerThread:ServerSocket생성(9999)");
				ServerSocket serverSocket=new ServerSocket(9999);
				while(true) {
					displayLog("1.EchoServerThread:클라이언드연결요청쓰레드가대기");
					Socket socket = serverSocket.accept();
					displayLog("2.EchoServerThread:클라이언드와연결된 서버쪽소켓:"+socket);
					displayLog("3.EchoServerThread:서버쪽소켓으로부터 입력,출력스트림생성");
					BufferedReader in=
							new BufferedReader(
									new InputStreamReader(
											socket.getInputStream()));
					PrintWriter out=
							new PrintWriter(
									new OutputStreamWriter(
											socket.getOutputStream()));
					displayLog("4.EchoServerThread:입력스트림을사용해서 클라이언트전송데이타읽기");
					String echoString=in.readLine();
					String clientIPPort = socket.getInetAddress().getHostAddress()+"("+socket.getPort()+")";
					displayLog("5.EchoServerThread:클라이언트로부터읽은데이타:["+clientIPPort+"]"+echoString);
					displayLog("6.EchoServerThread:클라이언트에 데이타쓰기");
					out.println("Server:"+echoString);
					out.flush();
					displayLog("7.EchoServerThread:클라이언드와연결된 서버쪽소켓닫기");
					socket.close();
				}
			}catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
	/********************EchoServerThread end**************************/	
	
}//class end















