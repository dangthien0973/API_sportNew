package API_sportNew.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import API_sportNew.entity.useraccount;
import API_sportNew.repository.UserRepository;
import net.bytebuddy.utility.RandomString;


@Service
public class UserService  {
	   @Autowired
	    private JavaMailSender mailSender;
	   @Autowired
	   private UserRepository repo;
	   // dang ki gui mail
	    public void register(useraccount user, String siteURL)  throws UnsupportedEncodingException, MessagingException {
	    		    String randomCode = RandomString.make(64);
	    		    user.setVerificationCode(randomCode);
	    		    user.setEnabled(1);
	    		    repo.save(user);
	    		    sendVerificationEmail(user, siteURL);
	    }
	     
	    public  void sendVerificationEmail(useraccount user, String siteURL)   throws MessagingException, UnsupportedEncodingException {
	        String toAddress = user.getEmail();
	        String fromAddress = "itdangthien0973@gmail.com";
	        String senderName = "Mã xác thực đăng kí";
	        String subject = "Please verify your registration";
	        String content = "Dear [[name]],<br>"
	                + "Please click the link below to verify your registration:<br>"
	                + "<h3>[[URL]]</h3>"
	                + "Thank you,<br>"
	                + "Your company name.";
	         
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	         
	        helper.setFrom(fromAddress, senderName);
	        helper.setTo(toAddress);
	        helper.setSubject(subject);
	         
	        content = content.replace("[[name]]", user.getCustomername());
	        content = content.replace("[[URL]]", user.getVerificationCode());
	         
	        helper.setText(content, true);
	         
	        mailSender.send(message);
	         
	    } 
	     
	    
}
