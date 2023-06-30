###### NESTED CLASSES: LESSON

### Non-Static vs. Static
As mentioned in the previous exercise, there are two types of nested classes: non-static (also known as inner) nested, and static. Let’s take a closer look at what makes these two types of classes different.

#### Non-static(inner)
Non-static nested classes can have access to both static and non-static members of the class that it is declared within. They are also known as inner classes. A non-static nested class is closely associated with the class enclosing it. So to reference a non-static nested class outside its scope, a programmer would have to also reference its encompassing class.

#### Static
A static nested class is not the same as an inner class because a static nested class cannot access all classes, variables, and methods of the enclosing class. They can only access other static members of their encompassing class. Static nested classes also don’t have access to non-static members of the Java program. Unlike non-static nested classes, static nested classes don’t need to be referenced with the association of their encompassing class.