###### NESTED CLASSES: LESSON

### Implementing Non-Static Nested Classes

Now that we’ve reviewed the main differences between non-static nested and static nested classes, let’s break down how to implement the use of a non-static nested class. For more clarity, from here on, we may refer to the non-static nested class as the inner class and the class that it is encapsulated within as the outer class.

To declare a non-static nested class within an outer class, you may use the following code:
```
class Outer {
  String outer;
  // Assign values using constructor
  public Outer(String name) {
    this.outer = name;
  }
 
  // private method
  private String getName() {
    return this.outer;
  }
 
  // Non-static nested class
  class Inner {
    String inner;
    String outer;
  }
}
```
Notice how the Inner class does not have the keyword static preceding it. It is also important that we review what the keyword this means in Java code. this is a keyword that a class uses to reference itself.

To instantiate a non-static nested class that can access other members of the outer class, first, we need to instantiate an object of the outer class:
```
Outer outer = new Outer();
```
Next, we can instantiate an inner class object:
```
Outer.Inner inner = outer.new Inner();
```
Note that we use the outer object along with the keyword new to create an instance of the inner class.

This step shows us an example of how a non-static class can access other static and non-static classes from the outer class. In the code below, take a look at a modified version of the Inner class from our previous example:
```
// Non-static nested class
class Inner {
  String inner;
  String outer; 
  public String getOuter() {
  // Instantiate outer class to use its method
  outer = Outer.this.getName();
}
```

#### Instructions

1. Now let’s practice what we have learned! For this exercise, the outer class Lib and an inner class Book have already been created for you. The constructors and methods within the classes have been created for you as well. Notice how the method setDescription() within the class Book calls objType and getObjName() from the outer class.

    In the main() method, create an instance of Lib called fiction. Pass in the following parameters to the constructor: “book” and “fiction”.

2. In the main() method, create an instance of Book.

3. Use setDescription(), System.out.println(), and getDescription() to print the description for a fiction book.

    Your output should look like the following:

    Fiction Book Description = Literature that is imaginary.

4. Repeat checkpoints 1-3 for a non-fiction book. Your Lib object should be named nonFiction.

    Note: In the constructor for the non-fiction book, use “nonfiction” for the name parameter.

    Your output should look like the following:

    Fiction Book Description = Literature that is imaginary.
    Non-fiction Book Description = Factual stories/accounts based on true events.