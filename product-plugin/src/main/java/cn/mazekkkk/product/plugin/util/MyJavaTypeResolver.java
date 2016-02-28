package cn.mazekkkk.product.plugin.util;

/* (C) Copyright 2015-2017, RGI Technology Inc.
 * All rights reserved.
 * 
 * Created On : 2015/5/15 10:36
 * User: yonghui.feng
 */

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;

public class MyJavaTypeResolver extends JavaTypeResolverDefaultImpl {

    public FullyQualifiedJavaType calculateJavaType(
        IntrospectedColumn introspectedColumn) {
        // TODO Auto-generated method stub
        FullyQualifiedJavaType answer;
        JdbcTypeInformation jdbcTypeInformation = typeMap
            .get(introspectedColumn.getJdbcType());

        if (jdbcTypeInformation == null) {
            switch (introspectedColumn.getJdbcType()) {
                case Types.DECIMAL:
                case Types.NUMERIC:
                    if (introspectedColumn.getScale() > 0) {//如果包含小数点则转换成float
                        answer = new FullyQualifiedJavaType(Double.class.getName());
                    } else {
                        if (introspectedColumn.getLength() > 18
                            || forceBigDecimals) {
                            answer = new FullyQualifiedJavaType(Double.class
                                .getName());
                        } else if (introspectedColumn.getLength() > 9) {
                            answer = new FullyQualifiedJavaType(Long.class.getName());
                        } else if (introspectedColumn.getLength() > 4) {
                            answer = new FullyQualifiedJavaType(Integer.class.getName());
                        } else {
                            answer = new FullyQualifiedJavaType(Short.class.getName());
                        }
                    }
                    break;

                default:
                    answer = null;
                    break;
            }
        } else {
            answer = jdbcTypeInformation.getFullyQualifiedJavaType();
        }

        return answer;
    }

    public String calculateJdbcTypeName(IntrospectedColumn introspectedColumn) {
        return null;
    }
}
