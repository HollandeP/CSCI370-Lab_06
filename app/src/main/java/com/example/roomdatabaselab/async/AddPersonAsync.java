package com.example.roomdatabaselab.async;

import android.os.AsyncTask;

import com.example.roomdatabaselab.data.LabDatabase;
import com.example.roomdatabaselab.entities.Person;

public class AddPersonAsync extends AsyncTask<Person, Void, Void> {
    private LabDatabase database;

    public AddPersonAsync(LabDatabase database){
        this.database = database;
    }

    @Override
    protected Void doInBackground(Person... people) {
        database.personDao().insertPerson(people[0]);
        return null;
    }
}
