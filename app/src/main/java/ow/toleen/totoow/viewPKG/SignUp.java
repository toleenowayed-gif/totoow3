package ow.toleen.totoow.viewPKG;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ow.toleen.totoow.R;

public class SignUp extends AppCompatActivity {
 private   TextView textView;
 private TextView etfullName;
 private EditText etEmail;
 private EditText etpassword;
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
        etfullName=findViewById(R.id.etfullName);
        etEmail=findViewById(R.id.etEmail);
        etpassword=findViewById(R.id.password);
        editTextPhone=findViewById(R.id.editTextPhone);
        button3=findViewById(R.id.button3);
        button3.setOnClickListener(v ->{
            String FullName=etfullName.getText().toString().trim();
            String email =etEmail.getText().toString().trim();
            String password =etpassword.getText().toString().trim();


        }

        if(FullName.isEmpty()){
            FullName.setError("FullName is required");
            FullName.requestFocus();
            return;
        }
        if(email.isEmpty()){
            etEmail.setError("email is required");
            etEmail.requestFocus();
            return;
        }
        if(password.isEmpty()){
            password.setError("password is required");
            password.requestFocus();
            return;
        }
    }
}