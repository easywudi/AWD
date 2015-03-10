package com.jintaimei.editview.view;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.CoreJdbcDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.uploader.UploadFile;
import com.bstek.dorado.uploader.annotation.FileResolver;
import com.bstek.dorado.web.DoradoContext;
import com.jintaimei.common.util.AwdUtils;
import com.jintaimei.editview.bean.HomePage;
import com.jintaimei.editview.bean.mapper.HomePageMapper;

@Component("editHomePagePr")
public class EditHomePagePr extends CoreJdbcDao {
	
	@DataProvider
	public void getHomePage(Page<HomePage> page) throws Exception {
		int pageNo = page.getPageNo();
		int pageSize = page.getPageSize();
		String sql = "SELECT * FROM HOME_PAGE ORDER BY SHOW_ORDER ASC LIMIT "+(pageNo-1)+","+pageSize;
		String countSql = "SELECT COUNT(*) FROM HOME_PAGE";
		List<HomePage> homePages = this.getJdbcTemplate().query(sql, new HomePageMapper());
		int total = this.getJdbcTemplate().queryForObject(countSql, Integer.class);
		page.setEntities(homePages);
		page.setEntityCount(total);
	}

	public List<HomePage> getListHomePage() {
		String sql = "SELECT * FROM HOME_PAGE ORDER BY SHOW_ORDER ";
		return this.getJdbcTemplate().query(sql, new HomePageMapper());
	}
	
	@FileResolver
	public String uploadImg(UploadFile file, Map<String, Object> parameter) throws Exception {
    	String saveImgFile = "/images/upload";
    	HttpServletRequest request = DoradoContext.getCurrent().getRequest();
    	String path = request.getSession().getServletContext().getRealPath(saveImgFile);
    	String copyPath = "/Users/raymondwu/backupimg";
    	String date = AwdUtils.getDateToString(new Date(), "yyyyMMddHHmmss");
    	String fileType = file.getFileName().substring(file.getFileName().indexOf("."));
    	String newFileName = date+fileType;
    	File targetFile = new File(path,newFileName);
    	File copyFile = new File(copyPath,newFileName);
    	if(!targetFile.exists()){
    		if(targetFile.mkdir()){
    			targetFile.mkdirs();
    		}
    	}
    	if(!copyFile.exists()){
    		if(copyFile.mkdir()){
    			copyFile.mkdirs();
    		}
    	}
    	file.transferTo(targetFile);
    	file.transferTo(copyFile);
 
        return saveImgFile+newFileName;
    }
	
}
