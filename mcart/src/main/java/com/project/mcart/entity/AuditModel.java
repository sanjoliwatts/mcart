package com.project.mcart.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
		value = { "dateOfCreation", "dateOfModification"/* , "dateOfOrder" */},
        allowGetters = true
)
public abstract class AuditModel implements Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_creation", nullable = false, updatable = false)
    @CreatedDate
    private Date dateOfCreation = new Date();
    
    
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "date_of_order", nullable = false, updatable = false, insertable = false)
//    @CreatedDate
//    private Date dateOfOrder;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_modification", nullable = true, insertable= false)
    @LastModifiedDate
    private Date dateOfModification;

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Date getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(Date dateOfModification) {
        this.dateOfModification = new Date();
    }
//
//	public Date getDateOfOrder() {
//		return dateOfOrder;
//	}
//
//	public void setDateOfOrder(Date dateOfOrder) {
//		this.dateOfOrder = dateOfOrder;
//	}
   
    
}