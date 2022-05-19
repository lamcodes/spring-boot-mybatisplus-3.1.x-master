package com.example.mybatisplus.mapper;

import com.example.mybatisplus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author huzhiting
 * @since 2019-06-03
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    Map<String ,Object>   selectbb(int id);

    List<User> selecta(int age);
}
