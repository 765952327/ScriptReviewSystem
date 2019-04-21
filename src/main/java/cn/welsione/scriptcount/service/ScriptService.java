package cn.welsione.scriptcount.service;

import cn.welsione.scriptcount.model.FileModel;
import cn.welsione.scriptcount.model.ScriptNumTb;

import java.util.List;
import java.util.Map;

public interface ScriptService {
    int updateRecord(Map<Integer, FileModel> lineMap, String group, String user, String version);
    List<ScriptNumTb> queryRecoar(String groupName);
    List<ScriptNumTb> queryGroupList();
}
