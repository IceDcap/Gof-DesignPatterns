Builder(生成器)————对象创建型
------------------------------------
#1.意图：
将一个复杂对象的构建和它的表示分离，使得同样的构建过程可以创建不同的表示
#2.使用环境：
当创建复杂对象的算法应该独立于该对象的组成部分以及它们的装配方式时
    
当构建过程必须允许被构造的对象有不同表示时
#3.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Builder.JPG "Builder")
#4.参与者
    Builder(TextConverter)
        ————为创建一个Product对象的各个部件指定抽象接口
    ConcreteBuilder(ASCIIConverter, TeXConverter, TextWidgetConverter)
        ————实现Builder的接口以构造和装配该产品的各个部件
        ————定义并明确它所创建的表示
        ————提供一个检索产品的接口(例如, getASCIIText(), getTextWidget())
    Director
        ————构造一个使用Builder接口的对象
    Product
        ————表示被构造的复杂对象（产品）,ConcreteBuilder负责该产品的内部表示并定义它的装配过程
        ————包含定义组成部件的类，包括将这些部件装配成最终产品的接口
        
#5.代码解释
现如今做一个文本转换器,TextConverter.java(Builder)定义了文本转换的3种方式,TeXConverter.java 
ASCIIConverter.java TextWidgetConverter(ConcreteBuilder)3种产品构建器分别实现TextConverter定义
的方式,该3种产品分别为ASCIIText, TextWidget, TeXText. RTFReader.java(Director)相当于主管控制着产
品的创建

```Java
    public class TextConverter {
        public void convertCharacter(char i){}
        public void convertFontChange(char i){}
        public void convertParagraph(){}
    }
    
    public class TeXConverter extends TextConverter {
        private TeXText texText;
    
        @Override
        public void convertCharacter(char i) {
            super.convertCharacter(i);
            System.out.println("execute Plan B for Tex to convert character");
        }
    
        @Override
        public void convertFontChange(char i) {
            super.convertFontChange(i);
            System.out.println("execute Plan B for Tex to convert FontChange");
        }
    
        @Override
        public void convertParagraph() {
            super.convertParagraph();
            System.out.println("execute Plan B for Tex to convert paragraph");
        }
    
        public TeXText getTexText() {
            return texText;
        }
    }
    
    public class ASCIIConverter extends TextConverter {
        private ASCIIText text;
    
        @Override
        public void convertCharacter(char i) {
            super.convertCharacter(i);
            System.out.println("execute Plan A for ASCII to convert character");
        }
    
        public ASCIIText getASCIIText() {
            return text;
        }
    }
    
    public class TextWidgetConverter extends TextConverter{
        private TextWidget textWidget;
    
        @Override
        public void convertCharacter(char i) {
            super.convertCharacter(i);
            System.out.println("execute Plan C for TextWidget to convert character");
        }
    
        @Override
        public void convertFontChange(char i) {
            super.convertFontChange(i);
            System.out.println("execute Plan C for TextWidget to convert FontChange");
        }
    
        @Override
        public void convertParagraph() {
            super.convertParagraph();
            System.out.println("execute Plan C for TextWidget to convert paragraph");
        }
    
        public TextWidget getTextWidget() {
            return textWidget;
        }
    }
```

Product

```Java
    public class ASCIIConverter extends TextConverter {
        private ASCIIText text;
    
        @Override
        public void convertCharacter(char i) {
            super.convertCharacter(i);
            text = new ASCIIText("Product ASCII Text");
            System.out.println("execute Plan A for ASCII to convert character");
        }
    
        public ASCIIText getASCIIText() {
            return text;
        }
    }
    
    public class TeXText {
        public TeXText() {
            System.out.println("this is product tex Text.");
        }
    }
    
    public class TextWidget {
        public TextWidget() {
            System.out.println("this is product text widget.");
        }
    }
```

Director

```Java
    public class RTFReader {
        private TextConverter textConverter;
    
        public RTFReader(TextConverter textConverter) {
            this.textConverter = textConverter;
        }
    
        public void parseRTF(int i) {
            if (i == 1) {
                textConverter.convertCharacter('i');
            } else if (i == 2) {
                textConverter.convertFontChange('f');
            } else {
                textConverter.convertParagraph();
            }
        }
    }
```

Client.java

```Java
    public class Client {
        public static void main(String[] args) {
            //initialize builder
            ASCIIConverter asciiConverter = new ASCIIConverter();
    
            //initialize director
            RTFReader rtfReader = new RTFReader(asciiConverter);
    
            //construct products
            rtfReader.parseRTF(1);
            rtfReader.parseRTF(2);
    
            //get product
            ASCIIText product = asciiConverter.getASCIIText();
            System.out.println(product.getName());
        }
    }
```

result

    execute Plan A for ASCII to convert character
    Product ASCII Text
    
    
在实际开发中Director角色经常被省略掉，而直接使用一个Builder来进行对象的组装，这个Builder通常为链式调用，它的关键点是每一个setter方法都返回自身（return this）。例如：

> new TestBuilder().setA("A").setB("B").create();

通过这种形式不仅去除了Director角色，整个结构也更加简单，也能对product对象的组装过程有更精细的控制。