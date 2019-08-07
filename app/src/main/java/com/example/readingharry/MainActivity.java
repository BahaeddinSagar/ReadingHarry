package com.example.readingharry;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("movies");


    }

    public void getdata(View view) {
        final ArrayList<String> movieNames = new ArrayList<>();
        final ArrayList<CoolMovie> movies = new ArrayList<>();
        final ListView listView = findViewById(R.id.listView);
        //read data only once
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childMovie : dataSnapshot.getChildren()) {
                    String name = childMovie.child("name").getValue(String.class);
                    CoolMovie mov = childMovie.getValue(CoolMovie.class);
                    Log.d("TAG", "onDataChange: " + mov.year);
                    movies.add(mov);
                    movieNames.add(name);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this
                        , android.R.layout.simple_list_item_1, movieNames);
                listView.setAdapter(adapter);
                Log.d("TAG", "onDataChange: " + movies.size());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("theDataIs", "onCancelled: " + databaseError);
            }
        });


    }


    public void addData(View view) {
        CoolMovie movie = new CoolMovie("image http",
                "http","A semi good movie",
                "Fantastic beasts",2012);
        reference.child("10").setValue(movie);
    }
}
