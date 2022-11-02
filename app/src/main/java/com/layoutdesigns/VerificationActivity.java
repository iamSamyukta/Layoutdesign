package com.layoutdesigns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VerificationActivity extends AppCompatActivity {
    private EditText regFullName,regEmailAddress,regBirthdate;
    private Button google,facebook,regNext;
    private RadioButton gender_button;
    private RadioGroup gender_group;


    FirebaseDatabase rootNode;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.brown)));
        getSupportActionBar().setTitle("Enter Profile Infromation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
        getSupportActionBar().show();

        google=findViewById(R.id.google);
        facebook=findViewById(R.id.facebook);

        regFullName=findViewById(R.id.FullName);
        regEmailAddress=findViewById(R.id.EmailAddress);
        regBirthdate=findViewById(R.id.BirthDate);
        regNext = findViewById(R.id.next);
        gender_group = findViewById(R.id.genderGroup);


        regNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");
                int selected_gender = gender_group.getCheckedRadioButtonId();
                gender_button = findViewById(selected_gender);
                String FullName = regFullName.getEditableText().toString();
                String EmailAddress = regEmailAddress.getLayout().getText().toString();
                String Birthdate = regBirthdate.getLayout().getText().toString();
                String gender = gender_button.getLayout().getText().toString();



                UserHelperClass helperClass = new UserHelperClass(FullName,EmailAddress,Birthdate,gender);


                reference.child(FullName).setValue(helperClass);

                Intent intent = new Intent(VerificationActivity.this , MainActivity2.class);
                startActivity(intent);


//                reference.setValue("First data storage");
            }
        });



                google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://accounts.google.com/accountchooser/signinchooser?flowName=GlifWebSignIn&flowEntry=AccountChooser");

            }
        });

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.facebook.com/login.php");
            }
        });
    }



    private void gotoUrl(String s)  {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));

    }
}
