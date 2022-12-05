package ex13;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProductDAO {
	
	File file = new File("c:/data/java/ex13/product.txt");
	
	public void update(int no, int sale) { // ��ǰ ������ +_�ϱ� ���� �ż���
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = "";
			String lines = ""; // line�� ���� �޾� ���Ӱ� ������ lines ������ ����
			while((line = bf.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				ProductVO vo = new ProductVO();
				vo.setNo(Integer.parseInt(st.nextToken()));
				vo.setName(st.nextToken());
				vo.setPrice(Integer.parseInt(st.nextToken()));
				int qnt = Integer.parseInt(st.nextToken());
				vo.setQnt(qnt - sale); // qnt���� sale���� ���� return�Ͽ� ����
				
				if(no == vo.getNo()) { // lines�� ���ο� ������ �����Ͽ� ����
					lines = lines + vo.getNo() + "|" + vo.getName() + "|" + vo.getPrice() + "|" + vo.getQnt() + "\n";
				} else { // ���࿡ �ٲ� ������ �ƴ϶�� ������ ���� ����
					lines = lines + line + "\n";
				}
			}
			FileWriter writer = new FileWriter(file, false); // ���ο� ������ ����� ���̱� ������ false�� ����
			writer.write(lines);
			writer.flush();
			writer.close();
			
		} catch(Exception e) {
			System.out.println("���� : " + e.toString());
		}
	}
	
	
	public int getMaxNo() {
		int no = 0;
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = bf.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				no = Integer.parseInt(st.nextToken());
			}
		} catch(Exception e) {
			System.out.println("������ ���� : " + e.toString());
		}
		
		return no;
	}
	
	public ArrayList<ProductVO> list(){
		ArrayList<ProductVO> array = new ArrayList<ProductVO>();
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = bf.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				ProductVO vo = new ProductVO();
				vo.setNo(Integer.parseInt(st.nextToken()));
				vo.setName(st.nextToken());
				vo.setPrice(Integer.parseInt(st.nextToken()));
				vo.setQnt(Integer.parseInt(st.nextToken()));
				array.add(vo);
			}
		} catch(Exception e) {
			System.out.println("��� : " + e.toString());
		}
		
		return array;
	}
	
	public void insert(ProductVO vo) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(vo.getNo() + "|" + vo.getName() + "|" + vo.getPrice() + "|" + vo.getQnt() + "\n");
			writer.flush();
			writer.close();
		} catch(Exception e) {
			System.out.println("��ǰ ��� : " + e.toString());
		}
	}
	
	public ProductVO read(int no) {
		ProductVO vo = new ProductVO();
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = bf.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line,"|");
				vo.setNo(Integer.parseInt(st.nextToken()));
				if(no == vo.getNo()) {
					vo.setName(st.nextToken());
					vo.setPrice(Integer.parseInt(st.nextToken()));
					vo.setQnt(Integer.parseInt(st.nextToken()));
					break;
				}
			}
		} catch(Exception e) {
			System.out.println("��� : " + e.toString());
		}
		return vo;
	}
}
