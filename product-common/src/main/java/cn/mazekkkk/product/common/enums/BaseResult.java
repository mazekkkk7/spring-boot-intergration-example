package cn.mazekkkk.product.common.enums;

/**
 * Created by mazekkkk on 16/6/21.
 */
public enum BaseResult {
    SUCCESS(1),FAIL(2);

    private Integer enumValue;

    BaseResult(Integer enumValue) {
        this.enumValue = enumValue;
    }

    public Integer getEnumValue() {
        return enumValue;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
