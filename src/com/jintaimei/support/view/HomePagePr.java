package com.jintaimei.support.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.bstek.bdf2.core.CoreJdbcDao;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.Expose;
import com.bstek.dorado.data.provider.Page;
import com.bstek.dorado.uploader.UploadFile;
import com.bstek.dorado.uploader.annotation.FileResolver;
import com.bstek.dorado.web.DoradoContext;
import com.jintaimei.common.constant.AwdConstants;
import com.jintaimei.common.util.AwdUtils;
import com.jintaimei.support.bean.HomePage;
import com.jintaimei.support.bean.mapper.HomePageMapper;

@Component("homePagePr")
public class HomePagePr extends CoreJdbcDao {
	
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
    	HttpServletRequest request = DoradoContext.getCurrent().getRequest();
    	String path = request.getSession().getServletContext().getRealPath(AwdConstants.ImgUrl.PROJECT_URL);
    	String date = AwdUtils.getDateToString(new Date(), "yyyyMMddHHmmss");
    	String fileType = file.getFileName().substring(file.getFileName().indexOf("."));
    	String newFileName = date+fileType;
    	File targetFile = new File(path,newFileName);
    	File copyFile = new File(AwdConstants.ImgUrl.BACKUP_URL,newFileName);
    	if(!targetFile.isDirectory()){
    		targetFile.mkdirs();
    	}
    	if(!copyFile.isDirectory()){
			copyFile.mkdirs();
    	}
    	file.transferTo(targetFile);
    	//写入一个图片到指定的地址进行备份
    	BufferedImage image = ImageIO.read(targetFile);
    	ImageIO.write(image, fileType.substring(1,fileType.length()), copyFile);
        return AwdConstants.ImgUrl.PROJECT_URL+"/"+newFileName;
    }
	
	@Expose
	public void updateHomePage(HomePage hg) throws Exception {
		String sql = "UPDATE HOME_PAGE SET IMG_FILE = '" + hg.getImgFile()
				+ "',PROJECT_TITLE = '" + hg.getProjectTitle()
				+ "' , PROJECT_DESC='" + hg.getProjectDesc() + "' WHERE ID = '"
				+ hg.getId() + "' ";
		this.getJdbcTemplate().update(sql);		
	}
	
	@Expose
	public void updateShowOrder(List<HomePage> list) throws Exception {
		if(list != null && list.size() > 0){
			for(HomePage hg : list){
				String sql = "UPDATE HOME_PAGE SET SHOW_ORDER = '"
						+ hg.getShowOrder() + "' WHERE ID = '" + hg.getId()
						+ "'";
				this.getJdbcTemplate().update(sql);
			}
		}
	}
	
	
}
