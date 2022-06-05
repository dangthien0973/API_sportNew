package API_sportNew.controller;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import API_sportNew.entity.useraccount;
import API_sportNew.payload.ReponseStatus;
import API_sportNew.payload.SignUpDto;
import API_sportNew.repository.UserRepository;
/*import API_sportNew.service.UserService;*/
import net.bytebuddy.utility.RandomString;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class RestUserController {

	@Autowired
	private UserRepository userRepository;
	/* @Autowired private UserService userService; */

	@PostMapping("/signup")
	public ResponseEntity<ReponseStatus> registerUser(@RequestBody SignUpDto signUpDto)
			throws UnsupportedEncodingException, MessagingException {
		ReponseStatus status = new ReponseStatus();
		// add check for username exists in a DB
		if (userRepository.existsByUsername(signUpDto.getUsername())) {
			status.setStatus(200);
			status.setMessage("UserName đã tồn tại!");
			return new ResponseEntity<ReponseStatus>(status, HttpStatus.BAD_REQUEST);
		}

		// add check for email exists in DB

		if (userRepository.existsByEmail(signUpDto.getEmail())) {
			status.setStatus(200);
			status.setMessage("Email đã tồn tại!");
			return new ResponseEntity<ReponseStatus>(status, HttpStatus.BAD_REQUEST);
		}
		// create user object
		useraccount user = new useraccount();
		user.setCustomername(signUpDto.getCustomername());
		user.setUsername(signUpDto.getUsername());
		user.setEmail(signUpDto.getEmail());
		user.setPassword(signUpDto.getPassword());
		Date dt = new Date();
		dt = new Date(System.currentTimeMillis());
		String randomCode = RandomString.make(64);
		user.setVerificationCode(randomCode);
		user.setEnabled(1);
		user.setCreatedate(dt);
		userRepository.save(user);
		status.setStatus(200);
		status.setMessage("Đăng kí thành công !");
		return new ResponseEntity<ReponseStatus>(status, HttpStatus.OK);
	}

	// kiểm tra email đã tồn tại chưa
	@PostMapping("/checkemail")
	public ResponseEntity<ReponseStatus> registerUser(@RequestBody String email)
			throws UnsupportedEncodingException, MessagingException {
		ReponseStatus status = new ReponseStatus();
		
		if (userRepository.existsByEmail(email)) {
			status.setStatus(200);
			status.setMessage("Email đã tồn tại!");
			return new ResponseEntity<ReponseStatus>(status, HttpStatus.BAD_REQUEST);
		} else {
			status.setStatus(200);
			status.setMessage("Email ok !");
			return new ResponseEntity<ReponseStatus>(status, HttpStatus.BAD_REQUEST);
		}
	}
}
