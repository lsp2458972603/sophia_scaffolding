package com.scaffolding.sophia.admin.biz.controller;

import com.scaffolding.sophia.admin.api.vo.UserVo;
import com.scaffolding.sophia.admin.biz.service.user.UserService;
import com.scaffolding.sophia.common.base.support.ApiResponse;
import com.scaffolding.sophia.common.base.support.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: LHL
 * @ProjectName: sophia_scaffolding
 * @Package: com.scaffolding.sophia.admin.biz.controller
 * @ClassName: UserController
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/info/vo")
    public ApiResponse userVoList(@RequestBody UserVo userVo) {
        List<UserVo> userList = userService.findUserVoList(userVo);
        return success(userList);
    }

    @GetMapping("/info/{id}")
    public ApiResponse getUserByUserId(@PathVariable Long id) {
        return success(userService.loadUserByUserId(id));
    }

    @GetMapping("/api")
    public ApiResponse getUserByUserName(@RequestParam String username) {
        return success(userService.loadUserByUserName(username));
    }
}
