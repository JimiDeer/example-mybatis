package com.lc.access;

import com.lc.model.XTest;
import org.apache.ibatis.annotations.Select;

/**
 * @author: liuc
 * @date: 2020/4/23
 * @desc:
 */
public interface XTestMapper {
    XTest getObj(String id);
    @Select(value = "select * from xx_test where id = #{id}")
    XTest checkObj(String id, String name);
}
