package com.jintaimei.support.view;

import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.CoreJdbcDao;

@Component
public class MessagePr extends CoreJdbcDao {

	
	public boolean saveMessage(String sql)  {
		int num = this.getJdbcTemplate().update(sql);
		return num > 0;
	}
	
}
