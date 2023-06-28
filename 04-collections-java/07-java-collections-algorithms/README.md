###### COLLECTIONS: LESSON

### Algorithms

We’ve seen the many benefits of the collections framework and how they provide ready-to-use implementations so we don’t have to create them ourselves. What should we do when we need to sort a collection or get some statistic like the maximum or minimum element in the collection? The collections framework provides the Collections class that has many static methods that perform these types of operations for us.

Here are some of the methods provided by the Collections class:

>binarySearch(): Performs binary search over a List to find the specified object and returns the index if found. This method is overloaded to also accept a Comparator to define a custom ordering policy. Note: this method only provides the correct value if the elements in the List are sorted.
max(): Returns the maximum element in the Collection. This method is overloaded to also accept a Comparator to define a custom ordering policy.
min(): Returns the minimum element in the Collection. This method is overloaded to also accept a Comparator to define a custom ordering policy.
reverse(): Reverses the order of elements in the List passed in as an argument.
sort(): Sorts the List passed in as an argument. This method is overloaded to also accept a Comparator to define a custom ordering 
policy.
>
These utility methods for the collections framework make performing complex calculations or gaining insight into the collection of data we have easy and efficient.

Let’s practice using some Collections methods.