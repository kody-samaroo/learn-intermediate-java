public class Main {
    public static void main(String[] args) {
      Container raw1 = new Container<>("My String");  // raw type box
  
          String s1 = (String) raw1.getData();  // no incompatible type error
      System.out.println("s1 is: "+ s1);
  
  /* Uncomment to see error
      String s2 = raw.getData();  // incompatible type error
  */
  
      Container<String> stringContainer = new Container<>("Not raw");
      Container raw2 = stringContainer;
      
      raw2.setData("new string");// Unchecked warning produced
    }
  }