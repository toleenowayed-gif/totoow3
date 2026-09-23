package ow.toleen.totoow.Model.Myproject;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class MyActorsTable {
    @PrimaryKey(autoGenerate = true)//تحديد الصفة كمفتاح رئيسي والذي يُنتجح بشكل تلقائي
    public long actorid;
    @ColumnInfo(name = "full_Name")//اعطاء اسم جديد للعامود-الصفة في الجدول
    public String fullName;
    public int age;//بحالة لم يتم اعطاء اسم للعامود يكون اسم الصفه هو اسم العامود
    public int moviecount;


}
