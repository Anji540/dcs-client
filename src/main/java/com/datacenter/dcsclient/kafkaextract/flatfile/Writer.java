package com.datacenter.dcsclient.kafkaextract.flatfile;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.datacenter.dcsclient.domain.User;
import com.datacenter.dcsclient.kafkaextract.CustomExtractor;
import com.datacenter.dcsclient.repository.UsersRepository;

@Component
public class Writer extends CustomExtractor implements ItemWriter<User>{
	
	@Autowired
	private UsersRepository repo; 
	

	@Override
	@Transactional
	public void write(List<? extends User> users) throws Exception {
		repo.save(users);
		
		for(User user : users){
		super.pushDataToKafka(user);
		}
		
	}
	
}
