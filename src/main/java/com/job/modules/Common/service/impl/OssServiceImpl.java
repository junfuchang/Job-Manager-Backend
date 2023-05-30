package com.job.modules.Common.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.job.common.config.AliyunConfig;
import com.job.common.domain.Result;
import com.job.common.enums.Code;
import com.job.common.exception.BusinessException;
import com.job.common.exception.SystemException;
import com.job.modules.Common.service.OssService;
import com.job.modules.Common.vo.UploadFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;

@Service
public class OssServiceImpl implements OssService {
    // 允许上传的格式
    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg",
            ".jpeg", ".gif", ".png"};
    @Autowired
    private OSS ossClient;
    @Autowired
    private AliyunConfig aliyunConfig;

    @Override
    public UploadFileVO upload(MultipartFile file) {
        //文件新路径
        String fileName = file.getOriginalFilename();
        // 校验图片格式
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(fileName, type)) {
                isLegal = true;
                break;
            }
        }
        if (!isLegal) {
            throw new BusinessException(Code.BUSINESS_ERR,"不允许上传该后缀的文件！");
        }
        Calendar date = Calendar.getInstance();
        String filePath =  date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH) + 1) +File.separator + System.currentTimeMillis() + fileName;
        // 上传到阿里云
        try {
            ossClient.putObject(aliyunConfig.getBucketName(), filePath, new ByteArrayInputStream(file.getBytes()));
        } catch (Exception e) {
            throw new SystemException(Code.FAILED,"上传文件失败");
        }

        UploadFileVO uploadFileVO = new UploadFileVO();
        uploadFileVO.setTitle(fileName);
        uploadFileVO.setSrc(this.aliyunConfig.getUrlPrefix() + filePath);
        return uploadFileVO;
    }


    /**
     * @desc 查看文件列表
     * 文档链接 https://help.aliyun.com/document_detail/84841.html?spm=a2c4g.11186623.2.13.3ad5b5ddqxWWRu#concept-84841-zh
     */
//    public List<OSSObjectSummary> list() {
//        // 设置最大个数。
//        final int maxKeys = 200;
//        // 列举文件。
//        ObjectListing objectListing = ossClient.listObjects(new ListObjectsRequest(aliyunConfig.getBucketName()).withMaxKeys(maxKeys));
//        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
//        return sums;
//    }
    /**
     * @desc 删除文件
     * 文档链接 https://help.aliyun.com/document_detail/84842.html?spm=a2c4g.11186623.6.770.4f9474b4UYlCtr
     */
//    public FileUploadResult delete(String objectName) {
//        ossClient.deleteObject(aliyunConfig.getBucketName(), objectName);
//        FileUploadResult fileUploadResult = new FileUploadResult();
//        fileUploadResult.setName(objectName);
//        fileUploadResult.setStatus("removed");
//        fileUploadResult.setResponse("success");
//        return fileUploadResult;
//    }
    /**
     * @desc 下载文件
     * 文档链接 https://help.aliyun.com/document_detail/84823.html?spm=a2c4g.11186623.2.7.37836e84ZIuZaC#concept-84823-zh
     */
//    public InputStream exportOssFile(String objectName) {
//        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
//        OSSObject ossObject = ossClient.getObject(aliyunConfig.getBucketName(), objectName);
//        // 读取文件内容。
//        InputStream is = ossObject.getObjectContent();
//        return is;
//    }


    /**
     * 弃用，留着用作上传文件的参考
     */
    // 文件保存目录，物理路径
    public final String rootPath = "/Users/cjf/Documents/uploads";
    //    public final String rootPath = "D:\\uploads";
    public final String allowSuffix = ".bmp.jpg.jpeg.png.gif.pdf.doc.zip.rar.gz";
    public Result uploadImg(@RequestParam("file") MultipartFile file, HttpServletRequest req) throws FileNotFoundException {
        //1.文件后缀过滤，只允许部分后缀
        //文件的完整名称,如spring.jpeg
        String filename = file.getOriginalFilename();
        //文件名,如spring
        String name = filename.substring(0, filename.indexOf("."));
        //文件后缀,如.jpeg
        String suffix = filename.substring(filename.lastIndexOf("."));
        if (allowSuffix.indexOf(suffix) == -1) {
            return new Result(Code.BUSINESS_ERR,null,"不允许上传该后缀的文件！");
        }

        //2.创建文件目录
        //创建年月文件夹
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR)
                + File.separator + (date.get(Calendar.MONTH) + 1));
        //目标文件
        File descFile = new File(rootPath + File.separator + dateDirs + File.separator + filename);

        int i = 1;
        //若文件存在重命名
        String newFilename = filename;
        while (descFile.exists()) {
            newFilename = name + "(" + i + ")" + suffix;
            String parentPath = descFile.getParent();
            descFile = new File(parentPath + File.separator + newFilename);
            i++;
        }
        //判断目标文件所在的目录是否存在
        if (!descFile.getParentFile().exists()) {
            //如果目标文件所在的目录不存在，则创建父目录
            descFile.getParentFile().mkdirs();
        }

        //3.存储文件
        //将内存中的数据写入磁盘
        try {
            file.transferTo(descFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //完整的url
        String fileUrl = "/uploads/" + dateDirs + "/" + newFilename;

        //4.返回URL
        UploadFileVO uploadFileVO = new UploadFileVO();
        uploadFileVO.setTitle(filename);
        uploadFileVO.setSrc(fileUrl);
        return new Result(uploadFileVO);
    }
}
