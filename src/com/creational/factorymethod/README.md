Factory Method(工厂方法)————类创建型
------------------------------------
#1.意图：
定义一个用于创建对象的接口，让子类决定实例化哪个类，FactoryMethod使一个类的实例化延迟到子类
#2.别名：
虚构造器（Virtual Constructor）
#3.使用环境
当一个类不知道它所必须创建的对象的类的时候
    当一个类希望由它的子类来指定它所创建的对象的时候
    当类将创建对象的职责委托给多个帮助子类中的某一个，并且你希望将哪一个帮助子类是代理者这一信息局部化的时候
#4.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Factory.JPG "Factory")
#5.参与者
    Product（Document）
        ————定义工厂方法所创建的对象的接口
    ConcreteProduct（MyDocument）
        ————实现Product接口
    Creator（Application）
        ————声明工厂方法，该方法返回一个Product类型的对象。Creator也可以定义一个工厂方法的缺省实现，
            它返回一个缺省的ConcreteProduct对象
        ————可以调用工厂方法以创建一个Product对象
    ConcreteCreator（MyApplication）
        ————重定义一个工厂方法以返回一个ConcreteProduct实例
        
#6.代码解释
创建一个文档类Document.java(Product)并定义了一些接口,MyDocument(ConcreteProduct)类实现了Document接口
声明创建者Application(Creator)该类声明工厂方法返回产品实例(可以缺省实现，由其子类来完成),MyApplication(
ConcreteCreator)类重定义或者补充父类Creator的工厂方法

Document.java

```Java
    public abstract class Document {
        public abstract void open();
        public abstract void close();
        public abstract void save();
        public abstract void revert();
    
    }
```

MyDocument.java

```Java
    public class MyDocumnet extends Document{
        private String name;
        public MyDocumnet(String name) {
            this.name = name;
        }
    
        @Override
        public void open() {
            System.out.println("open my document: " + name);
        }
    
        @Override
        public void close() {
            System.out.println("close my document: " + name);
        }
    
        @Override
        public void save() {
            System.out.println("save my document: " + name);
        }
    
        @Override
        public void revert() {
            System.out.println("revert my document: " + name);
        }
    }
```

Application.java

```Java
    public class Application {
        public MyDocumnet createDocument(){
            System.out.println("create document from Creator");
            return new MyDocumnet("sophia parent");
        }
        public void newDocument(){
            System.out.println("new document from Creator");
        }
        public void openDocument(){
            System.out.println("open document from Creator");
        }
    }
```

MyApplication.java

```Java
    public class MyApplication extends Application {
    
        @Override
        public MyDocumnet createDocument() {
            System.out.println("create document from MyApplication");
            return new MyDocumnet("sophia");
        }
    }
```

Client.java

```Java
    public class Client {
    
        public static void main(String[] args) {
            MyApplication myApplication = new MyApplication();
            MyDocumnet myDocumnet = myApplication.createDocument();
            myDocumnet.open();
            myDocumnet.revert();
            myDocumnet.save();
            myDocumnet.close();
        }
    }
```

result

    create document from MyApplication
    open my document: sophia
    revert my document: sophia
    save my document: sophia
    close my document: sophia
    

对于工厂方法模式中的具体工厂中要创建的具体产品可以使用反射机制，智能化创建。例如,有三款ConcreteProduct分别为AudiQ3、AudiQ5、AudiQ7

```java
public abstract class AudiCar {
    public abstract void drive();
    public abstract void selfNavigation();
}

public class AudiQ3 extends AudiCar {
    @Override
    public void drive() {
        System.out.println("Q3 drive.");
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q3 self navigation.");
    }
}

public class AudiQ5 extends AudiCar {
    @Override
    public void drive() {
        System.out.println("Q5 drive.");
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q5 self navigation.");
    }
}

public class AudiQ7 extends AudiCar {
    @Override
    public void drive() {
        System.out.println("Q7 drive.");
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q7 self navigation.");
    }
}
```

对应的AbstractFactory，使用反射来创建产品
```java
public abstract class AudiFactory {
    public abstract <A extends AudiCar> A createAudi(Class<A> clz);
}

public class AudiCarFactory extends AudiFactory {
    @Override
    public <A extends AudiCar> A createAudi(Class<A> clz) {
        AudiCar audiCar = null;
        try {
            audiCar  = (AudiCar) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (A)audiCar;
    }
}

```

对应的客户端以及打印情况如下
```java
public class AudiClient {
    public static void main(String[] args) {
        AudiFactory factory = new AudiCarFactory();
        AudiQ3 q3 = factory.createAudi(AudiQ3.class);
        q3.drive();
        q3.selfNavigation();

        AudiQ5 q5 = factory.createAudi(AudiQ5.class);
        q5.drive();
        q5.selfNavigation();

        AudiQ7 q7 = factory.createAudi(AudiQ7.class);
        q7.drive();
        q7.selfNavigation();

    }
}

```

```
Q3 drive.
Q3 self navigation.
Q5 drive.
Q5 self navigation.
Q7 drive.
Q7 self navigation.
```