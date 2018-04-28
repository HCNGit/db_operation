/*
 * 文件名：StudentController.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年7月18日
 */

package com.bonc.db_op.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.bonc.db_op.dao.StudentDao;
import com.bonc.db_op.entity.Student;
import com.bonc.db_op.util.POIUtil;
import com.bonc.db_op.util.StringToDate;


@RestController
public class StudentController
{
    @Autowired
    private StudentDao studentDao;
    
    
    
    
    @RequestMapping(value="/insertStudent", method = RequestMethod.GET)
    @ResponseBody
    public String insertStudent(){
        Student student = new Student();
        student.setId(999);
        student.setName("hcn");
        student.setSex("男");
        student.setAddress("北京大兴区");
        student.setDepartment("计算机系");
        Date date = new Date(1995,10,1);
        student.setBirth(date);
        studentDao.saveStu(999,"hcn","男",date.getYear(),"计算机系","北京大兴区");
        
        return "插入学生成功";
    }
    
    @RequestMapping(value={"/updateStu"}, method = RequestMethod.GET)
    @ResponseBody
    public String update(){
        
        studentDao.updateStu("浩宇", 999);
        return "更新成功";
    }
    
    @RequestMapping(value={"/findAll"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON findAll(){
        List<Student> list =null;
        
        list = studentDao.findAll();
        return (JSON)JSON.toJSON(list);
    }
    
    @RequestMapping(value={"/find2_4"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON find1_3(){
        List<Student> list =null;
        
        list = studentDao.findStuBetween();
        return (JSON)JSON.toJSON(list);
    }
    
    @RequestMapping(value={"/findIND"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON findIND(){
        List<Student> list =null;
        for(Student stu:list){
            System.out.println(stu.getName());
            //System.out.println(stu.getId());
        }
        list = studentDao.findIND();
        return (JSON)JSON.toJSON(list);
    }
    
    @RequestMapping(value={"/findByDepartment"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON findByDepartment(){
        List<Student> list =null;
        List<String> department = new ArrayList<String>();
        department.add("计算机系");
        department.add("英语系");
      
        list = studentDao.findByDepartmentIn(department);
        return (JSON)JSON.toJSON(list);
    }
    
    @RequestMapping(value={"/findByAge"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON findByAge(){
        List list =null;
        
        list = studentDao.findByAgeIn(18,22);
        return (JSON)JSON.toJSON(list);
    }
    
    @RequestMapping(value={"/countByDepartment"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON countByDepartment(){
        List list =null;
        
        list = studentDao.countByDepartment();
        return (JSON)JSON.toJSON(list);
    }
    
    
    @RequestMapping(value={"/queryGradeByCourse"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON queryGradeByCourse(){
        List list =null;
        
        list = studentDao.findGradeByCourse();
        return (JSON)JSON.toJSON(list);
    }
    
    @RequestMapping(value={"/findLisi"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON findSomebody(){
        List list =null;
        
        list = studentDao.findSomebody("李四");
        return (JSON)JSON.toJSON(list);
    }
    
    @RequestMapping(value={"/findAllInfo"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON findAllInfo(){
        List list =null;
        
        list = studentDao.findAllInfo();
       // System.out.println(list[0].toString());
        return (JSON)JSON.toJSON(list);
    }
    
    @RequestMapping(value={"/findStuSumGrade"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON findStuSumGrade(){
        List list =null;
        
        list = studentDao.findSumGrade();
        return (JSON)JSON.toJSON(list);
    }
    
    @RequestMapping(value={"/findCourseAvg"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON findCourseAvgGrade(){
        List list =null;
        
        list = studentDao.findCourseAvg();
        return (JSON)JSON.toJSON(list);
    }
    
    @RequestMapping(value={"/queryStu"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON findStu(){
        List list =null;
        
        list = studentDao.queryStu();
        return (JSON)JSON.toJSON(list);
    }
    
    @RequestMapping(value={"/queryStu1"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON findStu1(){
        List list =null;
        
        list = studentDao.queryStu1();
        return (JSON)JSON.toJSON(list);
    }
    
    @RequestMapping(value={"/test"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON test(){
        List list =null;
        
        list = studentDao.test();
        return (JSON)JSON.toJSON(list);
    }
}
