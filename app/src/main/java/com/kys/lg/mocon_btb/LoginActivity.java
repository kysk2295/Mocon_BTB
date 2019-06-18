package com.kys.lg.mocon_btb;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText id,password;
    Button btn_register,btn_login;
    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id=findViewById(R.id.ID);
        password=findViewById(R.id.password);
        btn_login=findViewById(R.id.loginButton);
        btn_register=findViewById(R.id.registerButton);

        auth=FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),JoinActivity.class);
                startActivity(i);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id.getText().toString().trim().equals("")||password.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(),"아이디나 비밀번호가 입력되지 않았습니다.",Toast.LENGTH_SHORT).show();
                }else{
                    siginin();
                }
            }
        });

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user= firebaseAuth.getCurrentUser();

                if(user!=null){

                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
    }



    private void siginin() {

        auth.signInWithEmailAndPassword(id.getText().toString().trim(),password.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(!task.isSuccessful()){

                    Toast.makeText(getApplicationContext(),"로그인이 실패했습니다.",Toast.LENGTH_SHORT).show();
                }else{

                    auth.addAuthStateListener(authStateListener);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
       //auth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(authStateListener!=null){
            auth.removeAuthStateListener(authStateListener);
        }
    }
}
