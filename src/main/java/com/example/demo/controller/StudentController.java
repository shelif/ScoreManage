package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.StKey;
import com.example.demo.entity.Student;
import com.example.demo.service.RespEntity;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {


    @Autowired
    private StudentService studentService;



    // 功能：跳转到学生子功能的home目录
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        String studentId=userDetails.getUsername();
        return "/student/home";

    }

    // 功能：返回学生基本信息
    @ResponseBody
    @RequestMapping(value = "/homeGET",method = RequestMethod.GET)
    public RespEntity homeGetRespEntity(){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String sId=userDetails.getUsername();
        RespEntity respEntit= studentService.homeGetRespService(sId);
        return respEntit;
    }

    // 功能：跳转到课程搜索界面
    @RequestMapping(value = "/lesson_search", method = RequestMethod.GET)
    public String lesson_search(Model model){

        return "/student/lesson_search";
    }

    // 功能：跳转到课程显示界面
    @RequestMapping(value = "/lesson_display", method = RequestMethod.GET)
    public String lesson_display(){

        return "/student/lesson_display";
    }

    // 功能：跳转到课程删除界面
    @RequestMapping(value = "/lesson_delete", method = RequestMethod.GET)
    public String lesson_delete(){

        return "/student/lesson_delete";
    }

    // 功能：跳转到自我信息查询界面
    @RequestMapping(value = "/infor_self", method = RequestMethod.GET)
    public String infor_self(){

        return "/student/infor_self";
    }

    // 功能：跳转到他人信息查询功能界面
    @RequestMapping(value = "/infor_other", method = RequestMethod.GET)
    public String infor_other(){

        return "/student/infor_other";
    }

//    @RequestMapping(value = "/lesson_search_result", method = RequestMethod.GET)
//    public String lesson_search_result(Model model, @RequestParam("search_Cno") String cno,
//                                       @RequestParam("search_Cname") String cname,@RequestParam("search_Ccredit") String credit,
//                                       @RequestParam("search_teacher") String teacher, @RequestParam("search_Class") String Cclass,
//                                       @RequestParam("search_Cplace") String Cplace, @RequestParam("day") String Cday,
//                                       @RequestParam("section") String Csection)
//    {
//        model.addAttribute("search_Cno", cno);
//        model.addAttribute("search_Cname", cname);
//        model.addAttribute("search_Ccredit", credit);
//        model.addAttribute("search_teacher", teacher);
//        model.addAttribute("search_Class", Cclass);
//        model.addAttribute("search_Cplace", Cplace);
//        model.addAttribute("day", Cday);
//        model.addAttribute("section", Csection);
////        model.addAttribute("id", id);
////        model.addAttribute("name", name);
//
//        return "student/lesson_search_result";
//    }

    // 功能：跳转到课程查找结果页面
    @RequestMapping(value ="/coursesFindResult", method = RequestMethod.GET)
    public String studentFindResult(@RequestParam("searchType") String searchType,@RequestParam("searchValue") String searchValue){

        return "/student/lesson_search_result";
    }

    // 功能：查询课程
    // 字段：
    // param：{1 : 学生学号} or {2 : 学生姓名}
    @ResponseBody
    @RequestMapping(value = "/queryCourses",method = RequestMethod.GET)
    public RespEntity queryCourses(@RequestParam Map<String,Object> param){
        Course course = new Course();
        if(param.get("1") != null) course.setcId((String) param.get("1"));
        else if(param.get("2") != null) course.setcName((String) param.get("2"));

        RespEntity respEntity=studentService.queryCourses(course);
        return respEntity;
    }

    // 功能：获得学生的学号
    @ResponseBody
    @RequestMapping(value = "/getSId",method = RequestMethod.GET)
    public RespEntity getSId(){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String sId=userDetails.getUsername();

        return new RespEntity(0, "ok", sId);
    }

    // 功能：选课
    // 字段：
    // param：{"tcid" : tcid}
    @ResponseBody
    @RequestMapping(value = "/chooseCourse", method = RequestMethod.GET)
    public RespEntity chooseCourse(@RequestParam Map<String,Object> param){
        StKey stKey = new StKey();

        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String sId=userDetails.getUsername();

        stKey.setStSId(sId);
        stKey.setStTcId((String ) param.get("tcid"));

        RespEntity respEntity = studentService.chooseCourse(stKey);
        return respEntity;
    }

    // 功能：在删除课程的界面显示课程信息
    @ResponseBody
    @RequestMapping(value = "/showCourseInfoForDelete", method = RequestMethod.GET)
    public RespEntity showCourseInfoForDelete(){

        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String sId=userDetails.getUsername();

        RespEntity respEntity = studentService.showCourseInfoThatHasBeenChoosen(sId);
        return respEntity;
    }

    // 功能：显示学生的选课信息
    @ResponseBody
    @RequestMapping(value = "/showCourseInfo", method = RequestMethod.GET)
    public RespEntity showCourseInfo(){

        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String sId=userDetails.getUsername();

        RespEntity respEntity = studentService.showCourseInfoThatHasBeenChoosen(sId);
        return respEntity;
    }

    // 功能：显示课程以及其分数的信息
    @ResponseBody
    @RequestMapping(value = "/showCourseInfoAndScore", method = RequestMethod.GET)
    public RespEntity showCourseInfoAndScore(){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String sId=userDetails.getUsername();

        RespEntity respEntity = studentService.showCourseInfoAndScoreThatHasBeenChoosen(sId);
        return respEntity;
    }

    // 功能：
    @ResponseBody
    @RequestMapping(value = "/showCourseTableInfo", method = RequestMethod.GET)
    public RespEntity showCourseTableInfo(){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String sId=userDetails.getUsername();
        System.out.println(sId);
        RespEntity respEntity = studentService.showCourseTableInfoThatHasBeenChoosen(sId);
        return respEntity;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteCourse", method = RequestMethod.GET)
    public RespEntity deleleCourse(@RequestParam Map<String,Object> param){

//        System.out.println("deleteCourse");
        StKey stKey = new StKey();

        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String sId=userDetails.getUsername();

        stKey.setStSId(sId);
        stKey.setStTcId((String ) param.get("tcid"));


 //       System.out.println("judge: " + ((String)param.get("tcid")).equals(" 011"));
 //       System.out.println((String)param.get("stuInfo") + " " + (String ) param.get("tcid"));

        RespEntity respEntity = studentService.deleteCourse(stKey);
        return respEntity;
    }

    // 功能：跳转到查询他人信息的界面
    @RequestMapping(value = "/queryOtherInfo", method = RequestMethod.GET)
    public String queryOtherInfo(@RequestParam("searchType") String searchType,@RequestParam("searchValue") String searchValue){

        return "/student/infor_other_result";
    }

    // 功能：调用查找他人信息的服务
    // 传入参数：学生的学号或姓名
    @ResponseBody
    @RequestMapping(value = "/queryOtherInfoAndShow",method = RequestMethod.GET)
    public RespEntity queryOtherInfoAndShow(@RequestParam Map<String,Object> param){
        RespEntity respEntity = new RespEntity();

        if(param.get("1") != null)
        {
            respEntity=studentService.queryOtherInfoBySId((String) param.get("1"));
        }
        else if(param.get("2") != null)
        {
            respEntity =studentService.queryOtherInfoBySname((String) param.get("2"));
        }
        return respEntity;
    }

    // 功能：跳转到修改密码的界面
    @RequestMapping(value = "/modifypsw", method = RequestMethod.GET)
    public String modifypsw(){
        return "/student/modifyPassword";
    }

    // 功能：进行密码修改
    // 调用修改密码的服务
    @ResponseBody
    @RequestMapping(value = "/modifyPasswordGET",method = RequestMethod.GET)
    public RespEntity modifyPasswordGETRespEntity(@RequestParam Map<String, Object> param){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        String uId=userDetails.getUsername();
        return studentService.modifyPasswordGetService(uId,param);
    }
}
