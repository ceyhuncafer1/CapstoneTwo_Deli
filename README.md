# Deli-CIOUS Sandwiches CLI App

## Overview
This is my first application with OOP implementation which allows customers to order sandwiches, chips, drinks, checkout, and get a unqiue receipt.
Users can choose from different sandwich sizes, types of bread, add meats, and more. 
Once the order is complete, a receipt is generated and saved to a file with a unique transaction ID.


First the customer will be prompted with this home screen:

![image](https://github.com/ninjakid56810/CapstoneTwo_Deli/assets/70558570/3c8b47f4-f61a-4ac6-bba6-422bc9ecde8d)

Which then they could now make a sandwich and fully customize:

![image](https://github.com/ninjakid56810/CapstoneTwo_Deli/assets/70558570/7c5af9f6-5398-46dc-b35b-58974cc0e849) ![image](https://github.com/ninjakid56810/CapstoneTwo_Deli/assets/70558570/f8917182-bc52-4ce1-a134-6d3b193e0079) ![image](https://github.com/ninjakid56810/CapstoneTwo_Deli/assets/70558570/9f9a2430-1b49-488a-8ef5-00b165bbe38c)

![image](https://github.com/ninjakid56810/CapstoneTwo_Deli/assets/70558570/6ad9dc89-ed48-4731-91d0-f3e5e0653eb8) ![image](https://github.com/ninjakid56810/CapstoneTwo_Deli/assets/70558570/dec30d89-6ca0-40ee-a5a9-0b3f240523d4) ![image](https://github.com/ninjakid56810/CapstoneTwo_Deli/assets/70558570/71270289-6d62-426a-ab54-064089a59433)

One thing to mention is that i kept the option type consistent. When testing, pressing between 1 and 0 for all my options was nice, rather than having the user have to type anything out at all.

## OOP Implementation

<img width="500" alt="MicrosoftTeams-image" src="https://github.com/ninjakid56810/CapstoneTwo_Deli/assets/70558570/e58001ea-642b-45f6-ad97-7cd08e499c18">

Main: Simply runs the program by creating an instance of UserInteface and calling it

Order: This is how we will group products (sandwich, chips, drink) and correlate unique (current, as the program does one order at a time) orders with corresponding products.

Product: Abstract class - Every product will have some same properties (price) We will flesh out the rest of the unique properties in the subclasses such as Sandwich, Drink, and Chip.

UserInteface: Deals with the actual user interaction - displaying menus, taking input, processing orders.

Sandwich: extends Product (subclass) contains details for customization and prices.

Chip: extends Product - Customer can select the type of chip they want

Drink: extends Product - Customer can choose size and drink type.

FileManager: Saves receipt to a file and generates a unique transaction ID (Doesn't matter in this case as the list for uniqueID's that can't be used anymore resets after every start on the application, howeveer a cool functionality nonetheless)

### One interesting piece of code from this project

We weren't tasked with creating a unqiue transaction ID for each receipt, however i wanted to try it out. My thought process was something like the end of a youtube video containing numbers and both case letters:

![image](https://github.com/ninjakid56810/CapstoneTwo_Deli/assets/70558570/a3486ba2-8b7f-4336-8caf-cddb863ec7c7)

So i created a String to represent the full list of characters to choose from
Then, I use random.nextInt() which specifies the index from the string of characters.

![image](https://github.com/ninjakid56810/CapstoneTwo_Deli/assets/70558570/3a99e413-18ef-4e38-b556-dfb8a2622f15)



