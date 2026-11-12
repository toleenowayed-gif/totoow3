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

    @Query("DELETE FROM MyTask WHERE keyId=:keyid")
    void deleteTaskByid(long keyid);

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

@Query("SELECT * FROM MyTask WHERE userId=:userId AND text=:text")
    LiveData<List<MyTask>> getTasksByuserIdAndtext(long userId, String text);
    @Query("SELECT * FROM MyTask WHERE  subjId=:subjId")
    LiveData<MyTask> getTaskById(long  subjId);
    @Query("SELECT * FROM MyTask WHERE shortTitle=:shortTitle")
    LiveData<List<MyTask>> getTasksByDescription(String shortTitle);
    @Query("SELECT * FROM MyTask WHERE userId=:userId AND time=:time")
    LiveData<List<MyTask>> getTasksByUserIdAndTitle(long userId, long time);
  
    @Query("SELECT * FROM MyTask WHERE userId=:userId ")
    LiveData<List<MyTask>> getTasksByUserId(long userId);
    @Query("SELECT * FROM MyTask WHERE priority=:priority")
    LiveData<List<MyTask>> getTasksByPriority(int priority);
    @Query("DELETE  FROM MyTask WHERE taskid=:taskid")
    void deleteTaskById(long taskid);
    @Query("SELECT * FROM MyTask WHERE title=:title")
    LiveData<List<MyTask>> getTasksByTitle(String title);
    @Query("SELECT * FROM MyTask WHERE shortTitle=:shortTitle AND userId=:userId")

    LiveData<List<MyTask>> getTasksByUserIdAndshortTitle(long userId, String shortTitle);
}





