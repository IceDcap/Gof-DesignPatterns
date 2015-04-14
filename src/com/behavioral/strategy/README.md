Strategy(策略)————对象行为型模式
----------
#1.意图：
定义一系列的算法，把他们一个个封装起来，并且使它们可互相替换。本模式使得算法可独立于使用它的客户而变化。
#2.别名
政策(Policy)
#3.使用环境：
    在下列情况下使用strategy模式：
    ——许多相关的类仅仅是行为有异。“策略”提供了一种用多个行为中的一个行为来配置一个类的方法
    ——需要使用一个算法的不同变体。例如，你可能会定义一些反映不同的空间，时间权衡的算法。当这些变体实现为
        一个算法的类层次时，可以使用策略模式。
    ——算法使用客户不应该知道的数据。可以用策略模式以避免暴露复杂的、与算法相关的数据结构。
    ——一个类定义了多种行为，并且这些行为在这个类的操作中以多个条件语句形式出现。将相关的条件分支移入它们
        各自的Strategy类中以代替这些条件语句
#4.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Strategy.JPG "Strategy")

结构与状态模式一模一样！！
#5.参与者
    Strategy(策略)
        ————定义所有支持的算法的公共接口。Context使用这个接口来调用某ConCreteStrategy定义算法
    ConcreteStrategy(具体策略)
        ————以Strategy接口实现某具体算法
    Context(上下文)
        ————用一个ConcreteStrategy对象来配置
        ————维护一个对Strategy对象的引用
        ————可定义一个接口来让Strategy访问它的数据
        

#6.代码描述
策略模式实现起来其实很简单，以下是一个关于选择排序算法的简单的例子

Strategy.java

```Java
    public interface Strategy {
        public void orderAlgorithmic();
    }
```

ConcreteStrategy(ConcreteStrategyA.java ConcreteStrategyB.java ConcreteStrategyC.java)

```Java
    public class ConcreteStrategyA implements Strategy {
        @Override
        public void orderAlgorithmic() {
            System.out.println("use quick sort algorithmic.");
        }
    }

    public class ConcreteStrategyB implements Strategy {
        @Override
        public void orderAlgorithmic() {
            System.out.println("use insert sort algorithmic.");
        }
    }

    public class ConcreteStrategyC implements Strategy {
        @Override
        public void orderAlgorithmic() {
            System.out.println("use merge sort algorithmic.");
        }
    }
```

Context.java

```Java
    public class Context {
        Strategy strategy;
    
        public Context(Strategy strategy) {
            this.strategy = strategy;
        }
    
        public void algorithm() {
            strategy.orderAlgorithmic();
        }
    }
```

Test.java

```Java
    public class Test {
        public static void main(String[] args) {
            Context context = new Context(new ConcreteStrategyA());
            context.algorithm();
            Context context1 = new Context(new ConcreteStrategyB());
            context1.algorithm();
            Context context2 = new Context(new ConcreteStrategyC());
            context2.algorithm();
        }
    }
```

result
    
    use quick sort algorithmic.
    use insert sort algorithmic.
    use merge sort algorithmic.


