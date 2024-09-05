package siga.pfa.reclamation.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "pfa_reclamation")
public class Reclamation implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
     @Column(name = "id_creator")

    private Long idCreator;
 
    @Column(name = "message")
    private String message;
    
    @Column(name = "observation")
    private String observation;
    
    @Lob
    @Column(name = "image")
    private byte[] image;
    
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    
    @Column(name = "created_by")
    private String createdBy;
    
    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;


    @Column(name = "modified_by")
    private String modifiedBy;
    
    @Column(name = "situation")
    private Integer situation; 
    
    @ManyToOne
    private SousTypeReclamation sousTypeReclamation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getSituation() {
		return situation;
	}

	public void setSituation(Integer situation) {
		this.situation = situation;
	}

 	public Long getIdCreator() {
		return idCreator;
	}

	public void setIdCreator(Long idCreator) {
		this.idCreator = idCreator;
	}
 
	public SousTypeReclamation getSousTypeReclamation() {
		return sousTypeReclamation;
	}

	public void setSousTypeReclamation(SousTypeReclamation sousTypeReclamation) {
		this.sousTypeReclamation = sousTypeReclamation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	
	
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
    
	
    

}
