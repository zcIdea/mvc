package com.springmvc.service;


import org.springframework.stereotype.Service;

import com.springmvc.entry.User;

public interface UserService {
 
	User getUserById(int id);
}
