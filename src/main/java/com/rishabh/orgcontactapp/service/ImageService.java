package com.rishabh.orgcontactapp.service;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.rishabh.orgcontactapp.config.CloudinaryConfig;
import com.rishabh.orgcontactapp.dao.ContactDao;
import com.rishabh.orgcontactapp.model.Contact;

@Service
public class ImageService {

    @Autowired
    private ContactDao contactDao;

    @Transactional
    public String uploadProfileImage(MultipartFile file, String phone, Integer orgId) {

        try {

            Cloudinary cloudinary = CloudinaryConfig.getInstance();

            String publicId = "user-" + phone + "-" + orgId;

            Map uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap(
                            "public_id", publicId,
                            "overwrite", true,
                            "invalidate", true
                    )
            );

            String imageUrl = uploadResult.get("secure_url").toString();

            // ✅ Save in DB
            Contact contact = contactDao.getContactByPhoneAndOrg(phone, orgId);
            if(contact!=null) {
            	contact.setProfileImageUrl(imageUrl);
            	contactDao.updateContact(contact);
            }

            return imageUrl;

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}