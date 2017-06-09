package com.nextyu.web.controller;

import com.nextyu.constant.SwaggerParamTypeConstants;
import com.nextyu.domain.User;
import com.nextyu.service.UserService;
import com.nextyu.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * created on 2017-05-25 17:19
 *
 * @author nextyu
 */
@Api(value = "用户API", tags = "用户API")
@RefreshScope
@RequestMapping("/users")
@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${haha}")
    public String haha;

    @Autowired
    private UserService userService;


    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", response = User.class, responseContainer = "List")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object list(HttpServletRequest request) {

        System.out.println(haha + "-------------------------------------");

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            logger.info("{} : {}", headerName, request.getHeader(headerName));
        }

        return userService.listAll();
    }

    @ApiOperation(value = "根据id查找用户", notes = "根据id查找用户", response = UserVO.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true,
                    dataType = "Long", defaultValue = "1", paramType = SwaggerParamTypeConstants.PATH)
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @ApiOperation(value = "新建一个用户", notes = "新建一个用户", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = false, readOnly = true,
                    dataType = "Long", defaultValue = "", paramType = SwaggerParamTypeConstants.FORM),
            @ApiImplicitParam(name = "name", value = "用户名", required = true,
                    dataType = "String", defaultValue = "蝙蝠侠", paramType = SwaggerParamTypeConstants.FORM)
    })
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Object save(User user) {
        userService.save(user);
        return "success";
    }

    @ApiOperation(value = "更新一个用户", notes = "更新一个用户", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true,
                    dataType = "Long", defaultValue = "1", paramType = SwaggerParamTypeConstants.PATH),
            @ApiImplicitParam(name = "name", value = "用户名", required = true,
                    dataType = "String", defaultValue = "蝙蝠侠", paramType = SwaggerParamTypeConstants.FORM)
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Object update(@PathVariable Long id, User user) {
        userService.update(user);
        return "success";
    }

    @ApiOperation(value = "删除一个用户", notes = "删除一个用户", response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true,
                    dataType = "Long", defaultValue = "1", paramType = SwaggerParamTypeConstants.PATH)
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Object delete(@PathVariable Long id) {
        userService.deleteById(id);
        return "success";
    }

}
