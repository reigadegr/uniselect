package com.xxx.misc.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class testServiceImpl : testService {
    @Autowired
    private lateinit var testmapper: testMapper


    override fun fid(id: Int): Test? {
        return testmapper.fid(id)
    }
}
