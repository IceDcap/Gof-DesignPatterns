Observer(观察者)————对象行为型模式
----------
#1.意图：
定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
#2.别名
依赖(Dependents),发布-订阅(Publish-Subscribe)
#3.使用环境：
    在下列情况下使用观察者模式：
    ——当一个抽象模型有两个方面，其中一个方面依赖于另一个方面，将这二者封装在独立的对象中以使它们可以各
      自独立地改变和复用
    ——当对一个对象的改变需要同时改变其他对象，而不知道具体有多少对象有待改变
    ——当一个对象必须通知其他对象，而它又不能假定其他对象是谁。换言之，你不希望这些对象是紧密耦合的
#4.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Observer.JPG "Observer")
#5.参与者
    Subject(目标)
        ————目标知道它的观察者，可以有任意多个观察者观察同一个目标
        ————提供注册和删除观察者对象的接口
    Observer(观察者)
        ————为那些在目标发生改变时需获得通知的对象定义一个更新接口
    ConcreteSubject(具体目标)
        ————将有关状态存入各ConcreteObserver对象
        ————当它的状态发生改变时，向它的各个观察者发出通知
    ConcreteObserver(具体观察者)
        ————维护一个指向ConcreteSubject对象的引用
        ————存储有关状态，这些状态应与目标的状态保持一致
        ————实现Observer的更新接口以使自身状态与目标的状态保持一致
    

#6.代码描述
Swing大量使用了观察者模式。许多GUI框架亦如此。
此模式也被应用到许多地方，如：javaBean、RMI。

例子：猎头-求职者是一个典型的观察者模式，求职者先在猎头处注册当有新工作机会时就会通知求职者（类似于发布订阅模式）

Subject.java

```Java
    public interface Subject {
        public void attach(Observer o);
        public void detach(Observer o);
        public void notifyAllObserver();
    }
```

Observer.java
    
```Java    
    public interface Observer {
        public void update(Subject subject);
    }
```
    
猎头HeadHunter.java

```Java
    public class HeadHunter implements Subject {
        private List<Observer> observers;
        private List<String> jobs;
    
        public HeadHunter() {
            observers = new ArrayList<Observer>();
            jobs = new ArrayList<String>();
        }
    
        @Override
        public void attach(Observer o) {
            observers.add(o);
        }
    
        @Override
        public void detach(Observer o) {
            observers.remove(o);
        }
    
        @Override
        public void notifyAllObserver() {
            for (Observer o : observers) {
                o.update(this);
            }
        }
    
        //add jobs info
        public void addJobs(String job) {
            jobs.add(job);
            notifyAllObserver();
        }
    
        public List<String> getJobs() {
            return jobs;
        }
    
        @Override
        public String toString() {
            return "HeadHunter{" +
                    "jobs=" + jobs +
                    '}';
        }
    }
```

具体的观察者JobSeeker.java

```Java
    public class JobSeeker implements Observer {
    
        private String name;
    
        public JobSeeker(String name) {
            this.name = name;
        }
    
        @Override
        public void update(Subject subject) {
            System.out.println(name + " receive a message.");
            System.out.println(subject);
        }
    }
```

Client.java

```Java
    public class Client {
    
        public static void main(String[] args) {
            HeadHunter hunter = new HeadHunter();
            hunter.attach(new JobSeeker("Luffy"));
            hunter.attach(new JobSeeker("Nami"));
            hunter.attach(new JobSeeker("Zoro"));
            hunter.attach(new JobSeeker("Usopp"));
    
            hunter.addJobs("Captain");
            hunter.addJobs("Cheater");
            hunter.addJobs("Swordsman");
        }
    }
```

result
    
    Luffy receive a message.
    HeadHunter{jobs=[Captain]}
    Nami receive a message.
    HeadHunter{jobs=[Captain]}
    Zoro receive a message.
    HeadHunter{jobs=[Captain]}
    Usopp receive a message.
    HeadHunter{jobs=[Captain]}
    Luffy receive a message.
    HeadHunter{jobs=[Captain, Cheater]}
    Nami receive a message.
    HeadHunter{jobs=[Captain, Cheater]}
    Zoro receive a message.
    HeadHunter{jobs=[Captain, Cheater]}
    Usopp receive a message.
    HeadHunter{jobs=[Captain, Cheater]}
    Luffy receive a message.
    HeadHunter{jobs=[Captain, Cheater, Swordsman]}
    Nami receive a message.
    HeadHunter{jobs=[Captain, Cheater, Swordsman]}
    Zoro receive a message.
    HeadHunter{jobs=[Captain, Cheater, Swordsman]}
    Usopp receive a message.
    HeadHunter{jobs=[Captain, Cheater, Swordsman]}

#7.效果
1).目标和观察者间抽象耦合

2).支持广播通信

3).意外的更新


