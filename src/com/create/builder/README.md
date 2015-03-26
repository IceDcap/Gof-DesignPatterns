#1.意图：
将一个复杂对象的构建和它的表示分离，使得同样的构建过程可以创建不同的表示
#2.使用环境：
当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时
    当构建过程必须允许被构造的对象有不同表示时
#3.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/tree/master/uml/Builder.JPG "Builder")
#4.参与者
    Builder(TextConverter)
        ----为创建一个Product对象的各个部件指定抽象接口
    ConcreteBuilder(ASCIIConverter, TeXConverter, TextWidgetConverter)
        ----实现Builder的接口以构造和装配该产品的各个部件
        ----定义并明确它所创建的表示
        ----提供一个检索产品的接口(例如, getASCIIText(), getTextWidget())
    Director
        ----构造一个使用Builder接口的对象
    Product
        ----表示被构造的复杂对象（产品）,ConcreteBuilder负责该产品的内部表示并定义它的装配过程
        ----包含定义组成部件的类，包括将这些部件装配成最终产品的接口