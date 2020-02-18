package org.py.sweb;

import org.junit.jupiter.api.Test;
import org.py.sweb.mapper.Sort;
import org.springframework.http.ResponseEntity;

import java.io.*;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonsTest {
    @Test
    public void test() {
        Integer iv = 999;
        Long lv = 999L;
        System.out.println(iv.equals(lv));
        System.out.println(lv.equals(iv));
        System.out.println(iv.equals(999));
        System.out.println(lv.equals(999L));
        System.out.println("----------");
        System.out.println(iv == 999L);
        System.out.println(lv == 999);
        System.out.println("----------");
        System.out.println(Objects.equals(iv, 999L));
        System.out.println(Objects.equals(iv, 999));
    }
    @Test
    public void datetimeTest() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(now);
        System.out.println(now.format(dateTimeFormatter));
        System.out.println(simpleDateFormat.format(Date.from(now.toInstant(ZoneOffset.UTC))));
    }
    @Test
    public void sortTest() {
        Sort sort = Sort.desc;
        System.out.println(sort.name());
    }
    @Test
    public void forTest() {
        List<Integer> list = Stream.iterate(0, n -> n + 2).limit(10).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
    @Test
    public void numberConvertTest() {
        String param = "aaa111";
        Integer iv = Integer.valueOf(null);
        System.out.println(iv);
    }
    @Test
    public void down() {
        try {
            URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1581956812083&di=a5acc9145306d3906f130970f1de96a1&imgtype=jpg&src=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D3245480194%2C2251011667%26fm%3D214%26gp%3D0.jpg");
            File save = new File( "aaa.jpg");
            try(BufferedInputStream in = new BufferedInputStream(url.openStream());
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(save))
            ) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[512];
                int len = 0;
                while((len = in.read(buffer)) != -1) {
                    //out.write(buffer, 0, len);
                    byteArrayOutputStream.write(buffer, 0, len);
                }
                out.write(byteArrayOutputStream.toByteArray());
                System.out.println("文件以保存！" + save.getAbsolutePath());
            } catch(IOException e) {
                e.printStackTrace();
            }
        } catch(MalformedURLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void responseTest() {
        ResponseEntity<String> body = ResponseEntity.ok().body("hello world.");
    }
}
