package com.hsy.paac.urms.dao;

import com.hsy.paac.urms.base.model.TUrmsOrganization;
import com.hsy.paac.urms.base.model.TUrmsOrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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