package com.oliverstudio.roomconverterdemo.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.oliverstudio.roomconverterdemo.data.db.tables.UsersTable;

@Database(entities = {UsersTable.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "app_db";

    public abstract DaoAccess daoAccess();
}