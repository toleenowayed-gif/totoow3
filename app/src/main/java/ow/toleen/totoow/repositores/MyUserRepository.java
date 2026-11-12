package ow.toleen.totoow.repositores;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ow.toleen.totoow.Model.AppDataBase;

import ow.toleen.totoow.Model.MyUserTable.MyUser;
import ow.toleen.totoow.Model.MyUserTable.MyUserQuery;

public class MyUserRepository {
    private MyUserQuery MyUserQuery;
    private List<MyUser> allUsers;//مبنى معطيات يحوي جميع المهلام المستخرجة

    public MyUserRepository(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        MyUserQuery = db.getMyUserQuery();
        allUsers = MyUserQuery.getAll();
    }

    public LiveData<List<MyUser>> getAllUsers() {
        return allUsers;
    }

    public List<MyUser> getAllUsers(long keyId) {
        return MyUserQuery.getAll();
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
    public void insert(MyUser Users) {
        MyUserQuery.insert(Users);
    }
    public void update(MyUser... Users) {
        MyUserQuery.update(Users);
    }
    public void updateMyuser(long keyId, String email, String phone, int passw) {

    }
    public void delete(MyUser... Users) {
        MyUserQuery.delete(Users);
    }
    public void deleteUserById(long keyId) {

        MyUserQuery.deleteMyuserById(keyId);
    }



    public LiveData<List<MyUser>> getUserByUserId(long userId) {
        return null;
    }


    public LiveData<List<MyUser>> getUserByfullName(String fullName) {
        return null;
    }

    public LiveData<List<MyUser>> getuserByemail(String email) {
        return null;
    }

    public LiveData<List<MyUser>> getuserByphone(String phone) {
        return null;
    }

    public LiveData<List<MyUser>> getuserBykeyIdAndfullName(long keyId, String fullName) {
        return null;
    }

    public LiveData<List<MyUser>> getuserBypassw(String passw) {
        return null;
    }

    public void updateUser(long keyId, String fullName, String email, String phone, String passw) {
    }

    public void deleteUserBykeyId(long keyId) {
    }
    public MyUser getUserByEmail(String email) {
        return MyUserRepository.getMyUserByEmail(email);
    }

    private static MyUser getMyUserByEmail(String email) {
        return null;
    }

    public MyUser login(String email, String password) {
        return null;
    }
}

