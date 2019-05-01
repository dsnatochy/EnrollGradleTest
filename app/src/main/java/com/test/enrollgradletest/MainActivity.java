package com.test.enrollgradletest;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.poynt.os.model.Intents;
import co.poynt.os.model.Payment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Payment p = new Payment();
        p.setAmount(1000L);
        p.setCurrency("USD");
        Intent i = new Intent(Intents.ACTION_COLLECT_PAYMENT);
        i.putExtra(Intents.INTENT_EXTRAS_PAYMENT, p);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Payment p = data.getParcelableExtra(Intents.INTENT_EXTRAS_PAYMENT);
        System.out.println(p);
    }
}
