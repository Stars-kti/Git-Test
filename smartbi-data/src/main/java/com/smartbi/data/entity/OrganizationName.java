package com.smartbi.data.entity;

import lombok.Data;

import java.util.Objects;

/**
 * @author chenjiaxing
 */
@Data
public class OrganizationName {

    private Integer id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrganizationName that = (OrganizationName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
