package com.hsy.paac.urms.dao.mapper;

import com.hsy.paac.urms.base.model.TUrmsUserPermission;
import com.hsy.paac.urms.base.model.TUrmsUserPermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUrmsUserPermissionMapper {
    long countByExample(TUrmsUserPermissionExample example);

    int deleteByExample(TUrmsUserPermissionExample example);

    int deleteByPrimaryKey(Integer userPermissionId);

    int insert(TUrmsUserPermission record);

    int insertSelective(TUrmsUserPermission record);

    List<TUrmsUserPermission> selectByExample(TUrmsUserPermissionExample example);

    TUrmsUserPermission selectByPrimaryKey(Integer userPermissionId);

    int updateByExampleSelective(@Param("record") TUrmsUserPermission record, @Param("example") TUrmsUserPermissionExample example);

    int updateByExample(@Param("record") TUrmsUserPermission record, @Param("example") TUrmsUserPermissionExample example);

    int updateByPrimaryKeySelective(TUrmsUserPermission record);

    int updateByPrimaryKey(TUrmsUserPermission record);
}