package com.exam.api.model;

import org.beetl.sql.core.annotatoin.AssignID;

import java.io.Serializable;

/**
 * @Author:HuoYaJing
 * @Description:
 * @Date: Create in 11:21 2018/5/22
 */

public class Exam implements Serializable {

    private Integer examId;

    private String examName;

    private Integer subjectId;

    private Integer score;

    private Integer evaluationLevel;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getEvaluationLevel() {
        return evaluationLevel;
    }

    public void setEvaluationLevel(Integer evaluationLevel) {
        this.evaluationLevel = evaluationLevel;
    }

    @Override
    public String toString() {
        return "Exam{"
                + "examId=" + examId +
                "examName=" + examName +
                "subjectId=" + subjectId +
                "score=" + score +
                "evaluationLevel=" + evaluationLevel +
                '}';
    }
}
