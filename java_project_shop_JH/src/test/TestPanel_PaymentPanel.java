package com.itwill.coffeecrew.shop.test.원주하;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import com.itwill.coffeecrew.shop.cart.Cart;
import com.itwill.coffeecrew.shop.cart.CartService;

import javax.swing.ImageIcon;
import java.awt.Point;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TestPanel_PaymentPanel extends JPanel {
	private JTextField payTextField;
	private JPanel payContentPanel;
	private JPanel paySouthPanel;

	/**
	 * Create the panel.
	 */
	public TestPanel_PaymentPanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 22));
		setBackground(new Color(255, 255, 255));
		setLayout(new BorderLayout(0, 0));
		
		JPanel payNothPanel = new JPanel();
		payNothPanel.setPreferredSize(new Dimension(300, 35));
		payNothPanel.setBackground(Color.WHITE);
		add(payNothPanel, BorderLayout.NORTH);
		payNothPanel.setLayout(new BorderLayout(0, 0));
		
		payTextField = new JTextField();
		payTextField.setEditable(false);
		payTextField.setText("결제하기");
		payTextField.setHorizontalAlignment(SwingConstants.CENTER);
		payTextField.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		payTextField.setColumns(10);
		payTextField.setBorder(null);
		payTextField.setBackground(Color.WHITE);
		payTextField.setAlignmentX(1.0f);
		payNothPanel.add(payTextField, BorderLayout.CENTER);
		
		paySouthPanel = new JPanel();
		paySouthPanel.setLayout(null);
		paySouthPanel.setPreferredSize(new Dimension(300, 120));
		paySouthPanel.setBackground(Color.WHITE);
		add(paySouthPanel, BorderLayout.SOUTH);
		
		JLabel payRequestLabel = new JLabel("요청 사항");
		payRequestLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		payRequestLabel.setBounds(32, 12, 78, 15);
		paySouthPanel.add(payRequestLabel);
		
		JButton payButton = new JButton("주문하기");
		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		payButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		payButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		payButton.setBorder(null);
		payButton.setBackground(Color.ORANGE);
		payButton.setBounds(119, 89, 97, 23);
		paySouthPanel.add(payButton);
		
		JTextField payRequestTextField = new JTextField();
		
	
		
		
		payRequestTextField.setForeground(Color.GRAY);
		payRequestTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		payRequestTextField.setText("얼음 많이 넣어주세요");
		payRequestTextField.setBounds(119, 9, 159, 21);
		paySouthPanel.add(payRequestTextField);
		payRequestTextField.setColumns(10);
		
		JComboBox payMtdComboBox = new JComboBox();
		payMtdComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		payMtdComboBox.setModel(new DefaultComboBoxModel(new String[] {"간편결제", "신용카드", "N pay"}));
		payMtdComboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		payMtdComboBox.setBounds(190, 56, 88, 23);
		paySouthPanel.add(payMtdComboBox);
		
		JPanel payCenterPanel = new JPanel();
		payCenterPanel.setPreferredSize(new Dimension(100, 100));
		add(payCenterPanel, BorderLayout.CENTER);
		payCenterPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane payContentScrollPane = new JScrollPane();
		payContentScrollPane.setPreferredSize(new Dimension(300, 300));
		payContentScrollPane.setBackground(Color.WHITE);
		payCenterPanel.add(payContentScrollPane);
		
		JPanel payContentMainPanel = new JPanel();
		payContentMainPanel.setPreferredSize(new Dimension(300, 600));
		payContentScrollPane.setViewportView(payContentMainPanel);
		payContentMainPanel.setLayout(new BorderLayout(0, 0));
		
		payContentPanel = new JPanel();
		payContentPanel.setBackground(Color.WHITE);
		payContentPanel.setPreferredSize(new Dimension(300, 10));
		payContentMainPanel.add(payContentPanel, BorderLayout.CENTER);
		payContentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel payItemPanel = new JPanel();
		payItemPanel.setBorder(null);
		payItemPanel.setLayout(null);
		payItemPanel.setPreferredSize(new Dimension(300, 70));
		payItemPanel.setBackground(Color.WHITE);
		payContentPanel.add(payItemPanel);
		
		JLabel payItemUnitPriceLabel = new JLabel(new DecimalFormat("#,###" + "원").format(1800));
		payItemUnitPriceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		payItemUnitPriceLabel.setBounds(101, 25, 57, 15);
		payItemPanel.add(payItemUnitPriceLabel);
		
		JLabel payItemTotPriceLabel = new JLabel(new DecimalFormat("#,###" + "원").format(3600));
		payItemTotPriceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		payItemTotPriceLabel.setBounds(235, 25, 53, 15);
		payItemPanel.add(payItemTotPriceLabel);
		
		JLabel payItemImageLabel = new JLabel("아이스아메리카노");
		payItemImageLabel.setIcon(new ImageIcon(TestPanel_PaymentPanel.class.getResource("/image/(ICE)아메리카노(50).jpg")));
		payItemImageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		payItemImageLabel.setPreferredSize(new Dimension(60, 60));
		payItemImageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		payItemImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		payItemImageLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		payItemImageLabel.setBounds(0, 0, 89, 70);
		payItemPanel.add(payItemImageLabel);
		
		JLabel payItemQty = new JLabel(new DecimalFormat("#,###").format(2));
		payItemQty.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		payItemQty.setBounds(184, 25, 20, 15);
		payItemPanel.add(payItemQty);
		
		JLabel payMarginLabel = new JLabel("");
		payMarginLabel.setPreferredSize(new Dimension(300, 3));
		payContentPanel.add(payMarginLabel);
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(300, 2));
		separator.setForeground(Color.GRAY);
		payContentPanel.add(separator);
		
		JPanel payListPanel = new JPanel();
		payListPanel.setBackground(Color.ORANGE);
		payListPanel.setPreferredSize(new Dimension(300, 20));
		payCenterPanel.add(payListPanel, BorderLayout.NORTH);
		payListPanel.setLayout(null);
		
		JLabel payListLabel = new JLabel("주문내역");
		payListLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		payListLabel.setBounds(0, 2, 74, 15);
		payListPanel.add(payListLabel);
		
		try {
			displayPayList();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		

	}
	
	public void displayPayList() throws Exception {
		CartService cartService = new CartService();
		payContentPanel.removeAll();
		int payTotAmount=0;
		List<Cart> cartList = cartService.getCartItemByUserId("kim1");
		for (Cart cart : cartList) {
			
			JPanel payItemPanel = new JPanel();
			
			payItemPanel.setBorder(null);
			payItemPanel.setLayout(null);
			payItemPanel.setPreferredSize(new Dimension(300, 70));
			payItemPanel.setBackground(Color.WHITE);
			payContentPanel.add(payItemPanel);
			
			payItemPanel.setLayout(null);
			
			JLabel payItemUnitPriceLabel = new JLabel(new DecimalFormat("#,###" + "원").format(cart.getProduct().getPPrice()));
			payItemUnitPriceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			payItemUnitPriceLabel.setBounds(101, 25, 57, 15);
			payItemPanel.add(payItemUnitPriceLabel);
			
			JLabel payItemTotPriceLabel = new JLabel(new DecimalFormat("#,###" + "원").format(cart.getProduct().getPPrice()*cart.getCQty()));
			payItemTotPriceLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			payItemTotPriceLabel.setBounds(235, 25, 53, 15);
			payItemPanel.add(payItemTotPriceLabel);
			
			JLabel payItemImageLabel = new JLabel(cart.getProduct().getPImage());
			//payItemImageLabel.setIcon(new ImageIcon(TestPanel_PaymentPanel.class.getResource("/productImage/size50/"+cart.getProduct().getPName()+"(50).jpg")));
			payItemImageLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
			payItemImageLabel.setPreferredSize(new Dimension(60, 60));
			payItemImageLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			payItemImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			payItemImageLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
			payItemImageLabel.setBounds(0, 0, 89, 70);
			payItemPanel.add(payItemImageLabel);
			
			
			JLabel payItemQty = new JLabel(String.valueOf(cart.getCQty()));
			payItemQty.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			payItemQty.setBounds(184, 25, 20, 15);
			payItemPanel.add(payItemQty);
			
			payContentPanel.add(payItemPanel);
			
			JLabel payMarginLabel = new JLabel("");
			payMarginLabel.setPreferredSize(new Dimension(300, 3));
			payContentPanel.add(payMarginLabel);
			
			JSeparator separator = new JSeparator();
			separator.setPreferredSize(new Dimension(300, 2));
			separator.setForeground(Color.GRAY);
			payContentPanel.add(separator);
			
			payTotAmount+=cart.getProduct().getPPrice()*cart.getCQty();
			
		}
		paySouthPanel.removeAll();
		
		JLabel payTotPriceLabel = new JLabel(new DecimalFormat("#,###" + "원").format(payTotAmount));
		payTotPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		payTotPriceLabel.setForeground(Color.BLACK);
		payTotPriceLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		payTotPriceLabel.setBounds(180, 37, 98, 15);
		paySouthPanel.add(payTotPriceLabel);
		
		JLabel payDescLabel = new JLabel("결제 금액");
		payDescLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		payDescLabel.setBounds(32, 37, 78, 15);
		paySouthPanel.add(payDescLabel);
		
		JLabel payMtdLabel = new JLabel("결제 수단");
		payMtdLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		payMtdLabel.setBounds(32, 62, 78, 15);
		paySouthPanel.add(payMtdLabel);
			
		JComboBox payMtdComboBox = new JComboBox();
		payMtdComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		payMtdComboBox.setModel(new DefaultComboBoxModel(new String[] {"간편결제", "신용카드", "N pay"}));
		payMtdComboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		payMtdComboBox.setBounds(190, 56, 88, 23);
		paySouthPanel.add(payMtdComboBox);	
			
		JButton payButton = new JButton("주문하기");
		payButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		payButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		payButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		payButton.setBorder(null);
		payButton.setBackground(Color.ORANGE);
		payButton.setBounds(119, 89, 97, 23);
		paySouthPanel.add(payButton);
		
		
		JLabel payRequestLabel = new JLabel("요청 사항");
		payRequestLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		payRequestLabel.setBounds(32, 12, 78, 15);
		paySouthPanel.add(payRequestLabel);
		
		
		
		
		JTextField payRequestTextField = new JTextField();
		payRequestTextField.setText("얼음 많이 넣어주세요");
		payRequestTextField.setForeground(Color.GRAY);
		
		/*payRequestTextField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				payRequestTextField.setText("");
		        payRequestTextField.setForeground(Color.BLACK);  // 클릭 시 폰트 색상 변경
		        
			}
		});*/
		
		 payRequestTextField.addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                if (payRequestTextField.getText().equals("얼음 많이 넣어주세요")) {
	                    payRequestTextField.setText("");
	                    payRequestTextField.setForeground(Color.BLACK);
	                }
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                if (payRequestTextField.getText().isEmpty()) {
	                    payRequestTextField.setText("얼음 많이 넣어주세요");
	                    payRequestTextField.setForeground(Color.GRAY);
	                }
	            }
	        });
		
		
		payRequestTextField.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		payRequestTextField.setBounds(119, 9, 159, 21);
		paySouthPanel.add(payRequestTextField);
		payRequestTextField.setColumns(10);
		
	}		
		
	}
	
	

