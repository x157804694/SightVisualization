package com.jxufe.sight.service.imp;

import com.jxufe.sight.mapper.UserInfoMapper;
import com.jxufe.sight.service.UserService;
import com.jxufe.sight.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserInfoMapper userInfoMapper;

    public UserServiceImpl(){

    }

    @Autowired
    public UserServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public UserInfoVO findUser(String username, String password) {
        return userInfoMapper.findUser(username,password);
    }

    @Override
    public UserInfoVO findUserByName(String username) {
        return userInfoMapper.findUserByName(username);
    }

    @Override
    public UserInfoVO addUser(String username, String password, String nickname) {
        return userInfoMapper.addUser(username,password,nickname);
    }

    @Override
    public UserInfoVO findUserById(Long id) {
        return userInfoMapper.findUserById(id);
    }

    @Override
    public void updateUserByUsername(UserInfoVO userInfoVO) {
        userInfoMapper.updateUserByUsername(userInfoVO);
    }

    @Override
    public void updateAvatarByUsername(String username,String avatar) {
        userInfoMapper.updateAvatarByUsername(username,avatar);
    }

    @Override
    public UserInfoVO findByNickname(String nickname) {
        return userInfoMapper.findByNickname(nickname);
    }
}
