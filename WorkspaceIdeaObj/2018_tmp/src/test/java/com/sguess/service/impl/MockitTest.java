package com.sguess.service.impl;

import com.sguess.dao.IMockDao;
import com.sguess.dao.entity.MockEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockitTest {


    @InjectMocks
    MockServiceImpl injectMocksService;
    @Spy
    IMockDao spyDao;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBehivar() {
        // mock creation
        List mockedList = mock(List.class);
        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();
        // selective, explicit, highly readable verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void testForMock() {
        List mock = mock(List.class);
        //Below 2 line are OK.
        when(mock.get(0)).thenReturn("one");
//        doReturn("one").when(mock).get(0);
        assertEquals("one", mock.get(0));
    }

    @Test
    public void testForSpy() {
        List list = new LinkedList();
        List spy = spy(list);
//        //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
//        when(spy.get(0)).thenReturn("foo");
        //You have to use doReturn() for stubbing
        doReturn("foo").when(spy).get(0);
        assertEquals("foo", spy.get(0));
    }

}
