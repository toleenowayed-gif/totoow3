package ow.toleen.totoow.Model.MySubjectTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface MySubjectQuery {
    @Dao
    public interface MySubjectQuery
    {
        /**
         * إعادة جميع مواضيع جدول المواضيع
         * @return قائمة من المواضيع
         */
        @Query("SELECT * FROM MySubject")
        List<MySubject.MySubject> getAllSubjects();

        /**
         * إدخال مهام
         * @param s مجموعة مهام
         */
        @Insert
        void insert(MySubject.MySubject... s);

        /**
         * تعديل المهام
         * @param s
         */
        @Update
        void update(MySubject.MySubject... s);

        /**
         * حذف مهمة أو مهام
         * @param s حذف المهام (حسب المفتاح الرئيسي)
         */
        @Delete
        void deleteTask(MySubject.MySubject... s);

        @Query("DELETE FROM MySubject WHERE key_id=:keyid")
        void delete(long keyid);

        @Query("SELECT * FROM MySubject WHERE title=:sub")
        MySubject.MySubject checkSubject(String sub);
    }
}

