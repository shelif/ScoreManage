package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.entity.*;
import com.example.demo.entity.StExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private TeachingClassDao teachingClassDao;

    @Autowired
    private ScDao scDao;

    @Autowired
    private StDao stDao;

    @Autowired
    private StudentDao studentDao;


    public RespEntity homeGETRespService(String uId) {
        Teacher teacher=teacherDao.selectByPrimaryKey(uId);
        if(teacher.gettId()!=null)return new RespEntity(0,"ok",teacher);
        else return new RespEntity(-1,"error",null);
    }

    public RespEntity t_search_resultGETRespService(Map<String, Object> param) {
        Course course=new Course();
        CourseExample courseExample=new CourseExample();
        CourseExample.Criteria criteria=courseExample.createCriteria();
        List<Course> courses=new ArrayList<>();
        if(param.get("cId")!=null) {
            courses.add(courseDao.selectByPrimaryKey((String)param.get("cId")));
            return new RespEntity(0,"ok",courses);
        }
        else if(param.get("cName")!=null) {
            //criteria.andCNameEqualTo((String)param.get("cName"));
           // courses=courseDao.selectByExample(courseExample);
            criteria.andCNameLike('%' + (String)param.get("cName") + '%');
            courses=courseDao.selectByExample(courseExample);
            return new RespEntity(0,"ok",courses);
        }
        else if(param.get("cScore")!=null) {
            criteria.andCScoreEqualTo(Float.parseFloat((String)param.get("cScore")));
            courses=courseDao.selectByExample(courseExample);
            return new RespEntity(0,"ok",courses);
        }
        else{
            return  new RespEntity(-1,"error",null);
        }
    }

    public RespEntity t_submit_classPOSTService(TeachingClass teachingClass) {

        // 判断教师是否重复地开设同一门课程
        String nowTeacher = teachingClass.getTcTId();
        String nowCourse = teachingClass.getTcCId();

        List<TeachingClass> teachingClasses = new ArrayList<>();
        TeachingClassExample example = new TeachingClassExample();
        TeachingClassExample.Criteria criteria = example.createCriteria();
        criteria.andTcTIdEqualTo(nowTeacher);
        criteria.andTcCIdEqualTo(nowCourse);
        teachingClasses = teachingClassDao.selectByExample(example);

        if(teachingClasses.size() != 0){
            // 该教师已经开设过这一课程
            return new RespEntity(-1, "您已经开设过本课程，不能再次开设！", null);
        }

        // 判断教师是否在相同时段开设了其他的课程
        String week = teachingClass.getTcWeekTime();
        String lesson = teachingClass.getTcLesson();

        List<TeachingClass> teachingClasses1 = new ArrayList<>();
        TeachingClassExample example1 = new TeachingClassExample();
        TeachingClassExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andTcTIdEqualTo(nowTeacher);
        criteria1.andTcWeekTimeEqualTo(week);
        criteria1.andTcLessonEqualTo(lesson);
        teachingClasses1 = teachingClassDao.selectByExample(example1);

        if(teachingClasses1.size() != 0){
            // 该教师已经在同一时间段开设了其他的课程
            return new RespEntity(-1, "你已经在相同的时段开设了其他的课程，不能再在此时段开设课程！", null);
        }

        String location = teachingClass.getTcLocation();
        // 判断是否有其余教师在相同时段相同地点开设了其他的课程
        List<TeachingClass> teachingClasses2 = new ArrayList<>();
        TeachingClassExample example2 = new TeachingClassExample();
        TeachingClassExample.Criteria criteria2 = example2.createCriteria();
        criteria2.andTcLocationEqualTo(location);
        criteria2.andTcWeekTimeEqualTo(week);
        criteria2.andTcLessonEqualTo(lesson);
        teachingClasses2 = teachingClassDao.selectByExample(example2);

        if(teachingClasses2.size() != 0){
            // 已经有其他在同一时间同一地点开设了课程
            return new RespEntity(-1, "已经有其他教师在相同的时段同样的地点开设了课程，请挑选另外的时间或者地点开设课程！", null);
        }
        TeachingClass teaching_class1 = teachingClassDao.selectByPrimaryKey(teachingClass.getTcId());
        if(teaching_class1!= null)
        {
            return new RespEntity(-1, "教学班号已存在，不能开设！", null);
        }
        int code=teachingClassDao.insert(teachingClass);
        if(code==1) return new RespEntity(0,"ok",null);
        else return new RespEntity(-1,"error",null);
    }

    public RespEntity t_classesGETService(String tId) {
        List<SubmitClass>  submitClasses=new ArrayList<>();
        List<TeachingClass> teachingClasses=new ArrayList<>();
        TeachingClassExample example=new TeachingClassExample();
        TeachingClassExample.Criteria criteria= example.createCriteria();
        criteria.andTcTIdEqualTo(tId);
        teachingClasses=teachingClassDao.selectByExample(example);
        for(TeachingClass teachingClass:teachingClasses){
            SubmitClass submitClass=new SubmitClass();
            submitClass.setCapacity(teachingClass.getTcCapacity());
            submitClass.setLocation(teachingClass.getTcLocation());
            submitClass.setCid(teachingClass.getTcCId());
            submitClass.setTcid(teachingClass.getTcId());
            submitClass.setTime(teachingClass.getTcWeekTime()+"["+teachingClass.getTcLesson()+"]");
            Course course=courseDao.selectByPrimaryKey(teachingClass.getTcCId());
            submitClass.setName(course.getcName());
            submitClass.setScore(course.getcScore());
            StExample example1=new StExample();
            Criteria criteria1=example1.createCriteria();
            criteria1.andStTcIdEqualTo(teachingClass.getTcId());
            submitClass.setTemp(Long.toString(stDao.countByExample(example1)));
            submitClasses.add(submitClass);
        }
        return new RespEntity(0,"ok",submitClasses);
    }

    public RespEntity t_delete_calGET(String tId) {
        List<SubmitClass>  submitClasses=new ArrayList<>();
        List<TeachingClass> teachingClasses=new ArrayList<>();
        TeachingClassExample example=new TeachingClassExample();
        TeachingClassExample.Criteria criteria= example.createCriteria();
        criteria.andTcTIdEqualTo(tId);
        teachingClasses=teachingClassDao.selectByExample(example);
        for(TeachingClass teachingClass:teachingClasses){
            SubmitClass submitClass=new SubmitClass();
            submitClass.setCid(teachingClass.getTcCId());
            submitClass.setTcid(teachingClass.getTcId());
            Course course=courseDao.selectByPrimaryKey(teachingClass.getTcCId());
            submitClass.setName(course.getcName());
            submitClass.setScore(course.getcScore());
            submitClasses.add(submitClass);
        }
        return new RespEntity(0,"ok",submitClasses);
    }

    public RespEntity t_delete_calDELETE(TeachingClass teachingClass) {
        int code=teachingClassDao.deleteByPrimaryKey(teachingClass.getTcId());
        if(code==1) return new RespEntity(0,"ok",null);
        else return new RespEntity(-1,"error",null);
    }

    public RespEntity t_submitgradeGetService(String tId) {
        return this.t_delete_calGET(tId);
    }

    public RespEntity tosubmitGETService(Map<String, Object> param) {
         List<SubmitGrade> submitGrades=new ArrayList<>();
         String tcId=(String) param.get("tcId");
         TeachingClass teachingClass=teachingClassDao.selectByPrimaryKey(tcId);
         String cId=teachingClass.getTcCId();
         StExample stExample=new StExample();
         Criteria criteria=stExample.createCriteria();
         criteria.andStTcIdEqualTo(tcId);
         List<StKey> stKeys=stDao.selectByExample(stExample);
         for(StKey stKey:stKeys){
             SubmitGrade submitGrade=new SubmitGrade();
             submitGrade.setsId(stKey.getStSId());
             submitGrade.setcName(studentDao.queryStudentById(stKey.getStSId()).getsName());
             ScKey scKey=new ScKey();
             scKey.setScCId(cId);
             scKey.setScSId(stKey.getStSId());
             if(scDao.selectByPrimaryKey(scKey)!=null)
                 submitGrade.setScGrade(scDao.selectByPrimaryKey(scKey).getScGrade());
             else
                 submitGrade.setScGrade(0);
             submitGrades.add(submitGrade);
         }
         return new RespEntity(0,"ok",submitGrades);
    }

    public RespEntity tosubmitPUTService(List<ScModel> scModels) {
        int code=0;
        for(ScModel scModel:scModels){
            Sc sc=new Sc();
            sc.setScSId(scModel.getScSId());
            sc.setScCId(scModel.getScCId());
            System.out.println("hehe"+ scModel.getScGrade());
            if(scModel.getScGrade() != -1){
                sc.setScGrade(scModel.getScGrade());
                code=scDao.updateByPrimaryKeySelective(sc);
            }


        }
        if(code==1) return new RespEntity(0,"ok",null);
        else return new RespEntity(-1,"error",null);
    }

    public RespEntity t_gradesGetService(String tId) {
        return this.t_delete_calGET(tId);
    }

    public RespEntity t_personal_infoGetService(String tId) {
        Teacher teacher=teacherDao.selectByPrimaryKey(tId);
        teacher.settPassword("[protected]");
        List<SubmitClass>  submitClasses=new ArrayList<>();
        List<TeachingClass> teachingClasses=new ArrayList<>();
        TeachingClassExample example=new TeachingClassExample();
        TeachingClassExample.Criteria criteria= example.createCriteria();
        criteria.andTcTIdEqualTo(tId);
        teachingClasses=teachingClassDao.selectByExample(example);
        for(TeachingClass teachingClass:teachingClasses){
            SubmitClass submitClass=new SubmitClass();
            submitClass.setCapacity(teachingClass.getTcCapacity());
            submitClass.setLocation(teachingClass.getTcLocation());
            submitClass.setCid(teachingClass.getTcCId());
            submitClass.setTcid(teachingClass.getTcId());
            submitClass.setTime(teachingClass.getTcWeekTime()+"["+teachingClass.getTcLesson()+"]");
            Course course=courseDao.selectByPrimaryKey(teachingClass.getTcCId());
            submitClass.setName(course.getcName());
            submitClass.setScore(course.getcScore());
            StExample example1=new StExample();
            Criteria criteria1=example1.createCriteria();
            criteria1.andStTcIdEqualTo(teachingClass.getTcId());
            submitClass.setTemp(Long.toString(stDao.countByExample(example1)));
            submitClasses.add(submitClass);
        }
        TeacherSelfInfo teacherSelfInfo=new TeacherSelfInfo();
        teacherSelfInfo.settId(tId);
        teacherSelfInfo.settName(teacher.gettName());
        teacherSelfInfo.setSubmitClasses(submitClasses);
        return new RespEntity(0,"ok",teacherSelfInfo);
    }

    public RespEntity t_other_infoGET(Map<String, Object> param) {
        List<Teacher> teachers=new ArrayList<>();
        if(param.get("tId")!=null){
            Teacher teacher=new Teacher();
            teacher=teacherDao.selectByPrimaryKey((String)param.get("tId"));
            if(teacher!=null)teacher.settPassword("[protected]");
            teachers.add(teacher);
            return new RespEntity(0,"ok",teachers);
        }
        else if(param.get("tName")!=null){
            TeacherExample example=new TeacherExample();
            TeacherExample.Criteria criteria=example.createCriteria();
            criteria.andTNameEqualTo((String)param.get("tName"));
            teachers=teacherDao.selectByExample(example);
            return new RespEntity(0,"ok",teachers);
        }
        else{
            return new RespEntity(-1,"error",null);
        }
    }
    public RespEntity modifyPasswordGetService(String uId, Map<String, Object> param) {
        int code;
        String originPassword=(String) param.get("originPassword");
        String newPassword=(String)param.get("newPassword");
        Teacher teacher=new Teacher();
        if(originPassword.equals(teacherDao.selectByPrimaryKey(uId).gettPassword())){
            teacher.settId(uId);
            teacher.settPassword(newPassword);
            code=teacherDao.updateByPrimaryKeySelective(teacher);
            if(code==1) return new RespEntity(0,"ok",null);
            else return new RespEntity(-1,"error",null);
        }
        else{
            return new RespEntity(-1,"error",null);
        }
    }
}
