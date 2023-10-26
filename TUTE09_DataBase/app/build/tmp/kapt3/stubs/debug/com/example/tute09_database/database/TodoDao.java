package com.example.tute09_database.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\'J\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/example/tute09_database/database/TodoDao;", "", "deleteTodo", "", "todo", "Lcom/example/tute09_database/database/Todo;", "(Lcom/example/tute09_database/database/Todo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTodoItems", "", "insertTodo", "app_debug"})
@androidx.room.Dao
public abstract interface TodoDao {
    
    @androidx.room.Insert
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertTodo(@org.jetbrains.annotations.NotNull
    com.example.tute09_database.database.Todo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteTodo(@org.jetbrains.annotations.NotNull
    com.example.tute09_database.database.Todo todo, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM Todo")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.tute09_database.database.Todo> getAllTodoItems();
}