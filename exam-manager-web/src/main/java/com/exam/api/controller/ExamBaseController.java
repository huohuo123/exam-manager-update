package com.exam.api.controller;

import com.exam.api.service.ExamBaseService;
import com.exam.api.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:HuoYaJing
 * @Description:
 * @Date: Create in 17:44 2018/5/18
 */
@RequestMapping(value = "/exam/v1/baseInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class ExamBaseController {

    @Autowired
    private ExamBaseService examBaseService;

    /**
     * 基本数据保存
     * @param examId
     * @param examName
     * @param subjectId
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result<Object> saveExamBase(@RequestParam(name = "examId",required = false) int examId,
                                       @RequestParam(name = "examName",required = false) String examName,
                                       @RequestParam(name = "subjectId",required = false)int subjectId){

        examId=01;
        examName="数学";
        subjectId=001;
        return new Result<Object>(examBaseService.saveExamBase(examId,examName,subjectId));
    }

}
