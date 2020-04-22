package com.example.roomdatabaselab.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomdatabaselab.entities.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class LabDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
}