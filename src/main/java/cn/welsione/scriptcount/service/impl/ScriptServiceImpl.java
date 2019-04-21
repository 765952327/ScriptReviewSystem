package cn.welsione.scriptcount.service.impl;

import cn.welsione.scriptcount.dao.ScriptNumTbMapper;
import cn.welsione.scriptcount.model.FileModel;
import cn.welsione.scriptcount.model.ScriptNumTb;
import cn.welsione.scriptcount.service.ScriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ScriptServiceImpl implements ScriptService {
    @Autowired
    ScriptNumTbMapper scriptNumTbMapper;
    @Override
    public int updateRecord(Map<Integer, FileModel> lineMap,String group,String user,String version) {

        Date now = new Date();
        for (Map.Entry<Integer, FileModel> entry : lineMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue().getFileName()+","+entry.getValue().getScriptNum());
            ScriptNumTb scriptNumTb = new ScriptNumTb();
            scriptNumTb.setGroupName(group);
            scriptNumTb.setFileVersion(version);
            scriptNumTb.setFileName(entry.getValue().getFileName());
            scriptNumTb.setScriptNum(entry.getValue().getScriptNum());
            scriptNumTb.setNodoNum(entry.getValue().getNodeNum());
            scriptNumTb.setUploadUser(user);
            scriptNumTb.setUpdateDate(now);
            if (scriptNumTbMapper.selectByGroupName(group,entry.getValue().getFileName())==null){
                scriptNumTbMapper.insertSelective(scriptNumTb);
            }else {
                ScriptNumTb item =  scriptNumTbMapper.selectByGroupName(group,entry.getValue().getFileName());
                scriptNumTb.setId(item.getId());
                scriptNumTbMapper.updateByPrimaryKeySelective(scriptNumTb);
            }

        }
        return 1;
    }

    @Override
    public List<ScriptNumTb> queryRecoar(String groupName) {
        return scriptNumTbMapper.queryAll(groupName);
    }

    @Override
    public List<ScriptNumTb> queryGroupList() {
        return scriptNumTbMapper.queryList();
    }
}
