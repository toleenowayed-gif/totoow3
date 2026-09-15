package ow.toleen.totoow.data.MyTaskTable;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

public interface MyTaskQuery {



    @Query(value = "SELECT * FROM MyTask ORDER BY importance DESC")
    List<MyTask> getAllTasks();


    @Query("SELECT * FROM MyTask WHERE userld = userid_p ORDER BY time DESC")
    List<MyTask> getAllTaskOrederBy(long userid_p);



    @Query("SELECT * FROM MyTask WHERE userld = userid_p AND isCompleted = isCompleted_p" +
            "ORDER BY importance DESC")
    List<MyTask> getAllTaskOrederBy(long userid_p,boolean isCompleted_p);
}
