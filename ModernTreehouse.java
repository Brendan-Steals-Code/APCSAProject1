/*
Preconditions: The correct ArrayList for the rooms has been inputted into the argument as well as the integer array for the index of the rooms with good electrical and the resident's name. The fact that the object is a ModernHouse allows this class to already assume that the plumbing is working fine on all of the rooms.

Postconditions: Any ModernTreehouse objects are easilly able to test the plumbing and electrical of each room as well as randomizing the order of the ArrayList of the rooms.
*/

import java.util.ArrayList;

// is a subclass of the Treehouse class
public class ModernTreehouse extends Treehouse {
  // declaring the variables specific to modern treehouse and
  // not already in treehouse
  private int[] goodElectricalIndex;
  private boolean goodElectrical;

  // Takes in the room ArrayList and uses the super keyword to 
  // store it in the Treehouse upper class along with the 
  // resident's name. An int array of the electricity  is stored 
  // and it is assumed that the plumbing is perfect because it 
  // is a modern treehouse.
  ModernTreehouse(ArrayList<String> r, int[] elec, String res)
  {
    super.rooms = r;
    int[] tempInd = new int[rooms.size()];
    for (int n = 0; n < rooms.size(); n++) {
      tempInd[n] = n;
    }
    super.goodPlumbingIndex = tempInd;
    super.resident = res;
    super.goodPlumbing = true;
    goodElectricalIndex = elec;
    if (goodElectricalIndex.length > (rooms.size()/2)) {
      goodElectrical = true;
    } else {
      goodElectrical = false;
    }
  }

  // Prints out declaring the quality of the electrical and 
  // returns the boolean value
  public boolean getGoodElectrical() {
    System.out.print("Does this treehouse have good electrical: ");
    if(goodElectrical) {
      System.out.println("yes");
    } else {
      System.out.println("no");
    }
    return goodElectrical;
  }

  // Returns whether or not the String inputted is a room with 
  // good electrical
  public boolean getGoodElectrical(String ro) {
    for(int p : goodElectricalIndex) {
      if(super.rooms.get(p).equals(ro)) {
        return true;
      }
    }
    return false;
  }

  // Attempts to flush, but if the electrical is bad then it 
  // causes a treehouse fire!
  public boolean tryFlush(String room) {
    if(getGoodElectrical(room)) {
      return true;
    }
    System.out.print("Uh oh! Electrical fire!!");
    return false;
  }

  // Returns an ArrayList of all of the rooms with good 
  // electrical
  public ArrayList<String> goodElectricalRooms() {
    ArrayList<String> temp = new ArrayList<String>();
    for (int m : goodElectricalIndex) {
      temp.add(super.rooms.get(m));  
    }
    return temp;
  }

  // Prints out the rooms in order and tests the electrical and 
  // plumbing by flushing in each room and printing the results.
  public void printRooms() {
    System.out.println("------------");
    for (String j : rooms) {
      System.out.print(j + " - ");
      if(tryFlush(j)) {
        System.out.println("has good electrical");
      } else {
        System.out.println(" -  has bad electrical");
      }
    }
    System.out.println("------------");
  }

}