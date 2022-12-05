package jframe;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO_VO.AccountDAO;
import DAO_VO.AccountVO;
import DAO_VO.TradeVO;

import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Deposit {

	JFrame frame;
	private JTextField textAccountNo;
	private JTextField textDeposit;
	private JPasswordField passwordField;
	private JTable table;
	boolean check = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public Deposit() {
		
		AccountDAO accountDAO = new AccountDAO();
		boolean accountCheck = false;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		// �Աݰ������� Ʋ
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		// �ܾ�Ȯ�� Ʋ
		JPanel pnlBalanceInfo = new JPanel();
		pnlBalanceInfo.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(pnlBalanceInfo);
		pnlBalanceInfo.setLayout(null);
		pnlBalanceInfo.setVisible(false);
		
		// �Աݰ�������
		JLabel lblDepositTitle = new JLabel("\uC785 \uAE08 \uACC4 \uC88C \uC815 \uBCF4");
		lblDepositTitle.setFont(new Font("����", Font.PLAIN, 20));
		lblDepositTitle.setBounds(139, 10, 156, 40);
		panel.add(lblDepositTitle);
		
		// �Ա� ���¹�ȣ
		JLabel lblAccountNo = new JLabel("\uC785\uAE08 \uACC4\uC88C\uBC88\uD638");
		lblAccountNo.setFont(new Font("����", Font.PLAIN, 15));
		lblAccountNo.setBounds(12, 65, 100, 20);
		panel.add(lblAccountNo);
		
		// ���¹�ȣ �Է�
		textAccountNo = new JTextField();
		textAccountNo.setFont(new Font("����", Font.PLAIN, 15));
		textAccountNo.setBounds(117, 65, 200, 20);
		panel.add(textAccountNo);
		textAccountNo.setColumns(10);
		
//		boolean accountCheck = false;
//		System.out.println(accountCheck);
		
		// ����Ȯ�� ��ư
		JButton btnAccountNo = new JButton("\uACC4\uC88C\uD655\uC778");
		// ����Ȯ�� ��ư Ŭ�� ��
		btnAccountNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountDAO accountDAO = new AccountDAO();
				AccountVO accountVO;
				boolean accountCheck = false;
				
				accountVO = accountDAO.read(textAccountNo.getText());
//				System.out.println(accountVO.toString());	// accountVO Ȯ��
				if(textAccountNo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "���¹�ȣ�� �Է����ּ���.");
				} else if(textAccountNo.getText().equals(accountVO.getAccountNo())) {	// ** �̺�Ʈó�� �ʿ� Ȯ�� ��� **
					check = true;
					JOptionPane.showMessageDialog(null, "���¹�ȣ�� Ȯ�εǾ����ϴ�.");
//					accountCheck = true;
				} else {
					JOptionPane.showMessageDialog(null, "�Է��Ͻ� ���¹�ȣ�� ������ �����ϴ�.\n ���¹�ȣ�� Ȯ�����ּ���.");
				}
			}
		});
		btnAccountNo.setFont(new Font("����", Font.PLAIN, 15));
		btnAccountNo.setBounds(322, 63, 100, 24);
		panel.add(btnAccountNo);
		
		// ���� ��й�ȣ
		JLabel lblAccountPass = new JLabel("\uACC4\uC88C \uBE44\uBC00\uBC88\uD638");
		lblAccountPass.setFont(new Font("����", Font.PLAIN, 15));
		lblAccountPass.setBounds(12, 110, 100, 20);
		panel.add(lblAccountPass);
		
		// ��й�ȣ �Է�
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("����", Font.PLAIN, 15));
		passwordField.setBounds(117, 110, 100, 20);
		panel.add(passwordField);
		
		// (���� 4�ڸ�)
		JLabel lblInfo = new JLabel("(\uC22B\uC790 4\uC790\uB9AC)");
		lblInfo.setFont(new Font("����", Font.PLAIN, 15));
		lblInfo.setBounds(222, 110, 90, 20);
		panel.add(lblInfo);
		
		// �ܾ�Ȯ�� ��ư
		JButton btnBalance = new JButton("\uC794\uC561\uD655\uC778");
		// �ܾ�Ȯ�� ��ư Ŭ�� ��
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecimalFormat dfWon = new DecimalFormat("#,###��");
				AccountDAO accountDAO = new AccountDAO();
				AccountVO accountVO;
				String balance;
				
				accountVO = accountDAO.read(textAccountNo.getText());
//				System.out.println(accountVO.toString());	// accountVO Ȯ��
				if(passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է����ּ���.");
				} else if(passwordField.getText().equals(accountVO.getPassword())) {
//					System.out.println(accountVO);	// accountVO Ȯ��
					// �ܾ�Ȯ�� �ŷ����� ���� ���
					String[] header = {"���¹�ȣ", "�ŷ�����", "�ŷ��ݾ�", "�ŷ���"};
					String[][] data = accountDAO.getTrade(textAccountNo.getText());
					
					table = new JTable(data, header);
					table.setAlignmentX(0);
					table.setPreferredScrollableViewportSize(new Dimension(434, 200));
					JScrollPane scrollPane = new JScrollPane(table);
					scrollPane.setBounds(0, 0, 434, 200);
					pnlBalanceInfo.add(scrollPane);
					
					accountVO = accountDAO.read(textAccountNo.getText());
					balance = dfWon.format(accountVO.getBalance());
//					System.out.println(balance);	// balance Ȯ��
					// �����ܾ� : #,###��
					JLabel lblBalance = new JLabel("\uD604\uC7AC\uC794\uC561 : " + balance);
					lblBalance.setFont(new Font("����", Font.PLAIN, 15));
					lblBalance.setBounds(12, 220, 300, 20);
					pnlBalanceInfo.add(lblBalance);
					
					panel.setVisible(false);
					pnlBalanceInfo.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�.\n��й�ȣ�� Ȯ�����ּ���.");
				}
			}
		});
		btnBalance.setFont(new Font("����", Font.PLAIN, 15));
		btnBalance.setBounds(322, 108, 100, 24);
		panel.add(btnBalance);
		
		// �ܾ�Ȯ�� Ȯ�� ��ư
		JButton btnBalanceChk = new JButton("\uD655\uC778");
		// �ܾ�Ȯ�� Ȯ�� ��ư Ŭ�� ��
		btnBalanceChk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				pnlBalanceInfo.setVisible(false);
			}
		});
		btnBalanceChk.setFont(new Font("����", Font.PLAIN, 15));
		btnBalanceChk.setBounds(323, 210, 100, 40);
		pnlBalanceInfo.add(btnBalanceChk);
		
		// �Ա� �ݾ�
		JLabel lblDeposit = new JLabel("\uC785\uAE08 \uAE08\uC561");
		lblDeposit.setFont(new Font("����", Font.PLAIN, 15));
		lblDeposit.setBounds(12, 155, 100, 20);
		panel.add(lblDeposit);
		
		// �Ա� �ݾ� �Է�
		textDeposit = new JTextField();
		textDeposit.setFont(new Font("����", Font.PLAIN, 15));
		textDeposit.setColumns(10);
		textDeposit.setBounds(117, 155, 200, 20);
		panel.add(textDeposit);
		
		// ��
		JLabel lblInfo2 = new JLabel("\uC6D0");
		lblInfo2.setFont(new Font("����", Font.PLAIN, 15));
		lblInfo2.setBounds(322, 155, 30, 20);
		panel.add(lblInfo2);
		
		// �Ա� ��ư
		JButton btnDeposit = new JButton("\uC785\uAE08");
		// �Ա� ��ư Ŭ�� ��
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecimalFormat dfWon = new DecimalFormat("#,###��");
				AccountVO accountVO;
				TradeVO tradeVO;
				
				accountVO = accountDAO.read(textAccountNo.getText());
				
				if(textAccountNo.getText().equals("") || check == false) {
					JOptionPane.showMessageDialog(null, "Ȯ�����ּ���.");
				} else if (textDeposit.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "�Ա� �ݾ��� Ȯ�����ּ���.");
				} else if(!passwordField.getText().equals(accountVO.getPassword())) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� Ʋ�Ƚ��ϴ�.\n��й�ȣ�� Ȯ�����ּ���.");
				} else {
					// �Ա� ���� ** Ȯ�ο��  �Աݾ� ���� �Ա� ��ư Ŭ���� �޽��� **
					int select = JOptionPane.showConfirmDialog(null, "�Ա��Ͻðڽ��ϱ�?", "�Ա�Ȯ��", JOptionPane.YES_NO_OPTION);
					
					
					if(select == JOptionPane.OK_OPTION) {
						String accountNo = textAccountNo.getText();
						int tradeBalance = Integer.valueOf(textDeposit.getText());
						
						tradeVO = new TradeVO();
						tradeVO.setAccountNo(accountNo);
						tradeVO.setTradeTypeNo("T01");
						tradeVO.setTradeBalance(tradeBalance);
						
						accountDAO.deposit(tradeVO);
						accountDAO.update(accountNo, tradeBalance);
						
						JOptionPane.showMessageDialog(null, "�Ա��� �Ϸ�Ǿ����ϴ�.");
						System.exit(0);
					} else if(select == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "�Ա��� ��ҵǾ����ϴ�.");
					}
				}
			}
		});
		
		btnDeposit.setFont(new Font("����", Font.PLAIN, 15));
		btnDeposit.setBounds(97, 210, 100, 40);
		panel.add(btnDeposit);
		
		// �Ա� ��� ��ư
		JButton btnCancel = new JButton("\uCDE8\uC18C");
		// �Ա� ��� ��ư Ŭ�� ��
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select = JOptionPane.showConfirmDialog(null, "�Ա��� ����Ͻðڽ��ϱ�?", "�Ա����", JOptionPane.YES_NO_OPTION);
				if(select == JOptionPane.OK_OPTION) {
					JOptionPane.showMessageDialog(null, "�Ա��� ��ҵǾ����ϴ�.");
					frame.setVisible(false);
					Main main = new Main();
				}
			}
		});
		btnCancel.setFont(new Font("����", Font.PLAIN, 15));
		btnCancel.setBounds(237, 210, 100, 40);
		panel.add(btnCancel);
	}
}