package org.py.sweb.sys.util;

import org.springframework.beans.factory.annotation.Value;

public final class ImgUtil {
    @Value("${allowImgs}")
    private String allowImgs;
    public boolean isAllowImg(String name) {
        return allowImgs.toLowerCase().indexOf(name.trim()) != -1 ? true : false;
    }
}
