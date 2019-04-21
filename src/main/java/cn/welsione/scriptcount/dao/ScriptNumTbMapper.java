package cn.welsione.scriptcount.dao;

import cn.welsione.scriptcount.model.ScriptNumTb;

import java.util.List;

public interface ScriptNumTbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ScriptNumTb record);

    int insertSelective(ScriptNumTb record);

    ScriptNumTb selectByPrimaryKey(Integer id);

    ScriptNumTb selectByGroupName(String group,String fileName);

    List<ScriptNumTb> queryAll(String group);

    List<ScriptNumTb> queryList();

    int updateByPrimaryKeySelective(ScriptNumTb record);

    int updateByPrimaryKey(ScriptNumTb record);
}