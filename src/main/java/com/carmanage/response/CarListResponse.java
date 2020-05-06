package com.carmanage.response;

import com.carmanage.entity.CarEntity;

import java.util.List;

public class CarListResponse {
    private List<CarEntity> carEntityList;
    private Integer pageNo;
    private Integer pages;

    public  CarListResponse(List<CarEntity> carEntityList, Integer pageNo, Integer pages) {
//       CarListResponse carResponse =
//        carResponse.setCarEntityList(carEntityList);
//        carResponse.setPageNo(pageNo);
//        carResponse.setPages(pages);
//        return carResponse;
        this.carEntityList = carEntityList;
        this.pageNo = pageNo;
        this.pages = pages;
    }

    public List<CarEntity> getCarEntityList() {
        return carEntityList;
    }

    public void setCarEntityList(List<CarEntity> carEntityList) {
        this.carEntityList = carEntityList;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }
}
