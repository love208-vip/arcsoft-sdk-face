package com.arcsoft.face;

/**
 * IR活体检测类
 */
public class IrLivenessInfo {

    /**
     * IR活体值
     */
    int liveness=-1;

    /**
     * 创建一个新的IR活体信息对象
     */
    public IrLivenessInfo(){

    }

    /**
     * 根据传入的IR活体信息对象创建一个新的IR活体信息对象，新创建的IR活体信息对象和为传入对象的深拷贝
     *
     * @param livenessInfo IR活体信息对象
     */
    public IrLivenessInfo(IrLivenessInfo livenessInfo) {
        if (livenessInfo != null) {
            liveness = livenessInfo.getLiveness();
        }
    }

    /**
     * 获取IR活体值
     *
     * @return IR活体值，未知=-1 、非活体=0 、活体=1、超出人脸=-2
     */
    public int getLiveness() {
        return liveness;
    }


}
