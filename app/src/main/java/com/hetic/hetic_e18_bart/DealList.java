package com.hetic.hetic_e18_bart;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Whorthy on 20/12/2017.
 */

public class DealList extends ArrayAdapter {

    private Activity context;
    private List<Deal> dealList;

    public DealList(Activity context, List<Deal> dealList) {
        super(context, R.layout.list_layout, dealList);
        this.context = context;
        this.dealList = dealList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewDesc = (TextView)listViewItem.findViewById(R.id.textViewDesc);
        TextView textViewTitre = (TextView)listViewItem.findViewById(R.id.textViewTitre);

        Deal deal = dealList.get(position);

        textViewDesc.setText(deal.getDealDescription());
        textViewTitre.setText(deal.getDealTitre());

        return listViewItem;
    }
}
