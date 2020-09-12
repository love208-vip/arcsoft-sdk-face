package com.arcsoft.face;

import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;


/**
 * 引擎配置类
 */
public class EngineConfiguration {

    /**
     * 功能配置
     */
    private FunctionConfiguration functionConfiguration = FunctionConfiguration.builder().build();

    /**
     * 引擎最多能检测出的人脸数，推荐有效值范围[1,50]
     */
    private Integer detectFaceMaxNum = 10;

    /**
     * 识别的最小人脸比例（图片长边与人脸框长边的比值），在VIDEO模式(ASF_DETECT_MODE_VIDEO)下有效值范围[2，32]，推荐值16；在IMAGE模式(ASF_DETECT_MODE_IMAGE)下有效值范围[2，32]，推荐值30
     */
    private Integer detectFaceScaleVal = 16;

    /**
     * 检测模式，支持VIDEO模式({@link DetectMode#ASF_DETECT_MODE_VIDEO})和IMAGE模式({@link DetectMode#ASF_DETECT_MODE_IMAGE})
     */
    private DetectMode detectMode = DetectMode.ASF_DETECT_MODE_IMAGE;

    /**
     * 人脸检测角度的优先级，支持0度(ASF_OP_0_ONLY)，90度(ASF_OP_90_ONLY)，180度(ASF_OP_180_ONLY)，270度(ASF_OP_270_ONLY)，多角度检测(ASF_OP_0_HIGHER_EXT)，建议使用单一指定角度检测，性能比多角度检测更佳
     */
    private DetectOrient detectFaceOrientPriority = DetectOrient.ASF_OP_0_ONLY;

    /**
     *
     * @return 获取引擎功能配置
     */
    public FunctionConfiguration getFunctionConfiguration() {
        return functionConfiguration;
    }

    /**
     * @param functionConfiguration 设置引擎功能配置
     */
    public void setFunctionConfiguration(FunctionConfiguration functionConfiguration) {
        this.functionConfiguration = functionConfiguration;
    }

    /**
     * @return 获取引擎最多能检测出的人脸数
     */
    public Integer getDetectFaceMaxNum() {
        return detectFaceMaxNum;
    }

    /**
     * @param detectFaceMaxNum 设置引擎最多能检测出的人脸数
     */
    public void setDetectFaceMaxNum(Integer detectFaceMaxNum) {
        this.detectFaceMaxNum = detectFaceMaxNum;
    }

    /**
     * @return 人脸相对于所在图片的长边的占比
     */
    public Integer getDetectFaceScaleVal() {
        return detectFaceScaleVal;
    }

    /**
     * @param detectFaceScaleVal 设置人脸相对于所在图片的长边的占比，在视频模式(ASF_DETECT_MODE_VIDEO)下有效值范围[2，32]，在图像模式(ASF_DETECT_MODE_IMAGE)下有效值范围[2，32]
     */
    public void setDetectFaceScaleVal(Integer detectFaceScaleVal) {
        this.detectFaceScaleVal = detectFaceScaleVal;
    }

    /**
     * @return 获取检测模式
     */
    public DetectMode getDetectMode() {
        return detectMode;
    }

    /**
     *
     * @param detectMode 设置检测模式
     */
    public void setDetectMode(DetectMode detectMode) {
        this.detectMode = detectMode;
    }

    /**
     * @return 获取人脸检测角度的优先级，支持0度(ASF_OP_0_ONLY)，90度(ASF_OP_90_ONLY)，180度(ASF_OP_180_ONLY)，270度(ASF_OP_270_ONLY)，多角度检测(ASF_OP_0_HIGHER_EXT)，建议使用单一指定角度检测，性能比多角度检测更佳
     */
    public DetectOrient getDetectFaceOrientPriority() {
        return detectFaceOrientPriority;
    }

    /**
     * @param detectFaceOrientPriority 设置人脸检测角度的优先级，支持0度(ASF_OP_0_ONLY)，90度(ASF_OP_90_ONLY)，180度(ASF_OP_180_ONLY)，270度(ASF_OP_270_ONLY)，多角度检测(ASF_OP_0_HIGHER_EXT)，建议使用单一指定角度检测，性能比多角度检测更佳
     */
    public void setDetectFaceOrientPriority(DetectOrient detectFaceOrientPriority) {
        this.detectFaceOrientPriority = detectFaceOrientPriority;
    }

    public EngineConfiguration() {

    }

    private EngineConfiguration(Builder builder) {
        this.functionConfiguration = builder.functionConfiguration;
        this.detectFaceMaxNum = builder.detectFaceMaxNum;
        this.detectFaceScaleVal = builder.detectFaceScaleVal;
        this.detectMode = builder.detectMode;
        this.detectFaceOrientPriority = builder.detectFaceOrientPriority;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private FunctionConfiguration functionConfiguration = FunctionConfiguration.builder().build();

        private Integer detectFaceMaxNum = 10;

        private Integer detectFaceScaleVal = 16;

        private DetectMode detectMode = DetectMode.ASF_DETECT_MODE_IMAGE;

        private DetectOrient detectFaceOrientPriority = DetectOrient.ASF_OP_0_ONLY;

        private Builder() {
        }

        public EngineConfiguration build() {
            return new EngineConfiguration(this);
        }

        /**
         * @param functionConfiguration 设置引擎功能配置
         *
         * @return 引擎功能配置
         */
        public Builder functionConfiguration(FunctionConfiguration functionConfiguration) {
            this.functionConfiguration = functionConfiguration;
            return this;
        }

        /**
         * @param detectFaceMaxNum 设置引擎最多能检测出的人脸数，推荐有效值范围[1,50]
         *
         * @return 最多能检测出的人脸数
         */
        public Builder detectFaceMaxNum(Integer detectFaceMaxNum) {
            this.detectFaceMaxNum = detectFaceMaxNum;
            return this;
        }

        /**
         * @param detectFaceScaleVal 设置人脸相对于所在图片的长边的占比，在视频模式(ASF_DETECT_MODE_VIDEO)下有效值范围[2，32]，在图像模式(ASF_DETECT_MODE_IMAGE)下有效值范围[2，32]
         *
         * @return 人脸相对于所在图片的长边的占比
         */
        public Builder detectFaceScaleVal(Integer detectFaceScaleVal) {
            this.detectFaceScaleVal = detectFaceScaleVal;
            return this;
        }

        /**
         * @param detectMode 检测模式
         * @return 检测模式
         *
         */
        public Builder detectMode(DetectMode detectMode) {
            this.detectMode = detectMode;
            return this;
        }

        /**
         * @param detectFaceOrientPriority 设置人脸检测角度的优先级，，支持0度(ASF_OP_0_ONLY)，90度(ASF_OP_90_ONLY)，180度(ASF_OP_180_ONLY)，270度(ASF_OP_270_ONLY)，多角度检测(ASF_OP_0_HIGHER_EXT)，建议使用单一指定角度检测，性能比多角度检测更佳
         *
         * @return 人脸检测角度的优先级
         */
        public Builder detectFaceOrientPriority(DetectOrient detectFaceOrientPriority) {
            this.detectFaceOrientPriority = detectFaceOrientPriority;
            return this;
        }
    }
}
