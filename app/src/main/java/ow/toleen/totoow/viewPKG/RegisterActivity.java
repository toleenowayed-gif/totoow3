package ow.toleen.totoow.viewPKG;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ow.toleen.totoow.R;

public class RegisterActivity extends AppCompatActivity {
 private   TextView textView;
    private TextView editTextText3;
 private EditText editTextTextEmailAddress;
 private EditText editTextTextPassword;
 private  EditText editTextPhone;
 private  Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView=findViewById(R.id.textView);
        editTextText3=findViewById(R.id.editTextText3);
        editTextTextEmailAddress=findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword=findViewById(R.id.editTextTextPassword);
        editTextPhone=findViewById(R.id.editTextPhone);
        button3=findViewById(R.id.button3);
    }
}