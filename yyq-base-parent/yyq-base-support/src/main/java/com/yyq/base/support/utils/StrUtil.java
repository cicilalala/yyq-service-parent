package com.yyq.base.support.utils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yangyunqi on 2017/7/18.
 */
public class StrUtil {

    /**
     * 下划线转驼峰
     * @param line
     * @param smallCamel true 首字母小写 false 首字母大写
     * @return
     */
    public static String underline2Camel(String line, boolean smallCamel){

        if(line == null || "".equals(line)){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher = pattern.matcher(line);
        while(matcher.find()){
            String word = matcher.group();
            sb.append(smallCamel && matcher.start() == 0 ? Character.toLowerCase(word.charAt(0)) : Character.toUpperCase(word.charAt(0)));
            int index = word.lastIndexOf('_');
            if(index > 0){
                sb.append(word.substring(1, index).toLowerCase());
            }else{
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    /**
     * 驼峰转下划线
     * @param line
     * @return
     */
    public static String camel2Underline(String line){
        if(line == null || "".equals(line)){
            return "";
        }
        line = String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher = pattern.matcher(line);
        while(matcher.find()){
            String word = matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end() == line.length() ? "" : "_");
        }
        return sb.toString().toLowerCase();
    }

    public static String randomUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
