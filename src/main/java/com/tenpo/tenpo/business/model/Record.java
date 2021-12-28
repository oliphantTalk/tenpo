package com.tenpo.tenpo.business.model;

import com.tenpo.tenpo.business.record.RqType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(name = "request_record")
@Getter
@Setter
@ToString
public class Record extends BaseEntity {

    private String email;

    @Enumerated(STRING)
    @Column(name = "request_type")
    private RqType requestType;

    @Column(name = "http_status")
    private int httpStatus;

    // JSONify a response object
    private String response;

}

