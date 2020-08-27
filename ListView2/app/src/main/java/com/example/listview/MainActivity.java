package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnChildItemClick {
    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        mAdapter = new ContactAdapter(this,listContact);
        mAdapter.registerChildItemClick(this);
        lvContact.setAdapter((ListAdapter) mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel model = listContact.get(i);
                Toast.makeText(MainActivity.this, model.getName() + ": " + model.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView () {
        lvContact = (ListView) findViewById(R.id.lvContact);
        ivUser = (ImageView) findViewById(R.id.ivUser);
        tvName = (TextView) findViewById(R.id.tvName);
    }

    private void initData(){
        listContact.add(new ContactModel("Phạm Thu Huyền", "0375857703", R.drawable.ic_u1));
        listContact.add(new ContactModel("Phan Văn Minh", "0375857703", R.drawable.ic_u2));
        listContact.add(new ContactModel("Trần Trọng HOàng", "0375857703", R.drawable.ic_u3));
        listContact.add(new ContactModel("Nguyễn Hữu Long", "0375857703", R.drawable.ic_u4));
        listContact.add(new ContactModel("Phạm Thị Thanh", "0375857703", R.drawable.ic_u5));
        listContact.add(new ContactModel("Đặng Thành Đạt", "0375857703", R.drawable.ic_user_a));
        listContact.add(new ContactModel("Hoàng Khánh HUyền", "0375857703", R.drawable.ic_u1));
        listContact.add(new ContactModel("Bùi Thị Trà", "0375857703", R.drawable.ic_u2));
        listContact.add(new ContactModel("Nguyễn Bá Dũng", "0375857703", R.drawable.ic_u3));
        listContact.add(new ContactModel("Hoàng Trung Xô", "0375857703", R.drawable.ic_u4));
        listContact.add(new ContactModel("Ngô Đức Quế", "0375857703", R.drawable.ic_u5));
        listContact.add(new ContactModel("Đỗ Đức Học", "0375857703", R.drawable.ic_u2));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.unRegisterChildItemClick();
    }

    public void onItemChildClick(int position){
        ContactModel contact = listContact.get(position);
        ivUser.setImageResource(contact.getImage());
        tvName.setText(contact.getName());
    }
}