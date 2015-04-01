Chain of responsibility(职责链)————对象行为型模式
----------
#1.意图：
使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递
该请求，直到有一个对象处理它为止。
#2.使用环境：
    ——有多个对象可以处理一个请求，哪个对象处理该请求运行时刻自动确定
    ——你想在不明确指定接收者的情况下，向多个对象中的一个提交一个请求
    ——可以处理一个请求的对象集合应被动态指定
#3.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/ChainOfResponsibility.JPG "ChainOfResponsibility")
#4.参与者
    Handler
        ————定义一个处理请求的接口
        ————（可选）实现后继链
    ConcreteHandler
        ————处理它所负责的请求
        ————可访问它的后继者
        ————如果可处理该请求，就处理之；否则将该请求转发给后继者
    Client
        ————向链上的具体处理者(ConcreteHandler)对象提交请求

#5.代码描述
某游戏公司会接收到一些邮件，邮件将分为：第一，Fans来信，大赞游戏。第二，父母来信，抱怨他们的孩子沉溺于游戏。第三，游戏店家寄来的
希望改进某些模块。第四，垃圾邮件。所有Fans的信都需要直接送到CEO手上，抱怨的信送给法律部门，改进请求的信交给开发部，垃圾邮件直接删除。

邮件接收职责链顺序为

          Spam Handler  ——>   Fan Handler  ——>  Compliant Handler  ——>  Suggest Handler

Handler(MailHandler.java)

```Java
public abstract class MailHandler {
    protected MailHandler successor;

    public void setSuccessor(MailHandler successor) {
        this.successor = successor;
    }

    protected abstract void handleRequest(String mailType);
}
```
    
ConcreteHandler(SpanHandler.java FanHandler.java CompliantHandler.java SuggestHandler.java)
    
    public class SpamHandler extends MailHandler {
        @Override
        protected void handleRequest(String mailType) {
            if (mailType.equals("spam"))
                System.out.println("delete the spam email.");
            else super.successor.handleRequest(mailType);
        }
    }
    
    public class FanHandler extends MailHandler {
        @Override
        protected void handleRequest(String mailType) {
            if (mailType.equals("fan"))
                System.out.println("send the fans email to ceo.");
            else successor.handleRequest(mailType);
        }
    }

    public class ComplaintHandler extends MailHandler {
        @Override
        protected void handleRequest(String mailType) {
            if (mailType.equals("complaint"))
                System.out.println("send the complaint email to law department.");
            else successor.handleRequest(mailType);
        }
    }
    
    public class SuggestHandler extends MailHandler {
        @Override
        protected void handleRequest(String mailType) {
            if (mailType.equals("suggest"))
                System.out.println("send the suggest email to develop department.");
        }
    }
    
Client.java

    public class Client {
        public static void main(String[] args) {
            MailHandler spam = new SpamHandler();
            MailHandler fans = new FanHandler();
            MailHandler compliant = new ComplaintHandler();
            MailHandler suggest = new SuggestHandler();
            spam.setSuccessor(fans);
            fans.setSuccessor(compliant);
            compliant.setSuccessor(suggest);
    
            spam.handleRequest("fan");
    //        spam.handleRequest("compliant");
            spam.handleRequest("suggest");
        }
    }

    
#6.效果
——降低耦合度

——增强了给对象指派职责的灵活性

——不保证被接受

#7.参考
Head First设计模式

[http://blog.csdn.net/vincentzhao2009/article/details/6216493](http://blog.csdn.net/vincentzhao2009/article/details/6216493)
[http://www.cnblogs.com/itTeacher/archive/2012/12/05/2803618.html](http://www.cnblogs.com/itTeacher/archive/2012/12/05/2803618.html)
