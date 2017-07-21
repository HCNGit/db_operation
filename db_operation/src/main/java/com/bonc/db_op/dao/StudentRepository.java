/*
 * 文件名：StudentRepository.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年7月19日
 */

package com.bonc.db_op.dao;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bonc.db_op.entity.Student;
@Transactional
public interface StudentRepository extends PagingAndSortingRepository<Student, Serializable> {  
    
    Page<Student> findAll(Pageable pageable);
    
}
