package cn.welsione.scriptcount.controller;

import cn.welsione.scriptcount.model.ScriptNumTb;
import cn.welsione.scriptcount.service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController

@RequestMapping("/")
public class ScriptController {
    @Autowired
    ScriptService scriptService;
    @RequestMapping("/showList")
    public List<ScriptNumTb> showList(){

       List<ScriptNumTb> list = scriptService.queryGroupList();
        List<ScriptNumTb> res = new ArrayList<>();

        for (ScriptNumTb i:list
             ) {
            int count = 0;
            int node = 0;
            List<ScriptNumTb> itemList = scriptService.queryRecoar(i.getGroupName());
            for (ScriptNumTb j:itemList
                 ) {
                count = count + j.getScriptNum();
                node = node +j.getNodoNum();
            }
            i.setScriptNum(count);
            i.setNodoNum(node);
            res.add(i);
        }
        return res;
    }
    @RequestMapping("/showDetails")
    public List<ScriptNumTb> showDetails(@RequestParam("groupName")String group){
        List<ScriptNumTb> list = scriptService.queryRecoar(group);
        return list;
    }


}
