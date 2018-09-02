package fitperson.ritesh.com.thefitperson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import fitperson.ritesh.com.thefitperson.Models.Experience;
import fitperson.ritesh.com.thefitperson.Models.Motive;
import fitperson.ritesh.com.thefitperson.Models.Sex;
import fitperson.ritesh.com.thefitperson.Models.User;


public class DataEntry extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        mAuth = FirebaseAuth.getInstance();

        implementingAllTheUI();

        User user = new User(getFirebaseUser(), getHeight(), getWeight(), getFirstName(), getLastName(), getDateOfBirth(), getExperience(), getMotive(), getSex());

        dbRef = FirebaseDatabase.getInstance().getReference("users");
        dbRef.child("uid").child(getFirebaseUser().getUid()).setValue(user);

    }

    private void implementingAllTheUI() {
    }

    String getFirstName() {
        return null;
    }

    String getLastName() {
        return null;
    }

    int getHeight() {
        return 0;
    }

    int getWeight() {
        return 0;
    }

    Sex getSex() {
        return null;
    }

    Motive getMotive() {
        return null;
    }

    Experience getExperience() {
        return null;
    }

    Date getDateOfBirth() {
        return null;
    }

    FirebaseUser getFirebaseUser() {
        return mAuth.getCurrentUser();
    }

}
