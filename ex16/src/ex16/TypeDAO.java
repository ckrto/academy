package ex16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class TypeDAO {
	Connection con = Database.getConnection();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	// ����
	public void update(TypeVO vo) {
		try {
			String sql = "update tbl_type set tname = ?, tdate = ? where tcode = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTname());
			ps.setString(2, vo.getTdate());
			ps.setString(3, vo.getTcode());
			ps.execute();
		} catch(Exception e) {
			System.out.println("���� : " + e.toString());
		}
	}
	
	// ����
	public boolean delete(String tcode) {
		boolean success = false;
		try {
			String sql = "delete from tbl_type where tcode = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tcode);
			ps.execute();
			success = true;
		} catch(Exception e) {
			
		}
		return success;
	}
	
	// ��ȸ
	public TypeVO read(String tcode) {
		TypeVO vo = new TypeVO();
		try {
			String sql = "select * from tbl_type where tcode=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, tcode);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				vo.setTcode(rs.getString("tcode"));
				vo.setTname(rs.getString("tname"));
				String tdate = sdf.format(rs.getDate("tdate"));
				vo.setTdate(tdate);
			}
		} catch(Exception e) {
			System.out.println("��ȸ : " + e.toString());
		}
		return vo;
	}
	
	// ���
	public void insert(TypeVO vo) {
		try {
			String sql = "insert into tbl_type(tcode, tname) values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTcode());
			ps.setString(2, vo.getTname());
			ps.execute();
		} catch(Exception e) {
			System.out.println("��� : " + e.toString());
		}
		
	}
	
	//Max Code ��������
	public String getMaxCode() {
		String maxCode = "";
		try {
			String sql = "select max(tcode) from tbl_type";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				maxCode = rs.getString("max(tcode)");
			}
		} catch(Exception e) {
			System.out.println("Max Code : " + e.toString());
		}
		return maxCode;
	}
	
	//���
	public ArrayList<TypeVO> list() {
		ArrayList<TypeVO> array = new ArrayList<TypeVO>();
		
		try {
			String sql = "select * from tbl_type";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TypeVO vo = new TypeVO();
				vo.setTcode(rs.getString("tcode"));
				vo.setTname(rs.getString("tname"));
				String tdate = sdf.format(rs.getDate("tdate"));
				vo.setTdate(tdate);
				array.add(vo);
			}
		} catch(Exception e) {
			System.out.println("��� : " + e.toString());
		}
		return array;
	}
}
