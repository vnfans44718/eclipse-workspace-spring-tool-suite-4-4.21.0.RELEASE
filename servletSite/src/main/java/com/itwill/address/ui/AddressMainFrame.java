package com.itwill.address.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.address.Address;
import com.itwill.address.AddressService;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddressMainFrame extends JFrame {
	/****** 1.AddressService 멤버필드선언 ******/
	AddressService addressService;
	/****************************************/

	private JPanel contentPane;
	private JTextField insertNameTextField;
	private JTextField insertPhoneTextField;
	private JTextField insertAddressTextField;
	private JTextField detailNameTextField;
	private JTextField detailPhoneTextField;
	private JTextField detailAddressTextField;
	private JTextField detailNoTextField;
	private JTable addressListTable;
	private JTextField detailNoTextField2;
	private JButton updateFormButton;
	private JTabbedPane addressTabbedPane;
	private JButton addressDeleteButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressMainFrame frame = new AddressMainFrame();
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
	public AddressMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		addressTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		addressTabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				switch(addressTabbedPane.getSelectedIndex()) {
				case 0:
					break;
				case 1:
					displayAddressList();
					break;
				case 2:
					break;
				
				}
			}
		});
		
		
		contentPane.add(addressTabbedPane, BorderLayout.CENTER);

		JPanel addressInsertPanel = new JPanel();
		addressTabbedPane.addTab("주소록쓰기", null, addressInsertPanel, null);
		addressInsertPanel.setLayout(null);

		JLabel insertNameLabel = new JLabel("이름");
		insertNameLabel.setBounds(68, 45, 57, 15);
		addressInsertPanel.add(insertNameLabel);

		JLabel insertPhoneLabel = new JLabel("전화번호");
		insertPhoneLabel.setBounds(68, 98, 57, 15);
		addressInsertPanel.add(insertPhoneLabel);

		JLabel insertAddressLabel = new JLabel("주소");
		insertAddressLabel.setBounds(68, 147, 57, 18);
		addressInsertPanel.add(insertAddressLabel);

		insertNameTextField = new JTextField();
		insertNameTextField.setBounds(200, 42, 116, 21);
		addressInsertPanel.add(insertNameTextField);
		insertNameTextField.setColumns(10);

		insertPhoneTextField = new JTextField();
		insertPhoneTextField.setBounds(200, 95, 116, 21);
		addressInsertPanel.add(insertPhoneTextField);
		insertPhoneTextField.setColumns(10);

		insertAddressTextField = new JTextField();
		insertAddressTextField.setBounds(200, 146, 116, 21);
		addressInsertPanel.add(insertAddressTextField);
		insertAddressTextField.setColumns(10);

		JButton addressInsertButton = new JButton("주소록쓰기");
		addressInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/******* 주소록쓰기 *********/

				try {
					// 1.TextField로부터데이타얻기
					String name = insertNameTextField.getText();
					String phone = insertPhoneTextField.getText();
					String addr = insertAddressTextField.getText();
					Address address=new Address(0, name, phone, addr);
					// 2.addressService.addressWrite(Address address)메쏘드호출
					int rowCount=addressService.addressWrite(address);
					JOptionPane.showMessageDialog(null, "주소쓰기성공");
					//3.주소록리스트화면보여주기
					addressTabbedPane.setSelectedIndex(1);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "주소쓰기실패");
					e1.printStackTrace();
				}

				/**************************/
			}
		});
		addressInsertButton.setBounds(119, 219, 150, 23);
		addressInsertPanel.add(addressInsertButton);

		JPanel addressListPanel = new JPanel();
		addressTabbedPane.addTab("주소록리스트", null, addressListPanel, null);
		addressListPanel.setLayout(null);

		JButton addressListButton = new JButton("주소록리스트");
		addressListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/********** 주소록리스트 *************/
				try {
					System.out.println("----------------UI에서출력-------------------");
					displayAddressList();

				} catch (Exception e1) {

					e1.printStackTrace();
				}

				/**********************************/
			}
		});
		addressListButton.setBounds(22, 200, 125, 23);
		addressListPanel.add(addressListButton);

		JScrollPane addressListScrollPane = new JScrollPane();
		addressListScrollPane.setBounds(12, 10, 359, 180);
		addressListPanel.add(addressListScrollPane);

		addressListTable = new JTable();
		addressListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				addressDeleteButton.setEnabled(true);
				
				
			}
		});
		addressListTable.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "\uBC88\uD638", "\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC8FC\uC18C" }));
		addressListScrollPane.setViewportView(addressListTable);
		
		addressDeleteButton = new JButton("선택된행삭제");
		addressDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					/*********테이블의선택된 row,column 얻기**********/
					int columnIndex=addressListTable.getSelectedColumn();
					int rowIndex=addressListTable.getSelectedRow();
					int selectAddressNo = (Integer)addressListTable.getValueAt(rowIndex, 0);
					/********** addressService.addressDelete(no)호출 ***************/
					int deleteRowCount = addressService.addressDelete(selectAddressNo);
					displayAddressList();
				}catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}
		});
		addressDeleteButton.setEnabled(false);
		addressDeleteButton.setBounds(218, 200, 125, 23);
		addressListPanel.add(addressDeleteButton);

		JPanel addressDetailPanel = new JPanel();
		addressDetailPanel.setLayout(null);
		addressTabbedPane.addTab("주소록상세보기", null, addressDetailPanel, null);

		JLabel detailNameLabel = new JLabel("이름");
		detailNameLabel.setBounds(78, 87, 57, 15);
		addressDetailPanel.add(detailNameLabel);

		JLabel detailPhoneLabel = new JLabel("전화번호");
		detailPhoneLabel.setBounds(78, 130, 57, 15);
		addressDetailPanel.add(detailPhoneLabel);

		JLabel detailAddressLabel = new JLabel("주소");
		detailAddressLabel.setBounds(78, 173, 57, 18);
		addressDetailPanel.add(detailAddressLabel);

		detailNameTextField = new JTextField();
		detailNameTextField.setEditable(false);
		detailNameTextField.setColumns(10);
		detailNameTextField.setBounds(210, 84, 116, 21);
		addressDetailPanel.add(detailNameTextField);

		detailPhoneTextField = new JTextField();
		detailPhoneTextField.setEditable(false);
		detailPhoneTextField.setColumns(10);
		detailPhoneTextField.setBounds(210, 127, 116, 21);
		addressDetailPanel.add(detailPhoneTextField);

		detailAddressTextField = new JTextField();
		detailAddressTextField.setEditable(false);
		detailAddressTextField.setColumns(10);
		detailAddressTextField.setBounds(210, 172, 116, 21);
		addressDetailPanel.add(detailAddressTextField);

		JButton addressDetailButton = new JButton("번호로찾기");
		addressDetailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/************** 주소록1개상세보기 ************/
				try {
					String noStr = detailNoTextField.getText();
					/************* 유효성체크 ***************/
					if (noStr == null || noStr.equals("")) {
						JOptionPane.showMessageDialog(null, "번호를 입력하세요");
						detailNoTextField.requestFocus();
						return;
					}
					
					/****** 문자를 int,double,boolean으로변경*********/
					int number=Integer.parseInt("2342342");
					double dnumber=Double.parseDouble("1.32154");
					boolean bool=Boolean.parseBoolean("true");
					
					int no = Integer.parseInt(noStr);
					/********** addressService.addressDetail(no)호출 ***************/
					Address findAddress=addressService.addressDetail(no);	
					if(findAddress!=null) {
						detailNoTextField2.setText(findAddress.getNo()+"");
						detailNameTextField.setText(findAddress.getName());
						detailPhoneTextField.setText(findAddress.getPhone());
						detailAddressTextField.setText(findAddress.getAddress());
						/***수정폼버튼활성화***/
						updateFormButton.setEnabled(true);
						
					}else {
						JOptionPane.showMessageDialog(null,"존재하지않는 주소입니다.");
						detailNoTextField2.setText("");
						detailNameTextField.setText("");
						detailPhoneTextField.setText("");
						detailAddressTextField.setText("");
						
						updateFormButton.setEnabled(false);
					}
					
					detailNoTextField.requestFocus();
					detailNoTextField.setSelectionStart(0);
					detailNoTextField.setSelectionEnd(noStr.length());
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				/*******************************************/
			}
		});
		addressDetailButton.setBounds(200, 10, 116, 23);
		addressDetailPanel.add(addressDetailButton);

		detailNoTextField = new JTextField();
		detailNoTextField.setBounds(131, 11, 57, 21);
		addressDetailPanel.add(detailNoTextField);
		detailNoTextField.setColumns(10);

		JLabel detailNoLabel = new JLabel("<html><b>번호입력:</b></html>");
		detailNoLabel.setBounds(68, 14, 57, 19);
		addressDetailPanel.add(detailNoLabel);

		JLabel detailNoLabel2 = new JLabel("번호");
		detailNoLabel2.setBounds(78, 49, 57, 15);
		addressDetailPanel.add(detailNoLabel2);

		detailNoTextField2 = new JTextField();
		detailNoTextField2.setEditable(false);
		detailNoTextField2.setColumns(10);
		detailNoTextField2.setBounds(210, 46, 116, 21);
		addressDetailPanel.add(detailNoTextField2);
		
		updateFormButton = new JButton("수정폼");
		updateFormButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***수정가능하도록 TextField를 활성화(Editable)시켜준다***/
				detailNoTextField2.setEditable(true);
				detailNameTextField.setEditable(true);
				detailPhoneTextField.setEditable(true);
				detailAddressTextField.setEditable(true);
			}
		});
		updateFormButton.setEnabled(false);
		updateFormButton.setBounds(88, 207, 97, 23);
		addressDetailPanel.add(updateFormButton);
		/********** 2.AddressService객체생성 **********/
		try {
			addressService=new AddressService();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		/******************************************/
	}// 생성자 끝
	
	/*********주소록리스트보여주기************/
	private void displayAddressList() {
		try {
			/********** addressService.addressList(no)호출 ***************/
			List<Address> addressList= addressService.addressList();
			Vector<String> columnVector=new Vector<String>();
			columnVector.add("번호");
			columnVector.add("이름");
			columnVector.add("전화번호");
			columnVector.add("주소");
			Vector tableVector=new Vector();
			for(Address address:addressList) {
			    Vector rowVector=new Vector();
				rowVector.add(address.getNo());
				rowVector.add(address.getName());
				rowVector.add(address.getPhone());
				rowVector.add(address.getAddress());
				tableVector.add(rowVector);
			}
			DefaultTableModel  tableModel = 
					new DefaultTableModel(tableVector,columnVector);
			
			addressListTable.setModel(tableModel);
			addressDeleteButton.setEnabled(false);
		} catch (Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "호갱님 죄송합니다.");
		}
		
	}
}//클래스끝
