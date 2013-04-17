package scl5562;

import scala.Option;

public class JavaSide {
    public static void main(String[] args) {
      errors();
    }

    public static void errors() {
        String thing = "test";
        take(Option.apply(thing));
    }

    private static void take(Option<String> opt) {
    }
}
