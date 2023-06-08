###### SERIALIZATION: LESSON

### Serializable Fields

When serializing objects, we often need to handle static class fields or exclude non-static fields in the serialization. Recall that the JVM defines a default way of serializing objects; this default includes ignoring static class fields, which belong to a class and not an object. The JVM also serializes all fields in an object, even those marked private and final.

Although the JVM implicitly serializes non-static fields, we can instruct the JVM to ignore them using the transient keyword. A field marked as transient will have its value ignored during serialization and instead receive the default value for that type of field.

Let’s visualize this with some code:
```
public class Person implements Serializable {
  private String name;
  private int age;
  private static int numberOfPeople = 10;
  private transient int yearBorn;  
} 
```
In the example above, we defined a static field called numberOfPeople with a value of 10. Since it belongs to the class, it will not be included in the serialization process. We also defined a transient field called yearBorn of type int. The JVM will ignore the initialized value of this field and instead serialize the field with its default value for its type (0 in this case).

Let’s discuss some interesting aspects of deserializing objects with transient and static fields:

- The deserialized (copy) object will not get the default value for a static field (in our example the value 0). Since a static field belongs to the class and not the object, a deserialized static field will receive the value it corresponds to in the current class.
- A constructor is not called during deserialization for the deserialized type object. Object fields are set using reflection.
- A constructor is only called for the first non-serializable class in the parent hierarchy of the deserialized object.

We often want to serialize all non-static fields in an object. However, sometimes we may need to serialize transient fields if a field’s value is dependent on other fields or, more importantly, if we have a reference field that is not serializable (we’ll talk about this later).

Let’s practice using different types of serializable and non-serializable fields.

#### Instructions

1. Let’s practice the serialization process with static and transient fields.

    We’ve included a new String field named model in the Car class and modified the constructor and main() function to incorporate it. Run the program to observe what gets printed when deserializing an object with a non transient and static field.

2. Let’s see what happens when we serialize an object with a transient field.

    Modify the model field and include the transient keyword after private. Observe the terminal output for toyotaCopy and it’s model field.