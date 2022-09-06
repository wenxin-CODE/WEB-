package com.dly.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dly.springboot.common.Constants;
import com.dly.springboot.controller.dto.UserDTO;
import com.dly.springboot.entity.User;
import com.dly.springboot.exception.ServiceException;
import com.dly.springboot.mapper.UserMapper;
import com.dly.springboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dly.springboot.utils.TokenUtils;
import org.springframework.stereotype.Service;
import cn.hutool.log.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-06-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    private static final Log LOG = Log.get();

    @Override
    public UserDTO login(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if(one != null){
            BeanUtil.copyProperties(one,userDTO,true);
//            设置token
            String token = TokenUtils.genToken(one.getId().toString(),one.getPassword());
            userDTO.setToken(token);
            return userDTO;
        }else {
            throw new ServiceException(Constants.CODE_600, "用户名密码错误");
        }
    }

    @Override
    public User register(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if(one == null){
            one = new User();
            BeanUtil.copyProperties(userDTO,one,true);
            save(one);
        }else {
            throw new ServiceException(Constants.CODE_600, "用户已存在");
        }
        return one;
    }

    private User getUserInfo(UserDTO userDTO){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDTO.getUsername());
        queryWrapper.eq("password",userDTO.getPassword());
        User one;
//        解决重复问题
        try {
            one = getOne(queryWrapper);
        }catch (Exception e){
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500, "系统错误");
//            例如查出多个
        }
        return one;
    }
}
