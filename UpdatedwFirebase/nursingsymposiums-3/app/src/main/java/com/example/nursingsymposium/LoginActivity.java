package com.example.nursingsymposium;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nursingsymposium.admin.AdminActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    Button login_btn;
    TextInputEditText id_username;
    TextInputEditText id_userpassword;
    TextView forgotPassword, register;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn = findViewById(R.id.login_btn);
        id_userpassword = findViewById(R.id.id_userpassword);
        forgotPassword = findViewById(R.id.forgotPassword);
        register = findViewById(R.id.register);
        id_username = findViewById(R.id.id_username);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = id_username.getText().toString();
                String password = id_userpassword.getText().toString();

            /*    username="test2@gmail.com";
               password="synergy1";
*/

                   username="admin@gmail.com";
                   password="123456";
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(LoginActivity.this, "Enter UserName", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                } else {

                    try {
                        progressDialog = new ProgressDialog(LoginActivity.this);
                        progressDialog.setMessage("Loading....");
                        progressDialog.show();
                        FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        progressDialog.cancel();
                                        if (task.isSuccessful()) {

                                            verifyUserType();

                                            Toast.makeText(LoginActivity.this, "Login Succesfull", Toast.LENGTH_SHORT).show();


                                        } else {
                                            Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });


                    } catch (Exception e
                    ) {
                        e.printStackTrace();
                    }

                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SelectTypeActivity.class);
                startActivity(intent);
            }
        });


    }

    private void verifyUserType() {
        String studentID = FirebaseAuth.getInstance().getUid();
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference reference=firebaseDatabase.getReference("UserDetails").child("Student").child(studentID);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                RegistrationModel model=snapshot.getValue(RegistrationModel.class);
                if(model.userType.equals("ADMIN")){
                    Intent intent = new Intent(LoginActivity.this, DashBoardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(LoginActivity.this, DashBoardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}