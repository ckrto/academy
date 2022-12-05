package ex15;

import java.sql.*;
import java.util.*;

public class DeptDAO {
	Connection con=Database.getConnection();
	//�а����
	public void insert(DeptVO vo) {
		try {
			String sql="insert into tbl_dept(code,dname) values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, vo.getCode());
			ps.setString(2, vo.getDname());
			ps.execute();
		}catch(Exception e) {
			System.out.println("�а����:" + e.toString());
		}
	}
	
	//MaxCode ���������
	public String getMaxCode() {
		String maxCode="";
		try {
			String sql="select max(code) mcode from tbl_dept";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) maxCode=rs.getString("mcode");
		}catch(Exception e) {
			System.out.println("MaxCode:" + e.toString());
		}
		return maxCode;
	}
	
	//������
	public ArrayList<DeptVO> list(){
		ArrayList<DeptVO> array=new ArrayList<DeptVO>();
		try {
			String sql="select * from tbl_dept order by dname"; //1
			PreparedStatement ps=con.prepareStatement(sql);//2
			ResultSet rs=ps.executeQuery(); //3
			while(rs.next()) {
				DeptVO vo=new DeptVO();
				vo.setCode(rs.getString("code"));
				vo.setDname(rs.getString("dname"));
				array.add(vo);
			}
		}catch(Exception e) {
			System.out.println("�а����:" + e.toString());
		}
		return array;
	}
}
