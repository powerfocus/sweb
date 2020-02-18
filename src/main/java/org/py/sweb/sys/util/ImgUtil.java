package org.py.sweb.sys.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public final class ImgUtil {
    @Value("${allowImgs}")
    private static String allowImgs;
    public static boolean isAllowImg(String name) {
        return allowImgs.toLowerCase().indexOf(name.trim()) != -1 ? true : false;
    }
}
