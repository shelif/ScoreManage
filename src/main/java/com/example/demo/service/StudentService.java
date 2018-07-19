package com.example.demo.service;


import com.example.demo.dao.*;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service

@CacheConfig(cacheNames="studentCache")
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private TeachingClassDao teachingClassDao;

    @Autowired
    private StDao stDao;

    @Autowired
    private ScDao scDao;

    static String [][] courseTableStored;

    static {
        courseTableStored = new String[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                courseTableStored[i][j] = "none";
            }
        }
    }

    // 功能：查询课程的信息
    // 返回参数：returnObj
    // returnObj[0] -- courses
    // returnObj[1] -- teachingClasses
    // returnObj[2] -- teachers
    // 未查询到相关课程：respEntity(-1, "noRecord", null)

    public RespEntity queryCourses(Course course){

        Object [] returnObjs = new Object[3];

        if(!(course.getcId() == null)){
            List<Course> courses = new ArrayList<>();
            List<TeachingClass> teachingClasses = new ArrayList<>();
            List<Teacher> teachers = new ArrayList<>();
       //     System.out.println("heihei");
           // courses.add(courseDao.selectByPrimaryKey(course.getcId()));
            Course cou = courseDao.selectByPrimaryKey(course.getcId());
            if(cou == null){
                return new RespEntity(-1, "noRecord", null);
            }
            courses.add(cou);

            returnObjs[0] = courses;

            TeachingClassExample teachingClassExample = new TeachingClassExample();
            TeachingClassExample.Criteria criteria = teachingClassExample.createCriteria();
            criteria.andTcCIdEqualTo(course.getcId());

 //           criteria.andTcCIdLike("%" + course.getcId() + "%");
            teachingClasses = teachingClassDao.selectByExample(teachingClassExample);

            returnObjs[1] = teachingClasses;

            for(int i = 0; i < teachingClasses.size(); i++){
                Teacher tmpTeacher  = teacherDao.selectByPrimaryKey(teachingClasses.get(i).getTcTId());
                teachers.add(tmpTeacher);
            }
            returnObjs[2] = teachers;
        }
        else if(!(course.getcName() == null)){
            List<Course> courses = new ArrayList<>();
            List<TeachingClass> teachingClasses = new ArrayList<>();
            List<Teacher> teachers = new ArrayList<>();
            CourseExample courseExample=new CourseExample();
            CourseExample.Criteria criteria=courseExample.createCriteria();
            criteria.andCNameLike("%" + course.getcName() + "%");

            courses=courseDao.selectByExample(courseExample);

            if(courses.size() == 0){
                return new RespEntity(-1, "noRecord", null);
            }

            returnObjs[0] = courses;

            for(int i = 0; i < courses.size(); i++){
                List<TeachingClass> tmpteachingClasses = new ArrayList<>();
                String nowCId = courses.get(i).getcId();


//                System.out.println("nowCid: " + nowCId);

                TeachingClassExample teachingClassExample = new TeachingClassExample();
                TeachingClassExample.Criteria criteria2 = teachingClassExample.createCriteria();
                criteria2.andTcCIdEqualTo(nowCId);

                tmpteachingClasses = teachingClassDao.selectByExample(teachingClassExample);
                for(int j = 0; j < tmpteachingClasses.size(); j++){
                    teachingClasses.add(tmpteachingClasses.get(j));
                }
            }
            returnObjs[1] = teachingClasses;

            for(int i = 0; i < teachingClasses.size(); i++){
                Teacher tmpTeacher  = teacherDao.selectByPrimaryKey(teachingClasses.get(i).getTcTId());
                teachers.add(tmpTeacher);
            }
            returnObjs[2] = teachers;
        }
        else {
            System.out.println("no such course");
            return new RespEntity(-1,"no such course",null);
        }
        //List<Teacher> teachers = (List<Teacher>) teacherDao.selectByPrimaryKey(cno);

        return new RespEntity(0, "ok", returnObjs);
    }

    // 功能：调用查询学生信息的服务

    public RespEntity homeGetRespService(String sId) {
        Student student=studentDao.queryStudentById(sId);
        return new RespEntity(0,"ok",student);
    }

    // 功能：选课
    // 字段：
    // stKey.getStSId() -- 学生学号
    // stKey.getStTcId() -- 学生的teachingClass信息

    public RespEntity chooseCourse(StKey stKey){

        // 判断是否已经选择该课程
        List<StKey> stKeys = new ArrayList<>();
        StExample stExample = new StExample();
        StExample.Criteria criteria = stExample.createCriteria();
        criteria.andStSIdEqualTo(stKey.getStSId());
        criteria.andStTcIdEqualTo(stKey.getStTcId());

        stKeys = stDao.selectByExample(stExample);
        if(stKeys.size() > 0){
            // 不能再选
            return new RespEntity(-1, "已选择该课程，不能再次选择", null);
        }


        // 判断是否和已选课表冲突
        TeachingClass teachingClass = new TeachingClass();
        teachingClass = teachingClassDao.selectByPrimaryKey(stKey.getStTcId());

        String week = teachingClass.getTcWeekTime();
        String lesson = teachingClass.getTcLesson();

        int ind1 = 0, ind2 = 0;

        if(week.equals("周一") || week.equals("monday")){
            ind2 = 0;
        }else if(week.equals("周二")|| week.equals("tuesday")){
            ind2 = 1;
        }else if(week.equals("周三")|| week.equals("wednesday")){
            ind2 = 2;
        }else if(week.equals("周四") || week.equals("thursday")){
            ind2 = 3;
        }else if(week.equals("周五") || week.equals("friday")){
            ind2 = 4;
        }else if(week.equals("周六") || week.equals("saturday")){
            ind2 = 5;
        }else if(week.equals("周日") || week.equals("sunday")){
            ind2 = 6;
        }
        if(lesson.equals("第一节课") || lesson.equals("lessonOne")){
            ind1 = 0;
        }else if(lesson.equals("第二节课") || lesson.equals("lessonTwo")){
            ind1 = 1;
        } else if(lesson.equals("第三节课") || lesson.equals("lessonThree")){
            ind1 = 2;
        }else if(lesson.equals("第四节课") || lesson.equals("lessonFour")){
            ind1 = 3;
        }

        updateCourseTable();

        if(!courseTableStored[ind1][ind2].equals("none")){
            // 与课表冲突，不能进行选课！
            return new RespEntity(-1, "与课表冲突，不能选择该课程！", null);
        }

        // 课程容量限制
        // if(teachingClass.getTcCapacity())

        StExample stExample1 = new StExample();
        StExample.Criteria criteria1 = stExample1.createCriteria();
        criteria1.andStTcIdEqualTo(stKey.getStTcId());
        List<StKey> stKeys1 = new ArrayList<>();
        stKeys1 = stDao.selectByExample(stExample1);

        if(stKeys1.size() >= Integer.parseInt(teachingClass.getTcCapacity())){
            // 选课人数已满
            return new RespEntity(-1, "选课人数已满，不能选课！", null);
        }

        // 查看是否选择过相同的课（course）
        ScKey scKey = new ScKey();
        scKey.setScCId(teachingClass.getTcCId());
        scKey.setScSId(stKey.getStSId());

        Sc sc2 = scDao.selectByPrimaryKey(scKey);
        if(sc2 != null){

            return new RespEntity(-1, "不能再次选择相同的课程！", null);
        }

        stDao.insert(stKey);

        Sc sc = new Sc();
        sc.setScSId(stKey.getStSId());
        sc.setScCId(teachingClass.getTcCId());
        sc.setScGrade((float)0);
        scDao.insert(sc);

        return new RespEntity(0, "选课成功！", "none");
    }

    // 功能：

    public RespEntity showCourseInfoThatHasBeenChoosen(String SId){
        List<StKey> stKeys = new ArrayList<>();

        Object[] returnObj = new Object[3];

        StExample stExample = new StExample();
        StExample.Criteria criteria = stExample.createCriteria();
        criteria.andStSIdEqualTo(SId);

        stKeys = stDao.selectByExample(stExample);

        List<TeachingClass> teachingClasses = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();

        for(int i = 0; i < stKeys.size(); i++){
//            TeachingClassExample teachingClassExample = new TeachingClassExample();
//            TeachingClassExample.Criteria criteria2= teachingClassExample.createCriteria();
            TeachingClass tmp = new TeachingClass();
            tmp = teachingClassDao.selectByPrimaryKey(stKeys.get(i).getStTcId());
            teachingClasses.add(tmp);

        }

        for(int i = 0; i < teachingClasses.size(); i++){
            Course tmp2 = new Course();
            tmp2 = courseDao.selectByPrimaryKey(teachingClasses.get(i).getTcCId());
            courses.add(tmp2);

            Teacher tmp3 = new Teacher();
            tmp3 = teacherDao.selectByPrimaryKey(teachingClasses.get(i).getTcTId());
            teachers.add(tmp3);
        }

        returnObj[0] = teachingClasses;
        returnObj[1] = courses;
        returnObj[2] = teachers;

        return new RespEntity(0, "已选的课程", returnObj);
    }

    private void updateCourseTable(){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String SId=userDetails.getUsername();

        // System.out.println("updateCourseTable: " + "nowUserName: " + SId);

        List<StKey> stKeys = new ArrayList<>();
        Object[] returnObj = new Object[3];
        StExample stExample = new StExample();
        StExample.Criteria criteria = stExample.createCriteria();
        criteria.andStSIdEqualTo(SId);
        stKeys = stDao.selectByExample(stExample);
        List<TeachingClass> teachingClasses = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
        for(int i = 0; i < stKeys.size(); i++){
            TeachingClass tmp = new TeachingClass();
            tmp = teachingClassDao.selectByPrimaryKey(stKeys.get(i).getStTcId());
            teachingClasses.add(tmp);
        }
        for(int i = 0; i < teachingClasses.size(); i++){
            Course tmp2 = new Course();
            tmp2 = courseDao.selectByPrimaryKey(teachingClasses.get(i).getTcCId());
            courses.add(tmp2);
        }

        // [][] courseTable = new String[10][10];

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                courseTableStored[i][j] = "none";
            }
        }

        for(int i = 0; i < teachingClasses.size(); i++){
            TeachingClass tmptc = teachingClasses.get(i);

            String week = tmptc.getTcWeekTime();
            String lesson = tmptc.getTcLesson();

            int ind1 = 0, ind2 = 0;

            if(week.equals("周一") || week.equals("monday")){
                ind2 = 0;
            }else if(week.equals("周二")|| week.equals("tuesday")){
                ind2 = 1;
            }else if(week.equals("周三")|| week.equals("wednesday")){
                ind2 = 2;
            }else if(week.equals("周四") || week.equals("thursday")){
                ind2 = 3;
            }else if(week.equals("周五") || week.equals("friday")){
                ind2 = 4;
            }else if(week.equals("周六") || week.equals("saturday")){
                ind2 = 5;
            }else if(week.equals("周日") || week.equals("sunday")){
                ind2 = 6;
            }

            if(lesson.equals("第一节课") || lesson.equals("lessonOne")){
                ind1 = 0;

            }else if(lesson.equals("第二节课") || lesson.equals("lessonTwo")){
                ind1 = 1;
            }
            else if(lesson.equals("第三节课") || lesson.equals("lessonThree")){
                ind1 = 2;
            }else if(lesson.equals("第四节课") || lesson.equals("lessonFour")){
                ind1 = 3;
            }

            courseTableStored[ind1][ind2] = courses.get(i).getcName();
        }
    }
    @CachePut(key="#p0.id")
    public RespEntity showCourseTableInfoThatHasBeenChoosen(String SId){
        updateCourseTable();

        return new RespEntity(0, "课表信息", courseTableStored);
    }
    @CachePut(key="#p0.id")
    public RespEntity deleteCourse(StKey stKey){
 //       List<StKey> stKeys = new ArrayList<>();
        StExample stExample = new StExample();
        StExample.Criteria criteria = stExample.createCriteria();
        criteria.andStSIdEqualTo(stKey.getStSId());
        criteria.andStTcIdEqualTo(stKey.getStTcId());



        TeachingClass teachingClass = new TeachingClass();
        teachingClass = teachingClassDao.selectByPrimaryKey(stKey.getStTcId());

        ScKey scKey = new ScKey();
        scKey.setScSId(stKey.getStSId());
        scKey.setScCId(teachingClass.getTcCId());


        Sc sc = scDao.selectByPrimaryKey(scKey);
        if(sc.getScGrade() != 0){

            return new RespEntity(-1, "你已经获得该课程的成绩，无法删除课程！", null);
        }

        stDao.deleteByExample(stExample);

        scDao.deleteByPrimaryKey(scKey);

        return new RespEntity(0, "课程删除成功！", null);
    }

    public RespEntity showCourseInfoAndScoreThatHasBeenChoosen(String sId) {
        List<StKey> stKeys = new ArrayList<>();

        Object[] returnObj = new Object[4];

        StExample stExample = new StExample();
        StExample.Criteria criteria = stExample.createCriteria();
        criteria.andStSIdEqualTo(sId);

        stKeys = stDao.selectByExample(stExample);

        List<TeachingClass> teachingClasses = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
        List<Sc> scs = new ArrayList<>();

        for(int i = 0; i < stKeys.size(); i++){
//            TeachingClassExample teachingClassExample = new TeachingClassExample();
//            TeachingClassExample.Criteria criteria2= teachingClassExample.createCriteria();
            TeachingClass tmp = new TeachingClass();
            tmp = teachingClassDao.selectByPrimaryKey(stKeys.get(i).getStTcId());
            teachingClasses.add(tmp);
        }
        // System.out.println("teachingClasses: " + teachingClasses.size());
        for(int i = 0; i < teachingClasses.size(); i++){
            Course tmp2 = new Course();
            tmp2 = courseDao.selectByPrimaryKey(teachingClasses.get(i).getTcCId());
            courses.add(tmp2);

            Teacher tmp3 = new Teacher();
            tmp3 = teacherDao.selectByPrimaryKey(teachingClasses.get(i).getTcTId());
            teachers.add(tmp3);

            Sc tmp4 = new Sc();

            ScKey scKey = new ScKey();
            scKey.setScSId(sId);
            scKey.setScCId(teachingClasses.get(i).getTcCId());
            tmp4 = scDao.selectByPrimaryKey(scKey);

            scs.add(tmp4);
        }

        returnObj[0] = teachingClasses;
        returnObj[1] = courses;
        returnObj[2] = teachers;
        returnObj[3] = scs;

        return new RespEntity(0, "ok", returnObj);
    }

    public RespEntity queryOtherInfoBySId(String sId) {
        List<Student> students = new ArrayList<>();
        Student student=studentDao.queryStudentById(sId);

        if(student == null){

            return new RespEntity(-1 ,"noRecord", null);
        }

        students.add(student);
        return new RespEntity(0,"ok",students);
    }

    public RespEntity queryOtherInfoBySname(String sname) {

        List<Student> students = new ArrayList<>();
        students = studentDao.queryStudentByName(sname);

        if(students.size() == 0){

            return new RespEntity(-1 ,"noRecord", null);
        }
        return new RespEntity(0,"ok" ,students);
    }

    public RespEntity modifyPasswordGetService(String uId, Map<String, Object> param) {
        int code;
        String originPassword=(String) param.get("originPassword");
        String newPassword=(String)param.get("newPassword");
        // Administor administor=new Administor();
        Student student = new Student();
       ;
        if(originPassword.equals( studentDao.queryStudentById(uId).getsPassword())){
            student.setsId(uId);
            student.setsPassword(newPassword);
            // code=studentDao.updateByPrimaryKeySelective(student);

            code = studentDao.updateStudent(student);

            if(code == 1) return new RespEntity(0,"ok",null);
            else return new RespEntity(-1,"error",null);
        }
        else{
            return new RespEntity(-1,"error",null);
        }
    }
}
