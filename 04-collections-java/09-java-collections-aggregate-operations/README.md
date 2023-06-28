###### COLLECTIONS: LESSON

### Aggregate Operations

As we’ve worked with different types of Collections and Maps, we’ve seen how important and verbose for-loops can get. For example, this code will produce a new Integer List where even numbers are doubled:
```
// Given `intList` with the following elements: 5, 4, 1, 3, 7, 8
List<Integer> evenList = new ArrayList<>();
for(Integer i: intList) {
  if(i % 2 == 0) {
    evenList.add(i*2);
  }
}
// evenList will have elements 8, 16
```
In the example above, we filtered down intList to only include even numbers (i % 2 == 0) and then doubled their value and stored them in evenList. We can perform the same operation using Streams. A Stream is a sequence of elements created from a Collection source. A Stream can be used as input to a pipeline, which defines a set of aggregate operations (methods that apply transformations to a Stream of data). The output of an aggregate operation serves as the input of the next operation (these are known as intermediate operations) until we reach a terminal operation, which is the final operation in a pipeline that produces some non-Stream output.

Before we continue, we need a brief understanding of lambda functions in Java. A lambda eliminates the need to create (extremely verbose) anonymous classes to implement methods. With lambdas, we can define the method with its parameter(s) and its return value in a small block of code. Let’s look at the example above rewritten using aggregate operations.
```
List<Integer> evenList = intList.stream()
  .filter((number) -> {return number % 2 == 0;})
  .map(evenNum -> evenNum*2)
  .collect(Collectors.toList());
```
In the example above, we:

- Called stream() which returns a sequential Stream with elements from intList.
- Created a (small) pipeline with a single intermediate operation filter() and the terminal operation collect().
- Called filter() which returns a Stream with elements that pass some filter condition. An element passes a filter condition by returning true when called on the filter method. We defined the filter method to return true if the number is even.
- Defined a lambda to provide the filter method to filter(). The lambda defines all the parameters before the arrow (->) symbol and defines the function’s body after.
- Called map() which will return a new Stream with elements that have had some method applied to them.
- Defined the map() method using a lambda where we have evenNum as a parameter and return the result of multiplying evenNum by 2. You can omit the parameter parentheses () when there is only one parameter and omit the curly braces {} and return when the lambda body is one line.
- Called collect() (terminal operation), which takes the Stream and collects the elements back into some Container (we use a List). Java provides a Collectors class with static utility methods to use as an argument to collect().

Great job getting this far. It’s important to note that there is a lot more information about lambda and Stream that is outside the scope of this lesson. We encourage you to explore the Java docs to learn more.

Let’s practice creating a pipeline with filter, map, and collect().

#### Instructions

Take a look at the code in Main.java, specifically the functions getSpecialWordsWithForLoop() and getSpecialWordsWithPipeline() which receive a String List and return a new String List with only the four letter Strings in all caps.

Notice how we translated getSpecialWordsWithForLoop(), which use an enhanced for-loop, to getSpecialWordsWithPipeline(), which uses a pipeline, aggregate functions, and lambdas.