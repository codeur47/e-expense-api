package com.yorosoft.eexpenseapi.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Purchase> purchaseList;
}
