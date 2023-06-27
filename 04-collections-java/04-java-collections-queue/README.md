###### COLLECTIONS: LESSON

### Queue

The Queue core interface in the collections framework is a collection that implements the Queue data structure. A Queue is a First In First Out (FIFO) data structure in which elements are inserted at the tail (back) of the collection and removed from the head (front). Think of it like a line (queue) of people waiting to make a purchase: the first people that arrive on the line (queue) will be the first ones to be able to make a purchase.

A Queue has two types of access methods for inserting, removing, and getting (but not removing) the element at the head of the Queue.

The following methods throw an exception when:

> add() - there is no space for the element
remove() - there are no elements to remove
element() - there are no elements to get
>
The following methods return a special value:

>offer() - false there is no space for the element
poll() - null there are no elements to remove
peek() - null there are no elements to get
>
The methods that return a special value should be used when working with a statically sized Queue and the exception throwing methods when using a dynamic Queue.

Like the other collections framework interfaces, Queue has many implementations. We’ll focus on LinkedList and PriorityQueue. We’ve seen LinkedList be used as a List implementation, but it’s also perfect when needing a basic Queue implementation. Being able to use a LinkedList as both a List and a Queue is a perfect example of the compatibility within the collections framework. The PriorityQueue ensures the top element is the smallest relative to the data type’s natural ordering (or some custom ordering policy you provide).

Let’s look at an example of Queue with a LinkedList implementation:
```
Queue<String> stringQueue = new LinkedList<>();
stringQueue.add("Mike"); // true - state of queue -> "Mike"
stringQueue.offer("Jeff"); // true - state of queue -> "Mike", "Jeff" 
 
String a = stringQueue.remove() // Returns "Mike" - state of queue -> 1
String b = stringQueue.poll() // Returns "Jeff" - state of queue -> empty
String c = stringQueue.peek() // Returns null
String d = stringQueue.element() // Throws NoSuchElementException
```
In the example above we:

Created a new String Queue reference with a LinkedList implementation.
Called add() and offer() to insert elements into the Queue. Note the state of the Queue after each call.
Called remove() and poll() to remove and retrieve the element at the front of the Queue.
Called peek() and element() to retrieve but not remove the element at the front of the Queue. Note the results when stringQueue is empty.
We can iterate through a Queue using the enhanced for-loop. For example:
```
// Assuming `stringQueue` has elements -> "Mike", "Jack", "John"
for (String name: stringQueue) {
  System.out.println(name);
}
// OUTPUT TERMINAL: "Mike", "Jack", "John"
```
One thing to note about a PriorityQueue is that an enhanced for-loop (or Iterator) makes no guarantee in the ordering of elements after the head.

Let’s practice creating a Queue and iterating through it.

#### Instructions

1. In main() of Main.java we’ve made a Queue named line with names (Strings) and printed out the contents of the Queue. We’d like to be able to process line in alphabetical order rather than FIFO.

    Define a new public static method called processAlphabetically() that accepts a parameter named queue that represents a Queue of Strings. This method returns no value

2. Recall that a PriorityQueue will have the smallest element at the head of the collection. The smallest element in a collection of Strings will be in lexicographical (alphabetical) order.

    In processAlphabetically(), create a Queue of Strings reference with a PriorityQueue implementation named alphabeticalQueue.

3. Next, let’s add all the elements in queue into alphabeticalQueue by using an enhanced for-loop. The for-loop should iterate through queue using a String reference called name and add name to alphabeticalQueue.

4. Let’s process the names in alphabeticalQueue alphabetically.

    Under the for-loop in processAlphabetically() define a while loop that will iterate until peek() of alphabeticalQueue returns null. In the body of the while loop, create a String reference named headElement and store the result of removing the head from alphabeticalQueue. Finally, use System.out.println() to print the following message:

    Processing: <element>