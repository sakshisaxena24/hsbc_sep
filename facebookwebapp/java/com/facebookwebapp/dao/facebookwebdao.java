package com.facebookwebapp.dao;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.facebookwebapp.entity.facebookwebentity;
import com.facebookwebapp.entity.*;
public class facebookwebdao implements facebookwebdaointerface {

	

	public int registerEmployee(facebookwebentity em)throws Exception {
	
		int i=0;
System.out.println(em.getName());	//print to console
System.out.println(em.getNumber());
System.out.println(em.getEmail());
System.out.println(em.getPassword());
System.out.println(em.getAddress());
		
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		
		Connection con=DriverManager.getConnection("jdbc:derby:d:/newdb;create=true", "sakshi", "sakshi");
		
		PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?,?,?)");
		ps.setString(1, em.getName());	//insert in database
		ps.setString(2, em.getNumber());
		ps.setString(3, em.getEmail());
		ps.setString(4, em.getPassword());
		ps.setString(5, em.getAddress());
		
	i=ps.executeUpdate();  
		return i;
		
		

		     

		   
		    }

	@Override
	public boolean loginprofile(facebookwebentity em) throws ClassNotFoundException, SQLException {
		boolean i=false;
		System.out.println(em.getName());	//print to console
		System.out.println(em.getNumber());
		System.out.println(em.getEmail());
		System.out.println(em.getPassword());
		System.out.println(em.getAddress());
				
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				
				Connection con=DriverManager.getConnection("jdbc:derby:d:/newdb;create=true", "sakshi", "sakshi");
				PreparedStatement ps=con.prepareStatement("select * from emp where name=? and password=?");
				ps.setString(1, em.getName());	//insert in database
				ps.setString(2, em.getPassword());
				
				ResultSet res=ps.executeQuery();
				
				if(res.next())
				{
					i=true;
				}
				
	
		return i;
	}

		
	
public List<facebookwebentity> friendlistdao(facebookwebentity em) {
	List<facebookwebentity> ll=new ArrayList<facebookwebentity>();
	facebookwebentity f=new facebookwebentity();
	f.setName("sakshi");
	f.setAddress("Chennai");
	
	facebookwebentity f1=new facebookwebentity();
	f1.setName("drishika");
	f1.setAddress("Mumbai");
	
	ll.add(f1);
	ll.add(f);
	/*try {
		PreparedStatement ps=con.prepareStatement("select * from friendlist where name=?");
		ps.setString(1, iu.getName());
	
		
		
		//step 4 executeQuery
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			FacebookEmployee f=new FacebookEmployee();
			f.setName(res.getString(1));
			f.setAddress(res.getString(4));
			ll.add(f);
		}
						
		
	}
	catch(SQLException ee) {
		ee.printStackTrace();
	}*/
	return ll;
}

}


