package org.smart4j.chapter3.controller;

import com.json.smart4j.framework.annotation.Action;
import com.json.smart4j.framework.annotation.Controller;
import com.json.smart4j.framework.bean.Param;
import com.json.smart4j.framework.bean.View;
import org.json.smart4j.plugin.security.SecurityHelper;
import org.json.smart4j.plugin.security.exception.AuthcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 处理系统请求
 * Created by wh on 16/4/28.
 */
@Controller
public class SystemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);

    /**
     * 进入首界面
     * @return
     */
    @Action("get:/")
    public View index(){
        return new View("index.jsp");
    }
    @Action("get:/login")
    public View login(){
        return new View("login.jsp");
    }
    @Action("post:/login")
    public View loginSubmit(Param param){
        String username =param.getString("username");
        String password = param.getString("password");
        try {
            SecurityHelper.login(username,password);
        } catch (AuthcException e) {
            LOGGER.error("login failure", e);
            return new View("/login");
        }
        return new View("/customer");
    }
    @Action("get:/logout")
    public View logout(){
        SecurityHelper.logout();
        return new View("/");
    }
}
