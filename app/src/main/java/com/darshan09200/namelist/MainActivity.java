package com.darshan09200.namelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.darshan09200.namelist.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        names = new ArrayList<>();
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);
        binding.listView.setAdapter(adapter);
        binding.submitBtn.setOnClickListener(v -> {
            String text = binding.textInput.getText().toString().trim();
            if (text.isEmpty()) {
                Toast.makeText(MainActivity.this, "Add a name", Toast.LENGTH_SHORT).show();
            } else {
                names.add(text);
                binding.textInput.setText("");
                adapter.notifyDataSetChanged();
            }
        });
    }
}