package enumTest;

public interface interfaceEnumTest {

    void showSeasonBeauty();

    String getSeasonName();
}

// 使用接口组织枚举
interface Foods {
    enum Coffee implements Foods{
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
    }
    enum Dessert implements Foods{
        FRUIT, CAKE, GELATO
    }
}
    // 枚举类都继承于java.lang.Enum,所以枚举不能再继承其他类了。但是枚举可以实现接口
    enum SeasonEnum implements interfaceEnumTest {
        SPRING(1,"春天"),SUMMER(2,"夏天"),FALL(3,"秋天"),WINTER(4,"冬天"),
        ;

        private int index;
        private String name;

        SeasonEnum(int index, String name) {
            this.index = index;
            this.name = name;
        }

        public int getIndex() {
            return index;
        }
        public String getName() {
            return name;
        }

        //接口方法
        @Override
        public void showSeasonBeauty() {
            System.out.println("welcome to " + this.name);
        }

        //接口方法
        @Override
        public String getSeasonName() {
            return this.name;
        }
}

