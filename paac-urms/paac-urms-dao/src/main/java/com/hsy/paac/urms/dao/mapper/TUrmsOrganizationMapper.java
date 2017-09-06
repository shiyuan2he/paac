package com.hsy.paac.urms.dao.mapper;

import com.hsy.paac.urms.base.model.TUrmsOrganization;
import com.hsy.paac.urms.base.model.TUrmsOrganizationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUrmsOrganizationMapper {
    long countByExample(TUrmsOrganizationExample example);

    int deleteByExample(TUrmsOrganizationExample example);

    int deleteByPrimaryKey(Integer organizationId);

    int insert(TUrmsOrganization record);

    int insertSelective(TUrmsOrganization record);

    List<TUrmsOrganization> selectByExample(TUrmsOrganizationExample example);

    TUrmsOrganization selectByPrimaryKey(Integer organizationId);

    int updateByExampleSelective(@Param("record") TUrmsOrganization record, @Param("example") TUrmsOrganizationExample example);

    int updateByExample(@Param("record") TUrmsOrganization record, @Param("example") TUrmsOrganizationExample example);

    int updateByPrimaryKeySelective(TUrmsOrganization record);

    int updateByPrimaryKey(TUrmsOrganization record);
}