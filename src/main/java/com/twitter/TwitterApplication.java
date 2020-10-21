package com.twitter;

import com.twitter.dao.PostDao;
import com.twitter.dao.UserDao;
import com.twitter.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterApplication  {

	public static void main(String[] args) {
		SpringApplication.run(TwitterApplication.class, args);
	}
}
