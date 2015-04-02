package com.behavioral.interpreter;

/**
 * Created by doushuqi on 15/4/1.
 */
public class Context {
    public static final float PI = 3.14f;
    private float r;

    public Context() {
    }

    public Context(float r) {
        this.r = r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getR() {
        return r;
    }
}
