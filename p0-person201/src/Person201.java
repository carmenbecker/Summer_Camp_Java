/**
 * For use in Compsci 201, P0, Duke University
 * @author Brandon Fain
 * @author Carmen Becker Pombo 
 * To be modified by students in 201. 
 * when you make a modification, add yourself 
 * as an author in these comments.
 */

 public class Person201 {

    private String myName;          // name of person or anonymous
    private String myBuilding;      // building where person is
    private int myFloor;            // floor number within building  

    /**
     * Default constructor
     */
    public Person201(){
        myName = "no-name";
        myBuilding = "no-building";
        myFloor = -1;
    }

    /**
     * Construct Person201 object with information
     * @param name preferred name/nickname of person or anonymous
     * @param building common name of building where you can be found
     * @param floor which floor is your room
     */
    public Person201(String name, String building, int floor) {
        myName = name;
        myBuilding = building;
        myFloor = floor;
    }

    /**
     * @return this person's name
     */
    public String getName(){
        return myName;
    }

    /**
     * @param other A person
     * @return true if other and this person are in
     * the same building, else false
     */
    public boolean sameBuilding (Person201 other) {
        
        String buildingA = myBuilding.toLowerCase();
        String buildingB = other.myBuilding.toLowerCase();
        if (buildingA.equals(buildingB)) {
            return true;
        }
        return false;
    }

    /** 
     * TODO: Fix so that returns true only if other has the
     * same building AND the same floor.
    */
    public boolean sameFloor(Person201 other) {

        String buildingA = myBuilding.toLowerCase();
        String buildingB = other.myBuilding.toLowerCase();
        if (buildingA.equals(buildingB) && (myFloor==other.myFloor) ){
            return true;
        }
        return false;
    }

        

    /**
     * Two Person201 objects are considered equal
     * if they have the same name, building, and floor
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Person201 otherPerson = (Person201) other;
        if (this.myName.equals(otherPerson.myName) && this.sameFloor(otherPerson)) {
            return true;
        }
        return false;
    }

    /**
     * Person201 objects print in the following format:
     * myName, myBuilding, myFloor
     */
    @Override
    public String toString(){
        return myName + ", " + myBuilding + ", " + Integer.toString(myFloor);
    }
}
