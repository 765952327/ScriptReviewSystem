package cn.welsione.scriptcount.service.impl;


import cn.welsione.scriptcount.service.FileUpload;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileUploadImpl implements FileUpload {

    @Value("${LOCAL_FILE_PATH}")
    private String LOCAL_FILE_PATH;

    public String fileUpload(MultipartFile[] files, String group) {
        for(MultipartFile f:files){
            saveFile(f,group);
        }
        return null;
    }

    /**
     * 保存文件到本地
     * @param file
     * @param fileDir
     * @return
     */
    private String saveFile(MultipartFile file,String fileDir) {
        if(file.isEmpty()){
            System.out.println("文件为空");
        }

        String fileName = file.getOriginalFilename();
        File dir = new File(LOCAL_FILE_PATH+fileDir);
        if (!dir.exists()){
            dir.mkdir();
        }
        File dest = new File(LOCAL_FILE_PATH+fileDir+"/"+ fileName);


        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }


}
