package com.jintaimei.editview.bean.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jintaimei.editview.bean.ProjectImg;

public class ProjectImgMapper implements RowMapper<ProjectImg> {

	@Override
	public ProjectImg mapRow(ResultSet rs, int arg1) throws SQLException {
		ProjectImg pi = new ProjectImg();
		pi.setCreateTime(rs.getDate("CREATE_TIME"));
		pi.setCreator(rs.getString("CREATOR"));
		pi.setImgFile(rs.getString("IMG_NAME"));
		pi.setImgFile(rs.getString("IMG_FILE"));
		pi.setImgId(rs.getString("IMG_ID"));
		pi.setImgOrder(rs.getInt("IMG_ORDER"));
		pi.setState(rs.getString("STATE"));
		return pi;
	}
	
	

}
