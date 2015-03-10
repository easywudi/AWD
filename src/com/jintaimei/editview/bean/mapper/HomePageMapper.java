package com.jintaimei.editview.bean.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jintaimei.editview.bean.HomePage;

public class HomePageMapper implements RowMapper<HomePage> {

	@Override
	public HomePage mapRow(ResultSet rs, int arg1) throws SQLException {
		HomePage hg = new HomePage();
		hg.setDetailLink(rs.getString("DETAIL_LINK"));
		hg.setId(rs.getString("ID"));
		hg.setImgFile(rs.getString("IMG_FILE"));
		hg.setProjectDesc(rs.getString("PROJECT_DESC"));
		hg.setProjectTitle(rs.getString("PROJECT_TITLE"));
		return hg;
	}
	
}
