###### COLLECTIONS: LESSON

### Collection

We’ve discussed the core interfaces and their implementations, but the thing that keeps the collections framework polymorphic (compatible) is the Collection interface. The Collection interface provides a generic, general-purpose API when our program needs a collection of elements and doesn’t care about what type of collection it is.

Implementing classes may implement Collection methods and add restrictions to them like a Set does to only contain unique elements. Also, implementing classes or extending interfaces do not need to implement all methods and instead will throw an UnsupportOperationException when a Collection method is not implemented correctly.

We’ve seen add() and remove(), but some other methods Collection defines are:
```
addAll() - receives a Collection argument and adds all the elements.
isEmpty() - returns true if the collection is empty, false otherwise.
iterator() - returns an Iterator over the collection.
size() - returns the number of elements in the collection.
stream() - returns a Stream over the elements in the collection.
toArray() - returns an array with all elements in the collection.
```
Here is an example of how we can use some of these methods:
```
Collection<Integer> collection = new ArrayList<>();
collection.add(4);
collection.add(8);
 
boolean isEmpty = collection.isEmpty(); // false
int collectionSize = collection.size(); // 2
 
Integer[] collectionArray = collection.toArray(new Integer[0]);
```
In the example above, we:

Created an Integer Collection with an ArrayList implementation.
Called add() to add elements to the end of the Collection.
Called isEmpty() to check if collection has elements.
Called size() to get the number of elements in collection.
Called toArray() to transform our collection into an array. Note the new Integer[0] argument that specifies the type of array we want returned.
We can iterate through a Collection with an enhanced for-loop as we’ve seen with the other core interfaces.

Let’s practice working with Collection.

#### Instructions

1. Let’s take advantage of the collections framework compatibility by completing a method to iterate and print out all the elements of collections and their various implementations.

    In Main.java, we’ve defined printCollection() with a generic Collection parameter. Complete the method by iterating through Collection using an enhanced for-loop and an element named item. In the body of the for-loop, call System.out.println() to output item.