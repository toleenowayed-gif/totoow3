package ow.toleen.totoow.repositores;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ow.toleen.totoow.AppDataBase;
import ow.toleen.totoow.Model.MyUserTable.MyUser;
import ow.toleen.totoow.Model.MyUserTable.MyUserQuery;
import ow.toleen.totoow.Model.giftfind.Mygiftfind;
import ow.toleen.totoow.Model.giftfind.MygiftfindQuery;

public class MygiftfindRepository {
    private MygiftfindQuery MygiftfindQuery;
    private LiveData<List<MygiftfindQuery>> allgifts;
    public MygiftfindRepository(Application application) {
        AppDataBase db = AppDataBase.getDB(application);
        MygiftfindQuery = db.getGiftFindQuery();
        allgifts = MygiftfindQuery.getAllGift();
    }
    public LiveData<List<MygiftfindQuery>> getAllgifts() {
        return allgifts;
    }

    public LiveData<List<Mygiftfind>> getAllgifts(int giftprice) {
        return Mygiftfind.getAllgifts();
    }

    public LiveData<List<Mygiftfind>> getgiftsBygifttype(String gifttype) {
        return MygiftfindQuery.getgiftsBygifttype(gifttype);
    }
    public LiveData<List<Mygiftfind>> getgiftsBygifttype(int giftrecipientage ) {
        return MygiftfindQuery.getgiftsBygiftrecipientage(giftrecipientage);
    }
    public LiveData<List<Mygiftfind>> getgiftsBygiftcolor(String giftcolor) {
        return MygiftfindQuery.getgiftsBygiftcolor(giftcolor);
    }
    public LiveData<List<Mygiftfind>> getgiftsBygiftid(long giftid) {
        return MygiftfindQuery.getgiftsBygiftid(giftid);
    }
    public LiveData<List<Mygiftfind>> getgiftsBygiftpriceAndgiftcolor(int giftprice, String giftcolor) {
        return MygiftfindQuery.getgiftsBygiftpriceAndgiftcolor(giftprice,giftcolor);
    }
    public void insert(Mygiftfind... gifts) {
        MygiftfindQuery.insert(gifts);
    }
    public void update(Mygiftfind... gifts) {
        MygiftfindQuery.update(gifts);
    }
    public void updateMygiftfind(int giftprice, String email, String phone, int passw) {
        MyUserQuery.updateMyuser(keyId,email, phone,passw);
    }
    public void delete(MyUser... Users) {
        MyUserQuery.delete(Users);
    }
    public void deleteTaskById(long keyId) {
        MyUserQuery.deleteMyuserById(keyId);
    }


}

