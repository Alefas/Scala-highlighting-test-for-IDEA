package highlighting;

import scala.collection.mutable.ListBuffer;
import scala.collection.mutable.ListBuffer$;

public class JavaListBufferExample {
    public static void main(String[] args) {
        ListBuffer<String> buffer = ListBuffer$.MODULE$.<String>empty();
        System.out.println(buffer);
    }
}
