package com.job.modules.Common.controller;
import com.job.common.domain.Result;
import com.job.modules.Common.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class UploadFileController {
   @Autowired
   OssService ossService;

    @PostMapping(value = "/insertImg")
    public Result uploadFile(@RequestParam("file") MultipartFile file) {
        return new Result(ossService.upload(file));
    }
}