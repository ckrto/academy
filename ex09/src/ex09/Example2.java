package ex09;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Example2 {
	public static void execute() {
		System.out.println("�ȳ��ϼ���. �ּҰ��� �ý����Դϴ�.");
		File file = new File("c:/data/java/address.txt");
		
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write("ȫ�浿,010-0000-0000,��õ�� ����Ȧ��\n");
			writer.write("��û��,010-1111-1111,��õ�� ������\n");
			writer.flush();
			writer.close();
			System.out.println("����Ϸ�");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
