package com.ajax.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Di Guan on 6/5/2021 11:38 PM
 */

public class test {
    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Map> maps = studentDao.fetchStudent();
        System.out.println(maps);
    }
}
