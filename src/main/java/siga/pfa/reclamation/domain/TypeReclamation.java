package siga.pfa.reclamation.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pfa_type_reclamation")
public class TypeReclamation implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "lib_fr")
    private String libFr;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    

    
    

}
