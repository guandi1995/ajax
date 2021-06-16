package com.ajax.dao;

import com.ajax.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author Di Guan on 6/8/2021 11:09 PM
 */

public class test {
    public static void main(String[] args) {
        MajorDaoImpl majorDao = new MajorDaoImpl();
        List<Map> maps = majorDao.fetchMajor();
        System.out.println(maps);
    }
}
