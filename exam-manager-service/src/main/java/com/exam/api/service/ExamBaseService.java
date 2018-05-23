package com.exam.api.service;

import com.exam.api.dao.ExamBaseDao;
import com.exam.api.model.Exam;
import org.beetl.sql.core.db.KeyHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:HuoYaJing
 * @Description:
 * @Date: Create in 10:49 2018/5/22
 */
@Service
public class ExamBaseService {

    @Autowired
    private ExamBaseDao examBaseDao;

    /**
     * 基本数据保存
     * @param examName
     * @param subjectId
     * @return
     */
    public boolean saveExamBase(String examName, int subjectId) {
        Exam exam = new Exam();
        exam.setExamName(examName);
        exam.setSubjectId(subjectId);
        //beetlsql保存
        //examBaseDao.saveExamBaseInfo(examName,subjectId);
        examBaseDao.insert(exam);
        return true;
    }
}
