package com.job.modules.Common.service;

import com.job.modules.Common.vo.UploadFileVO;
import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    UploadFileVO upload(MultipartFile file);
}
