package com.instagram.dao;

import java.util.List;

import com.instagram.entity.InstagramUser;

public interface InstagramdaoInterface {

//	void addprofiledetails();
	void commented();

	void liked();
	
	void imageupload();
	 void demo() throws Exception;

	//s	InstagramUser viewprofiledetails();

	int updateprofiledetails(InstagramUser iu)throws Exception;

	List<InstagramUser> searchprofiledetails(InstagramUser iu) throws Exception;
int addprofiledetails(InstagramUser iu) throws Exception;

	InstagramUser viewprofiledetails(InstagramUser iu) throws Exception;

	//void updateprofiledetails();

}
