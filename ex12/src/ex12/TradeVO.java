package ex12;

import java.text.DecimalFormat;

public class TradeVO extends AccountVO {
	private int no;
	private String date;
	private String type;
	private int amount;
	
	public int getNo() {
		return no;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###��");
		return "[������� : " + date + ", �Ա�/��� : " + type + ", ����ݾ� : " + df.format(amount) + "]";
	}
	
	
}
