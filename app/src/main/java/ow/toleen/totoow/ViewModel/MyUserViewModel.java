package ow.toleen.totoow.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ow.toleen.totoow.Model.MyUserTable.MyUser;
import ow.toleen.totoow.repositores.MyUserRepository;

public class MyUserViewModel extends AndroidViewModel {
    private MyUserRepository repository;
    private LiveData<List<MyUser>> allusers;

    public MyUserViewModel(@NonNull Application application) {
        super(application);
        repository = new MyUserRepository(application);
        allusers = repository.getAllUsers();
    }

    public LiveData<List<MyUser>> getAllusers() {
        return allusers;
    }

    public LiveData<List<MyUser>> getUserBykeyId(long keyId) {
        return repository.getUserByUserId(keyId);
    }
    public LiveData<List<MyUser>> getuserByfullName(String fullName) {
        return repository.getUserByfullName(fullName);
    }
    public LiveData<List<MyUser>> getuserByemail(String email) {
        return repository.getuserByemail(email);
    }
    public LiveData<List<MyUser>> getuserByphone(String phone) {
        return repository.getuserByphone(phone);
    }
    public LiveData<List<MyUser>> getuserBypassw(String passw) {
        return repository.getuserBypassw(passw);
    }
    public LiveData<List<MyUser>> getuserBykeyIdAndfullName(long KeyId, String fullName) {
        return repository.getuserBykeyIdAndfullName(KeyId,fullName );
    }
    public void insert(MyUser users) {
        repository.insert(users);
    }
    public MyUser getUserByEmail(String email) {
        return repository.getUserByEmail(email);
    }

    public MyUser login(String email, String password) {
        return repository.login(email, password);
    }

    public void update(MyUser... users) {
        repository.update(users);
    }
    public void updateUser(long keyId, String fullName, String email, String phone,String passw ) {
        repository.updateUser(keyId, fullName, email,phone,passw);
    }
    public void delete(MyUser... users) {
        repository.delete(users);
    }
    public void deleteUserBykeyId(long keyId) {
        repository.deleteUserBykeyId(keyId);
    }
}
