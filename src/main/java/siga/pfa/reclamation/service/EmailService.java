package siga.pfa.reclamation.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
 import org.springframework.stereotype.Service;

import siga.pfa.reclamation.domain.User;
import siga.pfa.reclamation.repository.UserRepository;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;
 
    // Inject the sender email from application.properties
     private String fromEmail="soulaimasou29@gmail.com";

    // Method to generate a random 8-character password
    private String generateRandomPassword() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }

    public Boolean sendResetPasswordEmail(  String toEmail) {
        // Generate a new password
        String newPassword = generateRandomPassword();

        // Hash the password before saving it to the database
 
        // Update the user's password in the database
        Optional<User> user = userRepository.findByEmail(toEmail);
     if(user.isPresent()) {
        user.get().setPassword(newPassword);
        userRepository.save(user.get());
     }
        // Prepare the email content
        String subject = "Your New Password";
        String text = "Hello "+user.get().getFirstName()+" "+user.get().getLastName()+",\n\nYour password has been reset. Here is your new password: " +
                      newPassword + 
                      "\n\nPlease log in and change it as soon as possible.\n\n" +
                      "Best regards,\nSIGA";

        // Send the email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail.trim());
        message.setSubject(subject);
        message.setText(text);
        message.setFrom(fromEmail.trim());  // Use the injected fromEmail value
 
        mailSender.send(message);
         
        return true;
 
     }
}
