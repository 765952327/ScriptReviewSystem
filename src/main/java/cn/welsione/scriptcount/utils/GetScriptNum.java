package cn.welsione.scriptcount.utils;

import cn.welsione.scriptcount.model.FileModel;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class GetScriptNum {
    public Map<Integer, FileModel> getScripyInfo(String path) throws IOException {
        Map<Integer,FileModel> lineMap = new LinkedHashMap<Integer,FileModel>();
        FindFile findFile = new FindFile();
        findFile.traverseFolder(path);
//        findFile.getMap();
        Map<Integer, File> map = findFile.getMap();
        for (Map.Entry<Integer, File> entry : map.entrySet()) {
            FileModel fileModel = new FileModel();
            GetLine lineNum = new GetLine();
            GetNote noteNum = new GetNote();
            String fileName = entry.getValue().getAbsolutePath();
            fileModel.setFileName(fileName.substring(fileName.indexOf("upload\\")+7,fileName.length()+0));
            fileModel.setScriptNum(lineNum.getFileLineNumber(entry.getValue()));
            fileModel.setNodeNum(noteNum.getFileLineNumber(entry.getValue()));
            lineMap.put(entry.getKey(),fileModel);
        }
        System.out.println(map);

        return lineMap;
    }
}
