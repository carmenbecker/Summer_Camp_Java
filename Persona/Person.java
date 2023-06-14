package Persona;


public class Person {

    public String myfirstName, mylastName, mycity;
    public int myage, myDNI; 

    //Constructors

    //All possible info
    public Person(String firstName, String lastName, int age, String city) {
        //ejemplo con age 
        this.myage = age; 
    }


    //Get-methods
    //cambia el return por los valores correctos  
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
            return 0; 
    }

    public String getCity() {
        return "";
    }

    //Set-methods
    public void setFirstName(String firstName) {
        //ejemplo
        this.myfirstName = firstName;
    }

    public void setLastName(String lastName) {       
    }

    public void setAge(int age) {      
    }

    public void setCity(String city) {
    }
    
}
