package com.itwill

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.Icon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class CoffeeCrewMainFrame extends JFrame {
	
	/*********로그인한 Member 객체 멤버필드 선언*********/
	
	/*로그인한 멤버 객체 , 주문중인 order 객체 멤버필드 선언*/
	Member loginMember = null;
	
    Order tempOder = null;
    

    /****2.패널 상수 선언****/
	public static int TOP_SHOP_MAIN_PANEL=0;
	public static int TOP_SHOP_MEMBER_PANEL=1;
	public static int TOP_SHOP_PRODUCT_PANEL=2;
	public static int TOP_SHOP_ORDER_PANEL=3;
	public static int TOP_SHOP_REVIEW_PANEL=4;
	public static int TOP_SHOP_CS_PANEL=5;
	
	
	
	public static int SUB_MEMBER_LOGIN_PANEL=11;
	public static int SUB_MEMBER_JOIN_PANEL=12;
	public static int SUB_MEMBER_INFO_PANEL=13;
	
	public static int SUB_PRODUCT_LIST_PANEL=21;
	public static int SUB_PRODUCT_DETAIL_PANEL=22;
	
	
	// tabbedpane 은 전역에 올라와야함, 붙은 패널도 필요에 따라 올라올 수 잇음
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/********* 1.CoffeeCrewService멤버필드선언(member, product, order, cart) *****/
	// private MemberService memberService;
	// private productService memberService;
	// private orderService memberService;
	// private cartService memberService;
	
	/***** 로그인한 member 객체저장할 Member객체선언 **********/
	// private Member loginMember = null;

	private JPanel contentPane;
	private JMenuItem joinMenuItem;
	private JMenuItem loginMenuItem;
	private JMenuItem logoutMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeCrewMainFrame frame = new CoffeeCrewMainFrame();
					frame.setVisible(true);
					frame.changePnel()
					//최초에 체인지 쓸 경우 기입해줘야함
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}//생성자 끝

	
	
	/**화면전환 메소드***/
	public void changePanel(int top, int sub, HashMap date) {
		
	if (top=TOP_SHOP_MAIN_PANEL) {
		
		
		
		
	} else if(top=TOP_SHOP_MEMBER_PANEL){
		
		shopTabbedPane.setSeletedIndex(TOP_SHOP_MAIN_PANEL);
		userTabbePane.setSeletedIndex(sub);

	}else if(top=TOP_SHOP_MEMBER_PANEL){

	}else if(top=TOP_SHOP_PRODUCT_PANEL){

	}
	
	
		
		public static int TOP_SHOP_MAIN_PANEL=0;
		public static int TOP_SHOP_MEMBER_PANEL=1;
		public static int TOP_SHOP_PRODUCT_PANEL=2;
		public static int TOP_SHOP_ORDER_PANEL=3;
		public static int TOP_SHOP_REVIEW_PANEL=4;
		public static int TOP_SHOP_CS_PANEL=5;
		
	}
	
	changePanel(TOP_SHOP_MEMBER_PANEL,SUB_MEMBER_JOIN_PANEL,null);
	
	
	/**
	 * Create the frame.
	 */
	public CoffeeCrewMainFrame() {
		setTitle("Coffee Crew");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CoffeeCrewMainFrame.class.getResource("/image/title_logo_25.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 643);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(253, 236, 166));
		setJMenuBar(menuBar);
		
		JMenu tabMenu = new JMenu("");
		tabMenu.setIcon(new ImageIcon(CoffeeCrewMainFrame.class.getResource("/image/menu_20.png")));
		menuBar.add(tabMenu);
		
		loginMenuItem = new JMenuItem("로그인");
		loginMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//로그인화면
				//memberTabbedPane.setSelectedIndex(1);
			}
		});
		tabMenu.add(loginMenuItem);
		
		joinMenuItem = new JMenuItem("회원가입");
		joinMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//회원가입화면
				//memberTabbedPane.setSelectedIndex(2);
			}
		});
		tabMenu.add(joinMenuItem);
		
		logoutMenuItem = new JMenuItem("로그아웃");
		logoutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//로그아웃시 로그인화면
				//memberTabbedPane.setSelectedIndex(1);
			}
		});
		tabMenu.add(logoutMenuItem);
		
		JSeparator separator = new JSeparator();
		tabMenu.add(separator);
		
		JMenuItem exitMenuItem = new JMenuItem("종료");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//애플리케이션 종료
				System.exit(0);
			}
		});
		tabMenu.add(exitMenuItem);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(10, 600));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane shopTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		shopTabbedPane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		contentPane.add(shopTabbedPane, BorderLayout.CENTER);
		
		JPanel memberPanel = new JPanel();
		memberPanel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		memberPanel.setName("");
		memberPanel.setToolTipText("");
		shopTabbedPane.addTab("회원", null, memberPanel, null);
		memberPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		memberTabbedPane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		memberTabbedPane.setBackground(new Color(240, 240, 240));
		memberPanel.add(memberTabbedPane, BorderLayout.CENTER);
		
		JPanel memberMainPanel = new JPanel();
		memberMainPanel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		memberMainPanel.setPreferredSize(new Dimension(200, 600));
		memberMainPanel.setBackground(new Color(240, 240, 240));
		memberMainPanel.setToolTipText("");
		memberTabbedPane.addTab("메인", (Icon) null, memberMainPanel, null);
		memberMainPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel memberMainLabel = new JLabel("");
		memberMainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		memberMainLabel.setIcon(new ImageIcon(CoffeeCrewMainFrame.class.getResource("/image/main_380_450.jpg")));
		memberMainPanel.add(memberMainLabel, BorderLayout.CENTER);
		
		JPanel memberLoginPanel = new JPanel();
		memberLoginPanel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		memberTabbedPane.addTab("로그인", null, memberLoginPanel, null);
		
		JPanel memberJoinPanel = new JPanel();
		memberJoinPanel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		memberTabbedPane.addTab("회원가입", null, memberJoinPanel, null);
		
		JPanel memberInfoPanel = new JPanel();
		memberInfoPanel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		memberTabbedPane.addTab("회원정보수정", null, memberInfoPanel, null);
		
		JPanel memberFindPanel = new JPanel();
		memberFindPanel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		memberTabbedPane.addTab("아이디/비밀번호찾기", null, memberFindPanel, null);
		
		JPanel productPanel = new JPanel();
		shopTabbedPane.addTab("상품", null, productPanel, null);
		productPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane productTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		productPanel.add(productTabbedPane, BorderLayout.CENTER);
		
		JPanel productListPanel = new JPanel();
		productTabbedPane.addTab("전체상품", null, productListPanel, null);
		productListPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel productDetailPanel = new JPanel();
		productTabbedPane.addTab("상품상세", null, productDetailPanel, null);
		productDetailPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel orderPanel = new JPanel();
		shopTabbedPane.addTab("주문", null, orderPanel, null);
		orderPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane orderTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		orderPanel.add(orderTabbedPane, BorderLayout.CENTER);
		
		JPanel orderHistoryPanel = new JPanel();
		orderTabbedPane.addTab("주문내역", null, orderHistoryPanel, null);
		
		JPanel orderDetailPanel = new JPanel();
		orderTabbedPane.addTab("주문상세", null, orderDetailPanel, null);
		
		JPanel orderPaymentPanel = new JPanel();
		orderTabbedPane.addTab("결제하기", null, orderPaymentPanel, null);
		
		JPanel cartListPanel = new JPanel();
		orderTabbedPane.addTab("장바구니", null, cartListPanel, null);
		
		JPanel logoPanel = new JPanel();
		FlowLayout fl_logoPanel = (FlowLayout) logoPanel.getLayout();
		fl_logoPanel.setVgap(-25);
		fl_logoPanel.setHgap(1);
		logoPanel.setBackground(new Color(253, 236, 166));
		contentPane.add(logoPanel, BorderLayout.NORTH);
		
		JLabel logoLabel = new JLabel("");
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoLabel.setIcon(new ImageIcon(CoffeeCrewMainFrame.class.getResource("/image/coffeecrew_logo_yellow.png")));
		logoPanel.add(logoLabel);
		
		/********* 2.CoffeeCrewService멤버필드객체생성(member, product, order, cart) *****/
		
		//memberService = new MemberService();
		//productService = new ProductService();
		//orderService = new OrderService();
		//cartService = new CartService();
		
		/******최초실행시 로그아웃상태로변경******/
		//logoutProcess();
		
	}// 생성자끝
	
	/*
	 * private void displayMemberList() {
	 * 
	 * 
	 * try { /***************회원리스트보기[JTable]*********** List<Member> memberList =
	 * memberService.memberList(); Vector columnVector = new Vector();
	 * columnVector.add("아이디"); columnVector.add("패쓰워드"); columnVector.add("이름");
	 * columnVector.add("주소"); columnVector.add("나이"); columnVector.add("결혼");
	 * columnVector.add("가입일");
	 * 
	 * Vector tableVector = new Vector(); for (Member member : memberList) { Vector
	 * rowVector = new Vector(); rowVector.add(member.getMemberId());
	 * rowVector.add(member.getMemberPassword());
	 * rowVector.add(member.getMemberName());
	 * rowVector.add(member.getMemberAddress());
	 * rowVector.add(member.getMemberAge());
	 * rowVector.add(member.getMemberMarried());
	 * rowVector.add(member.getMemberRegdate()); tableVector.add(rowVector); }
	 * 
	 * DefaultTableModel tableModel = new DefaultTableModel(tableVector,
	 * columnVector);
	 * 
	 * adminMemberListTable.setModel(tableModel);
	 * 
	 * } catch (Exception e1) { System.out.println("회원리스트보기에러-->" +
	 * e1.getMessage()); } }
	 * 
	 *//************* 회원수정폼활성화 불활성화 ****************/
	/*
	 * private void updateFormEnable(boolean b) { infoNameTF.setEditable(b);
	 * infoAddressTF.setEditable(b); infoAgeComboBox.setEnabled(b);
	 * infoMarriedCheckBox.setEnabled(b); updateBtn.setEnabled(b); }
	 * 
	 * 
	 *//************** 로그아웃시 호출할메쏘드 ***************/
	/*
	 * private void logoutProcess() {
	 *//***********
		 * 로그아웃시 해야할일*********** 1.로그인성공한 멤버객체 멤버필드에서제거 2.MemberMainFrame타이틀변경
		 * 3.로그인,회원가입탭 활성화,회원정보탭 불활성화 로그인,회원가입 메뉴아이템 활성화 로그아웃 메뉴아이템 불활성화 4.메인 화면전환
		 ********************************************/
	/*
	 * this.loginMember = null; setTitle("회원관리"); memberTabbedPane.setEnabledAt(1,
	 * true); //로그인탭 활성화 memberTabbedPane.setEnabledAt(2, true); //회원가입탭 활성화
	 * memberTabbedPane.setEnabledAt(3, false); //회원정보탭 불활성화
	 * memberTabbedPane.setEnabledAt(4, false);
	 * 
	 * loginMenuItem.setEnabled(true); //로그인 메뉴아이템 활성화
	 * joinMenuItem.setEnabled(true); //회원가입 메뉴아이템 활성화
	 * logoutMenuItem.setEnabled(false); //로그아웃 메뉴아이템 불활성화
	 * 
	 * memberTabbedPane.setSelectedIndex(0); }
	 * 
	 *//************** 로그인성공시 호출할메쏘드 ***************/
	/*
	 * void loginProcess(Member loginMember) throws Exception {
	 *//***********
		 * 로그인성공시 해야할일*********** 1.로그인성공한 멤버객체 멤버필드에저장 2.MemberMainFrame타이틀변경
		 * 3.로그인,회원가입탭 불활성화 회원정보 탭 활성화 로그인,회원가입 메뉴아이템 불활성화 로그아웃 메뉴아이템 활성화 4.회원정보보기 화면전환
		 ********************************************/
	/*
	 * this.loginMember = loginMember; //1번작업 setTitle(loginMember.getMemberName() +
	 * " 님 로그인"); //2번작업 if(this.loginMember.getMemberId().equals("admin")) {
	 * memberTabbedPane.setEnabledAt(1, false); memberTabbedPane.setEnabledAt(2,
	 * false); memberTabbedPane.setEnabledAt(3, true);
	 * memberTabbedPane.setEnabledAt(4, true); loginMenuItem.setEnabled(false);
	 * joinMenuItem.setEnabled(false); logoutMenuItem.setEnabled(true);
	 * memberTabbedPane.setSelectedIndex(4); } else {
	 * memberTabbedPane.setEnabledAt(1, false); //3번작업, 로그인탭 불활성화
	 * memberTabbedPane.setEnabledAt(2, false); //3번작업, 회원가입탭 불활성화
	 * memberTabbedPane.setEnabledAt(3, true); //3번작업, 회원정보탭 불활성화
	 * loginMenuItem.setEnabled(false); //3번작업, 로그인 메뉴아이템 불활성화
	 * joinMenuItem.setEnabled(false); //3번작업, 회원가입 메뉴아이템 불활성화
	 * logoutMenuItem.setEnabled(true); //3번작업, 로그아웃 메뉴아이템 활성화
	 * memberTabbedPane.setSelectedIndex(3); }
	 * 
	 * }
	 * 
	 * private void displayMemberInfo(Member member) {
	 *//**** 로그인한회원상세데이타보여주기 *****/
	/*
	 * infoIdTF.setText(member.getMemberId());
	 * infoPassTF.setText(member.getMemberPassword());
	 * infoNameTF.setText(member.getMemberName());
	 * infoAddressTF.setText(member.getMemberAddress());
	 * infoAgeComboBox.setSelectedItem(member.getMemberAge() + ""); if
	 * (member.getMemberMarried() == "T") { infoMarriedCheckBox.setSelected(true); }
	 * else { infoMarriedCheckBox.setSelected(false); }
	 * infoMarriedCheckBox.setSelected(member.getMemberMarried().equals("T")?
	 * true:false); }
	 */

}// 클래스끝



