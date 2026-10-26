package ow.toleen.totoow.Model.giftfind;

import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.util.List;

public class Mygiftfind {
    @PrimaryKey(autoGenerate = true)//تحديد الصفة كمفتاح رئيسي والذي يُنتجح بشكل تلقائي
    public int giftprice;

    public String gifttype;
    public int giftrecipientage;

    public String giftcolor;

    public long giftid;


    public static LiveData<List<Mygiftfind>> getAllgifts() {
        return null;
    }
}



