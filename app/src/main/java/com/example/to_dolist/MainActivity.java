package com.example.to_dolist;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    List<String> items = new ArrayList<>();
    ArrayAdapter<String> itemsAdapter;
    ListView listView;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        addBtn = findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(v);
            }
        });

        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        listView.setAdapter(itemsAdapter);
        removeItem();
    }

    private void removeItem() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getApplicationContext();
                Toast.makeText(context,"Item removed!",Toast.LENGTH_LONG).show();

                items.remove(position);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void addItem(View view) {
        EditText editText = findViewById(R.id.itemToAdd);
        String itemText = editText.getText().toString();

        if(!itemText.equals("")){
            itemsAdapter.add(itemText);
            editText.setText("");
        }else{
            Toast.makeText(getApplicationContext(),"Enter text!",Toast.LENGTH_LONG).show();
        }
    }


}