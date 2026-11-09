package ow.toleen.totoow.Model.MyTaskTable;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ow.toleen.totoow.Model.MyUserTable.MyUser;

@Dao
public interface MyTaskQuery {


    @Query("SELECT * FROM MyTask WHERE keyid = keyid ORDER BY time DESC")
    List<MyTask> getAllTaskOrederBykeyid(long keyid);


    @Query("SELECT * FROM MyTask WHERE keyid=keyid AND isCompleted = isCompleted")
    List<MyTask> getAllTaskOrederBykeyidandiscompleted(long keyid, boolean isCompleted);

    /**
     * إدخال مهام
     *
     * @param t مجموعة مهام
     */
    @Insert
   public void insertTask(MyTask... t);

    /**
     * تعديل المهام
     *
     * @param taskId
     * @param title
    طرأ خلل، يجب استدعاء المسؤول.
    كلمة سر المسؤو
     * @param description
     * @param priority
     * @param tasks       مجموعة مهام للتعديل (التعديل حسب المفتاح الرئيسي)
     */

    @Update
   public void updateTask(long taskId, String title, String description, int priority, MyTask... tasks);

    /**
     * حذف مهمة أو مهام
     *
     * @param tasks حذف المهام (حسب المفتاح الرئيسي)
     */

    @Delete
    public void deleteTask(MyTask... tasks);

    @Query("DELETE FROM MyTask WHERE keyId=:kid")
    public void deleteTask(long kid);

    /**
     * استخراج جميع المهام التابعة لرقم الموضوع
     *
     * @param key_id رقم الموضوع
     * @return
     */

    @Query("SELECT * FROM MyTask WHERE subjId=:key_id" +

            " ORDER BY importance DESC")
    List<MyTask> getTasksBySubjId(long key_id);


    @Query("SELECT * FROM MyTask WHERE useriId=:userId" +

            " ORDER BY importance DESC")


    @Query("SELECT * FROM MyTask WHERE  priority=:priority" +

            " ORDER BY importance DESC")
    LiveData<List<MyTask>> getTasksByPriority(int priority);
    @Query("SELECT * FROM MyTask WHERE  userId=:userId and title=:title" +

            " ORDER BY importance DESC")
    LiveData<List<MyTask>> getTasksByUserIdAndTitle(long userId, String title);
    @Query("SELECT * FROM MyTask WHERE  tasks=:tasks" +

            " ORDER BY importance DESC")
    public void insert(MyTask[] tasks);
    @Query("SELECT * FROM MyTask WHERE tasks=:tasks" +

            " ORDER BY importance DESC")
    public void update(MyTask[] tasks);
    @Query("SELECT * FROM MyTask WHERE  tasks=:tasks" +

            " ORDER BY importance DESC")
    public void delete(MyTask[] tasks);
    @Query("SELECT * FROM MyTask WHERE  taskId=:taskId" +

            " ORDER BY importance DESC")
   public void deleteTaskById(long taskId);
}





