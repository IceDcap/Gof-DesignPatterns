Facade(外观)————对象结构型
-------------
#1.意图：
为子系统中的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个接口使得这一子系统更加容易使用

#2.使用环境：
    ————当你为一个复杂的子系统提供一个简单接口时，子系统往往因为不断演化而变得越来越复杂。大多数的模式使用时都会产生更多更小的类
        这使得子系统更加具有可重用性，也更容易对子系统进行定制，但这也给那些不需要订制子系统的用户带来一些使用上的困难。Facade
        可以提供一个简单的缺省视图，这一视图对大多数用户来说已经足够，而那些需要更多的可定制性的用户可以越过Facade层
    ————客户程序与抽象类的实现部分之间存在这很大的依赖性和可移植性。引入Facade将这个子系统与客户以及其他的子系统分离，可以提高
        子系统的独立性和可移植性。
    ————当你需要构建一个层次结构的子系统时，使用Facade模式定义子系统中的每层的入口点。如果子系统之间是相互依赖的，你可以让它们
        仅通过Facade进行通讯，从而简化了它们之间的依赖关系



#3.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Facade.JPG "Facade")

#4.参与者
    Facade
        ————知道哪些子系统类负责处理请求
        ————将客户的请求代理给适当的子系统对象
    Subsystem classes
        ————实现子系统的功能
        ————处理由Facade对象指派的任务
        ————没有Facade的任何相关信息；既没有指向Facade的指针
    
#5.参考
[http://www.blogjava.net/supercrsky/articles/202854.html](http://www.blogjava.net/supercrsky/articles/202854.html)
[http://blog.csdn.net/hfmbook/article/details/7702642](http://blog.csdn.net/hfmbook/article/details/7702642)
