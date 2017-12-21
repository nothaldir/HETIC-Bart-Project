package com.hetic.hetic_e18_bart;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditActivity extends AppCompatActivity {

    EditText editTextUserName;

    DatabaseReference databaseUsers;
    Button buttonEditUser;

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        user = FirebaseAuth.getInstance().getCurrentUser();

        databaseUsers = FirebaseDatabase.getInstance().getReference("users");

        editTextUserName = findViewById(R.id.editTextUserName);

        buttonEditUser = findViewById(R.id.editUser);
        buttonEditUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editUser();
                Intent intent = new Intent(EditActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void editUser() {
        String userName = editTextUserName.getText().toString();

        UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                .setDisplayName(userName)
                .build();

        user.updateProfile(profileUpdate)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("LOG", "User profile updated.");
                        }
                    }
                });
    }
}
