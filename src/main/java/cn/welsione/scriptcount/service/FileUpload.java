package cn.welsione.scriptcount.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUpload {
    String fileUpload(MultipartFile[] files, String group);
}
