/*
 * 文件名：Score.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年7月18日
 */

package com.bonc.db_op.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 * @author HCN
 * @version 2017年7月18日
 * @see Score
 * @since
 */
@Entity
public class Score
{
    @Id
    int id;
    int stu_id;
    String c_name;
    int grade;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public int getStu_id()
    {
        return stu_id;
    }
    public void setStu_id(int stu_id)
    {
        this.stu_id = stu_id;
    }
    public String getC_name()
    {
        return c_name;
    }
    public void setC_name(String c_name)
    {
        this.c_name = c_name;
    }
    public int getGrade()
    {
        return grade;
    }
    public void setGrade(int grade)
    {
        this.grade = grade;
    }
    
    
}
