/*
 * 文件名：ScoreController.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：HCN
 * 修改时间：2017年8月3日
 */

package com.bonc.db_op.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bonc.db_op.dao.ScoreDao;
import com.bonc.db_op.entity.Score;

@Controller
public class ScoreController {
    
    @Autowired
    private ScoreDao scoreDao;
    
    /**
     * 
     * Description: 成功，score的属性值不用全写，不允许空的除外
     * 1、…<br>
     * 2、…<br>
     * Implement: <br>
     * 1、…<br>
     * 2、…<br>
     * 
     * @param score
     * @return 
     * @see
     */
    @RequestMapping(value={"/saveScore"})
    @ResponseBody
    public String saveScore(@Valid Score score){
        
        scoreDao.save(score);
        return "保存成功";
    }

}
