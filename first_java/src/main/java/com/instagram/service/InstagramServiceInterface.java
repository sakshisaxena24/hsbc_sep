package com.instagram.service;

import java.util.List;

import com.instagram.entity.InstagramUser;

public interface InstagramServiceInterface {

	//void createProfileService();

	int editProfileService(InstagramUser iu) throws Exception;

	void uploadimageService();



	List<InstagramUser> searchProfileService(InstagramUser iu)throws Exception;

	void commentService();

	void likeService();

	//int createprofileService(InstagramUser iu);

	int createProfileService(InstagramUser iu) throws Exception;

	InstagramUser viewProfileService(InstagramUser iu) throws Exception;

	void demoservice() throws Exception;




}
