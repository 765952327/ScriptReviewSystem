package cn.welsione.scriptcount.model;

public class FileModel {
    private String fileName;
    private int scriptNum;
    private int nodeNum;

    public int getNodeNum() {
        return nodeNum;
    }

    public void setNodeNum(int nodeNum) {
        this.nodeNum = nodeNum;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getScriptNum() {
        return scriptNum;
    }

    public void setScriptNum(int scriptNum) {
        this.scriptNum = scriptNum;
    }
}
