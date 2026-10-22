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

}
