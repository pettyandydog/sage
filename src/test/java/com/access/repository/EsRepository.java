package com.access.repository;

import com.access.annotation.Index;
import com.access.annotation.Param;
import com.access.annotation.Query;
import com.access.annotation.Type;

import java.util.Map;

/**
 * @author andy
 * @create 2017-05-10 17:06
 */
@Index({"zhijing1_8","zhijing2_8","zhijing3_8"})
public interface EsRepository {

    @Type("zj_wjbxx")
    @Query("{\"query\" : {\"match\" : {\"WPBH\" : \"804236775636 \" }}}")
    Map<String,Object> getPerson();

    @Type("zj_wjbxx")
    @Query("{\"query\" : {\"match\" : {\"WPBH\" : \"%{bh}\" }}}")
    Map<String,Object> getPerson2(@Param("bh") String bh);
}
