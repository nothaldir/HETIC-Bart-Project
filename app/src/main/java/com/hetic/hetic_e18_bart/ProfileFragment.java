package com.hetic.hetic_e18_bart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    FirebaseUser user;
    String userName;

    TextView textView_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getView().findViewById(R.id.log_out_button).setOnClickListener(this);
        getView().findViewById(R.id.geofence_button).setOnClickListener(this);
        getView().findViewById(R.id.edit_button).setOnClickListener(this);

        textView_name = (TextView) getView().findViewById(R.id.textView_name);

        user = FirebaseAuth.getInstance().getCurrentUser();
        userName = user.getDisplayName();

        textView_name.setText(userName);

    }


    public static Fragment newInstance() {
        ProfileFragment profileFragment = new ProfileFragment();
        return profileFragment;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.log_out_button) {
            AuthUI.getInstance()
                .signOut(getActivity())
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Log.d("AUTH", "USER LOGGED OUT");
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }
                });
        }
        if (view.getId() == R.id.geofence_button) {
            Intent intent = new Intent(getActivity(), GeofencingActivity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.edit_button) {
            Intent intent = new Intent(getActivity(), EditActivity.class);

            startActivity(intent);
        }
    }
}
