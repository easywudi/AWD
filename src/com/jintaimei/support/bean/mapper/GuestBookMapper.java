package com.jintaimei.support.bean.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jintaimei.support.bean.GuestBook;

public class GuestBookMapper implements RowMapper<GuestBook> {

	@Override
	public GuestBook mapRow(ResultSet rs, int arg1) throws SQLException {
		GuestBook gb = new GuestBook();
		gb.setCreateTime(rs.getDate("CREATE_TIME"));
		gb.setGuestEmail(rs.getString("GUEST_EMAIL"));
		gb.setGuestMessage(rs.getString("GUEST_MESSAGE"));
		gb.setGuestName(rs.getString("GUEST_NAME"));
		gb.setGuestPhone(rs.getString("GUEST_PHONE"));
		gb.setId(rs.getString("ID"));
		gb.setState(rs.getString("STATE"));
		return gb;
	}
	
	

}
