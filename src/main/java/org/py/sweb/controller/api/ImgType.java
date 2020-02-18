package org.py.sweb.controller.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public enum ImgType {
    PNG, BMP, JPG, JPEG, GIF, TIFF, DIB, ICO, TIF, HEIC;
    private static final String NON = "NON";
    public static List<String> allowImgNames() {
        return Arrays.stream(values()).map(em -> em.name()).collect(Collectors.toList());
    }
    public static boolean isAllow(String name) {
        List<String> list = allowImgNames();
        Collections.sort(list);
        return Collections.binarySearch(list, name) >= 0 ? true : false;
    }
}
