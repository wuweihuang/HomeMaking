package com.hm.web;


import com.hm.biz.UserBiz;
import com.hm.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
@Controller
@RequestMapping("/admin")
public class UserHandler {
    @Resource
    private UserBiz biz;
    private ModelAndView mav=null;
    @RequestMapping(value = "/userlogin.action")
    public ModelAndView userlogin(HttpServletRequest request, User user)
    {
        User u = biz.userLogin(user.getUserid(),user.getUserpwd());
        if(null!=u)
        {
            request.getSession().setAttribute("user",u);
            mav = new ModelAndView();
            mav.setViewName("index");

        }else {
            return null;
        }
        return mav;
    }
}
