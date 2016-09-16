Proxy(代理)————对象结构型
-------------
#1.意图：
为其他对象提供一种代理以控制对这个对象的访问
#2.别名
Surrogate
#3.使用环境：
在需要用比较通用和复杂的对象指针代替简单的指针的时候,使用Proxy模式。下面是一些可以使用Proxy模式常见情况:    

    1)远程代理(Remote Proxy)为一个对象在不同的地址空间提供局部代表。NEXTSTEP[Add94]使用NXProxy类实现了
        这一目的。Coplien[Cop92]称这种代理为“大使”(Ambassador)。
    2)虚代理(VirtualProxy)根据需要创建开销很大的对象。在动机一节描述的ImageProxy就是这样一种代理的例子。
    3)保护代理(Protection Proxy)控制对原始对象的访问。保护代理用于对象应该有不同的访问权限的时候。例如,
        在Choices操作系统[CIRM93]中KemelProxies为操作系统对象提供了访问保护。
    4)智能指引(SmartReference)取代了简单的指针,它在访问对象时执行一些附加操作。它的典型用途包括:
        • 对指向实际对象的引用计数,这样当该对象没有引用时,可以自动释放它(也称为SmartPointers[Ede92])。
        • 当第一次引用一个持久对象时,将它装入内存。
        • 在访问一个实际对象前,检查是否已经锁定了它,以确保其他对象不能改变它。



#4.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Proxy.JPG "Proxy")

#5.参与者
    Proxy
        ————保存一个引用使得代理可以访问实体。若RealSubject和Subject的接口相同,Proxy会引用Subject
        ————提供一个与Subject的接口相同的接口,这样代理就可以用来替代实体
        ————控制对实体的存取,并可能负责创建和删除它
        ————其他功能依赖于代理的类型:
            RemoteProxy负责对请求及其参数进行编码,并向不同地址空间中的实体发送已编 码的请求。
            VirtualProxy可以缓存实体的附加信息,以便延迟对它的访问。
            ProtectionProxy检查调用者是否具有实现一个请求所必需的访问权限。
    Subject
        ————定义RealSubject和Proxy的共用接口，这样就在任何使用RealSubject的地方都可以使用Proxy
    RealSubject
        ————定义Proxy所代表的实体

#8.代码解释
打官司请律师是一个典型的代理模式，原告作为RealSubject角色将打官司的所有流程都交给了律师来做，而律师也充当着ProxySubject角色。诉讼流程可以抽象为一个Subject主题角色。
```java
public interface ILawsuit {
    void submit();//提出诉讼

    void burden();//进行举证

    void defend();//开始辩护

    void finish();//诉讼完成
}

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

public class Lawyer implements ILawsuit {
    private ILawsuit mLawsuit;

    public Lawyer(ILawsuit mLawsuit) {
        this.mLawsuit = mLawsuit;
    }

    @Override
    public void submit() {
        mLawsuit.submit();
    }

    @Override
    public void burden() {
        mLawsuit.burden();
    }

    @Override
    public void defend() {
        mLawsuit.defend();
    }

    @Override
    public void finish() {
        mLawsuit.finish();
    }
}

public class Client {

    public static void main(String[] args) {
        ILawsuit yuangao = new YuanGao();
        Lawyer lawyer = new Lawyer(yuangao);
        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();

    }
}

```

结果
```
老板拖欠工资，特此申请仲裁！
这是合同书以及一年内工资卡流水账。
证据确凿，不能再说什么了。
诉讼成功，判决老板七日内结算工资。
```

上述例子很简单，这也是静态代理的最常见的例子。对于动态代理来说，我们不必清楚原告中的具体代码，也没必要自己定义ProxySubject来实现Subject以及它的所有方法。而是将代理延迟到运行时。通过`InvocationHandler`接口定义一个动态代理类
```java
public class DynamicProxy implements InvocationHandler {
    private Object object;//被代理的对象，具体不清楚是什么，在运行时自动获取

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(object, args);
        return result;
    }
}

```

```java
public class Client {

    public static void main(String[] args) {
        ILawsuit yuangao = new YuanGao();

        ////动态代理
        System.out.println("---------dynamic proxy--------");
        DynamicProxy proxy = new DynamicProxy(yuangao);
        ClassLoader classLoader = yuangao.getClass().getClassLoader();
        ILawsuit lawyer2 = (ILawsuit) Proxy.newProxyInstance(classLoader, new Class[]{ILawsuit.class}, proxy);
        lawyer2.submit();
        lawyer2.burden();
        lawyer2.defend();
        lawyer2.finish();
    }
}
```

运行结构
```
---------dynamic proxy--------
老板拖欠工资，特此申请仲裁！
这是合同书以及一年内工资卡流水账。
证据确凿，不能再说什么了。
诉讼成功，判决老板七日内结算工资。
```

#7.参考
[http://www.cnblogs.com/linjiqin/archive/2011/02/18/1957600.html](http://www.cnblogs.com/linjiqin/archive/2011/02/18/1957600.html)
[http://www.cnblogs.com/jqyp/archive/2010/08/20/1805041.html](http://www.cnblogs.com/jqyp/archive/2010/08/20/1805041.html)
