package com.structure.composite;

/**
 * Created by doushuqi on 15/3/30.
 */
public class EngineeringCollege extends Universities {
    protected EngineeringCollege(String name) {
        super(name);
    }

    @Override
    protected void add(Universities universities) {

    }

    @Override
    protected void remove(Universities universities) {

    }

    @Override
    protected void getChild(int depth) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < depth; i++) {
            sb.append("-");
        }
        System.out.println(new String(sb) + this.getName());
    }
}
