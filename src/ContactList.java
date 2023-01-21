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
        if (sortBy == 0)
        {
            for (int i = 0; i < contacts.size(); i++)
            {
                for (int j = 0; j < contacts.size() - i-1; j++)
                {
                    /**
                     * compares element of one person to the same of the one ahead of it
                     */
                    if(contacts.get(j).getFirstName().compareTo(contacts.get(j+1).getFirstName()) > 0)
                    {
                        Person temp = contacts.set(j + 1, contacts.get(j));
                        contacts.set(j, temp);
                    }
                }
            }
        }
        else if (sortBy == 1)
        {
            for (int i = 0; i < contacts.size(); i++)
            {
                for (int j = 0; j < contacts.size() - i-1; j++)
                {
                    /**
                     * compares element of one person to the same of the one ahead of it
                     */
                    if(contacts.get(j).getLastName().compareTo(contacts.get(j+1).getLastName()) > 0)
                    {
                        Person temp = contacts.set(j + 1, contacts.get(j));
                        contacts.set(j, temp);
                    }
                }
            }
        }
        else if (sortBy == 2)
        {
            for (int i = 0; i < contacts.size(); i++)
            {
                for (int j = 0; j < contacts.size() - i-1; j++)
                {
                    /**
                     * compares element of one person to the same of the one ahead of it
                     */
                    if(contacts.get(j).getPhoneNumber().compareTo(contacts.get(j+1).getPhoneNumber()) > 0)
                    {
                        Person temp = contacts.set(j + 1, contacts.get(j));
                        contacts.set(j, temp);
                    }
                }
            }
        }


    }

    /**
     * Linear search (lol) by first and last names, as well as phone number
     * @param firstName
     * @return
     */
    public Person searchByFirstName(String firstName)
    {
        for (Person p : contacts)
        {
            if (p.getFirstName().equals(firstName))
                return p;
        }
        return null;
    }
    public Person searchByLastName(String lastName)
    {
        for (Person p : contacts)
        {
            if (p.getLastName().equals(lastName))
                return p;
        }
        return null;
    }
    public Person searchByPhoneNumber(String phoneNumber)
    {
        for (Person p : contacts)
        {
            if (p.getPhoneNumber().equals(phoneNumber))
                return p;
        }
        return null;
    }

    /**
     * Binary search, need to sort first
     * Also not used b/c I wasn't sure if I had to use the linear or not
     * And b/c it is not tested and is kinda cruddy
     * @param target
     * @param type (same params as sort method)
     * @param low
     * @param high
     * @return
     */
    public Person search(String target, int type, int low, int high)
    {
        int mid = (low + high) / 2;
        if (type == 0)
        {
            if (contacts.get(mid).getFirstName().equals(target))
                return contacts.get(mid);
            else if (contacts.get(mid).getFirstName().compareTo(target) > 0)
                return search(target, type, mid + 1, high);
            else
                return search(target, type, low, mid - 1);
        }
        if (type == 1)
        {
            if (contacts.get(mid).getLastName().equals(target))
                return contacts.get(mid);
            else if (contacts.get(mid).getLastName().compareTo(target) > 0)
                return search(target, type, mid + 1, high);
            else
                return search(target, type, low, mid - 1);
        }
        if (type == 2)
        {
            if (contacts.get(mid).getPhoneNumber().equals(target))
                return contacts.get(mid);
            else if (contacts.get(mid).getPhoneNumber().compareTo(target) > 0)
                return search(target, type, mid + 1, high);
            else
                return search(target, type, low, mid - 1);
        }
        else
            return null;
    }

    /**
     * Lists just the Student objects in the Contact List
     */
    public void listStudents() {
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
                System.out.println("Enter a name: ");
                String str = s.nextLine();
                Person p = searchByFirstName(str);
                if(p == null)
                    System.out.println(str + " is not in the list.");
                else
                    System.out.println(p);
            }
            if(num == 7){
                System.out.println("Enter a name: ");
                String str = s.nextLine();
                Person p = searchByLastName(str);
                if(p == null)
                    System.out.println(str + " is not in the list.");
                else
                    System.out.println(p);
            }
            if(num == 8){
                System.out.println("Enter a number: ");
                String str = s.nextLine();
                Person p = searchByPhoneNumber(str);
                if(p == null)
                    System.out.println(str + " is not in the list.");
                else
                    System.out.println(p);
            }
            printMenuOptions();
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
