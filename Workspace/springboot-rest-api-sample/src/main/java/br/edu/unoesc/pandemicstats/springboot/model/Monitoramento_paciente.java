package br.edu.unoesc.pandemicstats.springboot.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@SequenceGenerator(name = "seq_mon_paciente", sequenceName = "seq_mon_paciente", allocationSize = 1, initialValue = 1)
@Data
public class Monitoramento_paciente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mon_paciente")
	private int codmon;
	private String datmon;
	private char intsin;
	private Paciente codpac;
	private Sintoma codsin;
}
