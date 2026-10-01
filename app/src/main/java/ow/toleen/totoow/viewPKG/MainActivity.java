package ow.toleen.totoow.viewPKG;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ow.toleen.totoow.AppDataBase;
import ow.toleen.totoow.Model.MyTaskTable.MyTaskQuery;
import ow.toleen.totoow.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        AppDataBase db=AppDataBase.getDB(getApplicationContext());
//2 مؤشر لكائن عمليات  لجدول
        MyTaskQuery.MySubjectQuery subjectQuery = db.getMySubjectQuery();
//3  بناء كائن من نوع الجدول وتحديد قيم الصفات
        MyTaskQuery.MySubject s1=new MyTaskQuery.MySubject();
        s1.setTitle("Math");
        MyTaskQuery.MySubject s2=new MyTaskQuery.MySubject();
        s2.title="Computers";
//4 اضافة كائن للجدول
        subjectQuery.insert(s1);
        subjectQuery.insert(s2);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }
}