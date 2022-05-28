package API_sportNew.controller;
 import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.http.HttpStatus; 
 import org.springframework.http.ResponseEntity; 
 import org.springframework.web.bind.annotation.PostMapping; 
 import org.springframework.web.bind.annotation.RequestBody; 
 import org.springframework.web.bind.annotation.RequestMapping; 
 import org.springframework.web.bind.annotation.RestController;

import API_sportNew.entity.useraccount;
import API_sportNew.payload.SignUpDto;
import API_sportNew.repository.UserRepository;
import API_sportNew.service.UserService;
import net.bytebuddy.utility.RandomString;


  @RestController
 
  @RequestMapping("/api/auth") public class RestUserController {
  
  @Autowired private UserRepository userRepository;
  @Autowired private UserService userService;
  
  @PostMapping("/signup") public ResponseEntity<?> registerUser(@RequestBody
  SignUpDto signUpDto) throws UnsupportedEncodingException, MessagingException{
  
  // add check for username exists in a DB
  if(userRepository.existsByUsername(signUpDto.getUsername())){ return new
  ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST); }
  
  // add check for email exists in DB
	/*
	 * if(userRepository.existsByEmail(signUpDto.getEmail())){ return new
	 * ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST); }
	 */
  
 // create user object 
  useraccount user = new useraccount();
  user.setCustomername(signUpDto.getCustomername());
  user.setUsername(signUpDto.getUsername());
  user.setEmail(signUpDto.getEmail());
  user.setPassword(signUpDto.getPassword());
  Date dt =new Date();
 dt = new Date(System.currentTimeMillis());
 String randomCode = RandomString.make(64);
 user.setVerificationCode(randomCode);
 user.setEnabled(1);
  user.setCreatedate(dt);
  
  userRepository.save(user);
  userService.sendVerificationEmail(user,"test");
  
  return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
  
 } }
