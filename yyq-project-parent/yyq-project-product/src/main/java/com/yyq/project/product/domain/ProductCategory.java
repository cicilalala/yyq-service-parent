package com.yyq.project.product.domain;

import com.yyq.base.api.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by yangyunqi on 2017/7/28.
 */
@Entity
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@DynamicUpdate // 动态更新 数据库时间设置为自动更新，必须要加入这个字段
public class ProductCategory extends BaseModel<ProductCategory> {

    @Id
    @GeneratedValue
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
