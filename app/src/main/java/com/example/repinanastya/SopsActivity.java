package com.example.repinanastya;

import androidx.annotation.RequiresApi;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SopsActivity extends ListActivity {

    private resAdapter adapter;

    private String[] name = {"Цезарь", "Крабовый"};

    private String[] price = {"400 руб", "300 руб"};

    private String[] weight = {"200 г", "100 г"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = (ListView) findViewById(R.id.list);

        adapter = new resAdapter(this);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String selection = adapter.getString(position);
        Toast.makeText(this, selection, Toast.LENGTH_LONG).show();
    }

    private class resAdapter extends BaseAdapter {
        private LayoutInflater mLayoutInflater;

        resAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return name.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = mLayoutInflater.inflate(R.layout.list_item, null);

            TextView nameTextView = (TextView) convertView.findViewById(R.id.name);
            nameTextView.setText(name[position]);

            TextView priceTextView = (TextView) convertView.findViewById(R.id.price);
            priceTextView.setText(price[position]);

            TextView weightTextView = (TextView) convertView.findViewById(R.id.weight);
            weightTextView.setText(weight[position]);

            return convertView;
        }

        String getString(int position) {
            return name[position] + " (" + price[position] + ")";
        }
    }
}