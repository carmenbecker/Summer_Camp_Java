package Persona;


public class Person {

    public String firstName, lastName, city;
    public int age, DNI; 

    //Constructors

    //All possible info
    public Person(String firstName, String lastName, int age, String city) {
        //ejemplo con age 
        this.age = age; 
    }

    //Methods

    //Get-methods
    //cambia el return 
    public String getName() {
        return "";
    }

    public String getFirstName() {
        return "";
    }

    public String getLastName() {
        return "";
    }

    public int getAge() {
            return 0; //Return 0 if no age is defined
    }

    public String getCity() {
        return "";
    }

    //Set-methods
    public void setFirstName(String firstName) {
        //ejemplo
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {       
    }

    public void setAge(int age) {      
    }

    public void setCity(String city) {
    }


}