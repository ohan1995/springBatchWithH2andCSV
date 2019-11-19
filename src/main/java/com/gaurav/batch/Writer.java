package com.gaurav.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gaurav.model.User;
import com.gaurav.repository.UserRepository;

@Component
public class Writer implements ItemWriter<User>{
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void write(List<? extends User> users) throws Exception {
		System.out.println("Data saved for user : " + users);
		userRepository.saveAll(users);
	}
	
	
}
