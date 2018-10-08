package fitperson.ritesh.com.thefitperson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

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
    EditText firstName;
    EditText lastName;
    EditText height;
    EditText weight;
    FirebaseAuth mAuth;
    DatabaseReference dbRef;
    Switch gender;
    boolean sexMale=true;
    RelativeLayout layout1;
    RelativeLayout layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        mAuth = FirebaseAuth.getInstance();
        layout1=findViewById(R.id.layout1);
        layout2=findViewById(R.id.layout2);

        User user = new User(getFirebaseUser(), getHeight(), getWeight(), getFirstName(), getLastName(), getDateOfBirth(), getExperience(), getMotive(), getSex());

        dbRef = FirebaseDatabase.getInstance().getReference("users");
        dbRef.child("uid").child(getFirebaseUser().getUid()).setValue(user);
        firstName=findViewById(R.id.firstName);
        lastName=findViewById(R.id.lastName);
        height=findViewById(R.id.height);
        weight=findViewById(R.id.weight);
        gender=findViewById(R.id.sex);
        gender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                    sexMale=false;
                else
                    sexMale=true;
            }
        });

    }

    public void switchLayout(View view) {
     layout1.setVisibility(View.GONE);
     layout2.setVisibility(View.VISIBLE);

    }

    String getFirstName() {

       return firstName.getText().toString();

    }

    String getLastName() {
        return lastName.getText().toString();
    }

    int getHeight() {
        return Integer.parseInt(height.getText().toString());
    }

    int getWeight() {
        return Integer.parseInt(weight.getText().toString());
    }

    Sex getSex() {
    if(sexMale)
        return Sex.male;
    else
        return Sex.female;
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
