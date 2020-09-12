//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.arcsoft.face;

/**
 * 人脸信息类
 */
public class FaceInfo {
    /**
     * 人脸位置信息
     */
    Rect rect;
    /**
     * 人脸角度
     */
    int orient;

    /**
     * faceId，IMAGE模式下不返回faceId
     */
    int faceId = -1;

    /**
     * 根据人脸位置信息和人脸角度创建一个人脸信息对象
     *
     * @param rect   人脸位置信息
     * @param orient 人脸角度
     */
    public FaceInfo(Rect rect, int orient) {
        this.rect = new Rect(rect);
        this.orient = orient;
    }

    /**
     * 根据传入的人脸信息对象创建一个新的人脸信息对象
     *
     * @param obj 人脸信息对象
     */
    public FaceInfo(FaceInfo obj) {

        this.rect = new Rect(obj.getRect());
        this.orient = obj.getOrient();
        this.faceId = obj.getFaceId();
    }

    /**
     * 创建一个新的人脸信息对象
     */
    public FaceInfo() {
        rect = new Rect();
        orient = 0;
    }

    /**
     * 获取人脸位置信息
     *
     * @return 人脸位置信息
     */
    public Rect getRect() {
        return this.rect;
    }

    /**
     * 获取人脸角度
     *
     * @return 人脸角度
     */
    public int getOrient() {
        return this.orient;
    }

    /**
     * 设置人脸位置信息
     *
     * @param rect 人脸位置信息
     */
    public void setRect(Rect rect) {
        this.rect = rect;
    }

    /**
     * 设置人脸角度
     *
     * @param orient 人脸角度
     */
    public void setOrient(int orient) {
        this.orient = orient;
    }

    /**
     * 获取faceId
     * @return faceId
     */
    public int getFaceId() {
        return faceId;
    }

    /**
     * 设置faceId
     * @param faceId 人脸Id
     */
    public void setFaceId(int faceId) {
        this.faceId = faceId;
    }

    /**
     * 获取格式化的人脸信息
     *
     * @return 格式化的人脸信息
     */
    @Override
    public String toString() {
        return this.rect.toString() + "," + this.orient;
    }

}
