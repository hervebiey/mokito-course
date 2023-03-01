package com.imanuwel.business;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void letsMockListsSizeMethod() {
        // Given - Setup

        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);
        // When - actual method call

        // Then - asserts
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
    }

    @Test
    public void letsMockListsSize_ReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size())
                .thenReturn(2)
                .thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void letsMockListGet_ReturnMultipleValues() {
        List listMock = mock(List.class);

//        Argument Matcher
        when(listMock.get(anyInt())).thenReturn("imanuwel");
        assertEquals("imanuwel", listMock.get(0));
        assertEquals("imanuwel", listMock.get(1));
    }

    @Test
    public void letsMockListGet_usingBDD() {
        //Given
        List listMock = mock(List.class);

        //        Argument Matcher
        given(listMock.get(anyInt())).willReturn("imanuwel");

        // When - listMock.get(0)
        String firstElement = (String) listMock.get(0);

        //Then
        assertThat(firstElement, is("imanuwel"));
    }

    @Test(expected = RuntimeException.class)
    public void letsMockListGet_throwsException() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
        listMock.get(0);
    }

    @Test(expected = RuntimeException.class)
    public void letsMockListGet_mixingUp() {
        List listMock = mock(List.class);
        when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something"));
        listMock.get(0);
    }
}
