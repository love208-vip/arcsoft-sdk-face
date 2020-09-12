package com.arcsoft.face.enums;

/**
 * 检测结果中的人脸角度
 */
public enum DetectResultOrient {
    /**
     * 检测结果中的人脸角度，逆时针0度
     */
    ASF_OC_0(1),
    /**
     * 检测结果中的人脸角度，逆时针90度
     */
    ASF_OC_90(2),
    /**
     * 检测结果中的人脸角度，逆时针270度
     */
    ASF_OC_270(3),
    /**
     * 检测结果中的人脸角度，逆时针180度
     */
    ASF_OC_180(4),
    /**
     * 检测结果中的人脸角度，逆时针30度
     */
    ASF_OC_30(5),
    /**
     * 检测结果中的人脸角度，逆时针60度
     */
    ASF_OC_60(6),
    /**
     * 检测结果中的人脸角度，逆时针120度
     */
    ASF_OC_120(7),
    /**
     * 检测结果中的人脸角度，逆时针150度
     */
    ASF_OC_150(8),
    /**
     * 检测结果中的人脸角度，逆时针210度
     */
    ASF_OC_210(9),
    /**
     * 检测结果中的人脸角度，逆时针240度
     */
    ASF_OC_240(10),
    /**
     * 检测结果中的人脸角度，逆时针300度
     */
    ASF_OC_300(11),
    /**
     * 检测结果中的人脸角度，逆时针330度
     */
    ASF_OC_330(12);

    private Integer value;

    DetectResultOrient(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static DetectResultOrient getValidEnum(Integer value) {
        for (DetectResultOrient detectResultOrient : DetectResultOrient.values()) {
            if (detectResultOrient.getValue().equals(value)) {
                return detectResultOrient;
            }
        }
        return null;
    }
}
