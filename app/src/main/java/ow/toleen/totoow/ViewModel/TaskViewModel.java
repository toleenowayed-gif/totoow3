package ow.toleen.totoow.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ow.toleen.totoow.Model.MyTaskTable.MyTask;
import ow.toleen.totoow.repositores.TaskRepository;

public class TaskViewModel extends AndroidViewModel{
        private TaskRepository repository;
        private  LiveData<List<MyTask>> allTasks;
    public TaskViewModel(@NonNull Application application) {
        super();
    }

    }
