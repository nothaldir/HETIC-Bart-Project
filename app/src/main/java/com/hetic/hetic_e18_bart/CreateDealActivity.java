package com.hetic.hetic_e18_bart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CreateDealActivity extends AppCompatActivity {

    EditText editTextTitre;
    EditText editTextPrix;
    EditText editTextDesc;
    Button buttonCreateDeal;

    DatabaseReference databaseDeals;

    ListView listViewDeals;

    List<Deal> dealList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_deal);

        databaseDeals = FirebaseDatabase.getInstance().getReference("deals");

        editTextTitre = (EditText)findViewById(R.id.dealTitre);
        editTextPrix = (EditText)findViewById(R.id.dealPrice);
        editTextDesc = (EditText)findViewById(R.id.dealDesc);

        buttonCreateDeal = (Button)findViewById(R.id.createDeal);

        listViewDeals = (ListView)findViewById(R.id.listViewDeals);

        dealList = new ArrayList<>();

        buttonCreateDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addDeal();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseDeals.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                dealList.clear();

                for (DataSnapshot dealSnapshot: dataSnapshot.getChildren()) {
                    Deal deal = dealSnapshot.getValue(Deal.class);

                    dealList.add(deal);
                }

                DealList adapter = new DealList(CreateDealActivity.this, dealList);
                listViewDeals.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void addDeal(){
        String titre = editTextTitre.getText().toString();
        int prix = Integer.parseInt(editTextPrix.getText().toString());
        String desc = editTextDesc.getText().toString();
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
