package com.sguess.service.impl;

import com.sguess.dao.IMockDao;
import com.sguess.dao.entity.MockEntity;
import com.sguess.service.IMockService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.profiles.active=ut"})
public class MockServiceImplTest {

    @Autowired
    IMockService service;

    @InjectMocks
    MockServiceImpl injectMocksService;
//    IMockService injectMocksService;

//    @MockBean
//    IMockDao mockBeanDao;
//    @Mock
//    IMockDao mockDao;
    @Spy
    IMockDao spyDao;
//    @MockBeans
//    IMockDao mockBeansDao;

    @Autowired
    IMockDao realDao;

    @Before
    public void setup() {
        realDao.deleteAll();
        initDB();
    }

//    @Test
//    public void testMock() {
//        Assert.assertNotNull(service);
//        Assert.assertNotNull(injectMocksService);
//        Assert.assertNotNull(mockBeanDao);
//        Assert.assertNotNull(mockDao);
//        Assert.assertNotNull(spyDao);
//        List<MockEntity> mockList = new ArrayList<>();
//        mockList.add(new MockEntity("Jerry01", 11));
//        mockList.add(new MockEntity("Jerry02", 12));
//        mockList.add(new MockEntity("Jerry03", 13));
//        mockList.add(new MockEntity("Jerry04", 14));
//        mockList.add(new MockEntity("Jerry05", 15));
//        Mockito.when(mockDao.findAll()).thenReturn(mockList);
//        List<MockEntity> rstList = injectMocksService.mockTest();
//        assertEquals(5, rstList.size());
//        assertEquals(111, rstList.get(0).getAge());
//    }

    @Test
    public void testSpy() {
        List<MockEntity> mockList = new ArrayList<>();
        mockList.add(new MockEntity("Jerry01", 11));
        mockList.add(new MockEntity("Jerry02", 12));
        mockList.add(new MockEntity("Jerry03", 13));
        mockList.add(new MockEntity("Jerry04", 14));
        mockList.add(new MockEntity("Jerry05", 15));
        Mockito.when(spyDao.findAll()).thenReturn(mockList);
        List<MockEntity> rstList = injectMocksService.mockTest();
        assertEquals(5, rstList.size());
        assertEquals(111, rstList.get(0).getAge());
    }

    private void initDB() {
        realDao.save(new MockEntity("Tom01", 1));
        realDao.save(new MockEntity("Tom02", 2));
        realDao.save(new MockEntity("Tom03", 3));
        realDao.save(new MockEntity("Tom04", 4));
    }
}