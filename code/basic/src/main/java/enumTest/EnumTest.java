package enumTest;

public class EnumTest {

    public static void main(String[] args) {
        forEnum();
        useEnumInJava();
        testSwitchCase();
    }

    /**
     * https://zhuanlan.zhihu.com/p/88609380
     * 循环枚举,输出ordinal属性；若枚举有内部属性，则也输出。(说的就是我定义的TYPE类型的枚举的typeName属性)
     */
    private static void forEnum() {
        for (SimpleEnum simpleEnum : SimpleEnum.values()) {
            System.out.println(simpleEnum + "  ordinal  " + simpleEnum.ordinal());
        }
        System.out.println("------------------");
        for (TypeEnum type : TypeEnum.values()) {
            System.out.println("type = " + type + "    type.name = " + type.name() + "   typeName = " + type.getTypeName() + "   ordinal = " + type.ordinal());
        }
    }

    /**
     * 在Java代码使用枚举
     */
    private static void useEnumInJava() {
        String typeName = "f5";
        TypeEnum type = TypeEnum.fromTypeName(typeName);
        if (TypeEnum.BALANCE.equals(type)) {
            System.out.println("根据字符串获得的枚举类型实例跟枚举常量一致");
        } else {
            System.out.println("大师兄代码错误");
        }

    }

    /**
     * 季节枚举(不带参数的枚举常量)这个是最简单的枚举使用实例
     * Ordinal 属性，对应的就是排列顺序，从0开始。
     */
    private enum SimpleEnum {
        SPRING,
        SUMMER,
        AUTUMN,
        WINTER
    }


    /**
     * 常用类型(带参数的枚举常量，这个只是在书上不常见，实际使用还是很多的，看懂这个，使用就不是问题啦。)
     */
    private static enum TypeEnum {
        FIREWALL("firewall"),
        SECRET("secretMac"),
        BALANCE("f5");

        private String typeName;

        TypeEnum(String typeName) {
            this.typeName = typeName;
        }

        /**
         * 根据类型的名称，返回类型的枚举实例。
         *
         * @param typeName 类型名称
         */
        public static TypeEnum fromTypeName(String typeName) {
            for (TypeEnum typeEnum : TypeEnum.values()) {
                if (typeEnum.getTypeName().equals(typeName)) {
                    return typeEnum;
                }
            }
            return null;
        }

        public String getTypeName() {
            return this.typeName;
        }
    }
        private static void testSwitchCase() {

            TypeEnum typeEnum = TypeEnum.fromTypeName("f5");
            if (typeEnum == null) {
                return;
            }
            switch (typeEnum) {
                case BALANCE:
                case SECRET:
                case FIREWALL:
                    System.out.println("枚举名称(即默认自带的属性 name 的值)是：" + typeEnum.name());
                    System.out.println("排序值(默认自带的属性 ordinal 的值)是：" + typeEnum.ordinal());
                    System.out.println("枚举的自定义属性 typeName 的值是：" + typeEnum.getTypeName());
                    break;
                default:
                    System.out.println("default");
            }
        }
}
