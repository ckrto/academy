package hankook;

public class SnowTire { //ī��ǥ�ù� (�ڹ� ��) 
	private String color = "������";
	private int life = 3;
	private int size = 20;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int life) {
		this.life = life;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void print() {
		System.out.println("�ѱ�Ÿ�̾��� �����Ÿ�̾� �Դϴ�.");
	}
	
	public void printInfo() {
		System.out.println("���� : " + color);
		System.out.println("������ : " + size);
	}
}
