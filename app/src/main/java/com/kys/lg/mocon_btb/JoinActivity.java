package com.kys.lg.mocon_btb;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static android.view.View.Z;

public class JoinActivity extends AppCompatActivity {

    EditText nickname,id,password,c_password;
    Button button;
    Spinner genre;
    String s_genre;
    DocumentReference reference;
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        nickname=findViewById(R.id.nickname);
        id=findViewById(R.id.join_ID);
        password=findViewById(R.id.join_password);
        c_password=findViewById(R.id.pw_check);
        button=findViewById(R.id.register);

        genre=findViewById(R.id.genre);
        auth=FirebaseAuth.getInstance();



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("tag",id.getText().toString()+ password.getText().toString()+c_password.getText().toString());

                if (!(id.getText().toString().trim().equals("") || password.getText().toString().trim().equals("") || c_password.getText().toString().trim().equals(""))) {

                    if (password.getText().toString().trim().equals(c_password.getText().toString().trim())) {

                        //유효성 검사
                        if ((isValidPassword(password.getText().toString().trim()) && isValidEmail(id.getText().toString().trim()))) {

                            createAccount();




                        } else {
                            Toast.makeText(getApplicationContext(), "비밀번호나 아이디가 재대로 표현되지 않았습니다,,", Toast.LENGTH_SHORT).show();
                        }


                    } else {
                        Toast.makeText(getApplicationContext(), "비밀번호가 일치하지 안습니다,", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "입력되지 않은 것이 있습니다.,", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private void createAccount() {



        auth.createUserWithEmailAndPassword(id.getText().toString().trim(),password.getText().toString().trim())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    final String uid= task.getResult().getUser().getUid();

                    User user= new User();
                    user.id=id.getText().toString().trim();
                    user.password=password.getText().toString().trim();
                    user.nickname=nickname.getText().toString().trim();

                    db.collection("users").document(uid).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            Toast.makeText(getApplicationContext(),"회원가입 성공",Toast.LENGTH_SHORT).show();

                        }
                    });

                    Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(i);

//
//                    HashMap<String,Object> user= new HashMap<>();
//                    user.put("id","kysk2295");
//                    user.put("password","fekfef");
//                    user.put("nickname","kys");
//
//                    db.collection("users").add(user).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//                        @Override
//                        public void onComplete(@NonNull Task<DocumentReference> task) {
//
//                            Toast.makeText(getApplicationContext(),"성공",Toast.LENGTH_SHORT).show();
//                        }
//                    });


                }else{

                    Toast.makeText(getApplicationContext(),"회원가입 실패",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidEmail(String toString) {
        if (toString== null || TextUtils.isEmpty(toString)){
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(toString).matches();
        }
    }

    private boolean isValidPassword(String toString) {

        Pattern p = Pattern.compile("(^.*(?=.{6,100})(?=.*[0–9])(?=.*[a-zA-Z]).*$)");

        Matcher m = p.matcher(toString);
        if (m.find() && !toString.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")){
            return true;
        }else{
            return false;
        }
    }
}
