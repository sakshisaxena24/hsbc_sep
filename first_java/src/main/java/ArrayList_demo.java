import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class ArrayList_demo {


	public static void main(String[] args) {
		HashSet <Employee> l=new HashSet<Employee>();
		Employee e1=new Employee();
		e1.setName("\n sakshi");
		e1.setPassword("\n 123");
		
		Employee e2=new Employee();
		e2.setName("\n sk");
		e2.setPassword("\n ksjsj");
		
		//l.add("sakshi");		//heterogeneous objects
		//l.add(new Integer(3));
		//l.add(new Float(3.3f));
		
		l.add(e1);		//adding to the list
		l.add(e2);
		
		for(Employee oo:l) //stored in object
			System.out.println(oo.getName()+" "+oo.getPassword());
			/*if(oo instanceof Employee)	//oo instaceof means object of which class
			{
				Employee e=(Employee)oo;	//typecasting
				System.out.println(e.getName()+"  "+e.getPassword());
			}
		
		if(oo instanceof String)
		{
			String s=(String)oo;
			System.out.println(s);
		}
		if(oo instanceof Integer)
		{
			String s=(Integer)oo;
			System.out.println(s);
		}
		if(oo instanceof Float)
		{
			String s=(Float)oo;
			System.out.println(s);
		}*/

	}

}


