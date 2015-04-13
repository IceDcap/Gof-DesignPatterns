State(状态)————对象行为型模式
----------
#1.意图：
允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类。
#2.别名
状态对象(Objects for States)
#3.使用环境：
    在下列情况下使用state模式：
    ——一个对象的行为取决于它的状态,并且它必须在运行时刻根据状态改变它的行为
    ——一个操作中含有庞大的多分支的条件语句,且这些分支依赖于该对象的状态。这个状
      态通常用一个或多个枚举常量表示。通常,有多个操作包含这一相同的条件结构。State
      模式将每一个条件分支放入一个独立的类中。这使得你可以根据对象自身的情况将对象的
      状态作为一个对象,这一对象可以不依赖于其他对象而独立变化。
#4.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/State.JPG "State")
#5.参与者
    Context(环境)
        ————定义客户感兴趣的接口
        ————维护一个ConcreteState子类的实例，这个实例定义当前状态
    State(状态)
        ————定义一个接口以封装与Context的一个特定相关的行为
    ConcreteState subclasses(具体状态子类)
        ————每一子类实现一个与Context的状态相关的行为
        

#6.代码描述
自动售糖机，具有以下几个状态和操作流程
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/statemachine.png "statemachine")

State(State.java)

```Java
    public interface State {
        public void insertQuarter();
        public void ejectQuarter();
        public void turnCrank();
        public void dispense();
    }
```

ConcreteState(NoQuarterState.java HasQuarterState.java SoldState.java WinnerState.java SoldOutState.java)

```Java
    public class NoQuarterState implements State {
        GumballMachine gumballMachine;
    
        public NoQuarterState(GumballMachine gumballMachine) {
            this.gumballMachine = gumballMachine;
        }
    
        @Override
        public void insertQuarter() {
            System.out.println("You insert a quarter");
            gumballMachine.setState(gumballMachine.getHasQuarterState());
        }
    
        @Override
        public void ejectQuarter() {
            System.out.println("Sorry, handle mistake");
        }
    
        @Override
        public void turnCrank() {
            System.out.println("Sorry, handle mistake");
        }
    
        @Override
        public void dispense() {
            System.out.println("Sorry, handle mistake");
        }
    }
    
    public class HasQuarterState implements State {
        GumballMachine gumballMachine;
    
        public HasQuarterState(GumballMachine gumballMachine) {
            this.gumballMachine = gumballMachine;
        }
    
        @Override
        public void insertQuarter() {
            System.out.println("You can't insert another quarter");
        }
    
        @Override
        public void ejectQuarter() {
            System.out.println("Quarter returned");
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }
    
        @Override
        public void turnCrank() {
            System.out.println("You turned the Crank..");
            int num = (int) (Math.random() * 9);
            if (num == 0) {
                System.out.println("Congratulations, you win a prize two gumballs!");
                gumballMachine.setState(gumballMachine.getWinnerState());
            } else
                gumballMachine.setState(gumballMachine.getSoldState());
        }
    
        @Override
        public void dispense() {
            System.out.println("Sorry, handle mistake");
        }
    }

    public class SoldState implements State {
        GumballMachine gumballMachine;
    
        public SoldState(GumballMachine gumballMachine) {
            this.gumballMachine = gumballMachine;
        }
    
        @Override
        public void insertQuarter() {
            System.out.println("Please wait, we are already giving you a gumball");
        }
    
        @Override
        public void ejectQuarter() {
            System.out.println("Sorry, handle mistake");
        }
    
        @Override
        public void turnCrank() {
            System.out.println("Sorry, handle mistake");
        }
    
        @Override
        public void dispense() {
            gumballMachine.releaseBall();
            if (gumballMachine.getCount() > 0)
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            else {
                gumballMachine.setState(gumballMachine.getSoldOutState());
                System.out.println("Oops, out of gumballs!");
            }
        }
    }
    
    public class WinnerState implements State {
        GumballMachine gumballMachine;
    
        public WinnerState(GumballMachine gumballMachine) {
            this.gumballMachine = gumballMachine;
        }
    
        @Override
        public void insertQuarter() {
            System.out.println("Sorry, handle mistake");
        }
    
        @Override
        public void ejectQuarter() {
            System.out.println("Sorry, handle mistake");
        }
    
        @Override
        public void turnCrank() {
            System.out.println("Sorry, handle mistake");
        }
    
        @Override
        public void dispense() {
            gumballMachine.releaseBall();
            if (gumballMachine.getCount() > 0) {
                System.out.println("You got two gumballs.");
                gumballMachine.setState(gumballMachine.getNoQuarterState());   
            }
            else {
                gumballMachine.setState(gumballMachine.getSoldOutState());
                System.out.println("Oops, out of gumballs!");
            }
        }
    }

    public class SoldOutState implements State {
        GumballMachine gumballMachine;
    
        public SoldOutState(GumballMachine gumballMachine) {
            this.gumballMachine = gumballMachine;
        }
    
        @Override
        public void insertQuarter() {
            System.out.println("out of gumballs! Please wait...");
        }
    
        @Override
        public void ejectQuarter() {
            System.out.println("out of gumballs! Please wait...");
        }
    
        @Override
        public void turnCrank() {
            System.out.println("out of gumballs! Please wait...");
        }
    
        @Override
        public void dispense() {
            System.out.println("out of gumballs! Please wait...");
        }
    }
```

Context(GumballMashine.java)

```Java
    /**
     * Context
     */
    public class GumballMachine {
        State soldOutState;
        State noQuarterState;
        State hasQuarterState;
        State soldState;
        State winnerState;
    
        State state = soldOutState;
        int count = 0;
    
        public GumballMachine(int count) {
            soldOutState = new SoldOutState(this);
            noQuarterState = new NoQuarterState(this);
            hasQuarterState = new HasQuarterState(this);
            soldState = new SoldState(this);
            winnerState = new WinnerState(this);
            this.count = count;
            if (count > 0) {
                state = noQuarterState;
            }
        }
    
        public void insertQuarter() {
            state.insertQuarter();
        }
    
        public void ejectQuarter() {
            state.ejectQuarter();
        }
    
        public void turnCrank() {
            state.turnCrank();
            state.dispense();
        }
    
        public void setState(State state) {
            this.state = state;
        }
    
        public void releaseBall() {
            System.out.println("release a ball....");
            if (count != 0) {
                count = count - 1;
            }
        }
    
        public State getSoldOutState() {
            return soldOutState;
        }
    
        public State getNoQuarterState() {
            return noQuarterState;
        }
    
        public State getHasQuarterState() {
            return hasQuarterState;
        }
    
        public State getSoldState() {
            return soldState;
        }
    
        public State getWinnerState() {
            return winnerState;
        }
    
        public State getState() {
            return state;
        }
    
        public int getCount() {
            return count;
        }
    }
```

Test.java

```Java
    public class Test {
        public static void main(String[] args) {
            GumballMachine gumballMachine = new GumballMachine(20);
            gumballMachine.insertQuarter();
            gumballMachine.ejectQuarter();
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
        }
    }
```

result
    
    You insert a quarter
    Quarter returned
    You insert a quarter
    You turned the Crank..
    Congratulations, you win a prize two gumballs!
    release a ball....
    You got two gumballs.


#7.效果
1).它将与特定状态相关的行为局部化,并且将不同状态的行为分割开来

2).它使得状态转换显式化

3).State对象可被共享

#8.参考
Head First设计模式

