package com.example.game.util;

import java.util.Random;

public class SaltUtils {

    public static String getSalt(){
        return getSalt(10);
    }

    //生成salt的静态方法
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        //此方法中的n为多少，就从数组中取多少个字符
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}
