package com.cdd.controller;

import com.cdd.biz.UserBiz;
import com.cdd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserBiz biz;
    public Map check(HttpServletRequest request)
    {
        Map<String, Object> result = new HashMap<>();
        User user=(User)request.getSession().getAttribute("user");
        System.out.println("user/check->check::"+user);
        if(user!=null)  //加了过滤器后其实不用判读了
        {
            result.put("isOk",true);
            result.put("user",user);
        }else {
            result.put("isOk",false);
        }
        return result;
    }

    @RequestMapping("/user/login")
    public Map login(User user, HttpServletRequest request){
        User userr = biz.checkPwd(user);
        Map map = new HashMap();
        System.out.println("lllllooo888::"+userr);
        if(userr!=null)
        {
            System.out.println("user/login->check::"+userr);
            request.getSession().setAttribute("user",userr);//加入session
            map.put("isOk",true);
            map.put("user",userr);
            map.put("msg","登录成功");
        }else {
            map.put("isOk",false);
            map.put("msg","登录失败,Id密码错误");
        }
        return map;
    }

    @RequestMapping("/user/quit")
    public Map quit(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        System.out.println("quit");
        Map map = new HashMap();
        map.put("isOk",true);
        return map;
    }

    @RequestMapping("/user/update")
    public Map update(User user,HttpServletRequest request )
    {
        Map<String, Object> result = new HashMap<>();
        biz.upUser(user);
        result.put("isOk",true);
        return result;
    }



    @RequestMapping("/user/register")
    public Map register(User user){
        System.out.println(user);
        this.biz.addUser(user);
        Map result=new HashMap<>();
        result.put("isOk",true);
        result.put("msg","注册成功");
        return result;
    }

    @RequestMapping("/user/list")
    public Map findUsers() {
        List<User> list = biz.findAll();
        Map result = new HashMap<>();
        result.put("isOk", true);
        result.put("msg", "查询成功");
        result.put("users", list);
        System.out.println(list);
        return result;
    }



    @RequestMapping("/user/del")
    public Map del(int userId) {
        Map result = new HashMap<>();
        if (biz.delUser(userId)) {
            result.put("isOk", true);
            result.put("msg", "删除成功");
        } else {
            result.put("isOk", false);
            result.put("msg", "删除失败");
        }
        return result;
    }





    public void setBiz(UserBiz biz) {
        this.biz = biz;
    }
}