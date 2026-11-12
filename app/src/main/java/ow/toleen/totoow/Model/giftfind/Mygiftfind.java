package ow.toleen.totoow.Model.giftfind;
import androidx.room.Entity;
import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;import androidx.room.Entity;
@Entity
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

    public int getGiftprice() {
        return giftprice;
    }

    public void setGiftprice(int giftprice) {
        this.giftprice = giftprice;
    }

    public String getGifttype() {
        return gifttype;
    }

    public void setGifttype(String gifttype) {
        this.gifttype = gifttype;
    }

    public int getGiftrecipientage() {
        return giftrecipientage;
    }

    public void setGiftrecipientage(int giftrecipientage) {
        this.giftrecipientage = giftrecipientage;
    }

    public String getGiftcolor() {
        return giftcolor;
    }

    public void setGiftcolor(String giftcolor) {
        this.giftcolor = giftcolor;
    }

    public long getGiftid() {
        return giftid;
    }

    public void setGiftid(long giftid) {
        this.giftid = giftid;
    }
}



