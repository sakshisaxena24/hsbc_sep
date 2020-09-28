package com.facebookwebapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.facebookwebapp.entity.facebookwebentity;

public interface facebookwebdaointerface {

	public int registerEmployee(facebookwebentity em) throws Exception;

	//public boolean loginprofile(facebookwebentity em);

	public boolean loginprofile(facebookwebentity em) throws ClassNotFoundException, SQLException;

	public List<facebookwebentity> friendlistdao(facebookwebentity fe);
}
