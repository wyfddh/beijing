package com.tj720.admin.service;

import java.util.List;

import com.tj720.admin.model.CurationExample;
import com.tj720.admin.model.MipUser;
import com.tj720.admin.model.MipUserExample;

public interface IMipUserService {

	public int updateStatus(MipUser mipUser);
	public List<MipUser> getUserList(MipUserExample curation);
	public MipUser getUser(String id);
	public int allPage(MipUserExample curation);
}
