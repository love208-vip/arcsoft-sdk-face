package com.arcsoft.face.enums;


public enum ErrorInfo {


    /**
     * 空
     * <p>
     * code=0
     */
    MERR_NONE(0),

    /**
     * 正常
     * <p>
     * code=0
     */
    MOK(0),

    /**
     * 通用错误类型
     * <p>
     * code=1
     */
    MERR_BASIC_BASE(0x0001),

    /**
     * 错误原因不明
     * <p>
     * code=1
     */
    MERR_UNKNOWN(0x0001),

    /**
     * 无效的参数
     * <p>
     * code=2
     */
    MERR_INVALID_PARAM(0x0001 + 1),

    /**
     * 引擎不支持
     * <p>
     * code=3
     */
    MERR_UNSUPPORTED(0x0001 + 2),

    /**
     * 内存不足
     * <p>
     * code=4
     */
    MERR_NO_MEMORY(0x0001 + 3),

    /**
     * 状态错误
     * <p>
     * code=5
     */
    MERR_BAD_STATE(0x0001 + 4),

    /**
     * 用户取消相关操作
     * <p>
     * code=6
     */
    MERR_USER_CANCEL(0x0001 + 5),

    /**
     * 操作时间过期
     * <p>
     * code=7
     */
    MERR_EXPIRED(0x0001 + 6),

    /**
     * 用户暂停操作
     * <p>
     * code=8
     */
    MERR_USER_PAUSE(0x0001 + 7),

    /**
     * 缓冲上溢
     * <p>
     * code=9
     */
    MERR_BUFFER_OVERFLOW(0x0001 + 8),

    /**
     * 缓冲下溢
     * <p>
     * code=10
     */
    MERR_BUFFER_UNDERFLOW(0x0001 + 9),

    /**
     * 存贮空间不足
     * <p>
     * code=11
     */
    MERR_NO_DISKSPACE(0x0001 + 10),

    /**
     * 组件不存在
     * <p>
     * code=12
     */
    MERR_COMPONENT_NOT_EXIST(0x0001 + 11),

    /**
     * 全局数据不存在
     * <p>
     * code=13
     */
    MERR_GLOBAL_DATA_NOT_EXIST(0x0001 + 12),

    /**
     * Free SDK通用错误类型
     * <p>
     * code=28672
     */
    MERR_FSDK_BASE(0x7000),

    /**
     * 无效的App Id
     * <p>
     * code=28673
     */
    MERR_FSDK_INVALID_APP_ID(0x7000 + 1),

    /**
     * 无效的SDK key
     * <p>
     * code=28674
     */
    MERR_FSDK_INVALID_SDK_ID(0x7000 + 2),

    /**
     * AppId和SDKKey不匹配
     * <p>
     * code=28675
     */
    MERR_FSDK_INVALID_ID_PAIR(0x7000 + 3),

    /**
     * SDKKey 和使用的SDK 不匹配
     * <p>
     * code=28676
     */
    MERR_FSDK_MISMATCH_ID_AND_SDK(0x7000 + 4),

    /**
     * 系统版本不被当前SDK所支持
     * <p>
     * code=28677
     */
    MERR_FSDK_SYSTEM_VERSION_UNSUPPORTED(0x7000 + 5),

    /**
     * SDK有效期过期，需要重新下载更新
     * <p>
     * code=28678
     */
    MERR_FSDK_LICENCE_EXPIRED(0x7000 + 6),

    /**
     * Face Recognition错误类型
     * <p>
     * code=73728
     */
    MERR_FSDK_FR_ERROR_BASE(0x12000),

    /**
     * 无效的输入内存
     * <p>
     * code=73729
     */
    MERR_FSDK_FR_INVALID_MEMORY_INFO(0x12000 + 1),

    /**
     * 无效的输入图像参数
     * <p>
     * code=73730
     */
    MERR_FSDK_FR_INVALID_IMAGE_INFO(0x12000 + 2),

    /**
     * 无效的脸部信息
     * <p>
     * code=73731
     */
    MERR_FSDK_FR_INVALID_FACE_INFO(0x12000 + 3),

    /**
     * 当前设备无GPU可用
     * <p>
     * code=73732
     */
    MERR_FSDK_FR_NO_GPU_AVAILABLE(0x12000 + 4),

    /**
     * 待比较的两个人脸特征的版本不一致
     * <p>
     * code=73733
     */
    MERR_FSDK_FR_MISMATCHED_FEATURE_LEVEL(0x12000 + 5),

    /**
     * 人脸特征检测错误类型
     * <p>
     * code=81920
     */
    MERR_FSDK_FACEFEATURE_ERROR_BASE(0x14000),

    /**
     * 人脸特征检测错误未知
     * <p>
     * code=81921
     */
    MERR_FSDK_FACEFEATURE_UNKNOWN(0x14000 + 1),

    /**
     * 人脸特征检测内存错误
     * <p>
     * code=81922
     */
    MERR_FSDK_FACEFEATURE_MEMORY(0x14000 + 2),

    /**
     * 人脸特征检测格式错误
     * <p>
     * code=81923
     */
    MERR_FSDK_FACEFEATURE_INVALID_FORMAT(0x14000 + 3),

    /**
     * 人脸特征检测参数错误
     * <p>
     * code=81924
     */
    MERR_FSDK_FACEFEATURE_INVALID_PARAM(0x14000 + 4),

    /**
     * 人脸特征检测结果置信度低
     * <p>
     * code=81925
     */
    MERR_FSDK_FACEFEATURE_LOW_CONFIDENCE_LEVEL(0x14000 + 5),

    /**
     * ASF错误类型
     * <p>
     * code=86016
     */
    MERR_ASF_EX_BASE(0x15000),

    /**
     * Engine不支持的检测属性
     * <p>
     * code=86017
     */
    MERR_ASF_EX_FEATURE_UNSUPPORTED_ON_INIT(0x15000 + 1),

    /**
     * 需要检测的属性未初始化
     * <p>
     * code=86018
     */
    MERR_ASF_EX_FEATURE_UNINITED(0x15000 + 2),

    /**
     * 待获取的属性未在process中处理过
     * <p>
     * code=86019
     */
    MERR_ASF_EX_FEATURE_UNPROCESSED(0x15000 + 3),

    /**
     * PROCESS不支持的检测属性组合，例如FR，有自己独立的处理函数
     * <p>
     * code=86020
     */
    MERR_ASF_EX_FEATURE_UNSUPPORTED_ON_PROCESS(0x15000 + 4),

    /**
     * 无效的输入图像
     * <p>
     * code=86021
     */
    MERR_ASF_EX_INVALID_IMAGE_INFO(0x15000 + 5),

    /**
     * 无效的脸部信息
     * <p>
     * code=86022
     */
    MERR_ASF_EX_INVALID_FACE_INFO(0x15000 + 6),

    /**
     * 人脸比对基础错误类型
     * <p>
     * code=90112
     */
    MERR_ASF_BASE(0x16000),

    /**
     * SDK激活失败,请打开读写权限
     * <p>
     * code=90113
     */
    MERR_ASF_ACTIVATION_FAIL(0x16000 + 1),

    /**
     * SDK已激活
     * <p>
     * code=90114
     */
    MERR_ASF_ALREADY_ACTIVATED(0x16000 + 2),

    /**
     * SDK未激活
     * <p>
     * code=90115
     */
    MERR_ASF_NOT_ACTIVATED(0x16000 + 3),

    /**
     * detectFaceScaleVal 不支持
     * <p>
     * code=90116
     */
    MERR_ASF_SCALE_NOT_SUPPORT(0x16000 + 4),

    /**
     * 激活文件与SDK类型不匹配，请确认使用的sdk
     * <p>
     * code=90117
     */
    MERR_ASF_ACTIVEFILE_SDKTYPE_MISMATCH(0x16000 + 5),

    /**
     * 设备不匹配
     * <p>
     * code=90118
     */
    MERR_ASF_DEVICE_MISMATCH(0x16000 + 6),

    /**
     * 唯一标识不合法
     * <p>
     * code=90119
     */
    MERR_ASF_UNIQUE_IDENTIFIER_ILLEGAL(0x16000 + 7),

    /**
     * 参数为空
     * <p>
     * code=90120
     */
    MERR_ASF_PARAM_NULL(0x16000 + 8),

    /**
     * 活体已过期
     * <p>
     * code=90121
     */
    MERR_ASF_LIVENESS_EXPIRED(0x16000 + 9),

    /**
     * 版本不支持
     * <p>
     * code=90122
     */
    MERR_ASF_VERSION_NOT_SUPPORT(0x16000 + 10),

    /**
     * 签名错误
     * <p>
     * code=90123
     */
    MERR_ASF_SIGN_ERROR(0x16000 + 11),

    /**
     * 激活信息保存异常
     * <p>
     * code=90124
     */
    MERR_ASF_DATABASE_ERROR(0x16000 + 12),

    /**
     * 唯一标识符校验失败
     * <p>
     * code=90125
     */
    MERR_ASF_UNIQUE_CHECKOUT_FAIL(0x16000 + 13),

    /**
     * 颜色空间不支持
     * <p>
     * code=90126
     */
    MERR_ASF_COLOR_SPACE_NOT_SUPPORT(0x16000 + 14),

    /**
     * 图片宽高不支持，宽度需四字节对齐
     * <p>
     * code=90127
     */
    MERR_ASF_IMAGE_WIDTH_HEIGHT_NOT_SUPPORT(0x16000 + 15),

    /**
     * 人脸比对基础错误类型
     * <p>
     * code=90128
     */
    MERR_ASF_BASE_EXTEND(0x16010),

    /**
     * 权限被拒绝
     * <p>
     * code=90128
     */
    MERR_ASF_READ_PHONE_STATE_DENIED(0x16010),

    /**
     * 激活数据被破坏,请删除激活文件，重新进行激活
     * <p>
     * code=90129
     */
    MERR_ASF_ACTIVATION_DATA_DESTROYED(0x16010 + 1),

    /**
     * 服务端未知错误
     * <p>
     * code=90130
     */
    MERR_ASF_SERVER_UNKNOWN_ERROR(0x16010 + 2),

    /**
     * INTERNET权限被拒绝
     * <p>
     * code=90131
     */
    MERR_ASF_INTERNET_DENIED(0x16010 + 3),

    /**
     * 激活文件与SDK版本不匹配,请重新激活
     * <p>
     * code=90132
     */
    MERR_ASF_ACTIVEFILE_SDK_MISMATCH(0x16010 + 4),

    /**
     * 设备信息太少，不足以生成设备指纹
     * <p>
     * code=90133
     */
    MERR_ASF_DEVICEINFO_LESS(0x16010 + 5),

    /**
     * 客户端时间与服务器时间（即北京时间）前后相差在30分钟以上
     * <p>
     * code=90134
     */
    MERR_ASF_LOCAL_TIME_NOT_CALIBRATED(0x16010 + 6),

    /**
     * 数据校验异常
     * <p>
     * code=90135
     */
    MERR_ASF_APPID_DATA_DECRYPT(0x16010 + 7),

    /**
     * 传入的AppId和AppKey与使用的SDK版本不一致
     * <p>
     * code=90136
     */
    MERR_ASF_APPID_APPKEY_SDK_MISMATCH(0x16010 + 8),

    /**
     * 短时间大量请求会被禁止请求,30分钟之后解封
     * <p>
     * code=90137
     */
    MERR_ASF_NO_REQUEST(0x16010 + 9),

    /**
     * 激活文件不存在
     * <p>
     * code=90138
     */
    MERR_ASF_ACTIVE_FILE_NOT_EXIST(0x16010 + 10),

    /**
     * 检测模型不支持，请查看对应接口说明，使用当前支持的检测模型
     * <p>
     * code=90139
     */
    MERR_ASF_DETECT_MODEL_UNSUPPORTED(0x16010 + 11),

    /**
     * 当前设备时间不正确，请调整设备时间
     * <p>
     * code=90140
     */
    MERR_ASF_CURRENT_DEVICE_TIME_INCORRECT(0x16010 + 12),

    /**
     * 年度激活数量超出限制，次年清零
     * <p>
     * code=90141
     */
    MERR_ASF_ACTIVATION_QUANTITY_OUT_OF_LIMIT(0x16010 + 13),


    /**
     * 网络错误类型
     * <p>
     * code=94208
     */
    MERR_ASF_NETWORK_BASE(0x17000),

    /**
     * 无法解析主机地址
     * <p>
     * code=94209
     */
    MERR_ASF_NETWORK_COULDNT_RESOLVE_HOST(0x17000 + 1),

    /**
     * 无法连接服务器
     * <p>
     * code=94210
     */
    MERR_ASF_NETWORK_COULDNT_CONNECT_SERVER(0x17000 + 2),

    /**
     * 网络连接超时
     * <p>
     * code=94211
     */
    MERR_ASF_NETWORK_CONNECT_TIMEOUT(0x17000 + 3),

    /**
     * 网络未知错误
     * <p>
     * code=94212
     */
    MERR_ASF_NETWORK_UNKNOWN_ERROR(0x17000 + 4),

    /**
     * 激活码错误类型
     * <p>
     * code=98304
     */
    MERR_ASF_ACTIVEKEY_BASE(0x18000),

    /**
     * 无法连接激活服务器
     * <p>
     * code=98305
     */
    MERR_ASF_ACTIVEKEY_COULDNT_CONNECT_SERVER(0x18000 + 1),

    /**
     * 服务器系统错误
     * <p>
     * code=98306
     */
    MERR_ASF_ACTIVEKEY_SERVER_SYSTEM_ERROR(0x18000 + 2),

    /**
     * 请求参数错误
     * <p>
     * code=98307
     */
    MERR_ASF_ACTIVEKEY_POST_PARM_ERROR(0x18000 + 3),

    /**
     * ACTIVEKEY与APPID、SDKKEY不匹配
     * <p>
     * code=98308
     */
    MERR_ASF_ACTIVEKEY_PARM_MISMATCH(0x18000 + 4),

    /**
     * ACTIVEKEY已经被使用
     * <p>
     * code=98309
     */
    MERR_ASF_ACTIVEKEY_ACTIVEKEY_ACTIVATED(0x18000 + 5),

    /**
     * ACTIVEKEY信息异常
     * <p>
     * code=98310
     */
    MERR_ASF_ACTIVEKEY_ACTIVEKEY_FORMAT_ERROR(0x18000 + 6),

    /**
     * ACTIVEKEY与APPID不匹配
     * <p>
     * code=98311
     */
    MERR_ASF_ACTIVEKEY_APPID_PARM_MISMATCH(0x18000 + 7),

    /**
     * SDK与激活文件版本不匹配
     * <p>
     * code=98312
     */
    MERR_ASF_ACTIVEKEY_SDK_FILE_MISMATCH(0x18000 + 8),

    /**
     * ACTIVEKEY已过期
     * <p>
     * code=98313
     */
    MERR_ASF_ACTIVEKEY_EXPIRED(0x18000 + 9),

    /**
     * 批量授权激活码设备数超过限制
     * <p>
     * code=98314
     */
    MERR_ASF_ACTIVEKEY_DEVICE_OUT_OF_LIMIT(0x18000 + 10),

    /**
     * 离线激活错误码类型
     * <p>
     * code=102400
     */
    MERR_ASF_OFFLINE_BASE(0x19000),

    /**
     * 离线授权文件不存在或无读写权限
     * <p>
     * code=102401
     */
    MERR_ASF_LICENSE_FILE_NOT_EXIST(0x19000 + 1),

    /**
     * 离线授权文件已损坏
     * <p>
     * code=102402
     */
    MERR_ASF_LICENSE_FILE_DATA_DESTROYED(0x19000 + 2),

    /**
     * 离线授权文件与SDK版本不匹配
     * <p>
     * code=102403
     */
    MERR_ASF_LICENSE_FILE_SDK_MISMATCH(0x19000 + 3),

    /**
     * 离线授权文件与SDK信息不匹配
     * <p>
     * code=102404
     */
    MERR_ASF_LICENSE_FILEINFO_SDKINFO_MISMATCH(0x19000 + 4),

    /**
     * 离线授权文件与设备指纹不匹配
     * <p>
     * code=102405
     */
    MERR_ASF_LICENSE_FILE_FINGERPRINT_MISMATCH(0x19000 + 5),

    /**
     * 离线授权文件已过期
     * <p>
     * code=102406
     */
    MERR_ASF_LICENSE_FILE_EXPIRED(0x19000 + 6),

    /**
     * 离线授权文件不可用，本地原有激活文件可继续使用
     * <p>
     * code=102407
     */
    MERR_ASF_LOCAL_EXIST_USEFUL_ACTIVE_FILE(0x19000 + 7),


    /**
     * 离线授权文件版本过低，请使用新版本激活助手重新进行离线激活
     * <p>
     * code=102408
     */
    MERR_ASF_LICENSE_FILE_VERSION_TOO_LOW(0x19000 + 8)






    ;



    private int value;

    ErrorInfo(int value) {
        this.value = value;
    }

    public static ErrorInfo getValidEnum(int value) {
        for (ErrorInfo errorInfo : ErrorInfo.values()) {
            if (errorInfo.getValue() == value) {
                return errorInfo;
            }
        }
        return ErrorInfo.MERR_UNKNOWN;
    }

    public int getValue() {
        return value;
    }
}
