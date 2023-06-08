###### SERIALIZATION: LESSON

### Custom Serialization

As we’ve learned about serialization, we’ve discussed how the JVM defines a default way to serialize objects when their classes implement the Serializable interface. Can we modify this default process? We can by implementing the methods readObject() and writeObject() in our class!

Let’s look at some code that implements readObject() and writeObject():
```
public class DateOfBirth {
  private int month;
  private int day;
  private int year;
 
  // constructors and getters
}
 
public class Person implements Serializable {
  private String name;
  private DateOfBirth dateOfBirth;
 
  private void writeObject(java.io.ObjectOutputStream stream) throws IOException{
    stream.writeObject(this.name);
    stream.writeInt(this.dateOfBirth.getMonth());
    stream.writeInt(this.dateOfBirth.getDay());
    stream.writeInt(this.dateOfBirth.getYear());
  }
 
  private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException{
    this.name = (String) stream.readObject();
    int month = (int) stream.readInt();
    int day = (int) stream.readInt();
    int year = (int) stream.readInt();
    this.dateOfBirth = new DateOfBirth(month, day, year);
  }    
}
```
In the example above:

- We have two classes: Person which implements Serializable and DateOfBirth which does not.
- Person has a reference field of type DateOfBirth.
- If we were to use the default serialization process, we would get a NotSeriliazableException because DateOfBirth does not implement Serializable.
- We implement writeObject(), which must throw IOException, to serialize a DateOfBirth object by manually serializing all of its fields separately. We also serialize the serializable String field.
- We implement readObject(), which must throw IOException and ClassNotFoundException, to deserialize a Person object by reading the int fields that are a part of DateOfBirth and creating a new DateOfBirth object with the provided constructor. This new object is used to set the dateOfBirth field in Person.

Often, the default process of serialization is enough as long as all references implement Serializable. The implementation of readObject() and writeObject() is useful when we have a reference field that does not or cannot implement Serializable. We could also potentially handle static field values if we needed to persist them. This, however, is not good practice as a static field should belong to a class and not an object.

Let’s practice implementing our custom serialization and deserialization methods.

#### Instructions

1. The class Car has a non-serializable Engine reference field named engine that cannot be serialized currently. Let’s fix that!

    In the class Car, complete the implementation of writeObject() to serialize the fields (state) of engine using the ObjectOutputStream stream methods. Use the provided public getters to access engine fields.

```
// Engine getter methods (implemented in Engine.java)
public double getLiters();
public int getCylinders();
```

2. We’ve customized the serialization of a non-serializable field in Car. Now, we need to deserialize the Engine fields back into an engine object.

    In the class Car, complete the implementation of readObject() to deserialize all Car fields using the ObjectInputStream stream methods. Create a local double variable named liters and an int variable named cylinders to store the serialized Engine fields. Use the provided Engine constructor to initialize the engine reference field with liters and cylinders.

    Note: The fields must be deserialized in the same order as they were serialized in Checkpoint 1.