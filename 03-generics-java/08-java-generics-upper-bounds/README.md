###### GENERICS: LESSON

### Upper Bounds

We’ve seen how generics make our code scalable by allowing us to provide type arguments to classes, interfaces, and methods. What if we needed to restrict what class or interface could be used as a type argument? We can accomplish this by assigning an upper bound. An upper bound will restrict a generic type to be a specific type or any type that extends it. Let’s see how this is done:
```
public class Box <T extends Number> {
  private T data; 
}
```
In the example above, we defined a type parameter T and added an upper bound type Number for T with extends Number. The extends in this example means that T can be a Number or any of its subclasses (or interfaces).

We can create references to Box as follows:

```
Box<Integer> intBox = new Box<>(2);  // Valid type argument
Box<Double> doubleBox = new Box<>(2.5);  // Valid type argument
Box<String> stringBox = new Box<>("hello");  // Error
```
In the example above we:

Created two Box references with type arguments Integer and Double, which are both child classes of Number.
Attempted to create a Box reference with type argument String and received an error because String is not a Number nor is it a subclass of Number.
We can also add upper bounds to generic methods as follows:
```
public static <T extends Number> boolean isZero(T data) {
  return data.equals(0);
}
```
In the example above, it’s important to note that we added the Number upper bound before the return type.

Java also allows us to create a type parameter with multiple bounds. Let’s look at an example:
```
public class Box <T extends Number & Comparable<T>> {
  private T data; 
}
```
In the example above, we specified multiple bounds (Number and Comparable) for type parameter T using the & operator between the different upper bounds. It’s important to note that when defining multiple bounds, any upper bound that is a class (in our example Number) must come first followed by any interfaces (in our example Comparable<T>).

Let’s practice adding an upper bound to a generic class.

#### Instructions

1. Currently, our Bus class can have any type of generic parameter. We would like to restrict this type of parameter to better meet our needs.

    In Bus.java, modify the type parameter so that we can only create Buses of SchoolPerson, Student, or Teacher.

    Note: Both Student and Teacher are subclasses of SchoolPerson. Feel free to look at SchoolPerson.java, Student.java, and Teacher.java to see how they relate to each other.