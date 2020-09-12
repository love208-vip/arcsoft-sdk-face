package com.arcsoft.face;


/**
 * 功能配置类
 */
public class FunctionConfiguration {

    /**
     * 是否支持人脸检测
     */
    private Boolean supportFaceDetect = false;
    /**
     * 是否支持人脸识别
     */
    private Boolean supportFaceRecognition = false;
    /**
     * 是否支持年龄检测
     */
    private Boolean supportAge = false;
    /**
     * 是否支持性别检测
     */
    private Boolean supportGender = false;
    /**
     * 是否支持3D人脸检测
     */
    private Boolean supportFace3dAngle = false;
    /**
     * 是否支持RGB活体检测
     */
    private Boolean supportLiveness = false;

    /**
     * 是否支持IR活体检测
     */
    private Boolean supportIRLiveness = false;

    private Boolean supportImageQuality = false;


    /**
     * @return 是否支持人脸检测
     */
    public Boolean isSupportFaceDetect() {
        return supportFaceDetect;
    }

    /**
     * @param supportFaceDetect 设置是否支持人脸检测
     */
    public void setSupportFaceDetect(Boolean supportFaceDetect) {
        this.supportFaceDetect = supportFaceDetect;
    }

    /**
     * @return 是否支持人脸识别
     */
    public Boolean isSupportFaceRecognition() {
        return supportFaceRecognition;
    }

    /**
     * @param supportFaceRecognition 设置是否支持人脸识别
     */
    public void setSupportFaceRecognition(Boolean supportFaceRecognition) {
        this.supportFaceRecognition = supportFaceRecognition;
    }

    /**
     * @return 是否支持年龄检测
     */
    public Boolean isSupportAge() {
        return supportAge;
    }

    /**
     * @param supportAge 设置是否支持年龄检测
     */
    public void setSupportAge(Boolean supportAge) {
        this.supportAge = supportAge;
    }

    /**
     * @return 是否支持性别检测
     */
    public Boolean isSupportGender() {
        return supportGender;
    }

    /**
     * @param supportGender 设置是否支持性别检测
     */
    public void setSupportGender(Boolean supportGender) {
        this.supportGender = supportGender;
    }

    /**
     * @return 是否支持3D人脸检测
     */
    public Boolean isSupportFace3dAngle() {
        return supportFace3dAngle;
    }

    /**
     * @param supportFace3dAngle 设置是否支持3D人脸检测
     */
    public void setSupportFace3dAngle(Boolean supportFace3dAngle) {
        this.supportFace3dAngle = supportFace3dAngle;
    }

    /**
     * @return 是否支持RGB活体检测
     */
    public Boolean isSupportLiveness() {
        return supportLiveness;
    }

    /**
     * @param supportLiveness 设置是否支持RGB活体检测
     */
    public void setSupportLiveness(Boolean supportLiveness) {
        this.supportLiveness = supportLiveness;
    }

    /**
     * @return 是否支持IR活体检测
     */
    public Boolean isSupportIRLiveness() {
        return supportIRLiveness;
    }

    /**
     * @param supportIRLiveness 设置是否支持IR活体检测
     */
    public void setSupportIRLiveness(Boolean supportIRLiveness) {
        this.supportIRLiveness = supportIRLiveness;
    }

    /**
     * @return 是否支持图像质量检测检测
     */
    public Boolean isSupportImageQuality(){
        return supportImageQuality;
    }

    /**
     * @param supportImageQuality 设置是否支持图像质量检测
     */
    public void setSupportImageQuality(Boolean supportImageQuality) {
        this.supportImageQuality = supportImageQuality;
    }


    public FunctionConfiguration() {

    }

    private FunctionConfiguration(Builder builder) {
        this.supportFaceDetect = builder.supportFaceDetect;
        this.supportFaceRecognition = builder.supportFaceRecognition;
        this.supportAge = builder.supportAge;
        this.supportGender = builder.supportGender;
        this.supportFace3dAngle = builder.supportFace3dAngle;
        this.supportLiveness = builder.supportLiveness;
        this.supportIRLiveness = builder.supportIRLiveness;
        this.supportImageQuality=builder.supportImageQuality;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private Boolean supportFaceDetect = false;
        private Boolean supportFaceRecognition = false;
        private Boolean supportAge = false;
        private Boolean supportGender = false;
        private Boolean supportFace3dAngle = false;
        private Boolean supportLiveness = false;
        private Boolean supportIRLiveness = false;
        private Boolean supportImageQuality =false;


        private Builder() {
        }

        public FunctionConfiguration build() {
            return new FunctionConfiguration(this);
        }

        /**
         * @param supportFaceDetect 设置是否支持人脸检测
         * @return 是否支持人脸检测
         */
        public Builder supportFaceDetect(Boolean supportFaceDetect) {
            this.supportFaceDetect = supportFaceDetect;
            return this;
        }

        /**
         * @param supportFaceRecognition 设置是否支持人脸识别
         * @return 是否支持人脸识别
         */
        public Builder supportFaceRecognition(Boolean supportFaceRecognition) {
            this.supportFaceRecognition = supportFaceRecognition;
            return this;
        }

        /**
         * @param supportAge 设置是否支持年龄检测
         * @return 是否支持年龄检测
         */
        public Builder supportAge(Boolean supportAge) {
            this.supportAge = supportAge;
            return this;
        }

        /***
         *
         * @param supportGender 设置是否支持性别检测
         * @return 是否支持性别检测
         */
        public Builder supportGender(Boolean supportGender) {
            this.supportGender = supportGender;
            return this;
        }

        /**
         * @param supportFace3dAngle 设置是否支持3D人脸检测
         * @return 是否支持3D人脸检测
         */
        public Builder supportFace3dAngle(Boolean supportFace3dAngle) {
            this.supportFace3dAngle = supportFace3dAngle;
            return this;
        }

        /**
         * @param supportLiveness 设置是否支持RGB活体检测
         * @return 是否支持活体检测
         */
        public Builder supportLiveness(Boolean supportLiveness) {
            this.supportLiveness = supportLiveness;
            return this;
        }

        /**
         * @param supportIRLiveness 设置是否支持IR活体检测
         * @return 是否支持活体检测
         */
        public Builder supportIRLiveness(Boolean supportIRLiveness) {
            this.supportIRLiveness = supportIRLiveness;
            return this;
        }

        /**
         * @param supportImageQuality 设置是否支持图像质量检测
         * @return 是否支持活体检测
         */
        public Builder supportImageQuality(Boolean supportImageQuality) {
            this.supportImageQuality = supportImageQuality;
            return this;
        }
    }
}
