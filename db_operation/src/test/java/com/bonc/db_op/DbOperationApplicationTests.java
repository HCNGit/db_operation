package com.bonc.db_op;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bonc.db_op.dao.StudentDao;
import com.bonc.db_op.entity.Student;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DbOperationApplicationTests {

    @Autowired
    private StudentDao studentDao;
    
	@Test
	public void contextLoads() {
	}

	@Test
	public void StudentDaoTest(){
	    List<Student> sList = null;
	    sList = studentDao.findStuBetween();
	    for(Student stu:sList){
	        System.out.println(stu.getId()+"---"+stu.getName()+"---"+stu.getDepartment());
	    }
	}
}
