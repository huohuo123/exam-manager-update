package com.exam.api.dao;

import com.exam.api.model.Exam;
import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.annotatoin.SqlStatementType;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author:HuoYaJing
 * @Description:
 * @Date: Create in 10:51 2018/5/22
 */
@Repository
public interface ExamBaseDao extends BaseMapper<Exam>{


    @Sql(type = SqlStatementType.INSERT,value = "insert into exam (exam_name,subject_id) values (?,?)")
    Integer saveExamBaseInfo(String examName, int subjectId);
}
