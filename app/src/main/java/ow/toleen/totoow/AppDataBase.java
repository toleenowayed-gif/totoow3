package ow.toleen.totoow;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ow.toleen.totoow.Model.MyTaskTable.MyTask;
import ow.toleen.totoow.Model.MyTaskTable.MyTaskQuery;
import ow.toleen.totoow.Model.MyUserTable.MyUser;
import ow.toleen.totoow.Model.MyUserTable.MyUserQuery;

    @Database(entities = {MyUser.class, MyTaskQuery.MySubject.class, MyTask.class}, version = 1)
    public abstract  class AppDataBase extends RoomDatabase
    {
        private static  AppDataBase db;

        public abstract MyUserQuery getMyUserQuery();

        public abstract MyTaskQuery.MySubjectQuery getMySubjectQuery();

        public abstract MyTaskQuery getMyTaskQuery();

        public static AppDataBase getDB(Context context)
        {
            if (db == null)
            {
                db = Room.databaseBuilder(
                                context,
                                AppDataBase.class,
                                "ToleenDataBase")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build();
            }
            return db;
        }
    }
