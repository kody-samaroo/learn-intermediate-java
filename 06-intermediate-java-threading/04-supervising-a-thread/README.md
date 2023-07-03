###### THREADING: LESSON

### Supervising a Thread

So far, you have seen how to start threads with the start() method and learned multiple ways to implement threads into sequential programs.

Sometimes, we want to be able to see the status of threads during their execution. In Java, the best pattern for doing so is to use a supervisor thread. This is a pattern where the main thread (or another thread) is able to watch and check on the progress of another thread, as long as it has access to the corresponding Thread instance. This kind of thread is implemented just like other threads. Supervisor threads are often used for updating the user of our program on the progress of an ongoing task.

One Thread method that a supervisor thread may use to monitor another thread is isAlive(). This method returns true if the thread is still running, and false if it has terminated. A supervisor might continuously poll this value (check it at a fixed interval) until it changes, and then notify the user that the thread has changed state. Here is an example:
```
import java.time.Instant;
import java.time.Duration;
 
public class Factorial{
 public int compute(int n){
   // the existing method to compute factorials
 }
 
 // utility method to create a supervisor thread
 public static Thread createSupervisor(Thread t){
   Thread supervisor = new Thread(() -> {
     Instant startTime = Instant.now();
     // supervisor is polling for t's status
     while (t.isAlive()) {
       System.out.println(Thread.currentThread().getName() + " - Computation still running...");
       Thread.sleep(1000);
     }
   });
 
   // setting a custom name for the supervisor thread
   supervisor.setName("supervisor");
   return supervisor;
 
 }
 
 public static void main(String[] args){
   Factorial f = new Factorial();
 
   Thread t1 = new Thread(() -> {
     System.out.println("25 factorial is...");
     System.out.println(f.compute(25));
   });
 
 
   Thread supervisor = createSupervisor(t1);
 
   t1.start();
   supervisor.start();
 
   System.out.println("Supervisor " + supervisor.getName() + " watching worker " + t1.getName());
 }
}
```
The thread labeled supervisor here is polling the status of t1 (a “worker” thread) continuously at an interval of 1000 milliseconds (one second). The supervisor checks the status of t1 using the isAlive() method in a while loop.

Additionally, the getName() method will return a unique name for a thread in the current context. This comes in handy when debugging multi-threaded programs: the programmer can better understand which thread is performing a certain task at a given moment. We can also name a thread ourselves, using the setName() method of the Thread class.

Now, let’s create a supervisor thread that polls for the status of all of the running CrystalBall threads.

#### Instructions

1. For a supervisor thread to be able to check the status of all the threads, it will require access to all of the thread instances. We can store all of the instances in a List<Thread> threads. To do this, in the main() method of FortuneTeller.java, use the map() method to transform the list of questions into a list of threads by:

    Replacing the existing .forEach expression with a .map expression. This time, don’t call start() on the thread. This will be handled after the supervisor is ready.
    For each question q, create the Thread t using the lambda expression syntax for Runnables and return the resulting Thread.
    Finally, .collect it into a List<Thread> threads.

2. Note that there is a createSupervisor() method present. Read over this method and take a look at what it is doing.

    The createSupervisor() method takes a list of threads and creates a supervisor thread that polls the list of threads to find which ones are still running (using .filter with isAlive()), and prints them out. Then, if there are no more running threads, it breaks the loop and exits. Otherwise, it waits for one second and then polls the threads again.

    Update this method so that before it returns the supervisor thread, it sets the thread’s name explicitly to "Supervisor".

3. In the main() method, call the createSupervisor() method after your previous code where you created the list of threads. Pass in the list of threads, and store the resulting supervisor thread in a variable called supervisor.

4. Finally, start each of the “asking” threads by using a .forEach loop, and start the supervisor thread immediately after.

5. Run your code and observe the output. The supervisor should be giving us continuous status updates! Every second, after checking which threads are running, it prints them out and finally lets us know when all threads have completed. When you’ve executed the program a few times, proceed to see how we can handle even more complex threading use-cases.