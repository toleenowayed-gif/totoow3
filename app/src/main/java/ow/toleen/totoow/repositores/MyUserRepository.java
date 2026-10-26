package ow.toleen.totoow.repositores;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ow.toleen.totoow.AppDataBase;

import ow.toleen.totoow.Model.MyUserTable.MyUser;
import ow.toleen.totoow.Model.MyUserTable.MyUserQuery;

public class MyUserRepository {
    private MyUserQuery MyUserQuery;
    private LiveData<List<MyUser>> allUsers;//مبنى معطيات يحوي جميع المهلام المستخرجة

    public MyUserRepository(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        MyUserQuery = db.getMyUserQuery();
        allUsers = MyUserQuery.getAllUsers();
    }

    public LiveData<List<MyUser>> getAllUsers() {
        return allUsers;
    }

    public LiveData<List<MyUser>> getAllUsers(long keyId) {
        return MyUserQuery.getAllUsers();
    }

    public LiveData<List<MyUser>> getUsersByemail(String email) {
        return MyUserQuery.getUsersByemail(email);
    }
    public LiveData<List<MyUser>> getUsersByphone(String phone) {
        return MyUserQuery.getUsersByphone(phone);
    }
    public LiveData<List<MyUser>> getUsersBypassw(String passw) {
        return MyUserQuery.getUsersBypassw(passw);
    }
    public LiveData<List<MyUser>> getUsersBykeyIdAndphone(long keyId, String phone) {
        return MyUserQuery.getUsrsBykeyIdAndphone(keyId,phone);
    }
    public void insert(MyUser User, MyUser... Users) {
        MyUserQuery.insert(User);
    }
    public void update(MyUser... Users) {
        MyUserQuery.update(Users);
    }
    public void updateMyuser(long keyId, String email, String phone, int passw) {
       MyUserQuery.updateMyUser( keyId, email, phone, passw);
    }
    public void delete(MyUser... Users) {
        MyUserQuery.delete(Users);
    }
    public void deleteUserById(long keyId) {

        MyUserQuery.deleteMyuserById(keyId);
    }


}
