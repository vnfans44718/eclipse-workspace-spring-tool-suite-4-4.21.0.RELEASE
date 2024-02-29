

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.itwill.coffeecrew.shop.cart.Cart;
import com.itwill.coffeecrew.shop.cart.CartService;
import com.itwill.coffeecrew.shop.member.Member;
import com.itwill.coffeecrew.shop.order.OrderService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.PublicKey;

public class TestPanel_cartPanel extends JPanel {
	/**************************************************/
	private JTextField cartTextField;
	private JPanel cartContentPanel;
	
	private JFrame mainTestFrame;
	private JPanel cartSouthPanel;
	private JPanel cartNothPanel;



	public TestPanel_cartPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 22));
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBorder(new LineBorder(new Color(255, 0, 51)));
		add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("djkflasjf");
		btnNewButton_1_1.setBorder(new LineBorder(new Color(255, 0, 51)));
		add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("New button");
		btnNewButton_1_2.setBorder(new LineBorder(new Color(255, 0, 51)));
		add(btnNewButton_1_2);

		JButton btnNewButton_1_2_1 = new JButton("New button");
		btnNewButton_1_2_1.setBorder(new LineBorder(new Color(255, 0, 51)));
		add(btnNewButton_1_2_1);

		cartNothPanel = new JPanel();
		cartNothPanel.setPreferredSize(new Dimension(300, 35));
		cartNothPanel.setBackground(Color.WHITE);
		add(cartNothPanel, BorderLayout.NORTH);
		cartNothPanel.setLayout(new BorderLayout(0, 0));

		cartTextField = new JTextField();
		cartTextField.setEditable(false);
		cartTextField.setAlignmentX(1.0f);
		cartTextField.setBackground(Color.WHITE);
		cartTextField.setBorder(null);
		cartTextField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		cartTextField.setHorizontalAlignment(SwingConstants.CENTER);
		cartTextField.setText("        장바구니");
		cartNothPanel.add(cartTextField, BorderLayout.CENTER);
		cartTextField.setColumns(10);
		
		JButton cartTrashButton = new JButton("");
		cartTrashButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					CartService cartService = new CartService();
					cartService.deleteCartItemByUserId("kim1");
					JOptionPane.showMessageDialog(null, "제품이 모두 삭제되었습니다.");
					displayCartList();
					//왔다갔다
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
	
	
		cartTrashButton.setBorderPainted(false);
		cartTrashButton.setForeground(Color.WHITE);
		cartTrashButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartTrashButton.setBackground(Color.WHITE);
		cartTrashButton.setIcon(new ImageIcon(TestPanel_cartPanel.class.getResource("/image/cart-menu-trashcan(32).png")));
		cartNothPanel.add(cartTrashButton, BorderLayout.EAST);


		

	
		
		
		
		cartSouthPanel = new JPanel();
		cartSouthPanel.setBackground(Color.WHITE);
		cartSouthPanel.setPreferredSize(new Dimension(300, 50));
		add(cartSouthPanel, BorderLayout.SOUTH);
		cartSouthPanel.setLayout(null);

		//하단 주문 시작
		JLabel cartTotPrice = new JLabel("총 상품 금액");
		cartTotPrice.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		cartTotPrice.setBounds(16, 5, 78, 15);
		cartSouthPanel.add(cartTotPrice);

		JLabel cartTotPriceLabel = new JLabel(new DecimalFormat("#,###" + "원").format(0));
		cartTotPriceLabel.setForeground(Color.BLUE);
		cartTotPriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		cartTotPriceLabel.setBounds(19, 25, 75, 15);
		cartSouthPanel.add(cartTotPriceLabel);
		
		

		JButton cartOrderButton = new JButton("주문하기");
		
		cartOrderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartOrderButton.setBorder(null);
		cartOrderButton.setBackground(Color.ORANGE);
		cartOrderButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		cartOrderButton.setBounds(210, 13, 97, 23);
		cartSouthPanel.add(cartOrderButton);

		

		JPanel cartCenterPanel = new JPanel();
		add(cartCenterPanel, BorderLayout.CENTER);
		cartCenterPanel.setLayout(new BorderLayout(0, 0));

		JScrollPane cartContentScrollPane = new JScrollPane();
		cartContentScrollPane.setBackground(new Color(255, 255, 255));
		cartCenterPanel.add(cartContentScrollPane, BorderLayout.CENTER);

		/************ 카트 콘텐츠 패널 *************/
		cartContentPanel = new JPanel();
		cartContentPanel.setBackground(new Color(255, 255, 255));
		cartContentPanel.setPreferredSize(new Dimension(300, 600));
		cartContentScrollPane.setViewportView(cartContentPanel);
		cartContentPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel cartMarginLabel = new JLabel("");
		cartMarginLabel.setPreferredSize(new Dimension(300, 15));
		cartContentPanel.add(cartMarginLabel);

		// 카트 아이템 패널
		JPanel cartItemPanel = new JPanel();
		cartItemPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		cartItemPanel.setBackground(new Color(255, 255, 255));
		cartItemPanel.setPreferredSize(new Dimension(300, 70));
		/********* 제품 패널 ***********/
		cartContentPanel.add(cartItemPanel);
		cartItemPanel.setLayout(null);

		JLabel cartItemUnitPriceLabel = new JLabel(new DecimalFormat("#,###" + "원").format(1800));
		cartItemUnitPriceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		cartItemUnitPriceLabel.setBounds(88, 25, 57, 15);
		cartItemPanel.add(cartItemUnitPriceLabel);

		final JLabel cartItemTotPriceLabel = new JLabel(new DecimalFormat("#,###" + "원").format(3600));
		cartItemTotPriceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		cartItemTotPriceLabel.setBounds(204, 25, 53, 15);
		cartItemPanel.add(cartItemTotPriceLabel);

		JButton cartItemDeleteButton = new JButton("");
		cartItemDeleteButton.setBorder(null);
		cartItemDeleteButton
				.setIcon(new ImageIcon(TestPanel_cartPanel.class.getResource("/image/cart-fuction-delete.png")));
		cartItemDeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cartItemDeleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cartItemDeleteButton.setBackground(Color.WHITE);
		cartItemDeleteButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		cartItemDeleteButton.setBounds(257, 16, 39, 33);
		cartItemPanel.add(cartItemDeleteButton);

		JComboBox cartItemComboBox = new JComboBox();
		cartItemComboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		cartItemComboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		cartItemComboBox.setBounds(152, 21, 39, 23);
		cartItemPanel.add(cartItemComboBox);
		
		
		

		JLabel cartItemImageLabel = new JLabel("아이스아메리카노");
		cartItemImageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		cartItemImageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		cartItemImageLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		cartItemImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cartItemImageLabel.setPreferredSize(new Dimension(60, 60));
		cartItemImageLabel.setIcon(new ImageIcon(TestPanel_cartPanel.class.getResource("/productImage/size50/카페라떼ICE(50).jpg")));
		
		cartItemImageLabel.setBounds(0, 0, 86, 70);
		cartItemPanel.add(cartItemImageLabel);

		JLabel cartMarginLabel_1 = new JLabel("");
		cartMarginLabel_1.setPreferredSize(new Dimension(300, 15));
		cartContentPanel.add(cartMarginLabel_1);
		
	
		

		try {
			displayCartList();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}// 생성자 끝

	/**********
	 * 로그인 유저의 카트리스트 보여주기
	 * 
	
	 *******/

	public void createOderItemList () {
		
		for
		
		
	}
	
	
	
	
	public void displayCartList() throws Exception {
		CartService cartService = new CartService();
		int cartTotAmount=0;
		cartContentPanel.removeAll();
		cartSouthPanel.removeAll();
		
		JLabel cartMarginLabel = new JLabel("");
		cartMarginLabel.setPreferredSize(new Dimension(300, 15));
		cartContentPanel.add(cartMarginLabel);

		Member member = Member.builder().id("kim1").build();
		
		List<Cart> cartList = cartService.getCartItemByUserId(member.getId());

		for (Cart cart : cartList) {
			// 카트 아이템 1개의 형태
			JPanel cartItemPanel = new JPanel();
			cartItemPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
			cartItemPanel.setBackground(new Color(255, 255, 255));
			cartItemPanel.setPreferredSize(new Dimension(300, 70));
			/********* 제품 패널 ***********/
			cartContentPanel.add(cartItemPanel);
			cartItemPanel.setLayout(null);
			
			JLabel cartItemUnitPriceLabel = new JLabel(new DecimalFormat("#,###" + "원").format(cart.getProduct().getPPrice()));
			cartItemUnitPriceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			cartItemUnitPriceLabel.setBounds(88, 25, 57, 15);
			cartItemPanel.add(cartItemUnitPriceLabel);

			JLabel cartItemTotPriceLabel = new JLabel(new DecimalFormat("#,###" + "원").format(cart.getProduct().getPPrice()*cart.getCQty()));
			cartItemTotPriceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			cartItemTotPriceLabel.setBounds(204, 25, 53, 15);
			cartItemPanel.add(cartItemTotPriceLabel);
			
			JButton cartItemDeleteButton = new JButton("");
			cartItemDeleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			
			cartItemDeleteButton.addActionListener(new ActionListener() {
				
				//임시
				Cart c = cart;
				JPanel cPanel = cartItemPanel;
				
				
				public void actionPerformed(ActionEvent e) {
					
				try {
					int deleteCartItemCount = cartService.deleteCartItemByCartNo(c.getCNo());
					JOptionPane.showMessageDialog(null, deleteCartItemCount + "개의 제품이 삭제되었습니다.");
					//카트리스트 보여주기(?)
					displayCartList();
					//왔다갔다
					//orderTappedPane.setseletedIndex(4);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				
					
				}
			});
			
			
			cartItemDeleteButton.setBorder(null);
			cartItemDeleteButton.setBackground(Color.WHITE);
			cartItemDeleteButton
					.setIcon(new ImageIcon(TestPanel_cartPanel.class.getResource("/image/cart-fuction-delete.png")));
			cartItemDeleteButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			cartItemDeleteButton.setBounds(257, 16, 39, 33);
			cartItemPanel.add(cartItemDeleteButton);
			
			
			
			JComboBox cartItemComboBox = new JComboBox();
			cartItemComboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			cartItemComboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
			cartItemComboBox.setBounds(152, 21, 39, 23);
			cartItemComboBox.setSelectedItem(cart.getCQty() + "");
			cartItemPanel.add(cartItemComboBox);
			
			
			cartItemComboBox.addItemListener(new ItemListener() {
				private Cart c = cart;

				public void itemStateChanged(ItemEvent e) {
					/*** 수량변경시 선택될때마다호출 ***/
					if (e.getStateChange() == ItemEvent.SELECTED) {
						/**************** 카트수량수정 ******************/
						try {
							String cartSelectedQtyStr = (String) cartItemComboBox.getSelectedItem();
							int cartSelectedQty = Integer.parseInt(cartSelectedQtyStr);
							int updateCartCount = cartService.updateCart(c.getCNo(), cartSelectedQty);
							// 카트아이템총가격변경
						
							
							
							cartItemTotPriceLabel.setText(
									new DecimalFormat("#,###").format(c.getProduct().getPPrice() * cartSelectedQty));
							
							//orderTappedPane.setseletedIndex(4);
							displayCartList();
							
							

						} catch (Exception ex) {
							ex.printStackTrace();
						}
						/**********************************************/
					}
				}
			});
			
			

			JLabel cartItemImageLabel = new JLabel(cart.getProduct().getPImage());
			cartItemImageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
			cartItemImageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			cartItemImageLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
			cartItemImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			cartItemImageLabel.setPreferredSize(new Dimension(60, 60));
			//cartItemImageLabel.setIcon(new ImageIcon(TestPanel_cartPanel.class.getResource("/productImage/size50/"+cart.getProduct().getPName()+"(50).jpg")));
			
			cartItemImageLabel.setBounds(0, 0, 86, 70);
			cartItemPanel.add(cartItemImageLabel);
			
			cartContentPanel.add(cartItemPanel);

			JLabel cartMarginLabel_1 = new JLabel("");
			cartMarginLabel_1.setPreferredSize(new Dimension(300, 15));
			cartContentPanel.add(cartMarginLabel_1);
			
			
			cartTotAmount+=cart.getProduct().getPPrice()*cart.getCQty();
			
			
			
		}
			
			/*************************************************/
		
		JLabel cartTotPriceLabel = new JLabel(new DecimalFormat("#,###" + "원").format(cartTotAmount));
		cartTotPriceLabel.setForeground(Color.BLUE);
		cartTotPriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		cartTotPriceLabel.setBounds(19, 25, 75, 15);
		cartSouthPanel.add(cartTotPriceLabel);
		

	
	
		
		JLabel cartTotPrice = new JLabel("총 상품 금액");
		cartTotPrice.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		cartTotPrice.setBounds(16, 5, 78, 15);
		cartSouthPanel.add(cartTotPrice);
		

			JButton cartOrderButton = new JButton("주문하기");
			cartOrderButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			cartOrderButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				
					//orderTappedPane.setseletedIndex(5);
					//displayPayList();
					
				}
			});
			cartOrderButton.setBorder(null);
			cartOrderButton.setBackground(Color.ORANGE);
			cartOrderButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
			cartOrderButton.setBounds(210, 13, 97, 23);
			cartSouthPanel.add(cartOrderButton);
		
			
			
	}
	
	return
}// 끝
