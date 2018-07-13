package com.example.demo.service;

import com.example.demo.dao.*;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private AdministorDao administorDao;

    @Autowired
    private StDao stDao;

    @Autowired
    private  ScDao scDao;

    @Autowired
    private TeachingClassDao teachingClassDao;

    public RespEntity homeResp(){

        int studentsNum;
        int teachersNum;
        int coursesNum;
        List<Student> students=studentDao.queryStudent();
        studentsNum=students.size();

        TeacherExample teacherExample=new TeacherExample();
        TeacherExample.Criteria teacherCriteria=teacherExample.createCriteria();
        teacherCriteria.andTIdIsNotNull();
        teachersNum=(int) teacherDao.countByExample(teacherExample);

        CourseExample courseExample=new CourseExample();
        CourseExample.Criteria courseCriteria=courseExample.createCriteria();
        courseCriteria.andCIdIsNotNull();
        coursesNum=(int)courseDao.countByExample(courseExample);

        int numbers[]={studentsNum,teachersNum,coursesNum};
        RespEntity respEntity=new RespEntity(0,"ok",numbers);
        return respEntity;
    }

    public RespEntity studentDetailResp(){
        List<Student> students=studentDao.queryStudent();
        for(Student student:students){
            student.setsPassword("[protected]");
        }
        RespEntity respEntity=new RespEntity(0,"ok",students);
        return  respEntity;
    }

    public RespEntity teacherDetailResp(){
        TeacherExample teacherExample=new TeacherExample();
        TeacherExample.Criteria teacherCriteria=teacherExample.createCriteria();
        teacherCriteria.andTIdIsNotNull();
        List<Teacher>  teachers=teacherDao.selectByExample(teacherExample);
        for(Teacher teacher:teachers){
            teacher.settPassword("[protected]");
        }
        RespEntity respEntity=new RespEntity(0,"ok",teachers);
        return respEntity;
    }

    public RespEntity courseDetailResp(){
        CourseExample courseExample=new CourseExample();
        CourseExample.Criteria criteria=courseExample.createCriteria();
        criteria.andCIdIsNotNull();
        List<Course> courses=courseDao.selectByExample(courseExample);
        return new RespEntity(0,"ok",courses);
    }

    public RespEntity studentManageAddRespService(Student student) {
        Student student1 = studentDao.queryStudentById(student.getsId());
        if(student1 != null){

            return new RespEntity(-1, "学号已存在，不能增加该学生！", null);
        }
        int code=studentDao.insertStudent(student);
        if(code==1) return new RespEntity(0,"ok",null);
        else return new RespEntity(-1,"error",null);
    }

    public RespEntity studentManageDeleteService(String sId) {
        Student student1 = studentDao.queryStudentById(sId);
        if(student1 == null){

            return new RespEntity(-1, "学号不存在，不能删除该学生！", null);
        }
        int code=studentDao.deleteStudent(sId);
        if(code==1) return new RespEntity(0,"ok",null);
        else return new RespEntity(-1,"error",null);
    }

    public RespEntity studentFindResultService(Student student) {
        List<Student> students = new ArrayList<>();
        if(!(student.getsId()==null)){
            students.add(studentDao.queryStudentById(student.getsId()));
        }
        else if(!(student.getsClass()==null)){
            students=studentDao.queryStudentByClass(student.getsClass());
        }
        else if(!(student.getsMajor()==null)){
            students=studentDao.queryStudentByMajor(student.getsMajor());
            System.out.println(students.toString());
        }
        else {
            return new RespEntity(-1,"no such students",students);
        }

        return new RespEntity(0,"ok",students);
    }

    public RespEntity studentModifyResultService(Student student) {
        Student student1 = studentDao.queryStudentById(student.getsId());
        if(student.getsName()=="")
            student.setsName(student1.getsName());
        if(student.getsMajor()=="")
            student.setsMajor(student1.getsMajor());
        if(student.getsClass()=="")
            student.setsClass(student1.getsClass());
        if(student.getsTotalScore()==0)
            student.setsTotalScore(student1.getsTotalScore());
        if(student.getsGpa()==0)
            student.setsGpa(student1.getsGpa());
        if(student.getsIQ()==0)
            student.setsIQ(student1.getsIQ());

        int code=studentDao.updateStudent(student);
        Student modifiedStudent=studentDao.queryStudentById(student.getsId());
        if(code==1) return new RespEntity(0,"ok",modifiedStudent);
        else return new RespEntity(-1,"error",null);
    }

    public RespEntity studentModifyResultGetService(Map<String, Object> param) {
        Student student=studentDao.queryStudentById((String)param.get("sId"));
        return new RespEntity(0,"ok",student);
    }

    public RespEntity teacherManageAddPostRespService(Teacher teacher) {
        Teacher teacher1 = teacherDao.selectByPrimaryKey(teacher.gettId());
        if(teacher1 != null){

            return new RespEntity(-1, "工号已存在，不能增加该教师！", null);
        }
        teacher.settUsername(teacher.gettId());
        int code=teacherDao.insert(teacher);
        if(code==1) return new RespEntity(0,"ok",null);
        else return  new RespEntity(-1,"error",null);
    }

    public RespEntity teacherFindResultService(Teacher teacher) {
        List<Teacher> teachers = new ArrayList<>();
        if(!(teacher.gettId()==null)){
            teachers.add(teacherDao.selectByPrimaryKey(teacher.gettId()));
        }
        else if(!(teacher.gettName()==null)){
            TeacherExample example=new TeacherExample();
            TeacherExample.Criteria criteria=example.createCriteria();
            criteria.andTNameEqualTo(teacher.gettName());
            teachers=teacherDao.selectByExample(example);
        }
        else {
            return new RespEntity(-1,"no such teachers",teachers);
        }
        return new RespEntity(0,"ok",teachers);
    }

    public RespEntity teacherManageDeleteService(Teacher teacher) {
        Teacher teacher1 = teacherDao.selectByPrimaryKey(teacher.gettId());
        if(teacher1 == null){

            return new RespEntity(-1, "工号不存在，不能删除该教师！", null);
        }
        int code=teacherDao.deleteByPrimaryKey(teacher.gettId());
        if(code==1) return new RespEntity(0,"ok",null);
        else return  new RespEntity(1,"error",null);
    }

    public RespEntity teacherModifyResultGetService(Map<String, Object> param) {
        Teacher teacher=teacherDao.selectByPrimaryKey((String)param.get("tId"));
        return new RespEntity(0,"ok",teacher);

    }

    public RespEntity teacherModifyResultPutService(Teacher teacher) {
        Teacher teacher1 = teacherDao.selectByPrimaryKey(teacher.gettId());
        if(teacher.gettName()=="")
            teacher.settName(teacher1.gettName());


        int code=teacherDao.updateByPrimaryKeySelective(teacher);
        Teacher modifiedTeacher=teacherDao.selectByPrimaryKey(teacher.gettId());
        if(code==1) return new RespEntity(0,"ok",modifiedTeacher);
        else return new RespEntity(-1,"error",null);
    }

    public RespEntity courseManageAddRespService(Course course) {


        Course course1 = courseDao.selectByPrimaryKey(course.getcId());
        if(course1 != null){

            return new RespEntity(-1, "课程号已存在，不能增加该课程！", null);
        }

            int code = courseDao.insert(course);



        if(code==1) return new RespEntity(0,"ok",null);
        else return new RespEntity(-1,"error",null);
    }

    public RespEntity courseManageDeleteService(Course course) {
        Course course1 = courseDao.selectByPrimaryKey(course.getcId());
        if(course1 == null){

            return new RespEntity(-1, "课程号不存在，不能删除该课程！", null);
        }
        int code=courseDao.deleteByPrimaryKey(course.getcId());
        if(code==1) return new RespEntity(0,"ok",null);
        else return new RespEntity(-1,"error",null);
    }

    public RespEntity courseFindResultService(Course course) {
        List<Course> courses = new ArrayList<>();
        if(!(course.getcId()==null)){
            courses.add(courseDao.selectByPrimaryKey(course.getcId()));
        }
        else if(!(course.getcName()==null)){
            CourseExample example=new CourseExample();
            CourseExample.Criteria criteria=example.createCriteria();
           // criteria.andCNameEqualTo(course.getcName());
            criteria.andCNameLike('%' + course.getcName() + '%');
            courses=courseDao.selectByExample(example);
        }
        else if(!(course.getcScore()==0)){
            CourseExample example=new CourseExample();
            CourseExample.Criteria criteria=example.createCriteria();
            criteria.andCScoreEqualTo(course.getcScore());
            courses=courseDao.selectByExample(example);
        }
        else {
            return new RespEntity(-1,"no such courses",courses);
        }
        return new RespEntity(0,"ok",courses);
    }

    public RespEntity courseModifyResultPutService(Course course) {
        Course course1 = courseDao.selectByPrimaryKey(course.getcId());
        if(course.getcName()=="")
            course.setcName(course1.getcName());

        if(course.getcScore()==null)
            course.setcScore(course1.getcScore());


        int code=courseDao.updateByPrimaryKeySelective(course);
        Course courseModified=courseDao.selectByPrimaryKey(course.getcId());
        if(code==1) return new RespEntity(0,"ok",courseModified);
        else return new RespEntity(-1,"error",null);
    }

    public RespEntity courseModifyResultGetService(Map<String, Object> param) {
        Course course=courseDao.selectByPrimaryKey((String)param.get("cId"));
        return new RespEntity(0,"ok",course);

    }

    public RespEntity modifyPasswordGetService(String uId, Map<String, Object> param) {
        int code;
        String originPassword=(String) param.get("originPassword");
        String newPassword=(String)param.get("newPassword");
        Administor administor=new Administor();
        if(originPassword.equals(administorDao.selectByPrimaryKey(uId).getaPassword())){
            administor.setaId(uId);
            administor.setaPassword(newPassword);
            code=administorDao.updateByPrimaryKeySelective(administor);
            if(code==1) return new RespEntity(0,"ok",null);
            else return new RespEntity(-1,"error",null);
        }
        else{
            return new RespEntity(-1,"error",null);
        }
    }

    public RespEntity calculateRankInfo(int major){
        String majorName = "noMajor";
        if(major == 1) majorName = "cs";
        else if(major == 2) majorName = "ioc";
        else if(major == 3) majorName = "is";

        List<Student> students = new ArrayList<>();

        students = studentDao.queryStudentByMajor(majorName);

        // sort
        for(int i = 0; i < students.size() - 1; i++){

            for(int j = 0; j < students.size() - i - 1; j++){
                if(students.get(j).getsGpa() < students.get(j + 1).getsGpa()){
                    Student tmpStudent = students.get(j);

                    students.set(j, students.get(j + 1));
                    students.set(j + 1, tmpStudent);
                }
            }
        }

        return new RespEntity(0, "ok", students);
    }

    // 功能：计算所有学生的GPA成绩
    // 注意：需要忽略掉所有未登记成绩的科目
    public void calcGPAs(){
        List<Student> students = new ArrayList<>();

        students = studentDao.queryStudent();

        for(int i = 0; i < students.size(); i++){
            Student student = students.get(i);

            List<Sc> scs = new ArrayList<>();

            ScExample scExample = new ScExample();
            ScExample.Criteria criteria = scExample.createCriteria();
            criteria.andScSIdEqualTo(student.getsId());

            scs = scDao.selectByExample(scExample);

            Float totalCredit = 0.0f;
            Float poweredCredit = 0.0f;

            for(int j = 0; j < scs.size(); j++){
                String cid = scs.get(j).getScCId();
                Float grade = scs.get(j).getScGrade();

                if(grade == 0){
                    // 这门科目的成绩还没有登录，不能进行计算
                    continue;
                }

                Float singleGPA = 0.0f;
                if(grade >= 90){
                    singleGPA = 4.0f;
                }
                else if(grade >= 60){

                    singleGPA = 4.0f - ((90.0f - grade) / 10.0f);
                }
                else{
                    singleGPA = 0.0f;
                }

                Course course = courseDao.selectByPrimaryKey(cid);

                Float credit = course.getcScore();

                totalCredit += credit;
                poweredCredit += credit * singleGPA;
            }

            Float GPA = 0.0f;

            if(totalCredit != 0){
                // 如果分母不等于0
                GPA = poweredCredit / totalCredit;
            }

            // 更新GPA
            Student newStu = new Student();
            newStu.setsId(student.getsId());
            newStu.setsGpa(GPA);
            newStu.setsTotalScore(totalCredit);
            studentDao.updateStudent(newStu);
        }
    }
}
