package ex04;

public class Example5 {
	public static void execute() {
		// �迭 (�ϳ��� ������ �������� �����͸� ����)
		
		int[] a= {10, 21, 13, 44, 88, 57, 61, 4};
		int sum = 0;
		
		System.out.println("3��° : " + a[2]);
		System.out.println("6��° : " + a[5]);
		
		System.out.println("----------------------");
		
		a[7] = 40;
		
		for(int i = 0; i < a.length; i++) { // a.length : �迭�� ũ��
			sum = sum + a[i];
			System.out.println(i+1 + "��° : " + a[i]);
		}
		
		System.out.println("----------------------");
		System.out.println("���� : " + sum);
		
		double avg = sum / (double) a.length;
		System.out.println("��� :" + avg);
	}
}