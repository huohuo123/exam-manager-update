package com.exam.api.dao;

import com.exam.api.model.Employees;
import org.beetl.sql.core.annotatoin.Sql;
import org.beetl.sql.core.annotatoin.SqlStatementType;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:HuoYaJing
 * @Description:
 * @Date: Create in 10:51 2018/9/12
 */
@Repository
public interface EmployeeDao extends BaseMapper<Employees>{


	@Sql(type = SqlStatementType.SELECT,value = "select emp_no from employees")
	List<Integer> getAll();

	@Sql(type = SqlStatementType.SELECT,value = "select * from employees order by birth_date desc limit 1,100")
	List<Employees> getList();


}
