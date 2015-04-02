Bridge(桥接)————对象结构型
-------------
#1.意图：
将抽象部分与它的实现部分分离，使它们都可以独立的变化
#2.别名
Handler/Body
#3.使用环境：
    ————你不希望在抽象和它的实现部分之间有一个固定的绑定关系，例如这种情况可能因为在程序运行时刻实现部分
        应可以被选择或者切换。
    ————类的抽象和他的实现都应该通过生成子类的方法进行扩充，这时Bridge模式使你可以对不同的抽象接口和实现
        部分进行组合，并分别对它们进行扩充。
    ————对一个抽象部分的修改应对客户不产生影响，即客户代码不必重新编译。


#4.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Bridge.JPG "Bridge")
#5.参与者
    Abstraction
        ————定义抽象类的接口
        ————维护一个指向Implement类型对象的指针
    RefinedAbstraction
        ————扩充由Abstraction定义的接口
    Implementor
        ————定义实现类的接口，该接口不一定要与Abstraction的接口完全一致；事实上这两个接口可以完全不同。
            一般来讲，Implementor接口仅提供基本的操作，而Abstraction则定义了基于这些基本操作的较高层次的操作
    ConcreteImplementor
        ————实现Implementor接口并定义它的具体实现
#6.效果
    ————分离接口及其实现部分
    ————提高可扩充性
    ————实现细节对客户透明

#7.代码需求描述
实际上，我们要做到的是把变化的部分提出，对其抽象，使变化独立。

1. 概括的讲，我们的需求就是实现各种各样的汽车。从细节上讲，我们知道，汽车
以用途分类，有卡车，巴士，小汽车等类别；
以动力系统分类，有汽油型，柴油型，电力型，天然气型，生物能，油电混合型，太阳能型等等。
也就是说，有汽油型的卡车，巴士，小汽车，也有柴油型的卡车，巴士，小汽车，当然还有其他各种类型的卡车，巴士，小汽车。
这里为了方便，我们对需求做一个简化，只考虑卡车、巴士，汽油型和柴油型。也就是说，两两组合之后，就会有四种车型：汽油型卡车，柴油型卡车，汽油型巴士和柴油型巴士。

2. 任何车都有开始和停止的功能。

3. 卡车有载货的功能，巴士有载客的功能。

UML示例

![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/bridgesample.png "bridgesample")

将车辆的发动机类型再抽象为柴油型和汽油型

Abstraction(AbstractVehicle.java)

```Java
    public abstract class AbstractVehicle implements Vehicle {
    
        private Engine mEngine;
    
        public void setEngine(Engine mEngine) {
            this.mEngine = mEngine;
        }
    
        @Override
        public void start() {
            mEngine.fireUp();
            mEngine.start();
        }
    
        @Override
        public void stop() {
            mEngine.stop();
        }
    
        public String carInfo() {
            return mEngine.engineInfo();
        }
    
    }
```
    
RefinedAbstraction(Bus.java & Truck.java)

```Java    
    public class Bus extends AbstractVehicle {
    
        public void loadPeople() {
            System.out.println("this is a " + carInfo() + " bus," + " can load people.");
        }
    }
    
    public class Truck extends AbstractVehicle {
    
        public void loadGoods() {
            System.out.println("this is a " + carInfo() + " truck," + " can load woods.");
        }
    }
```
    
Implementor(Engine.java)

```Java
    public interface Engine {
        public void fireUp();
        public void start();
        public void stop();
        public String engineInfo();
    }
```
    
ConcreteImplementor(CasolineEngine.java & DieselEngine.java)
    
```Java
    public class CasolineEngine implements Engine{
        @Override
        public void fireUp() {
    
        }
    
        @Override
        public void start() {
    
        }
    
        @Override
        public void stop() {
    
        }
    
        @Override
        public String engineInfo() {
            return "casoline";
        }
    }

    public class DieselEngine implements Engine {
        @Override
        public void fireUp() {
    
        }
    
        @Override
        public void start() {
    
        }
    
        @Override
        public void stop() {
    
        }
    
        @Override
        public String engineInfo() {
            return "diesel";
        }
    }
```

Client.java

```Java
    public class Client {
        public static void main(String[] args) {
            //casoline bus
            Bus bus = new Bus();
            Engine casoline = new CasolineEngine();
            bus.setEngine(casoline);
            bus.loadPeople();
    
            //diesel truck load woods
            Truck truck = new Truck();
            Engine diesel = new DieselEngine();
            truck.setEngine(diesel);
            truck.loadGoods();
    
    
        }
    }
```
    
result
    
    this is a casoline bus, can load people.
    this is a diesel truck, can load woods.



#8.参考资料
[http://blog.csdn.net/superbeck/article/details/5969884](http://blog.csdn.net/superbeck/article/details/5969884)
     
