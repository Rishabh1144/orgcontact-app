package com.rishabh.orgcontactapp.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryConfig {

    private static Cloudinary cloudinary;

    public static Cloudinary getInstance() {

        if (cloudinary == null) {
            cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", "dozh0vncl",
                    "api_key", "562959488713457",
                    "api_secret", "3xS19HsTfJDoUudz0zg0pVI9kqI"
            ));
        }

        return cloudinary;
    }
}