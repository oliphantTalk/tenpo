package com.tenpo.tenpo.business.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Privilege extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

}
