package com.arcsoft.face.enums;

/**
 * 检测模式
 */
public enum DetectMode {
    /**
     * VIDEO检测模式，用于处理连续帧的图像数据
     */
    ASF_DETECT_MODE_VIDEO(0L),
    /**
     * IMAGE检测模式，用于处理单张的图像数据
     */
    ASF_DETECT_MODE_IMAGE(0xFFFFFFFFL);

    private long value;

    DetectMode(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
