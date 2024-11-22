package com.btec.fpt.appquanlichitieu;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ExpenseActivity extends AppCompatActivity {


    private Button btnSelectDate;
    private final Calendar calendar = Calendar.getInstance();
    private ImageButton selectedButton = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        getWindow().setStatusBarColor(ContextCompat.getColor(ExpenseActivity.this, R.color.bar));

        btnSelectDate = findViewById(R.id.btn_select_date);

        btnSelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });


        Button btnSaveExpense = findViewById(R.id.btnSaveExpense);
        btnSaveExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ExpenseActivity.this, "Đã nhập dữ liệu", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton item_icon7 = findViewById(R.id.item_icon7);
        item_icon7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExpenseActivity.this, AddTransactionSpendingActivity.class);
                startActivity(intent);
            }
        });
        Button btn_expense = findViewById(R.id.btn_expense);
        btn_expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExpenseActivity.this, ExpenseActivity.class);
                startActivity(intent);
            }
        });
        Button btn_income = findViewById(R.id.btn_income);
        btn_income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExpenseActivity.this, RevenueActivity.class);
                startActivity(intent);
            }
        });

    }


    private void showDatePickerDialog() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year, month, dayOfMonth);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy (EEE)", Locale.getDefault());
                        btnSelectDate.setText(dateFormat.format(calendar.getTime()));
                    }
                }, year, month, day);
        datePickerDialog.show();
    }
}