package com.rails.mybatisdemo.demo.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author lizhibin
 * @since 2019-04-19
 */
@TableName("sljy_order_product")
@ApiModel(value="SljyOrderProduct对象", description="订单表")
@Data
@FieldNameConstants
//@FieldNameConstants(prefix = "PREFIX_", suffix = "_SUFFIX")
public class SljyOrderProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "")
    @TableId(type = IdType.UUID)
    private String orderId;

    @ApiModelProperty(value = "")
    private String orderCode;

    @ApiModelProperty(value = "")
    private String orderDay;

    @ApiModelProperty(value = "")
    private Date orderDate;

    @ApiModelProperty(value = "")
    private String userId;







}
