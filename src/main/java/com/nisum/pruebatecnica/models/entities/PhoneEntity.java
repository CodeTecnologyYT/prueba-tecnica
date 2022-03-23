package com.nisum.pruebatecnica.models.entities;

import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "NPT_PHONE")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@DynamicInsert
@DynamicUpdate
public class PhoneEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID")
    private String id;

    @Column(name = "NUMBER", columnDefinition = "VARCHAR(15)", nullable = false)
    private String number;

    @Column(name = "CITY_CODE", columnDefinition = "VARCHAR(3)", nullable = false)
    private String cityCode;

    @Column(name = "COUNTRY_CODE", columnDefinition = "VARCHAR(5)", nullable = false)
    private String countryCode;

    @Column(name = "DATE_CREATED")
    @ColumnDefault(value="CURRENT_TIMESTAMP")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "DATE_MODIFIED")
    @ColumnDefault(value="CURRENT_TIMESTAMP")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private UserEntity user;
}
