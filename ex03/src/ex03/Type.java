package ex03;

public class Type {
	public static void exeute() {
		
		System.out.println("---------- ����Ÿ�� ----------\n");
		
		System.out.println("1.������ ����");
		
		int intValue = 3;
		System.out.println("intValue = " + intValue + "\n");
		
		System.out.println("2.�Ǽ��� ����");
		
		double dubValue = 3.14;
		System.out.println("dubValue = " + dubValue + "\n");
		
		System.out.println("3.������ ����");
		
		char charValue = 'A';
		System.out.println("charValue = " + charValue);
		
		String strValue = "ȫ�浿";
		System.out.println("strValue = " + strValue + "\n");
		
		System.out.println("---------- ����Ÿ�� �ڵ���ȯ ----------\n");
		
		dubValue = 3.14;
		intValue = 4;
		dubValue = intValue;
		System.out.println("dubValue = " + dubValue + "\n");
		
		System.out.println("---------- ����Ÿ�� ������ȯ ----------\n");
		
		dubValue = 3.14;
		intValue = 4;
		intValue = (int) dubValue;
		System.out.println("intValue = " + intValue);
		
	}
}
