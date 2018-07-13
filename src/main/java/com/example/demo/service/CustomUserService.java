package com.example.demo.service;

import com.example.demo.dao.AdministorDao;
import com.example.demo.dao.StudentDao;
import com.example.demo.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService{


    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private AdministorDao administorDao;



    @Override
    public UserDetails loadUserByUsername(String userInput) throws UsernameNotFoundException {
        String[] information=userInput.split(";");
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        String rawDbPassword=null;
        List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>();
        if(information[1].equals("student")) {
            rawDbPassword = studentDao.queryStudentById(information[0]).getsPassword();
            authorities.add(new SimpleGrantedAuthority("STUDENT"));
        }
        else if(information[1].equals("teacher")){
            rawDbPassword = teacherDao.selectByPrimaryKey(information[0]).gettPassword();
            authorities.add(new SimpleGrantedAuthority("TEACHER"));
        }

        else if(information[1].equals("admin")){
            rawDbPassword = administorDao.selectByPrimaryKey(information[0]).getaPassword();
            authorities.add(new SimpleGrantedAuthority("ADMIN"));
        }

        String encodedDbPassword=bCryptPasswordEncoder.encode(rawDbPassword);
        return new User(information[0],encodedDbPassword,authorities);
    }
}
