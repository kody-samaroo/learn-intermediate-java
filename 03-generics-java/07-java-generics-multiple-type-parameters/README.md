###### GENERICS: LESSON

### Multiple Type Parameters
As of now, our generic classes, interfaces, and methods have all taken a single parameter type. But what if our program needed to specify two or more parameter types? Java generics allow us to do that as well. Let’s look at an example:
```
public class Box<T, S> {
  private T item1;
  private S item2;
  // Constructors, getters, and setters
}
Box<String, Integer> wordAndIntegerBox = new Box<>("Hello", 5);
```
In the example above, we created a generic class Box with two type parameters, T and S, by providing a comma-separated list of type parameters in the diamond operator. We also instantiated a Box reference named wordAndIntegerBox by providing the necessary type arguments in a comma-separated list: <String, Integer>.

This can also be done for interfaces and methods. Let’s look at an example for a method:
```
public class Util {
  public static <T, S> boolean areNumbers(T item1, S item2) {
    return item1 instanceof Number && item2 instanceof Number; 
  }
}
```
boolean areNums = Util.areNumbers("Hello", 34);  // false
In the example above, we created a static areNumbers() method that has two generic type parameters: T and S. Note that a comma-separated list of type parameters, <T, S>, must be specified in the method signature before the return type. A cool thing about the example is if it weren’t for Java’s type inferences, the above method would have to be called like this:
```
Boolean areNums = Util.<String, Integer>areNumbers("Hello", 34);  // false
```
In the example above, we explicitly specified the type arguments <String, Integer> before the method name. Type inferences will infer these types from the arguments passed in, "Hello" and 34, making the explicit arguments unnecessary.

Let’s practice creating a multiple-type parameter class.

#### Instructions

1. Currently, Main.java won’t compile because Container only has a single type parameter T. Let’s fix the errors!

    In Container.java, add a second type parameter, S, to the Container class.

    Note: It’s okay to see an error stating main() is missing in Container.

2. Since Container has multiple type parameters, we need a field and constructor to create references to Container.

    In the class Container, define a private field named item2 of type S. Also, modify the constructor to include a second parameter of type S named item2. Initialize the field item2 with the parameter item2.

    Note: It’s okay to see an error stating main() is missing in Container.

3. Let’s finalize Container by creating a getter for the new item2 field.

    In the class Container, define a method named getItem2() with a return type of S that returns the field item2.

    Note: It’s okay to see an error stating main() is missing in Container.

4. Great Job amending Container to meet our new needs.

    Let’s run main() in Main.java.