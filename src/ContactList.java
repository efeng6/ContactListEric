import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * A class that stores subclasses of Person as a contact list.
 * The user is presented with a menu of options and may add, sort,
 * search, or list the contacts.
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick & Eric F
 * @version: 2022-2023
 */

public class ContactList
{
    private ArrayList<Person> contacts;
    Scanner s = new Scanner(System.in);



    public ContactList() {
        contacts = new ArrayList<Person>();
    }



    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    /**
     * Asks user for input to create and add a new Person
     * to the contact list
     */
    public void addContact() {
        // TODO: Complete the addContact method
        System.out.println("Select a type of contact to add:");
        System.out.println("1: Student");
        System.out.println("2: Worker");
        int typeOfPerson = 0;
        while (typeOfPerson != 1 && typeOfPerson != 2)
        {
            typeOfPerson = s.nextInt();
        }
        s.nextLine();
        System.out.println("Please fill in the following information");
        System.out.println("First Name:");
        String fname = s.nextLine();
        System.out.println("Last Name:");
        String lname = s.nextLine();
        System.out.println("Phone number:");
        String pnum = s.nextLine();
        if(typeOfPerson == 1)
        {
            System.out.println("Grade: ");
            contacts.add(new Student(fname, lname, pnum, s.nextInt()));
        }
        else
        {
            System.out.println("Job: ");
            contacts.add(new Worker(fname, lname, pnum, s.nextLine()));
        }


    }

    /**
     * Loops through and prints all contacts
     */
    public void printContacts() {
        // TODO: Complete the printContacts method
        for (Person contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    /**
     * Bubble sorts the contacts in the list by firstName,
     * lastName, or phoneNumber
     * @param sortBy: 0=firstName, 1=lastName, 2=phoneNumber
     */
    public void sort(int sortBy) {
        // TODO: Complete the sort method
        if (sortBy == 0)
        {
            for (int i = 0; i < contacts.size(); i++)
            {
                for (int j = 0; j < contacts.size() - i; j++)
                {
                    if(contacts.get(j).getFirstName().compareTo(contacts.get(j).getFirstName()) > 0)
                    {
                        Person temp = contacts.set(j + 1, contacts.get(j));
                        contacts.set(j, temp);
                    }
                }
            }
        }
        if (sortBy == 1)
        {
            for (int i = 0; i < contacts.size(); i++)
            {
                for (int j = 0; j < contacts.size() - i; j++)
                {
                    if(contacts.get(j).getLastName().compareTo(contacts.get(j).getLastName()) > 0)
                    {
                        Person temp = contacts.set(j + 1, contacts.get(j));
                        contacts.set(j, temp);
                    }
                }
            }
        }
        if (sortBy == 2)
        {
            for (int i = 0; i < contacts.size(); i++)
            {
                for (int j = 0; j < contacts.size() - i; j++)
                {
                    if(contacts.get(j).getPhoneNumber().compareTo(contacts.get(j).getPhoneNumber()) > 0)
                    {
                        Person temp = contacts.set(j + 1, contacts.get(j));
                        contacts.set(j, temp);
                    }
                }
            }
        }


    }

    // TODO: Write searchByFirstName

    // TODO: Write searchByLastName

    // TODO: Write searchByPhoneNumber

    public Person searchByFirstName(String firstName)
    {
        sort(0);

    }
    public Person searchByLastName(String lastName)
    {
        sort(1);

    }
    public Person searchByPhoneNumber(String phoneNumber)
    {
        sort(2);
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
        // TODO: Complete the listStudents method
        for (Person contact : contacts) {
            if (contact instanceof Student)
            {
                System.out.println(contact.toString());
            }

        }

    }

    /**
     * Loops providing menu options to the user
     * until the user exits
     */
    public void run() {
        System.out.println("Welcome to your Contacts List");
        System.out.println("Please pick from the following menu options");
        printMenuOptions();
        int num = s.nextInt();
        s.nextLine();
        // TODO: Complete the run method
        while (num != 0)
        {
            if(num == 1)
                addContact();
            if(num == 2){
                sort(0);
                printContacts();
            }
            if(num == 3){
                sort(1);
                printContacts();
            }
            if(num == 4){
                sort(2);
                printContacts();
            }
            if(num == 5){
                listStudents();
            }
            if(num == 6){

            }
            if(num == 7){

            }
            if(num == 8){

            }
            num = s.nextInt();
            s.nextLine();
        }
    }


    public static void main(String[] args)
    {
        ContactList cl = new ContactList();
        cl.run();
    }
}
