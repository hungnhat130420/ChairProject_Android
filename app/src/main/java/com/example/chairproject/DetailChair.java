package com.example.chairproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DetailChair extends AppCompatActivity {
    private ImageView hinhGhe,btnAdd,btnSub;
    private TextView tvName,tvPrice,count;
    private Button btnCart;
    private  Chair chair = new Chair();
    public static List<Chair> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_chair);
        Intent intent = getIntent();
        hinhGhe=findViewById(R.id.imgdc);
        tvName = findViewById(R.id.txtName);
        tvPrice = findViewById(R.id.txtPrice);
        btnCart = findViewById(R.id.btnCart);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);

//        count = findViewById(R.id.txtCount);



        int id = intent.getIntExtra("id", 0);

        for(Chair c : MainActivity.chairs){
            if(c.getId()==id){
                chair = c;
                break;
            }
        }

        //int img =intent.getIntExtra("img",0);
        hinhGhe.setImageResource(chair.getImg());
        //String name = intent.getStringExtra("name");
        tvName.setText(chair.getName());
        //String price = intent.getStringExtra("price");
        tvPrice.setText(chair.getPrice());

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = findViewById(R.id.txtCount);
                int sl = Integer.parseInt(count.getText().toString().trim());
                sl++;
                count.setText(String.valueOf(sl));

            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = findViewById(R.id.txtCount);
                int sl = Integer.parseInt(count.getText().toString().trim());
                if(sl>0)
                    sl--;
                else
                    Toast.makeText(DetailChair.this, "Không được nhỏ hơn 0", Toast.LENGTH_SHORT).show();;
                count.setText(String.valueOf(sl));
            }
        });
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),activity_list_rcv.class);
                startActivity(intent);

                list.add(chair);
                ChairAPI.getInstance().setListItem(list);
            }
        });
    }
}