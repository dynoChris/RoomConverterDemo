package com.oliverstudio.roomconverterdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.oliverstudio.roomconverterdemo.data.db.AppDatabase;
import com.oliverstudio.roomconverterdemo.data.db.tables.UsersTable;
import com.oliverstudio.roomconverterdemo.data.models.User;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    AppDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getAppComponent().inject(this);

        List<User> userList = new ArrayList<>();
        User user = new User("Petr", 36);
        for (int i = 0; i < 100; i++) {
            userList.add(user);
        }

        UsersTable usersTable = new UsersTable(userList);
        mDatabase.daoAccess().insertUsers(usersTable);

        UsersTable queriedUsers = mDatabase.daoAccess().queryUsers();

        Log.d("ptg", "size: " + queriedUsers.getUserList().size());
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();

    }
}