package ex03;

import java.util.Arrays;
import java.util.Random;

public class LOTTO {
	public static void lotto() {
		
		Random random = new Random();
		int a[] = new int[6];
		int temp;
		
		System.out.println("�̹��� �ζ� ��ȣ�� : ");
		for(int k = 0; k < 5; k++) {
			for(int i = 0; i < 6; i++) {
				a[i] = random.nextInt(45) + 1;
				for(int j = 0; j < i; j++) {
					if(a[i] == a[j]) {
						i--;
						break;
					}
				}
			}
			System.out.println(Arrays.toString(a));
		}
		
	}
}
