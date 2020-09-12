package com.arcsoft.face.enums;

/**
 * @author st7251
 */
public enum  DetectModel {

    /**
     * RGB图像检测模型
     */
    ASF_DETECT_MODEL_RGB(0x1);


    private int value;

    DetectModel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
