package jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import DAO_VO.AccountInfoDAO;
import DAO_VO.AccountInfoVO;
import DAO_VO.PasswordDAO;
import DAO_VO.PasswordVO;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;

public class study extends JFrame {

	private JPanel contentPane;
	private JTextField ano;
	private JTextField psw;
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
	 * Create the frame.
	 * @throws ParseException 
	 */
	
	public study() throws ParseException {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("���� ��ȸ");
		lblNewLabel.setBounds(188, 5, 57, 15);
		contentPane.add(lblNewLabel);
		
		MaskFormatter mf =new MaskFormatter("###-#####");
		ano = new JFormattedTextField(mf);
		ano.setBounds(90, 30, 230, 26);
		contentPane.add(ano);
		ano.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("���¹�ȣ : ");
		lblNewLabel_1.setBounds(23, 30, 69, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("��й�ȣ : ");
		lblNewLabel_1_1.setBounds(23, 77, 69, 26);
		contentPane.add(lblNewLabel_1_1);
		
		psw = new JPasswordField();
		psw.setColumns(10);
		psw.setBounds(90, 77, 230, 26);
		contentPane.add(psw);
		
		JTextPane result = new JTextPane();
		result.setBounds(53, 120, 339, 87);
		contentPane.add(result);
		
		JButton btnNewButton_1 = new JButton("���");
		btnNewButton_1.setBounds(325, 228, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Ȯ��");
		btnNewButton.setBounds(332, 30, 90, 73);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				PasswordDAO pdao= new PasswordDAO();
				PasswordVO pvo= new PasswordVO();
				
				if(ano.getText().equals("   -     ") && psw.getText().equals("")) {
					result.setText("���¹�ȣ�� �Է��ϼ���.\n��й�ȣ�� �Է��ϼ���");
				}
				else if(ano.getText().equals("   -     ")) {
					result.setText("���¹�ȣ�� �Է��ϼ���.");
				}
				else if(psw.getText().equals("")) {
					result.setText("��й�ȣ�� �Է��ϼ���.");
				}
				else {
					pvo=pdao.read(ano.getText());
					if(pvo.getAccountName()==null) {
						result.setText("�������� �ʴ� ���¹�ȣ�Դϴ�.");
					}
					else {	//�Է��� ���¹�ȣ�� ���°� ����� �ش� ������ ��й�ȣ�� ��ġ�ϴ��� �Ǵ�
						if(!pvo.getPassword().equals(psw.getText())) {
							result.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
						}
						else {	//�Է��� ���¹�ȣ ������ ��й�ȣ�� ��ġ�� �� 
							setVisible(true);
							new read(pvo);
						}
					}
				}
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main main = new Main();
			}
		});
	}
}