package com.jintaimei.support.bean.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jintaimei.support.bean.ProjectDesc;

public class ProjectDescMapper implements RowMapper<ProjectDesc> {

	@Override
	public ProjectDesc mapRow(ResultSet rs, int arg1) throws SQLException {
		ProjectDesc pd = new ProjectDesc();
		pd.setContent(rs.getString("CONTENT"));
		pd.setCreateTime(rs.getDate("CREATE_TIME"));
		pd.setCreator(rs.getString("CREATOR"));
		pd.setProjectDescId(rs.getString("PROJECT_DESC_ID"));
		pd.setState(rs.getString("STATE"));
		pd.setTitle(rs.getString("TITLE"));
		pd.setProjectId(rs.getString("PROJECT_ID"));
		pd.setProjectDescOrder(rs.getInt("PROJECT_DESC_ORDER"));
		return pd;
	}

	
	
	
}
