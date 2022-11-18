package com.example.studentdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button insertButton,viewButton;
    EditText student_idET,fullnameET,degree_titleET,addressET,phoneET;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databaseReference= FirebaseDatabase.getInstance().getReference("Students/");

        setContentView(R.layout.activity_main);
        insertButton=findViewById(R.id.buttonID);
        viewButton=findViewById(R.id.button2ID);

        student_idET=findViewById(R.id.student_idEditID);
        fullnameET=findViewById(R.id.fullnameEditID);
        degree_titleET=findViewById(R.id.degree_titleEditID);
        addressET=findViewById(R.id.addressEditID);
        phoneET=findViewById(R.id.phoneEditID);

        insertButton.setOnClickListener(this);
        viewButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.buttonID){
            saveData();
        }
        if (view.getId()==R.id.button2ID){
            Intent intent=new Intent(getApplicationContext(),DataActivity.class);
            startActivity(intent);
            overridePendingTransition(0,0);
        }

    }

    private void saveData() {
        String id=databaseReference.push().getKey();
        String student_id=student_idET.getText().toString().trim();
        String fullname=fullnameET.getText().toString().trim();
        String degree_title =degree_titleET.getText().toString().trim();
        String address=addressET.getText().toString().trim();
        String phone=phoneET.getText().toString().trim();
        if(student_id.matches("")|| fullname.matches("")){
            Toast.makeText(getApplicationContext(),"Please Enter Student ID and FUllname",Toast.LENGTH_LONG).show();
        }
        else{
            Student student=new Student(id,student_id,fullname,degree_title,address,phone);
            databaseReference.child(id).setValue(student);
            Toast.makeText(getApplicationContext(),"Data Added To Firebase",Toast.LENGTH_SHORT).show();
        }


    }
}