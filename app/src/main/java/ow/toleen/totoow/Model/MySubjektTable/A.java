package ow.toleen.totoow.Model.MySubjektTable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class A {
    @Entity
    public class MySubject
    {
        @PrimaryKey(autoGenerate = true)
        public long key_id;
        public String title;

        public void setTitle( ) {
        }

        public void setTitle(String math) {
        }
    }
}
