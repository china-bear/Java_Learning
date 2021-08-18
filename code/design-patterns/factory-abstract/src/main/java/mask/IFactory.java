package mask;

/**
 * 工厂抽象模式
 */
public interface IFactory {
  //创建口罩
  IMask createMask();
  //创建防护服
  IProtectiveSuit createSuit();
}
