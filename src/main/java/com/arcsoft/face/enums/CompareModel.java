package com.arcsoft.face.enums;

/**
 * @author st7251
 */
public enum CompareModel {

    /**
     * 用于生活照之间的特征比对，推荐阈值0.80
     */
    LIFE_PHOTO(0x1),

    /**
     * 用于证件照或生活照与证件照之间的特征比对，推荐阈值0.82
     */
    ID_PHOTO(0x2);


    private int value;

    CompareModel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
