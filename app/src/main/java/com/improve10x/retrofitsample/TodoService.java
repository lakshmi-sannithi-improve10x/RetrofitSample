package com.improve10x.retrofitsample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TodoService {
    @GET("vissuTodo")
    Call<List<TodoItem>>getTodoItems();

    @POST("vissuTodo")
    Call<TodoItem>createTodoItem(@Body TodoItem todoItem);

}
