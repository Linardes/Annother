package com.LMJ.controller;

import com.LMJ.pojo.Administrator;
import com.LMJ.service.AdministratorService;
import com.LMJ.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("control")
public class JumpController {
    @Autowired(required = true)//true表示注入的时候，该bean必须存在，注入失败会报错;false表示如果有当前要注入的bean就注入，没有跳过，不会报错。
    private AdministratorService administratorService;
    @RequestMapping("/login")
    public String loginCheck(HttpServletRequest request, Administrator administrator){
        String name=administrator.getName();
        String psw= MD5Util.getMD5(administrator.getPsw());
        administrator=administratorService.getAdministrator(name);
        if(administrator!=null) {
            String password = administrator.getPsw();
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
