import java.io.FileWriter;
import java.io.IOException;

public class Introduction {
  public static void main(String[] args) throws IOException  {
    // Your code here:
    FileWriter output = new FileWriter("output.txt");
    String outputText = "Hello World!";
    output.write(outputText);
    output.close();
  }
}