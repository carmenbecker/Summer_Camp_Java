import java.util.List;
import java.io.IOException;

public class Person201Finder {
    public static void main(String[] args) throws IOException {
        Person201 query = new Person201("Carmen", "Trinity", 3);
        Person201[] people = Person201Utilities.readURL("https://courses.cs.duke.edu/compsci201/spring23/notes/people.txt");
        
        System.out.println("\nSearching for people near " + query.getName() + "\n");
        
        System.out.println("People on the same floor: ");
        List<Person201> sameFloor = Person201Utilities.sameFloor(people, query);
        Person201Utilities.printPeople(sameFloor);

        System.out.println("People in the same building: ");
        List<Person201> sameBuilding = Person201Utilities.sameBuilding(people, query);
        Person201Utilities.printPeople(sameBuilding);

    }
    
}
