###### THREADING: LESSON

### Introduction

So far, we have learned about threads and how they work in theory. Before we put it into practice, we should have a strong understanding of what kinds of problems multi-threaded programs are best suited to solve.

Threading can solve problems where there is a lot of waiting to be done. When one task is in a “waiting” or “blocked” state, another one can start. This is useful for programs in which a long-running computation needs to be done, or when a task must wait on a response from an external source such as fetching an image from a server.

In the following exercise, you’ll see how a program could be forced to “wait” for a task’s completion. As you complete it, start thinking about what tasks could be performed in threads, concurrently, to save some time.

#### Instructions

1. In FortuneTeller.java, you can see a program that consults another class, CrystalBall.java, to get a prediction for different kinds of questions! The crystal ball takes some time to muse before giving an answer, depending on the difficulty of the Question.

    As a refresher on compiling Java code, compile the java code (*.java), and then try running the FortuneTeller program in the terminal. Observe the behavior of this program.

    Click the Run button once the program has finished and you’re ready to move on. (Note: This step might take a few seconds, wait until the button stops spinning.)