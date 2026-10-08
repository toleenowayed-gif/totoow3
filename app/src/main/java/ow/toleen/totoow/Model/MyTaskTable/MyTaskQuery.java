package ow.toleen.totoow.Model.MyTaskTable;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface MyTaskQuery {


    @Query(value = "SELECT * FROM MyTask ORDER BY importance DESC")
    List<MyTask> getAllTasks();


    @Query("SELECT * FROM MyTask WHERE userld = userid_p ORDER BY time DESC")
    List<MyTask> getAllTaskOrederBy(long userid_p);


    @Query("SELECT * FROM MyTask WHERE userld = userid_p AND isCompleted = isCompleted_p" +
            "ORDER BY importance DESC")
    List<MyTask> getAllTaskOrederBy(long userid_p, boolean isCompleted_p);

    /**
     * إدخال مهام
     *
     * @param t مجموعة مهام
     */
    @Insert
    void insertTask(MyTask... t);

    /**
     * تعديل المهام
     *
     * @param taskId
     * @param title
     * @param description
     * @param priority
     * @param tasks       مجموعة مهام للتعديل (التعديل حسب المفتاح الرئيسي)
     */

    @Update
    void updateTask(long taskId, String title, String description, int priority, MyTask... tasks);

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

            " ORDER BY importance DESC")
    List<MyTask> getTasksBySubjId(long key_id);

    Object getTasksByTitle(String title);

    LiveData<List<MyTask>> getTasksByDescription(String description);

    LiveData<List<MyTask>> getTasksByUserId(long userId);

    LiveData<MyTask> getTaskById(long taskId);
}





