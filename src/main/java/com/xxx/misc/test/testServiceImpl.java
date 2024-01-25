package com.xxx.misc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testServiceImpl implements testService {
    @Autowired
    private testMapper testmapper;

    @Override
    public Test fid(Integer id) {
        return testmapper.fid(id);
    }
}
