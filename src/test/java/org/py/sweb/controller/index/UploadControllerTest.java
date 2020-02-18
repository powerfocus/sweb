package org.py.sweb.controller.index;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

@SpringBootTest
public class UploadControllerTest {
    @Value("${allowImgs}")
    private String allowImgs;
    @Test
    public void test() {
        /*Optional<String> reduce = Arrays.stream(allowImgs).reduce((v1, v2) -> v1.concat(",").concat(v2));
        String s = reduce.orElse("");
        Arrays.stream(allowImgs).forEach(t -> System.out.print(t + " "));
        System.out.println(s);
        if(s.toLowerCase().indexOf("png") != -1)
            System.out.println("allow");
        else
            System.out.println("no allow");*/
        if(allowImgs.toLowerCase().indexOf("png") != -1)
            System.out.println("allow");
        else
            System.out.println("not allow");
    }
}