package com.example.roomdatabaselab.async;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.roomdatabaselab.MainActivity;
import com.example.roomdatabaselab.PersonsActivity;
import com.example.roomdatabaselab.data.LabDatabase;
import com.example.roomdatabaselab.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class GetPeopleAsync extends AsyncTask<Person, Void, List<Person>> {
    MainActivity parent;
    LabDatabase database;
    List<Person> people;
    Context context;

    public GetPeopleAsync(LabDatabase database, Context context){
        this.database = database;
        this.context = context;
    }

    @Override
    protected List<Person> doInBackground(Person... people) {
        this.people = database.personDao().getAllPersons();

        return null;
    }

    @Override
    protected void onPostExecute(List<Person> people) {
        super.onPostExecute(people);
    }
}

