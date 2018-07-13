package com.example.demo.controller;

import com.example.demo.entity.ScModel;
import com.example.demo.entity.TeachingClass;
import com.example.demo.service.RespEntity;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/teacher")
@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/")
    public String index(){
        return  "/teacher/teacher_homepage";
    }

    //返回教师基本信息
    @RequestMapping(value = "/homeGET",method = RequestMethod.GET)
    @ResponseBody
    public RespEntity homeGETRespEntity(){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        String uId=userDetails.getUsername();
        return teacherService.homeGETRespService(uId);

    }

    @RequestMapping(value = "/t_search_class")
    public String t_search_class(){
        return "/teacher/t_search_class";
    }

    @RequestMapping(value="/t_search_result")
    public String t_search_result(@RequestParam("attrType") String attrType, @RequestParam("attrValue") String attrValue){
        return "/teacher/t_search_result";
    }

    //返回教师查询结果
    @ResponseBody
    @RequestMapping(value = "/t_search_resultGET",method = RequestMethod.GET)
    public RespEntity t_search_resultGETRespEntity(@RequestParam Map<String, Object> param){
        return teacherService.t_search_resultGETRespService(param);
    }

    @RequestMapping(value="/t_submit_class")
    public String t_submit_class(){
        return "/teacher/t_submit_class";
    }

    //获取创建课程的信息，反回创建结果
    @ResponseBody
    @RequestMapping(value ="/t_submit_classPOST",method = RequestMethod.POST)
    public RespEntity t_submit_classPOSTRespEntity(@RequestBody TeachingClass teachingClass){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        teachingClass.setTcTId(userDetails.getUsername());
        return teacherService.t_submit_classPOSTService(teachingClass);
    }

    @RequestMapping(value = "/t_classes")
    public String t_classes(){
        return "/teacher/t_classes";
    }

    //返回教师开课信息
    @ResponseBody
    @RequestMapping(value = "/t_classesGET",method = RequestMethod.GET)
    public RespEntity t_classesRespEntity(){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String tId=userDetails.getUsername();
        return teacherService.t_classesGETService(tId);
    }

    @RequestMapping(value = "/t_delete_cal")
    public String  t_delete_cal(){
        return "/teacher/t_delete_cal";
    }

    //返回教师教师
    @ResponseBody
    @RequestMapping(value="/t_delete_calGET",method = RequestMethod.GET)
    public RespEntity t_delete_calRespEntity(){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String tId=userDetails.getUsername();
        return teacherService.t_delete_calGET(tId);
    }

    //返回删除信息
    @ResponseBody
    @RequestMapping(value="/t_delete_calDELETE",method = RequestMethod.DELETE)
    public RespEntity t_delete_calRespDeleteEntity(@RequestBody TeachingClass teachingClass){
        System.out.println("hehe"+teachingClass.toString());
        return teacherService.t_delete_calDELETE(teachingClass);

    }

    @RequestMapping(value = "/t_submitgrade")
    public String t_submitgrade(){
        return "/teacher/t_submitgrade";
    }

    //返回当前的成绩信息
    @ResponseBody
    @RequestMapping(value = "/t_submitgradeGET",method = RequestMethod.GET)
    public RespEntity t_submitgradeGETRespEntity(){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String tId=userDetails.getUsername();
        System.out.println("hehe"+teacherService.t_submitgradeGetService(tId));
        return teacherService.t_submitgradeGetService(tId);
    }

    @RequestMapping(value = "/tosubmit")
    public String tosubmit(@RequestParam String tcid,@RequestParam String cid){
        return "/teacher/tosubmit";
    }


    //上传课程的之前的信息
    @ResponseBody
    @RequestMapping(value = "/tosubmitGET",method = RequestMethod.GET)
    public RespEntity tosubmitGETRespEntity(@RequestParam Map<String,Object> param){
        return teacherService.tosubmitGETService(param);
    }

    //返回之前的课表信息
    @ResponseBody
    @RequestMapping(value="/tosubmitPUT",method = RequestMethod.PUT)
    public RespEntity tosubmitPUTRespEntity(@RequestBody List<ScModel> scModels){
        return teacherService.tosubmitPUTService(scModels);
    }

    @RequestMapping(value="/t_grades")
    public String t_grades(){
        return "/teacher/t_grades";
    }

    //返回教学班信息
    @ResponseBody
    @RequestMapping(value = "/t_gradesGET",method = RequestMethod.GET)
    public RespEntity t_gradesGETRespEntity(){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String tId=userDetails.getUsername();
        return teacherService.t_gradesGetService(tId);
    }

    @RequestMapping(value="/t_selected_grade")
    public String t_selected_grade(){
        return "/teacher/t_selected_grade";
    }

    //返回教学班内的成绩信息
    @ResponseBody
    @RequestMapping(value="/t_selected_gradeGET",method = RequestMethod.GET)
    public RespEntity t_selected_gradeGETRespEntity(@RequestParam Map<String,Object> param){
        return teacherService.tosubmitGETService(param);
    }

    @RequestMapping(value = "/t_personal_info")
    public String t_personal_info(){
        return "/teacher/t_personal_info";
    }

    //返回个人信息
    @ResponseBody
    @RequestMapping(value = "/t_personal_infoGET",method = RequestMethod.GET)
    public RespEntity t_personal_infoGETRespEntity(){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String tId=userDetails.getUsername();
        return teacherService.t_personal_infoGetService(tId);
    }

    @RequestMapping(value = "/t_other_info")
    public String t_other_info(){
        return "/teacher/t_other_info";
    }

    @RequestMapping(value = "/t_search_other_reslt")
    public String t_search_other_reslt(){
        return "/teacher/t_search_other_reslt";
    }


    //返回其他人的信息
    @ResponseBody
    @RequestMapping(value = "/t_search_other_resltGET",method = RequestMethod.GET)
    public RespEntity t_other_info(@RequestParam Map<String,Object> param){
        return teacherService.t_other_infoGET(param);
    }

    @RequestMapping(value = "/modifyPassword")
    public String modifyPasswrod(){
        return "/teacher/modifyPassword";
    }

    @ResponseBody
    @RequestMapping(value = "/modifyPasswordGET",method = RequestMethod.GET)
    public RespEntity modifyPasswordGETRespEntity(@RequestParam Map<String, Object> param){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        String uId=userDetails.getUsername();
        return teacherService.modifyPasswordGetService(uId,param);
    }
}
