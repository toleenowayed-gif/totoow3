package ow.toleen.totoow.data.MyUserTable;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface MyUserQuery {
    /**
     * واجهة تحوي عمليات\دوال\استعلامات على قاعدة البيانات
     */
    @Dao//لتحديد ان الواجهة تحتوي استعلامات على قاعدة بيانات
    public interface myUserQuery
    {   //استخراج جميع المستعملين
        @Query("SELECT * FROM MyUser")

        List<Myuser.MyUser> getAll();
        // استخراج مستعمل حسب رقم المميز لهid

        @Query("SELECT * FROM MyUser WHERE keyid IN (:userIds)")
        List<Myuser.MyUser> loadAllByIds(int[] userIds);
        //هل المستعمل موجود حسب الايميل وكلمة السر
        @Query("SELECT * FROM MyUser WHERE email = :myEmail AND passw = :myPassw LIMIT 1")

        Myuser.MyUser checkEmailPassw(String myEmail, String myPassw);
        //فحص هل الايميل موجود من قبل
        @Query("SELECT * FROM MyUser WHERE email = :myEmail LIMIT 1")

        Myuser.MyUser checkEmail(String myEmail);
        // اضافة مستعمل او مجموعة مستعملين
        @Insert
// اضافة مستعمل او مجموعة مستعملين
        void insertAll(Myuser.MyUser... users);
        // حذف @Delete// حذف
        void delete(Myuser.MyUser user);
        //حذف حسب الرقم المميز id
        @Query("Delete From MyUser WHERE keyid=:id ")

        void delete(int id);
        //اضافة مستعمل واحد
        @Insert//اضافة مستعمل واحد
        void insert(Myuser.MyUser myUser);
        //تعديل مستعمل او قائمة مستعملين
        @Update
//تعديل مستعمل او قائمة مستعملين
        void update(Myuser.MyUser...values);
    }


}
