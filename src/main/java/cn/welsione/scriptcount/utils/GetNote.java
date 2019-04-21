package cn.welsione.scriptcount.utils;

import java.io.*;

public class GetNote {
    public  int count=0;
    public int getFileLineNumber(File file) throws IOException {
        int countTag = 0;
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String temp = "";
        while (temp != null){
            temp = bufferedReader.readLine();
            if(temp != null&& (temp.contains("<script>")||temp.contains("<script type=\"text/javascript\">"))){
                while (temp!=null){
                    temp = bufferedReader.readLine();
                    if (temp != null && temp.contains("//")) {
//                        String substring = temp.substring(temp.indexOf("//"), temp.indexOf("//"));
//                        if (!substring.equals("  ")) {
//                            if (substring.contains(";") || substring.contains(":")) {
//
//                            } else {
//                                count++;
//                            }
//
//                        }
                        count++;
                    }
                    if (temp != null&& (temp.contains("/*")&&temp.contains("*/"))){
                        count++;
                        continue;
                    }if (temp != null&& temp.contains("/*")) {
                        count=count+2;
                        readUtilEndTag(bufferedReader);
                    }else  {
                        continue;
                    }
                }
            }else {
                continue;
            }

        }
//        System.out.println(count);
        return count;
    }
    public void readUtilEndTag(BufferedReader bufferedReader) throws IOException {
        String nextTemp = bufferedReader.readLine();
        if (nextTemp!=null&&!nextTemp.contains("*/")) {
            readUtilEndTag(bufferedReader);
            count++;
            System.out.println(">>"+count);
        }
    }
}
