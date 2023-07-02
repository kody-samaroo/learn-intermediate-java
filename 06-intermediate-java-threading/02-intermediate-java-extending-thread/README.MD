###### THREADING: LESSON

### Extending the Thread Class

There are multiple ways to implement threading in Java. The first that we will try involves extending the Thread class. In Java, there is a built-in class that handles threads: java.lang.Thread. To create a thread, we create a class that extends the built-in Thread class and then overrides its public void run() method. Beyond these two requirements, the rest of our class can have anything we want in it!

The public void run() method that we override performs the actual work that our thread should be responsible for. This may be performing a long-running computation, calling out to another application or service, or other tasks that involve some waiting.

Notice that the run() method is a void and accepts no parameters. Every run() method must be of this signature. If run() requires some external information, that information must be a field declared in the class and initialized in the constructor. However, be very careful of using external information as this may present some synchronization issues.

When we defined our class in this way, we can then create an instance of our class in any other part of our program and call start() on the instance to trigger the thread’s execution.

Here’s an example of a sequential program in Java that computes the meaning of life:
```
public class HugeProblemSolver{
 
  public HugeProblemSolver(){
    // Required constructor used for passing information to the start() method.
  }
 
  private static void solveComputation(){
    // Solves random computation
    // Takes anywhere from 1 second to 10 minutes
    System.out.println("The answer is: 42");
  }
 
  public static void main(String[] args){
    HugeProblemSolver.solveComputation();
    HugeProblemSolver.solveComputation();
  }
}
```
In this program, we will only see the answer to the second question after the first question has been answered. A threaded solution would allow us to start the computations at the same time, and receive the answers as soon as they are available.

Let’s take a look at the threaded approach:
```
public class HugeProblemSolver extends Thread{
 
  public HugeProblemSolver(){
    // Required constructor used for passing information to the start() method.
  }
 
  private static void solveComputation(){
    // Solves random computation
    // Takes anywhere from 1 second to 10 minutes
  }
 
  @Override
  public void run(){
    solveComputation();
    System.out.println("The answer is: 42");
  }
 
  public static void main(String[] args){
    HugeProblemSolver m1 = new HugeProblemSolver();
    HugeProblemSolver m2 = new HugeProblemSolver();
    m1.start();
    m2.start();
  }
}
```
Now, you can see that all that changed was:

- Extended the Thread Class.
- Created and Overrode the run() method from Thread.
- Instantiated HugeProblemSolver and called start() which starts a new thread and searches in the class for the run() method to execute.

Now, both Threads we created are working on solving their own problems simultaneously. Whichever one finishes first will print to the console first. There is no need to wait on sequential order.

Let’s see how we can implement this in our CrystalBall class.

#### Instructions

1. The CrystalBall “thinks” for a given amount of time, based on question complexity when it is “asked a question”. This is where we want to allow multiple threads to start concurrently.

    Update CrystalBall.java to extend the Thread class.

2. Create a private field called question of type Question in the CrystalBall class. It will be used to store the question that is being asked of the crystal ball when we finish our multithreading approach.

    Create a constructor for the CrystalBall class that accepts a Question question parameter. Use the constructor to initialize the question field.

3. Now we need to override the Thread class’s run() method.

    Start by declaring the run() method and adding the required @Override annotation.
    Inside run(), call ask(), passing in the instance variable you just created, this.question.

4. Now let’s update FortuneTeller.java to reflect our changes and start our threads:

    Update the CrystalBall c‘s constructor in the forEach loop by passing in the Question q.
    Instead of calling ask(q) on the instance of CrystalBall c, change it to start(). We already passed in the question in the constructor, so this is all we need to do to start our threads.

5. You’ve done it! Try running the newly threaded FortuneTeller program to see how much faster the program completes, now that the CrystalBall class has been threaded.

- Use javac *.java to compile all java files.
- Use java FortuneTeller to run the program.

    You may have noticed that since the responses are now threaded, the output is interleaved! This makes it hard to know which answer is corresponding to which question. This is a common consideration that has to be made when converting a sequential program to a threaded program.

    As an added challenge, try updating the print statements so that it is always clear which answer corresponds to which question.