package com.optimagrowth.organizationservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "organizations")
@Data
public class Organization {

    @Id
    @Column(name = "organization_id", nullable = false)
    String id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "contact_name", nullable = false)
    String contactName;

    @Column(name = "contact_email", nullable = false)
    String contactEmail;

    @Column(name = "contact_phone", nullable = false)
    String contactPhone;

}
