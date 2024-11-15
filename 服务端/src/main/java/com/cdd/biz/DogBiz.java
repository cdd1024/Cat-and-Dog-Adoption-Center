package com.cdd.biz;

import com.cdd.entity.Dog;
import com.cdd.mapper.DogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogBiz {
    @Autowired
    private DogMapper dogMapper;

    public List<Dog> findAll(){return dogMapper.selectDogs();}

    public void addDog(Dog dog){
        this.dogMapper.insertDog(dog);
    }
    public boolean delDog(int dogId) {
        try {
            return this.dogMapper.deleteDogById(dogId) > 0;
        } catch (Exception e) {
            // 可以记录异常信息或者进行其他处理，比如抛出自定义异常
            e.printStackTrace();
            return false;
        }
    }

    public void setDogMapper(DogMapper dogMapper) {
        this.dogMapper = dogMapper;
    }
    public boolean updateDog(Dog dog){
        return this.dogMapper.updateDog(dog)>0;
    }
    public List<Dog> queDog(int id){
        return dogMapper.selectDogById(id);
    }
}
