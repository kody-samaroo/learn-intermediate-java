###### LEARN INTERMEDIATE JAVA

### Ice Cream Inventory

Congratulations, you have just landed a new contract to build out an application for a new local ice cream shop in town! They need a program that will help them sort and keep track of their inventory of ice cream, shakes, slushies, and smoothies. This Java program will have to keep count of how many of each product the shop sells.

Mark the tasks as complete by checking them off
#### Create a nested class named NonVegan.
1. Inside ShopItems, create a nested class called NonVegan that contains the following fields:
```
int iceCreamCount;
int shakeCount;
int totalCount;
```
2. Inside NonVegan, create a method called increaseCount() that accepts two integer parameters called type and count. Inside this function, if type is 1, increment iceCreamCount by count. If type is 2, increment shakeCount by count.

    Use shadowing to increase the count of the variable totalCount both within the NonVegan class, and the variable totalCount in the enclosing class ShopItems.

#### Create a nested class named Vegan.
3. Inside ShoppingItems, create a class named Vegan that contains the following fields:
```
int smoothieCount;
int slushieCount;
int totalCount;
```
4. Inside Vegan, create a method called increaseCount() that accepts two integer parameters called type and count. Inside this function, if type is 3, increment smoothieCount by count. If type is 4, increment slushieCount by count.

    Use shadowing to increase the count of the variable totalCount both within the Vegan class, and the variable totalCount in the enclosing class ShopItems.

    Incorporate your classes into the Main method of the IceCreamShop class.
5. Inside the main() function of ShopItems, create an instance of the outer class ShopItems. Next, create an instance of the class NonVegan, and an instance of the class Vegan.

6. Complete the if-statement within the while loop in the main() method. Call the proper increaseCount() method within each if or else if block based on the type of order and whether it is vegan or non-vegan. Use the following table as a guide:
```
type number	kind of treat	class
1	ice cream	non-vegan
2	shake	non-vegan
3	smoothie	vegan
4	slushie	vegan
```
7. Outside of the while loop, near the end of the method, print the following three statements:

    Thank you for your order! Today we have sold <number_of_items_sold> orders of sweetness!
    where <number_of_items_sold> represents the total number of items sold.

    <number_of_non-vegan_treats> items have been ice cream and shakes.
    where <number_of_non-vegan_treats> represents the total number of non-vegan items sold.

    <number_of_vegan_treats> items have been smoothies and slushies.
    where <number_of_vegan_treats> represents the total number of vegan items sold.

#### Run your program

8. Compile your program.

9. Run your program.