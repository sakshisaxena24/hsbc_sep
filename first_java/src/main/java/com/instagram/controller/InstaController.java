package com.instagram.controller;

import java.io.BufferedReader;
import java.util.List;

import com.instagram.entity.InstagramUser;
import java.io.IOException;
import java.io.InputStreamReader;

//import com.instagram.entity.InstagramUser;
import com.instagram.service.InstagramService;

import com.instagram.service.InstagramServiceInterface;

public class InstaController implements InstagramControllerInterface{

	private InstagramServiceInterface fs;
	
	public InstaController()
	{
		fs=new InstagramService();
	}


	@Override
	public void createProfile() throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your name : ");
		String name=br.readLine();
		
		System.out.println("Enter your password");
		String password=br.readLine();
		
		System.out.println("Enter your email");
		String email=br.readLine();
		
		System.out.println("Enter your address");
		String address=br.readLine();
		
		InstagramUser iu=new InstagramUser(); //objecy to transfer data from one layer to another
		iu.setName(name);
		iu.setPassword(password);
		iu.setEmail(email);
		iu.setAddress(address);
		
		int i=fs.createProfileService(iu);
		if(i>0)
		{
			System.out.println("profile created");
			
		}
		else
		{
			System.out.println("not created");
		}
		
		
		
	}

	@Override
	public void editProfile()throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter name whose profile you want to edit");
		String name=br.readLine();
		
		InstagramUser iu=new InstagramUser();  //object to transfer data from controller to service
		iu.setName(name);
	
		int uu=fs.editProfileService(iu); //object to take data from service to controller
		
		if(uu>0)
		{
			System.out.println("Name is "+name);
		
		}
		else
		{
			System.out.print("User with name "+name+"not exist");
		}
		
	//fs.viewProfile();
	
		
	}

	@Override
	public void uploadimage() {
		fs.uploadimageService();
		System.out.println("Image uploaded");
		
	}

	@Override
	public void viewProfile() throws Exception {
		
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter name whose profile you wants to view");
		String name=br.readLine();
		
		InstagramUser iu=new InstagramUser();  //object to transfer data from controller to service
		iu.setName(name);
	
		InstagramUser uu=fs.viewProfileService(iu); //object to take data from service to controller
		
		if(uu!=null)
		{
			System.out.println("Name is "+uu.getName());
			System.out.println("Password is "+uu.getPassword());
			System.out.println("Email is  "+uu.getEmail());
			System.out.println("address id "+uu.getAddress());
		}
		else
		{
			System.out.print("User with name "+name+"not exist");
		}
		
	//fs.viewProfile();
	System.out.println("View Profile");
		
	}
	
	/*public void createcustomtable() throws Exception 
	 * Buufered reader line
	 * sopl("eneter tablename"):
	 * name=br.read
	 * 
	 * system.print("columns");
	 * i=parseInt
	 * 
	 * for(int j=1;j<=i;j++)
	 * 
	 *column name
	 *string cname=br.readLine();
	 *similarly for datatype and size.*/
	 
	@Override
	public void searchProfile()throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter name to search profile");
		String name=br.readLine();
		
		InstagramUser iu=new InstagramUser();
		iu.setName(name); //entity to controller
		
		
	List<InstagramUser>uu= fs.searchProfileService(iu);
	
	System.out.println(uu.size()+" users found");
	for(InstagramUser u:uu)
	{
		System.out.println("****************************************");
		System.out.println("Name is :  "+u.getName());
		System.out.println("Password is:  "+u.getPassword());
		System.out.println("Email is :  "+u.getEmail());
		System.out.println("Address is :  "+u.getAddress());
		System.out.println("*****************************************");
	}
		//fs.searchProfile();
//		fs.searchProfileService(iu); //controller to service
	//	System.out.println("Search Profile");
		
	}

	@Override
	public void comment() {
		fs.commentService();
		System.out.println("Search Profile");
		
	}

	@Override
	public void like() {
		fs.likeService();
		System.out.println("Search Profile");
		
	}


	@Override
	public void demoa() throws Exception {
	fs.demoservice();
		
	}

}
