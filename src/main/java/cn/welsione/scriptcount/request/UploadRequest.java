package cn.welsione.scriptcount.request;

import org.springframework.web.multipart.MultipartFile;

public class UploadRequest {
    private String group;
    private MultipartFile[] file;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public MultipartFile[] getFile() {
        return file;
    }

    public void setFile(MultipartFile[] file) {
        this.file = file;
    }
}
