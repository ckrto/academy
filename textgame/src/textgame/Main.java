package textgame;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String name;
		int age;
		int choice;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� �������� �̸��� ���̸� �Է����ּ���.");
		System.out.println("�̸��� �Է��ϼ���.");
		name = sc.next();
		System.out.println("���̸� �Է��ϼ���.");
		age = sc.nextInt();
		
		if(age > 30)
		{
			System.out.println("? ���ݿͼ� ���ϰڴٰ�?? �λ� ���߳�");
		}
		
		System.out.println("203x�� ����� ������ �������� " + name + "��(��) ���ο� �����ڸ��� ã���� ���ڸ� ���α��� ����Ʈ�� �����Ѵ�.");
		System.out.println("���α��� ����Ʈ�� ������ " + name + "��(��) �ܾ˹ٶ�� �����ִ� �� ���ڸ��� ���� ����.");
		System.out.println("�� ���ڸ��� �ϱ� 300������ 5�ֵ��� �شٴ� �ӻ���� �˹�...");
		System.out.println("���ڱ� ����� ��Ʈ����, �ֽ����� ���� ���� ���� 1�￩��... "+ name + "�� ������...");
		System.out.println("�� ���ڸ��� �����Ͻðڽ��ϱ�?");
		System.out.println("1. ��             2. �ƴϿ�");
		choice = sc.nextInt();
		
		if(choice == 1)
		{
			System.out.println("�׷�! ������ ���� �涱�̰� �������� �̷� �˹ٶ� �ؼ� ���ѹα��� ������ �Ǵ°� �����ž�!");
		}
		else if(choice == 2)
		{
			System.out.println(name + "��(��) �׷��� ���� �涱�̴� ����ϰ� �Ǿ���....");
			System.out.println("Bad Ending...");
		}
		
		System.out.println("xx������ �ӻ�����");
		System.out.println(name + "�� �� �����԰� ���⼭ ������ �ۼ��ϽǰԿ�");
		
		System.out.println("���� �������� ��");
		System.out.println("���� ������ �帱�״� �ѹ� �ۼ��غ�����");
		System.out.println("������ 2�� �� �ִ°�");
		System.out.println("���� �̽Ĺްų� ���� ���� �ִ°�");
		System.out.println("������ȯ�� ������ �ִ°�");
		System.out.println("�˷����Ⱑ �ִ°� �ִٸ� � �˷����Ⱑ �ִ°�");
		
	}

}
