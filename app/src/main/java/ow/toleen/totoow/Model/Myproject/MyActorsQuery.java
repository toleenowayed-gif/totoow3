package ow.toleen.totoow.Model.Myproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ow.toleen.totoow.Model.MyUserTable.MyUserQuery;

@Dao
public interface MyActorsQuery {
    @Query("SELECT * FROM MyProject")
    List<MyActorsQuery> getAll();
    // استخراج مستعمل حسب رقم المميز لهid

    @Query("SELECT * FROM MyProject WHERE Actorid IN (:userIds)")
    List<MyActorsQuery> loadAllByIds(int[] userIds);

    //هل المستعمل موجود حسب الايميل وكلمة السر
    @Query("SELECT * FROM MyProject WHERE fullname = :Actorfullname AND Actorid= :Actorid LIMIT 1")
    MyActorsQuery checkfullnameActorid(String fullname, long Actorid);

    //فحص هل الايميل موجود من قبل
    @Query("SELECT * FROM MyProject WHERE Actorid= :Actorid LIMIT 1")
    MyActorsQuery checkEmail(String myEmail);

    // اضافة مستعمل او مجموعة مستعملين
    @Insert
// اضافة مستعمل او مجموعة مستعملين
    void insertAll(MyActorsQuery.MyProject... users);
    public class MyProject {
    }
    void delete(MyActorsQuery.MyProject user);
    //حذف حسب الرقم المميز id
    @Query("Delete From MyProject WHERE Actorid=:id ")

    void delete(int id);

    //اضافة مستعمل واحد
    @Insert
    default//اضافة مستعمل واحد
    void insert(MyActorsQuery.MyProject myProject) {

    }

    //تعديل مستعمل او قائمة مستعملين
    @Update
//تعديل مستعمل او قائمة مستعملين
    void update(MyActorsQuery.MyProject...values);


}

// حذف @Delete// حذف

