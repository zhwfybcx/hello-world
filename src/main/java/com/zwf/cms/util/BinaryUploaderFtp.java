package com.zwf.cms.util;

import com.baidu.ueditor.PathFormat;
import com.baidu.ueditor.define.AppInfo;
import com.baidu.ueditor.define.BaseState;
import com.baidu.ueditor.define.FileType;
import com.baidu.ueditor.define.State;
import com.baidu.ueditor.upload.StorageManager;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2017/3/26.
 */
public class BinaryUploaderFtp {
    public static final State save(HttpServletRequest request,
                                   Map<String, Object> conf) {
        boolean isAjaxUpload = request.getHeader("X_Requested_With") != null;

        if (!ServletFileUpload.isMultipartContent(request)) {
            return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
        }

        ServletFileUpload upload = new ServletFileUpload(
                new DiskFileItemFactory());

        if (isAjaxUpload) {
            upload.setHeaderEncoding("UTF-8");
        }

        try {
            /*MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("upfile");*/
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            Iterator iter = multipartRequest.getFileNames();
            MultipartFile file = null;
            while (iter.hasNext()) {
                file=multipartRequest.getFile(iter.next().toString());
            }

            // FileItemIterator iter = multipartRequest.getFileNames();
            // FileItemIterator iterator = upload.getItemIterator(request);
            //
            // while (iterator.hasNext()) {
            // fileStream = iterator.next();
            //
            // if (!fileStream.isFormField())
            // break;
            // fileStream = null;
            // }
            //
            // if (fileStream == null) {
            // return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
            // }

            String savePath = (String) conf.get("savePath");
            String originFileName = file.getOriginalFilename();
            String suffix = FileType.getSuffixByFilename(originFileName);

            originFileName = originFileName.substring(0,
                    originFileName.length() - suffix.length());
            savePath = savePath + suffix;

            long maxSize = ((Long) conf.get("maxSize")).longValue();

            if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
                return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
            }

            savePath = PathFormat.parse(savePath, originFileName);

            String physicalPath = (String) conf.get("rootPath") + savePath;

            InputStream is = file.getInputStream();
            State storageState = StorageManager.saveFileByInputStream(is,
                    physicalPath, maxSize);
            is.close();
            FTPService ftemp = new FTPService();
            String s = ftemp.uploadFile(System.currentTimeMillis()+ suffix, physicalPath);
            // 删除上传本地文件（暂时这样写）
            File fileDel  = new File(physicalPath);
            File fileParent = new File(fileDel.getParent());
            fileDel.delete();
            fileParent.delete();
            //判定是否上传成功
            PropertyPlaceholder propertyPlaceholder = new PropertyPlaceholder();
            if (storageState.isSuccess()) {
				/*storageState.putInfo("url", "http://files.maidoupo.com/ccfile/" + s);*/
                storageState.putInfo("url", propertyPlaceholder.getProperty("cms.ftp")+ s);
                storageState.putInfo("type", suffix);
                storageState.putInfo("original", originFileName + suffix);
            }

            return storageState;
        } catch (IOException e) {
            return new BaseState(false, AppInfo.IO_ERROR);
        }

    }

    private static boolean validType(String type, String[] allowTypes) {
        List<String> list = Arrays.asList(allowTypes);

        return list.contains(type);
    }
}
