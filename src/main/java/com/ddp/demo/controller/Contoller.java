package com.ddp.demo.controller;

import com.ddp.demo.config.DBContextHolder;
import com.ddp.demo.entity.User;
import com.ddp.demo.service.DBChangeService;
import com.ddp.demo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class Contoller {

    @Resource
    private DBChangeService dbChangeServiceImpl;
    @Resource
    UserService userService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/test")
    public  String test() throws Exception {

        //切换到数据库dbtest2
        String datasourceId="dbtest2";
        dbChangeServiceImpl.changeDb(datasourceId);
        List<User> userList= userService.queryUserInfo();
        System.out.println(userList.toString());

        //再切换到数据库dbtest3
        dbChangeServiceImpl.changeDb("dbtest3");
        List<User> userList3= userService.queryUserInfo();
        System.out.println(userList3.toString());


        //切回主数据源
        DBContextHolder.clearDataSource();
        return "ok";

        //每一次changeDb时 都会清空threadloacal，这会导致AbstractRoutingDataSource 使用默认数据源

        //关于不懂数据源的分布式事务 参考https://blog.csdn.net/qq_35387940/article/details/103474353
    }
}
