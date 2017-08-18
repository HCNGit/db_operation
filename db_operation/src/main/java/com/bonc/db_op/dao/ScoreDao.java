/*
 * 文件名：ScoreDao.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年8月3日
 */

package com.bonc.db_op.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bonc.db_op.entity.Score;
import com.bonc.db_op.entity.Student;

@Transactional
public interface ScoreDao extends JpaRepository<Score,Integer>{


}
