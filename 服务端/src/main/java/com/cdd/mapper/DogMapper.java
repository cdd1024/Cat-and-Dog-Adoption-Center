package com.cdd.mapper;

import com.cdd.entity.Dog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DogMapper {
    @Select("select * from t_dog")
    List<Dog> selectDogs();
    @Insert("insert into t_dog values(null,#{breed},#{price},#{desc})")
    void insertDog(Dog dog);
    @Delete("delete from t_dog where dogid=#{id}")
    int deleteDogById(int id);
    @Select("select * from t_dog where dogid=#{id}")
    List<Dog> selectDogById(int id);
    @Update("update t_dog set breed=#{breed},price=#{price},`desc`=#{desc} where dogId=#{dogId}")
    int updateDog(Dog dog);
}
