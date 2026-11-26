package ow.toleen.totoow.viewPKG;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ow.toleen.totoow.AddTaskActivity;
import ow.toleen.totoow.Model.MyUserTable.MyUser;
import ow.toleen.totoow.R;
import ow.toleen.totoow.ViewModel.MyUserViewModel;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;



import ow.toleen.totoow.Model.AppDataBase;
import ow.toleen.totoow.Model.MySubjectTable.MySubject;
import ow.toleen.totoow.Model.MySubjectTable.MySubjectQuery;

public class MainActivity extends AppCompatActivity {
    private Button btnAddNewTask;
    private Button btnRegisterScreen;
    private Spinner spnrSubject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        spnrSubject=findViewById(R.id.spnrOpreations);
        ArrayAdapter<String>adapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        String[]ar={"ضرب","طرح","جمع","قسمة"};
        AppDataBase db = AppDataBase.getDB(getApplicationContext());
//2 مؤشر لكائن عمليات  لجدول
        MySubjectQuery subjectQuery = db.getMySubjectQuery();
//3  بناء كائن من نوع الجدول وتحديد قيم الصفات
        MySubject s1 = new MySubject();
        s1.setTitle("Math");
        MySubject s2 = new MySubject();
        s2.title = "Computers";
//4 اضافة كائن للجدول


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
                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.giftmenu, menu);
        return true;
    }

    public boolean OnOptionsItemSelected(MenuItem item) {
        if (R.id.Reminder == item.getItemId()) {
            Toast.makeText(this, "Reminder", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.Reminder) {
            ShowYesNoDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
public void ShowYesNoDialog(){
    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setTitle("log out");
    builder.setMessage("Are you Sure");
    builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int i) {
            Toast.makeText(MainActivity.this, "Sining Out", Toast.LENGTH_SHORT).show();
finish();
        }
    });
    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int i) {
            Toast.makeText(MainActivity.this, "Sining Out", Toast.LENGTH_SHORT).show();
        }
            });
        AlertDialog dialog=builder.create();
    dialog.show();
}
}