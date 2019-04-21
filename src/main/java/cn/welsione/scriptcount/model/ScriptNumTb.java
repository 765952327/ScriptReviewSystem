package cn.welsione.scriptcount.model;

import java.util.Date;

public class ScriptNumTb {
    private Integer id;

    private String groupName;

    private String fileName;

    private Integer scriptNum;

    private Integer nodoNum;

    private String fileVersion;

    private String uploadUser;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Integer getScriptNum() {
        return scriptNum;
    }

    public void setScriptNum(Integer scriptNum) {
        this.scriptNum = scriptNum;
    }

    public Integer getNodoNum() {
        return nodoNum;
    }

    public void setNodoNum(Integer nodoNum) {
        this.nodoNum = nodoNum;
    }

    public String getFileVersion() {
        return fileVersion;
    }

    public void setFileVersion(String fileVersion) {
        this.fileVersion = fileVersion == null ? null : fileVersion.trim();
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser == null ? null : uploadUser.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}