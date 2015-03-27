package com.jintaimei.support.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;

import com.jintaimei.common.constant.AwdConstants;
import com.jintaimei.common.util.AwdUtils;
import com.jintaimei.common.util.SpringContextsUtil;
import com.jintaimei.support.view.MessagePr;

public class MessageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -94526941199533232L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//联系人
		String user = req.getParameter("name_m");
		String username = "";
		//邮箱
		String email = req.getParameter("email_m");
		//内容
		String content = req.getParameter("content_m");
//		String content = con!=null?new String(con.getBytes("ISO-8859-1"),"utf-8"):"" ;
		//联系方式
		String phone = req.getParameter("phone_m");
		if(!StringUtils.hasText(user)){
			username = "未留姓名";
			email = "";
		} else {
			username = new String(user.getBytes("ISO-8859-1"),"utf-8") ;
		}
		String sql = "INSERT INTO GUEST_BOOK (ID,GUEST_NAME,GUEST_EMAIL,GUEST_PHONE,GUEST_MESSAGE,CREATE_TIME,STATE) "
				+ "VALUES ('"+AwdUtils.getUUID()+"','"+username+"','"+email+"','"+phone+"','"+content+"',NOW(),'"+AwdConstants.YES+"')";
		MessagePr messagePr = (MessagePr) SpringContextsUtil.getBean("messagePr");
		boolean flag = messagePr.saveMessage(sql);
		req.getSession().setAttribute("flag",flag);
		String url = req.getContextPath()+"/jsp/thankyou.jsp";
//		req.getRequestDispatcher(url).forward(req, resp);
		resp.sendRedirect(url);
		
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doHead(req, resp);
	}

	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(arg0, arg1);
	}



	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doTrace(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(arg0, arg1);
	}

	@Override
	protected long getLastModified(HttpServletRequest req) {
		// TODO Auto-generated method stub
		return super.getLastModified(req);
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(arg0, arg1);
	}
	
	

}
