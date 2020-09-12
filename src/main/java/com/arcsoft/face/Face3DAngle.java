//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.arcsoft.face;

/**
 * 人脸3D角度信息类
 */
public class Face3DAngle {

    /**
     * yaw角度信息
     */
    float yaw;

    /**
     * roll角度信息
     */
    float roll;
    /**
     * pitch角度信息
     */
    float pitch;

    /**
     * 对于每一张脸角度检测的状态，如果status为0 表示检测正常，roll，yaw，pitch 的数值可信，否则上面三个角度信息是不可信的
     */
    int status;

    /**
     * 创建一个空的Face3DAngle对象
     */
    public Face3DAngle() {
        this.yaw = 0.0F;
        this.roll = 0.0F;
        this.pitch = 0.0F;
        this.status = 1;
    }

    /**
     * 传入一个Face3DAngle对象，生成一个新的Face3DAngle对象，生成的对象为传入对象的深拷贝
     *
     * @param obj 传入的Face3DAngle对象
     */
    public Face3DAngle(Face3DAngle obj) {
        if (obj == null) {
            this.yaw = 0.0F;
            this.roll = 0.0F;
            this.pitch = 0.0F;
            this.status = 1;
        } else {
            this.yaw = obj.getYaw();
            this.roll = obj.getRoll();
            this.pitch = obj.getPitch();
            this.status = obj.getStatus();
        }
    }

    /**
     * 获取yaw角度信息
     *
     * @return yaw角度信息
     */
    public float getYaw() {
        return this.yaw;
    }

    /**
     * 获取roll角度信息
     *
     * @return roll角度信息
     */
    public float getRoll() {
        return this.roll;
    }

    /**
     * 获取pitch角度信息
     *
     * @return pitch角度信息
     */
    public float getPitch() {
        return this.pitch;
    }

    /**
     * 获取状态信息
     *
     * @return 状态信息，如果值为0 表示检测正常，roll，yaw， pitch 的数值可信，否则上面三个角度信息是不可信的
     */
    public int getStatus() {
        return this.status;
    }

    /**
     * 获取当前对象的深拷贝
     *
     * @return 当前对象的深拷贝
     */
    @Override
    public Face3DAngle clone() {
        return new Face3DAngle(this);
    }

    /**
     * 获取格式化的三维角度信息字符串
     *
     * @return 格式化的三维角度信息字符串
     */
    @Override
    public String toString() {
        return "Face3DAngle{" +
                "yaw=" + yaw +
                ", roll=" + roll +
                ", pitch=" + pitch +
                ", status=" + status +
                '}';
    }
}
