package com.example.dpbsadmin.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dpbsadmin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView csDepartment,mathsDepartment,bmDepartment;
    private LinearLayout csNoData,bmNoData,mathsNoData;
    private List<TeacherData> list1, list2,list3;

    private DatabaseReference reference,dbRef;
    private TeacherAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);
        //setting up the floating button
        fab = findViewById(R.id.fab);

        csNoData= findViewById(R.id.csNoData);
        mathsNoData= findViewById(R.id.mathsNoData);
        bmNoData= findViewById(R.id.bmNoData);

        csDepartment= findViewById(R.id.csDepartment);
        mathsDepartment= findViewById(R.id.mathsDepartment);
        bmDepartment= findViewById(R.id.bmDepartment);

        reference= FirebaseDatabase.getInstance().getReference().child("teacher");
        csDepartment();
        mathsDepartment();
        bmDepartment();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UpdateFaculty.this,AddTeacher.class));
            }
        });

    }

    private void csDepartment() {

        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1= new ArrayList<>();
                if(!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }
                else {
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter= new TeacherAdapter(list1,UpdateFaculty.this,"Computer Science");
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void mathsDepartment() {

        dbRef = reference.child("Mathematics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2= new ArrayList<>();
                if(!dataSnapshot.exists()){
                    mathsNoData.setVisibility(View.VISIBLE);
                    mathsDepartment.setVisibility(View.GONE);
                }
                else {
                    mathsNoData.setVisibility(View.GONE);
                    mathsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mathsDepartment.setHasFixedSize(true);
                    mathsDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter= new TeacherAdapter(list2,UpdateFaculty.this,"Mathematics");
                    mathsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void bmDepartment() {

        dbRef = reference.child("Business Department");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3= new ArrayList<>();
                if(!dataSnapshot.exists()){
                    bmNoData.setVisibility(View.VISIBLE);
                    bmDepartment.setVisibility(View.GONE);
                }
                else {
                    bmNoData.setVisibility(View.GONE);
                    bmDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    bmDepartment.setHasFixedSize(true);
                    bmDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter= new TeacherAdapter(list3,UpdateFaculty.this,"Business Department");
                    bmDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}