package com.example.diacry;

import com.google.android.gms.tasks.Task;
import  com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOUser {
    private DatabaseReference dbRef;

    public DAOUser(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        dbRef = db.getReference(User.class.getSimpleName());
    }

    public Task<Void> add(User user){
       // if(user == null) throw execption jei neegzistuoja ar pan
       return  dbRef.push().setValue(user);
    }
}
