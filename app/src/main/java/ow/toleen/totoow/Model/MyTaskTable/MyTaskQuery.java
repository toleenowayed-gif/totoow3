package ow.toleen.totoow.Model.MyTaskTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyTaskQuery {


    @Query("SELECT * FROM MyTask WHERE subjId = keyid ORDER BY time DESC")
    List<MyTask> getAllTasks();


    @Query("SELECT * FROM MyTask WHERE userId=:userId AND isCompleted =:isCompleted")
    LiveData<List<MyTask>>getAllTaskorderBy(long userId, boolean isCompleted);

    /**
     * إدخال مهام
     *
     * @param t مجموعة مهام
     */
    @Insert
    void insertTask(MyTask... t);

    /**
     * تعديل المهام
     * <p>
     * <p>
     * طرأ خلل، يجب استدعاء المسؤول.
     * كلمة سر المسؤو
     *
     * @param tasks مجموعة مهام للتعديل (التعديل حسب المفتاح الرئيسي)
     */

    @Update
    void updateTask(MyTask... tasks);

    /**
     * حذف مهمة أو مهام
     *
     * @param tasks حذف المهام (حسب المفتاح الرئيسي)
     */

    @Delete
    void deleteTask(MyTask... tasks);

    @Query("DELETE FROM MyTask WHERE keyId=:kid")
    void deleteTask(long kid);

    /**
     * استخراج جميع المهام التابعة لرقم الموضوع
     *
     * @param key_id رقم الموضوع
     * @return
     */

    @Query("SELECT * FROM MyTask WHERE subjId=:key_id" +

            " ORDER BY priority DESC")
    List<MyTask>getTasksBysubjId(long key_id );


  @Insert
    public void insert(MyTask... tasks);

    @Update
    public void update(MyTask... tasks);

    }





