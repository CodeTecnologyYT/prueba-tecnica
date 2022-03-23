package com.nisum.pruebatecnica.models.entities;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "NPT_USER")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Column(name = "EMAIL", columnDefinition = "VARCHAR(100)",unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", columnDefinition = "VARCHAR(100)", nullable = false)
    private String password;

    @Column(name = "DATE_CREATED")
    @ColumnDefault(value="CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "DATE_MODIFIED")
    @ColumnDefault(value="CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    @Column(name = "DATE_LAST_LOGIN")
    @ColumnDefault(value="CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLastLogin;

    @Column(name = "IS_ACTIVE", columnDefinition = "VARCHAR(1)",nullable = false)
    private String isActive;

    @OneToMany(mappedBy = "user",cascade = {CascadeType.ALL})
    private Set<PhoneEntity> phones;
}
