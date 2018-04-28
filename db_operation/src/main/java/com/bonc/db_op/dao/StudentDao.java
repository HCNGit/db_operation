/*
 * 文件名：StudentDao.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年7月18日
 */

package com.bonc.db_op.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bonc.db_op.entity.Student;



/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author HCN
 * @version 2017年7月18日
 * @see StudentDao
 * @since
 */
@Transactional
public interface StudentDao extends JpaRepository<Student,Integer>
{
    
    @Modifying
    @Query(value="insert into student values(?,?,?,?,?,?)",nativeQuery=true)
    void saveStu(int id,String name,String sex,int year,String dep,String addr);
    
    @Modifying
    @Query(value="update student set name=? where id=?",nativeQuery=true)
    void updateStu(String name,int id);
    
    
    //原生sql 下标1到3，即为数据库中2到4条记录
    @Query(value="SELECT * FROM student LIMIT 1,3",nativeQuery=true)
    List<Student> findStuBetween();
    
    //从student表查询所有学生的学号（id）、姓名（name）和院系（department）的   !!!封装不成Student对象的
    @Query(value="select name,department from Student")
    List<Student> findIND();
    
    //从student表中查询计算机系和英语系的学生的信息
    List<Student> findByDepartmentIn(List list);
    
    //从student表中查询年龄18~22岁的学生信息
    @Query(value="SELECT id,name,sex,2013-birth AS age,department,address from "
        + "student where 2013-birth between ?1 and ?2",nativeQuery=true)
    List findByAgeIn(int min,int max);
    
    //从student表中查询每个院系有多少人
    @Query(value="select department,count(id) from Student group by department")
    List countByDepartment();
    
    //从score表中查询每个科目的最高分
    @Query(value="SELECT c_name,MAX(grade) FROM Score GROUP BY c_name")
    List findGradeByCourse();
    
    //查询李四的考试科目（c_name）和考试成绩（grade）
    @Query(value="SELECT c_name,grade FROM Score where stu_id="
        + " (select id from Student where name = ?1)")
    List findSomebody(String name);
    
    //用连接的方式查询所有学生的信息和考试信息
    @Query(value="SELECT st.id,name,sex,birth,department,address,c_name,grade "
        + "from student st,score sc where st.id = sc.stu_id",nativeQuery=true)
    List findAllInfo();
    
    //计算每个学生的总成绩
    @Query(value="select st.id,name,SUM(grade) from student st,score sc "
        + "where st.id = sc.stu_id group by st.id order by SUM(grade) desc",nativeQuery=true)
    List findSumGrade();
    
    //计算每个考试科目的平均成绩
    @Query(value="SELECT c_name,AVG(grade) FROM Score GROUP BY c_name")
    List findCourseAvg();
    
    //查询同时参加计算机和英语考试的学生的信息
    @Query(value="SELECT a.* FROM student a ,score b ,score c "
        + "where a.id = b.stu_id and b.c_name = '计算机'"
        + " and a.id = c.stu_id and c.c_name ='英语'",nativeQuery= true)
    List queryStu();
    
    //查询姓张或者姓王的同学的姓名、院系和考试科目及成绩
    @Query(value="SELECT student.id, name,sex,birth,department, address, c_name,grade "
        + "FROM student, score where (name LIKE  '张%'  OR name LIKE  '王%')"
        + " and student.id=score.stu_id",nativeQuery= true)
    List queryStu1();
    
    //测试sql语句，测试结果：正确
    @Query(value="SELECT student.id, name,sex,birth,department, address, c_name,grade "
        + "FROM student, score where student.department = score.c_name"
        + " or student.address=score.c_name",nativeQuery= true)
    List test();
    
    
    
}
