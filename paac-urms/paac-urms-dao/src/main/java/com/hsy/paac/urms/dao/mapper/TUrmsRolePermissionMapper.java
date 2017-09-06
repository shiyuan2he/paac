package com.hsy.paac.urms.dao.mapper;

import com.hsy.paac.urms.base.model.TUrmsRolePermission;
import com.hsy.paac.urms.base.model.TUrmsRolePermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUrmsRolePermissionMapper {
    long countByExample(TUrmsRolePermissionExample example);

    int deleteByExample(TUrmsRolePermissionExample example);

    int deleteByPrimaryKey(Integer rolePermissionId);

    int insert(TUrmsRolePermission record);

    int insertSelective(TUrmsRolePermission record);

    List<TUrmsRolePermission> selectByExample(TUrmsRolePermissionExample example);

    TUrmsRolePermission selectByPrimaryKey(Integer rolePermissionId);

    int updateByExampleSelective(@Param("record") TUrmsRolePermission record, @Param("example") TUrmsRolePermissionExample example);

    int updateByExample(@Param("record") TUrmsRolePermission record, @Param("example") TUrmsRolePermissionExample example);

    int updateByPrimaryKeySelective(TUrmsRolePermission record);

    int updateByPrimaryKey(TUrmsRolePermission record);
}