package com.arcsoft.face;

import java.util.List;

/**
 * RGB活体检测类
 */
public class LivenessInfo {

    /**
     * RGB活体值
     */
    private int liveness = -1;

    /**
     * 创建一个新的RGB活体信息对象
     */
    public LivenessInfo() {

    }

    /**
     * 根据传入的RGB活体信息对象创建一个新的RGB活体信息对象，新创建的RGB活体信息对象和为传入对象的深拷贝
     *
     * @param livenessInfo RGB活体信息对象
     */
    public LivenessInfo(LivenessInfo livenessInfo) {
        if (livenessInfo != null) {
            liveness = livenessInfo.getLiveness();
        }
    }

    /**
     * 获取RGB活体值
     *
     * @return RGB活体值，未知=-1 、非活体=0 、活体=1、超出人脸=-2
     */
    public int getLiveness() {
        return liveness;
    }

}
