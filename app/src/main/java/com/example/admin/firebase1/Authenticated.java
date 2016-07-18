package com.example.admin.firebase1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Authenticated extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticated);

        tv = ((TextView) findViewById(R.id.textView));

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("FTS");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tv.setText(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Authenticated.this, "Error reading data", Toast.LENGTH_LONG);
            }
        });



    }

    public void saveData(View view) {
        myRef.setValue(tv.getText().toString(), tv.getText().toString());
    }
}
