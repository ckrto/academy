package ex04;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Example6 {
	public static void execute() {
		DecimalFormat df = new DecimalFormat("###.00");
		Scanner sc = new Scanner(System.in);
		
		String[] name = new String[3];
		int[] kor = new int[3];
		int[] eng = new int[3];
		int[] mat = new int[3];		
		int tot = 0;
		double avg;
		
		for(int i = 0; i < name.length; i++) {
			System.out.print("�̸��� �Է����ּ��� : ");
			name[i] = sc.next();
		}
		System.out.print("\n");
		
		for(int i = 0; i < kor.length; i++) {
			System.out.print(name[i] + "�� ���� ������ �Է����ּ��� : ");
			kor[i] = sc.nextInt();
		}
		System.out.print("\n");
		
		for(int i = 0; i < eng.length; i++) {
			System.out.print(name[i] + "�� ���� ������ �Է����ּ��� : ");
			eng[i] = sc.nextInt();
		}
		System.out.print("\n");
		
		for(int i = 0; i < mat.length; i++) {
			System.out.print(name[i] + "�� ���� ������ �Է����ּ��� : ");
			mat[i] = sc.nextInt();
		}
		System.out.print("\n");
		
		System.out.println("�̸�\t����\t����\t����\t����\t���");
		
		for(int i = 0; i < name.length; i++) {
			tot = kor[i] + eng[i] + mat[i];
			avg = tot / (double) 3;
				
			System.out.print(name[i] + "\t");
			System.out.print(kor[i] + "\t");
			System.out.print(eng[i] + "\t");
			System.out.print(mat[i] + "\t");
			System.out.print(tot + "\t");
			System.out.println(df.format(avg));
		}
	}
}
