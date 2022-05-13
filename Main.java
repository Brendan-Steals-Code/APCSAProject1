/*
Brendan Aeria
Period 4 APCSA Mrs. Woldseth
Project 1 treehouse submission

Preconditions: Array lists for the room names, integer arrays
for the index of the rooms with good plumbing if it is a 
treehouse and good electrical if it is a modern treehouse, and 
the resident's name will be used when declaring any treehouse 
object.

Postconditions: A treehouse object contains the rooms, index of 
the rooms with good plumbing, has a boolean that decides if the 
plumbing in the total house is good, and the resident's name.
*/


import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    // Creating the array list that will go into the treehouse object
    ArrayList<String> exRooms = new ArrayList<String>();
    exRooms.add("bath1");
    exRooms.add("living1");
    exRooms.add("kitchen1");
    exRooms.add("bath2");
    exRooms.add("living2");
    exRooms.add("kitchen2");
    exRooms.add("bath3");
    exRooms.add("living3");
    exRooms.add("kitchen3");

    // The integer array that describes the index of the rooms with good plumbing
    int[] numGood = {0,2};
    
    System.out.println(" ");
    // Creating the treehouse object
    Treehouse test = new Treehouse(exRooms, numGood, "Bob");

    // Begins a series of actions with the test treehouse object
    
    test.printRooms();
    System.out.println(" ");

    System.out.println("Resident of this treehouse: " + test.getResident());
    test.getGoodPlumbing();
    System.out.println(" ");
    
    System.out.println("Rooms with good plumbing:");
    System.out.println(test.goodPlumbingRooms());
    System.out.println(" ");
    
    System.out.println("Let's randomize the rooms:");
    test.randomizeRooms();
    test.printRooms();
    System.out.println(" ");
    
    System.out.println("Rooms with good plumbing:");
    System.out.println(test.goodPlumbingRooms());

    // Creates the modern treehouse object

    int[] goodEl = {0, 1, 3, 6};
    
    Treehouse modern = new ModernTreehouse(exRooms, goodEl, "Bob");

    // Demonstrates the difference with the modern treehouse subclass
    
    System.out.println(" ");
    System.out.println(" ");
    System.out.println("- - - - - - - - - - - - - - - - -");
    System.out.println(" ");
    System.out.println(" ");
    System.out.println("Now let's see this modern treehouse:");
    modern.printRooms();
    
  }
}