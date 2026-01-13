package com.lusia.listaandr;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> noteList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteList = new ArrayList<>();
        noteList.add("Zakupy: chleb, masło, ser");
        noteList.add("Do zrobienia: obiad, umyć podłogi");
        noteList.add("weekend: kino, spacer z psem");

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noteList);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);



        listView.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView textView = (TextView) view;
                    if(textView.getPaintFlags() != Paint.STRIKE_THRU_TEXT_FLAG) {
                        view.setBackgroundColor(Color.GRAY);
                        textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    }
                    else {
                        view.setBackgroundColor(Color.WHITE);
                        textView.setPaintFlags(0);
                    }
                }
            }
        );

        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        noteList.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                        return false;
                    }
                }
        );
    }

    public void onClick(View view) {
        EditText editText = (EditText) findViewById(R.id.newElement);
        String note = editText.getText().toString();

        noteList.add(note);
        arrayAdapter.notifyDataSetChanged();
    }

}