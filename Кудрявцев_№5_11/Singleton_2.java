public class Singleton_2 {
  private static Singleton_2 INSTANCE;

  private Singleton_2() {}

  public static Singleton_2 getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Singleton_2();
    }
    return INSTANCE;
  }
}