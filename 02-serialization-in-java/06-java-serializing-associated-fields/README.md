###### SERIALIZATION: LESSON

### Serializing Associated Fields

As we’ve been serializing objects, we’ve not only had primitive type fields, but also reference types. For example:
```
public class Person implements Serializable {
  private String name;
  private int age;
  private static final long serialVersionUID = 1L; 
```
In the example above, we’ve defined two primitive types, age and serialVersionUID, and a reference String type name. For reference types to be serializable, they must also implement the Serializable interface, which the String class does. If the reference type did not implement Serializable, then we would get a NotSerializableException thrown. When the JVM encounters a reference type, it will try to serialize the reference type first before trying to serialize the encapsulating object.

Let’s look at class definitions and go through the steps of serializing a Person object:
```
public class Address implements Serializable{
  private String streetName;
}
 
public class Person implements Serializable{
  private Address address;
}
```
In the example above, when serializing a Person object the JVM will:

- Check that the Person object is serializable and try to serialize the Address type.
- Check that the Address object is serializable and try to serialize the String type.
- Check that the String object is serializable and serialize the value.
- Finish serializing the Address object after serializing streetName.
- Finish serializing the Person object after serializing address.

Our serializable classes will often have a combination of reference and primitives types, but the JVM will perform the same steps as above. If an exception were to be thrown at any point while serializing a reference type, a NotSerializableException would be thrown and propagated up.

Let’s practice serializing objects with reference-type fields.

#### Instructions

1. Let’s add a custom reference type field to the class Car to see how the serialization process handles it.

    We’ve provided a class named Engine with the following fields:
```
public class Engine implements Serializable{
  private double liters;
  private int cylinders;
```

Add a private Engine type field named engine to the class Car to fix the errors in the code. Observe the terminal output to see how serialization works with a custom reference type.