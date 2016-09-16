package com.structural.proxy;

/**
 * Created by shuqi on 16-9-15.
 */
public class YuanGao implements ILawsuit {
    @Override
    public void submit() {
        System.out.println("老板拖欠工资，特此申请仲裁！");
    }

    @Override
    public void burden() {
        System.out.println("这是合同书以及一年内工资卡流水账。");
    }

    @Override
    public void defend() {
        System.out.println("证据确凿，不能再说什么了。");
    }

    @Override
    public void finish() {
        System.out.println("诉讼成功，判决老板七日内结算工资。");
    }
}
