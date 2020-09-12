import com.arcsoft.face.*;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectModel;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.toolkit.ImageFactory;
import com.arcsoft.face.toolkit.ImageInfo;
import com.arcsoft.face.toolkit.ImageInfoEx;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FaceEngineTest {


    public static void main(String[] args) {

        //激活码，从官网获取
        String appId = "Fnf55vnvutM1cG6RW6Wqh3odJD7mJ72AETrdEB7oxaLg";
        String sdkKey = "8bS4Nx6WbLoe97vUNKbUP4KxrsfXGYwzAPvbZ41MZ5Cz";
        String activeKey = "8611-113Q-713Y-BJHP";

        System.err.println("注意，如果返回的errorCode不为0，可查看com.arcsoft.face.enums.ErrorInfo类获取相应的错误信息");

        //人脸识别引擎库存放路径
        FaceEngine faceEngine = new FaceEngine("D:\\arcsoft_lib");
        //激活引擎
        int errorCode = faceEngine.activeOnline(appId, sdkKey, activeKey);
        System.out.println("引擎激活errorCode:" + errorCode);


        ActiveDeviceInfo activeDeviceInfo = new ActiveDeviceInfo();
        //采集设备信息（可离线）
        errorCode = faceEngine.getActiveDeviceInfo(activeDeviceInfo);
        System.out.println("采集设备信息errorCode:" + errorCode);
        System.out.println("设备信息:"+activeDeviceInfo.getDeviceInfo());

//        faceEngine.activeOffline("d:\\ArcFacePro64.dat");

        ActiveFileInfo activeFileInfo = new ActiveFileInfo();
        errorCode = faceEngine.getActiveFileInfo(activeFileInfo);
        System.out.println("获取激活文件errorCode:" + errorCode);
        System.out.println("激活文件信息:" + activeFileInfo.toString());

        //引擎配置
        EngineConfiguration engineConfiguration = new EngineConfiguration();
        engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
        engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_ALL_OUT);
        engineConfiguration.setDetectFaceMaxNum(10);
        engineConfiguration.setDetectFaceScaleVal(16);
        //功能配置
        FunctionConfiguration functionConfiguration = new FunctionConfiguration();
        functionConfiguration.setSupportAge(true);
        functionConfiguration.setSupportFace3dAngle(true);
        functionConfiguration.setSupportFaceDetect(true);
        functionConfiguration.setSupportFaceRecognition(true);
        functionConfiguration.setSupportGender(true);
        functionConfiguration.setSupportLiveness(true);
        functionConfiguration.setSupportIRLiveness(true);
        functionConfiguration.setSupportImageQuality(true);
        engineConfiguration.setFunctionConfiguration(functionConfiguration);

        //初始化引擎
        errorCode = faceEngine.init(engineConfiguration);
        System.out.println("初始化引擎errorCode:" + errorCode);


        //人脸检测
        ImageInfo imageInfo = ImageFactory.getRGBData(new File("C:\\Users\\dell\\Desktop\\ace26151-d46d-4ced-a243-489c7a3bd756.jpg"));
        List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
        errorCode = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList);
        System.out.println("人脸检测errorCode:" + errorCode);
        System.out.println("检测到人脸数:" + faceInfoList.size());


        List<ImageQuality> imageQualityList = new ArrayList<>();
        errorCode = faceEngine.imageQualityDetect(imageInfo, DetectModel.ASF_DETECT_MODEL_RGB, faceInfoList, imageQualityList);
        System.out.println("图像质量检测errorCode:" + errorCode);
        System.out.println("图像质量分数:" + imageQualityList.get(0).getFaceQuality());

        //特征提取
        FaceFeature faceFeature = new FaceFeature();
        errorCode = faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList.get(0), faceFeature,2);
        System.out.println("特征提取errorCode:" + errorCode);

        //人脸检测2
        ImageInfo imageInfo2 = ImageFactory.getRGBData(new File("C:\\Users\\dell\\Desktop\\ace26151-d46d-4ced-a243-489c7a3bd756.jpg"));
        List<FaceInfo> faceInfoList2 = new ArrayList<FaceInfo>();
        errorCode = faceEngine.detectFaces(imageInfo2.getImageData(), imageInfo2.getWidth(), imageInfo2.getHeight(), imageInfo.getImageFormat(), faceInfoList2);
        System.out.println("人脸检测errorCode:" + errorCode);
        System.out.println("检测到人脸数:" + faceInfoList.size());

        //特征提取2
        FaceFeature faceFeature2 = new FaceFeature();
        errorCode = faceEngine.extractFaceFeature(imageInfo2.getImageData(), imageInfo2.getWidth(), imageInfo2.getHeight(), imageInfo.getImageFormat(), faceInfoList2.get(0), faceFeature2);
        System.out.println("特征提取errorCode:" + errorCode);

        //特征比对
        FaceFeature targetFaceFeature = new FaceFeature();
        targetFaceFeature.setFeatureData(faceFeature.getFeatureData());
        FaceFeature sourceFaceFeature = new FaceFeature();
        sourceFaceFeature.setFeatureData(faceFeature2.getFeatureData());
        FaceSimilar faceSimilar = new FaceSimilar();

        errorCode = faceEngine.compareFaceFeature(targetFaceFeature, sourceFaceFeature, faceSimilar);
        System.out.println("特征比对errorCode:" + errorCode);
        System.out.println("人脸相似度：" + faceSimilar.getScore());

        //设置活体测试
        errorCode = faceEngine.setLivenessParam(0.5f, 0.7f);
        System.out.println("设置活体活体阈值errorCode:" + errorCode);

        //人脸属性检测
        FunctionConfiguration configuration = new FunctionConfiguration();
        configuration.setSupportAge(true);
        configuration.setSupportFace3dAngle(true);
        configuration.setSupportGender(true);
        configuration.setSupportLiveness(true);
        errorCode = faceEngine.process(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList, configuration);
        System.out.println("图像属性处理errorCode:" + errorCode);

        //性别检测
        List<GenderInfo> genderInfoList = new ArrayList<GenderInfo>();
        errorCode = faceEngine.getGender(genderInfoList);
        System.out.println("性别：" + genderInfoList.get(0).getGender());

        //年龄检测
        List<AgeInfo> ageInfoList = new ArrayList<AgeInfo>();
        errorCode = faceEngine.getAge(ageInfoList);
        System.out.println("年龄：" + ageInfoList.get(0).getAge());

        //3D信息检测
        List<Face3DAngle> face3DAngleList = new ArrayList<Face3DAngle>();
        errorCode = faceEngine.getFace3DAngle(face3DAngleList);
        System.out.println("3D角度：" + face3DAngleList.get(0).getPitch() + "," + face3DAngleList.get(0).getRoll() + "," + face3DAngleList.get(0).getYaw());

        //活体检测
        List<LivenessInfo> livenessInfoList = new ArrayList<LivenessInfo>();
        errorCode = faceEngine.getLiveness(livenessInfoList);
        System.out.println("活体：" + livenessInfoList.get(0).getLiveness());


        //IR属性处理
        ImageInfo imageInfoGray = ImageFactory.getGrayData(new File("d:\\IR_480p.jpg"));
        List<FaceInfo> faceInfoListGray = new ArrayList<FaceInfo>();
        errorCode = faceEngine.detectFaces(imageInfoGray.getImageData(), imageInfoGray.getWidth(), imageInfoGray.getHeight(), imageInfoGray.getImageFormat(), faceInfoListGray);

        FunctionConfiguration configuration2 = new FunctionConfiguration();
        configuration2.setSupportIRLiveness(true);
        errorCode = faceEngine.processIr(imageInfoGray.getImageData(), imageInfoGray.getWidth(), imageInfoGray.getHeight(), imageInfoGray.getImageFormat(), faceInfoListGray, configuration2);
        //IR活体检测
        List<IrLivenessInfo> irLivenessInfo = new ArrayList<>();
        errorCode = faceEngine.getLivenessIr(irLivenessInfo);
        System.out.println("IR活体：" + irLivenessInfo.get(0).getLiveness());


        //获取激活文件信息
        ActiveFileInfo activeFileInfo2 = new ActiveFileInfo();
        errorCode = faceEngine.getActiveFileInfo(activeFileInfo2);


        //高级人脸图像处理接口
        ImageInfoEx imageInfoEx = new ImageInfoEx();
        imageInfoEx.setHeight(imageInfo.getHeight());
        imageInfoEx.setWidth(imageInfo.getWidth());
        imageInfoEx.setImageFormat(imageInfo.getImageFormat());
        imageInfoEx.setImageDataPlanes(new byte[][]{imageInfo.getImageData()});
        imageInfoEx.setImageStrides(new int[]{imageInfo.getWidth() * 3});
        List<FaceInfo> faceInfoList1 = new ArrayList<>();
        errorCode = faceEngine.detectFaces(imageInfoEx, DetectModel.ASF_DETECT_MODEL_RGB, faceInfoList1);
        List<ImageQuality> imageQualityList1 = new ArrayList<>();
        errorCode = faceEngine.imageQualityDetect(imageInfoEx, DetectModel.ASF_DETECT_MODEL_RGB, faceInfoList1, imageQualityList1);
        FunctionConfiguration fun = new FunctionConfiguration();
        fun.setSupportAge(true);
        errorCode = faceEngine.process(imageInfoEx, faceInfoList1, fun);
        List<AgeInfo> ageInfoList1 = new ArrayList<>();
        int age = faceEngine.getAge(ageInfoList1);
        FaceFeature feature = new FaceFeature();
        errorCode = faceEngine.extractFaceFeature(imageInfoEx, faceInfoList1.get(0), feature,2);


        //引擎卸载
        errorCode = faceEngine.unInit();

    }
}