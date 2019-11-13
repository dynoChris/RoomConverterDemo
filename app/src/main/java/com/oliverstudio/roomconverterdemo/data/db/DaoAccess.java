package com.oliverstudio.roomconverterdemo.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.oliverstudio.roomconverterdemo.data.db.tables.UsersTable;

@Dao
public interface DaoAccess {

    @Insert
    void insertUsers(UsersTable usersTable);

    @Query("SELECT * FROM " + UsersTable.TABLE_NAME)
    UsersTable queryUsers();
}
