package com.ajax.dao;

import com.ajax.utils.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @author Di Guan on 6/16/2021 12:06 AM
 */

public class MajorDaoImpl implements MajorDao{
    @Override
    public List<Map> fetchMajor() {
        String SQL = "SELECT * FROM major";
        return JDBCUtils.executeQuery(SQL);
    }
}
