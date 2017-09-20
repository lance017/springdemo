package com.lance.springdemo.controller;

import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lance on 2017/9/18.
 */
@Service
public class RoleDirectiveModel implements TemplateDirectiveModel {
    /**
     *
     * @param environment 环境变量
     * @param map 指令参数
     * @param templateModels 循环变量
     * @param templateDirectiveBody 指令内容
     * @throws TemplateException
     * @throws IOException
     */
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        System.out.println("===============");

        TemplateScalarModel user = (TemplateScalarModel) map.get("user");
        TemplateScalarModel role = (TemplateScalarModel) map.get("role");

        if ("123456".equals(user.getAsString()) && "admin".equals(role.getAsString())) {
            templateModels[0] = TemplateBooleanModel.TRUE;
        }

        List<String> otherRights = new ArrayList<String>();
        otherRights.add("add");
        otherRights.add("delete");
        otherRights.add("update");
        templateModels[1] = new SimpleSequence((otherRights));

        templateDirectiveBody.render(environment.getOut());

    }
}
