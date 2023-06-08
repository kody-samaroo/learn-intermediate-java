###### INPUT AND OUTPUT: LESSON

### Review: Printing with System.out

By now, you should be very familiar with how to print information to the console using System.out.print(), System.out.println(), and System.out.printf(), but have you ever asked yourself how or why these statements actually work? Let’s take a look!

- System is a class in the lang package that part of every Java install. It contains several properties and methods to interface with various high-level aspects of the computer environment.
- out is an instance of a PrintStream, included as part of the System class, that is already open and provides output to the user’s default console or display.

The PrintStream instance of out is a robust class, let’s take a look at some of the functions that out provides through the examples provided below.

System.out.print() prints into the same line when a program is running. The example below shows us how two System.out.print() statements called in the main method, print in the same line.
```
System.out.print("Hello ");
System.out.print("World!");
```

This code would show the following output in your program:
```
Hello World!
```
You may also choose to concatenate the string you wish to print with other strings or variables. To concatenate simply means to join multiple strings together, and in Java, we use the + symbol to achieve this:
```
String world = "World";
int day = 1;
System.out.print("Hello " + world + "! Today is Day: " + day + " of your Intermediate Java course!");
```
This code would show the following output in your program:
```
Hello World! Today is Day: 1 of your Intermediate Java course!
System.out.println() prints output to a new line:
```
```
System.out.println("Hello");
System.out.println("World!");
```
This code would show the following output in your program:
```
Hello
World!
```
Concatenation using System.out.println() works similar to System.out.print(), using the ‘+’ symbol to combine strings.

System.out.printf() allows us to output strings that are formatted in the code using format specifiers. Format specifiers begin with the ‘%’ sign, followed by the type of variable we want to print. Some examples include %s for a string,%c for a character, and %d for an integer.

Let’s look at a modified version of the Java program that uses System.out.printf(). Notice that variables in our print statement are stated in the order that the format specifiers appear.
```
String world = "World";
int day = 1;
System.out.printf("Hello %s! Today is Day: %d of your Intermediate Java course!", world, day); 
```
This code would show the following output in your program:

Hello World! Today is Day: 1 of your Intermediate Java course!
Java also allows special characters to be included into our print statements to help with formatting, one such character is the new line indicator, \n. We can insert this anywhere into our strings to break the string and start processing on the next line.
```
System.out.print("Name: Will\nAge:35\nBirthplace: Cincinnati");
 
// Prints:
Name: Will
Age: 35
Birthplace: Cincinnati
```

#### Instructions

1. Before we can print our variables, we need variables to print! In the code editor declare the following variables:

- a String name that’s set to your name
- a String hobbies that contains a list of your hobbies
- an int age that contains your age

2. Use System.out.println() to print your name in the following format:
```
My name is ___
```

3. Use System.out.printf() to print your age in the following format:
```
"I am __ years old"
```

4. Use System.out.print() to print your hobbies using the following format:
```
My hobbies are ______
```

5. Hmm… Notice anything strange about the output? It looks like we need to add a new line character in order to get our text to format properly for the user.

    Go back to your .printf() statement and add \n to the end of the string.