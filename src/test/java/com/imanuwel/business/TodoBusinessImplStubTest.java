package com.imanuwel.business;

import com.imanuwel.data.api.TodoService;
import com.imanuwel.data.api.TodoServiceStub;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class TodoBusinessImplStubTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAStub() {
        TodoService todoServiceStub = new TodoServiceStub();

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToString("Dummy");

        assertEquals(2, filteredTodos.size());
    }
}
