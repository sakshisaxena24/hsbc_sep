package com.instagram.service;


import java.util.List;

import com.instagram.dao.Instagramdao;
import com.instagram.dao.InstagramdaoInterface;
import com.instagram.entity.InstagramUser;

public class InstagramService implements InstagramServiceInterface{


	private InstagramdaoInterface fd;
	
	public InstagramService(){
		fd=new Instagramdao();
	}
	@Override
	public int createProfileService(InstagramUser iu) throws Exception {
		int i= fd.addprofiledetails(iu);
		
		return i;
		
	}



	@Override
	public void uploadimageService() {
	fd.imageupload();
	System.out.println("Image Uploaded");
	}


	@Override
	public void commentService() {
		fd.commented();
		System.out.println("Comment details completed");
		
	}

	@Override
	public void likeService() {
		fd.liked();
		System.out.println("Like details completed");
		
	}
	@Override
	public InstagramUser viewProfileService(InstagramUser iu)throws Exception {
		InstagramUser uu= fd.viewprofiledetails(iu);
		System.out.println("Profile is viewed");
		return uu;
	
	}
	@Override
	public List<InstagramUser> searchProfileService(InstagramUser iu) throws Exception {
		return fd.searchprofiledetails(iu);
		
	}
	@Override
	public int editProfileService(InstagramUser iu) throws Exception {
		int uu= fd.updateprofiledetails(iu);
		System.out.println("Profile is viewed");
		 return uu;
	
		
	}
	@Override
	public void demoservice() throws Exception {
	fd.demo();
		
	}

	}


