package com.smartbi.data.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

/**
 * @author chenjiaxing
 */
@Data
@EqualsAndHashCode(of = {"code"})
public class OrganizationCode {


    private Integer id;
    private String code;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrganizationCode that = (OrganizationCode) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    public OrganizationCode() {
    }

}
