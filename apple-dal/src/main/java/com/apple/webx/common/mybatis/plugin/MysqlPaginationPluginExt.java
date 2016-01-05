/*
 * Copyright 2013 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.apple.webx.common.mybatis.plugin;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * 类MysqlPaginationPluginExt.java的实现描述： Mysql Ext 实现类
 * <p>
 * 
 * @author Jndong 2013年12月12日 下午1:15:10
 */
public class MysqlPaginationPluginExt extends MysqlPaginationPlugin {

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        addIsValidMethod(topLevelClass, introspectedTable);
        return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
    }

    private void addIsValidMethod(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("isValid");
        method.setReturnType(FullyQualifiedJavaType.getBooleanPrimitiveInstance());
        method.addBodyLine("for(int i = 0; i < oredCriteria.size(); i++){");
        method.addBodyLine("if(oredCriteria.get(i).isValid()){");
        method.addBodyLine("return true;");
        method.addBodyLine("}");
        method.addBodyLine("}");
        method.addBodyLine("return false;");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
                                                                     IntrospectedTable introspectedTable) {
//        XmlElement lastXmlE = (XmlElement) element.getElements().remove(element.getElements().size() - 1);
//        XmlElement pageStart = new XmlElement("include");
//        pageStart.addAttribute(new Attribute("refid", "OracleDialectPrefix"));
//        element.getElements().add(5, pageStart);
//        XmlElement isdeletedElement = new XmlElement("if");
//        isdeletedElement.addAttribute(new Attribute("test", "valid"));
//        isdeletedElement.addElement(new TextElement("and is_deleted = 'n'"));
//        element.addElement(isdeletedElement);
//        isdeletedElement = new XmlElement("if");
//        isdeletedElement.addAttribute(new Attribute("test", "!valid"));
//        isdeletedElement.addElement(new TextElement("where is_deleted = 'n'"));
//        element.addElement(isdeletedElement);
//
//        XmlElement fullOrgPath = new XmlElement("include");
//        fullOrgPath.addAttribute(new Attribute("refid", "fullOrgPath"));
//        element.addElement(fullOrgPath);
//
//        XmlElement owner = new XmlElement("include");
//        owner.addAttribute(new Attribute("refid", "owner"));
//        element.addElement(owner);
//
//        element.addElement(lastXmlE);
//        XmlElement isNotNullElement = new XmlElement("include"); //$NON-NLS-1$     
//        isNotNullElement.addAttribute(new Attribute("refid", "OracleDialectSuffix"));
//        element.getElements().add(isNotNullElement);

        return true;
    }

    @Override
    public boolean sqlMapCountByExampleElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
 
        return true;
    }

}
