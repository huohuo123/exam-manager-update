package com.exam.api.service;

import com.exam.api.dao.ExamBaseDao;
import com.exam.api.model.Exam;
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

    public boolean saveExamBase(int examId, String examName, int subjectId) {
        Exam exam = new Exam();
        exam.setExamId(examId);
        exam.setExamName(examName);
        exam.setSubjectId(subjectId);

        examBaseDao.insert(exam);

        return true;
    }
}
