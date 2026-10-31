package com.example.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            // 建立 AlertDialog
            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
            dialog.setTitle("請選擇功能");
            dialog.setMessage("請根據下方按鈕選擇要顯示的物件");

            // 中立按鈕：顯示原生 Toast
            dialog.setNeutralButton("取消", (dialogInterface, i) ->
                Toast.makeText(MainActivity.this, "dialog", Toast.LENGTH_SHORT).show()
            );

            // 負面按鈕：顯示客製化 Toast
            dialog.setNegativeButton("自定義Toast", (dialogInterface, i) ->
                showToast()
            );

            // 正面按鈕：顯示 List 對話框
            dialog.setPositiveButton("list", (dialogInterface, i) ->
                showListDialog()
            );

            dialog.show();
        });
    }

    @SuppressWarnings("deprecation")
    private void showToast() {
        Toast toast = new Toast(MainActivity.this);
        toast.setGravity(Gravity.TOP, 0, 50);
        toast.setDuration(Toast.LENGTH_SHORT);

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_root));
        toast.setView(layout);
        toast.show();
    }

    private void showListDialog() {
        final String[] list = {"message1", "message2", "message3", "message4", "message5"};
        AlertDialog.Builder dialog_list = new AlertDialog.Builder(MainActivity.this);
        dialog_list.setTitle("使用List呈現");

        dialog_list.setItems(list, (dialogInterface, i) ->
            Toast.makeText(MainActivity.this, "您選擇的是" + list[i], Toast.LENGTH_SHORT).show()
        );

        dialog_list.show();
    }
}
