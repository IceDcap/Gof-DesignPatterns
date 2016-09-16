Abstract Factory(抽象工厂)————对象创建型
------------------------------------
#1.意图：
提供一个创建一系列相关或相互依赖对象接口，而无需指定它们具体的类
#2.使用环境：
一个系统要独立于它的产品的创建，组合和表示的时候
一个系统要由多个产品系列中的一个来配置时
当你要强调一系列相关的产品对象的设计以便进行联合使用时
当你提供一个产品类库，而只想显示它们的接口而不实现时
#3.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/AbstractFactory.JPG "AbstractFactory")
#4.参与者
    AbstractFactory
        ————声明一个创建抽象产品对象的操作接口
    ConcreteFactory
        ————实现创建具体产品对象的操作
    AbstractProduct
        ————为一类产品对象声明一个接口
    ConcreteProduct
        ————定义一个将被相应的具体工厂创建的产品对象
        ————实现AbstractProduct接口
    Client
        ————仅使用由AbstractFactory和AbstractProduct类声明的接口
        
#5.代码解释
抽象工厂类(AbstractFactory.java)提供了创建产品A和创建产品B的接口(CreateProductA(),CreateProductB()),该接口由具体的
工厂来实现(ConcreteFactory1.java,ConcreteFactory2.java),有了抽象工厂后需要定义一个抽象的产品(AbstractProductA.java,
AbstractProductB.java)并提供具体的产品(ProductA1,ProductA2,ProductB1,ProductB2)

```Java
    public abstract class AbstractFactory {
        public abstract AbstractProductA createProductA();
        public abstract AbstractProductB createProductB();
    }
    
    public class ConcreteFactory1 extends AbstractFactory {
        @Override
        public AbstractProductA createProductA() {
            return new ProductA1();
        }
    
        @Override
        public AbstractProductB createProductB() {
            return new ProductB1();
        }
    }
    
    public class ConcreteFactory2 extends AbstractFactory {
        @Override
        public AbstractProductA createProductA() {
            return new ProductA2();
        }
    
        @Override
        public AbstractProductB createProductB() {
            return new ProductB2();
        }
    }
    
    public abstract class AbstractProductA {
    }

    public abstract class AbstractProductB {
    }
    
    public class ProductA1 extends AbstractProductA {
        public ProductA1() {
            System.out.println("create product A1 success!");
        }
    }
    
    public class ProductA2 extends AbstractProductA {
        public ProductA2() {
            System.out.println("create product A2 success!");
        }
    }
    
    public class ProductB1 extends AbstractProductB {
        public ProductB1() {
            System.out.println("create product B1 success!");
        }
    }

    public class ProductB2 extends AbstractProductB {
        public ProductB2() {
            System.out.println("create product B2 success!");
        }
    }
```

Client.java

```Java
    public class Client {
        public static void main(String[] args) {
            ConcreteFactory1 factory1 = new ConcreteFactory1();
            factory1.createProductA();
            factory1.createProductB();
            ConcreteFactory2 factory2 = new ConcreteFactory2();
            factory2.createProductA();
            factory2.createProductB();
        }
    }
```

result

    creational product A1 success!
    creational product B1 success!
    creational product A2 success!
    creational product B2 success!
    


汽车生产车间，分别要生产三款车型，Q3、Q5、Q7。它们分别有不同的部件组成，主要区别在于轮胎、引擎和制动系统。将这三种部件分别作为AbstractProduct，并且设计出它们分别对应的ConcreteProduct

```java
public interface ITire {
    void tire();
}

public class NormalTire implements ITire{
    @Override
    public void tire() {
        System.out.println("normal tire.");
    }
}

public class SUVTire implements ITire {
    @Override
    public void tire() {
        System.out.println("SUV tire.");
    }
}


public interface IEngine {
    void engine();
}

public class DomesticEngine implements IEngine {
    @Override
    public void engine() {
        System.out.println("国产发动机");
    }
}

public class ImportEngine implements IEngine {
    @Override
    public void engine() {
        System.out.println("进口发动机");
    }
}


public interface IBrake {
    void brake();
}

public class NormalBrake implements IBrake {
    @Override
    public void brake() {
        System.out.println("普通制动");
    }
}

public class SeniorBrake implements IBrake {
    @Override
    public void brake() {
        System.out.println("高级制动");
    }
}

```

有了AbstractProduct和ConcreteProduct后，就可以定义抽象工厂了CarFactory

```java
public abstract class CarFactory {
    /**
     * 生成轮胎
     * @return
     */
    public abstract ITire createTire();

    /**
     * 生产发动机
     * @return
     */
    public abstract IEngine createEngine();

    /**
     * 生产制动系统
     * @return
     */
    public abstract IBrake createBrake();
}
```

最后设计具体工厂，它们分别代表三种车型的生产车间Q3Factory、Q5Factory、Q7Factory

```java
public class Q3Factory extends CarFactory {
    @Override
    public ITire createTire() {
        return new NormalTire();
    }

    @Override
    public IEngine createEngine() {
        return new DomesticEngine();
    }

    @Override
    public IBrake createBrake() {
        return new NormalBrake();
    }
}

public class Q5Factory extends CarFactory {
    @Override
    public ITire createTire() {
        return new SUVTire();
    }

    @Override
    public IEngine createEngine() {
        return new ImportEngine();
    }

    @Override
    public IBrake createBrake() {
        return new SeniorBrake();
    }
}

public class Q7Factory extends CarFactory {
    @Override
    public ITire createTire() {
        return new SUVTire();
    }

    @Override
    public IEngine createEngine() {
        return new ImportEngine();
    }

    @Override
    public IBrake createBrake() {
        return new SeniorBrake();
    }
}
```

客户端打印为
```java
public class CarClient {
    public static void main(String[] args) {
        CarFactory factoryQ3 = new Q3Factory();
        factoryQ3.createTire().tire();
        factoryQ3.createEngine().engine();
        factoryQ3.createBrake().brake();
        System.out.println("---------------------");

        CarFactory factoryQ5 = new Q5Factory();
        factoryQ5.createTire().tire();
        factoryQ5.createEngine().engine();
        factoryQ5.createBrake().brake();
        System.out.println("---------------------");


        CarFactory factoryQ7 = new Q7Factory();
        factoryQ7.createTire().tire();
        factoryQ7.createEngine().engine();
        factoryQ7.createBrake().brake();
    }
}

```

输出结果为

```
normal tire.
国产发动机
普通制动
---------------------
SUV tire.
进口发动机
高级制动
---------------------
SUV tire.
进口发动机
高级制动

```