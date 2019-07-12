package com.cc.ssm.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/uploadPage")
    public String uploadPage(){
        return "uploadPage";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file, Model model){
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        log.info("fileName: "+fileName);
        String destFileName = request.getServletContext().getRealPath("")+"upload"+ File.separator + fileName;
        log.info("destFileName: "+destFileName);
        File destFile  = new File(destFileName);
        destFile.getParentFile().mkdirs();
        try {
            file.transferTo(destFile);
            model.addAttribute("fileName",fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败，"+e.getMessage();
        }
        return "uploadPage";
    }
}
