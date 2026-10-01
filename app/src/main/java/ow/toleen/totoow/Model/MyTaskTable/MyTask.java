package ow.toleen.totoow.Model.MyTaskTable;

import androidx.room.PrimaryKey;

public class MyTask {
       @PrimaryKey private long keyid;
        public int importance;
        public  String shortTitle;
        public String text;
        public long time;
        public boolean isCompleted;
        public long subjId;
        public long userId;

    }

