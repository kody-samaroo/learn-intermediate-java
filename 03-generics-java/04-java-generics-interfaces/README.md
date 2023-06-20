###### GENERICS: LESSON

### Interfaces

We’ve seen how to create a generic class, but we can also create a generic interface. Let’s look at an example:
```
public interface Replacer<T> {
  void replace(T data);
}
```
The generic interface Replacer is created like a generic class where the type parameter <T> must be appended to the interface name. Interface method declarations are similar to non-generic interfaces and can include non-generic methods as well.

A generic interface can be implemented by a generic class and its generic type parameter can be used as the argument to the interface type parameter. For example, let’s have our Box generic class implement the interface Replacer:
```
public class Box <T> implements Replacer<T> {
  private T data;
 
  @Override
  void replace(T data) {
    this.data = data; 
  }
}
```
In the example above, the Box type parameter <T> will be used as the type argument for the Replacer type parameter <T>.

We can also have a non-generic class implement a generic interface by specifying the type argument to the interface. For example:
```
public class StringBag implements Replacer<String> {
  private String data;
 
  @Override
  void replace(String data) {
    this.data = data; 
  }
}
```
In the example above, the StringBag is a non-generic class that implements Replacer and provides String as the argument to the type parameter. Notice that the replace() parameter data has a String type as opposed to the generic T in the previous example.

Now let’s create interface type references similarly to how we created generic class references:
```
Replacer<Integer> boxReplacer = new Box<>();  // Using generic `Box` implementation
Replacer<String> bagReplacer = new StringBag();  // Using non-generic `StringBag` implementation
```
In the example above we created two Replacer references. The Box implementation can be of any type but the StringBag implementation needs to be a <String> type because of the non-generic class implementation.

Let’s practice creating generic interfaces and references.

#### Instructions

1. Let’s start by defining our generic interface and an abstract method to be implemented.

    In Retriever.java, create a generic interface named Retriever with a T type parameter. Define the method signature for a method named retrieveData() with no parameters and a T return type.

    Note: It’s okay to see an error in the terminal window about a missing main() method.

2. Let’s implement the Retriever interface in a non-generic class.

    In Book.java, implement the Retriever interface in Book and override retrieveData(). The body of retrieveData() should return the name field in Book. In this case, Book is a Retriever of Strings.

    Note: It’s okay to see an error in the terminal window about a missing main() method.

3. Let’s implement the Retriever interface in a generic class.

    In Container.java, implement the Retriever interface in Container and override retrieveData(). The body of retrieveData() should return the data field in Container.

    Note: It’s okay to see an error in the terminal window about a missing main() method.

4. Let’s create some references to our generic interfaces and output some data to the terminal.

    In Main.java, under variables we’ve defined for you (myNumber & bookName), create two Retriever references:

    An Integer type Container implementation named containerRetriever. Initialize it with myNumber.
    Book implementation named bookRetriever. Initialize it with bookName.
    Call System.out.println() to print the result of retrieveData() from containerRetriever.

    Call System.out.println() to print the result of retrieveData() from bookRetriever.