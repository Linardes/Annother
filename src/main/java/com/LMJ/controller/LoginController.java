package com.LMJ.controller;

import com.LMJ.pojo.Administrator;
import com.LMJ.service.AdministratorService;
import com.LMJ.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/controller1")
public class LoginController {
    @Autowired(required = true)//true表示注入的时候，该bean必须存在，注入失败会报错;false表示如果有当前要注入的bean就注入，没有跳过，不会报错。
    private AdministratorService administratorService;
    @RequestMapping("/login")
    public String loginCheck(HttpServletRequest request, Administrator administrator,String verCode){
        // 获取session中的验证码
        String sessionCode = (String) request.getSession().getAttribute("captcha");
        // 判断验证码
        if (verCode==null || !sessionCode.equals(verCode.trim().toLowerCase())) {
            //return JsonResult.error("验证码不正确");
            request.setAttribute("msg","验证码错误");
            return "login";
        }
        String name=administrator.getName();
        administrator=administratorService.getAdministrator(name);
        if(administrator!=null) {
            String password = administrator.getPsw();
            String psw=administrator.getPsw();
            if(psw.equals(password)) {
                request.getSession().setAttribute("name",name);
                return "main";
            }
            else{
                request.setAttribute("msg","密码错误");
                return "login";
            }
        }else {
                request.setAttribute("msg","用户不存在");
                return "login";
        }
    }
}
