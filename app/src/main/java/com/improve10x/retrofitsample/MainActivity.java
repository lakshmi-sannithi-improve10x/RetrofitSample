package com.improve10x.retrofitsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
  private TextView testingTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testingTxt = findViewById(R.id.testing_txt);
        apiCall();
    }

    private void apiCall() {
        TodoService todoService = new TodoApi().createTodoService();
        Call<List<TodoItem>>call = todoService.getTodoItems();
        call.enqueue(new Callback<List<TodoItem>>() {
            @Override
            public void onResponse(Call<List<TodoItem>> call, Response<List<TodoItem>> response) {
                Gson gson = new Gson();
                testingTxt.setText(gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<List<TodoItem>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}