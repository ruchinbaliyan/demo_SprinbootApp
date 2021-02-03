package com.example.demospring.tddWithJunit;

import java.util.ArrayList;

public class ImplStack {

    ArrayList<Integer> A =new ArrayList<>();

    public int totalElements()
    {
        return A.size();
    }

    public void  push(int i) {
        A.add(i);
    }

    public int popElement() {

        if(A.size()==0)
            return -1;

        int x= A.get(A.size()-1);
        A.remove(A.size()-1);
        return x;

    }

    public int peekElement() {
        if(A.size()==0)
            return -1;

        return A.get(A.size()-1);
    }

    /*
    pollElement give the top element and remove it .
     */
    public int pollElement() {
        if(A.size()==0)
            return -1;
        int n =A.get(A.size()-1);
        A.remove(A.size()-1);
        return n;

    }
}
