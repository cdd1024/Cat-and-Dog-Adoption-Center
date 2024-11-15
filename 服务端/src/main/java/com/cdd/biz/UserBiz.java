package com.cdd.biz;

import com.cdd.entity.User;

import com.cdd.mapper.UserMapper;
import com.cdd.util.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBiz {
    @Autowired
    private UserMapper userMapper;
    public List<User> findAll() {
        return userMapper.selectAllUsers();
    }

    public void addUser(User user) {
        this.userMapper.insertUser(user);
    }

    public User checkPwd(User user){
        User dbUser= userMapper.selectUserById(user.getUserId());

        if(dbUser!=null && dbUser.getUserPwd().equals(user.getUserPwd())){
            return dbUser;
        }else {
            throw new MyException("登录失败，账号不存在或密码错误");
        }
    }

    public void upUser(User user){
        userMapper.updateUser(user);
    }
    public boolean delUser(int userId) {
        return userMapper.deleteUserById(userId) > 0;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


}
