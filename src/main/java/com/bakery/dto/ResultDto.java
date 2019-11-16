package com.bakery.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultDto {
    String total;
    List<String> detail;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<String> getDetail() {
        if (detail == null)
            detail = new ArrayList<>();
        return detail;
    }

    public void setDetail(List<String> detail) {
        this.detail = detail;
    }
}
