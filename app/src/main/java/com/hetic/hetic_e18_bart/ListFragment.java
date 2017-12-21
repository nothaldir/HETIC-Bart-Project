package com.hetic.hetic_e18_bart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment implements View.OnClickListener {

    ListView listViewDeals;

    List<Deal> dealList;

    DatabaseReference databaseDeals;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getView().findViewById(R.id.create_deal_button).setOnClickListener(this);

        listViewDeals = (ListView) getView().findViewById(R.id.listViewDeals);

        databaseDeals = FirebaseDatabase.getInstance().getReference("deals");

        dealList = new ArrayList<>();
    }

    public static Fragment newInstance() {
        ListFragment listFragment = new ListFragment();
        return listFragment;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.create_deal_button) {
            Intent intent = new Intent(getActivity(), CreateDealActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        databaseDeals.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                dealList.clear();
                for (DataSnapshot dealSnapshot : dataSnapshot.getChildren()){
                    Deal deal = dealSnapshot.getValue(Deal.class);

                    dealList.add(deal);
                }

                DealList adapter = new DealList(getActivity(), dealList);
                listViewDeals.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
