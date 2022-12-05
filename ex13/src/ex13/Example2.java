package ex13;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Example2 {
	public static void execute() {
		DecimalFormat df = new DecimalFormat("#,###����"); // �پ��� ���� �����͸� �ڽ��� ���ϴ� �������� ��Ÿ�� �� �ְ� �����ִ� Ŭ����
		Scanner sc = new Scanner(System.in);
		ProductDAO dao = new ProductDAO();
		ProductVO vo = new ProductVO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // ���������� �ð�ǥ�� ������ ��� �ִ� Ŭ����
		SaleDAO sdao = new SaleDAO();
		SaleVO svo = new SaleVO();
		
		int newNo;
		
		String sno;
		String menu;
		String qnt;
		String price;
		
		boolean isNumber = false;
		boolean run = true;
		
		while(run) {
			System.out.println("------------------------------------------------------------");
			System.out.println("1.��ǰ��� | 2.��ǰ��ȸ | 3.��ǰ��� | 4.������ | 0.����");
			System.out.println("------------------------------------------------------------");
			System.out.print("������ �۾��� �������ּ��� : ");
			menu = sc.nextLine();
			
			System.out.println("");
			
			switch(menu) {
			case "1" : 
				vo = new ProductVO();
				newNo = dao.getMaxNo() + 100;
				
				System.out.println("�ش� ��ǰ�� ��ǰ ��ȣ�� " + newNo + "�� �Դϴ�.");
				vo.setNo(newNo);
				
				System.out.print("��ǰ���� �Է����ּ���. : ");
				vo.setName(sc.nextLine());
				
				isNumber = false;
				do {
					System.out.print("��ǰ�� �ܰ��� �Է����ּ���. : ");
					price = sc.nextLine();
					
					isNumber = price.matches("-?\\d+(\\.\\d+)?");
					if(isNumber == false) {
						System.out.println("���ڷ� �Է����ּ���.\n");
					}
				} while(isNumber == false);
				vo.setPrice(Integer.parseInt(price));
				
				isNumber = false;
				do {
					System.out.print("��ǰ�� ������ �Է����ּ���. : ");
					qnt = sc.nextLine();
					
					isNumber = qnt.matches("-?\\d+(\\.\\d+)?");
					if(isNumber == false) {
						System.out.println("���ڷ� �Է����ּ���.\n");
					}
				} while(isNumber == false);
				vo.setQnt(Integer.parseInt(qnt));
			
				System.out.println("");
				
				dao.insert(vo);
				
				System.out.println("���ο� ��ǰ�� ��ϵǾ����ϴ�.\n");
				break;
			case "2" :
				isNumber = false;
				do {
					System.out.print("�˻��Ͻ� ��ǰ�� ��ǰ ��ȣ�� �Է��ϼ���. : ");
					sno = sc.nextLine();
					System.out.println("");
					
					isNumber = sno.matches("-?\\d+(\\.\\d+)?");
					if(isNumber == false) {
						System.out.println("��ǰ ��ȣ�� ���ڷ� �Է����ּ���.\n");
					}
				} while(isNumber == false);
				
				vo = dao.read(Integer.parseInt(sno));
				
				if(vo.getName() == null) {
					System.out.println("��ǰ�� �������� �ʽ��ϴ�.");
				} else {
					int sum = vo.getPrice() * vo.getQnt();
					String strSum = df.format(sum);
					String dfprice = df.format(vo.getPrice());
					System.out.println("��ȣ\t��ǰ��\t�ǸŴܰ�\t������\t�ݾ�");
					System.out.printf("%d\t%s\t%s\t%d��\t%s\n", vo.getNo(), vo.getName(), dfprice, vo.getQnt(), strSum);
					
					ArrayList<SaleVO> sarray = sdao.list(Integer.parseInt(sno));
					if(sarray.size()==0) {
						System.out.println("�Ǹ��� ��ǰ�� �����ϴ�.");
					} else {
						System.out.println("");
						System.out.println(vo.getName() + "�� ���� ��Ȳ�Դϴ�.");
						System.out.println("---------------------------------------------------");
						System.out.println("��ȣ\t��¥\t�Ǹŷ�");
						for(SaleVO s : sarray) {
							System.out.printf("%d\t%s\t%d\n", s.getNo(), s.getDate(), s.getSale());
						}
					}
				}
				System.out.println("");
				break;
			case "3" :
				ArrayList<ProductVO> array = dao.list();
				System.out.println("��ȣ\t��ǰ��\t�ǸŴܰ�\t������\t�ݾ�");
				for(ProductVO v : array) {
					int sum = v.getPrice() * v.getQnt();
					String strSum = df.format(sum);
					String dfprice = df.format(v.getPrice());
					System.out.printf("%d\t%s\t%s\t%d��\t%s\n", v.getNo(), v.getName(), dfprice, v.getQnt(), strSum);
				}
				System.out.printf("\n��ϵǾ� �ִ� ��ü ��ǰ�� ���� %d�� �Դϴ�.\n", array.size());
				System.out.println("");
				break;
			case "4" :
				vo = new ProductVO();
				
				do {
					System.out.print("���� ��Ȳ�� ����Ͻ� ��ǰ�� ��ǰ ��ȣ�� �Է��ϼ���. : ");
					sno = sc.nextLine();
					System.out.println("");
					
					isNumber = sno.matches("-?\\d+(\\.\\d+)?");
					if(isNumber == false) {
						System.out.println("��ǰ ��ȣ�� ���ڷ� �Է����ּ���.\n");
					}
				} while(isNumber == false);
				
				vo = dao.read(Integer.parseInt(sno));
				
				if(vo.getName() == null) {
					System.out.println("��ǰ�� �������� �ʽ��ϴ�.");
				} else {
					ArrayList<SaleVO> sarray = sdao.list(Integer.parseInt(sno));
					if(sarray.size() == 0) {
						System.out.println("�Ǹ��� ��ǰ�� �����ϴ�.");
					} else {
						System.out.println("��ȣ\t��¥\t�Ǹŷ�");
						for(SaleVO s : sarray) {
							System.out.printf("%d\t%s\t%d\n", s.getNo(), s.getDate(), s.getSale());
						}
					}
					System.out.println("");
					
					System.out.println("��ǰ�� : " + vo.getName());
					svo.setNo(Integer.parseInt(sno));
					
					System.out.println("");
					
					svo.setDate(sdf.format(new Date()));
					
					System.out.print("��ǰ�� �Ǹŷ��� �Է����ּ��� : ");
					String sale = sc.nextLine();
					
					System.out.println("");
					
					dao.update(Integer.parseInt(sno), Integer.parseInt(sale));
					
					svo = new SaleVO();
					svo.setNo(Integer.parseInt(sno));
					svo.setDate(sdf.format(new Date()));
					svo.setSale(Integer.parseInt(sale));
					sdao.insert(svo);
					
					System.out.println("���ο� ���� ��Ȳ�� ��ϵǾ����ϴ�.");
				}
				
				System.out.println("");
				break;
			case "0" :
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
/*
   //������ - �Ǹż���
   public void update(int no, int qnt) {
      try {
         BufferedReader reader=new BufferedReader(new FileReader(file));
         String line="";
         String lines="";
         while((line=reader.readLine()) != null) {
            StringTokenizer st=new StringTokenizer(line, "|");
            int lineNo=Integer.parseInt(st.nextToken());
            if(no==lineNo) {
               ProductVO vo=new ProductVO();
               vo.setNo(lineNo);
               vo.setName(st.nextToken());
               vo.setPrice(Integer.parseInt(st.nextToken()));
               vo.setQnt(Integer.parseInt(st.nextToken()));
               vo.setQnt(vo.getQnt()-qnt);
               
               lines=lines + vo.getNo()+"|"+vo.getName()
                     +"|"+vo.getPrice()+"|"+vo.getQnt()+"\n";
            }else {
               lines = lines + line;
            }
         }
         //���ο� ��������
         FileWriter writer=new FileWriter(file, false);
         writer.write(lines);
         writer.flush();
         writer.close();
      }catch(Exception e) {
         System.out.println("������ ��ǰ�ڵ�:" + e.toString());
      }
   }
 */