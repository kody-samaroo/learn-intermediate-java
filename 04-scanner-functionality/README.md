###### INPUT AND OUTPUT: LESSON

### Scanner Functionality

Now that we’re familiar with how to set up our Scanner instances, let’s dive into some of its functionalities and how to actually read input, whether that be from a file or from the console.

The first thing to know about the Scanner class is that it breaks up its input using a defined delimiter and by default that delimiter is set to whitespace. This means every time there is a space or a new line in our input, the Scanner will recognize it as a new piece of the input, in fact, it can do its best to search the input for the specific type of information you are looking for, whether that be an integer, a word, or a character.

The next most important piece of the Scanner class is that is blocking, that means that if the Scanner is waiting on user input from the terminal, it will block continued execution of the program until it gets its input.

The list below outlines some (but not all) the different methods associated with the Scanner class that allow us to read the next piece of information we are looking for.

| Variable | Code
| --- | ---
| String | String myString = input.next();
| Int | int num = input.nextInt();
| Double | double numDouble = input.nextDouble();
| Byte | byte numByte = input.nextByte();
| Boolean | boolean isTrue = input.nextBoolean();
| Long | long numLong = input.nextLong();
| Short | short numShort = input.nextShort();

The Scanner class has several additional methods that help support data validation and control flow, we can use these to make sure that we don’t try to process data that doesn’t exist and thereby run into errors in our program, also known as exceptions.

| Code | Function
| --- | ---
| input.hasNext() | This function returns a boolean that indicates if there is another token left to process
| input.hasNextLine() | This function returns a boolean that indicates if there is another line in the input of the defined scanner.
| input.hasNextInt() | This function returns a boolean that validates if there is another int in the input of the defined scanner.
| input.useDelimiter(","): | This function helps us specify what delimiters we want to use. A delimiter is used to separate data units. This , delimiter can be especially useful when a program is required to read csv (comma separated values) files.

Let’s go ahead and ask the user to enter a name and then wait for their input. This is your first truly interactive program! Get Excited! 😜

#### Instructions

1. Beneath the comment, write the print statement that asks the user what their name is.

2. After the print statement, declare a new String variable called userName, initialize it to the Scanner’s next String input, use the table from the exercise to find the appropriate method.

    Remember, once we ask the Scanner to find us information, we block the execution of the rest of the program, meaning nothing will run unless the input is received.

3. Use System.out.printf() to print the following statement:

    Hello "userName"! It's nice to meet you.
where “userName” is replaced with the input provided by the user.

4. Now let’s test it out! First, compile your program using the correct command in the terminal.

5. Now, run your program using the correct command in the terminal.