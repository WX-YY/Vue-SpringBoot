package com.wwx.Login.controller;

import com.wwx.Login.model.Login;
import com.wwx.Login.model.LoginExample;
import com.wwx.Login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

//直接创建controller，方法RequestMapping可以省略参数说明
@RestController
//跨域
@CrossOrigin
public class LoginConteoller {
    @Autowired
    LoginService service;
    //处理登录
   @PostMapping("/login")
    public Object login(@RequestBody Login login, HttpServletRequest request) {
        String userId = login.getUserLoginId();
        String password =login.getCurrentPassword();
        if (userId != null && password != null) {
            LoginExample example =new LoginExample();
            LoginExample.Criteria criteria = example.createCriteria();
            criteria.andUserLoginIdEqualTo(userId);
            criteria.andCurrentPasswordEqualTo(password);
            List<Login> list =service.selectByExample(example);
            if (list.size() > 0) {
                    login=list.get(0);
               return login;

            }else
                return "404";
        }
        return "404";
    }
    @PostMapping("/loginadd")
    public Login loginadd(@RequestBody Login login){
        Integer id=(int)(new Random().nextDouble()*10000000);
        login.setUserId(id.toString());
        Date date = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, 8);// 24小时制
        date = cal.getTime();
        login.setCreateTime(date);
              // +8小时


        service.insertSelective(login);
        return login;
    }
}



