package com.example.demo.controller;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.AdminService;
import com.example.demo.service.RespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//管理员系统的Controller
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    //返回主页
    @RequestMapping(value = "/")
    public String home() {
        return "/admin/home";
    }


    //返回基本信息
    @ResponseBody
    @RequestMapping(value = "/homeGET", method = RequestMethod.GET)
    public RespEntity homeGet(@RequestParam Map<String, Object> param) {
        System.out.println("heihei" + param.toString());
        RespEntity respEntity = adminService.homeResp();
        return respEntity;
    }

    //学生详情
    @RequestMapping(value = "/studentDetail")
    public String studentDetail() {
        return "/admin/studentDetail";
    }

    //返回所有的学生详情
    @ResponseBody
    @RequestMapping(value = "/studentDetailGET", method = RequestMethod.GET)
    public RespEntity studentDetailGet() {
        RespEntity respEntity = adminService.studentDetailResp();
        return respEntity;
    }

    //教师详情
    @RequestMapping(value = "/teacherDetail")
    public String teacherDetail() {
        return "/admin/teacherDetail";
    }

    //返回所有教师的信息
    @ResponseBody
    @RequestMapping(value = "/teacherDetailGET", method = RequestMethod.GET)
    public RespEntity teacherDetailGet() {
        RespEntity respEntity = adminService.teacherDetailResp();
        return respEntity;
    }

    //课程详情页面
    @RequestMapping(value = "/courseDetail")
    public String courseDetail() {
        return "/admin/courseDetail";
    }

    //返回所有课程的信息
    @ResponseBody
    @RequestMapping(value = "/courseDetailGET", method = RequestMethod.GET)
    public RespEntity courseDetailGet() {
        RespEntity respEntity = adminService.courseDetailResp();
        return respEntity;
    }

    @RequestMapping(value = "/studentManageAdd")
    public String studentManageAdd() {
        return "/admin/studentManageAdd";
    }

    //添加学生，返回成功或失败
    @ResponseBody
    @RequestMapping(value = "/studentManageAddPOST", method = RequestMethod.POST)
    public RespEntity studentManageAddRespEntity(@RequestBody Student student) {
        student.setsGpa(0);
        student.setsIQ(0);
        student.setsTotalScore(0);
        student.setsUsername(student.getsId());
        RespEntity respEntity = adminService.studentManageAddRespService(student);
        return respEntity;
    }

    @RequestMapping(value = "/studentManageDelete")
    public String studentManageDelete() {
        return "/admin/studentManageDelete";
    }

    //返回是否删除成功
    @ResponseBody
    @RequestMapping(value = "/studentManageDeleteDELETE", method = RequestMethod.DELETE)
    public RespEntity studentManageDeleteRespEntity(@RequestBody Student student) {

        RespEntity respEntity = adminService.studentManageDeleteService(student.getsId());
        return respEntity;
    }


    @RequestMapping(value = "/studentManageFind")
    public String studentManageFind() {
        return "/admin/studentManageFind";
    }


    @RequestMapping(value = "/studentFindResult")
    public String studentFindResult(@RequestParam("attrType") String attrType, @RequestParam("attrValue") String attrValue) {
        return "/admin/studentFindResult";
    }

    //返回学生的查询结果
    @ResponseBody
    @RequestMapping(value = "/studentFindResultGET", method = RequestMethod.GET)
    public RespEntity studentFindResultGETRespEntity(@RequestParam Map<String, Object> param) {
        Student student = new Student();
        if (param.get("sId") != null) student.setsId((String) param.get("sId"));
        else if (param.get("sClass") != null) student.setsClass((String) param.get("sClass"));
        else if (param.get("sMajor") != null) student.setsMajor((String) param.get("sMajor"));
        System.out.println("hehe" + student.toString());
        RespEntity respEntity = adminService.studentFindResultService(student);
        return respEntity;
    }


    @RequestMapping(value = "/studentManageModify")
    public String studentManageModify() {
        return "/admin/studentManageModify";
    }

    @RequestMapping(value = "/studentModifyResult")
    public String studentModifyResult() {
        return "/admin/studentModifyResult";
    }


    //成功后返回更新后此学生的信息，失败后返回错误码
    @RequestMapping(value = "studentModifyResultPUT", method = RequestMethod.PUT)
    @ResponseBody
    public RespEntity studentModifyResultPUTRespEntity(@RequestBody Student student) {
        RespEntity respEntity = adminService.studentModifyResultService(student);
        return respEntity;

    }

    //返回有学生修改前的信息
    @RequestMapping(value = "studentModifyResultGET", method = RequestMethod.GET)
    @ResponseBody
    public RespEntity studentModifyResultGETRespEntity(@RequestParam Map<String, Object> param) {
        RespEntity respEntity = adminService.studentModifyResultGetService(param);
        return respEntity;
    }

    @RequestMapping(value = "teacherManageAdd")
    public String teacherManageAdd() {
        return "/admin/teacherManageAdd";
    }

    //返回teacher查询信息
    @ResponseBody
    @RequestMapping(value = "teacherManageAddPOST", method = RequestMethod.POST)
    public RespEntity teacherManageAddPostRespEntity(@RequestBody Teacher teacher) {
        return adminService.teacherManageAddPostRespService(teacher);
    }

    @RequestMapping(value = "/teacherManageFind")
    public String teacherManageFind() {
        return "/admin/teacherManageFind";
    }

    @RequestMapping(value = "/teacherFindResult")
    public String teacherFindResult(@RequestParam("attrType") String attrType, @RequestParam("attrValue") String attrValue) {
        return "/admin/teacherFindResult";
    }

    //返回教师查询信息结果
    @ResponseBody
    @RequestMapping(value = "/teacherFindResultGET", method = RequestMethod.GET)
    public RespEntity teacherFindResultGETRespEntity(@RequestParam Map<String, Object> param) {
        Teacher teacher = new Teacher();
        if (param.get("tId") != null) teacher.settId((String) param.get("tId"));
        else if (param.get("tName") != null) teacher.settName((String) param.get("tName"));
        RespEntity respEntity = adminService.teacherFindResultService(teacher);
        return respEntity;
    }

    @RequestMapping(value = "/teacherManageDelete")
    public String teacherManageDelete() {
        return "/admin/teacherManageDelete";
    }

    //返回删除结果
    @RequestMapping(value = "/teacherManageDeleteDELETE", method = RequestMethod.DELETE)
    @ResponseBody
    public RespEntity teacherManageDeleteDELETERespEntity(@RequestBody Teacher teacher) {
        return adminService.teacherManageDeleteService(teacher);
    }

    @RequestMapping(value = "/teacherManageModify")
    public String teacherManageModify() {
        return "/admin/teacherManageModify";
    }

    @RequestMapping(value = "/teacherModifyResult")
    public String teacherModifyResult() {
        return "/admin/teacherModifyResult";
    }

    //返回修改前的教师信息
    @ResponseBody
    @RequestMapping(value = "/teacherModifyResultGET", method = RequestMethod.GET)
    public RespEntity teacherModifyResultGETRespEntity(@RequestParam Map<String, Object> param){
        return adminService.teacherModifyResultGetService(param);
    }

    //返回修改后的教师
    @ResponseBody
    @RequestMapping(value = "/teacherModifyResultPUT", method = RequestMethod.PUT)
    public RespEntity teacherModifyResultPUTRespEntity(@RequestBody Teacher teacher){
        return adminService.teacherModifyResultPutService(teacher);
    }

    @RequestMapping(value ="/courseManageAdd")
    public String courseManageAdd(){
        return "/admin/courseManageAdd";
    }

    //返回课程是否修改成功
    @ResponseBody
    @RequestMapping(value = "/courseManageAddPOST",method = RequestMethod.POST)
    public RespEntity courseManageAddPOSTRespEntity(@RequestBody Course course){
        return adminService.courseManageAddRespService(course);
    }

    @RequestMapping(value = "/courseManageDelete")
    public String courseManageDelete(){
        return "/admin/courseManageDelete";
    }

    //返回删除课程是否成功
    @ResponseBody
    @RequestMapping(value = "/courseManageDeleteDELETE",method = RequestMethod.DELETE)
    public RespEntity courseManageDeleteDELETERespEntity(@RequestBody Course course){
        return adminService.courseManageDeleteService(course);
    }

    @RequestMapping(value = "/courseManageFind")
    public String courseManageFind(){
        return "/admin/courseManageFind";
    }

    @RequestMapping(value = "/courseFindResult")
    public String courseFindResult(@RequestParam("attrType") String attrType, @RequestParam("attrValue") String attrValue){
        return "/admin/courseFindResult";
    }

    //返回课程的查询结果
    @ResponseBody
    @RequestMapping(value = "/courseFindResultGET",method = RequestMethod.GET)
    public RespEntity courseFindResultGETRespEntity(@RequestParam Map<String, Object> param){
        Course course=new Course();
        if(param.get("cId")!=null)course.setcId((String) param.get("cId"));
        else if(param.get("cName")!=null)course.setcName((String)param.get("cName"));
        else if(param.get("cScore")!=null)course.setcScore(Float.parseFloat((String)param.get("cScore")));
        return adminService.courseFindResultService(course);
    }

    @RequestMapping(value = "/courseManageModify")
    public String courseManageModify(){
        return "/admin/courseManageModify";
    }

    @RequestMapping(value = "/courseModifyResult")
    public  String courseModifyResult(){
        return "/admin/courseModifyResult";
    }

    //返回修改课程的结果
    @ResponseBody
    @RequestMapping(value = "/courseModifyResultPUT",method = RequestMethod.PUT)
    public RespEntity courseModifyResultPUTRespEntity(@RequestBody Course course){
        return  adminService.courseModifyResultPutService(course);
    }

    //返回课程信息
    @ResponseBody
    @RequestMapping(value = "/courseModifyResultGET",method = RequestMethod.GET)
    public RespEntity courseModifyResultPUTRespEntity(@RequestParam Map<String, Object> param){
        return  adminService.courseModifyResultGetService(param);
    }

    @RequestMapping(value ="/modifyPassword")
    public String modifyPassword(){
        return "/admin/modifyPassword";
    }


    //进行密码修改
    @ResponseBody
    @RequestMapping(value = "/modifyPasswordGET",method = RequestMethod.GET)
    public RespEntity modifyPasswordGETRespEntity(@RequestParam Map<String, Object> param){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        String uId=userDetails.getUsername();
        return adminService.modifyPasswordGetService(uId,param);
    }

    @RequestMapping(value = "/scoreManage")
    public String scoreManage(){

        return "/admin/scoreManage";
    }

    // 专业排名统计
    @ResponseBody
    @RequestMapping(value = "/calculateRankInfo",method = RequestMethod.GET)
    public RespEntity calculateRankInfo(@RequestParam Map<String, Object> param){

        int major = 0;
        if(param.get("1") != null) major= 1;
        else if(param.get("2") != null) major =2;
        else if (param.get("3") != null ) major = 3;
        return adminService.calculateRankInfo(major);
    }


    @RequestMapping(value = "/scoreCalc", method = RequestMethod.GET)
    public String calcGPA(){

        return "/admin/scoreCalc";
    }

    @ResponseBody
    @RequestMapping(value = "/scoreCalcDo", method = RequestMethod.GET)
    public RespEntity scoreCalcDo(){
        adminService.calcGPAs();

        return new RespEntity(0, "ok", null);
    }
}