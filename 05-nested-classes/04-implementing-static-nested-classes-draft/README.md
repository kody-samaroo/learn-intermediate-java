###### NESTED CLASSES: LESSON

### Implementing Static Nested Classes

In this exercise, we will explore the concept of static nested classes. A static nested class is a class that belongs to its enclosing class in the same way that a static variable belongs to its enclosing class. Static nested classes are helpful because they allow related classes to be grouped under an enclosing class. To illustrate this concept, we will use a toolbox as an example. A toolbox contains many tools that a person can use such as a hammer, a tape measure, a wrench, and others. We can implement the concept of a toolbox in Java using static nested classes like so:
```
class Toolbox{  
  public static String toolboxName = "Awesome Toolbox";
  public String ownerName;
 
  static class Saw{
    public void cut(){
      System.out.println("Cutting...");
    }
  }
 
  static class TapeMeasure{
    public void measure(){
      System.out.println("Measuring...");
    }
  }
 
  static class Wrench{
    public void tighten(){
      System.out.println("Tightening...");
    }
 
    public void loosen(){
      System.out.println("Loosening...");
    }
  }
}
```
We can use the “toolbox” like so:
```
public class Main{
  public static void main(String[] args) {
    Toolbox.Saw petersSaw = new Toolbox.Saw();
    Toolbox.MeasuringTape amysMeasuringTape = new Toolbox.MeasuringTape();
    Toolbox.Wrench randomWrench = new Toolbox.Wrench();
 
    petersSaw.cut(); // output: Cutting...
    amysMeasuringTape.measure(); // output: Measuring...
    randomWrench.tighten(); // output: Tightening...
}
```
Static nested classes can access static variables of the enclosing class, but cannot access non-static variables because non-static variables belong to an instance of the class and not the class itself. Modifying Saw in Toolbox like so is okay:
```
static class Saw{
  public void cut(){
    System.out.println("Cutting...");
  }
  public void printName(){
    System.out.println(toolboxName); // When called, this will print "Awsome Toolbox"
  }
}
```
Modifying Saw like this will cause a compiler error:
```
static class Saw{
  public void cut(){
    System.out.println("Cutting...");
  }
  public void printName(){
    System.out.println(ownerName); // This will not compile!
  }
}
```
Let’s practice creating and using nested classes.

#### Instructions

1. In this series of checkpoints, you will implement the concept of a vending machine that has two kinds of treats. We have already created the VendingMachine class for you. You will fill it out as you go along.

    Your first task is to create the following two static classes:

    ChocolateBar to represent a chocolate bar.
    BagOfChips to represent a bag of chips.

2. In each of the static classes, create the following two methods:

    >getName() which returns a String representing the brand name of the item.
    getPrice() which returns a double representing the price of the item.
    >
    You are free to set the brand name and price of the items to whatever you like.

3. In the main() method, create the following:

    An instance of ChocolateBar called mikesChocolateBar.
    An instance of BagOfChips called gabbysBagOfChips.
point 4 Passed

4. Print the name of the snacks as well as the price in the following format:

>"Mike's <snack_name> chocolate bar costs <snack_price>"
"Gabby's <snack_name> bag of chips costs <snack_price>"