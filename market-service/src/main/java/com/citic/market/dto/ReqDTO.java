package com.citic.market.dto;

import org.springframework.http.HttpStatus;

public class ReqDTO {

    private Integer id;
    private Integer currentPage;
    private Integer pageSize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ReqDTO(Integer id, Integer currentPage, Integer pageSize) {
        this.id = id;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
