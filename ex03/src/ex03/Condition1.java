package ex03;

import java.util.Random;

public class Condition1 {
	public static void execute() {
		
		//���ǹ� (switch case)
		int[] count = new int[7];
		Random random = new Random();
		
		for(int i=0; i<10; i++)
		{
			switch((int)(Math.random()*6)+1) {
			case 1:
				System.out.println("1���� ���Խ��ϴ�.");
				count[1]++;
				break;
			case 2:
				System.out.println("2���� ���Խ��ϴ�.");
				count[2]++;
				break;
			case 3:
				System.out.println("3���� ���Խ��ϴ�.");
				count[3]++;
				break;
			case 4:
				System.out.println("4���� ���Խ��ϴ�.");
				count[4]++;
				break;
			case 5:
				System.out.println("5���� ���Խ��ϴ�.");
				count[5]++;
				break;
			case 6:
				System.out.println("6���� ���Խ��ϴ�.");
				count[6]++;
				break;
			default:
				break;
			}
		}
		for(int j = 1; j <= 6; j++)
			System.out.println(j +"���� " + count[j] + "�� ���Խ��ϴ�.");

	}
}
