package com.example.qthjen.listviewandevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> list;
    Button bt;
    EditText et;
    Button btUpdate;
    Button btDelete;

    int vitri = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);
        bt = (Button) findViewById(R.id.bt);
        et = (EditText) findViewById(R.id.et);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btDelete = (Button) findViewById(R.id.btDelete);

        list = new ArrayList<String>();

        list.add("Q.ThjeN");
        list.add("Unity3D");
        list.add("Swift");
        list.add("Java");
        list.add("Kotlin");
        list.add("React Native");
        list.add("Object-C");
        list.add("Go Lang");
        list.add("Python");

        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

        /** sự kiện click **/
/**        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() { **/
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, list.get(position) + " vi tri: " + position, Toast.LENGTH_SHORT).show();
//            }
//        });

        /** sự kiện long click **/
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Language: " + list.get(position), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        /** Add data **/
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String insert = et.getText().toString();
                list.add(insert);
                adapter.notifyDataSetChanged(); // hàm thay đổi dữ liệu để add khi dữ liệu bị thay đổi
                et.setText("");
            }
        });

        /** Update data **/
        /** sự kiện cho item **/
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                et.setText(list.get(position));
                vitri = position;
            }
        });

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dataUpdate = et.getText().toString();
                list.set(vitri, dataUpdate);
                adapter.notifyDataSetChanged();
                et.setText("");

            }
        });

        /** Delete data**/
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list.remove(vitri);
                adapter.notifyDataSetChanged();
                et.setText("");

            }
        });

    }

}
