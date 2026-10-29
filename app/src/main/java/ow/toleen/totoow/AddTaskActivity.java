package ow.toleen.totoow;

import static ow.toleen.totoow.R.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.PrivateKey;

public class AddTaskActivity extends AppCompatActivity {

    private TextView textview;
     private EditText editTextText;
      private EditText editTextTextMultiLine3;
      private Button BtnSaveTask;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textview= findViewById(R.id.textview);
        editTextText=findViewById(R.id.editTextText);
        editTextTextMultiLine3=findViewById(R.id.editTextTextMultiLine3);
        editTextText=findViewById(id.editTextText);
    }
    }
