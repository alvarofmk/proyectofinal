package com.salesianostriana.dam.karting.model;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@IdClass(VueltaPK.class)
public class Vuelta implements Comparable<Vuelta>, Persistable<VueltaPK>{
	
	@Id
	@ManyToOne
	private Participacion participacion;
	
	@Id
	private int numeroVuelta;
	
	private Duration tiempo;
	
	@Transient
    private boolean isNew = true; 

	@Override
	public int compareTo(Vuelta o) {
		return tiempo.compareTo(o.getTiempo());
	}

	@Override
	public VueltaPK getId() {
		return new VueltaPK(participacion, numeroVuelta);
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return isNew;
	}

    @PrePersist 
    @PostLoad
    void markNotNew() {
        this.isNew = false;
    }

}
