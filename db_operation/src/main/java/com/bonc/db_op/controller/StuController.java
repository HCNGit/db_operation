/*
 * 文件名：StuController.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年7月19日
 */

package com.bonc.db_op.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bonc.db_op.dao.StudentRepository;
import com.bonc.db_op.entity.Student;
import com.bonc.db_op.service.StudentService;
import com.bonc.db_op.util.ExcelUtil;
import com.bonc.db_op.util.POIUtil;
import com.bonc.db_op.util.StringToDate;

@Controller
public class StuController
{
    
    @Autowired
    private StudentRepository repository;
    
    
    @RequestMapping(value={"/dataTablesDemo", "/inter"})
    public String inter(){
        //在数据库中初始化用户
        
        return "hello/dataTablesDemo";
    }
    
    @RequestMapping(value={"/queryByPage", "/inter"})
    public String queryByPage(){
        //在数据库中初始化用户
        
        return "hello/page";
    }
    
    
    @RequestMapping(value={"/readFile", "/read"})
    public String read(){
        //在数据库中初始化用户
        
        return "hello/readExcel";
    }
    
    
    
    
    
    
    //查询所有学生，其结果用jpa分页
    @RequestMapping(value={"/findStudentByPage"}, method = RequestMethod.GET)
    @ResponseBody
    public Page<Student> findStudent(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "2") Integer size){
        Sort sort = new Sort(Sort.Direction.ASC,"id");  
        Pageable pageable = new PageRequest(page,size,sort);
        Page<Student> pageRes =  repository.findAll(pageable);
        return pageRes;
    }
    //按地址查询，其结果分页
    @RequestMapping(value={"/findStudentByAddress"}, method = RequestMethod.GET)
    @ResponseBody
    public Page<Student> findStudentByAddr(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                           @RequestParam(value = "address") String address,
                                     @RequestParam(value = "size", defaultValue = "2") Integer size){
        Sort sort = new Sort(Sort.Direction.ASC,"name");  
        Pageable pageable = new PageRequest(page,size,sort);
        Page<Student> pageRes =  repository.findStudentByAddress(pageable,address);
        return pageRes;
    }
    
    //DataTables 前端分页
    @RequestMapping(value={"/findAlls"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON findAlls(){
        List<Student> list =null;
        
        list = repository.findAll();
        return (JSON)JSON.toJSON(list);
    }
    /**
     * 
     * Description: <br>
     * 1、…<br>
     * 2、…<br>
     * Implement: <br>
     * 1、…<br>
     * 2、…<br>
     * 
     * @param page   每页的起始坐标
     * @param draw
     * @param size
     * @return 
     * @see
     */
    //dataTables 后端分页
    @RequestMapping(value={"/dataTableBack"}, method = RequestMethod.GET)
    @ResponseBody
    public JSON find(@RequestParam(value = "start") Integer page,
                     @RequestParam(value = "draw") Integer draw,
                                     @RequestParam(value = "length") Integer size){
       // Sort sort = new Sort(Sort.Direction.ASC,"id");  
        Pageable pageable = new PageRequest(page/size,size);
        Page<Student> pageRes =  repository.findAll(pageable);
        
       int draw1 = draw.intValue();
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("draw", draw1);
        resMap.put("recordsTotal", pageRes.getTotalElements());
        resMap.put("recordsFiltered",pageRes.getTotalElements() );
        resMap.put("data", pageRes.getContent());
        
        return (JSON)JSON.toJSON(resMap);
   
    }
    
    
   
    
    /** 
     * 读取excel文件中的信息
     * @param excelFile 
     */  
    @RequestMapping(value={"/readExcelFile"}, method = RequestMethod.POST)  
    @ResponseBody
    public String readExcel(@RequestParam(value = "excelFile") MultipartFile excelFile,HttpServletRequest req,HttpServletResponse resp){  

        Map<String, Object> param = new HashMap<String, Object>();  
//       List<Student> students = new ArrayList<Student>();  
       List<String[]> studentList = null;
       try { 
            studentList = POIUtil.readExcel(excelFile); 
       
            /*for(int i = 0;i<studentList.size();i++){  
              String[] stus = studentList.get(i);  
              Student student = new Student();  
              student.setId(Integer.parseInt(stus[0]));
              student.setName(stus[1]);
              student.setSex(stus[2]);
              //String tempdate = stus[3]+"-1-1";
              student.setBirth(StringToDate.strToDate("yyyy", stus[3]));
              //System.out.println(student.getBirth());
              student.setDepartment(stus[4]);
              student.setAddress(stus[5]);
              
              students.add(student);
             }  */
           } catch (IOException e) {  
               e.printStackTrace();
           }  
        
        
          return JSON.toJSONString(studentList);
    }  
    
    @RequestMapping(value = "/partExport")
    @ResponseBody
    public void partExport (HttpServletResponse response){
        
        JSONArray ja = new JSONArray();
        for(int i=0;i<100;i++){
            Student s = new Student();
            
            s.setId(i);
            s.setName("POI"+i);
            s.setSex(i%2==0?"男":"女");
            s.setBirth(new Date());
            s.setDepartment("英语系");
            s.setAddress("上海");
         
            ja.add(s);
        }
        Map<String,String> headMap = new LinkedHashMap<String,String>();
        headMap.put("id","编号");
        headMap.put("name","姓名");
        headMap.put("sex","性别");
        headMap.put("department","院系");
        headMap.put("address","地址");
        
        String title = "导出excel文件测试";
        ExcelUtil.downloadExcelFile(title,headMap,ja,response);
    }
    
    
    
    
    
    
    
    
    
}
