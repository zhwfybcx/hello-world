/**
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.zwf.cms.web.controller.manage;

import com.zwf.cms.biz.process.ManageArticleBizProcess;
import com.zwf.cms.enums.ArticleConstant;
import com.zwf.cms.model.CmsProperties;
import com.zwf.cms.util.FTPService;
import com.zwf.cms.util.LoggerUtil;
import com.zwf.cms.util.StringUtils;
import com.zwf.cms.web.model.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weifeng
 * @version $Id: ManageArticleController.java, v 0.1 2017年03月17日 上午11:39  Exp$
 */
@Controller
@RequestMapping(value = "/manage/article")
public class ManageArticleController extends ManageBaseController {

	private static Logger logger = Logger.getLogger(ManageArticleController.class);

	@Autowired
	private ManageArticleBizProcess manageArticleBizProcess;

	@Autowired
	private CmsProperties cmsProperties;

/*	@Autowired
	ServletContext context;*/

	/**
	 * 返回分页列表页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String manage(@RequestParam(value = "folderId", defaultValue = "0") long folderId,
	                     @RequestParam(value = "p", defaultValue = "1") int pageNum, ModelMap modelMap,
			HttpServletRequest request) {
		ArticleInfo article = new ArticleInfo();
		article.setFolderid(folderId);
      //  String id = CookieUtil.getCookie(CookieUtil.ID, request);
		AdminVo adminVo = this.getAdmin(request);
		article.setAdminid(adminVo.getAdminId());
		PageVo<ArticleInfo> pageVo = manageArticleBizProcess.queryParmArticleList(article,pageNum, 10);
		pageVo.setList(manageArticleBizProcess.getArticleFolderNameList(pageVo.getList()));

        Map<String, String> Param = new HashMap<>();
        Param.put("folderId", String.valueOf(folderId));
        pageVo.setArgs(Param);
        modelMap.put("pageVo", pageVo);
        modelMap.put("folderId", folderId);
        return "manage/article/list";
	}

	/**
	 * 返回添加文章界面
	 *
	 * @return
	 */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addArticle(@RequestParam(value = "folderId", defaultValue = "0") long folderId,
	                         ModelMap modelMap, HttpServletRequest request) {
		AdminVo adminVo = this.getAdmin(request);
		List<FolderInfo> folderVos = folderBizProcess.getAllFolderList(adminVo.getAdminId());
		modelMap.put("foldervos", folderVos);
		modelMap.put("folderId", folderId);
		return "manage/article/add";
	}

	/**
	 * 添加文章
	 * @param articleVo 文章的vo类
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/json/add")
	public JsonVo<String> addNew(@RequestParam("file") MultipartFile file,
								 @ModelAttribute ArticleInfo articleVo, HttpServletRequest request) {
		JsonVo<String> json = new JsonVo<String>();
		try {
			String url = uploadFileToFtp(file, request);
            AdminVo adminVo =this.getAdmin(request);
			FolderInfo folder = folderBizProcess.queryFolderById(articleVo.getFolderid());
			String path = folder.getPath();
          //  String filepath =
			// 初始化文章对象
			articleVo.setAdminid(adminVo.getAdminId());
			articleVo.setPath(path);
			articleVo.setPicture(url);
			articleVo.setCheckif(ArticleConstant.check.yes.name());
			articleVo.setViewcount(0);
			articleVo.setCommentcount(0);
			articleVo.setCreatetime(new Date());

			long articleId = manageArticleBizProcess.addArticle(articleVo);
			LoggerUtil.info(logger, "添加文章成功",articleId);
			//HtmlGenerator.generator(articleId, request);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			LoggerUtil.error(logger, e, "添加文章出现异常",articleVo);
		}
		return json;
	}

	/**
	 * 删除一篇文章
	 * @param articleId
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/json/delete/{articleid}")
	public JsonVo<String> delete(@PathVariable("articleid") long articleId, HttpServletRequest request) {
		LoggerUtil.info(logger, "开始删除文章", articleId);
		JsonVo<String> json = new JsonVo<String>();
		try {
			manageArticleBizProcess.deleteById(articleId);
			json.setResult(true);
		} catch (Exception e) {
			json.setResult(false);
			LoggerUtil.error(logger, e, "删除出现异常");
		}
		LoggerUtil.info(logger, "删除文章结束", articleId);
		return json;
	}

	/**
	 * 进入更新文章页面
	 *
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/update/{articleid}")
	public String updateArticle(@PathVariable(value = "articleid") long articleid, ModelMap modelMap,
			HttpServletRequest request) {
		AdminVo adminVo = this.getAdmin(request);
		List<FolderInfo> folderVos = folderBizProcess.getAllFolderList(adminVo.getAdminId());
		ArticleInfo articleVo = manageArticleBizProcess.findByPrimary(articleid);
		modelMap.put("foldervos", folderVos);
		modelMap.put("articleVo", articleVo);
		return "manage/article/update";
	}

	/**
	 * ajax请求更新文章
	 * @param file
	 * @param articleVo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/json/update")
	public JsonVo<String> update(@RequestParam(value = "file", required = false) MultipartFile file,
			@ModelAttribute ArticleVo articleVo, HttpServletRequest request) throws Exception  {
		LoggerUtil.info(logger, "更新文章开始", "文章", articleVo);
		JsonVo<String> json = new JsonVo<String>();
		ArticleInfo articleVoNew = manageArticleBizProcess.findByPrimary(articleVo.getArticleid());
		try {
			if (file != null) {
				articleVoNew.setPicture(uploadFileToFtp(file, request));
			}
			articleVoNew.setTitle(articleVo.getTitle());
			articleVoNew.setContent(articleVo.getContent());
			articleVoNew.setStatus(articleVo.getStatus());
			articleVoNew.setFolderid(articleVo.getFolderid());
			FolderInfo folderVo = folderBizProcess.queryFolderById(articleVo.getFolderid());
			articleVoNew.setPath(folderVo.getPath());
				manageArticleBizProcess.update(articleVoNew);
			//HtmlGenerator.generator(articleVo.getArticleid(), request);
			json.setResult(true);

		} catch (Exception e) {
			LoggerUtil.error(logger, e, "更新文章出现异常", "文章", articleVo);
			json.setResult(false);
		}
		return json;
	}

	/**
	 * 富文本编辑器上传文件
	 *
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	@ResponseBody
	@RequestMapping(value = "/upload")
	public String upload(@RequestParam("myFileName") CommonsMultipartFile file, HttpServletRequest request)
			throws IOException, ServletException {
		return uploadFileToFtp(file, request);
	}

	/**
	 * 更改文章审核状态
	 * 
	 * @param articleId
	 * @param check
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/json/check")
	public JsonVo<String> checkIf(@RequestParam(value = "articleId") long articleId,
			@RequestParam(value = "check") String check) {
		JsonVo<String> jsonVo = new JsonVo<String>();
		ArticleInfo articleVo = manageArticleBizProcess.findByPrimary(articleId);
		articleVo.setCheckif(check);
		manageArticleBizProcess.update(articleVo);
		jsonVo.setResult(true);
		return jsonVo;
	}

	/**
	 * 返回指定目录下的文章列表
	 */
/*	@RequestMapping(value = "/pathlist")
	public String fodlerList(@RequestParam(value = "folderId", defaultValue = "0") long folderId,
			@RequestParam(value = "p", defaultValue = "1") int pageNum, ModelMap modelMap) {
		PageVo<ArticleVo> list = manageArticleBizProcess.queryParmArtList(folderId, pageNum);
		Map<String, String> Param = new HashMap<>();
		Param.put("folderId", String.valueOf(folderId));
		list.setArgs(Param);
		for (ArticleVo articleVo : list.getList()) {
			FolderVo folderVo = folderBizProcess.queryFolderById(articleVo.getFolderid());
			articleVo.setPathName(folderVo.getName());
		}
		modelMap.put("pageVo", list);
		modelMap.put("folderId", folderId);
		return "/manage/article/list";
	}*/
	
	/**
	 * 上传文件到ftp，暂时放在这里
	 * 
	 * @param file
	 * @param request
	 * @return
	 */
	public String uploadFileToFtp(MultipartFile file,HttpServletRequest request){
		if(file == null){
			return "";
		}
		try {
			// 获得原始文件名
			String fileName = file.getOriginalFilename();
			//新文件名为时间戳
			String newFileName = System.currentTimeMillis() +"."+ StringUtils.split(fileName, '.')[1];
			// 获得项目路径
			ServletContext sc = request.getSession().getServletContext();
			String path = sc.getRealPath("/static/image") + File.separator; // 设定文件保存的目录
			File f = new File(path);
			if (!f.exists()){
				f.mkdirs();
			}
			if (!file.isEmpty()) {
				FileOutputStream fos = new FileOutputStream(path + newFileName);
				InputStream in = file.getInputStream();
				int b = 0;
				while ((b = in.read()) != -1) {
					fos.write(b);
				}
				fos.close();
				in.close();
			}
			String imgUrl = FTPService.uploadFile(newFileName, StringUtils.joinString(path, newFileName));
			File file2 = new File(StringUtils.joinString(path, newFileName));
			file2.delete();
			LoggerUtil.info(logger, "文件上传完毕,路径为", imgUrl);
			return StringUtils.joinString( cmsProperties.getFtp(), imgUrl);
		} catch (Exception e) {
			LoggerUtil.error(logger,e);
			return "";
		}
	}
	
	/**
     * 预览
     * @param articleid
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/preview",method=RequestMethod.GET)
    public String  preview(@RequestParam long articleid,ModelMap modelMap,HttpServletRequest request){
        try {
            ArticleInfo articleVo = manageArticleBizProcess.findByPrimary(articleid);
            modelMap.addAttribute("article", articleVo);
            return "/template/pcontent";
        }catch (Exception e){
            return "/404";
        }
    }
    
}
