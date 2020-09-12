//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.arcsoft.face;

/**
 * 性别信息类
 */
public class GenderInfo {

    /**
     * 性别值
     */
    int gender=-1;

    /**
     * 创建一个新的性别信息对象
     */
    public GenderInfo() {
    }

    /**
     * 根据传入的性别信息对象创建一个新的性别信息对象，新创建的性别信息对象和为传入对象的深拷贝
     *
     * @param obj 性别信息对象
     */
    public GenderInfo(GenderInfo obj) {
        if (obj == null) {
            gender = -1;
        } else {
            this.gender = obj.getGender();
        }
    }

    /**
     * 获取性别
     *
     * @return 性别，，未知性别=-1 、男性=0 、女性=1
     */
    public int getGender() {
        return this.gender;
    }

    /**
     * 返回当前对象的深拷贝
     *
     * @return 当前对象的深拷贝
     */
    @Override
    public GenderInfo clone() {
        return new GenderInfo(this);
    }
}
