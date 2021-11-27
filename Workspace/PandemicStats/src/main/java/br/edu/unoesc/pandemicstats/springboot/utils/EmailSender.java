package br.edu.unoesc.pandemicstats.springboot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author Eduardo Mateus Da Costa
 * @since 25/11/2021
 * @version 1.1
 * @see JavaMailSender
 */

@Component
public class EmailSender {
	
    @Autowired
    private JavaMailSender mailSender;

    /**
     * @param String emailadress
     * @param String message
     * @param String subject
     * @see SimpleMailMessage
     */
    public void Enviar(String emailadress, String message, String subject) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(emailadress);
        email.setSubject(subject);
        email.setText(message);
        mailSender.send(email);
    }
}
