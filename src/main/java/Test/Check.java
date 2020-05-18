package Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @Author pan
 * @Date 2020/5/9 14:50
 * @Description
 * @Version 1.0
 **/
public class Check {

    public void check(ResObject resObject, List test) {
        Optional.ofNullable(resObject.getAttrValues())
                .orElseGet(Collections::emptyMap)
                .entrySet()
                .forEach(it -> {
                    Optional.ofNullable(test)
                            .orElseGet(Collections::emptyList)
                            .stream()
                            .forEach(res -> {
                                it.getValue().setValue("moder");
                            });
                });
    }
}
