package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EchoClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField echoTextField;
	private JScrollPane scrollPane;
	private JTextArea displayTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EchoClientFrame frame = new EchoClientFrame();
					frame.setVisible(true);
					frame.echoTextField.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EchoClientFrame() {
		setTitle("EchoClientFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		echoTextField = new JTextField();
		echoTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*************************/
				try {
					String echoString = echoTextField.getText();
					if(echoString.trim().equals("")) {
						echoTextField.requestFocus();
						return;
					}
					echoTextField.setText("");
					echoTextField.requestFocus();
					/*
					 * 1.Socket생성
					 */
					Socket socket =new Socket("192.168.15.31", 9999);
					
					/*
					 * 2.서버로 문자데이타쓰기
					 *   - OutputStream얻기
					 *   - OutputStream(byte)
					 *     -->Writer로변경(OutputStreamWriter)
					 *     -->PrintWriter로변경(PrintWriter)
					 */
					OutputStream out=socket.getOutputStream();
					OutputStreamWriter osw=new OutputStreamWriter(out);
					PrintWriter pw=new PrintWriter(osw);
					pw.println(echoString);
					pw.flush();
					/*
					 * 3.서버에서 전송되는 데이타읽기
					 *   - InputSteram얻기
					 *   - InputStream(byte)-->InputSteamReader-->BufferedReader
					 */
					BufferedReader br=
							new BufferedReader(
									new InputStreamReader(socket.getInputStream()));
					String serverEchoString=br.readLine();
					displayTextArea.append(serverEchoString+"\n");
					pw.close();
					br.close();
					socket.close();
					
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				/*************************/
			}
		});
		contentPane.add(echoTextField, BorderLayout.SOUTH);
		echoTextField.setColumns(10);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		displayTextArea = new JTextArea();
		displayTextArea.setEditable(false);
		scrollPane.setViewportView(displayTextArea);
	}

}
