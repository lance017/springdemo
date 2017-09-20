package com.lance.springdemo.controller;

import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lance on 2017/9/18.
 */
public class SortMethod implements TemplateMethodModelEx {
    @Override
    public Object exec(List list) throws TemplateModelException {
//        获取第一个参数
        SimpleSequence arg0 = (SimpleSequence) list.get(0);
        List<BigDecimal> bigDecimalList = arg0.toList();

        Collections.sort(bigDecimalList, new Comparator<BigDecimal>() {
            @Override
            public int compare(BigDecimal o1, BigDecimal o2) {
                return o1.intValue() - o2.intValue();//升序
            }
        });
        return bigDecimalList;
    }
}
