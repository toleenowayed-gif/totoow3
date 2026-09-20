package ow.toleen.totoow.data.MyTaskTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
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
    List<MyTask> getAllTaskOrederBy(long userid_p,boolean isCompleted_p);

    /**

     * إدخال مهام

     * @param t مجموعة مهام

     */
    @Insert

    void insertTask(MyTask... t);

    /**

     * تعديل المهام

     * @param tasks مجموعة مهام للتعديل (التعديل حسب المفتاح الرئيسي)

     */

    @Update

    void updateTask(MyTask... tasks);

    /**

     * حذف مهمة أو مهام

     * @param tasks حذف المهام (حسب المفتاح الرئيسي)

     */

    @Delete

    void deleteTask(MyTask... tasks);

    @Query("DELETE FROM MyTask WHERE keyId=:kid")

    void deleteTask(long kid);

    /**

     * استخراج جميع المهام التابعة لرقم الموضوع

     * @param key_id رقم الموضوع

     * @return

     */

    @Query("SELECT * FROM MyTask WHERE subjId=:key_id" +

            " ORDER BY importance DESC")

    List<MyTask> getTasksBySubjId(long key_id);
    @Entity
    public class MySubject
    {
        @PrimaryKey(autoGenerate = true)
        public long key_id;
        public String title;
    }

    @Dao
    public interface MySubjectQuery
    {
        /**
         * إعادة جميع مواضيع جدول المواضيع
         * @return قائمة من المواضيع
         */
        @Query("SELECT * FROM MySubject")
        List<MySubject> getAllSubjects();

        /**
         * إدخال مهام
         * @param s مجموعة مهام
         */
        @Insert
        void insert(MySubject... s);

        /**
         * تعديل المهام
         * @param s
         */
        @Update
        void update(MySubject... s);

        /**
         * حذف مهمة أو مهام
         * @param s حذف المهام (حسب المفتاح الرئيسي)
         */
        @Delete
        void deleteTask(MySubject... s);

        @Query("DELETE FROM MySubject WHERE key_id=:keyid")
        void delete(long keyid);

        @Query("SELECT * FROM MySubject WHERE title=:sub")
        MySubject checkSubject(String sub);
    }
}
