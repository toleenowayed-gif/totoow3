package ow.toleen.totoow.Model.giftfind;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MygiftfindQuery {

    @Query("SELECT * FROM Mygiftfind  WHERE giftid =:giftid ORDER BY time DESC")
   List<Mygiftfind>getAllgifts(long giftid);

    @Insert
// اضافة مستعمل او مجموعة مستعملين
   void insert(Mygiftfind... gift);
    // حذف @Delete// حذف
   void delete(Mygiftfind... gift);
    //حذف حسب الرقم المميز id


    //اضافة مستعمل واحد

    //تعديل مستعمل او قائمة مستعملين
    @Update
//تعديل مستعمل او قائمة مستعملين
    void update(Mygiftfind...gift);


    @Query("SELECT * FROM Mygiftfind WHERE gifttype=:gifttype")
    LiveData<List<Mygiftfind>> getgiftsBygifttype(String gifttype);
    @Query("SELECT * FROM Mygiftfind WHERE giftcolor=:giftcolor")
    LiveData<List<Mygiftfind>> getgiftsBygiftcolor(String giftcolor);
    @Query("SELECT * FROM Mygiftfind WHERE giftid=:giftid")
    LiveData<List<Mygiftfind>> getgiftsBygiftid(long giftid);
    @Query("SELECT * FROM Mygiftfind WHERE giftrecipientage=:giftrecipientage")
    LiveData<List<Mygiftfind>> getgiftsBygiftrecipientage(int giftrecipientage);
    @Query("SELECT * FROM Mygiftfind WHERE giftprice=:giftprice AND giftcolor=:giftcolor")
    LiveData<List<Mygiftfind>> getgiftsBygiftpriceAndgiftcolor(int giftprice, String giftcolor);


    LiveData<List<MygiftfindQuery>> getAllgifts();


}


