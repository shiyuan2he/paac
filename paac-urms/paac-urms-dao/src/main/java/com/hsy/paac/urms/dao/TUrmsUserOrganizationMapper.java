package com.hsy.paac.urms.dao;

import com.hsy.paac.urms.base.model.TUrmsUserOrganization;
import com.hsy.paac.urms.base.model.TUrmsUserOrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUrmsUserOrganizationMapper {
    long countByExample(TUrmsUserOrganizationExample example);

    int deleteByExample(TUrmsUserOrganizationExample example);

    int deleteByPrimaryKey(Integer userOrganizationId);

    int insert(TUrmsUserOrganization record);

    int insertSelective(TUrmsUserOrganization record);

    List<TUrmsUserOrganization> selectByExample(TUrmsUserOrganizationExample example);

    TUrmsUserOrganization selectByPrimaryKey(Integer userOrganizationId);

    int updateByExampleSelective(@Param("record") TUrmsUserOrganization record, @Param("example") TUrmsUserOrganizationExample example);

    int updateByExample(@Param("record") TUrmsUserOrganization record, @Param("example") TUrmsUserOrganizationExample example);

    int updateByPrimaryKeySelective(TUrmsUserOrganization record);

    int updateByPrimaryKey(TUrmsUserOrganization record);
}