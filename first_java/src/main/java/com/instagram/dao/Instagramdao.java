package com.instagram.dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.instagram.entity.InstagramUser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;



public class Instagramdao implements InstagramdaoInterface {


public void demo()throws Exception{
	//public int addprofiledetails(InstagramUser iu)throws Exception {
		/*File f=new File("d:/hsbc_file/one.txt");
		File f1=new File("d:/hsbc_file/two.txt");
		
		FileInputStream in=new FileInputStream(f);
		FileOutputStream out=new FileOutputStream(f1);
		
		int c=0;
		
		while(!((c=in.read())==-1)){
			out.write(c);
		}
		out.close();
		in.close();
		System.out.println("writing complete");
		*/
		
	int c=0;
	
		File f=new File("c:/sakshi");
		if(f.mkdir())
		{
			System.out.println("directory created");
		}
		
		if(f.createNewFile())
		{
			System.out.println("yes");
		}
		File f1=new File("c:/sakshi/one.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		FileOutputStream out=new FileOutputStream(f1);
	
		System.out.println("enter your data");
		
		String st=br.readLine();
		for(int i=0;i<st.length();i++) {
			out.write(st.charAt(i));
		}
			
	//File f2=new File("c:/sakshi/two.txt");	
		
		out.close();
		
		System.out.println("writing complete");
		}

	
public int addprofiledetails(InstagramUser iu) throws Exception{
	
		int i=0;
		

		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		Connection con=DriverManager.getConnection("jdbc:derby:d:/instadb;create=true", "sakshi", "sakshi");
		
		PreparedStatement ps=con.prepareStatement("insert into instagram values(?,?,?,?)");
		ps.setString(1, iu.getName());
		ps.setString(2, iu.getPassword());
		ps.setString(3, iu.getEmail());
		ps.setString(4, iu.getAddress());
		
		 i=ps.executeUpdate();  
		
		return i;
	
	}



	@Override
	public void imageupload() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InstagramUser viewprofiledetails(InstagramUser iu) throws Exception {
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		Connection con=DriverManager.getConnection("jdbc:derby:d:/instadb;create=true", "sakshi", "sakshi");
		
		PreparedStatement ps=con.prepareStatement("select * from instagram where name=?");
		ps.setString(1, iu.getName());
	
		ResultSet res=ps.executeQuery();
		
		
		InstagramUser uu=null;
		
		while(res.next()) {
			uu=new InstagramUser();
			uu.setName(res.getString(1));
			uu.setPassword(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setAddress(res.getString(4));
		}
		return uu;
	}

	

	@Override
	public void commented() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void liked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<InstagramUser> searchprofiledetails(InstagramUser iu) throws Exception {

		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		Connection con=DriverManager.getConnection("jdbc:derby:d:/instadb;create=true", "sakshi", "sakshi");
		
		PreparedStatement ps=con.prepareStatement("select * from instagram where name=?");
		ps.setString(1, iu.getName());
	
		ResultSet res=ps.executeQuery();
		
		List<InstagramUser> ll=new ArrayList<InstagramUser>();
		
		while(res.next())
		{
			InstagramUser uu=new InstagramUser();
			uu.setName(res.getString(1));
			uu.setPassword(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setAddress(res.getString(4));
			
			ll.add(uu);
		}
		
		
		return ll;
	}


	@Override
	public int updateprofiledetails(InstagramUser iu) throws Exception {

		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		Connection con=DriverManager.getConnection("jdbc:derby:d:/instadb;create=true", "sakshi", "sakshi");
		
		PreparedStatement ps=con.prepareStatement("update instagram set password=? where name=?");
		ps.setString(1, iu.getName());
		ps.setString(2, iu.getPassword());

		
		return ps.executeUpdate(); 
		
	}



	




		
	}

