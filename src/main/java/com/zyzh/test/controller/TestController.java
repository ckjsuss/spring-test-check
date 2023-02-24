package com.zyzh.test.controller;

import com.zyzh.check.annotation.DoCheck;
import com.zyzh.check.annotation.DoChecks;
import com.zyzh.check.entype.Check;
import com.zyzh.test.result.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: TestController
 * @Description:
 * @author: Leo wey
 * @date: 2023/2/22 16:42
 * @Version: 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * 测试参数校验
     *
     * @param email
     * @return
     */

    @DoCheck(value = Check.Email, arg = "email", msg = "邮箱格式不正确！")
    @DoCheck(value = Check.Telephone, arg = "telephone", msg = "电话格式不正确！")
    @GetMapping("/send")
    public R<String> send(@RequestParam("email") String email,@RequestParam("telephone") String telephone) {
        logger.info("校验参数：{},{}", email, telephone);
        return R.success("发送成功");
    }
}