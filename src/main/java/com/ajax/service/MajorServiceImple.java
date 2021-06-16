package com.ajax.service;

import com.ajax.dao.MajorDao;
import com.ajax.dao.MajorDaoImpl;
import com.ajax.pojo.Message;

import java.util.List;
import java.util.Map;

/**
 * @author Di Guan on 6/16/2021 12:37 AM
 */

public class MajorServiceImple implements MajorService{
    private MajorDao majorDao = new MajorDaoImpl();
    @Override
    public List<Map> fetchMajor() {
        return majorDao.fetchMajor();
    }
}
