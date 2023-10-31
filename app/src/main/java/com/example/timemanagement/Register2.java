package com.example.timemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Register2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Hobby> hobbies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        recyclerView = findViewById(R.id.selecHobbiesRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        hobbies = new ArrayList<>();
        hobbies.add(new Hobby("Reading"));
        hobbies.add(new Hobby("Traveling"));
        hobbies.add(new Hobby("Cooking"));
        // Add more hobbies as needed

        HobbyAdapter adapter = new HobbyAdapter(hobbies);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new HobbyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle item click here
                Hobby hobby = hobbies.get(position);
                Toast.makeText(Register2.this, "Selected hobby: " + hobby.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}