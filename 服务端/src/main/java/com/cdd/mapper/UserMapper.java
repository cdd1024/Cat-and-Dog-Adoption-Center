package com.cdd.mapper;

import com.cdd.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface UserMapper {
    @Select("SELECT * FROM t_user")
    List<User> selectAllUsers(); // 查询所有用户信息

    @Insert("insert into t_user values(null,#{userA},#{userPwd},#{shenfen},#{phone})")
    void insertUser(User user);

    @Delete("DELETE FROM t_user WHERE userId = #{userId}")
    int deleteUserById(int userId); // 根据用户编号删除用户

    @Select("SELECT * FROM t_user WHERE userId = #{userId}")
    User selectUserById(int userId); // 根据编号查找用户

    @Update("UPDATE t_user SET userA = #{userA}, userPwd = #{userPwd}, shenfen = #{shenfen}, phone = #{phone} WHERE userId = #{userId}")
    void updateUser(User user);
}
