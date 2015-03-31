package com.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doushuqi on 15/3/30.
 */
public class ConcreteUniversity extends Universities {
    private List<Universities> list;

    protected ConcreteUniversity(String name) {
        super(name);
        list = new ArrayList<Universities>();
    }

    @Override
    protected void add(Universities universities) {
        list.add(universities);
    }

    @Override
    protected void remove(Universities universities) {
        list.remove(universities);
    }

    @Override
    protected void getChild(int depth) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
        for (Universities c : list) {
            c.getChild(depth + 2);
        }
    }
}
