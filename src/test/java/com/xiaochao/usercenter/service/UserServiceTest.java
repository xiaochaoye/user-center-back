package com.xiaochao.usercenter.service;

import com.xiaochao.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author 超
 * @Date 2023/3/13 17:34
 */
@SpringBootTest     //必须加
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("123");
        user.setUserAccount("xiaoye");
        user.setAvatarUrl("https://fanyi-cdn.cdn.bcebos.com/static/translation/img/header/logo_e835568.png");
        user.setGender(0);
        user.setUserPassword("12345");
        user.setPhone("111");
        user.setEmail("1111");


        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        //非空测试
        String userAccount = "xiaochao";
        String userPassword = "";
        String checkPassword = "123456";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        //账户长度不小于4位数
        userAccount = "cho";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        //密码不小于8位数
        userAccount = "xeqeq";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        //账户不包含特殊字符
        userAccount = "3132 13";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        //密码与校验密码相同
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        //账户不能重复
        userAccount = "xi3123";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        //断言成功，返回的id大于0，注册是成功的
        userAccount = "2312313";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
    }
}
