package com.hsy.paac.urms.dao;

import com.hsy.paac.urms.base.model.TUrmsRole;
import com.hsy.paac.urms.base.model.TUrmsRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUrmsRoleMapper {
    long countByExample(TUrmsRoleExample example);

    int deleteByExample(TUrmsRoleExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(TUrmsRole record);

    int insertSelective(TUrmsRole record);

    List<TUrmsRole> selectByExample(TUrmsRoleExample example);

    TUrmsRole selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") TUrmsRole record, @Param("example") TUrmsRoleExample example);

    int updateByExample(@Param("record") TUrmsRole record, @Param("example") TUrmsRoleExample example);

    int updateByPrimaryKeySelective(TUrmsRole record);

    int updateByPrimaryKey(TUrmsRole record);
}