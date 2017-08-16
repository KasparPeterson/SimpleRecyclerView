package com.kasparpeterson.example;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kasparpeterson.simplerecyclerview.SimpleAdapterItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<SimpleAdapterItem> items = new ArrayList<>();
        items.add(new ExampleAdapter.FirstItem("I am first"));
        items.add(new ExampleAdapter.FirstItem("I am second"));
        items.add(new ExampleAdapter.SecondItem());
        items.add(new ExampleAdapter.FirstItem("I am third"));
        items.add(new ExampleAdapter.FirstItem("I am fourth"));
        items.add(new ExampleAdapter.SecondItem());
        items.add(new ExampleAdapter.FirstItem("I am fifth"));
        items.add(new ExampleAdapter.FirstItem("I am sixth"));
        items.add(new ExampleAdapter.FirstItem("I am seventh"));
        items.add(new ExampleAdapter.SecondItem());
        items.add(new ExampleAdapter.FirstItem("I am the last"));
        ExampleAdapter adapter = new ExampleAdapter(items, new ExampleAdapter.Listener() {
            @Override
            public void onFirstItemClicked(@NonNull String input) {
                Log.d(TAG, "onFirstItemClicked, input: " + input);
            }

            @Override
            public void onSecondItemClicked() {
                Log.d(TAG, "onSecondItemClicked()");
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
