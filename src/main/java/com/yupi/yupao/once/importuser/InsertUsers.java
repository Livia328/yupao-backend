package com.yupi.yupao.once.importuser;

import com.yupi.yupao.mapper.UserMapper;
import com.yupi.yupao.model.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

// 加上component注解，把它变成Spring的Bean
@Component
public class InsertUsers {

    @Resource
    private UserMapper userMapper;

    /**
     * 批量插入用户
     * Scheduled 这个注解是定时任务的注解，
     * initialDelay = 5000，延迟五秒后执行
     * fixedRate隔多少时间执行一次，这里定义为long的最大值，就是说隔非常长时间才执行一次
     *
     * 这里没有执行，去test-service-insertUserTest里写了
     */
//    @Scheduled(initialDelay = 5000, fixedRate = Long.MAX_VALUE)
    public void doInsertUsers() {
        // Spring帮助计时的小工具
        StopWatch stopWatch = new StopWatch();
        System.out.println("goodgoodgood");
        stopWatch.start();
        final int INSERT_NUM = 1000;
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假鱼皮");
            user.setUserAccount("fakeyupi");
            user.setAvatarUrl("https://636f-codenav-8grj8px727565176-1256524210.tcb.qcloud.la/img/logo.png");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("123");
            user.setEmail("123@qq.com");
            user.setTags("[]");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("11111111");
            userMapper.insert(user);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
