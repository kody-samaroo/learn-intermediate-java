###### GENERICS: LESSON

### Classes

Previously, we saw how generics can help make our code more manageable and flexible for future needs. We created the following generic class:
```
public class Box <T> {
  private T data;
 
  public Box(T data) {
    this.data = data; 
  }
 
  public T getData() {
    return this.data;
  }  
}
```
In the example above, notice that:

The type parameter must be specified within the diamond operator (<>) after the class name.
The type parameter, T, is similar to a method parameter but instead receives a class or interface type as an argument as opposed to a reference or primitive type.
The constructor accepts a T-type parameter to initialize data.
The getter method returns the type parameter T when returning data.
Creating generic classes is great, but we also need to be able to create instantiations of them in our programs:
```
Box<String> myStringBox = new Box<>("Apple");
```
In the example above, the object myStringBox is created like a non-generic object, but differs in:

Needing the diamond operator with the class or interface type argument, <String> in this example, after the class name.
Needing the empty diamond operator before calling the constructor new Box<>("Apple").
When defining type parameters, although not being a hard requirement, it’s best practice to make them single, uppercase letters to easily distinguish them from the names of classes or variables. By convention, type parameters are E (Elements), K (Key), N (Number), T (Type), V (Value), and S (or U or V) for multiple type parameters.

One last thing to note is that before Java 7, generic references had to be created like this:
```
Box<String> myStringBox = new Box<String>("Apple");
```
In the example above, the <String> type argument also needed to be specified prior to calling the constructor. This is no longer necessary due to Java’s type inference where the compiler can infer the <String> type argument in the constructor from the context of the reference definition Box<String>.

Let’s practice creating a generic class and creating an instance of it.

#### Instructions

1. Let’s start by defining our generic class that will represent a real world container.

    In Container.java, create a generic class called Container with a type parameter T. Inside container, create a private type T field called data.

    Note: It’s okay to see an error in the terminal window about a missing main() method.

2. Let’s complete our class so we can create references to it.

    In the Container class, add a public constructor with a type T parameter named data. Set the data field to the value of the data parameter. Also, create a getter named getData() and a setter named setData() for the data field.

    Note: It’s okay to see an error in the terminal window about a missing main() method.

3. Let’s create Container references and print it’s data field to the terminal.

    We’ve provided a Book class for you to use with a single String argument constructor. In main() of Main.java, create the following references:

    A String type Container named wordContainer. Use myWord to initialize it.
    A Book type Container named bookContainer. Use myBook to initialize it.
    Call System.out.println() to print wordContainers data field using it’s getter.

    Call System.out.println() to print bookContainers data field using it’s getter.
