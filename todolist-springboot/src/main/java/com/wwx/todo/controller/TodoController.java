package com.wwx.todo.controller;

import com.wwx.todo.model.Todo;
import com.wwx.todo.model.TodoExample;
import com.wwx.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
//直接创建controller，方法RequestMapping可以省略参数说明
@RestController
//跨域
@CrossOrigin

public class TodoController {
@Autowired
    TodoService todoService;
@GetMapping("/todos")
    public List<Todo> todoList(@RequestParam String userId,@RequestParam String currentStatus){
    TodoExample example = new TodoExample();
    TodoExample.Criteria criteria = example.createCriteria();
    if(null !=userId && !"".equalsIgnoreCase(userId)){
        criteria.andUserIdEqualTo(userId);
    }
    if(null !=currentStatus && !"".equalsIgnoreCase(currentStatus)){
        criteria.andCurrentStatusEqualTo(currentStatus);
    }
   List list =todoService.selectByExample(example);
    return  list;
}
@PostMapping("/todos")
    public Todo todoadd(@RequestBody Todo todo){
    Integer id=(int)(new Random().nextDouble()*10000000);
    todo.setItemId(id.toString());
    Date date = new Date(System.currentTimeMillis());
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.HOUR, 8);// 24小时制
    date = cal.getTime();
    todo.setCreatedTime(date);
    todo.setLastUpdatedTime(date);
    todoService.insertSelective(todo);
    return todo;
}
@PutMapping("/todos")
    public Todo todoedit(@RequestBody Todo todo){
    Date date = new Date(System.currentTimeMillis());
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.HOUR, 8);// 24小时制
    date = cal.getTime();
    todo.setLastUpdatedTime(date);
    todoService.updateByPrimaryKeySelective(todo);
    return todo;
    }
 @DeleteMapping("/todos/{id}")
    public  String tododelete(@PathVariable String id){
    todoService.deleteByPrimaryKey(id);
    return "200";
    }
}
