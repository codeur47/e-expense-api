package com.yorosoft.eexpenseapi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDTO {

    @ApiModelProperty(value = "The id of the object")
    private Long id;
}
