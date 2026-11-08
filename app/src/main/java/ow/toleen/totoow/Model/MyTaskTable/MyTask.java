package ow.toleen.totoow.Model.MyTaskTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public  class MyTask {
       @PrimaryKey
       protected long keyid;
        public int priority ;
        public  String shortTitle;
        public String text;
        public long time;
        public boolean isCompleted;
        public long subjId;
        public long userId;

    }

