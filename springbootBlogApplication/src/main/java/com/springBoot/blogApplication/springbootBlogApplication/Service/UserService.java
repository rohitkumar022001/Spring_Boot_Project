package com.springBoot.blogApplication.springbootBlogApplication.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.User;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.UserDTO;
@Service
public interface UserService {

	UserDTO createUser(UserDTO user);

	List<UserDTO> getuser();

	UserDTO getuserbyuid(int uid);

	boolean checkUid(int uid);

}
