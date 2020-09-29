package Annotations;

/**
 * 爱的故事
 *
 * Created by bear on 2020/9/8
 */

@BookAnnotation(bookName = "泡沫之夏",
        heroine = "尹夏沫",
        briefOfBook = "淡漠安静的性格使得欧辰与洛熙为她神魂颠倒。她是冷漠与激情混合体，"
        + "只是在经过种种遭遇，饱尝了人间冷暖后。她用冷漠的外衣将自己包裹住，不愿"
        + "让人看见自己真实的性格，最后与欧辰携手走进婚姻的殿堂。",
        sales = 1000000)
public class LoveStoryBook {

    @AuthorAnnotation(name = "明晓溪", age = 28, gender = "女")
    private String user;
    @BookAnnotation(bookName = "微微一笑很倾城",
            heroine = "顾漫",
            briefOfBook = "《微微一笑很倾城》一书中出现的游戏叫梦游江湖，女主角PK榜上排名第六的芦"
                    + "苇微微是一身劲装背着大刀的红衣女侠，男主角第一高手一笑奈何则是一身白衣纤尘不"
                    + "染衣袂飘飘潇洒出尘的琴师。两人在经典地点长安城朱雀桥相遇并举行婚礼。书中游戏"
                    + "既有一般游戏常见的跑环、摆摊，也有现阶段游戏不存在的宝宝结婚、抢亲等功能。",
            sales = 800000)
    public void getBookInfo(){
    }
}
