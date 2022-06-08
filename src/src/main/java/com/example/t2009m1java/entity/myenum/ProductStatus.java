package com.example.t2009m1java.entity.myenum;

public enum ProductStatus {
    ACTIVE(1), DEACTIVE(0), DELETED(-1), UNDEFINED(-2);

    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ProductStatus of(int value) {
        for (ProductStatus productStatus :
                ProductStatus.values()) {
            if (productStatus.getValue() == value) {
                return productStatus;
            }
        }
        return ProductStatus.UNDEFINED;
    }
}
