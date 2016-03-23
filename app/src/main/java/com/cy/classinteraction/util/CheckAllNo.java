package com.cy.classinteraction.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wuyue on 2016/3/23.
 */
public class CheckAllNo {

    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((17[0-9])|(13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
