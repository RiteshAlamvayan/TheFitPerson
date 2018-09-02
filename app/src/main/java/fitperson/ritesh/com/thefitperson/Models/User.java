package fitperson.ritesh.com.thefitperson.Models;

import com.google.firebase.auth.FirebaseUser;

import java.util.Date;

public class User {
    FirebaseUser user;
    // height in cm
    private int height;
    //weight in kg
    private int weight;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Experience experience;
    private Motive motive;
    private Sex sex;

    public User(FirebaseUser user,
                int height,
                int weight,
                String firstName,
                String lastName,
                Date dateOfBirth,
                Experience experience,
                Motive motive,
                Sex sex) {
        this.user = user;
        this.height = height;
        this.weight = weight;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.experience = experience;
        this.motive = motive;
        this.sex = sex;
    }
}
