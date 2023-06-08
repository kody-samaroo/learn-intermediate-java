import java.io.FileReader;
import java.io.IOException;

public class Introduction {
  public static void main(String[] args) {
    String path = "/a/bad/file/path/to/thisFile.txt";
    try {
      FileReader reader = new FileReader(path);  
      while (reader.ready()) {    
        System.out.print((char) reader.read());    
      }    
      reader.close();
    } catch (IOException e) {
      System.out.println("There has been an IO exception!");
      System.out.println(e);
    }
  }
}