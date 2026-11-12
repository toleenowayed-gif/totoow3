package ow.toleen.totoow.Model.MyUserTable;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


/**
     * واجهة تحوي عمليات\دوال\استعلامات على قاعدة البيانات
     */
    @Dao//لتحديد ان الواجهة تحتوي استعلامات على قاعدة بيانات
    public interface MyUserQuery
    {   //استخراج جميع المستعملين
        @Query("SELECT * FROM MyUser")

        LiveData<List<MyUser>> getAll();
        // استخراج مستعمل حسب رقم المميز لهid

        @Query("SELECT * FROM MyUser WHERE keyid IN (:userIds)")
        LiveData<List<MyUser>> loadAllByIds(int[] userIds);
        //هل المستعمل موجود حسب الايميل وكلمة السر
        @Query("SELECT * FROM MyUser WHERE email = :myEmail AND passw = :myPassw LIMIT 1")

        MyUser checkEmailPassw(String myEmail, String myPassw);
        //فحص هل الايميل موجود من قبل
        @Query("SELECT * FROM MyUser WHERE email = :myEmail LIMIT 1")

        MyUser checkEmail(String myEmail);
        // اضافة مستعمل او مجموعة مستعملين
        @Insert
// اضافة مستعمل او مجموعة مستعملين
        void insertAll(MyUser... users);
        @Delete
        // حذف @Delete// حذف
        public void delete(MyUser user);
        //حذف حسب الرقم المميز id
        @Query("Delete From MyUser WHERE keyid=:id ")

        public void delete(int id);

        //اضافة مستعمل واحد
        @Insert
        default//اضافة مستعمل واحد
        void insert(MyUser myUser) {

        }

        //تعديل مستعمل او قائمة مستعملين
        @Update
//تعديل مستعمل او قائمة مستعملين
       public void update(MyUser...values);

       @Update
       public void updateMyUser(MyUser m);
        @Delete
        public void delete(MyUser... users);
        @Delete
        public void deleteMyuserById(MyUser... users);

@Query("SELECT * FROM MyUser WHERE keyId=:keyId AND phone=:phone")
        LiveData<List<MyUser>> getUsrsBykeyIdAndphone(long keyId, String phone);
        @Query("SELECT * FROM MyUser WHERE email=:email")
        LiveData<List<MyUser>> getUsersByemail(String email);
        @Query("SELECT * FROM MyUser WHERE phone=:phone")
        LiveData<List<MyUser>> getUsersByphone(String phone);
        @Query("SELECT * FROM MyUser WHERE passw=:passw")
        LiveData<List<MyUser>> getUsersBypassw(String passw);
        @Query("DELETE  FROM MyUser WHERE keyId=:keyId")

        void deleteMyuserById(long keyId);
    }



