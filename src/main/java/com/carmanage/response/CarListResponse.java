package com.carmanage.response;

import com.carmanage.entity.CarListEntity;

import java.util.List;

public class CarListResponse {
    private List<CarListEntity> carListEntityList;
    private Integer pageNo;
    private Integer pages;

    public  CarListResponse(List<CarListEntity> carListEntityList, Integer pageNo, Integer pages) {
//       CarListResponse carResponse =
//        carResponse.setCarEntityList(carEntityList);
//        carResponse.setPageNo(pageNo);
//        carResponse.setPages(pages);
//        return carResponse;
        this.carListEntityList = carListEntityList;
        this.pageNo = pageNo;
        this.pages = pages;
    }

    public List<CarListEntity> getCarListEntityList() {
        return carListEntityList;
    }

    public void setCarListEntityList(List<CarListEntity> carListEntityList) {
        this.carListEntityList = carListEntityList;
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
