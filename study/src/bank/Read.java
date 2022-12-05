package bank;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import DAO_VO.AccountInfoDAO;
import DAO_VO.AccountInfoVO;
import DAO_VO.PasswordDAO;
import DAO_VO.PasswordVO;

public class Read {
	public static void execute(){
		
		Scanner in = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("��0,000��");
				
		AccountInfoDAO idao = new AccountInfoDAO();
		PasswordDAO pdao= new PasswordDAO();
		PasswordVO pvo= new PasswordVO();
		AccountInfoVO ivo = new AccountInfoVO();
		
		String accountNo=""; 		//���¹�ȣ
		String password=""; //��й�ȣ
		String balance =""; //���� ������ �ܾ�
		
		boolean run = true; //���� ��ȸ�� ����Ҷ����� �ݺ��� while�� ����
		boolean run1 = true;//���¹�ȣ �Է� Ȯ�� ����
		boolean run2 = true;//��й�ȣ �Է� Ȯ��
		
		while(run) {
			System.out.println("���� ��ȸ");	//���α׷� �ȳ�
			
			do {
				//���¹�ȣ �Է� �� ���Է� Ȯ��
				if(accountNo.equals("")) {
					System.out.print("���¹�ȣ : ");
					accountNo= in.nextLine();
					if(accountNo.equals("")) {
						System.out.println("���¹�ȣ�� �Է��ϼ���.");
					}
					else {
						run1=false;
					}
				}
				//��й�ȣ �Է� �� ���Է� Ȯ��
				if(password.equals("")) {
					System.out.print("��й�ȣ : ");
					password= in.nextLine();
					if(password.equals("")) {
						System.out.println("��й�ȣ�� �Է��ϼ���.");
					}
					else {
						run2=false;
					}
				}
			}while(run1==true || run2==true);
			
			//�ش� ���¹�ȣ�� ����� ���� ���� Ȯ��
			pvo=pdao.read(accountNo);	//�ش� ���¹�ȣ�� ���� �о����
			if(pvo.getAccountName()==null) {
				System.out.println("�������� �ʴ� ���¹�ȣ�Դϴ�.");
				accountNo="";	//���¹�ȣ �ʱ�ȭ�ؼ� while �ٽ� �����ϰ� �ٽ� �Է��ϵ���
			}
			else {	//�Է��� ���¹�ȣ�� ���°� ����� �ش� ������ ��й�ȣ�� ��ġ�ϴ��� �Ǵ�
				if(!pvo.getPassword().equals(password)) {
					System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					password="";
				}//��й�ȣ ����ġ�� ��й�ȣ �ʱ�ȭ�ؼ� while �ٽ� �����ϰ� �ٽ� �Է��ϵ��� 
				else {	//�Է��� ���¹�ȣ ������ ��й�ȣ�� ��ġ�� �� 
					System.out.println("������\tŸ��\t��ǰ��\t\t���°�����\t\t�ܾ�");
					balance = df.format(pvo.getBalance());
					ivo=idao.read(pvo.getAccountTypeNo());
					System.out.printf("%s\t%s\t%s\t%s\t%s",pvo.getAccountName(),ivo.getAccountType(),ivo.getAccountTypeName(),pvo.getAccountDate(),balance);
					break;	//���� ����ϰ� ���α׷� �����ϵ���
				}
			}		
		}//w
		
	}//m
}//c
