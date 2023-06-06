import java.io.*;
import java.util.*;
import java.net.*;
/**
 * For use in Compsci 201, P0, Duke University
 * Static utility methods for reading Person201 data
 * from files/url, checking if Person201 objects are in 
 * the same building or on the same floor, printing
 * @author Brandon Fain
 * @author Owen Astrachan
 * @author Carmen Becker Pombo 
 */

public class Person201Utilities {
    /**
     * Searches for Person201 objects in same building as a query person
     * @param people Array of Person201 objects
     * @param person Person201 object for query
     * @return List of all objects from people in the same building
     * but not equal to person
     */
    public static List<Person201> sameBuilding(Person201[] people, Person201 person) {
        List<Person201> sameDorm = new ArrayList<>();
        for (Person201 p : people) {
            if (!p.equals(person) && p.sameBuilding(person)) {
                sameDorm.add(p);
            }
        }
        return sameDorm;
    }

    /* 
     * TODO: Fix to return a List of all people who are not equal to 
     * person but are on the same floor in the same building
    */
    public static List<Person201> sameFloor(Person201[] people, Person201 person) {
        List<Person201> sameFloor = new ArrayList<>();
        for (Person201 p : people) {
            if(!p.equals(person)&& p.sameBuilding(person)==true&&p.sameFloor(person)==true) {
                sameFloor.add(p);
            }
        }
            return sameFloor;

    }

    /**
     * Reads Person201 data from a file
     * @param fname path to file to read data from. Should be formatted
     * one person per line: name, building, floor
     * @return Array of Person201 objects read from file
     * @throws IndexOutOfBoundsException if file not correctly formatted
     * @throws IOException if file not found
     */
    public static Person201[] readFile(String fname) throws IOException {
        Scanner s = new Scanner(new File(fname));
        ArrayList<Person201> list = new ArrayList<>();

        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] data = line.split(", ");
            Person201 p = new Person201(data[0], data[1], Integer.parseInt(data[2]));
            list.add(p);
        }

        s.close();
        return list.toArray(new Person201[0]);
    }

    /**
     * Reads Person201 data from a web source
     * @param url url of file to read data from. Should be formatted
     * one person per line: name, building, floor
     * @return Array of Person201 objects read from web
     * @throws IndexOutOfBoundsException if file not correctly formatted
     * @throws IOException if no file found at url
     */
    public static Person201[] readURL(String url) throws IOException {
        BufferedInputStream input = new BufferedInputStream(new URL(url).openStream());
        Scanner s = new Scanner(input);
        ArrayList<Person201> list = new ArrayList<>();

        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] data = line.split(", ");
            Person201 p = new Person201(data[0], data[1], Integer.parseInt(data[2]));
            list.add(p);
        }

        s.close();
        return list.toArray(new Person201[0]);
    }

    /**
     * Prints a list of Person201 objects, one per line, to standard out
     * @param people A list of Person201 objects
     */
    public static void printPeople(List<Person201> people) {
        for (Person201 p : people) {
            System.out.println("\t-" + p);
        }
        System.out.println();
    }

}
