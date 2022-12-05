package jframe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import DAO_VO.AccountDAO;
import DAO_VO.AccountInfoDAO;
import DAO_VO.AccountInfoVO;
import DAO_VO.PasswordDAO;
import DAO_VO.PasswordVO;
import DAO_VO.TradeDAO;
import DAO_VO.TradeVO;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class read extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public read(PasswordVO vo) {
		DecimalFormat df = new DecimalFormat("��0,000��");
		
		AccountInfoDAO idao = new AccountInfoDAO();
		AccountInfoVO ivo = new AccountInfoVO();
		AccountDAO accountDAO = new AccountDAO();
		TradeDAO tdao = new TradeDAO();
		ArrayList<TradeVO> array= new ArrayList<>();
		
		String balance =""; //���� ������ �ܾ�
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uACC4\uC88C\uC870\uD68C");
		lblNewLabel.setBounds(182, 0, 57, 15);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 27, 431, 23);
		contentPane.add(textArea);
		
		JButton btnNewButton = new JButton("\uCDE8\uC18C");
		btnNewButton.setBounds(325, 228, 97, 23);
		contentPane.add(btnNewButton);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(12, 60, 431, 23);
		contentPane.add(textArea_1);
		
		balance = df.format(vo.getBalance());
		ivo=idao.read(vo.getAccountTypeNo());
		
		
		textArea.setText("������\tŸ��\t��ǰ��\t���°�����\t�ܾ�");
		textArea_1.setText(vo.getAccountName()+"\t"+ivo.getAccountType()+"\t"+ivo.getAccountTypeName()+"\t"+vo.getAccountDate()+"\t"+balance+"\n");
		
		
//		JTextArea textArea_3 = new JTextArea();
//		textArea_3.setText("���¹�ȣ\t�ŷ���\t�ŷ���\t�ŷ�����");
//		textArea_3.setBounds(12, 93, 431, 23);
//		contentPane.add(textArea_3);
//		//�ŷ�����
//				array=tdao.list(vo.getAccountNo());
//				String history="";
//				for(TradeVO tvo:array) {
//					String tradeBalance=df.format(tvo.getTradeBalance());
//					String trade=(tvo.getAccountNo()+"\t"+tradeBalance+"\t"+tvo.getTradeDate()+"\t"+tvo.getTradeType()+"\n");
//					history=history+trade;
//				}
//
//		JTextArea textArea_2 = new JTextArea();
//		textArea_2.setBounds(12, 121, 431, 101);
//		contentPane.add(textArea_2);
//		textArea_2.setText(history);
				
		String[] header = {"���¹�ȣ", "�ŷ�����", "�ŷ��ݾ�", "�ŷ���"};
		String[][] data = accountDAO.getTrade(vo.getAccountNo());
		
		table = new JTable(data, header);
		table.setAlignmentX(0);
		table.setPreferredScrollableViewportSize(new Dimension(434, 200));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(9, 93, 434, 132);
		contentPane.add(scrollPane);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
