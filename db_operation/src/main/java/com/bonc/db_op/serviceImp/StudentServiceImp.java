/*
 * 文件名：StudentServiceImp.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年7月19日
 */

package com.bonc.db_op.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bonc.db_op.dao.StudentRepository;
import com.bonc.db_op.entity.Student;
import com.bonc.db_op.service.StudentService;

@Service
public class StudentServiceImp implements StudentService
{
    @Autowired
    StudentRepository studentRepository;

    
    
    
    
}
