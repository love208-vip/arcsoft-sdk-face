package com.arcsoft.face.toolkit;


import com.arcsoft.face.enums.DetectModel;
import com.arcsoft.face.enums.ImageFormat;

public class ImageInfo {
    private byte[] imageData;
    private Integer width;
    private Integer height;
    private ImageFormat imageFormat;

    public byte[] getImageData() {
        if (imageData == null) {
            imageData = new byte[0];
        }
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public ImageFormat getImageFormat() {
        return imageFormat;
    }

    public void setImageFormat(ImageFormat imageFormat) {
        this.imageFormat = imageFormat;
    }

}
