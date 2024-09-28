package jmaster.io.restapi.cotroller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jmaster.io.restapi.model.User;
import jmaster.io.restapi.service.UserService;

@RestController
public class UserController {
//  before: sử dụng DAO viết thủ công lệnh sql	
//	@PostMapping("/register")
//	public List<User> create(@RequestBody User user) {
//		List<User> use = new ArrayList<>();	
//		UserDAO.addAUser(user);
//		use = UserDAO.getAllUsers();
//		return use;							
//	}
	@Autowired 
	private UserService userService;
	
//	@PostMapping("/login")
//	public ResponseEntity<User> isSuccess(@RequestBody String[] unAndPw) {
//		System.out.println(45);
//		User user = userService.findAUser(unAndPw);
//		return ResponseEntity.ofNullable(user);
//	}

	
	
	
}
