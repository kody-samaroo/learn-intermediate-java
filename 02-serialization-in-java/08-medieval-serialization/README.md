###### LEARN INTERMEDIATE JAVA

### Medieval Serialization

Welcome to Waveside Game Studio, creators of MMOTBRPGFUWJVMs, the ultra concise acronym for Massively Multiplayer Online Text Based Role Playing Games For Use With Java Virtual Machines.

Catchy, we know, but it’s your first day on the job and there’s no time to dwell on clever acronyms and your marketing career aspirations.

You’ve been asked to add the game intro, saving, and loading functionality to the company’s new Medieval Game using serialization. Your Tech Lead added you to the git collaboration and you see the files in the editor before you, let’s jump right in…


#### Workspace Review

1. Review Armour Files
The Armour class contains the core functionality for all of the subclasses. You can see a generic piece of armour has three traits: a name, a durability, and a defenseRating.

    Besides the basic constructor, there are two instance methods, one that reduces the durability of the item and one that repairs the item. Below that is a getter to return the defenseRating modified by the current durability as well as a toString() method to allow us to present an armour piece to the player.

    There are four subclasses of the Armour class: Helmet, Shirt, Trouser, and Shoe. Each subclass makes a call to super() in its own constructor, passing through the relevant information.

2. Review Weapon.java
Open Weapon.java in the code editor. You may close the other files if you want to declutter the workspace.

    The Weapon class contains two instance variables (name and damage), a constructor, and getters for each of the variables. There is no toString() method because printing the weapon to the user is handled by the Player class.

3. Review Player.java
Open Player.java in the code editor. You may close the other files if you want to declutter the workspace.

    The Player class uses each of the classes previously covered. As one would expect, a player has a name, and a health variable and may have one of each of the following: Helmet, Shirt, Trouser, Shoe, and Weapon. However, if you look at the constructor when a new player is created, they start with only a Weapon, the "Rusty Short Sword".

    Right now, there are only two instance methods, takeDamage() and heal(), that can be implemented into the combat system when it is created. The game is still in its infancy stages. You may notice that once a player dies (health reaches 0), the game alerts the player and exits the game.

    Following those methods are several getters and setters and the toString() method. Some of these will be used in the game intro, but most are reserved for later game updates.

4. Review MedievalGame.java
Open MedievalGame.java in the code editor. You may close the other files if you want to declutter the workspace.

    This file will contain the majority of the edits you have been asked to make as well as the main() method of the game. The only functional piece of code right now is the addDelay() method, which will be used to slow the terminal down and make it appear to the user that a person, and not a computer, is replying to them in the game.

    The main() method contains the necessary logic to test your code. It launches the game by initializing a Scanner and an instance of MedievalGame, then it executes your start logic and goes through the process of printing out your character, saving it, deleting it, and reloading it. The method is currently empty. You will fill this method out as you go through this project.

    The three other methods, start(), save(), and load() will contain the logic for the three tasks you will complete.

#### Setting up the Serialization Backbone

5. The save() method of MedievalGame is where you are going to serialize a Player instance to a file. To make that happen, you must first ensure that all the classes used in Player can be serialized as well.

    Open Armour.java in the code editor.

6. The first addition to the Armour class is to import the interface we are going to use. Do this by adding an import statement for the Serializable interface above the class declaration.

7. The next step is to implement the interface. Add the Serializable interface to the Armour class declaration.

8. The final step is to add a new class variable called serialVersionUID. It will be private, static, final, and of type long and it will be initialized to 1L.

    This variable ensures that the object requested at deserialization is the same one that was initially serialized.

9. Now it’s time to make all our objects Serializable. Repeat the same three steps (import the interface, implement the interface, and add the serialVersionUID class variable) to each of the following classes:

- Helmet.java
- Shirt.java
- Trouser.java
- Shoe.java
- Weapon.java
- Player.java

#### Saving The Game

10. When we save a game, we write the user’s instance of a Player to a file using the name that the user gave their player.

    Open MedievalGame.java and declare a new private instance variable, player of type Player. We used comments to organize the file and recommend putting it under the /* Instance Variables */ location.

11. Now let’s move on to the save() method.

    Inside the method, create a new String called fileName and set it equal to the player’s name plus ".svr". This will be the file extension, short for “saver”.

12. To serialize the Player class to a file, we need the ability to write to a file.

    Inside the save() method, create a FileOutputStream object and give it a relevant name (we used userSaveFile). Set it equal to a new FileOutputStream and pass in the fileName variable as the source.

    To access the FileOutputStream class, import it from the java.io package.

13. Now that we can write to a file, we need to create the object stream to pass objects to the file.

    On the next line, declare an ObjectOutputStream called playerSaver and set it equal to a new ObjectOutputStream, passing in the FileOutputStream variable you created in the line above.

    Just like the FileOutputStream object, you must import the class from the java.io package to use it.

14. Now that you’ve created the ObjectOutputStream, use its instance method, writeObject(), to write the player object to the file.

15. If you’ve compiled your code during these steps, you’ll notice that you were running into some errors. All three of the last tasks throw exceptions and that need to be handled.

    Below the fileName declaration, create a try-catch block. Put the three lines where you created the FileOutputStream, ObjectOutputStream, and used the writeObject() method, into the try block.

    Catch an IOException as e, which you will also have to import (java.io.IOException), and print an error message to the user about being unable to save the game properly inside the catch block.

    This completes your save() method.

#### Loading a Saved Game

16. Now that you can successfully write (save) objects to a file, it is time to reverse that functionality and load a user’s saved character from the file. Find the load() method in MedievalGame.java.

    You will see that the method returns a Player; for now, it’s just a generic new Player so that our compiler doesn’t throw any errors. Besides the return type, you will notice it passes in two arguments: a String playerName and a Scanner console. The playerName will be used to look up the user’s save file. The Scanner object can be used later to expand the capabilities of the game to handle accidental spelling mistakes or other user name errors.

17. Inside the load() method, declare an uninitialized Player called loadedPlayer.

    Change the return statement to return loadedPlayer instead of the new “Test” Player.

18. This time, we’ll create the try-catch ahead of time and put our code in it as we add it. After the loadedPlayer declaration, create an empty try-catch block.

    The catch block will catch either an IOException or a ClassNotFoundException as e. You don’t need to import the ClassNotFoundException because it is part of java.lang and every program automatically imports that package.

19. The next step is very similar to the save() method. Create the FileInputStream and the ObjectInputStream in the same way as you did in task 11.

    The argument in the FileInputStream constructor will be the playerName parameter that was passed into the load() method concatenated with the ".svr" file extension. The argument for the ObjectInputStream will be the FileInputStream you just created.

20. Now we need to read the Player object from the file. Inside the try block, set the loadedPlayer variable equal to the object that is returned by calling the readObject() method on the ObjectInputStream object. You will need to cast the returned object as a Player object.

21. Inside the catch block, we are going to handle the problems that may arise when the file cannot be found or there is a problem reading the objects in the file. The way we are initially going to handle this is by alerting the user and then creating a new player with the name that they passed into the load() method.

    Wrap your error message in calls to the addDelay() method to slow the computer down and make it appear to be searching/thinking about solving the problem.

    Here are the steps inside the catch block:

- Make a call to addDelay() with 1500 as the argument
- Add a message that alerts the user to what is happening
- Make another call to addDelay with 2000 as the argument
- Set loadedPlayer equal to a new Player with the playerName variable passed to the constructor.

#### Starting the Game

22. This is where the fun begins. Navigate to the start() method to start filling it in. At the top of the start() method, declare an uninitialized Player called player.

    Now modify the method’s return statement to return player.

23. You will now print the artwork from the Art class to the home screen. Inside start(), make a call to the Art class’ static method called homeScreen().

24. Now we are going to welcome the user to our game. We passed the Scanner from the main() method into the start() method so we have access to it and will use it to record answers from the user.

    In a few lines, welcome the adventurer to the game and ask them if they would like to start a new game or load a saved game. Ask them to enter “y” for yes or “n” for no.

    Note: We are not going to be handling errors, typos, or any other edge cases as far as user input is concerned except the bare necessities. We highly encourage you to take this code and expand upon the central concepts to cover user interactions and other best practices.

25. Next, declare a String variable, answer, and set it equal to the lower case result of the next token of the scanner, console.

26. The next step is to create the logic to handle the “y” or “n” answer. There are many ways to do this and we’ll leave this as a challenge to you. Here are the basic guidelines:

- If “y”, ask the player to enter their previous character name and set the local player variable equal to the loaded character.
- If “n”, ask the player for their desired character name and set the local player variable equal to a new Player with the name the user entered.
- If neither “y” or “n” is entered, ask the user to enter one of the two choices (Hint: we wrapped our logic in a while statement and used break statements when the user correctly entered “y” or “n”).

27. The last thing to do is compile and run your game. Use the javac *.java command in the terminal to compile all the files.

    If you run into any errors, try to troubleshoot the error traces and figure out where exactly things might have gone wrong. This is a lot of code and typos or syntax errors should almost be expected on the first try. Don’t be discouraged.

    Finally, run the MedievalGame file with the java MedievalGame command in the terminal and see what your hard work produced. Expand the terminal so you can see the ASCII art properly.

    What the main() method does is call your start logic to start a new game. It then goes through the process of saving the character, deleting the current player object, and then reloading the save file to the player object to make sure the process works correctly. We’ve added delays to make it a bit more user-friendly.

    This game included many features that we didn’t explore yet and we offer that as a challenge to expand the game. Maybe build the combat system or encrypt the serialization so users can’t change data in the saved files. You could even draw out a little 2D map and use the console to have the player navigate around. Does your Tavern sell items? You could build a Shop class and make the Tavern interactable…

    The goal is to have fun. Now that you can serialize objects, your game just got a lot more portable! Congratulations!