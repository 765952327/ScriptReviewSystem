package cn.welsione.scriptcount.utils;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFile {
    private int count = 0;
    private Map<Integer,File> map = new LinkedHashMap<Integer,File>();
    public void traverseFolder(String path) {

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                return ;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
//                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        traverseFolder(file2.getAbsolutePath());
                    } else {
//                        System.out.println("文件:" + file2.getAbsolutePath());
                        String fileName = file2.getName();
                        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
//                        System.out.println(suffix);
                        if (suffix.equals("html")||suffix.equals(".html")){
//                            System.out.println(suffix);
                            this.map.put(count,file2);
                            count++;
                        }

                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
    public  Map<Integer,File> getMap(){
        return map;
    }
}
