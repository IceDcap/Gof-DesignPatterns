Gof-DesignPatterns
------------------
23 design patterns samples in Java

# 23中设计模式分类
如下表所示
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/category.png "category")
    
我们根据两条准则对模式进行分类。第一是目的准则,即模式是用来完成什么工作的。
    模式依据其目的可分为创建型(Creational)、结构型(Structural)、或行为型(Behavioral)三种。
    创建型模式与对象的创建有关;结构型模式处理类或对象的组合;行为型模式对类或对象怎样交互和怎样分配职责进行描述。
    第二是范围准则,指定模式主要是用于类还是用于对象。
    类模式处理类和子类之间的关 系,这些关系通过继承建立,是静态的,在编译时刻便确定下来了。
    对象模式处理对象间的 关系,这些关系在运行时刻是可以变化的,更具动态性。
    从某种意义上来说,几乎所有模式都使用继承机制,所以“类模式”只指那些集中于处理类间关系的模式,
    而大部分模式都属于对象模式的范畴。
    创建型类模式将对象的部分创建工作延迟到子类,而创建型对象模式则将它延迟到另一 个对象中。
    结构型类模式使用继承机制来组合类,而结构型对象模式则描述了对象的组装方式。
    行为型类模式使用继承描述算法和控制流,而行为型对象模式则描述一组对象怎样协作完成单个对象所无法完成的任务。
    还有其他组织模式的方式。有些模式经常会被绑在一起使用,
    例如,Composite常和Iterator或Visitor一起使用;有些模式是可替代的,
    例如,Prototype常用来替代AbstractFactory;
    有些模式尽管使用意图不同,但产生的设计结果是很相似的,
    例如,Composite和Decorator的结构图是相似的。
    
# 创建型模式
创建型模式抽象了实例化过程。它们帮助一个系统独立于如何创建、组合和表示它的那些对象。一个类
创建型模式使用继承改变被实例化的类,而一个对象创建型模式将实例化委托给另一个对象。
    
随着系统演化得越来越依赖于对象复合而不是类继承,创建型模式变得更为重要。当这种情况发生时,
重心从对一组固定行为的硬编码(hard-coding)转移为定义一个较小的基本行为集,这些行为可以被
组合成任意数目的更复杂的行为。这样创建有特定行为的对象要求的不仅仅是实例化一个类。

在这些模式中有两个不断出现的主旋律。第一,它们都将关于该系统使用哪些具体的类的信息封装起来。
第二,它们隐藏了这些类的实例是如何被创建和放在一起的。整个系统关 于这些对象所知道的是由抽象
类所定义的接口。因此,创建型模式在什么被创建,谁创建它,它是怎样被创建的,以及何时创建这些方面
给予你很大的灵活性。它们允许你用结构和功能 差别很大的“产品”对象配置一个系统。配置可以是静态
的(即在编译时指定),也可以是动态的(在运行时)。

有时创建型模式是相互竞争的。例如,在有些情况下Prototype或AbstractFactory用起来都很好。
而在另外一些情况下它们是互补的:Builder可以使用其他模式去实现某个构件的创建。Prototype
可以在它的实现中使用Singleton。



# 结构性模式
结构型模式涉及到如何组合类与对象以获得更大的结构。结构型类模式采用继承机制来组合接口或实现。
一个简单地例子是采用多重继承方法将两个以上的类组合成一个类，结果这个类包含了所有父类的性质。
这一模式尤其有助于多个独立开发的类库协同工作。另一个例子是类形式的Adapter模式，一般来说，
适配器使得一个接口与其他接口兼容，从而给出了多个不同接口的统一抽象。

结构型对象模式不是对接口和实现进行组合，而是描述了如何对一些对象进行组合，从而实现新功能的一些方法。
因为可以再运行时刻改变对象的组合关系，所以对象组合方式具有更大的灵活性，而这种机制用静态类组合是不
可能实现的。

Composite模式是结构型对象模式的一个实例。它描述了如何构造一个类层次式结构,这一结构由两种类型的对象
(基元对象和组合对象)所对应的类构成.其中的组合对象使得你可以组合基元对象以及其他的组合对象,从而形成
任意复杂的结构。在Proxy模式中,proxy对象作为其他对象的一个方便的替代或占位符。它的使用可以有多种形式。
例如它可以在局部空间中代表一个远程地址空间中的对象,也可以表示一个要求被加载的较大的对象,还可以用来保护
对敏感对象的访问。Proxy模式还提供了对对象的一些特有性质的一定程度上的间接访问,从而它可以限制、增强或修改这些性质。

Flyweight模式为了共享对象定义了一个结构。至少有两个原因要求对象共享:效率和一致性。Flyweight的对象
共享机制主要强调对象的空间效率。使用很多对象的应用必需考 虑每一个对象的开销。使用对象共享而不是进行对象
复制,可以节省大量的空间资源。但是仅当这些对象没有定义与上下文相关的状态时,它们才可以被共享。Flyweight
的对象没有这样的状态。任何执行任务时需要的其他一些信息仅当需要时才传递过去。由于不存在与上下文相关的状态,
因此Flyweight对象可以被自由地共享。

如果说Flyweight模式说明了如何生成很多较小的对象,那么Facade模式则描述了如何用单个对象表示整个子系统。
模式中的facade用来表示一组对象,facade的职责是将消息转发给它所表示的对象。Bridge模式将对象的抽象和其
实现分离,从而可以独立地改变它们。

Decorator模式描述了如何动态地为对象添加职责。Decorator模式是一种结构型模式。这一模式采用递归方式组合
对象,从而允许你添加任意多的对象职责。例如,一个包含用户界面组件的Decorator对象可以将边框或阴影这样的装
饰添加到该组件中,或者它可以将窗口滚动和缩放这样的功能添加的组件中。我们可以将一个 Decorator对象嵌套在
另外一个对象中就可以很简单地增加两个装饰,添加其他的装饰也是如此。因此,每个Decorator对象必须与其组件的
接口兼容并且保证将消息传递给它。Decorator模式在转发一条信息之前或之后都可 以完成它的工作(比如绘制组件的边框)。
    
# 行为模式
行为模式涉及到算法和对象间的职责的分配。行为模式不仅描述了对象或类的模式还描述了它们之间的通信模式。
这些模式刻画了在运行时难以跟踪的复杂的控制流，它们将你的注意力从控制流转移到对象之间的联系上来。

行为类模式使用继承机制在类之间分派行为，如Template Method较为简单和常用，模板方法是一个算法的抽象定义，
它逐步的的定义了该算法每一步调用一个抽象操作或一个原语操作，子类定义抽象操作以具体实现该算法。另一种类模式
是Interpreter，它将一个文法表示为一个类层次，并实现一个解释器作为这些类的实例上的一个操作。

行为对象模式使用了对象复合而不是继承。一些行为对象模式描述了一组对等的对象怎样相互协作以完成其中任何一个对
象都无法单独完成的任务。这里一个重要的问题是对等的对象 如何互相了解对方。对等对象可以保持显式的对对方的引用,
但那会增加它们的耦合度。在极端情况下,每一个对象都要了解所有其他的对象。Mediator在对等对象间引入一个mediator
对象以避免这种情况的出现。mediator提供了松耦合所需的间接性。

Chain of Responsibility提供更松的耦合。它让你通过一条候选对象链隐式的向一个对象发送请求。根据运行时刻
情况任一候选者都可以响应相应的请求。候选者的数目是任意的,你可以在运行时刻决定哪些候选者参与到链中。

Observer模式定义并保持对象间的依赖关系。典型的Observer的例子是Smalltalk中的模型/视图/控制器,其中一旦
模型的状态发生变化,模型的所有视图都会得到通知。

其他的行为对象模式常将行为封装在一个对象中并将请求指派给它。Strategy模式将算法封装在对象中,这样可以方便地
指定和改变一个对象所使用的算法。Command模式将请求封装在对象中,这样它就可作为参数来传递,也可以被存储在历史
列表里,或者以其他方式使用。State模式封装一个对象的状态,使得当这个对象的状态对象变化时,该对象可改变它的行为。
Visitor封装分布于多个类之间的行为,而Iterator则抽象了访问和遍历一个集合中的对象的方式。

# 链接
1、Factory Method
[工厂方法](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/creational/factorymethod)

2、Abstract Factory
[抽象工厂](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/creational/abstractfactory)

3、Builder
[生成器](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/creational/builder)

4、Prototype
[原型](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/creational/prototype)

5、Singleton
[单例](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/creational/singleton)

6、Adapter
[适配器](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/structural/adapter)

7、Bridge
[桥接](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/structural/bridge)

8、Composite
[组合](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/structural/composite)

9、Decorator
[装饰](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/structural/decorator)

10、Facade
[外观](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/structural/facade)

11、Flyweight
[享元](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/structural/flyweight)

12、Proxy
[代理](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/structural/proxy)

13、Interpreter
[解释器](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/behavioral/interpreter)

14、Template Method
[模板方法](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/behavioral/templatemethod)

15、Chain of Responsibility
[职责链](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/behavioral/chainofresponsibility)

16、Command
[命令](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/behavioral/command)

17、Iterator
[迭代器](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/behavioral/iterator)

18、Mediator
[中介者](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/behavioral/mediator)

19、Memento
[备忘录](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/behavioral/memento)

20、Observer
[观察者](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/behavioral/observer)

21、State
[状态](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/behavioral/state)

22、Strategy
[策略](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/behavioral/strategy)

23、Visitor
[访问者](https://github.com/IceDcap/Gof-DesignPatterns/tree/master/src/com/behavioral/visitor)


