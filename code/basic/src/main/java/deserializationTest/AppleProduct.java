package deserializationTest;

import java.io.Serializable;

public class AppleProduct implements Serializable {

    private static final long serialVersionUID = 1234567L; // 强烈建议所有要序列化的类都显示地声明serialVersionUID字段

    public String headphonePort;
    public String thunderboltPort;
    public String lightningPort;

    public String getHeadphonePort() {
        return headphonePort;
    }

    public String getThunderboltPort() {
        return thunderboltPort;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLightningPort() {
        return lightningPort;
    }

}