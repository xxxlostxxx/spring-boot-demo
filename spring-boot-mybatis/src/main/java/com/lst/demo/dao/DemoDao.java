package com.lst.demo.dao;


import com.lst.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DemoDao {
      User getUser(@Param("id") Long id);
}
