package com.jintaimei.support.view;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.CoreJdbcDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.data.provider.Page;
import com.jintaimei.common.constant.AwdConstants;
import com.jintaimei.support.bean.ProjectDesc;
import com.jintaimei.support.bean.ProjectImg;
import com.jintaimei.support.bean.ProjectInfo;
import com.jintaimei.support.bean.mapper.ProjectDescMapper;
import com.jintaimei.support.bean.mapper.ProjectImgMapper;
import com.jintaimei.support.bean.mapper.ProjectInfoMapper;

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
	
	public List<ProjectInfo> getProjectInfo() {
		String sql = "SELECT * FROM PROJECT_INFO WHERE STATE='"+AwdConstants.YES+"'";
		return this.getJdbcTemplate().query(sql, new ProjectInfoMapper());
	}
	
	public List<ProjectImg> getProImg(String projectId) throws Exception {
		String sql = "SELECT * FROM PROJECT_IMG WHERE PROJECT_ID='"+projectId+"' AND STATE = '"+AwdConstants.YES+"' ORDER BY IMG_ORDER ASC ";
		return this.getJdbcTemplate().query(sql, new ProjectImgMapper());
	}
	
	public List<ProjectDesc> getProDesc(String projectId) throws Exception {
		String sql = "SELECT * FROM PROJECT_DESC WHERE PROJECT_ID='"+projectId+"' AND STATE = '"+AwdConstants.YES+"' ORDER BY PROJECT_DESC_ORDER ASC ";
		return this.getJdbcTemplate().query(sql, new ProjectDescMapper());
	}
	
	
	
}
