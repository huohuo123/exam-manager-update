package com.exam.api.service;

import com.exam.api.dao.EmployeeDao;
import com.exam.api.model.Employees;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @Author:HuoYaJing
 * @Description:
 * @Date: Create in 10:50 2018/9/12
 */
@Service
public class EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeDao employeeDao;

	private static int pageSize = 250;

	private int nThreads = 8;

	ExecutorService executorService = new ThreadPoolExecutor(4, 8, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(100000),
			new ThreadPoolExecutor.CallerRunsPolicy());



	public boolean modify() {
		List<Integer> employeesList = employeeDao.getAll();

		long timeMillis = System.currentTimeMillis();
		int size = employeesList.size();
		if (size > nThreads * pageSize) {
			pageSize = size % nThreads == 0 ? size / nThreads : size / nThreads + 1;
		} else {
			nThreads = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;
		}
		for (int i = 0; i < nThreads; i++) {
			int lastMaxIndex = (i + 1) * pageSize;
			List<Integer> subList = employeesList.subList(i * pageSize, lastMaxIndex >= size ? size : lastMaxIndex);
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					for (Integer empNo : subList) {
						Employees employeesUpdate = new Employees();
						employeesUpdate.setEmpNo(empNo);
						long uid = Long.parseLong(empNo + "01");
						employeesUpdate.setUid(uid);
						employeeDao.updateTemplateById(employeesUpdate);
					}

				}
			});

		}
		logger.info("批量更新服务列表详情耗时TIME：{}, 批量更新条数：{}", System.currentTimeMillis() - timeMillis, size);
		return true;
	}

	// public boolean insert() {
	// 	List<Integer> employeesList = employeeDao.getAll();
	// 	int size = employeesList.size();
	// 	if (size > nThreads * pageSize) {
	// 		pageSize = size % nThreads == 0 ? size / nThreads : size / nThreads + 1;
	// 	} else {
	// 		nThreads = size % pageSize == 0 ? size / pageSize : size / pageSize + 1;
	// 	}
	// 	for (int i = 0; i < nThreads; i++) {
	// 		int finalI = i;
	// 		executorService.submit(new Runnable() {
	// 			int lastMaxIndex = (finalI + 1) * pageSize;
	// 			List<Integer> subList = employeesList.subList(finalI * pageSize, lastMaxIndex >= size ? size : lastMaxIndex);
	//
	// 			@Override
	// 			public void run() {
	// 				for (Integer empNo : subList) {
	// 					Employees employees = new Employees();
	// 					employees.setUid(Long.valueOf(empNo + "00000000001"));
	// 					employees.setBirthDate(LocalDate.now());
	// 					employees.setFirstName("huohuo");
	// 					employees.setGender("M");
	// 					employees.setHireDate(LocalDate.now());
	// 					employees.setLastName("niuniu");
	// 					employeeDao.insert(employees);
	// 				}
	// 			}
	// 		});
	// 	}
	// 	return true;
	// }

	// public boolean insertOne() {
	// 	Employees employees = new Employees();
	// 	employees.setUid("22222222222");
	// 	employees.setBirthDate(new Date(1992 - 05 - 19));
	// 	employees.setFirstName("huohuo");
	// 	employees.setGender("M");
	// 	employees.setHireDate(new Date(1992 - 05 - 19));
	// 	employees.setLastName("niuniu");
	// 	employeeDao.insert(employees);
	// 	return true;
	// }

	public List<Employees> get() {
		Employees employees = new Employees();
		employees.setGender("M");
		return employeeDao.getList();
	}
}

