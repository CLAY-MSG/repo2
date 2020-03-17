package com.xgk.dao;

import com.xgk.domain.Provider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/2/25 14:24
 */
@Repository
public interface ProviderDao {


    int findTotalCount();

    @Select("select * from smbms_provider")
    List<Provider> findAll();

    @Insert("insert into smbms_provider(proCode,proName,proDesc,proContact,proPhone,proAddress,proFax,createdBy,creationDate,modifyDate,modifyBy) " +
            "values (#{proCode},#{proName},#{proDesc},#{proContact},#{proPhone},#{proAddress},#{proFax},#{createdBy},#{creationDate},#{modifyDate},#{modifyBy})")
    int addProvider(Provider provider);

    @Update("update smbms_provider set proCode=#{proCode},proName = #{proName},proDesc=#{proDesc},proContact=#{proContact},proPhone=#{proPhone},proAddress=#{proAddress},proFax=#{proFax},createdBy=#{createdBy},creationDate=#{creationDate},modifyDate=#{modifyDate},modifyBy=#{modifyBy} where id = #{id}")
    int updateProvider(Provider provider);

    int updateProviderByCondition(Provider provider);

    int updateProviderByTrimCondition(Provider provider);

    @Delete("delete from smbms_provider where id = #{id}")
    int deleteProvider(Integer id);

    List<Provider> findAllProvider(Integer id);

    List<Provider> findAllProviderByCondition(Provider provider);

    List<Provider> findAllProviderByChooseCondition(Provider provider);



}
