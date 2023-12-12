package com.example.game.service.impl;

import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.example.game.controller.param.UserLoginParam;
import com.example.game.controller.param.UserRegisterParam;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.example.game.dto.UserSimpleInfo;
import com.example.game.entity.User;
import com.example.game.entity.table.UserTableDef;
import com.example.game.enums.UserStatusEnum;
import com.example.game.mapper.UserMapper;
import com.example.game.service.UserService;
import com.example.game.util.PasswordHashUtils;
import com.example.game.util.SaltUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 用户表 服务层实现。
 *
 * @author YangX
 * @since 2023-07-31
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Value("${default.user.avatar}")
    private String defaultAvatar;

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(String username) {

        if (!StringUtils.hasText(username)) {
            return null;
        }
        return userMapper.getUserByUserName(username);
    }

    @Override
    public UserSimpleInfo getUserSimpleInfo(Integer userId) {

        if(userId == null || userId <= 0){
            return null;
        }

        User user = userMapper.selectOneById(userId);
        if(user == null){
            return null;
        }

        UserSimpleInfo userSimpleInfo = new UserSimpleInfo();
        BeanUtil.copyProperties(user, userSimpleInfo, false);
        return userSimpleInfo;
    }

    @Override
    public Boolean verify(User currentUser, UserLoginParam param) throws NoSuchAlgorithmException {

        if (StringUtils.isEmpty(param.getUserName()) || StringUtils.isEmpty(param.getPassword())) {
            return false;
        }

        String salt = currentUser.getSalt();
        String hash = PasswordHashUtils.hashPassword(param.getPassword(), salt);// 加盐
        return currentUser.getPassword().equals(hash);
    }

    @Override
    public SaResult register(UserRegisterParam user) throws NoSuchAlgorithmException {

        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {
            return SaResult.error("账号和密码不能为空");
        }

        User currentUser = this.getUser(user.getUserName());
        if (currentUser != null) {
            return SaResult.error("当前用户名已存在");
        }

        String salt = SaltUtils.getSalt();
        String hash = PasswordHashUtils.hashPassword(user.getPassword(), salt);// 加盐

        User u = new User();
        u.setUserName(user.getUserName());
        u.setPassword(hash);
        u.setSalt(salt);
        u.setAvatar(defaultAvatar);
        u.setGender(user.getGender().name());
        u.setProsperityValue(0);
        u.setCityLevel("1"); //默认从1级开始
        u.setCoinNum(0);
        u.setStatus(UserStatusEnum.USAGE.name());
        u.setCreateAt(new Date());
        u.setCreateBy(0L);
        u.setIsDel(Boolean.FALSE);
        int count = userMapper.insert(u);
        if (count <= 0) {
            return SaResult.error("添加失败");
        }

        return SaResult.ok();
    }

    @Override
    public List<User> getByIds(List<Long> ids) {
        if(CollectionUtil.isEmpty(ids)){
            return Collections.emptyList();
        }
        return this.getByIds(ids);
    }

    @Override
    public List<User> getListByLikeIdOrLikeName(String idOrName) {

        if(!StringUtils.hasText(idOrName)){
            return Collections.emptyList();
        }

        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .from(UserTableDef.USER)
                .where("id like '%" + idOrName + "%' or user_name like '%" + idOrName + "%'");
        return this.list(queryWrapper);
    }
}