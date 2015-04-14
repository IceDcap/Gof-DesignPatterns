Visitor(访问者)————对象行为型模式
----------
#1.意图：
表示一个作用于某对象结构中的各元素的操作。它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。
#2.使用环境：
    在下列情况下使用Visitor模式：
    ——一个对象结构包含很多类对象,它们有不同的接口,而你想对这些对象实施一些依赖于
      其具体类的操作。
    ——需要对一个对象结构中的对象进行很多不同的并且不相关的操作,而你想避免让这些操
      作“污染”这些对象的类。Visitor使得你可以将相关的操作集中起来定义在一个类中。
      当该对象结构被很多应用共享时,用 Visitor模式让每个应用仅包含需要用到的操作。
    ——定义对象结构的类很少改变,但经常需要在此结构上定义新的操作。改变对象结构类需
      要重定义对所有访问者的接口,这可能需要很大的代价。如果对象结构类经常改变,那
      么可能还是在这些类中定义这些操作较好。
#3.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Visitor.JPG "Visitor")

#4.参与者
    Visitor(访问者)
        ————为该对象结构中ConcreteElement的每一个类声明一个Visit操作。该操作的名字和特征标识了发送Visit请求给
            该访问者的那个类。这使得访问者可以确定正被访问元素的具体的类。这样访问者就可以通过该元素的特定接口直接访问它。
    ConcreteVisitor(具体访问者)
        ————实现每个由 Visitor声明的操作。每个操作实现本算法的一部分,而该算法片断乃是对应于结构中对象的类。
            ConcreteVisitor为该算法提供了上下文并存储它的局部状态。这一状态常常在遍历该结构的过程中累积结果。
    Element(元素)
        ————定义一个Accept操作,它以一个访问者为参数。
    ConcreteElement(具体元素)
        ————实现Accept操作,该操作以一个访问者为参数。
    ObjectStructure(对象结构)
        ————能枚举它的元素。
        ————可以提供一个高层的接口以允许该访问者访问它的元素。
        ————可以是一个复合或是一个集合,如一个列表或一个无序集合。

#5.代码描述
当你想要为一个对象的组合增加新的能力，且封装并不重要时就使用访问者模式。

Visitor.java

```Java
    public interface Visitor {
        public void visit(GladiolusConcreteElement gladiolus);
        public void visit(ChrysanthemumConcreteElement chrysanthemum);
    }
```

FlowerElement.java

```Java
    public interface FlowerElement {
        public void accept(Visitor visitor);
    }
```

GladiolusConcreteElement.java

```Java
    public class GladiolusConcreteElement implements FlowerElement {
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }
```

ChrysanthemumConcreteElement.java

```Java
    public class ChrysanthemumConcreteElement implements FlowerElement {
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }
```

GladiolusVisitor.java

```Java
    public class GladiolusVisitor implements Visitor {
        @Override
        public void visit(GladiolusConcreteElement gladiolus) {
            System.out.println(this.getClass().getSimpleName() + " access " + gladiolus.getClass().getSimpleName());
        }
    
        @Override
        public void visit(ChrysanthemumConcreteElement chrysanthemum) {
            System.out.println(this.getClass().getSimpleName() + " access " + chrysanthemum.getClass().getSimpleName());
        }
    }
```

ChrysanthemumVisitor.java

```Java
    public class ChrysanthemumVisitor implements Visitor {
        @Override
        public void visit(GladiolusConcreteElement gladiolus) {
            System.out.println(this.getClass().getSimpleName() + " access " + gladiolus.getClass().getSimpleName());
        }
    
        @Override
        public void visit(ChrysanthemumConcreteElement chrysanthemum) {
            System.out.println(this.getClass().getSimpleName() + " access " + chrysanthemum.getClass().getSimpleName());
        }
    }
```

ObjectStructure.java

```Java
    public class ObjectStructure {
        private final List<FlowerElement> elements = new ArrayList<FlowerElement>();
    
        public void addElement(final FlowerElement e)
        {
            elements.add(e);
        }
    
        public void removeElement(final FlowerElement e)
        {
            elements.remove(e);
        }
    
        public void accept(final Visitor visitor)
        {
            for (final FlowerElement e : elements)
            {
                e.accept(visitor);
            }
        }
    }
```

Client.java

```Java
    public class Client {
        public static void main(final String[] args)
        {
            final ObjectStructure os = new ObjectStructure();
            os.addElement(new GladiolusConcreteElement());
            os.addElement(new ChrysanthemumConcreteElement());
    
            final GladiolusVisitor gVisitor = new GladiolusVisitor();
            final ChrysanthemumVisitor chVisitor = new ChrysanthemumVisitor();
    
            os.accept(gVisitor);
            os.accept(chVisitor);
    
        }
    }
```

result

    GladiolusVisitor access GladiolusConcreteElement
    GladiolusVisitor access ChrysanthemumConcreteElement
    ChrysanthemumVisitor access GladiolusConcreteElement
    ChrysanthemumVisitor access ChrysanthemumConcreteElement

#6.效果
1) 访问者模式使得易于增加新的操作

2) 访问者集中相关的操作而分离无关的操作

3) 增加新的 ConcreteElement类很困难

4) 通过类层次进行访问

5) 累积状态

6) 破坏封装