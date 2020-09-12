package com.arcsoft.face.toolkit;


import com.arcsoft.face.enums.ImageFormat;

public class ImageInfoEx {
    private byte[][] imageDataPlanes;
    private int[] imageStrides;
    private Integer width;
    private Integer height;
    private ImageFormat imageFormat;

    public byte[][] getImageDataPlanes() {
        if (imageDataPlanes == null) {
            imageDataPlanes = new byte[0][];
        }
        return imageDataPlanes;
    }


    public void setImageDataPlanes(byte[][] imageDataPlanes) {
        this.imageDataPlanes = imageDataPlanes;
    }

    public int[] getImageStrides() {
        if (imageStrides == null) {
            imageStrides = new int[0];
        }
        return imageStrides;
    }

    public void setImageStrides(int[] imageStrides) {
        this.imageStrides = imageStrides;
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
