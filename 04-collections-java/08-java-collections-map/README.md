###### COLLECTIONS: LESSON

### Map

Previously, we saw the collections framework hierarchy and how Collection is the root of it. There exists another interface that didn’t quite fit into that hierarchy but is an extremely important part of the collection framework: the Map.

Map defines a generic interface for an object that holds key-value pairs as elements. The key is used to retrieve some value (like the index in an array or List). A key must be unique and map to exactly one value. There are many implementations of Map, but we’ll focus on the HashMap implementation.

The HashMap defines no specific ordering for the keys and is the most optimized implementation for retrieving values. This is Java’s implementation of a hash table.

A Map has the following methods for accessing its elements:

>put(): Sets the value that a key maps to. Note that this method replaces the value a key mapped to if the key was already present in the Map.

>get(): Gets, but does not remove, the value the provided key argument points to if it exists. This method returns null if the key is not in the Map. Let’s see how we can use them:
```
Map<String, String> myMap = new HashMap<>();
 
myMap.put("Hello", "World") // { "Hello" -> "World" }
myMap.put("Name", "John") //   { "Hello" -> "World" }, { "Name" -> "John" }
 
String result = myMap.get("Hello") // returns "World" 
String noResult = myMap.get("Jack") // return `null`
```
In the example above, we:

Created a Map reference that maps a String key to a String value using the HashMap implementation. Note that a Map needs a type argument for the key and value.
Added key-value pairs to myMap using put() where the first argument is the key and the second is the value the key maps to.
Retrieved the value the key “Hello” maps to using get(). The String “World” is returned since the key “Hello” exists. get() returns null because the key “Jack” does not exist.
We can iterate over a Map with an enhanced for-loop like so:
```
// Given a map, `myMap`, with the following key-value pairs { "Hello" -> "World" }, { "Name" -> "John"}
for (String s: myMap.keySet()){
  System.out.println("key: "+s+", value: "+myMap.get(s));
}
// OUTPUT TERMINAL:
// key: Name, value: John
// key: Hello, value: World
```
In the example above, we:

Called keySet() to return the Set of the keys contained in this HashMap.
Iterated through the set of keys of this map.
Called myMap.get(s) to get the value associated with key s.
Let’s practice working with Map.

#### Instructions

1. In Main.java, we’ve defined a method named countNumbers() that takes in a List of Integers named list as a parameter and returns a Map of an Integer-Integer pair. The purpose of this function is to count the number of occurrences of each number in list.

    Inside countNumbers() create a Map named intCount that maps an integer to another integer.

2. Inside countNumbers(), loop through list. For each number in list, if it does not contain an entry in intCount, map that number to the number 1. If the entry does exist, do nothing (we will change this in the next checkpoint).

3. Now it’s time to count the occurrences of each number in list. In the loop inside the countNumbers() method, if an entry for a number does exist, get the value of that entry, increment it by 1, and update the value of that entry. This represents the count of each number in list.