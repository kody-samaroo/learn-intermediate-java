###### THREADING: LESSON

### Communicating Between Threads

Previously, we learned how to block thread execution using join(). However, this is only to block thread execution from the context where the thread was started. For example, if a thread was created and started in the main thread, we can only call join() on it from the main thread and wait on its completion from there.

In Java, to control thread execution from within other threads, we can use the wait(), notify(), and notifyAll() methods. These are primarily used to protect shared resources from being used by two threads at the same time or to wait until some condition has changed in a thread.

When using wait() and notifyAll(), it is important to do so in a synchronized(this) block. When we create a synchronized(this) block, we are telling Java that we want it to be the only thread accessing the fields of the class at a given moment. In the synchronized(this) block, we must:

- Check the condition on which to wait.
- Decide whether to wait() (block the execution of the current thread) or notifyAll() (allow other threads to check their condition again and proceed)

In the example, we are simulating a family of five eager to eat some dinner! However, they can’t eat until the food has arrived. We could have controlled this behavior before by defining, starting, and joining the delivery thread before the five eatFood() threads began. However, using wait() and notifyAll(), we can start them in any order, and each eatFood() thread will wait() until a call to notifyAll() by another thread tells them to proceed to check again.

The synchronized block is used here to tell Java that only one thread should be able to read from and write to the foodArrived() field at a time.

The wait() function is used to pause execution for a thread until a call has been made to notifyAll(), which triggers another check of the condition.

The notifyAll() function is used to tell all threads that are currently waiting that they may now proceed.

In addition to being used to coordinate thread execution, we can use the synchronized(this) block, wait(), and notifyAll() to control access to shared resources. If a resource is currently in use, a thread should wait() until a call to notifyAll() is made, which indicates that the shared resource may have been released and is ready for use.

In this exercise, you’ll use the synchronized(this) block, wait(), and notifyAll() to update our CakeMaker class so that only one thread can use the mixing bowl at a given time. The other threads must wait() until the mixing bowl is released, and are instructed to continue with execution with a call to notifyAll().

#### Instructions

1. As you may have noticed, the last time that we saw this class, there are several boolean attributes representing whether or not certain shared resources are in use by a given thread. Before, we ignored these attributes. Now, we have realized that we only have a single mixing bowl! This means that only one thread can be using it at a time, and any other thread that requires the mixing bowl must wait(). If a thread is done using the mixing bowl, it must notifyAll() the other threads that they can check their condition again, and take ownership of the mixing bowl.

    Inside mixDryIngredients(), use the synchronized(this) block with a call to wait() to block the mixWetIngredients() thread from using the mixing bowl if the mixDryIngredients() (or any other thread) is using it.

    If the mixing bowl is in use, the thread should use printTask() to say "Waiting for the mixing bowl..." before the call to wait().

    Once it is out of the while loop (because the mixing bowl is no longer in use), it should use printTask() to say: "Using mixing bowl!", before setting mixingBowlInUse to true to indicate that the resource has been claimed.

    Note: The code will take a few seconds to finish running.

2. Now, let the mixDryIngredients() method release control of the mixing bowl when it is done! This will look similar to when the mixing bowl was acquired, but this time, we don’t need to check any conditions first. Change the attribute to false, and then notifyAll() the other threads that they can use it.

    Use printTask() to say "Releasing mixing bowl!" after changing the attribute to false, and before calling notifyAll().

3. Great! Now, we can add the same two snippets to the mixWetIngredients() method. Update the method so that it uses synchronized(this), wait(), and notifyAll() to indicate acquiring and releasing the mixing bowl.

4. Try running the code now! If you performed the above steps correctly, you should be able to tell that only one of mixWetIngredients and mixDryIngredients are able to perform actions that require the mixing bowl at a given time. This is much better than having to perform each method sequentially.

    As an added challenge, try adding similar snippets to control usage of the whisk! Run the code and inspect the output to see if the sequence of actions makes sense and that no thread can be using the whisk while another has claimed it.