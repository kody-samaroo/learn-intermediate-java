###### GENERICS: LESSON

### Wildcard Lower Bounds

Recall that generic code can have an upper bound when defined using a type parameter or a wildcard. We can also provide a lower bound when working with wildcards. A lower bound wildcard restricts the wildcard to a class or interface and any of its parent types. For example:
```
public class Util {
  public static void getBag(Bag<? super Integer> bag) {
    return bag;
  }
}
```
In the example above, we used the super keyword to restrict the argument to getBag() to be a Bag of Integer, Number, or Object. If a call to getBag() with Bag<Double> is made, it would result in an error because Double is not an Integer or one of its parents.

Some important things to note about lower bounds are:

They cannot be used with generic type parameters, only wildcards.
A wildcard cannot have both a lower bound and an upper bound. In this case, it’s best to use a generic type parameter.
There are some general guidelines provided by Java as to when to use what type of wildcard:

An upper bound wildcard should be used when the variable is being used to serve some type of data to our code.
A lower bound wildcard should be used when the variable is receiving data and holding it for later use.
When a variable that serves data is used and only uses Object methods, an unbounded wildcard is preferred.
When a variable needs to serve data and store data for later use, a wildcard should not be used (use a type parameter instead).
Let’s practice adding a lower bound to a generic method.

#### Instructions

1. Let’s practice working with “in” and “out” references to understand how to use wildcards with bounds.

    In Main.java, transferData() is currently giving an error on incompatible types as we try to read an object from src and transfer it to dsc. Add a bound on src so that its type is bound to a Student or any of its sub-classes.

2. Now, add a bound to dsc so that its type is bound to a SchoolPerson or any of it’s parent classes.

    You should see the contents of dsc before and after the transfer of data occurs after you make your changes and run the program.