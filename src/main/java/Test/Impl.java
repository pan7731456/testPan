package Test;

import Untils.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author pan
 * @Date 2020/5/9 14:29
 * @Description
 * @Version 1.0
 **/
public class Impl {

    public static void main(String[] args) {
//        Date now = new Date();
//        Date maximum = DateUtil.getLastMonthTime(now, "min");
//        String format = DateFormatUtils.format(maximum, "yyyy-MM-dd HH:mm");
//        System.out.println(format);
//        ResObject resObject = new ResObject();
//
//        ResObject clone = ObjectUtil.clone(resObject);
//        System.out.println(clone == resObject);

        char a = 'A';
        char b = 'A';
        StringBuilder index = new StringBuilder();
        index.append(a).append(b);
        System.out.println(index);

    }
}
