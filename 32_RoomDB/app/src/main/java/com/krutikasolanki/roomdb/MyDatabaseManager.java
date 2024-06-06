package com.krutikasolanki.roomdb;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Contact.class, version = 1,exportSchema = false)
public abstract class MyDatabaseManager extends RoomDatabase {
    private static final String DB_NAME="ContactsDB";
    private static MyDatabaseManager instance;
    public static synchronized MyDatabaseManager getMyDatabaseManager(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context,MyDatabaseManager.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract ContactDao contactDao();
}
