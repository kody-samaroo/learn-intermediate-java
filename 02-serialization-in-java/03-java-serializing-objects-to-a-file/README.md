###### SERIALIZATION: LESSON

### Serializing Objects to a File

Now that we’ve learned about the Serializable interface and how to implement it, let’s take a look at how to serialize an object to a file. To do this we’ll need to use the helper classes, FileOutputStream, which will help us write to a file, and ObjectOutputStream, which will help us write a serializable object to an output stream.

Let’s look at how to do this with some code:
```
public class Person implements Serializable {
  private String name;
  private int age;
  private static final long serialVersionUID = 1L; 
 
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }  
 
  public static void main(String[] args) throws FileNotFoundException, IOException{
    Person michael = new Person("Michael", 26);
    Person peter = new Person("Peter", 37);
 
    FileOutputStream fileOutputStream = new FileOutputStream("persons.txt");
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
 
    objectOutputStream.writeObject(michael);
    objectOutputStream.writeObject(peter);    
  }
}
```
In the example above we:

Added a constructor to the Person class we defined in the previous lesson.
Defined main() and initialized two Person objects - michael and peter.
Initialized a FileOutputStream object in main() which will create and write a stream of bytes to a file named persons.txt.
Initialized an ObjectOutputStream object in main() which will help serialize an object to a specified output stream.
Used objectOutputStream.writeObject() in main() to serialize the michael and peter objects to a file.
After the execution of the above program, the persons.txt will contain a stream of bytes that has the type and value information of the fields for the michael and peter objects respectively.

Let’s practice serializing an object to a file.

#### Instructions

1. In the main() method, let’s create all the Car objects we need to serialize an object to a file.

Create:

- A Car object named toyota that represents a 2021 Toyota.
- A Car object named honda that represents a 2020 Honda.

2. Now, let’s continue in the main() method by creating the Stream objects that we will need.

Create:

- A FileOutputStream object (this class has been imported for you) named fileOutputStream, passing the String "cars.txt" as an argument. This will be the name of the file created.
- A ObjectOutputStream object (this class has been imported for you) named objectOutputStream, passing fileOutputStream to its constructor.

3. Now that we have all our helper objects, let’s serialize the Car objects and write them to the cars.txt file.

    In the main() function, after all the object declarations we did previously, serialize the Car objects toyota and honda using the writeObject() method of objectOutputStream.

    We should see the file cars.txt appear in the file navigator. If we open the file, we see strange text written to it. This strange text is our serialized objects!