package com.example.demospring.tddWithJunit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Stack basic functionalites are :
 * Push (pushes a new element)
 * Pop (remove top element)
 * Peek (returns the top element)
 * Poll (return and delete top element)
 */

public class ImplStackTest {

    private ImplStack stack;

    @Before
    public void setup(){
        stack =new ImplStack();
    }

    @Test
    public void pushing(){
        assertEquals(0,stack.totalElements());
        stack.push(1);
        assertEquals(1,stack.totalElements());
        stack.push(2);
    }

    @Test
    public void popFromEmptyStack(){
        stack= new ImplStack();
        assertEquals(-1,stack.popElement());

    }
    @Test
    public void popFromNonEmptyStackTest(){

        stack =new ImplStack();
        stack.push(1);
        assertEquals(1,stack.popElement());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4,stack.popElement());
        assertEquals(2,stack.totalElements());

    }
    @Test
    public void peekFromEmptyStack()
    {
        stack= new ImplStack();
        assertEquals(-1,stack.peekElement());

    }
    @Test
    public void peekFromStack(){
        ImplStack stack =new ImplStack();

        stack.push(1);
        assertEquals(1,stack.peekElement());
        stack.push(2);
        stack.popElement();
        stack.popElement();
        assertEquals(-1,stack.peekElement());
        stack.push(3);
        stack.push(4);
        stack.popElement();
        assertEquals(3,stack.peekElement());


    }

    @Test
    public void pollFromEmptyStack()
    {
        stack= new ImplStack();
        assertEquals(-1,stack.pollElement());

    }

    @Test
    public void pollElement(){
        ImplStack stack = new ImplStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3,stack.pollElement());

    }
}