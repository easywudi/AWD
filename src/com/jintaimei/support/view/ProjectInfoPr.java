package com.jintaimei.support.view;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.bstek.bdf2.core.CoreJdbcDao;
import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.uploader.UploadFile;
import com.bstek.dorado.uploader.annotation.FileResolver;
import com.bstek.dorado.web.DoradoContext;
import com.jintaimei.common.constant.AwdConstants;
import com.jintaimei.common.util.AwdUtils;
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
		int pageNo = page.getPageNo();
		int pageSize = page.getPageSize();
		String sql = "SELECT * FROM PROJECT_INFO ORDER BY CREATE_TIME DESC LIMIT "+(pageNo-1)+","+pageSize;
		String countSql = "SELECT COUNT(*) FROM PROJECT_INFO";
		List<ProjectInfo> homePages = this.getJdbcTemplate().query(sql, new ProjectInfoMapper());
		int total = this.getJdbcTemplate().queryForObject(countSql, Integer.class);
		page.setEntities(homePages);
		page.setEntityCount(total);
		
	}
	
	@DataProvider
	public List<ProjectDesc> getProjectDesc (String projectId) throws Exception {
		String sql = "SELECT * FROM PROJECT_DESC WHERE 1=1 AND PROJECT_ID = '"+projectId+"' ORDER BY PROJECT_DESC_ORDER ASC ";
		List<ProjectDesc> list = this.getJdbcTemplate().query(sql, new ProjectDescMapper());
		return list;
	}
	
	@DataProvider
	public List<ProjectImg> getProjectImg (String projectId) throws Exception {
		String sql = "SELECT * FROM PROJECT_IMG WHERE 1=1 AND PROJECT_ID = '"+projectId+"' ORDER BY IMG_ORDER ASC ";
		List<ProjectImg> list = this.getJdbcTemplate().query(sql, new ProjectImgMapper());
		return list;
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
	
	
	@Expose
	public void saveDetail(Map<String,String> param ) throws Exception {
		if(param!=null){
			String projectDescId = param.get("projectDescId");
			String title = param.get("title");
			String content = param.get("content");
			String projectId = param.get("projectId");
			String create = ContextHolder.getLoginUserName();
			String sql = "";
			if(StringUtils.hasText(projectDescId)){
				sql = "UPDATE PROJECT_DESC SET TITLE='"+title+"',CONTENT='"+content+"' WHERE PROJECT_DESC_ID = '"+projectDescId+"' ";
			} else {
				sql = "INSERT INTO PROJECT_DESC (PROJECT_DESC_ID,TITLE,CONTENT,CREATOR,CREATE_TIME,STATE,PROJECT_ID)"
						+ " VALUES ('"+AwdUtils.getUUID()+"','"+title+"','"+content+"','"+create+"',NOW(),'"+AwdConstants.YES+"','"+projectId+"') ";
			}
			this.getJdbcTemplate().update(sql);
		}
	}
	
	@Expose
	public void saveOrderDetail(List<ProjectDesc> list) throws Exception {
		if(list!=null){
			for(ProjectDesc pd : list){
				String sql = "UPDATE PROJECT_DESC SET PROJECT_DESC_ORDER = '"+pd.getProjectDescOrder()+"' WHERE PROJECT_DESC_ID = '"+pd.getProjectDescId()+"'";
				this.getJdbcTemplate().update(sql);
			}
		}
	}
	
	@Expose
	public void deleteDetail(String id) throws Exception {
		if(StringUtils.hasText(id)){
			String sql = "UPDATE PROJECT_DESC SET STATE = '"+AwdConstants.NO+"' WHERE PROJECT_DESC_ID = '"+id+"'";
			this.getJdbcTemplate().update(sql);
		}
	}
	
	@FileResolver
	public String uploadDetailImg(UploadFile file, Map<String, Object> parameter) throws Exception {
    	HttpServletRequest request = DoradoContext.getCurrent().getRequest();
    	String path = request.getSession().getServletContext().getRealPath(AwdConstants.ImgUrl.PROJECT_URL);
    	String date = AwdUtils.getDateToString(new Date(), "yyyyMMddHHmmss");
    	String fileType = file.getFileName().substring(file.getFileName().indexOf("."));
    	String newFileName = date+fileType;
    	File targetFile = new File(path,newFileName);
    	if(!targetFile.isDirectory()){
    		targetFile.mkdirs();
    	}
    	file.transferTo(targetFile);
        return AwdConstants.ImgUrl.PROJECT_URL+"/"+newFileName;
    }
	
	@Expose
	public void saveImgDetail(ProjectImg pi) throws Exception {
		String imgId = pi.getImgId();
		String imgFile = pi.getImgFile();
		String sql;
		if(StringUtils.hasText(imgId)) {
			sql = "UPDATE PROJECT_IMG SET IMG_FILE='"+imgFile+"' WHERE IMG_ID='"+imgId+"'";
		} else {
			sql = "INSERT INTO PROJECT_IMG (IMG_ID,IMG_FILE,PROJECT_ID,CREATOR,CREATE_TIME,STATE,IMG_ORDER)"
					+ " VALUES ('"+AwdUtils.getUUID()+"','"+imgFile+"','"+pi.getProjectId()+"','"+ContextHolder.getLoginUserName()+"',NOW(),'"+AwdConstants.YES+"','"+0+"')";
		}
		this.getJdbcTemplate().update(sql);		
	}
	
}
