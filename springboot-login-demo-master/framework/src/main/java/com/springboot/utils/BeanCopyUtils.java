package com.springboot.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {
    public BeanCopyUtils() {

    }
    public static <v> v copyBean(Object source,Class<v> class1) throws InstantiationException, IllegalAccessException {
        //build target object

        v result = class1.newInstance();
        BeanUtils.copyProperties(source,result);
        return result;
    }
    public static <o,v> List<v> copyBeanList(List<o> list,Class<v> class1) {
        return list.stream()
                .map(o -> {
                    try {
                        return copyBean(o, class1);
                    } catch (InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
    }
}
