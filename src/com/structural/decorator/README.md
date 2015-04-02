Decorator(装饰)————对象结构型
-------------
#1.意图：
动态的给一个对象添加一些额外的职责。就增加功能来说，Decorator模式相比生成子类更为灵活
#2.别名
包装器Wrapper
#3.使用环境：
    ————在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责
    ————处理那些可以撤销的职责
    ————当不能采用生成子类的方法进行扩充时。一般情况是，可能有大量独立的扩展，为支持
        每一种组合将产生大量的子类，使得子类的数目呈爆炸性的增长。另一种情况可能是因为
        类的定义被隐藏，或类定义不能用于生成子类



#4.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Decorator.JPG "Decorator")

#5.参与者
    Component
        ————定义一个对象接口，可以给这些对象动态的添加职责        
    ConcreteComponent
        ————定义一个对象，可以给这个对象添加一些职责
    Decorator
        ————维持一个指向Component对象的指针，并定义一个与Component接口一致的接口
    ConcreteDecorator
        ————向组件添加职责
#6.代码解释
整个Java 的IO包全部由装饰模式构建的
下面例子，项目经理，开发人员共同完成一个项目，其中开发人员只负责代码编写，而不同的项目经理会做不同的工作，大致的都会做
项目前的准备工作和项目后的结尾工作，中间部分由开发人员进行代码编写，项目经理相当于装饰器为该项目在开发者编码的时候动态的进行扩展

Component(Project.java)

```Java
    public interface Project {
        public void doCoding();
    }
```

ConcreteComponent(Developer.java)

```Java
    public class Developer implements Project {
        private String name;
    
        public Developer(String name) {
            this.name = name;
        }
    
        @Override
        public void doCoding() {
            System.out.println(name + " is trying hard in coding...");
            System.out.println("finish coding！！");
        }
    }
```
    
Decorator(Manager.java)
    
```Java
    public class Manager implements Project {
        private Project mProject;
    
        public Manager(Project project) {
            this.mProject = project;
        }
    
        @Override
        public void doCoding() {
            startNewWork();
        }
    
        public void startNewWork(){
            doEarlyWork();
            mProject.doCoding();
            doEndWork();
        }
    
        public void doEarlyWork(){}
        public void doEndWork(){}
    }
```
    
ConcreteDecorator(ManagerLiu.java & ManagerWang.java)

```Java
    public class ManagerLiu extends Manager {
        public ManagerLiu(Project project) {
            super(project);
        }
    
        @Override
        public void doEarlyWork() {
            System.out.println("Manager Liu is doing requirement analysis.");
            System.out.println("Manager Liu is doing architecture design.");
            System.out.println("Manager Liu is doing detailed design.");
        }
    }
    
    public class ManagerWang extends Manager {
        public ManagerWang(Project project) {
            super(project);
        }
    
        @Override
        public void doEarlyWork() {
            System.out.println("Manager Wang is doing requirement analysis.");
        }
    
        @Override
        public void doEndWork() {
            System.out.println("Manager Wang is doing ending.");
        }
    }
```
    
Client.java
    
```Java
    public class Client {
        public static void main(String[] args) {
            Project developer = new Developer("developerA");
            Project managerLiu = new ManagerLiu(developer);
            Project managerWang = new ManagerWang(new Developer("developerB"));
            managerLiu.doCoding();
            managerWang.doCoding();
        }
    }
```
    
result

    Manager Liu is doing requirement analysis.
    Manager Liu is doing architecture design.
    Manager Liu is doing detailed design.
    developerA is trying hard in coding...
    finish coding！！
    Manager Wang is doing requirement analysis.
    developerB is trying hard in coding...
    finish coding！！
    Manager Wang is doing ending.
    
#7.效果
    ————比静态继承更灵活
    ————避免在层次结构高层的类有太多的特征
    ————参与者Decorator与Component不同，Decorator是一个透明的包装
    ————有许多小对象来进行装饰
     
