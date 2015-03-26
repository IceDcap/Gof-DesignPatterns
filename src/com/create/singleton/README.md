#1.意图：
保证一个类仅有一个实例，并提供一个访问它的全局访问点
#2.使用环境：
当类只能有一个实例而且客户可以从一个众所周知的访问点访问
当这个唯一实例应该是通过子类化可扩展的，并且客户应该无需更改代码就能使用一个扩展的实例时
#3.结构
![github](http://github.com/IceDcap/Gof-DesignPatterns/blob/tree/master/uml/Singleton.JPG.png "Singleton")
#4.参与者
Singleton
        ----定义一个Instance操作，允许客户访问它的唯一实例。Instance是一个类操作
        ----可能负责创建它自己的唯一实现

# 下面就用代码具体说说单例模式：
在开发中我们最常使用的就是如下代码的单例

        /**
         * Thread dangerous
         * 
         */
        public class Singleton1 {
            private static Singleton1 uniqueInstance;

            private Singleton1() {
            }

            public static Singleton1 getInstance() {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton1();
                    return uniqueInstance;
                }
                return uniqueInstance;
            }
        }

    这种方式的单例是存有隐患的，当在多线程中单例的效果就有可能失效了，因为它不是线程安全的编码方式。

    解决方法很简单，让它线程安全不就行了！！如下代码：

        /**
         * add synchronized
         * 
         */
        public class Singleton1 {
            private static Singleton1 uniqueInstance;

            private Singleton1() {
            }

            public static synchronized Singleton1 getInstance() {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton1();
                    return uniqueInstance;
                }
                return uniqueInstance;
            }
        }

    可是当我们运用到大型系统中我们又不得不考虑同步造成性能问题?
    怎么办呢？
    其实事物总是有两面性，不可能在追求性能的时候还要考虑线程安全问题，那么就需要我们在开发软件过程中遇到具体问题就要具体分析到底应用哪种类型的单例模式。

    改善方法：
    如果getInstance（）的性能对应用程序不是很关键，就什么都不做。
    使用“急切”创建实例，而不是延迟实例化的做法（也就是俗称的饿汉式）

        /**
         * 恶汉式
         * 
         */
        public class Singleton2 {
            private static Singleton2 uniqueInstance = new Singleton2();

            private Singleton2() {
            }

            public static Singleton2 getInstance() {
                return uniqueInstance;
            }
        }
        
    这种方法利用JVM在加载类时马上创建唯一实例，从而保障任何线程访问getInstance之前就创建唯一实例。
    用“检查加锁”，在getInstance（）中减少使用同步
    首先检查是否实例已经创建了，如果尚未创建，“才”进行同步。这样一来，只有第一次会同步，这正是我们想要的。

        /**
         * double-checked locking
         * 
         */
        public class Singleton3 {
            private volatile static Singleton3 uniqueInstance;

            private Singleton3() {
            }

            public static synchronized Singleton3 getInstance() {
                if (uniqueInstance == null) {
                    synchronized (Singleton3.class) {
                        if (uniqueInstance == null) {
                            uniqueInstance = new Singleton3();
                            return uniqueInstance;
                        }
                    }
                }
                return uniqueInstance;
            }
        }

    volatile关键字确保：当uniqueInstance变量被初始化成Singleton3实例时，多个线程正确的处理uniqueInstance变量。







