###### THREADING: LESSON

### Waiting for Thread Completion

Another common scenario in multi-threaded programs is to wait for a thread to complete before proceeding in a path of execution.

In other languages, this concept is called “awaiting” or “blocking”. In Java, we say that we wait for the thread to join.

When a thread joins, it means that the thread’s task is complete and the process that was initially forked off has been “joined” back into the main thread.

This is useful when we can only perform a specific task once several prerequisite tasks have been completed. Take a look at BurgerMaker.java in the editor, which describes the process of preparing a cheeseburger. A cheeseburger is generally prepared in the following way:

- Grill hamburger patty.
- Once the patty is properly cooked, add cheese on top to melt it.
- Toast the burger buns.
- Fry onions.
- Once all ingredients are ready, assemble the burger.

Many of these steps can be done concurrently. However, notice that some of the steps are dependent on the completion of other steps. Step 2 requires the patty to be grilled before melting cheese on top of it. Step 5 requires all other steps to be completed before it can start (we can’t assemble a burger until everything is ready).

In BurgerMaker, we can see how join() is used to enforce dependencies between different tasks. By using start() and join() properly, we can ensure that tasks that can be performed concurrently are started. Still, tasks with dependencies are not started until all dependencies have been joined.

In this exercise, we’ll use the join() features we see in BurgerMaker.java to ensure that tasks occur in the correct order while making a cake in our new file, CakeMaker.java. CakeMaker describes baking a cake by following these steps: A cake is made in the following way:

- The oven must be preheated before the cake can be baked.
- The dry ingredients and wet ingredients should be mixed before the ingredients can be combined.
- The ingredients must be combined before the cake can be baked.
- The cake must be finished baking before the cake can be frosted.

#### Instructions

1. Open the CakeMaker.java file in the editor and take a look at it. Several methods that detail the different steps in making a cake are already in place.

    Notice that we’re using a different constructor for Thread now; one that takes two arguments. This one allows us to create the thread and give it a custom name in the same step.

    You will update the main() function where specified so that the tasks occur as efficiently and concurrently as possible without breaking dependencies between tasks.

    Start the following tasks:

    - preheatOven
    - mixDryIngredients
    - mixWetIngredients
    - makeFrosting

2. Use the join() function to represent the completion of the following tasks:

    - mixDryIngredients
    - mixWetIngredients

    Start the combineIngredients task which represents combining the dry and wet ingredients.

3. “Join” the following tasks to represent their completion:

    - preheatOven
    - combineIngredients
    - makeFrosting

4. “Bake the cake” by calling start() and then join() for the bakeCake task. “Frost the cake” by doing the same for the frostCake task.

5. Compile and run CakeMaker.java! You should see the cake-making process, and if you’ve done it correctly, several tasks will happen at once. Your cake will be ready in no time!