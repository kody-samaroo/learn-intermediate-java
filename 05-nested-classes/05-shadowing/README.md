###### NESTED CLASSES: LESSON

#### Shadowing

Now let’s take a look at the concept of shadowing in Java. Shadowing allows for overlapping scopes of members with the same name and type to exist in both a nested class and the enclosing class simultaneously. The value of the variable will depend on which object we use to call it.

Take a look at the example below:
```
class Outer {
  String name = "Outer";
 
  // Nested inner class
  class Inner {
    String name = "Inner";
 
    public void printTypeMethod() {
      System.out.println(name);
      System.out.println(Outer.this.name);
    }
  }
}
 
class Main {
  // Main driver method
  public static void main(String[] args) {
    Outer outerObj = new Outer();
    Outer.Inner innerObj  = outerObj.new Inner();
    innerObj.printTypeMethod();
  }
}
```
The code above will output the following:

>Inner
Outer
>

If we take a closer look at the method printTypeMethod(), the keyword this is used in the second print statement. Using the keyword this along with the class name Outer, allows us to overlap the variable name with the contents of the outer class.

#### Instructions

1. For this exercise, we will be practicing the use of shadowing by modifying a program about books. To start off, the outer class Book and inner class Biography have been created for you.

    Create a String variable in both classes named type.
    In the class Book, set the variable type to “Nonfiction”.
    In the class Biography, set the variable type to “Biography”.

2. In the inner class Biography create a method called print() that will use two System.out.println() statements.

    For the first println() statement use the variable type f.
    For the second println() statement use the variable type to print “Biography”.