package com.jxufe.sight.service;

import com.jxufe.sight.vo.UserInfoVO;

public interface UserService {
    public UserInfoVO findUser(String username, String password);
    public UserInfoVO findUserByName(String username);
    public UserInfoVO addUser(String username,String password,String nickname);
    public UserInfoVO findUserById(Long id);
}
