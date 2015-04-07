Memento(备忘录)————对象行为型模式
----------
#1.意图：
在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可以将该对象恢复到原先保存的状态
#2.别名
Token
#3.使用环境：
    在下列情况下使用备忘录模式：
    ——必须保存一个对象的某一时刻的（部分）状态，这样以后需要时它才能恢复到先前的状态
    ——如果一个用接口来让其它对象直接得到这些状态，将会暴露对象的实现细节并破坏对象的封装性
#4.结构
![github](https://github.com/IceDcap/Gof-DesignPatterns/blob/master/uml/Memento.JPG "Memento")
#5.参与者
    Memento(备忘录)
        ————备忘录存储原发器对象的内部状态。原发器根据需要决定备忘录存储原发器的哪些内部状态。
        ————防止原发器以外的其他对象访问备忘录。备忘录实际上有两个接口,管理者(caretaker)只能看到备忘
            录的窄接口— 它只能将备忘录传递给其他对象。相反,原发器能够看到一个宽接口,允许它访问返回到先
            前状态所需的所有数据。理想的情况是只允许生成本备忘录的那个原发器访问本备忘录的内部状态
    Originator(原发器)
        ————原发器创建一个备忘录，用以记录当前时刻它的内部状态
        ————使用备忘录恢复内部状态
    Caretaker(负责人)
        ————负责保存好备忘录
        ————不能对备忘录的内容进行操作或检查
    

#6.代码描述
以保存游戏进度为例，在游戏角色大战Boss前将该角色的状态存储，与Boss作战后角色的各项能力会下降，如果没有通关，则可利用备忘录进行恢复到战前状态。

Memento.java用于存储玩家数据状态

```Java
    public class Memento {
    
        private int vitality;
        private int aggressivity;
        private int defencivity;
    
        public void setVitality(int vitality) {
            this.vitality = vitality;
        }
    
        public void setAggressivity(int aggressivity) {
            this.aggressivity = aggressivity;
        }
    
        public void setDefencivity(int defencivity) {
            this.defencivity = defencivity;
        }
    
        public int getVitality() {
            return vitality;
        }
    
        public int getAggressivity() {
            return aggressivity;
        }
    
        public int getDefencivity() {
            return defencivity;
        }
    }
```

PlayerOriginator.java用于创建和恢复备忘录

```Java
    public class PlayerOriginator {
        private int vitality;
        private int aggressivity;
        private int defencivity;
    
        public PlayerOriginator(int vitality, int aggressivity, int defencivity) {
            this.vitality = vitality;
            this.aggressivity = aggressivity;
            this.defencivity = defencivity;
        }
    
        public void setVitality(int vitality) {
            this.vitality = vitality;
        }
    
        public void setAggressivity(int aggressivity) {
            this.aggressivity = aggressivity;
        }
    
        public void setDefencivity(int defencivity) {
            this.defencivity = defencivity;
        }
    
        public int getVitality() {
            return vitality;
        }
    
        public int getAggressivity() {
            return aggressivity;
        }
    
        public int getDefencivity() {
            return defencivity;
        }
    
        public Memento createMemento() {
            final Memento memento = new Memento();
            memento.setVitality(vitality);
            memento.setAggressivity(aggressivity);
            memento.setDefencivity(defencivity);
            return memento;
        }
    
        public void setMemento(final Memento memento) {
            this.vitality = memento.getVitality();
            this.aggressivity = memento.getAggressivity();
            this.defencivity = memento.getDefencivity();
        }
    
        public void showState() {
            System.out.println("vitality: " + vitality);
            System.out.println("aggressivity: " + aggressivity);
            System.out.println("defencivity: " + defencivity);
        }
    }
```

CareTaker.java用于保存备忘录中数据的状态，当恢复到保存状态时则需要该对象取得

```Java
    public class CareTaker {
        private Memento memento;
    
        public Memento getMemento() {
            return memento;
        }
    
        public void setMemento(Memento memento) {
            this.memento = memento;
        }
    
    }
```

result

    player's original data is 
    vitality: 100
    aggressivity: 100
    defencivity: 100
    After battled with Boss, player's data is 
    vitality: 70
    aggressivity: 60
    defencivity: 10
    reset data, player's data is 
    vitality: 100
    aggressivity: 100
    defencivity: 100

#7.效果
1).保存封装边界

2).简化原发器

3).使用备忘录可能代价很高

4).定义窄接口和宽接口

5).维护备忘录的潜在代价


