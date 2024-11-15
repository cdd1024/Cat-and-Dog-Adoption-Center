package com.cdd.controller;

import com.cdd.biz.DogBiz;
import com.cdd.entity.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DogController {
    @Autowired
    private DogBiz biz;
    @RequestMapping("/dog/list")
    public Map findDogs(){
        List<Dog> list=biz.findAll();
        Map result=new HashMap<>();
        result.put("isOk",true);
        result.put("msg","查询成功");
        result.put("dogs",list);

        return result;
    }
    @RequestMapping("/dog/add")
    public Map add(Dog dog){
        this.biz.addDog(dog);
        Map result=new HashMap<>();
        result.put("isOk", true);
        result.put("msg", "添加成功");
        return result;
    }
    @RequestMapping("/dog/del")
    public Map del(int id){
        Map result = new HashMap<>();
        if(this.biz.delDog(id)){
            result.put("isOk", true);
            result.put("msg", "删除成功");
        } else {
            result.put("isOk", false);
            result.put("msg", "删除失败");
        }

        return result;
    }
    @RequestMapping("/dog/update")
    public Map update(Dog dog){
        Map result = new HashMap<>();
        if(this.biz.updateDog(dog)){
            result.put("isOk", true);
            result.put("msg", "编辑成功");
        } else {
            result.put("isOk", false);
            result.put("msg", "编辑失败");
        }
        return result;
    }

    @RequestMapping("/dog/que")
    public Map que(int id){
        List<Dog> list=biz.queDog(id);
        Map result = new HashMap<>();
        result.put("isOk", true);
        result.put("msg", "查询成功");
        result.put("dogs", list);
        return result;
    }
    public void setBiz(DogBiz biz){
        this.biz=biz;
    }
}
