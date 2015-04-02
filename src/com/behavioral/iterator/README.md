Iterator(迭代器)————对象行为型模式
----------
#1.意图：
提供一种方法顺序访问一个聚合对象中的各个元素，而不需要暴露该对象的内部表示
#2.别名
游标(Cursor)
#2.使用环境：
    迭代器模式可用来:
    ——访问一个聚合对象的内容而无需暴露它的内部表示
    ——支持对聚合对象的多种遍历
    ——为遍历不同的聚合结构提供一个统一的接口(即，支持多态迭代)
    
#3.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Iterator.JPG "Iterator")
#4.参与者
    Iterator(迭代器)
        ————迭代器定义访问和遍历元素的接口
    ConcreteIterator
        ————具体迭代器实现迭代器接口
        ————对该聚合遍历时跟踪当前位置
    Aggregate(聚合)
        ————聚合定义创建相应迭代器对象的接口
    ConcreteAggregate(具体聚合)
        ————具体聚合实现创建相应迭代器的接口，该操作返回ConcreteIterator的一个适当的实例


#5.代码描述
Java集合包中已经很好的运用了迭代器模式了,这里简单利用Vector来进行演示(Java中用泛型囊括了所有集合类)

Iterator.java

```Java
    public interface Iterator {
    
        public Object first();
        public Object next();
        public Object currentItem();
        public boolean isHave();
    }
```

ConcreteIterator.java

```Java
   public class ConcreteIterator implements Iterator {
       private int currentIndex = 0;
       private Vector vector = null;
   
       public ConcreteIterator(final Vector vector) {
           this.vector = vector;
       }
   
       @Override
       public Object first() {
           currentIndex = 0;
           return vector.get(currentIndex);
       }
   
       @Override
       public Object next() {
           currentIndex++;
           return vector.get(currentIndex);
       }
   
       @Override
       public Object currentItem() {
           return vector.get(currentIndex);
       }
   
       @Override
       public boolean isHave() {
           return !(currentIndex >= vector.size() - 1);
   
       }
   } 
```

Aggregate.java

```Java
    public interface Aggregate {
        public Iterator createIterator();
    }
```

ConcreteAggregate.java

```Java
    public class ConcreteAggregate implements Aggregate {
        private Vector vector;
    
        public Vector getVector() {
            return vector;
        }
    
        public void setVector(Vector vector) {
            this.vector = vector;
        }
    
        public ConcreteAggregate() {
            vector = new Vector();
            vector.add("No.1");
            vector.add("No.2");
            vector.add("No.3");
            vector.add("No.4");
            vector.add("No.5");
        }
    
        @Override
        public Iterator createIterator() {
            return new ConcreteIterator(vector);
        }
    }
```

Client.java

```Java
    public class Client {
        public static void main(String[] args) {
            final Aggregate aggregate = new ConcreteAggregate();
            final Iterator iterator = aggregate.createIterator();
            System.out.println(iterator.first());
            while (iterator.isHave()) {
                System.out.println(iterator.next());
            }
        }
    }
```

result
    
    No.1
    No.2
    No.3
    No.4
    No.5
    
