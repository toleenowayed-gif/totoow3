package ow.toleen.totoow.Model.MySubjectTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface MySubjectQuery {

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

