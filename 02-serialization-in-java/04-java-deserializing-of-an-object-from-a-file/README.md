###### SERIALIZATION: LESSON

### Deserializing an Object to a File

Knowing how to serialize our objects is great, but it becomes more useful when we can turn serialized objects back into Java objects with deserialization. As the name suggests, deserialization does the opposite of serialization and transforms a stream of bytes into a Java object.

Like with serialization, we’ll make use of helper classes FileInputStream, which helps us read a file, and ObjectInputStream which helps us read a serialized stream of bytes.

Assuming we have the file persons.txt we created in the last exercise, let’s understand how to do this by looking at some code:
```
public class Person implements Serializable {
  public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
 
    FileInputStream fileInputStream = new FileInputStream("persons.txt");
    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
 
    Person michaelCopy = (Person) objectInputStream.readObject();
    Person peterCopy = (Person) objectInputStream.readObject();
  }
}
```
In the example above we:

- Initialized FileInputStream and ObjectInputStream in main() which will read a file and transform a stream of bytes into a Java object.
- Created a Person object named michaelCopy by using objectInputStream.readObject() to read a serialized object.
- Created a Person object named peterCopy by using objectInputStream.readObject() to read a serialized object.

It’s important to note that deserialization creates a copy of the original object. This means that the deserialized object shares the same field values as the original object but is located in a different place in memory. Also, The deserialized objects will be in the order that they were serialized in and we need to explicitly typecast the readObject() return value back into the type of object we serialized.

The JVM ensures it deserializes the object using the correct class file by comparing the serialVersionUID in the class file with the one in the serialized object. If a match is not found an InvalidClassException is thrown. Also, readObject() throws a ClassNotFoundException when the class of the serialized object cannot be found.

Let’s practice deserializing objects from a file.

#### Instructions
1. Let’s begin by creating the helper objects we will use to deserialize an object from a file.

    At the bottom of main(), create:

- A FileInputStream object named fileInputStream and pass "cars.txt" as an argument to its constructor.
- A ObjectInputStream object named objectInputStream and pass fileInputStream as an argument to its constructor.

2. Using the helper objects defined previously, let’s convert a serialized stream of bytes back into a Java object (also known as deserialization).

    In main(), below the helper input objects, call readObject() from objectInputStream and store the return value of the first call in a Car type named toyotaCopy and the second call in hondaCopy.

3. Let’s compare the original serialized objects with the deserialized objects to ensure that they have the same field values but are different objects.

    Create a boolean type named isSameObject and set the value to be the reference comparison of toyotaCopy and toyota. Then, using System.out.println(), output toyotaCopy, toyota, and isSameObject to the terminal.

    Note that we’ve provided a toString() implementation in the Car class that returns the String "Car make is: <this.make>, Car year is: <this.year>"

    An example terminal output would look like:
```
Toyota (Copy) - Car make is: Toyota, Car year is: 2021
Toyota (Original) - Car make is: Toyota, Car year is: 2021
Is same object: false
```