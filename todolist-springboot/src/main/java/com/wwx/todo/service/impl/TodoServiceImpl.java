package com.wwx.todo.service.impl;

import com.wwx.todo.mapper.TodoMapper;
import com.wwx.todo.model.Todo;
import com.wwx.todo.model.TodoExample;
import com.wwx.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoMapper mapper;
    @Override
    public long countByExample(TodoExample example) {
        return mapper.countByExample(example);
    }

    @Override
    public int deleteByExample(TodoExample example) {
        return mapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String itemId) {
        return mapper.deleteByPrimaryKey(itemId);
    }

    @Override
    public int insert(Todo record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(Todo record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<Todo> selectByExample(TodoExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public Todo selectByPrimaryKey(String itemId) {
        return mapper.selectByPrimaryKey(itemId);
    }

    @Override
    public int updateByExampleSelective(Todo record, TodoExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Todo record, TodoExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Todo record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Todo record) {
        return mapper.updateByPrimaryKey(record);
    }
}
