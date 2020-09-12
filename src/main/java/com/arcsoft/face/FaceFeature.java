//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.arcsoft.face;

/**
 * 人脸特征信息类
 */
public class FaceFeature {
    /**
     * 人脸特征数据的长度
     */
    public static final int FEATURE_SIZE = 1032;
    /**
     * 人脸特征数据
     */
    byte[] featureData;

    /**
     * 根据传入的人脸特征对象创建一个新的人脸特征对象，新创建的对象为传入对象的深拷贝
     *
     * @param obj 人脸特征数据对象
     */
    public FaceFeature(FaceFeature obj) {
        if (obj == null) {
            featureData = new byte[FEATURE_SIZE];
        } else {
            featureData = obj.getFeatureData().clone();
        }
    }

    /**
     * 创建一个人脸特征对象
     */
    public FaceFeature() {
        this.featureData = new byte[FEATURE_SIZE];
    }

    /**
     * 根据传入的人脸特征数据创建一个人脸特征对象
     *
     * @param data 人脸特征数据
     */
    public FaceFeature(byte[] data) {
        this.featureData = data;
    }

    /**
     * 获取人脸特征数据
     *
     * @return 人脸特征数据
     */
    public byte[] getFeatureData() {
        return this.featureData;
    }

    /**
     * 设置人脸特征数据
     *
     * @param data 人脸特征数据
     */
    public void setFeatureData(byte[] data) {
        this.featureData = data;
    }

    /**
     * 返回当前人脸特征对象的深拷贝
     *
     * @return 当前人脸特征对象的深拷贝
     */
    @Override
    public FaceFeature clone() {
        return new FaceFeature(this);
    }
}
