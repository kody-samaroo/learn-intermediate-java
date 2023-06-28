import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
public class Main {
  public static void main(String[] args) {
    List<Integer> intList = new ArrayList<>();
    intList.add(3);
    intList.add(-56);
    intList.add(67);
    System.out.println("intList: "+ intList);
    List<Integer> negatedInts = negateListOfInts(intList);
    System.out.println("Negated Ints: "+ negatedInts);

    Set<String> stringSet = new HashSet<>();
    Map<String, Integer> wordCount = new HashMap<>();

  }

  public static List<Integer> negateListOfInts(List<Integer> ints){
    return ints.stream().map(myInt -> negateInt(myInt)).collect(Collectors.toList());
  }

  public static int negateInt(int a) {
    return a * -1;
  }
}