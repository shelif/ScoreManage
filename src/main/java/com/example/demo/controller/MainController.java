package com.example.demo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

import javax.servlet.http.HttpSession;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    //根据用户类型跳转到相应首页
    @RequestMapping("/home")
    public String home() {
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Collection<? extends GrantedAuthority> grantedAuthorityList=userDetails.getAuthorities();
        for(GrantedAuthority grantedAuthority:grantedAuthorityList){
            if(grantedAuthority.toString()=="STUDENT")
                return "redirect:/student/";
            if(grantedAuthority.toString()=="TEACHER")
                return "redirect:/teacher/";
            if(grantedAuthority.toString()=="ADMIN")
                return "redirect:/admin/";
        }
        return "/login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
