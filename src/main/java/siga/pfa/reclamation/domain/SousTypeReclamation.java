package siga.pfa.reclamation.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name = "pfa_sous_type_reclamation")
public class SousTypeReclamation implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	
	private String libFr;
	
	
	@ManyToOne
    private TypeReclamation typeReclamation;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLibFr() {
		return libFr;
	}


	public void setLibFr(String libFr) {
		this.libFr = libFr;
	}


	public TypeReclamation getTypeReclamation() {
		return typeReclamation;
	}


	public void setTypeReclamation(TypeReclamation typeReclamation) {
		this.typeReclamation = typeReclamation;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	

}
