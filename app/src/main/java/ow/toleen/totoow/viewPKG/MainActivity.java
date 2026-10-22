package ow.toleen.totoow.viewPKG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ow.toleen.totoow.AddTaskActivity;
import ow.toleen.totoow.AppDataBase;
import ow.toleen.totoow.Model.MySubjectTable.MySubject;
import ow.toleen.totoow.Model.MySubjectTable.MySubjectQuery;
import ow.toleen.totoow.R;

public class MainActivity extends AppCompatActivity {
    private Button btnAddNewTask;
    private Button btnRegisterScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        AppDataBase db = AppDataBase.getDB(getApplicationContext());
//2 مؤشر لكائن عمليات  لجدول
        MySubjectQuery subjectQuery = db.getMySubjectQuery();
//3  بناء كائن من نوع الجدول وتحديد قيم الصفات
        MySubject s1 = new MySubject();
        s1.setTitle("Math");
        MySubject s2 = new MySubject();
        s2.title = "Computers";
//4 اضافة كائن للجدول

        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        btnAddNewTask = findViewById(R.id.btnAddNewTask);
        btnRegisterScreen = findViewById(R.id.btnRegisterScreen);

        btnAddNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(i);
            }
        });

        btnRegisterScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}

