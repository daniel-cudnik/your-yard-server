package com.example.jwtspringdatabaseusers.base.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_BASE_ID")
public class BaseEntity implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ")
    private Long id;

    @Column(name = "TECHDATE",
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date techDate;

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTechDate() {
        return techDate;
    }

    public void setTechDate(Date techDate) {
        this.techDate = techDate;
    }

    @PrePersist
    @PreUpdate
    private void setCurrentDate(){
        techDate = new Date();
    }
}
