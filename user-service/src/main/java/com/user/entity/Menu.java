package com.user.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@ApiModel
@Entity(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ApiModelProperty("路径")
    private String path;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("详情")
    private String detail;
    @ApiModelProperty("是否需要验证")
    private Integer requireAuth;
    @ApiModelProperty("上级菜单id")
    private Integer parentId;
    @ApiModelProperty("是否启用")
    private Boolean enabled;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name="parentId", referencedColumnName = "id")
    private List<Menu> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Integer requireAuth) {
        this.requireAuth = requireAuth;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(path, menu.path) &&
                Objects.equals(name, menu.name) &&
                Objects.equals(detail, menu.detail) &&
                Objects.equals(requireAuth, menu.requireAuth) &&
                Objects.equals(parentId, menu.parentId) &&
                Objects.equals(enabled, menu.enabled) &&
                Objects.equals(children, menu.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path, name, detail, requireAuth, parentId, enabled, children);
    }
}
