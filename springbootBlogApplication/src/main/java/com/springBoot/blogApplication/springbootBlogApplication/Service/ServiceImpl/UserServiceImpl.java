package com.springBoot.blogApplication.springbootBlogApplication.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.blogApplication.springbootBlogApplication.Entity.Category;
import com.springBoot.blogApplication.springbootBlogApplication.Entity.User;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.CatDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Payload.UserDTO;
import com.springBoot.blogApplication.springbootBlogApplication.Repository.UserRepository;
import com.springBoot.blogApplication.springbootBlogApplication.Service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository UserRepository;
	@Override
	public UserDTO createUser(UserDTO udto) {
		// TODO Auto-generated method stub
		User u=new User();
		
		u.setUid(udto.getUid());
		u.setUsername(udto.getUsername());
		u.setEmail(udto.getEmail());
		System.out.println(udto.getUid());
		UserRepository.save(u);
		//converting post Entity to postDTO
		UserDTO ur=new UserDTO();
		ur.setUid(u.getUid());
		ur.setUsername(u.getUsername());
		ur.setEmail(u.getEmail());
		return ur;
	}
	@Override
	public List<UserDTO> getuser() {
		// TODO Auto-generated method stub
		List<User> user=UserRepository.findAll();
		List<UserDTO> ud=new ArrayList<UserDTO>();
		for(User u:user) {
			UserDTO udto=new UserDTO();
			udto.setUid(u.getUid());
			udto.setUsername(u.getUsername());
			udto.setEmail(u.getEmail());
			ud.add(udto);
		}
		return ud;
		
	}
	@Override
	public UserDTO getuserbyuid(int uid) {
		// TODO Auto-generated method stub
		User u;
		try {
		u=UserRepository.findById(uid).get();
		}
		catch(Exception e){
			return null;
		}
		UserDTO ud=new UserDTO();
		ud.setUsername(u.getUsername());
		ud.setUid(u.getUid());
		ud.setEmail(u.getEmail());
		
		return ud;
	}
	@Override
	public boolean checkUid(int uid) {
		
		return UserRepository.existsById(uid);
	}
	

}
