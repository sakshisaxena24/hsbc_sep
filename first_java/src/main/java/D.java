class A{
	A(int j)
	{
		super();
		System.out.println("A");
	}
	
	int i=8;
	void add()
	{
		System.out.println("add function");
	}
	static void sub()
	{
		
	}
	
}
class B extends A{

	B() {
		super(7);
		System.out.println("B");
		System.out.println(super.i);
		super.add();
		super.sub();
		// TODO Auto-generated constructor stub
	}
/*	static void sub()
	{
		super.add(); //wont let you use super with static keyword
	}*/
	
}
class C extends B{
	private int k;
	
	C(int k){
		super();
		this.k=k;
		System.out.println("C");
	}
}
public class D {

	public static void main(String[] args) {
		new C(9);
		// TODO Auto-generated method stub

	}

}
