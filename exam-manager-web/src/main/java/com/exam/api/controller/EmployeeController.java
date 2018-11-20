package com.exam.api.controller;

import com.exam.api.service.EmployeeService;
import com.exam.api.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:HuoYaJing
 * @Description:
 * @Date: Create in 10:42 2018/9/12
 */
@RequestMapping(value = "/exam/v1/Info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public Result<Object> modify(
	) {
		return new Result<Object>(employeeService.modify());
	}

	// @RequestMapping(value = "/insert", method = RequestMethod.POST)
	// public Result<Object> insert(
	// ) {
	// 	return new Result<Object>(employeeService.insert());
	// }
	//
	// @RequestMapping(value = "/insertOne", method = RequestMethod.POST)
	// public Result<Object> insertOne(
	// ) {
	// 	return new Result<Object>(employeeService.insertOne());
	// }

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public Result<Object> get(
	) {
		return new Result<Object>(employeeService.get());
	}

}
