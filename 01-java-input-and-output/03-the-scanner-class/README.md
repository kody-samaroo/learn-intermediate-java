###### INPUT AND OUTPUT: LESSON

### The Scanner Class

Just like System, the Scanner class is predefined and built into Java for your use. It’s used to read user input in a Java program. When we declare a scanner we need to tell it what type of input we are going to be scanning, this gets passed into the constructor we initialize it.

For this exercise, we will build a program that walks us through writing code that uses the Scanner class together with the input from the console, which we get from System.in. The Scanner class comes with Java in the package java.util, therefore before we can use the Scanner class in our own code we must import it from that package, which you can do using the following:

> import java.util.Scanner;

Note: Everything that is contained in the java.lang package is automatically imported into every Java program. Every Java SDK installation comes with everything in the java.base module, a collection of resources that make Java what it is. The other packages contained in java.base such as java.util and java.io provide helper functionality that isn’t necessary to every program, but is used in special circumstances, such as when we need a Scanner. We access these extra classes by importing them into out program, this tells the compiler to go to those packages and make sure the resource is available for use when we build our programs. You may ask why we don’t include everything into all Java programs? If we did that, our programs would be huge when we compiled them, including many many files we will never use. Importing specific classes from these packages keeps our software lean and efficient.

Now that we have access to the Scanner class, let’s begin by declaring the Scanner class as an instance variable that we will call input:

> Scanner input = new Scanner(System.in);

Notice how we have placed System.in within the brackets in our declaration. This is what will allow our program to read user input from the console. Similar to how the out property of System was a PrintStream, the in property is an instance of an InputStream, read more about it here.

The Scanner class can also read input from a file; we will cover that in a later exercise.

#### Instructions

1. Import the Scanner class at the top of your program, outside of the class declaration.

2. Now declare and instantiate a new Scanner object using System.in in the constructor.