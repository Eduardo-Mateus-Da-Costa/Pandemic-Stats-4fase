package br.edu.unoesc.pandemicstats.springboot.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class EmailSender {
	
    @Autowired
    private JavaMailSender mailSender;

    public void Enviar(String emailadress, String message, String subject) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(emailadress);
        email.setSubject(subject);
        email.setText(message);
        mailSender.send(email);
    }
}
