Flyweight(享元)————对象结构型
-------------
#1.意图：
运用共享技术有效的支持大量细粒度的对象

#2.使用环境：
    ————当一个应用程序使用了大量的对象
    ————完全由于使用了大量的对象，造成很大的存储开销
    ————对象的大多数状态都可以变为外部状态
    ————如果删除对象的外部状态，那么可以用相对较少的共享对象取代很多组对象
    ————应用程序不依赖于对象标示。由于flyweight对象可以被共享，对于概念上明显有别的对象，标示测试将返回真值。



#3.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/FlyWeight.JPG "FlyWeight")

#4.参与者
    Flyweight
        ————描述一个接口，通过这个接口flyweight可以接受并作用于外部状态
    ConcreteFlyweight
        ————实现Flyweight接口,并为内部状态(如果有的话)增加存储空间。ConcreteFlyweight对象必须是可共享的。
            它所存储的状态必须是内部的;即,它必须独立于ConcreteFlyweight对象的场景。
    UnsharedConcreteFlyweight
        ————并非所有的Flyweight子类都需要被共享。Flyweight接口使共享成为可能,但它并不强制共享。在Flyweight
            对象结构的某些层次,UnsharedConcreteFlyweight对象通常将ConcreteFlyweight对象作为子节点
    FlyWeightFactory
        ————创建并管理flyweight对象
        ————确保合理地共享flyweight。当用户请求一个flyweight时,FlyweightFactory对象提供一个已创建的实例或
            者创建一个(如果不存在的话)
    Client
        ————维持一个对flyweight的引用。
        ————计算或存储一个(多个)flyweight的外部状态。
#5.代码解释
当一个应用中使用了大量的对象，这些对象造成了很大的存储开销，而对象的大部分状态或参数都是相同（内部状态）的时候，
可以考虑使用享元模式，使用享元模式可以是这些对象引用都共享相同的实例，降低存储开销，而对象之间的不同的状态参数
(外部状态)则使用外部参数传入来实现。
    
WebSite.java

    package flyweight;
    
    public abstract class WebSite {
        protected String type;
        
        public WebSite(String type) {
            this.type = type;
        }
        
        public String getType() {
            return type;
        }
    
        public abstract void use(User user);
    }
    
ConcurrentWebSite.java
    
    package flyweight;
    
    public class ConcurrentWebSite extends WebSite {
        public ConcurrentWebSite(String type) {
            super(type);
        }
    
        @Override
        public void use(User user) {
            System.out.println("The web site's type is: " + type);
            System.out.println("User: " + user.getUserName());
            System.out.println("Passwd: " + user.getPassWd());
            System.out.println();
        }
    }
    
WebSiteFactory.java
    
    package flyweight;
    
    import java.util.HashMap;
    import java.util.Map;
    
    public class WebSiteFactory {
        private static Map<String, WebSite> webSites = new HashMap<String, WebSite>();
        
        private WebSiteFactory() {}
        
        public static WebSite createWebSite(String type) {
            WebSite webSite = webSites.get(type);
            if (webSite == null) {
                webSite = new ConcurrentWebSite(type);
                webSites.put(type, webSite);
            }
            return webSite;
        }
        
        public static int webSitesCount() {
            return webSites.size();
        }
    }
    
User.java
    
    package flyweight;
    
    public class User {
        private String userName;
        private String passWd;
        
        public User(String userName, String passWd) {
            this.userName = userName;
            this.passWd = passWd;
        }
        
        public String getUserName() {
            return userName;
        }
        
        public String getPassWd() {
            return passWd;
        }
    }
    
Test.java
    
    package flyweight;
    
    public class Test {
        public static void main(String[] args) {
            WebSite wb1 = WebSiteFactory.createWebSite("BusinessWebSite");
            User user1 = new User("root", "root");
            wb1.use(user1);
            
            WebSite wb2 = WebSiteFactory.createWebSite("BusinessWebSite");
            User user2 = new User("admin", "admin");
            wb2.use(user2);
            
            WebSite wb3 = WebSiteFactory.createWebSite("BusinessWebSite");
            User user3 = new User("slave", "slave");
            wb3.use(user3);
            
            WebSite wb4 = WebSiteFactory.createWebSite("PersonalWebSite");
            User user4 = new User("person", "person");
            wb4.use(user4);
            
            WebSite wb5 = WebSiteFactory.createWebSite("PersonalWebSite");
            User user5 = new User("alexis", "alexis");
            wb5.use(user5);
            
            WebSite wb6 = WebSiteFactory.createWebSite("PersonalWebSite");
            User user6 = new User("shadow", "shadow");
            wb6.use(user6);
            
            System.out.println("WebSites Instances Count: " + WebSiteFactory.webSitesCount());
        }
    }

输出结果
    
    The web site's type is: BusinessWebSite
    User: root
    Passwd: root
    
    The web site's type is: BusinessWebSite
    User: admin
    Passwd: admin
    
    The web site's type is: BusinessWebSite
    User: slave
    Passwd: slave
    
    The web site's type is: PersonalWebSite
    User: person
    Passwd: person
    
    The web site's type is: PersonalWebSite
    User: alexis
    Passwd: alexis
    
    The web site's type is: PersonalWebSite
    User: shadow
    Passwd: shadow
    
    WebSites Instances Count: 2
    
#6.参考
[http://www.cnblogs.com/zemliu/archive/2012/11/17/2775241.html](http://www.cnblogs.com/zemliu/archive/2012/11/17/2775241.html)
