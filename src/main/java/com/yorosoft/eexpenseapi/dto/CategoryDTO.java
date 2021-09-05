package com.yorosoft.eexpenseapi.dto;

import com.yorosoft.eexpenseapi.model.Purchase;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Collection;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO extends BaseDTO {

    @ApiModelProperty(value = "The name of the category")
    private String name;

    @ApiModelProperty(value = "The list of the category purchases")
    private Collection<Purchase> purchaseList;
}
