package com.bms.slpd.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD0621IParam",
        description = "查询储存运输标准指标接口入参")
public class SLPD0621IParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "通过查询breedId查询全部差异卡标志,等于1时查询breedId下所有差异卡,其它查询标准卡")
    private int findAllFlag;
    @ApiModelProperty(value = "breedId集合")
    private List<Long> breedIds;
    @ApiModelProperty(value = "productId集合")
    private List<String> productIds;

    public int getFindAllFlag() {
        return findAllFlag;
    }

    public void setFindAllFlag(int findAllFlag) {
        this.findAllFlag = findAllFlag;
    }

    public List<Long> getBreedIds() {
        return breedIds;
    }

    public void setBreedIds(List<Long> breedIds) {
        this.breedIds = breedIds;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<String> productIds) {
        this.productIds = productIds;
    }
}
