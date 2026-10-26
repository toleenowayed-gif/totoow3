package ow.toleen.totoow.Model.giftfind;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ow.toleen.totoow.Model.MyUserTable.MyUser;
import ow.toleen.totoow.Model.Myproject.MyActorsQuery;

@Dao
public interface MygiftfindQuery {
    @Query("SELECT * FROM Mygiftfind")
    LiveData<List<MygiftfindQuery>> getAllGift();
    // استخراج مستعمل حسب رقم المميز لهid

    @Query("SELECT * FROM Mygiftfind WHERE giftid IN (:giftid)")

    LiveData<List<MygiftfindQuery>> loadAllBytypes(String[] usertype);

    @Insert
// اضافة مستعمل او مجموعة مستعملين
    void insertAll(Mygiftfind... gifts);
    // حذف @Delete// حذف
    void delete(Mygiftfind gift);
    //حذف حسب الرقم المميز id
    @Query("Delete From Mygiftfind WHERE giftid=id ")

    void delete(int id);

    //اضافة مستعمل واحد
    @Insert
    default//اضافة مستعمل واحد
    void insert(Mygiftfind mygiftfind) {

    }

    //تعديل مستعمل او قائمة مستعملين
    @Update
//تعديل مستعمل او قائمة مستعملين
    void update(Mygiftfind...values);

    LiveData<List<Mygiftfind>> getAllgifts();


    LiveData<Mygiftfind> getAllgifts(long userId);

    LiveData<List<Mygiftfind>> getgiftsBygifttype(String gifttype);

    LiveData<List<Mygiftfind>> getgiftsBygiftcolor(String giftcolor);

    LiveData<List<Mygiftfind>> getgiftsBygiftid(long giftid);

    LiveData<List<Mygiftfind>> getgiftsBygiftrecipientage(int giftrecipientage);

    LiveData<List<Mygiftfind>> getgiftsBygiftpriceAndgiftcolor(int giftprice, String giftcolor);

    void updateMygiftfind(long giftid, String gifttype, String giftcolor, int giftrecipientage, long giftid1);

    void deleteMygiftById(long giftId);
}


