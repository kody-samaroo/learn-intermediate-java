###### INPUT AND OUTPUT: LESSON

### IOExceptions

Errors are unwanted issues that occur in a program that cannot be handled by a program. They may even result in a program crashing. Exceptions are issues that may occur when a program is running that can be foreseen, or caught by the program. For example, if a user passes an incorrect file path in the arguments of a Java program.

There are two types of exceptions: checked and unchecked. Checked exceptions are exceptions that are thrown when a program is compiling and unchecked exceptions typically occur during runtime. A developer can check if a block of code is going to throw an exception by using a try-catch block, essentially trying some code out to see if an exception occurs or not, and then catching the exception and running a separate block of code in those situations. This allows us to prevent the Exception (unless we want it to) from being thrown out of our main method and crashing the program.

IOExceptions are exceptions that are related to input and/or output in a program and are classified as checked exceptions.

Some examples of when IOExceptions occur include:

- Failed attempts at trying to access a file.
- The end of a file has been reached.
- The file a program is attempting to access cannot be found.
- An input/output operation has been interrupted.

We can code our program to handle IOExceptions in areas of our code where we are dealing with input and output. To start off we must first import the IOExceptions class into our program using import java.io.IOException.

Have a look at the block of code below to see how we have modified one of the examples from the previous exercises to use catch IOExceptions. When we catch exceptions in this manner, we no longer have to declare that our method throws the exception, since we’ve handled it at this level. There are many ways we may choose to handle an exception. We may choose to print an error using System.out.println() or run a new instance of the program.
```
String statement = "Hello World!";
 
try {
  FileWriter output = new FileWriter("output.txt");
  output.write(statementBytes);
  output.close();
} catch (IOException e) {
  // Handle exception
  System.out.println("There has been an IO exception");
  System.out.println(e); // Prints the actual exception
}
```

#### Instructions

1. Take a look at our program on the right that implements a try-catch block:

    You will notice in the method signature we have removed the throws IOException clause since it is caught in the try block.
    Moving inside the main method you will see we have deliberately created a file path that is incorrect in order to get the compiler to throw an IOException.
    Inside the try block we try to read the data that is contained in the file with the bad path, resulting in the Exception being thrown.
    The catch block catches the exception and prints back out to the user what has happened… it doesn’t crash the program.
    Go ahead and run the file to see that it compiles properly and then catches the deliberate error.