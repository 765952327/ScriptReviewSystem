package cn.welsione.scriptcount.controller;

import cn.welsione.scriptcount.dao.ScriptNumTbMapper;
import cn.welsione.scriptcount.model.FileModel;
import cn.welsione.scriptcount.model.ScriptNumTb;
import cn.welsione.scriptcount.service.FileUpload;
import cn.welsione.scriptcount.service.ScriptService;
import cn.welsione.scriptcount.utils.FileUtil;
import cn.welsione.scriptcount.utils.GetScriptNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UploadController {
    @Autowired
    ScriptService scriptService;
    @RequestMapping(value = "/upload",method=RequestMethod.POST)
    public String  upload(@RequestParam("file") MultipartFile[] file,@RequestParam("group")String group,@RequestParam("user")String user,@RequestParam("version")String version) throws IOException {
        String path ="D:/upload";
        System.out.println(group);
//        System.out.println(file);
        String folder = file[0].getOriginalFilename();
        folder = folder.substring(0,folder.indexOf("/"));
        FileUtil.saveMultiFile(path, file);
        GetScriptNum scriptNum = new GetScriptNum();
        Map<Integer, FileModel> lineMap = scriptNum.getScripyInfo(path+"/"+folder);
        scriptService.updateRecord(lineMap,group,user,version);
        System.out.println(folder);

        return "success";
    }
}
