package com.arcsoft.face;

import com.arcsoft.face.enums.*;
import com.arcsoft.face.toolkit.ImageInfo;
import com.arcsoft.face.toolkit.ImageInfoEx;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author st7251
 */
public class FaceEngine {


    private native int initFaceEngine(long detectMode, int detectFaceOrientPriority, int detectFaceScaleVal, int detectFaceMaxNum, int combinedMask);

    private native int activeOnlineFaceEngine(String appId, String sdkKey, String activeKey);

    private native int activeOfflineFaceEngine(String filePath);

    private native int getActiveFile(ActiveFileInfo activeFileInfo);

    private native int unInitFaceEngine(long handle);

    private native void getVersion(VersionInfo versionInfo);

    private native int detectFaces(long handle, byte[] imageData, int width, int height, int format, int detectModel, FaceInfo[] faceInfoArray);

    private native int detectFacesEx(long handle, byte[][] imageDataPlanes, int[] imageStrides, int width, int height, int format, int detectModel, FaceInfo[] faceInfoArray);

    private native int setLivenessParam(long handle, float rgbThreshold, float irThreshold);

    private native int process(long handle, byte[] imageData, int width, int height, int format, FaceInfo[] faceInfoArray, int combineMask);

    private native int processEx(long handle, byte[][] imageDataPlanes, int[] imageStrides, int width, int height, int format, FaceInfo[] faceInfoArray, int combineMask);

    private native int processIr(long handle, byte[] imageData, int width, int height, int format, FaceInfo[] faceInfoArray, int combineMask);

    private native int processIrEx(long handle, byte[][] imageDataPlanes, int[] imageStrides, int width, int height, int format, FaceInfo[] faceInfoArray, int combineMask);

    private native int extractFaceFeature(long handle, byte[] imageData, int width, int height, int format, Rect faceRect, int degree, byte[] featureData,int threadNum);

    private native int extractFaceFeatureEx(long handle, byte[][] imageDataPlanes, int[] imageStrides, int width, int height, int format, Rect faceRect, int degree, byte[] featureData,int threadNum);

    private native int pairMatching(long handle, byte[] feature1, byte[] feature2, int compareModel, FaceSimilar faceSimilar);

    private native int getAge(long handle, AgeInfo[] ageInfoArray);

    private native int getGender(long handle, GenderInfo[] genderInfoArray);

    private native int getFace3DAngle(long handle, Face3DAngle[] face3DAngles);

    private native int getLiveness(long handle, LivenessInfo[] livenessInfos);

    private native int getLivenessIr(long handle, IrLivenessInfo[] livenessInfos);

    private native int getActiveDeviceInfoNative(ActiveDeviceInfo activeDeviceInfo);

    private native int imageQualityDetectNative(long handle, byte[] imageData, int width, int height, int format, int detectModel, FaceInfo[] faceInfoArray, ImageQuality[] imageQualityArray);

    private native int imageQualityDetectExNative(long handle, byte[][] imageDataPlanes, int[] imageStrides, int width, int height, int format,int detectModel, FaceInfo[] faceInfoArray, ImageQuality[] imageQualityArray);


    /**
     * 初始化和调用引擎的属性，人脸检测
     */
    private final int ASF_FACE_DETECT = 0x00000001;
    /**
     * 初始化和调用引擎的属性，人脸识别
     */
    private final int ASF_FACE_RECOGNITION = 0x00000004;
    /**
     * 初始化和调用引擎的属性，年龄检测
     */
    private final int ASF_AGE = 0x00000008;
    /**
     * 初始化和调用引擎的属性，性别检测
     */
    private final int ASF_GENDER = 0x00000010;
    /**
     * 初始化和调用引擎的属性，人脸三维角度检测
     */
    private final int ASF_FACE3DANGLE = 0x00000020;
    /**
     * 初始化和调用引擎的属性，RGB活体检测
     */
    private final int ASF_LIVENESS = 0x00000080;

    /**
     * 初始化和调用引擎的属性，IR活体检测
     */
    private final int ASF_IR_LIVENESS = 0x00000400;

    /**
     * 初始化和调用引擎的属性，图像质量检测
     */
    private final int ASF_IMAGEQUALITY = 0x00000200;

    private long handle = 0L;

    private int detectFaceMaxNum;

    private static List<String> libCache = new LinkedList<String>();

    private static final String WIN_FACE_ENGINE_JNI_LIBRARY = "libarcsoft_face_engine_jni";
    private static final String LINUX_FACE_ENGINE_JNI_LIBRARY = "arcsoft_face_engine_jni";


    private static synchronized void libraryLoad(String libPath) {
        if (libPath == null || libPath.length() == 0) {
            if (!libCache.contains(WIN_FACE_ENGINE_JNI_LIBRARY)) {
                String os = System.getProperty("os.name");
                if (os.toLowerCase().startsWith("win")) {
                    System.loadLibrary(WIN_FACE_ENGINE_JNI_LIBRARY);
                } else {
                    System.loadLibrary(LINUX_FACE_ENGINE_JNI_LIBRARY);
                }
                libCache.add(WIN_FACE_ENGINE_JNI_LIBRARY);
            }
        } else {
            if (libPath.endsWith("/") || libPath.endsWith("\\")) {
                libPath = libPath.substring(0, libPath.length() - 1);
            }
            libPath += File.separator;
            if (!libCache.contains(libPath)) {
                String os = System.getProperty("os.name");
                if (os.toLowerCase().startsWith("win")) {
                    System.load(libPath + "libarcsoft_face.dll");
                    System.load(libPath + "libarcsoft_face_engine.dll");
                    System.load(libPath + "libarcsoft_face_engine_jni.dll");
                } else {
                    System.load(libPath + "libarcsoft_face.so");
                    System.load(libPath + "libarcsoft_face_engine.so");
                    System.load(libPath + "libarcsoft_face_engine_jni.so");
                }
                libCache.add(libPath);
            }

        }
    }

    /**
     * 创建引擎
     */
    public FaceEngine() {
        libraryLoad(null);
    }

    /**
     * 创建引擎
     *
     * @param libPath 引擎库路径
     */
    public FaceEngine(String libPath) {
        libraryLoad(libPath);
    }

//    @Override
//    protected void finalize() throws Throwable {
//        unInit();
//        super.finalize();
//    }

    /**
     * 激活SDK,与activeOnline功能一致，建议用activeOnline
     *
     * @param appId     官网申请的APP_ID
     * @param sdkKey    官网申请的SDK_KEY
     * @param activeKey 官网申请的ACTIVE_KEY
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int activeOnline(String appId, String sdkKey, String activeKey) {
        if (appId == null) {
            appId = "";
        }
        if (sdkKey == null) {
            sdkKey = "";
        }
        if (activeKey == null) {
            activeKey = "";
        }
        int resultCode = activeOnlineFaceEngine(appId, sdkKey, activeKey);
        return resultCode;
    }


    /**
     * 离线激活SDK
     *
     * @param filePath 激活文件路径
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int activeOffline(String filePath) {
        if (filePath == null) {
            filePath = "";
        }
        int resultCode = activeOfflineFaceEngine(filePath);
        return resultCode;
    }

    /**
     * 获取激活文件信息
     *
     * @param activeFileInfo 激活文件信息对象，用于输出激活文件信息数据
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int getActiveFileInfo(ActiveFileInfo activeFileInfo) {
        int errorCode = getActiveFile(activeFileInfo);
        return errorCode;
    }

    /**
     * 初始化人脸引擎
     *
     * @param engineConfiguration 引擎配置类
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int init(EngineConfiguration engineConfiguration) {
        if (engineConfiguration == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        long detectMode = engineConfiguration.getDetectMode().getValue();
        int detectFaceOrientPriority = engineConfiguration.getDetectFaceOrientPriority().getValue();
        int detectFaceScaleVal = engineConfiguration.getDetectFaceScaleVal();
        int detectFaceMaxNum = engineConfiguration.getDetectFaceMaxNum();
        this.detectFaceMaxNum = detectFaceMaxNum;
        int combinedMask = 0;
        if (engineConfiguration.getFunctionConfiguration().isSupportFaceDetect()) {
            combinedMask |= ASF_FACE_DETECT;
        }
        if (engineConfiguration.getFunctionConfiguration().isSupportFaceRecognition()) {
            combinedMask |= ASF_FACE_RECOGNITION;
        }
        if (engineConfiguration.getFunctionConfiguration().isSupportAge()) {
            combinedMask |= ASF_AGE;
        }
        if (engineConfiguration.getFunctionConfiguration().isSupportGender()) {
            combinedMask |= ASF_GENDER;
        }
        if (engineConfiguration.getFunctionConfiguration().isSupportFace3dAngle()) {
            combinedMask |= ASF_FACE3DANGLE;
        }
        if (engineConfiguration.getFunctionConfiguration().isSupportLiveness()) {
            combinedMask |= ASF_LIVENESS;
        }
        if (engineConfiguration.getFunctionConfiguration().isSupportIRLiveness()) {
            combinedMask |= ASF_IR_LIVENESS;
        }

        if (engineConfiguration.getFunctionConfiguration().isSupportImageQuality()) {
            combinedMask |= ASF_IMAGEQUALITY;
        }

        int errorCode = initFaceEngine(detectMode, detectFaceOrientPriority, detectFaceScaleVal, detectFaceMaxNum, combinedMask);
        return errorCode;
    }

    /**
     * 销毁引擎
     *
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int  unInit() {
        if (handle != 0L) {
            int errorCode = unInitFaceEngine(handle);
            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }
    }


    /**
     * 创建活体阈值参数对象
     *
     * @param rgbThreshold RGB活体阈值
     * @param irThreshold  IR活体阈值
     * @return 错误码，详细见({@link ErrorInfo})
     */

    public int setLivenessParam(float rgbThreshold, float irThreshold) {
        if (handle != 0L) {
            int errorCode = setLivenessParam(handle, rgbThreshold, irThreshold);
            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }
    }


    /**
     * 人脸检测
     *
     * @param data         输入的图像数据
     * @param width        图片宽度，为4的倍数
     * @param height       图片高度，YUYV/I420/NV21/NV12格式为2的倍数；BGR24/GRAY/DEPTH_U16格式无限制
     * @param imageFormat  图像的颜色空间格式
     * @param faceInfoList 人脸列表，传入后赋值
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int detectFaces(byte[] data, int width, int height, ImageFormat imageFormat, List<FaceInfo> faceInfoList) {
        return detectFaces(data, width, height, imageFormat, DetectModel.ASF_DETECT_MODEL_RGB, faceInfoList);
    }

    private int detectFaces(ImageInfo imageInfo, DetectModel detectModel, List<FaceInfo> faceInfoList) {
        if (imageInfo == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }
        return detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), detectModel, faceInfoList);
    }

    /**
     * 人脸检测
     *
     * @param data         输入的图像数据
     * @param width        图片宽度，为4的倍数
     * @param height       图片高度，YUYV/I420/NV21/NV12格式为2的倍数；BGR24/GRAY/DEPTH_U16格式无限制
     * @param imageFormat  图像的颜色空间格式
     * @param detectModel  人脸检查模型
     * @param faceInfoList 人脸列表，传入后赋值
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int detectFaces(byte[] data, int width, int height, ImageFormat imageFormat, DetectModel detectModel, List<FaceInfo> faceInfoList) {
        if (data == null || imageFormat == null || detectModel == null || faceInfoList == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        if (width < 1 || height < 1) {
            return ErrorInfo.MERR_ASF_IMAGE_WIDTH_HEIGHT_NOT_SUPPORT.getValue();
        }

        if (!checkImageData(data, width, height, imageFormat)) {
            return ErrorInfo.MERR_ASF_EX_INVALID_IMAGE_INFO.getValue();
        }


        faceInfoList.clear();
        if (handle != 0L) {
            FaceInfo[] faceInfoArray = new FaceInfo[detectFaceMaxNum];
            int code = detectFaces(handle, data, width, height, imageFormat.getValue(), detectModel.getValue(), faceInfoArray);
            for (FaceInfo faceInfo : faceInfoArray) {
                if (faceInfo == null) break;
                faceInfoList.add(faceInfo);
            }
            return code;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }
    }

    /**
     * 图像信息
     *
     * @param imageInfoEx  图像信息
     * @param faceInfoList 人脸输出列表
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int detectFaces(ImageInfoEx imageInfoEx, List<FaceInfo> faceInfoList) {
        if (imageInfoEx == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        return detectFaces(imageInfoEx.getImageDataPlanes(),
                imageInfoEx.getImageStrides(), imageInfoEx.getWidth(),
                imageInfoEx.getHeight(), imageInfoEx.getImageFormat(), DetectModel.ASF_DETECT_MODEL_RGB, faceInfoList);

    }

    /**
     * 图像信息
     *
     * @param imageInfoEx  图像信息
     * @param detectModel  人脸检测模型
     * @param faceInfoList 人脸输出列表
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int detectFaces(ImageInfoEx imageInfoEx, DetectModel detectModel, List<FaceInfo> faceInfoList) {
        if (imageInfoEx == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        return detectFaces(imageInfoEx.getImageDataPlanes(),
                imageInfoEx.getImageStrides(), imageInfoEx.getWidth(),
                imageInfoEx.getHeight(), imageInfoEx.getImageFormat(), detectModel, faceInfoList);

    }

    /**
     * @param imageDataPlanes 人脸图像通道
     * @param imageStrides    步长
     * @param width           图片宽度，为4的倍数
     * @param height          图片高度，YUYV/I420/NV21/NV12格式为2的倍数；BGR24/GRAY/DEPTH_U16格式无限制
     * @param imageFormat     图像的颜色空间格式
     * @param detectModel     人脸检查模型
     * @param faceInfoList    人脸列表，传入后赋值
     * @return 错误码，详细见({@link ErrorInfo})
     */
    private int detectFaces(byte[][] imageDataPlanes, int[] imageStrides, int width, int height, ImageFormat imageFormat, DetectModel detectModel, List<FaceInfo> faceInfoList) {
        if (imageDataPlanes == null || imageFormat == null || detectModel == null || faceInfoList == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        if (width < 1 || height < 1) {
            return ErrorInfo.MERR_ASF_IMAGE_WIDTH_HEIGHT_NOT_SUPPORT.getValue();
        }

        if (!checkImageData(imageDataPlanes, imageStrides, width, height, imageFormat)) {
            return ErrorInfo.MERR_ASF_EX_INVALID_IMAGE_INFO.getValue();
        }


        faceInfoList.clear();

        if (handle != 0L) {
            FaceInfo[] faceInfoArray = new FaceInfo[detectFaceMaxNum];

            int errorCode = detectFacesEx(handle, imageDataPlanes, imageStrides, width, height, imageFormat.getValue(), detectModel.getValue(), faceInfoArray);

            for (FaceInfo faceInfo : faceInfoArray) {
                if (faceInfo == null) break;
                faceInfoList.add(faceInfo);
            }
            return errorCode;

        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }
    }

    /**
     * RGB活体、年龄、性别、三维角度检测，在调用该函数后，可以调用getLiveness(List) ，getAge(List)，getGender(List)，getFace3DAngle(List)分别获取 RGB活体、年龄、性别、三维角度的检测结果； RGB活体最多支持 1 个人脸信息的检测，超过部分返回未知； 年龄、性别、三维角度最多支持4个人脸信息的检测，超过部分返回未知
     *
     * @param data                  输入的图像数据
     * @param width                 图片宽度，为4的倍数
     * @param height                图片高度，YUYV/I420/NV21/NV12格式为2的倍数，BGR24格式无限制
     * @param imageFormat           图像的颜色空间格式
     * @param faceInfoList          人脸列表
     * @param functionConfiguration 功能配置组合
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int process(byte[] data, int width, int height, ImageFormat imageFormat, List<FaceInfo> faceInfoList, FunctionConfiguration functionConfiguration) {
        if (faceInfoList == null
                || data == null
                || imageFormat == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        if (width < 1 || height < 1) {
            return ErrorInfo.MERR_ASF_IMAGE_WIDTH_HEIGHT_NOT_SUPPORT.getValue();
        }

        if (!checkImageData(data, width, height, imageFormat)) {
            return ErrorInfo.MERR_ASF_EX_INVALID_IMAGE_INFO.getValue();
        }


        int _combinedMask = 0;
        if (functionConfiguration.isSupportFaceDetect()) {
            _combinedMask |= ASF_FACE_DETECT;
        }
        if (functionConfiguration.isSupportFaceRecognition()) {
            _combinedMask |= ASF_FACE_RECOGNITION;
        }
        if (functionConfiguration.isSupportAge()) {
            _combinedMask |= ASF_AGE;
        }
        if (functionConfiguration.isSupportGender()) {
            _combinedMask |= ASF_GENDER;
        }
        if (functionConfiguration.isSupportFace3dAngle()) {
            _combinedMask |= ASF_FACE3DANGLE;
        }
        if (functionConfiguration.isSupportLiveness()) {
            _combinedMask |= ASF_LIVENESS;
        }
        if (functionConfiguration.isSupportIRLiveness()) {
            _combinedMask |= ASF_IR_LIVENESS;
        }
        if (functionConfiguration.isSupportImageQuality()) {
            _combinedMask |= ASF_IMAGEQUALITY;
        }


        if (handle != 0L) {
            int errorCode = process(handle, data, width, height, imageFormat.getValue(), faceInfoList.toArray(new FaceInfo[0]), _combinedMask);
            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }
    }

    /**
     * @param imageInfoEx           图像信息
     * @param faceInfoList          人脸列表
     * @param functionConfiguration 功能配置组合
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int process(ImageInfoEx imageInfoEx, List<FaceInfo> faceInfoList, FunctionConfiguration functionConfiguration) {
        if (imageInfoEx == null
                || faceInfoList == null
                || functionConfiguration == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        return process(imageInfoEx.getImageDataPlanes(), imageInfoEx.getImageStrides(),
                imageInfoEx.getWidth(), imageInfoEx.getHeight(), imageInfoEx.getImageFormat(), faceInfoList, functionConfiguration);
    }

    /**
     * @param imageDataPlanes 人脸图像通道
     * @param imageStrides    步长
     * @param width           图片宽度，为4的倍数
     * @param height          图片高度，YUYV/I420/NV21/NV12格式为2的倍数；BGR24/GRAY/DEPTH_U16格式无限制
     * @param imageFormat     图像的颜色空间格式
     * @param faceInfoList    人脸列表，传入后赋值
     * @return 错误码，详细见({@link ErrorInfo})
     */
    private int process(byte[][] imageDataPlanes, int[] imageStrides, int width, int height, ImageFormat imageFormat, List<FaceInfo> faceInfoList, FunctionConfiguration functionConfiguration) {
        if (faceInfoList == null
                || imageDataPlanes == null
                || imageStrides == null
                || imageFormat == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }
        if (width < 1 || height < 1) {
            return ErrorInfo.MERR_ASF_IMAGE_WIDTH_HEIGHT_NOT_SUPPORT.getValue();
        }

        if (!checkImageData(imageDataPlanes, imageStrides, width, height, imageFormat)) {
            return ErrorInfo.MERR_ASF_EX_INVALID_IMAGE_INFO.getValue();
        }


        int _combinedMask = 0;
        if (functionConfiguration.isSupportFaceDetect()) {
            _combinedMask |= ASF_FACE_DETECT;
        }
        if (functionConfiguration.isSupportFaceRecognition()) {
            _combinedMask |= ASF_FACE_RECOGNITION;
        }
        if (functionConfiguration.isSupportAge()) {
            _combinedMask |= ASF_AGE;
        }
        if (functionConfiguration.isSupportGender()) {
            _combinedMask |= ASF_GENDER;
        }
        if (functionConfiguration.isSupportFace3dAngle()) {
            _combinedMask |= ASF_FACE3DANGLE;
        }
        if (functionConfiguration.isSupportLiveness()) {
            _combinedMask |= ASF_LIVENESS;
        }
        if (functionConfiguration.isSupportIRLiveness()) {
            _combinedMask |= ASF_IR_LIVENESS;
        }
        if (functionConfiguration.isSupportImageQuality()) {
            _combinedMask |= ASF_IMAGEQUALITY;
        }

        if (handle != 0L) {
            int errorCode = processEx(handle, imageDataPlanes, imageStrides, width, height, imageFormat.getValue(), faceInfoList.toArray(new FaceInfo[0]), _combinedMask);
            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }
    }

    /**
     * RGB活体、年龄、性别、三维角度检测，在调用该函数后，可以调用getLiveness(List) ，getAge(List)，getGender(List)，getFace3DAngle(List)分别获取 RGB活体、年龄、性别、三维角度的检测结果； RGB活体最多支持 1 个人脸信息的检测，超过部分返回未知； 年龄、性别、三维角度最多支持4个人脸信息的检测，超过部分返回未知
     *
     * @param data                  输入的图像数据
     * @param width                 图片宽度，为4的倍数
     * @param height                图片高度，YUYV/I420/NV21/NV12格式为2的倍数，BGR24格式无限制
     * @param imageFormat           图像的颜色空间格式
     * @param faceInfoList          人脸列表
     * @param functionConfiguration 功能配置组合
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int processIr(byte[] data, int width, int height, ImageFormat imageFormat, List<FaceInfo> faceInfoList, FunctionConfiguration functionConfiguration) {
        if (faceInfoList == null
                || data == null
                || imageFormat == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        if (width < 1 || height < 1) {
            return ErrorInfo.MERR_ASF_IMAGE_WIDTH_HEIGHT_NOT_SUPPORT.getValue();
        }

        if (!checkImageData(data, width, height, imageFormat)) {
            return ErrorInfo.MERR_ASF_EX_INVALID_IMAGE_INFO.getValue();
        }


        int _combinedMask = 0;

        if (functionConfiguration.isSupportFaceDetect()) {
            _combinedMask |= ASF_FACE_DETECT;
        }
        if (functionConfiguration.isSupportFaceRecognition()) {
            _combinedMask |= ASF_FACE_RECOGNITION;
        }
        if (functionConfiguration.isSupportAge()) {
            _combinedMask |= ASF_AGE;
        }
        if (functionConfiguration.isSupportGender()) {
            _combinedMask |= ASF_GENDER;
        }
        if (functionConfiguration.isSupportFace3dAngle()) {
            _combinedMask |= ASF_FACE3DANGLE;
        }
        if (functionConfiguration.isSupportLiveness()) {
            _combinedMask |= ASF_LIVENESS;
        }
        if (functionConfiguration.isSupportIRLiveness()) {
            _combinedMask |= ASF_IR_LIVENESS;
        }
        if (functionConfiguration.isSupportImageQuality()) {
            _combinedMask |= ASF_IMAGEQUALITY;
        }

        if (handle != 0L) {
            int errorCode = processIr(handle, data, width, height, imageFormat.getValue(), faceInfoList.toArray(new FaceInfo[0]), _combinedMask);
            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }
    }

    /**
     * @param imageInfoEx           图像信息
     * @param faceInfoList          人脸列表
     * @param functionConfiguration 功能配置组合
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int processIr(ImageInfoEx imageInfoEx, List<FaceInfo> faceInfoList, FunctionConfiguration functionConfiguration) {
        if (imageInfoEx == null
                || faceInfoList == null
                || functionConfiguration == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        return processIr(imageInfoEx.getImageDataPlanes(), imageInfoEx.getImageStrides(),
                imageInfoEx.getWidth(), imageInfoEx.getHeight(), imageInfoEx.getImageFormat(), faceInfoList, functionConfiguration);
    }

    /**
     * @param imageDataPlanes       人脸图像通道
     * @param imageStrides          步长
     * @param width                 图片宽度，为4的倍数
     * @param height                图片高度，YUYV/I420/NV21/NV12格式为2的倍数；BGR24/GRAY/DEPTH_U16格式无限制
     * @param imageFormat           图像的颜色空间格式
     * @param faceInfoList          人脸列表，传入后赋值
     * @param functionConfiguration 功能类型
     * @return 错误码，详细见({@link ErrorInfo})
     */
    private int processIr(byte[][] imageDataPlanes, int[] imageStrides, int width, int height, ImageFormat imageFormat, List<FaceInfo> faceInfoList, FunctionConfiguration functionConfiguration) {
        if (faceInfoList == null
                || imageDataPlanes == null
                || imageStrides == null
                || imageFormat == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        if (width < 1 || height < 1) {
            return ErrorInfo.MERR_ASF_IMAGE_WIDTH_HEIGHT_NOT_SUPPORT.getValue();
        }

        if (!checkImageData(imageDataPlanes, imageStrides, width, height, imageFormat)) {
            return ErrorInfo.MERR_ASF_EX_INVALID_IMAGE_INFO.getValue();
        }


        int _combinedMask = 0;

        if (functionConfiguration.isSupportFaceDetect()) {
            _combinedMask |= ASF_FACE_DETECT;
        }
        if (functionConfiguration.isSupportFaceRecognition()) {
            _combinedMask |= ASF_FACE_RECOGNITION;
        }
        if (functionConfiguration.isSupportAge()) {
            _combinedMask |= ASF_AGE;
        }
        if (functionConfiguration.isSupportGender()) {
            _combinedMask |= ASF_GENDER;
        }
        if (functionConfiguration.isSupportFace3dAngle()) {
            _combinedMask |= ASF_FACE3DANGLE;
        }
        if (functionConfiguration.isSupportLiveness()) {
            _combinedMask |= ASF_LIVENESS;
        }
        if (functionConfiguration.isSupportIRLiveness()) {
            _combinedMask |= ASF_IR_LIVENESS;
        }
        if (functionConfiguration.isSupportImageQuality()) {
            _combinedMask |= ASF_IMAGEQUALITY;
        }

        if (handle != 0L) {
            int errorCode = processIrEx(handle, imageDataPlanes, imageStrides, width, height, imageFormat.getValue(), faceInfoList.toArray(new FaceInfo[0]), _combinedMask);
            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }
    }

    /**
     * 提取人脸特征数据
     *
     * @param data        图像数据
     * @param width       图片宽度，为4的倍数
     * @param height      图片高度，YUYV/I420/NV21/NV12格式为2的倍数；BGR24/GRAY格式无限制
     * @param imageFormat 图像的颜色空间格式
     * @param faceInfo    人脸信息
     * @param feature     人脸特征对象，用于输出人脸特征数据
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int extractFaceFeature(byte[] data, int width, int height, ImageFormat imageFormat, FaceInfo faceInfo, FaceFeature feature) {
        return extractFaceFeature(data,width,height,imageFormat,faceInfo,feature,1);
    }

    /**
     * 提取人脸特征数据
     *
     * @param data        图像数据
     * @param width       图片宽度，为4的倍数
     * @param height      图片高度，YUYV/I420/NV21/NV12格式为2的倍数；BGR24/GRAY格式无限制
     * @param imageFormat 图像的颜色空间格式
     * @param faceInfo    人脸信息
     * @param feature     人脸特征对象，用于输出人脸特征数据
     * @param threadNum    线程数
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int extractFaceFeature(byte[] data, int width, int height, ImageFormat imageFormat, FaceInfo faceInfo, FaceFeature feature,int threadNum) {

        if (feature == null || imageFormat == null
                || feature.getFeatureData() == null
                || feature.getFeatureData().length < FaceFeature.FEATURE_SIZE
                || faceInfo == null
                || data == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        if (width < 1 || height < 1) {
            return ErrorInfo.MERR_ASF_IMAGE_WIDTH_HEIGHT_NOT_SUPPORT.getValue();
        }

        if (!checkImageData(data, width, height, imageFormat)) {
            return ErrorInfo.MERR_ASF_EX_INVALID_IMAGE_INFO.getValue();
        }


        if (handle != 0L) {
            int errorCode = this.extractFaceFeature(handle, data, width, height, imageFormat.getValue(), faceInfo.getRect(), faceInfo.getOrient(), feature.featureData,threadNum);
            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }

    }

    /**
     * @param imageInfoEx 图像信息
     * @param faceInfo    人脸信息
     * @param feature     人脸特征对象，用于输出人脸特征数据
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int extractFaceFeature(ImageInfoEx imageInfoEx, FaceInfo faceInfo, FaceFeature feature) {
        if (imageInfoEx == null || faceInfo == null || feature == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        return extractFaceFeature(imageInfoEx.getImageDataPlanes(), imageInfoEx.getImageStrides(), imageInfoEx.getWidth(),
                imageInfoEx.getHeight(), imageInfoEx.getImageFormat(), faceInfo, feature,1);

    }

    /**
     * @param imageInfoEx 图像信息
     * @param faceInfo    人脸信息
     * @param feature     人脸特征对象，用于输出人脸特征数据
     * @param threadNum    线程数
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int extractFaceFeature(ImageInfoEx imageInfoEx, FaceInfo faceInfo, FaceFeature feature,int threadNum) {
        if (imageInfoEx == null || faceInfo == null || feature == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        return extractFaceFeature(imageInfoEx.getImageDataPlanes(), imageInfoEx.getImageStrides(), imageInfoEx.getWidth(),
                imageInfoEx.getHeight(), imageInfoEx.getImageFormat(), faceInfo, feature,threadNum);

    }

    /**
     * @param imageDataPlanes 图像通道
     * @param imageStrides    图像步长
     * @param width           宽度
     * @param height          高度
     * @param imageFormat     格式
     * @param faceInfo        人脸信息
     * @param feature         人脸特征对象，用于输出人脸特征数据
     * @param threadNum    线程数
     * @return 错误码，详细见({@link ErrorInfo})
     */
    private int extractFaceFeature(byte[][] imageDataPlanes, int[] imageStrides, int width, int height, ImageFormat imageFormat, FaceInfo faceInfo, FaceFeature feature,int threadNum) {

        if (feature == null || imageFormat == null
                || feature.getFeatureData() == null
                || faceInfo == null
                || imageDataPlanes == null
                || imageStrides == null
        ) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        if (width < 1 || height < 1) {
            return ErrorInfo.MERR_ASF_IMAGE_WIDTH_HEIGHT_NOT_SUPPORT.getValue();
        }

        if (!checkImageData(imageDataPlanes, imageStrides, width, height, imageFormat)) {
            return ErrorInfo.MERR_ASF_EX_INVALID_IMAGE_INFO.getValue();
        }


        if (handle != 0L) {
            int errorCode = this.extractFaceFeatureEx(handle, imageDataPlanes, imageStrides, width, height, imageFormat.getValue(), faceInfo.getRect(), faceInfo.getOrient(), feature.featureData,threadNum);
            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }
    }

    /**
     * 比对人脸特征数据获取相似度
     *
     * @param feature1    人脸特征对象
     * @param feature2    人脸特征对象
     * @param faceSimilar 相似度信息，用于输出相似度数据
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int compareFaceFeature(FaceFeature feature1, FaceFeature feature2, FaceSimilar faceSimilar) {
        return compareFaceFeature(feature1, feature2, CompareModel.LIFE_PHOTO, faceSimilar);
    }

    /**
     * 比对人脸特征数据获取相似度
     *
     * @param feature1     人脸特征对象
     * @param feature2     人脸特征对象
     * @param compareModel 比对模型，生活照比对还是身份证比对
     * @param faceSimilar  相似度信息，用于输出相似度数据
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int compareFaceFeature(FaceFeature feature1, FaceFeature feature2, CompareModel compareModel, FaceSimilar faceSimilar) {
        if (feature1 == null || feature1.getFeatureData() == null || feature2 == null || feature2.getFeatureData() == null || faceSimilar == null || compareModel == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        if (handle != 0L) {
            int errorCode = pairMatching(handle, feature1.featureData, feature2.featureData, compareModel.getValue(), faceSimilar);
            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }

    }


    /**
     * 获取年龄信息，需要在调用{@link #process(byte[], int, int, ImageFormat, List, FunctionConfiguration)}后调用
     *
     * @param ageInfoList 年龄信息列表，用于输出年龄信息数据
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int getAge(List<AgeInfo> ageInfoList) {

        if (ageInfoList == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }
        ageInfoList.clear();
        if (handle != 0L) {
            AgeInfo[] faceInfoArray = new AgeInfo[detectFaceMaxNum];
            int errorCode = getAge(handle, faceInfoArray);
            for (AgeInfo ageInfo : faceInfoArray) {
                if (ageInfo == null) break;
                ageInfoList.add(ageInfo);
            }

            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }

    }

    /**
     * 获取性别信息，需要在调用{@link #process(byte[], int, int, ImageFormat, List, FunctionConfiguration)}后调用
     *
     * @param genderInfoList 性别信息列表，用于输出性别信息数据
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int getGender(List<GenderInfo> genderInfoList) {
        if (genderInfoList == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }
        genderInfoList.clear();
        if (handle != 0L) {
            GenderInfo[] genderInfos = new GenderInfo[detectFaceMaxNum];
            int errorCode = getGender(handle, genderInfos);
            for (GenderInfo genderInfo : genderInfos) {
                if (genderInfo == null) break;
                genderInfoList.add(genderInfo);
            }

            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }

    }

    /**
     * 获取人脸三维角度信息，需要在调用{@link #process(byte[], int, int, ImageFormat, List, FunctionConfiguration)}后调用
     *
     * @param face3DAngleList 人脸三维角度信息列表，用于输出人脸三维角度信息数据
     * @return 错误码，详细见({@link ErrorInfo})
     */

    public int getFace3DAngle(List<Face3DAngle> face3DAngleList) {
        if (face3DAngleList == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }
        face3DAngleList.clear();
        if (handle != 0L) {
            Face3DAngle[] face3DAngles = new Face3DAngle[detectFaceMaxNum];
            int errorCode = getFace3DAngle(handle, face3DAngles);
            for (Face3DAngle face3DAngle : face3DAngles) {
                if (face3DAngle == null) break;
                face3DAngleList.add(face3DAngle);
            }

            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }
    }

    /**
     * 获取新的RGB活体信息对象，需要在调用{@link #process(byte[], int, int, ImageFormat, List, FunctionConfiguration)}后调用
     *
     * @param livenessInfoList 创建一个新的RGB活体信息对象
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int getLiveness(List<LivenessInfo> livenessInfoList) {
        if (livenessInfoList == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }
        livenessInfoList.clear();
        if (handle != 0L) {
            LivenessInfo[] livenessInfos = new LivenessInfo[detectFaceMaxNum];
            int errorCode = getLiveness(handle, livenessInfos);
            for (LivenessInfo livenessInfo : livenessInfos) {
                if (livenessInfo == null) break;
                livenessInfoList.add(livenessInfo);
            }
            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }
    }

    /**
     * 获取新的IR活体信息对象，需要在调用{@link #processIr(byte[], int, int, ImageFormat, List, FunctionConfiguration)}后调用
     *
     * @param livenessInfoList 创建一个新的IR活体信息对象
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int getLivenessIr(List<IrLivenessInfo> livenessInfoList) {
        if (livenessInfoList == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }
        livenessInfoList.clear();
        if (handle != 0L) {
            IrLivenessInfo[] livenessInfos = new IrLivenessInfo[detectFaceMaxNum];
            int errorCode = getLivenessIr(handle, livenessInfos);
            for (IrLivenessInfo livenessInfo : livenessInfos) {
                if (livenessInfo == null) break;
                livenessInfoList.add(livenessInfo);
            }
            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }
    }

    /**
     * 获取版本信息
     *
     * @return 返回版本信息
     */
    public VersionInfo getVersion() {
        VersionInfo versionInfo = new VersionInfo();
        this.getVersion(versionInfo);
        return versionInfo;
    }

    /**
     * 采集设备信息（可离线）
     *
     * @param activeDeviceInfo 创建一个新的采集设备信息对象
     * @return 错误码，详细见({@link ErrorInfo})
     */
    public int getActiveDeviceInfo(ActiveDeviceInfo activeDeviceInfo) {
        if (activeDeviceInfo == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }
        return getActiveDeviceInfoNative(activeDeviceInfo);
    }


    /**
     * 图像质量检测
     *
     * @param imageInfo         图像信息
     *@param detectModel       图像检测模型
     * @param faceInfoList      人脸列表，传入后赋值
     * @param imageQualityArray 输出图像质量信息
     * @return @return 错误码，详细见({@link ErrorInfo})
     */
    public int imageQualityDetect(ImageInfo imageInfo, DetectModel detectModel, List<FaceInfo> faceInfoList, List<ImageQuality> imageQualityArray) {
        if (imageInfo == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        return imageQualityDetect(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), detectModel, faceInfoList, imageQualityArray);
    }

    private int imageQualityDetect(byte[] data, int width, int height, ImageFormat imageFormat, DetectModel detectModel, List<FaceInfo> faceInfoList, List<ImageQuality> imageQualityArray) {
        if (faceInfoList == null
                || data == null
                || imageFormat == null
                || imageQualityArray == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        if (width < 1 || height < 1) {
            return ErrorInfo.MERR_ASF_IMAGE_WIDTH_HEIGHT_NOT_SUPPORT.getValue();
        }

        if (!checkImageData(data, width, height, imageFormat)) {
            return ErrorInfo.MERR_ASF_EX_INVALID_IMAGE_INFO.getValue();
        }

        if (handle != 0L) {
            ImageQuality[] imageQualities = new ImageQuality[faceInfoList.size()];
            FaceInfo[] faceInfos = faceInfoList.toArray(new FaceInfo[0]);
            int errorCode = imageQualityDetectNative(handle, data, width, height, imageFormat.getValue(), detectModel.getValue(), faceInfos, imageQualities);
            for (int i = 0; i < faceInfoList.size(); i++) {
                imageQualityArray.add(imageQualities[i]);
            }
            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }
    }


    /**
     * 图像质量检测
     *
     * @param imageInfoEx       图像信息
     * @param detectModel       图像检测模型
     * @param faceInfoList      人脸列表，传入后赋值
     * @param imageQualityArray 输出图像质量信息
     * @return @return 错误码，详细见({@link ErrorInfo})
     */
    public int imageQualityDetect(ImageInfoEx imageInfoEx, DetectModel detectModel, List<FaceInfo> faceInfoList, List<ImageQuality> imageQualityArray) {
        if (imageInfoEx == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }
        return imageQualityDetect(imageInfoEx.getImageDataPlanes(), imageInfoEx.getImageStrides(), imageInfoEx.getWidth(), imageInfoEx.getHeight(),detectModel , imageInfoEx.getImageFormat()
                , faceInfoList, imageQualityArray);
    }

    /**
     * @param imageDataPlanes   人脸图像通道
     * @param imageStrides      步长
     * @param width             图片宽度，为4的倍数
     * @param height            图片高度，YUYV/I420/NV21/NV12格式为2的倍数；BGR24/GRAY/DEPTH_U16格式无限制
     * @param imageFormat       图像的颜色空间格式
     * @param faceInfoList      人脸列表，传入后赋值
     * @param imageQualityArray 输出图像质量信息
     * @return @return 错误码，详细见({@link ErrorInfo})
     */
    private int imageQualityDetect(byte[][] imageDataPlanes, int[] imageStrides, int width, int height,  DetectModel detectModel,ImageFormat imageFormat, List<FaceInfo> faceInfoList, List<ImageQuality> imageQualityArray) {
        if (faceInfoList == null
                || imageDataPlanes == null
                || imageStrides == null
                || imageFormat == null
                || imageQualityArray == null) {
            return ErrorInfo.MERR_INVALID_PARAM.getValue();
        }

        if (width < 1 || height < 1) {
            return ErrorInfo.MERR_ASF_IMAGE_WIDTH_HEIGHT_NOT_SUPPORT.getValue();
        }

        if (!checkImageData(imageDataPlanes, imageStrides, width, height, imageFormat)) {
            return ErrorInfo.MERR_ASF_EX_INVALID_IMAGE_INFO.getValue();
        }

        if (handle != 0L) {
            ImageQuality[] imageQualities = new ImageQuality[faceInfoList.size()];
            int errorCode = imageQualityDetectExNative(handle, imageDataPlanes, imageStrides, width, height, imageFormat.getValue(), detectModel.getValue(),faceInfoList.toArray(new FaceInfo[0]), imageQualities);
            for (int i = 0; i < faceInfoList.size(); i++) {
                imageQualityArray.add(imageQualities[i]);
            }
            return errorCode;
        } else {
            return ErrorInfo.MERR_BAD_STATE.getValue();
        }

    }

    private boolean checkImageData(byte[] data, int width, int height, ImageFormat imageFormat) {
        switch (imageFormat) {
            case CP_PAF_NV21:
            case CP_PAF_NV12:
            case CP_PAF_I420:
                if (data.length != width * height * 3 / 2) {
                    return false;
                }
                break;
            case CP_PAF_BGR24:
                if (data.length != width * height * 3) {
                    return false;
                }
                break;
            case CP_PAF_YUYV:
                if (data.length != width * height * 2) {
                    return false;
                }
                break;
            case CP_PAF_GRAY: {
                if (data.length != width * height) {
                    return false;
                }
                break;
            }
            case CP_PAF_DEPTH_U16: {
                if (data.length != width * height * 2) {
                    return false;
                }
                break;
            }
        }
        return true;
    }

    private boolean checkImageData(byte[][] planes, int[] strides, int width, int height, ImageFormat imageFormat) {
        if (planes != null && strides != null) {
            if (planes.length != strides.length) {
                return false;
            } else {
                byte[][] var3 = planes;
                int var4 = planes.length;

                for (int var5 = 0; var5 < var4; ++var5) {
                    byte[] plane = var3[var5];
                    if (plane == null || plane.length == 0) {
                        return false;
                    }
                }

                switch (imageFormat) {
                    case CP_PAF_NV21:
                        return ((height & 1) == 0)
                                && planes.length == 2
                                && planes[0].length == planes[1].length * 2
                                && planes[0].length == (strides[0] * height)
                                && planes[1].length == (strides[1] * height / 2);
                    case CP_PAF_BGR24:
                    case CP_PAF_GRAY:
                    case CP_PAF_DEPTH_U16:
                        return planes.length == 1
                                && planes[0].length == strides[0] * height;
                    default:
                        return false;
                }
            }
        } else {
            return false;
        }
    }


}
