package com.hsy.paac.urms.dao;

import com.hsy.paac.urms.base.model.TUrmsPermission;
import com.hsy.paac.urms.base.model.TUrmsPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUrmsPermissionMapper {
    long countByExample(TUrmsPermissionExample example);

    int deleteByExample(TUrmsPermissionExample example);

    int deleteByPrimaryKey(Integer permissionId);

    int insert(TUrmsPermission record);

    int insertSelective(TUrmsPermission record);

    List<TUrmsPermission> selectByExample(TUrmsPermissionExample example);

    TUrmsPermission selectByPrimaryKey(Integer permissionId);

    int updateByExampleSelective(@Param("record") TUrmsPermission record, @Param("example") TUrmsPermissionExample example);

    int updateByExample(@Param("record") TUrmsPermission record, @Param("example") TUrmsPermissionExample example);

    int updateByPrimaryKeySelective(TUrmsPermission record);

    int updateByPrimaryKey(TUrmsPermission record);
}