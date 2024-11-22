package com.btec.fpt.appquanlichitieu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RevenueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);
        getWindow().setStatusBarColor(ContextCompat.getColor(RevenueActivity.this, R.color.bar));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btn_expense = findViewById(R.id.btn_expense);
        btn_expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RevenueActivity.this, ExpenseActivity.class);
                startActivity(intent);
            }
        });
        Button btn_income = findViewById(R.id.btn_income);
        btn_income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RevenueActivity.this, RevenueActivity.class);
                startActivity(intent);
            }
        });
        ImageButton item_icon8 = findViewById(R.id.imgbtn_add);
        item_icon8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RevenueActivity.this, AddTransactionRevenueActivity.class);
                startActivity(intent);
            }
        });
    }
}