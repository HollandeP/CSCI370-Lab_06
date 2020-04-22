package com.example.roomdatabaselab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.roomdatabaselab.async.AddPersonAsync;
import com.example.roomdatabaselab.async.GetPeopleAsync;
import com.example.roomdatabaselab.data.LabDatabase;
import com.example.roomdatabaselab.entities.Person;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
LabDatabase labDatabase;
Button submit;
Button listPeople;
EditText nameInput;
Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labDatabase = Room.databaseBuilder(this, LabDatabase.class, "Persons").build();
        submit = findViewById(R.id.submitName);
        listPeople = findViewById(R.id.listPeople);
        nameInput = findViewById(R.id.nameInput);
        final Intent i = new Intent(getApplicationContext(), PersonsActivity.class);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person = new Person(nameInput.getText().toString());
                new AddPersonAsync(labDatabase).execute(person);
            }
        });

        listPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetPeopleAsync temp = new GetPeopleAsync(labDatabase, getApplicationContext());
                try {
                    List<Person> people = temp.get();ArrayList<String> personNames = new ArrayList<>();
                    for(Person p: people) {
                        personNames.add(p.getName());
                    }

                    Intent i = new Intent(getApplicationContext(), PersonsActivity.class);
                    i.putExtra("Persons", personNames);
                    getApplicationContext().startActivity(i);
                }
                catch (Exception ex){
                    System.out.println("Error: " + ex.getMessage());
                }

            }
        });


    }
}
