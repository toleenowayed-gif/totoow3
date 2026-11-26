package ow.toleen.totoow.viewPKG;

import static ow.toleen.totoow.R.*;
import static ow.toleen.totoow.R.id.phone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import ow.toleen.totoow.Model.MyUserTable.MyUser;
import ow.toleen.totoow.R;
import ow.toleen.totoow.ViewModel.MyUserViewModel;
import ow.toleen.totoow.repositores.MyUserRepository;

public class SignUp extends AppCompatActivity {
    private TextView textView;
    private TextView etfullName;
    private EditText etEmail;
    private EditText etpassword;
    private EditText etphone ;
    private Button button3;
    private Button btnGoToSignIn;
    private MyUserViewModel userViewModel;

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
        textView = findViewById(R.id.textView);
        etfullName = findViewById(R.id.FullName);
        etEmail = findViewById(R.id.email);
        etpassword = findViewById(R.id.password);
        etphone= findViewById(R.id.phone);
        button3 = findViewById(R.id.button3);
        btnGoToSignIn=findViewById(id.btnGoToSignIn);
        button3.setOnClickListener(v -> SignUpUser());
         userViewModel = new ViewModelProvider(this).get(MyUserViewModel.class);
        btnGoToSignIn.setOnClickListener(v -> {
        Intent intent = new Intent(SignUp.this, SignInActivity.class);
            startActivity(intent);
        });
    }
    private void SignUpUser()

    {
        String fullName = etfullName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etpassword.getText().toString().trim();
        String phone = etphone.getText().toString().trim();


        if (fullName.isEmpty()) {
            etfullName.setError("FullName is required");
            etfullName.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            etEmail.setError("email is required");
            etEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            etpassword.setError("password is required");
            etpassword.requestFocus();
            return;
        }
        if (phone.isEmpty()) {
            etphone.setError("phone is required");
            etphone.requestFocus();
            return;
        }
        MyUser user=new MyUser();
        user.setFullName(fullName);
        user.email=email;
        user.passw=password;
        user.phone=phone;

        userViewModel.insert(user);

        Toast.makeText(this, "Acount created succesfully !Welcome, " + user.getFullName(), Toast.LENGTH_SHORT).show();
         Intent intent=new Intent(SignUp.this,MainActivity.class);
         intent.putExtra("userName",fullName);
        intent.putExtra("Email",email);
        startActivity(intent);
        finish();

    }
}