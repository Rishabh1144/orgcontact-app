package com.rishabh.orgcontactapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.rishabh.orgcontactapp.service.ImageService;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/uploadProfileImage")
    @ResponseBody
    public String uploadProfileImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("phone") String phone,
            @RequestParam("org_id") Integer orgId) {

        return imageService.uploadProfileImage(file, phone, orgId);
    }
}