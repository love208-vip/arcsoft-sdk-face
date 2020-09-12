//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.arcsoft.face;

/**
 * 年龄信息类
 */
public class AgeInfo {

    /**
     * 年龄信息
     */
    int age;

    /**
     * 初始化一个空的年龄信息对象
     */
    public AgeInfo() {
        this.age = 0;
    }

    /**
     * 根据传入的年龄信息对象生成一个新的年龄信息对象，生成的对象为传入的年龄信息对象的深拷贝
     *
     * @param obj 传入的年龄信息对象
     */
    public AgeInfo(AgeInfo obj) {
        if (obj == null) {
            age = 0;
        } else {
            this.age = obj.getAge();
        }
    }

    /**
     * 获取年龄信息
     *
     * @return 年龄信息，若为0表示检测失败
     */
    public int getAge() {
        return this.age;
    }

    /**
     * 获取当前年龄信息对象的深拷贝
     *
     * @return 当前年龄信息对象的深拷贝
     */
    @Override
    public AgeInfo clone() {
        return new AgeInfo(this);
    }
}
