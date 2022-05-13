/*
Preconditions: All of the proper variables have been inputted into the constructor in order to be stored and used by the methods of the Treehouse class.

Postconditions: Methods are used that modify, randomize, and use the information stored in any Treehouse object including one that is a ModernTreehouse.
*/

import java.util.ArrayList;


public class Treehouse {
  // These are where the variables for this class are declared
  public ArrayList<String> rooms = new ArrayList<String>();
  public int[] goodPlumbingIndex;
  public String resident;
  public boolean goodPlumbing;

  // The compiler requires a no parameter constructor in order 
  // to create a ModernTreehouse object
  Treehouse(){}

  // The variables for this class are stored and the overall 
  // quality of the plumbing is determined as good if more than 
  // half of the rooms have good plumbing
  Treehouse(ArrayList<String> r, int[] g, String res)
  {
    rooms = r;
    goodPlumbingIndex = g;
    resident = res;
    if (goodPlumbingIndex.length > (rooms.size()/2)) {
      goodPlumbing = true;
    } else {
      goodPlumbing = false;
    }
  }

  // getter method for the resident name
  public String getResident() {
    return resident;
  }

  // Prints out declaring the quality of the plumbing and 
  // returns the boolean value
  public boolean getGoodPlumbing() {
    System.out.print("Does this treehouse have good plumbing: ");
    if(goodPlumbing) {
      System.out.println("yes");
    } else {
      System.out.println("no");
    }
    return goodPlumbing;
  }

  // Returns whether or not the String inputted is a room with 
  // good plumbing
  public boolean getGoodPlumbing(String ro) {
    for(int p : goodPlumbingIndex) {
      if(rooms.get(p).equals(ro)) {
        return true;
      }
    }
    return false;
  }

  // Iterated through the rooms array list and randomly swaps 
  // rooms while maintaining the index of good or bad plumbing
  public void randomizeRooms() {
    int swapWith;
    String tempR;
    
    for (int i = 0; i < rooms.size(); i++) {
      swapWith = (int)(Math.random() * (rooms.size() - i)) + i;
      tempR = rooms.get(i);
      rooms.set(i, rooms.get(swapWith));
      rooms.set(swapWith, tempR);
      
    }
  }

  // returns the room for that specific index
  public String getRoom(int i) {
    return rooms.get(i);
  }

  // returns the index of the room String inputed
  // returns -1 if it is not a room found
  public int indexOfRoom(String s) {
    for (int i = 0; i < rooms.size(); i++) {
      if (rooms.get(i).equals(s)) {
        return i;
      }
    }
    return -1;
  }

  // returns the number of rooms in the ArrayList
  public int getNumRooms() {
    return rooms.size();
  }

  // prints the names of each room as well as wether or not they
  // have good plumbing
  public void printRooms() {
    System.out.println("------------");
    for (String j : rooms) {
      System.out.print(j + " - ");
      if(tryFlush(j)) {
        System.out.println("has good plumbing");
      } else {
        System.out.println("has bad plumbing");
      }
    }
    System.out.println("------------");
  }

  // determines if the specific room inputed to the method as a 
  // String has good plumbing
  public boolean tryFlush(String room) {
    for (int i = 0; i < rooms.size(); i++) {
      if (rooms.get(i).equals(room)) {
        for (int k : goodPlumbingIndex) {
          if(i == k) {
            return true;
          }
        }
      }
    }
    return false;
  }

  // returns an ArrayList of the rooms that do have good 
  // plumbing
  public ArrayList<String> goodPlumbingRooms() {
    ArrayList<String> temp = new ArrayList<String>();
    for (int m : goodPlumbingIndex) {
      temp.add(rooms.get(m));  
    }
    return temp;
  }
}