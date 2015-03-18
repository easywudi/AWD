package com.jintaimei.support.view;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.CoreJdbcDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.data.provider.Page;
import com.jintaimei.support.bean.ProjectDesc;
import com.jintaimei.support.bean.ProjectImg;
import com.jintaimei.support.bean.ProjectInfo;

@Component
public class ProjectInfoPr extends CoreJdbcDao {

	@DataProvider
	public void pageProjectInfo (Page<ProjectInfo> page,Map<String,Object> param) throws Exception {
		
	}
	
	public List<ProjectDesc> getProjectDesc (String descId) throws Exception {
		
		return null;
	}
	
	public List<ProjectImg> getProjectImg (String imgId) throws Exception {
		
		return null;
	}
	
	
}
