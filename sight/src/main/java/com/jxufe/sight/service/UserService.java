package com.jxufe.sight.service;

import com.jxufe.sight.vo.UserInfoVO;

public interface UserService {
    UserInfoVO findUser(String username, String password);
    UserInfoVO findUserByName(String username);
    UserInfoVO addUser(String username,String password,String nickname);
    UserInfoVO findUserById(Long id);
    void updateUserByUsername(UserInfoVO userInfoVO);
    void updateAvatarByUsername(String username,String avatar);
    UserInfoVO findByNickname(String nickname);
}
