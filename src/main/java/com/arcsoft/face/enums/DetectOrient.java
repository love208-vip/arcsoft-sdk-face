package com.arcsoft.face.enums;

/**
 * 人脸检测角度
 */
public enum DetectOrient {
    /**
     * 人脸检测角度，逆时针0度
     */
    ASF_OP_0_ONLY(1),
    /**
     * 人脸检测角度，逆时针90度
     */
    ASF_OP_90_ONLY(2),
    /**
     * 人脸检测角度，逆时针270度
     */
    ASF_OP_270_ONLY(3),
    /**
     * 人脸检测角度，逆时针180度
     */
    ASF_OP_180_ONLY(4),
    /**
     * 人脸检测角度，各个角度尝试检测
     */
    ASF_OP_ALL_OUT(5);

    private int value;

    DetectOrient(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
