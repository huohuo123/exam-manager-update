package com.exam.api.service;

import com.exam.api.dao.ExamBaseDao;
import com.exam.api.model.Exam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author:HuoYaJing
 * @Description:
 * @Date: Create in 10:49 2018/5/22
 */
@Service
public class ExamBaseService {

    private final static Logger logger = LoggerFactory.getLogger(ExamBaseService.class);

    @Autowired
    private ExamBaseDao examBaseDao;

    /**
     * 基本数据保存
     *
     * @param examName
     * @param subjectId
     * @return
     */
    public boolean saveExamBase(String examName, int subjectId) {
        Exam exam = new Exam();
        exam.setExamName(examName);
        exam.setSubjectId(subjectId);
        logger.info("saveExamBase examName {}", examName);
        //beetlsql保存
        try {
            //examBaseDao.saveExamBaseInfo(examName,subjectId);
            examBaseDao.insert(exam);
        } catch (Exception e) {
            logger.error("saveExam is error", e);
        }
        return true;
    }
}
