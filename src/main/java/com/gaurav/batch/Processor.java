package com.gaurav.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.gaurav.model.User;

@Component
public class Processor implements ItemProcessor<User, User>{
	
	private static final Map<String , String> DEPT_NAME = new HashMap<>();
	
	public Processor() {
		DEPT_NAME.put("001", "Technology");
		DEPT_NAME.put("002", "Operations");
	}
	@Override
	public User process(User item) throws Exception {
		
		String deptCode = item.getDept();
		String dept = DEPT_NAME.get(deptCode);
		item.setDept(dept);
		System.out.println(String.format("Converted from [%s] to [%s] ", deptCode, dept));
		return item;
	}
	
	
}
