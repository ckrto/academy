package ex17;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CampDAO dao = new CampDAO();
		CampVO vo = null;
		FacilityDAO fdao = new FacilityDAO();
		FacilityVO fvo = null;
		TypeDAO tdao = new TypeDAO();
		TypeVO tvo = null;
		
		int menu;
		
		String newCode;
		String cname;
		String address;
		String code;
		
		boolean run = true;
		
		while(run) {
			System.out.println("-------------------------");
			System.out.println("1.ķ������");
			System.out.println("2.ķ������");
			System.out.println("3.ķ������ȸ");
			System.out.println("4.�ü������");
			System.out.println("5.�������");
			System.out.println("0.���α׷� ����");
			System.out.println("-------------------------");
			menu = Input.input("������ �۾��� �������ּ���. : ");
			System.out.println("");
			
			switch(menu) {
			case 1 :
				newCode = dao.getNewCode();
				System.out.println("����Ͻ� ķ������ �ڵ�� " + newCode + " �Դϴ�.\n");
				
				System.out.print("ķ������ �̸��� �Է����ּ���. : ");
				cname = sc.nextLine();
				System.out.println("");
				
				if(cname.equals("")) {
					System.out.println("����� ����մϴ�.\n");
					break;
				}
				
				System.out.print("ķ������ �ּҸ� �Է����ּ���. : ");
				address = sc.nextLine();
				System.out.println("");
				
				if(address.equals("")) {
					System.out.println("����� ����մϴ�.\n");
					break;
				}
				vo = new CampVO();
				vo.setCode(newCode);
				vo.setCname(cname);
				vo.setAdress(address);
				dao.insert(vo);
				System.out.println("���ο� ķ������ ��ϵǾ����ϴ�.\n");
				break;
			case 2 :
				ArrayList<CampVO> array = dao.list();
				System.out.println("------------------------------------------------");
				for(CampVO v : array) {
					System.out.printf("%s\t%s\t%s\n", v.getCode(), v.getCname(), v.getAdress());
					ArrayList<FacilityVO> farray = fdao.list(v.getCode());
					System.out.print("�ü��� ��Ȳ : ");
					for(FacilityVO f : farray) {
						System.out.printf("%s(%s) | ", f.getFname(), f.getFcode());
					}
					System.out.println("");
					ArrayList<TypeVO> tarray = tdao.list(v.getCode());
					System.out.println("ķ�������� ��Ȳ : ");
					for(TypeVO t : tarray) {
						System.out.printf("%s(%d��) | ", t.getTname(), t.getQnt());
					}
					System.out.println("");
					System.out.println("------------------------------------------------");
				}		
				System.out.println("");
				break;
			case 3 :
				System.out.print("��ȸ�� ķ������ �ڵ带 �Է����ּ���. : ");
				code = sc.nextLine();
				System.out.println("");
				if(code.equals("")) {
					System.out.println("��ȸ�� ����մϴ�.\n");
					break;
				}
				vo = dao.read(code);
				if(vo.getCname() == null) {
					System.out.println("�ش� ķ������ �����ϴ�.");
					break;
				}
				
				System.out.printf("%s(%s)\n", vo.getCname(), vo.getAdress());
				ArrayList<FacilityVO> farray = fdao.list(code);
				System.out.println("�ü��� : ");
				for(FacilityVO f : farray) {
					System.out.printf("%s(%s) | ", f.getFname(), f.getFcode());
				}
				System.out.println("\n------------------------------------------------");
				
				ArrayList<TypeVO> tarray = tdao.list(code);
				System.out.println("���� : ");
				for(TypeVO t : tarray) {
					System.out.printf("%s(%s) | ", t.getTname(), t.getTcode());
				}
				System.out.println("\n------------------------------------------------");
				
				
				System.out.println("");
				break;
			case 4 :
				Example1.execute();
				break;
			case 5 :
				Example2.execute();
				break;
			case 0 :
				run = false;
				System.out.println("���α׷��� �����մϴ�.\n");
				break;
			default :
				System.out.println("�޴��� �ٽ� �������ּ���\n");
				break;
			}
			
		}
	}

}
