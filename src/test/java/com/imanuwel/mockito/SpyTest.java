package com.imanuwel.mockito;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {
    @Test
    public void test() {
        List arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Dummy");
        verify(arrayListSpy).add("Dummy");
        verify(arrayListSpy, never()).clear();

//        stub(arrayListSpy.size()).toReturn(5);
//        assertEquals(5, arrayListSpy.size());
//        // Mocks return default values
//
//        arrayListSpy.add("Dummy");
//        assertEquals(1, arrayListSpy.size());
//
//        arrayListSpy.remove("Dummy");
//        assertEquals(0, arrayListSpy.size());
    }
}
