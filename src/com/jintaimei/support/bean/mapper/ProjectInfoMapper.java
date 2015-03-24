package com.jintaimei.support.bean.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jintaimei.support.bean.ProjectInfo;

public class ProjectInfoMapper implements RowMapper<ProjectInfo> {

	@Override
	public ProjectInfo mapRow(ResultSet rs, int arg1) throws SQLException {
		ProjectInfo pi = new ProjectInfo();
		pi.setCreateTime(rs.getDate("CREATE_TIME"));
		pi.setCreator(rs.getString("CREATOR"));
		pi.setImgFile(rs.getString("IMG_FILE"));
		pi.setProjectId(rs.getString("PROJECT_ID"));
		pi.setProjectAbout(rs.getString("PROJECT_ABOUT"));
		pi.setProjectDescId(rs.getString("PROJECT_DESC_ID"));
		pi.setProjectImgId(rs.getString("PROJECT_IMG_ID"));
		pi.setProjectName(rs.getString("PROJECT_NAME"));
		pi.setProjectType(rs.getString("PROJECT_TYPE"));
		pi.setState(rs.getString("STATE"));
		return pi;
	}
	
	

}
