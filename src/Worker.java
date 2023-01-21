import java.util.ArrayList;

public class Worker extends Person{
    private String job;

    public String getJob() {
        return job;
    }

    public Worker(String firstName, String lastName, String phoneNumber, String job) {
        super(firstName, lastName, phoneNumber);
        this.job = job;


    }

    @Override
    /**
     * Person's toString plus some stuff
     */
    public String toString()
    {
        return super.toString() + " Job: " + job;
    }





}
