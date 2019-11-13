package com.oliverstudio.roomconverterdemo.data.db.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oliverstudio.roomconverterdemo.data.models.User;

import java.lang.reflect.Type;
import java.util.List;

public class UsersConverter {

    @TypeConverter
    public String listUsersToJson(List<User> users) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<User>>() {}.getType();
        String json = gson.toJson(users, type);
        return json;
    }

    @TypeConverter
    public List<User> jsonToListUsers(String jsonListUsersAsString) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<User>>() {}.getType();
        List<User> users = gson.fromJson(jsonListUsersAsString, type);
        return users;
    }

}
