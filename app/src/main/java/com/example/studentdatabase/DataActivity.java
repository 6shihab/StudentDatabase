package com.example.studentdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DataActivity extends AppCompatActivity {

    private List<Student> all_data;
    DatabaseReference databaseReference;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        databaseReference= FirebaseDatabase.getInstance().getReference("Students/");
        all_data = new ArrayList<>();

        tableLayout =  findViewById(R.id.dataTable);

    }

    @Override
    protected void onStart() {


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                all_data.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Student student=dataSnapshot.getValue(Student.class);
                    all_data.add(student);
                }
                showDataOnTable(all_data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        super.onStart();
    }

    private void showDataOnTable(List<Student> student_data) {

        for (Student row : student_data) {
            TableRow tableRow = new TableRow(this);
            String[] parameters = {
                    row.getStudent_id(),
                    row.getFullname(),
                    row.getDegree_title(),
                    row.getAddress(),
                    row.getPhone()
            };
            for (int i=0; i<5; i++){
                TextView textView = new TextView(this);
                textView.setText(parameters[i]);
                textView.setTextSize(18);
                textView.setPadding(10,0,10, 0);
                textView.setGravity(Gravity.CENTER);
                tableRow.addView(textView);
            }
            tableLayout.addView(tableRow);
        }
        student_data.clear();

    }
}