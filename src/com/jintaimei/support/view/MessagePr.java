package com.jintaimei.support.view;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.CoreJdbcDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.data.provider.Page;
import com.jintaimei.common.util.AwdUtils;
import com.jintaimei.support.bean.GuestBook;
import com.jintaimei.support.bean.mapper.GuestBookMapper;

@Component
public class MessagePr extends CoreJdbcDao {

	
	@DataProvider
	public void pageMessage (Map<String,Object> param,Page<GuestBook> page) throws Exception{
		String sql = "SELECT * FROM GUEST_BOOK WHERE 1=1 ";
		StringBuffer condition = new StringBuffer();
		if(param!=null){
			Date startDate = (Date)param.get("startDate");
			Date endDate = (Date)param.get("endDate");
			String start = AwdUtils.getDateToString(startDate, "yyyy-MM-dd") + " 00:00";
			String end = AwdUtils.getDateToString(endDate, "yyyy-MM-dd") + " 23:59";
			if(startDate != null && endDate != null){
				condition.append(" AND (CREATE_TIME >= '"+start+"' AND CREATE_TIME <= '"+end+"')");
			}
		}
		this.pagingQuery(page, sql + condition.toString() + " ORDER BY CREATE_TIME DESC ", new GuestBookMapper());
		
	}
	
	public boolean saveMessage(String sql)  {
		int num = this.getJdbcTemplate().update(sql);
		return num > 0;
	}
	
}
