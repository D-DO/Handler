package com.example.odd.handler1.ex2;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.odd.handler1.R;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    Handler h;
    TextView tvInfo;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.tvInfo);
        btnStart = (Button) findViewById(R.id.btnStart);
    }

    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:

                Thread t = new Thread(new Runnable() {
                    public void run() {
                        for (int i = 1; i <= 10; i++) {
                            // долгий процесс
                            downloadFile();
                            // обновляем TextView
                            tvInfo.setText("Закачано файлов: " + i);
                            // пишем лог
                            Log.d(LOG_TAG, "i = " + i);
                        }
                    }
                });
                t.start();
//                for (int i = 1; i <= 10; i++) {
//                    // долгий процесс
//                    downloadFile();
//                    // обновляем TextView
//                    tvInfo.setText("Закачано файлов: " + i);
//                    // пишем лог
//                    Log.d(LOG_TAG, "Закачано файлов: " + i);
//                }
                break;
            case R.id.btnTest:
                tvInfo.setText("test");
                Log.d(LOG_TAG, "test");
                break;
            default:
                break;
        }

    }

    void downloadFile() {
        // пауза - 1 секунда
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
