package Test;

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
        List<ResObject> strings = new ArrayList<>();

        List<Integer> collect = strings.stream().map(ResObject::hashCode).collect(Collectors.toList());
        System.out.println();
    }
}
