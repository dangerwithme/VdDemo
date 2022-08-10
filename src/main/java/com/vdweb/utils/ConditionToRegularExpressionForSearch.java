package com.vdweb.utils;

import java.util.regex.Pattern;

public class ConditionToRegularExpressionForSearch {
    private String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";//去除特殊字符的正则表达式

    public String action(String condition){
        String[] SplitCondition = condition.split("");
        Pattern p = Pattern.compile(regEx);
        condition = condition + '|';
        for (String s : SplitCondition) {
            if (p.matcher(s).find()) {
                continue;
            }else
                condition = condition + s + '|';
        }
        condition = condition.substring(0,condition.length()-1);
        return condition;
    }
}
