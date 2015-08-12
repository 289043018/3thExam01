package com.hand.Exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class App 
{
	 public static void main(String[] args) {
		 
		  //当前的数据库连接
		  Connection conn = null;
		  //发送sql语句
		  Statement st = null;
		  //结果集
		  ResultSet rs = null;
		  ResultSet rs2 = null;
		 System.out.println("输入：");
		 System.out.println("请输入Country_id:");
		 Scanner scanner = new Scanner(System.in);
		 String country_id;
		 
		 country_id= scanner.nextLine();
		  //创建一个字符串保存SQL语句
		  String sql = "select city_id,city from city where city_id = "+ country_id;
		  String sql2 = "select country from country where country_id ="+country_id;
		  try {
		   //注册一个驱动
		   Class.forName("com.mysql.jdbc.Driver");
		   //获取数据库连接
		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","root");
		   //发送SQL语句
		   st = conn.createStatement();
		   rs = st.executeQuery(sql2);
//		  String count3
		  System.out.println("输出：");
		  System.out.print("country ");
		  while(rs.next()){
			  
			  System.out.print(rs.getString("country"));
		  }
		  System.out.println(" 的城市->");
		  System.out.println("城市ID| "+"城市名称");
		  rs2 = st.executeQuery(sql);
		   //对rs对象进行遍历
		   while (rs2.next()) {
		    System.out.print(rs2.getInt("city_id")+ "| ");
		    System.out.print(rs2.getString("city")+"  ");
		    System.out.println();
		   
		   }
		   
		   
		   
		   
		  } catch (Exception e) {
		   e.printStackTrace();
		  }finally{
		   try {//从由小到大的顺序关闭资源
			   rs2.close();
		    rs.close();
		   } catch (Exception e2) {
		   }
		   try {
		    st.close();
		   } catch (Exception e3) {
		   }
		   try {
		    conn.close();
		   } catch (Exception e4) {
		   
		   }
		  }
		 }

}
