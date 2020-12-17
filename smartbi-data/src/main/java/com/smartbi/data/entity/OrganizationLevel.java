package com.smartbi.data.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Objects;

/**
 * @author chenjiaxing
 */
@Data
@Alias("OrganizationLevel")
public class OrganizationLevel {

    private Integer id;
    private String level;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrganizationLevel that = (OrganizationLevel) o;
        return Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level);
    }

}
