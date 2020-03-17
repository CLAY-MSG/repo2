package com.xgk.service.impl;

import java.util.List;

import com.xgk.dao.RoleDao;
import com.xgk.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements com.xgk.service.RoleService {

	@Autowired
	RoleDao roleDao;
	
	@Override
	public List<Role> getRoleList() {
		return roleDao.getRoleList();
	}

}
