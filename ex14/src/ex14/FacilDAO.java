package ex14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FacilDAO {
	File file = new File("c:/data/java/ex14/dues.txt");
	
	public void insert(int code, String facil) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(code + "|" + facil + "\n");
			writer.flush();
			writer.close();
		} catch(Exception e) {
			System.out.println("�ü��� ��� : " + e.toString());
		}
	}
	
	public void delect(int code, String facil) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = "";
			String lines = "";
			while((line = bf.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				int lineCode = Integer.parseInt(st.nextToken());
				String lineFacil = st.nextToken();
				if(lineCode != code || !lineFacil.equals(facil)) {
					lines = lines + line + "\n";
				}
			}

			FileWriter writer = new FileWriter(file, false);
			writer.write(lines);
			writer.flush();
			writer.close();
		} catch(Exception e) {
			System.out.println("�ü��� ���� : " + e.toString());
		}
	}
	
	public ArrayList<String> list(int code) {
		ArrayList<String> array = new ArrayList<String>();
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = bf.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "|");
				int lineCode = Integer.parseInt(st.nextToken());
				if(code == lineCode) {
					array.add(st.nextToken());
				}
			}
			
		} catch(Exception e) {
			System.out.println("�ü������ : " + e.toString());
		}
		return array;
	}
}
