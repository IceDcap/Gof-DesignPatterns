Composite(组合)————对象结构型
-------------
#1.意图：
将对象组合成树形结构以表示“部分-整体”的层次结构。Composite使得用户对单个对象和组合对象的使用具有一致性
#2.使用环境：
    ————表示对象的部分和整体的层次结构
    ————用户忽略组合对象与单个对象的不同，用户将统一地使用组合结构中的所有对象



#3.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Composite.JPG "Composite")
    
    典型的Composite对象结构如下    
                                       __________
                                      |aComposite|
                                       ——————————
                                        /  |    \
                                       /   |     \   
                                      /    |      \    
                                     /     |       \      
                                 _____   _____    __________
                                |aLeaf| |aLeaf|  |aComposite|  
                                 -----   -----    ----------
                                                  /       \                
                                                /          \
                                              _____      _____
                                             |aLeaf|    |aLeaf|
                                              -----      -----
#4.参与者
    Component
        ————为组合中的对象声明接口
        ————在适当的情况下，实现所有类共有接口的缺省行为
        ————声明一个接口用于访问和管理Component的子组件
        
    Leaf
        ————在组合中表示叶子节点对象
        ————在组合中定义图元对象的行为
    Composite
        ————定义有子部件的那些部件的行为
        ————存储子部件
        ————在Component接口中实现与子部件有关的操作
    Client
        ————通过Component接口操纵组合部件的对象
#5.代码解释
表示部分整体的例子有很多，例如北京市的所有高校，每所高校可以按学院划分在深一层的“部分”结构

Component(Universities.java)
    
    /**
     * Component
     */
    public abstract class Universities {
        private String name;
    
        protected Universities(String name) {
            this.name = name;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        protected abstract void add(Universities universities);
        protected abstract void remove(Universities universities);
        protected abstract void getChild(int depth);
    }

Leaf(ArtiestCollege.java & EngineeringCollege)

    public class ArtiestCollege extends Universities {
        protected ArtiestCollege(String name) {
            super(name);
        }
    
        @Override
        protected void add(Universities universities) {
    
        }
    
        @Override
        protected void remove(Universities universities) {
    
        }
    
        @Override
        protected void getChild(int depth) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < depth; i++) {
                sb.append("-");
            }
            System.out.println(new String(sb) + this.getName());
        }
    }
    
    public class EngineeringCollege extends Universities {
        protected EngineeringCollege(String name) {
            super(name);
        }
    
        @Override
        protected void add(Universities universities) {
    
        }
    
        @Override
        protected void remove(Universities universities) {
    
        }
    
        @Override
        protected void getChild(int depth) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < depth; i++) {
                sb.append("-");
            }
            System.out.println(new String(sb) + this.getName());
        }
    }
     
Composite(ConcreteUniversity.java)

    public class ConcreteUniversity extends Universities {
        private List<Universities> list;
    
        protected ConcreteUniversity(String name) {
            super(name);
            list = new ArrayList<Universities>();
        }
    
        @Override
        protected void add(Universities universities) {
            list.add(universities);
        }
    
        @Override
        protected void remove(Universities universities) {
            list.remove(universities);
        }
    
        @Override
        protected void getChild(int depth) {
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < depth; i++) {
                sb.append("-");
            }
            System.out.println(new String(sb) + this.getName());
            for (Universities c : list) {
                c.getChild(depth + 2);
            }
        }
    }

Client.java
    
    public class Client {
        public static void main(String[] args) {
            Universities root = new ConcreteUniversity("北京高校");
            root.add(new EngineeringCollege("工业学院"));
            root.add(new ArtiestCollege("艺术学院"));
    
            Universities root1 = new ConcreteUniversity("清华大学");
            root1.add(new EngineeringCollege("工业技术学院"));
            root1.add(new ArtiestCollege("艺术综合学院"));
    
            Universities root2 = new ConcreteUniversity("北京师范大学");
            root2.add(new EngineeringCollege("工业科学技术专业学院"));
            root2.add(new ArtiestCollege("艺术信息学院"));
    
            Universities root3 = new ConcreteUniversity("北京大学");
            root3.add(new EngineeringCollege("工学院"));
            root3.add(new ArtiestCollege("艺术音乐学院"));
    
            root.add(root1);
            root.add(root2);
            root.add(root3);
            root.getChild(3);
    
        }
    }

result

    ---北京高校
    -----工业学院
    -----艺术学院
    -----清华大学
    -------工业技术学院
    -------艺术综合学院
    -----北京师范大学
    -------工业科学技术专业学院
    -------艺术信息学院
    -----北京大学
    -------工学院
    -------艺术音乐学院
    
    