Mediator(中介者)————对象行为型模式
----------
#1.意图：
用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变他们之间的交互
#2.使用环境：
    在下列情况下使用中介者模式：
    ——一组对象以定义良好但是复杂的方式进行通信。产生的相互依赖关系结构混乱且难以理解
    ——一个对象引用其他很多对象并且直接与这些对象通信，导致难以复用该对象
    ——想定制一个分布在多个类中的行为，而又不想生成太多的子类
#3.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Mediator.JPG "Mediator")
#4.参与者
    Mediator(中介者)
        ————中介者定义一个接口用于与各同事(Colleague)对象通信
    ConcreteMediator(具体中介者)
        ————具体中介者通过协调各同事对象实现协作行为
        ————了解并维护它的各个同事
    Colleague class(同事类)
        ————每一个同事类都知道它的中介者对象
        ————每一个同事对象在需与同事通信的时候，与它的中介者通信
    

#5.代码描述
户主租房找中介,同样找房子入住也需要找中介。中介的工作就是发布房源消息或者为消费者查找房子,当有户主出租房子时
会找到中介来发布房源消息,消费者也可以通过中介发消息的形式吸引户主来出租他家的房子。

```Java
    public interface Mediator {
    
        public void publishMessage(String str, Identity identity);
    }
```

```Java
    public enum Identity {
        CONSUMER, OWNER
    }
```

```Java
    public class ConcreteMediator implements Mediator {
        protected Colleague colleague;
    
        public Colleague getColleague() {
            return colleague;
        }
    
        public void setColleague(Colleague colleague) {
            this.colleague = colleague;
        }
    
        @Override
        public void publishMessage(String str, Identity identity) {
            if (identity.equals(Identity.CONSUMER))
                System.out.println("Consumer look for a house, the detailed message is " + str + " .");
            else
            System.out.println("A house need to rent out now, the info is " + colleague.info(str));
        }
    }
```

```Java
    public abstract class Colleague {
    
        protected Mediator mediator;
    
        public Mediator getMediator() {
            return mediator;
        }
    
        public void setMediator(Mediator mediator) {
            this.mediator = mediator;
        }
    
        protected abstract String info(String info);
    }
```

```Java
    public class OwnerColleague extends Colleague {
    
        public OwnerColleague() {
        }
    
        @Override
        protected String info(String info) {
            return info;
        }
    }
    
    public class ConsumerColleague extends Colleague {
        @Override
        protected String info(String info) {
            return info;
        }
    }
```
    
Client.java
    
```Java
    public class Client {
        public static void main(String[] args) {
            ConcreteMediator mediator = new ConcreteMediator();
    
            Colleague owner = new OwnerColleague();
            Colleague consumer = new ConsumerColleague();
    
            mediator.setColleague(owner);
            String str =owner.info("I have a 80m*m house to rent out!");
            mediator.publishMessage(str, Identity.OWNER);
    
            mediator.publishMessage(consumer.info("looking for a room at shengli street"), Identity.CONSUMER);
        }
    }
```

result
    
    A house need to rent out now, the info is I have a 80m*m house to rent out!
    Consumer look for a house, the detailed message is looking for a room at shengli street .


#6.效果
1).减少子类生成

2).将各个Colleague解耦

3).简化对象协议

4).对对象如何协作进行了抽象

5).使控制集中化

#7.参考
[http://men4661273.iteye.com/blog/1634907](http://men4661273.iteye.com/blog/1634907)

[http://haolloyin.blog.51cto.com/1177454/333810/](http://haolloyin.blog.51cto.com/1177454/333810/)