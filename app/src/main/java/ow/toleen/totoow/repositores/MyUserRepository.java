package ow.toleen.totoow.repositores;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ow.toleen.totoow.AppDataBase;
import ow.toleen.totoow.Model.MyTaskTable.MyTask;
import ow.toleen.totoow.Model.MyTaskTable.MyTaskQuery;
import ow.toleen.totoow.Model.MyUserTable.MyUser;
import ow.toleen.totoow.Model.MyUserTable.MyUserQuery;

public class MyUserRepository {
    private MyUserQuery MyUserQuery;
    private LiveData<List<MyUser>> allUsers;//مبنى معطيات يحوي جميع المهلام المستخرجة

    public MyUserRepository(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        MyUserQuery= db.getMyUserQuery();
        allUsers = MyUserQuery.getAllUsers();
    }
    public LiveData<List<MyUser>> getAllUsers() {
        return allUsers;
    }
    public LiveData<List<MyTask>> getTasksByUserId(long userId) {
        return MyUserQuery.getTasksByUserId(userId);
    }

}