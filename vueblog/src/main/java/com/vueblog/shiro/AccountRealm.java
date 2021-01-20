package com.vueblog.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.vueblog.entity.User;
import com.vueblog.service.UserService;
import com.vueblog.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm  extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
        //类型判断，保证强转
    }

    //密码验证，并获取用户权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        JwtToken jwtToken = (JwtToken) token;
        //强制类型转换

        //获取id
        String userId = jwtUtils.getClaimByToken((String)jwtToken.getPrincipal()).getSubject();
        //查询用户
        User user = userService.getById(Long.valueOf(userId));
        //判定状态
        if(user == null){
            throw new UnknownAccountException("用户不存在");
        }

        if(user.getStatus() == -1){
            throw new LockedAccountException("用户已被锁定");
        }

        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user,profile);
        //绑定
        return new SimpleAuthenticationInfo(profile,jwtToken.getCredentials(),getName());
    }
}
