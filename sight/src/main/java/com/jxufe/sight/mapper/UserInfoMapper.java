package com.jxufe.sight.mapper;

import com.jxufe.sight.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoMapper {
    UserInfoVO findUser(@Param("username") String username,@Param("password") String password);
    UserInfoVO findUserByName(@Param("username") String username);
    UserInfoVO addUser(@Param("username") String username,@Param("password") String password,
                       @Param("nickname") String nickname);
    UserInfoVO findUserById(@Param("id") Long id);
    void updateUserByUsername(@Param("user") UserInfoVO userInfoVO);
    void updateAvatarByUsername(@Param("username") String username,@Param("avatar") String avatar);
    UserInfoVO findByNickname(@Param("nickname") String nickname);
}
