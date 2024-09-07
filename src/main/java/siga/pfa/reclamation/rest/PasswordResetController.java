package siga.pfa.reclamation.rest;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import siga.pfa.reclamation.domain.PasswordResetRequest;
import siga.pfa.reclamation.domain.User;
import siga.pfa.reclamation.repository.UserRepository;
import siga.pfa.reclamation.service.EmailService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PasswordResetController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

     
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody PasswordResetRequest request) {
        // Traitement des données de la demande
        try {
            // Vérifiez que l'utilisateur existe et générez le nouveau mot de passe ici
            
            // Exemple de données que vous pourriez envoyer dans l'email
            String subject = request.getSubject();
            String text = request.getText();
            String to = request.getTo();
         Optional<User> userOpt = userRepository.findByEmail(to);
         // Generate a new password
            String newPassword = generateRandomPassword();
 if(userOpt.isPresent()) {
            // Update the user's password in the database
             userOpt.get().setPassword(newPassword);
            userRepository.save(userOpt.get());}

        if( emailService.sendResetPasswordEmail(to))   { // Send the new password to the user's email
           

            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Mail sent.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        }catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occured.");
          
    }

    private String generateRandomPassword() {
        // Implement a method to generate a random password
        int length = 8; // Password length
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        Random random = new Random();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }
        return password.toString();
    }
}
