package com.hetic.hetic_e18_bart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateDealActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextPrice;
    EditText editTextDescription;
    Button buttonCreateDeal;

    DatabaseReference databaseDeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_deal);

        databaseDeals = FirebaseDatabase.getInstance().getReference("deals");

        editTextName = (EditText)findViewById(R.id.dealName);
        editTextPrice = (EditText)findViewById(R.id.dealPrice);
        editTextDescription = (EditText)findViewById(R.id.dealDescription);

        buttonCreateDeal = (Button)findViewById(R.id.createDeal);

        buttonCreateDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDeal();
            }
        });
    }

    private void addDeal(){
        String titre = editTextName.getText().toString();
        int prix = Integer.parseInt(editTextPrice.getText().toString());
        String desc = editTextDescription.getText().toString();

            String id = databaseDeals.push().getKey();

            Deal deal = new Deal(id, titre, prix, desc);

            databaseDeals.child(id).setValue(deal);

            Toast.makeText(this, "Deal créé", Toast.LENGTH_SHORT).show();

        if (!TextUtils.isEmpty(titre)) {

        }else{
            Toast.makeText(this, "Veuillez enter un titre", Toast.LENGTH_SHORT).show();
        }
    }
}
