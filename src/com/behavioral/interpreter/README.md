Interpreter(解释器)————类行为型模式
----------
#1.意图：
给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子
#2.使用环境：
    当有一个语言需要解释执行,并且你可将该语言中的句子表示为一个抽象语法树时,可使用解释器模式。而当存在以下
    情况时该模式效果最好:
    • 该文法简单对于复杂的文法,文法的类层次变得庞大而无法管理。此时语法分析程序生成器这样的工具是更好的选择。
        它们无需构建抽象语法树即可解释表达式,这样可以节省空间而且还可能节省时间。
    • 效率不是一个关键问题最高效的解释器通常不是通过直接解释语法分析树实现的,而是首先将它们转换成另一种形式。
        例如,正则表达式通常被转换成状态机。但即使在这种情况下, 转换器仍可用解释器模式实现,该模式仍是有用的。
#3.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Interpreter.JPG "Interpreter")
#4.参与者
    AbstractExpression(抽象表达式)
        ————声明一个抽象的解释操作，这个接口为抽象语法树中所有的节点所共享
    TerminalExpression(终结符表达式)
        ————实现与文法中的终结符相关联的解释操作
        ————一个句子中的每个终结符需要该类的一个实例
    NonterminalExpression(非终结符表达式)
        ————对文法中的每一条规则R::=R1R2...Rn都需要一个NonterminalExpression类
        ————为从R1到Rn的每个符号都维护一AbstractExpression类型的实例变量
        ————为文法中的非终结符实现解释(Interpret)操作。解释(Interpret)一般要递归地调用表示
            R1到Rn的那些对象的解释操作
    Context(上下文)
        ————包含解释器之外的一些全局信息
    Client
        ————构建(或被给定)表示该文法定义的语言中一个特定的句子的抽象语法树。该抽象语法树由NonterminalExpression
            和TerminalExpression的实例装配而成
        ————调用解释操作

#5.代码描述
计算圆的面积，S = π * r².这里就有一个变量，两个运算符一个乘法一个平方（其实算作一个了，为了解释方便，分成两个）我们
只要知道r的值就能算出圆的面积，因此上下文中应该持有r变量，一旦拿到r的值就终止解释器(TerminalExpression)，对于两个
运算的解释分别定义为SquareNonterminalExpression和MultiplyNonterminalExpression，AbstractExpression定义抽象
解释方法(参数只传上下文)

AbstractExpression.java

```Java
    public abstract class AbstractExpression {
        protected abstract float interpreter(Context context);
    }
```

Context.java

```Java
    public class Context {
        public static final float PI = 3.14f;
        private float r;
    
        public Context() {
        }
    
        public Context(float r) {
            this.r = r;
        }
    
        public void setR(float r) {
            this.r = r;
        }
    
        public float getR() {
            return r;
        }
    }
```

NonterminalExpression(MultiplyNonterminalExpression.java SquareNonterminalExpression.java)

```Java
    public class MultiplyNonterminalExpression extends AbstractExpression {
        AbstractExpression expression;
    
        public MultiplyNonterminalExpression(AbstractExpression expression) {
            this.expression = expression;
        }
    
        @Override
        protected float interpreter(Context context) {
            return Context.PI * expression.interpreter(context);
        }
    }
    
    public class SquareNonterminalExpression extends AbstractExpression{
        AbstractExpression expression;
    
        public SquareNonterminalExpression(AbstractExpression expression) {
            this.expression = expression;
        }
    
        @Override
        protected float interpreter(Context context) {
            return expression.interpreter(context) * expression.interpreter(context);
        }
    }
```

TerminalExpression.java

```Java
    public class TerminalExpression extends AbstractExpression {
        private float r;
    
        public TerminalExpression(float r) {
            this.r = r;
        }
    
        @Override
        protected float interpreter(Context context) {
            return r;
        }
    }
```

Client.java

```Java
    public class Client {
        public static void main(String[] args) {
            final Context context = new Context(4.3f);
            final SquareNonterminalExpression squareValue = new SquareNonterminalExpression(new TerminalExpression(context.getR()));
            final MultiplyNonterminalExpression multiplyValue = new MultiplyNonterminalExpression(squareValue);
    
            System.out.println("result is " + multiplyValue.interpreter(context));
        }
    }
```


#6.效果
——易于改变和扩展文法

——也易于实现文法

——复杂的文法难以维护

——增加了新的解释表达式的方式

#7.参考
[http://blog.csdn.net/hfmbook/article/details/7688593](http://blog.csdn.net/hfmbook/article/details/7688593)
[http://www.cnblogs.com/itTeacher/archive/2012/12/12/2814437.html](http://www.cnblogs.com/itTeacher/archive/2012/12/12/2814437.html)
