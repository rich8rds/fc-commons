package com.favourite.collections.commons.useradmin.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.favourite.collections.commons.useradmin.domain.Permission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;


@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleResponseData {

    private String name;
    private String description;
    private Boolean isDisabled;
    private Set<Permission> permissions;

}
