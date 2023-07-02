###### THREADING: LESSON

### Implementing the Runnable Interface

In the previous exercise, you learned that we can convert a class to run as a thread by extending the Thread class. We can also create threaded classes in Java by implementing the Runnable interface.

This approach is preferred because we are only allowed to extend one class, and wasting it on Thread might not be beneficial to our program. Here, rather than extending the capability of the built-in Thread class, we just want to use its threading capability. Because of this, implementing the Runnable interface (which is what the Thread class does anyway) and passing in the object into a new Thread object is the preferred way of implementing multithreading. Here’s an example of how we would implement a Factorial thread by implementing Runnable instead of extending Thread:
```
public class Factorial implements Runnable {
 private int n;
 
 public Factorial(int n) {
   this.n = n;
 }
 
 public int compute(int n) {
   // ... the code to compute factorials
 }
 
 public void run() {
   System.out.print("Factorial of " + String.valueOf(this.n) + ":")
   System.out.println(this.compute(this.n));
 }
 
 public static void main(String[] args) {
   Factorial f = new Factorial(25);
   Factorial g = new Factorial(10);
   Thread t1 = new Thread(f);
   Thread t2 = new Thread(f);
   t1.start();
   t2.start();
 }
}
```
A more succinct way of using the Runnable interface is to use lambda expressions. This is a more modern syntax that allows us to define the run() method we want to use inline without requiring the class to implement Runnable or extend Thread. For the above example, the syntax looks like this:
```
public class Factorial {
 public int compute(int n) {
   // ... the code to compute factorials
 }
 
 public static void main(String[] args) {
   Factorial f = new Factorial();
 
   // the lambda function replacing the run method
   new Thread(() -> {
     System.out.println(f.compute(25));
   }).start();
 
   // the lambda function replacing the run method
   new Thread(() -> {
     System.out.println(f.compute(10));
   }).start();
 }
}
```
Behind the scenes, this syntax is still using the Runnable interface. This is because Java will translate this lambda syntax into something like this:
```
new Thread(new Runnable() {
 void run() {
   System.out.println(f.compute(25));
 }
}).start();
```
Using the lambda expression syntax for starting threads, we can create a threaded version of our class in only a few lines!

This syntax has several benefits:

Our class no longer needs to extend Thread OR implement Runnable. We can make a thread from anything!
Our class no longer needs a constructor to store arguments! Since we can pass an argument directly into the compute function when we create our thread, we no longer need to create a separate instance of our object any time we want to perform a threaded task with it.
Our class is easier to read! The lambda syntax makes it so that people reading our code can immediately identify what task is being performed in our thread without having to read our class first to find the run() method.
Now, let’s try both of these methods of implementing Runnable with our FortuneTeller class.

Note: Sometimes you will see developers specifically import the Thread and Runnable classes from java.lang. This is not necessary since all Java programs naturally import the java.lang package anyway. It is often used to help with readability or remind an author to add a specific feature.

#### Instructions

1. Let’s start by converting our class into one that implements Runnable instead of one that extends Thread:

    Update the class to implement the Runnable interface, don’t forget to remove the Thread extension
    Lastly, remember to remove the @Override annotation, as it is no longer required.

2. Great! Now that you’ve converted the CrystalBall class to a Runnable, update FortuneTeller.java in the following way:

    Instead of calling .start() directly on an instance c of CrystalBall, create a new Thread t from the Runnable version of the CrystalBall.
    Call .start() on that thread.
    Run the code now, and you should see that this works in the exact same way as your previous code did when you extended the Thread class!

3. Like before, you still require a new CrystalBall for every Question (q) that is asked. In practice, a single Crystal Ball should be able to think about more than one question at a time!

    Now let’s try implementing lambdas. You can use the lambda expression syntax for creating Runnables to achieve this as you saw in the Factorial example.

    Update CrystalBall.java class to:

- Neither extend Thread nor implement Runnable
- Remove the .run() method
- Remove instance variable question
- Remove the constructor

4. Finally, update FortuneTeller.java so that instead of creating a new CrystalBall c in every iteration of the loop, create one CrystalBall c before the loop over where the questions begin.

    Then, in the loop, start a new Thread using the lambda expression syntax, which calls the .ask() method of the CrystalBall c with the current Question q.

5. That should be it; run the code to see how the threaded FortuneTeller program works! Feel free to tweak it further to see how you can make the output easier to understand.