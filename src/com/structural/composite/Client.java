package com.structural.composite;

/**
 * Created by doushuqi on 15/3/30.
 */
public class Client {
    public static void main(String[] args) {
        Universities root = new ConcreteUniversity("北京高校");
        root.add(new EngineeringCollege("工业学院"));
        root.add(new ArtiestCollege("艺术学院"));

        Universities root1 = new ConcreteUniversity("清华大学");
        root1.add(new EngineeringCollege("工业技术学院"));
        root1.add(new ArtiestCollege("艺术综合学院"));

        Universities root2 = new ConcreteUniversity("北京师范大学");
        root2.add(new EngineeringCollege("工业科学技术专业学院"));
        root2.add(new ArtiestCollege("艺术信息学院"));

        Universities root3 = new ConcreteUniversity("北京大学");
        root3.add(new EngineeringCollege("工学院"));
        root3.add(new ArtiestCollege("艺术音乐学院"));

        root.add(root1);
        root.add(root2);
        root.add(root3);
        root.getChild(3);

    }
}
