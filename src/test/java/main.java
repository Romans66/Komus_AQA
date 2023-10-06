
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class main {
  final static Logger logger = LoggerFactory.getLogger(main.class);
  public static void main(String args[]) {
    SomeMethod someMethod = new SomeMethod();
    someMethod.someMethod();
  }

  public static class SomeMethod {
    public void someMethod() {
      logger.info("Это сообщение с уровнем INFO");
    }
  }
}
