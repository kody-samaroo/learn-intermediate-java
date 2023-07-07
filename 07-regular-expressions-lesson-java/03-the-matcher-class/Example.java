import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Example {
  public Example() {}

  public static void main(String[] args) {
    Pattern pattern = Pattern.compile("nap time", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher("Every morning starts with some nap time!");
    System.out.println(matcher.find());
  }
}