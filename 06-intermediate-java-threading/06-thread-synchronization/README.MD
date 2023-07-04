###### THREADING: LESSON

### Thread Synchronization

Another important scenario when working with multi-threaded programs is managing shared resources between threads.

When we access the same data from two different threads, we may cause a race condition. A race condition occurs when some inconsistency is caused by two threads trying to access the same shared data at the same time. Consider this example where two threads are attempting to increment a value simultaneously:
```
class IntegerMapper{
  public int[] array = {1, 2, 3, 4, 5};    
  public void incrementElement(int i, int j){
    array[i] += j;
  }   
}
public class Main{
  public static void main(String args[]) throws InterruptedException{
    IntegerMapper iMapper = new IntegerMapper();
    Thread thread1 = new Thread(() -> {
      for(int i = 0; i < 100; i++){
        iMapper.incrementElement(2, 4);
        try{
          Thread.sleep(10);
        }
        catch(InterruptedException exception){
          System.out.println("Error!");
        }
      }
 
    });
    Thread thread2 = new Thread(() -> {
      for(int i = 0; i < 100; i++){
        iMapper.incrementElement(2, 3);
        try{
          Thread.sleep(10);
        }
        catch(InterruptedException exception){
          System.out.println("Error!");
        }
      }
    });
 
    thread1.start();
    thread2.start();
 
    thread1.join();
    thread2.join();
 
    System.out.println(iMapper.array[2]);
  }
}
```
If we run this program multiple times, we will get a different output each time! This is because thread1 and thread2 conflict in their access of array[2]. To update the value in the incrementElement() method, the value must be read, incremented, then saved. One thread could be reading the value while the other thread is incrementing it, leading to inconsistencies.

We can prevent race conditions on shared data by using the synchronized keyword in Java. In a threaded program, when we add synchronized to the definition of a function, it will ensure that for a given instance of a class, only one thread can run that method at a time. We can fix incrementElement() by making it synchronized like so:
```
public synchronized void incrementElement(int i, int j){
    array[i] += j;
}
```
Now, each time the program is run, it will output the same value.

Let’s see how we can use thread synchronization to solve a classic race condition problem.

#### Instructions

1. Take a look at Counter.java. It is a simple class that increments a number. In the main() function, we have defined two threads that increment a number 100 times each.

    Underneath where the two threads are defined, write code that will start thread a, start thread b, and then join thread a and thread b back to the main thread.

    After you’re done, compile and run the code to see what happens.
    
2. Notice something weird? If each thread was supposed to increment the counter 100 times, then the total value of count should have been 200! However, since these two methods were not synchronized, they encountered a race condition. Every time you run this code, you might get a different answer for the final count!

    For example, while one thread could be performing getCount(), another could have performed setCount(), so the getCount() would have been operating on outdated information!

    The increment() method is where our Counter performs the calls to setCount() and getCount(). Update the method signature to include the synchronized keyword, it goes after the access modifier.

    When you’re done, run the code again.

3. Hurray! You can now see that the counter works as expected, yielding the correct total count for the number of iterations expected. Try adding more threads and validating that it continues to update the count as expected.