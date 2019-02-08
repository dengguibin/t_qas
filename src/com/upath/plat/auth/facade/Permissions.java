package com.upath.plat.auth.facade;

import java.io.Serializable;

import com.upath.plat.auth.model.TRmsPermissionsinfo;

@SuppressWarnings("serial")
public class Permissions extends TRmsPermissionsinfo implements IPermissions,Serializable{

	public String getId() {
		return getQxid();
	}

	public String getName() {
		return getQxmc();
	}

	
	public Integer getStat(){
		return getPxh();
	}
	
}
