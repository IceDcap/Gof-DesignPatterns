Adapter（适配器）————类对象结构型
----------
#1.意图：
将一个类的接口转换成客户希望的另一个接口，Adapter模式使得原本由于接口不兼容而不能一起工作的类可以一起工作。
#2.别名
包装器（Wrapper）
#3.使用环境：
    ————使用一个存在的类，而它的接口不符合你的要求
    ————创建一个可复用的类，该类可以与其他不相符的类或者不可预见的类（即那些接口不一定兼容的类）协同工作
    ————（仅适用于对象Adapter）当你想使用一些已经存在的子类，但是不可能对每一个都进行子类化以匹配它们的接口。
        对象适配器可以适配它的父类接口
    Android中最常见的就是ListView和BaseAdapter的组合使用
#4.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Adapter.JPG "Adapter")
#5.参与者
    Target
        ————定义Client使用的与特定领域相关的接口
    Client
        ————与符合Target接口的对象协同
    Adaptee
        ————定义一个已经存在的接口与Target接口进行适配
    Adapter
        ————对Adaptee的接口与Target接口进行适配

#6.代码描述
最常见的例子就是充电器（无论手机还是电脑）它们的充电电压不能使用我们标准的220v，故要中间加一个适配器才能充电
例如手机充电，充电电压需要5v（Target），手机充电器（或叫适配器）可以将22v电压转化为5v（Adapter），充电对象手机（Adaptee）

Target(VoltageAdapter.java)

```Java
    /**
     * Target
     */
    public interface VoltageAdapter {
        public int transformVoltage();
    }
```
    
Adapter(PhoneAdapter.java)

```Java   
    /**
     * Adapter
     */
    public class PhoneAdapter implements VoltageAdapter {
    
        private int requestVoltage;
        private int standardVoltage = 220;
    
        public PhoneAdapter(int requestVoltage) {
            this.requestVoltage = requestVoltage;
        }
    
        public void setRequestVoltage(int requestVoltage) {
            this.requestVoltage = requestVoltage;
        }
    
        public void setStandardVoltage(int standardVoltage) {
            this.standardVoltage = standardVoltage;
        }
    
        public int getRequestVoltage() {
    
            return requestVoltage;
        }
    
        public int getStandardVoltage() {
            return standardVoltage;
        }
    
        @Override
        public int transformVoltage() {
            System.out.println("standard voltage is " + standardVoltage + "v.");
            System.out.println("the transform voltage is " + requestVoltage + "v.");
            return requestVoltage;
        }
    }
```
    
Adaptee(Phone.java)

```Java
    /**
     * Adaptee
     */
    public class Phone {
        private VoltageAdapter adapter;
    
        public VoltageAdapter getAdapter() {
            return adapter;
        }
    
        public void setAdapter(VoltageAdapter adapter) {
            this.adapter = adapter;
        }
    
        public void inputVoltage(){
            System.out.println("The phone charge voltage is " + adapter.transformVoltage() + "v.");
        }
    }
```
    
Client.java

```Java    
    public class Client {
        public static void main(String[] args) {
            Phone phone = new Phone();
            VoltageAdapter adapter = new PhoneAdapter(5);
            phone.setAdapter(adapter);
            phone.inputVoltage();
        }
    }
```     
