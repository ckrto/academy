package ex15;
import java.util.*;

public class Example1 {
	public static void execute() {
		Scanner s=new Scanner(System.in);
		boolean run=true;
		DeptDAO dao= new DeptDAO();
		
		System.out.println("\n****************** �� �� �� �� �� �� **************");
		while(run) {
			System.out.println("\n===============================================");
			System.out.println("1.�ڵ��� | 2.�ڵ��� | 3.�ڵ���� | 4.�ڵ���� | 0.����");
			System.out.println("===============================================");
			int menu=Main.input("����");
			switch(menu) {
			case 0:
				System.out.println("������������ �̵��մϴ�.");
				run=false;
			case 1://�ڵ���
				String mcode=dao.getMaxCode();
				int newCode=Integer.parseInt(mcode) + 10; //String->int
				System.out.println("�а��ڵ�>" +  newCode);
				System.out.print("�а��̸�>");
				String codeName=s.nextLine();
				
				DeptVO vo=new DeptVO();
				vo.setCode(String.valueOf(newCode)); //int->String
				vo.setDname(codeName);
				dao.insert(vo);
				System.out.println("���ο� �а��� ��ϵǾ����ϴ�.");
				break;
			case 2://�ڵ���
				ArrayList<DeptVO> array=dao.list();
				for(DeptVO v:array) {
					System.out.printf("%s\t%s\n",v.getCode(),
										v.getDname());
				}
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.out.println("0~4�޴��� �����ϼ���.");
			}
		}
	}
}
