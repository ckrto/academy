package ex03;

public class Condition {
	public static void execute() {
		System.out.println("---------- ���ǹ�(if) ----------");
		
		int score = 64;
		
		boolean result = (score >= 90);
		if(result) {
			System.out.println("������ 90������ Ů�ϴ�.");
			System.out.println("����� A�Դϴ�.");
		}
		if(score < 90) {
			System.out.println("������ 90�� �̸��Դϴ�.");
			System.out.println("����� B�Դϴ�.");
		}
		
		// if ~ else ��
		if(score >= 90) {
			System.out.println("������ 90������ Ů�ϴ�.");
			System.out.println("����� A�Դϴ�.");
		}
		else {
			System.out.println("������ 90�� �̸��Դϴ�.");
			System.out.println("����� B�Դϴ�.");
		}
		
		// if ~ else if ��
		if(score >= 90) {
			System.out.println("������ 90������ Ů�ϴ�.");
			System.out.println("����� A�Դϴ�.");
		}
		else if(score >= 80) {
			System.out.println("������ 80�� �̻��Դϴ�.");
			System.out.println("����� B�Դϴ�.");
		}
		else if(score >= 70) {
			System.out.println("������ 70�� �̻��Դϴ�.");
			System.out.println("����� C�Դϴ�.");
		}
		else if(score >= 60) {
			System.out.println("������ 60�� �̻��Դϴ�.");
			System.out.println("����� D�Դϴ�.");
		}
		else {
			System.out.println("������ 60�� �̸��Դϴ�.");
			System.out.println("����� F�Դϴ�.");
		}
		
		// ��ø if��
		if(score >= 90) {
			if(score >= 95) {
				System.out.println("������ 95�� �̻��Դϴ�.");
				System.out.println("����� A+�Դϴ�.");
			}
			else {
				System.out.println("������ 90�� �̻��Դϴ�.");
				System.out.println("����� A�Դϴ�.");
			}
		}
		else if(score >= 80) {
			if(score >= 85) {
				System.out.println("������ 85�� �̻��Դϴ�.");
				System.out.println("����� B+�Դϴ�.");
			}
			else {
				System.out.println("������ 80�� �̻��Դϴ�.");
				System.out.println("����� B�Դϴ�.");
			}
		}
		else if(score >= 70) {
			if(score >= 75) {
				System.out.println("������ 75�� �̻��Դϴ�.");
				System.out.println("����� C+�Դϴ�.");
			}
			else {
				System.out.println("������ 70�� �̻��Դϴ�.");
				System.out.println("����� C�Դϴ�.");
			}
		}
		else if(score >= 60) {
			if(score >= 65) {
				System.out.println("������ 65�� �̻��Դϴ�.");
				System.out.println("����� D+�Դϴ�.");
			}
			else {
				System.out.println("������ 60�� �̻��Դϴ�.");
				System.out.println("����� D�Դϴ�.");
			}
		}
	}
}
