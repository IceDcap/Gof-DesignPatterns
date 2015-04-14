Template Method(模板方法)————类行为型模式
----------
#1.意图：
定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。Template Method使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
#2.使用环境：
    在下列情况下使用模板方法模式：
    ——一次性实现一个算法的不变部分，并将可变的行为留给子类去完成
    ——各子类中公共的行为应该被提取出来并集中到一个公共父类中以避免代码重复
    ——控制子类扩展。模板方法只在特定点调用“hook”操作，这样就允许这些点进行扩展
#3.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Template.JPG "TemplateMethod")

#4.参与者
    AbstractClass(抽象类)
        ————定义抽象的原语操作(primitive operation),具体的子类将重定义它们以实现一个算法的各步骤
        ————实现一个模板方法,定义一个算法的骨架。该方法不仅调用原语操作,也调用定义在AbstractClass或其他对象中的操作
    ConcreteClass(具体类)
        ————实现原语操作以完成算法中与特定子类相关的步骤
        

#5.代码描述
泡咖啡操作：把水煮沸->用沸水冲泡咖啡->把咖啡倒进杯子->加糖和牛奶

沏茶操作：把水煮沸->用沸水浸泡茶叶->把茶倒进杯子->加柠檬

将相同的行为放到父类中，并将相似的行为在父类中进行抽象。

CaffeineBeverage.java

```Java
    public abstract class CaffeineBeverage {
    
        final void prepareRecipe() {
            boilWater();
            brew();
            pourInCup();
            addCondiments();
        }
    
        abstract void brew();
    
        abstract void addCondiments();
    
        void boilWater() {
            System.out.println("Boiling water...");
        }
    
        void pourInCup() {
            System.out.println("Pouring into cup.");
        }
    }
```

Tea.java

```Java
    public class Tea extends CaffeineBeverage {
        @Override
        void brew() {
            System.out.println("Steeping the tea.");
        }
    
        @Override
        void addCondiments() {
            System.out.println("Adding Lemon.");
        }
    }
```

Coffee.java

```Java
    public class Coffee extends CaffeineBeverage {
        @Override
        void brew() {
            System.out.println("Dripping Coffee through filter.");
        }
    
        @Override
        void addCondiments() {
            System.out.println("Adding Sugar and Milk.");
        }
    }
```

Client.java

```Java
    public class Client {
        public static void main(String[] args) {
            //Tea
            Tea tea = new Tea();
            tea.prepareRecipe();
            System.out.println("--------------------");
            //Coffee
            Coffee coffee = new Coffee();
            coffee.prepareRecipe();
        }
    }
```

result

    Boiling water...
    Steeping the tea.
    Pouring into cup.
    Adding Lemon.
    --------------------
    Boiling water...
    Dripping Coffee through filter.
    Pouring into cup.
    Adding Sugar and Milk.

#6.效果
模板方法是一种代码复用的基本技术。它们在类库中尤为重要，它们提取了类库中的公共行为。

模板方法导致一种反向的控制结构,这种结构有时被称为“好莱坞法则”,即“别找我们,
我们找你”。这指的是一个父类调用一个子类的操作,而不是相反。模板方法调用下列类型的操作:

• 具体的操作(ConcreteClass或对客户类的操作)。

• 具体的AbstractClass的操作(即,通常对子类有用的操作)。

• 原语操作(即,抽象操作)。

• Factory Method(参见Factory Method(3.5))。

• 钩子操作(hook operations),它提供了缺省的行为,子类可以在必要时进行扩展。一个
钩子操作在缺省操作通常是一个空操作。

很重要的一点是模板方法应该指明哪些操作是钩子操作(可以被重定义)以及哪些是抽
象操作(必须被重定义)。要有效地重用一个抽象类,子类编写者必须明确了解哪些操作是设 计为有待重定义的。
子类可以通过重定义父类的操作来扩展该操作的行为,其间可显式地调用父类操作。

#7.扩展
使用钩子，hook是一种被声明在抽象类中的方法，但是只有空的或者默认的实现。钩子的存在可以让子类有能力对算
法的不同点进行挂钩。要不要挂钩由子类决定。

有了钩子，我们能够决定要不要覆盖方法。如果我们不提供自己的方法，抽象类会提供一个默认的实现。

```Java
    public abstract class CaffeineBeverage {
    
        final void prepareRecipe() {
            boilWater();
            brew();
            pourInCup();
            //customer decide if add condiments.
            if (customerWantsCondiments()){
                addCondiments();
            }
        }
    
        abstract void brew();
    
        abstract void addCondiments();
    
        void boilWater() {
            System.out.println("Boiling water...");
        }
    
        void pourInCup() {
            System.out.println("Pouring into cup.");
        }
    
        //this is a hook. subclass can override or not.
        //default true.
        boolean customerWantsCondiments() {
            return true;
        }
    }
```

```Java
    public class CoffeeWithHook extends CaffeineBeverage {
        @Override
        void brew() {
            System.out.println("Dripping Coffee through filter.");
        }
    
        @Override
        void addCondiments() {
            System.out.println("Adding Sugar and Milk.");
        }
    
        @Override
        boolean customerWantsCondiments() {
            String answer = getUserInput();
            return answer.toLowerCase().startsWith("y");
        }
    
        private String getUserInput() {
            String answer = null;
    
            System.out.println("Would you  like milk and sugar with your coffee (y/n)?");
    
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            try {
                answer = in.readLine();
            } catch (IOException e) {
                System.err.println("IO error trying to read your answer");
            }
    
            if (null == answer)
                return "no";
            return answer;
        }
    }
```


#8.参考
Head First设计模式
