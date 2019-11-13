package com.oliverstudio.roomconverterdemo.data.db.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.oliverstudio.roomconverterdemo.data.db.converters.UsersConverterWithCompressing;
import com.oliverstudio.roomconverterdemo.data.models.User;

import java.util.List;

@Entity(tableName = UsersTable.TABLE_NAME)
public class UsersTable {

    public static final String TABLE_NAME = "users_table";

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "users")
    @TypeConverters({UsersConverterWithCompressing.class})
    private List<User> mUserList;

    public UsersTable(List<User> userList) {
        mUserList = userList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUserList() {
        return mUserList;
    }

    public void setUserList(List<User> userList) {
        mUserList = userList;
    }
}