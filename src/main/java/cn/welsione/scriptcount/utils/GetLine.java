package cn.welsione.scriptcount.utils;

import java.io.*;

public class GetLine {
    public  int count=0;
    public int getFileLineNumber(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String temp = "";
        while (temp != null){
            temp = bufferedReader.readLine();
            if (temp != null&& (temp.contains("<script>")||temp.contains("<script type=\"text/javascript\">"))){
                readUtilEndTag(bufferedReader);

            }else {
                continue;
            }
        }
        return count;
    }
    public void readUtilEndTag(BufferedReader bufferedReader) throws IOException {
        String nextTemp = bufferedReader.readLine();
        if (nextTemp!=null&&!nextTemp.equals("</script>")) {
            readUtilEndTag(bufferedReader);
            count++;
        }
    }
}
