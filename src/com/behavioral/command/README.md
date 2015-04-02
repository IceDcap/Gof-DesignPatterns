Command(命令)————对象行为型模式
----------
#1.意图：
将一个请求封装为一个对象，从而是你可用不同的请求对客户进行参数化；对请求排队或者记录请求日志，以及支持可撤消的操作。
#2.别名
动作(Action),事务(Transaction)
#2.使用环境：
    当你有如下需求时,可使用Command模式:
    ——抽象出待执行的动作以参数化某对象。你可用过程语言中的回调(callback)函数表达这种参数化机制。所谓回调函数是指函数先在某处
        注册,而它将在稍后某个需要的时候被调用。Command模式是回调机制的一个面向对象的替代品。
    ——在不同的时刻指定、排列和执行请求。一个Command对象可以有一个与初始请求无关的生存期。如果一个请求的接收者可用一种与地址空
        间无关的方式表达,那么就可将负责该请求的命令对象传送给另一个不同的进程并在那儿实现该请求。
    ——支持取消操作。Command的Excute操作可在实施操作前将状态存储起来,在取消操作时这个状态用来消除该操作的影响。Command接口必须
        添加一个Unexecute操作,该操作取消上一次Execute调用的效果。执行的命令被存储在一个历史列表中。可通过向后和向前遍历这一列
        表并分别调用Unexecute和Execute来实现重数不限的“取消”和“重做”。
    ——支持修改日志,这样当系统崩溃时,这些修改可以被重做一遍。在Command接口中添加装载操作和存储操作,可以用来保持变动的一个一致的
        修改日志。从崩溃中恢复的过程包括从磁盘中重新读入记录下来的命令并用Execute操作重新执行它们。
    ——用构建在原语操作上的高层操作构造一个系统。这样一种结构在支持事务(transaction)的信息系统中很常见。一个事务封装了对数据的
        一组变动。Command模式提供了对事务进行建模的方法。Command有一个公共的接口,使得你可以用同一种方式调用所有的事务。同时使
        用该模式也易于添加新事务以扩展系统。
    
#3.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Command.JPG "Command")
#4.参与者
    Command
        ————声明执行操作的接口
    ConcreteCommand
        ————将一个接收者对象绑定于一个动作
        ————调用接收者相应的操作，以实现Execute
    Client
        ————创建一个具体命令对象并设定它的接收者
    Invoker
        ————要求该命令执行这个请求
    Receiver
        ————知道如何实施与执行一个请求相关的操作，任何类都可能作为一个接收者

#5.代码描述
最直观的例子就是遥控器。用遥控器控制灯的开关。。。

灯(Receiver)的开和关命令(Action())直接独立为一个对象(ConcreteCommand)，遥控器(Invoker)的按钮是触发灯的开关，触发后由具体
的开关命令(ConcreteCommand)来执行。

Command.java

```Java
    public interface Command {
        public void execute();
    }
```

ConcreteCommand(LightOnCommand.java LightOffCommand.java)

```Java
    public class LightOnCommand implements Command {
        private Light light;
    
        public LightOnCommand(Light light) {
            this.light = light;
        }
    
        @Override
        public void execute() {
            light.on();
        }
    }
    
    public class LightOffCommand implements Command {
        private Light light;
    
        public LightOffCommand(Light light) {
            this.light = light;
        }
    
        @Override
        public void execute() {
            light.off();
        }
    }
```
    
Invoker(RemoteControl.java)

```Java
    public class RemoteControl {
        private Command menu;
    
        public void setMenu(Command menu) {
            this.menu = menu;
        }
    
        public void menuPressed() {
            menu.execute();
        }
    }
```
    
Receiver(Light.java)

```Java
    public class Light {
        private String brandName;
    
        public Light(String brandName) {
            this.brandName = brandName;
        }
    
        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }
    
        public String getBrandName() {
            return brandName;
        }
    
        public void on(){
            System.out.println(brandName + " turned on...");
        }
        public void off(){
            System.out.println(brandName + " turned off...");
        }
    }
```

Client.java

```Java
    public class Client {
        public static void main(String[] args) {
            Light light = new Light("nb");
            RemoteControl control = new RemoteControl();
            Command on = new LightOnCommand(light);
            Command off = new LightOffCommand(light);
    
            control.setMenu(on);
            control.menuPressed();
            control.setMenu(off);
            control.menuPressed();
        }
    }
```
    
#6.效果
Command模式有以下效果:

1) Command模式将调用操作的对象与知道如何实现该操作的对象解耦。 

2) Command是头等的对象。它们可像其他的对象一样被操纵和扩展。

3) 你可将多个命令装配成一个复合命令。例如是前面描述的MacroCommand类。一般说来,复合命令是Composite模式的一个实例。

4) 增加新的Command很容易,因为这无需改变已有的类。

#7.参考
Head First设计模式