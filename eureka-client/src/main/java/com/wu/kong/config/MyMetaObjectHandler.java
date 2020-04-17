package com.wu.kong.config;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/*
 * 自定义公共字段填充处理器
 *
 * */
public class MyMetaObjectHandler extends MetaObjectHandler {
    @Override
    /*
     * 插入操作自动填充
     * */
    public void insertFill(MetaObject metaObject) {
        Object filedValue = getFieldValByName("name", metaObject);
        if (filedValue == null) {
            System.out.println("*****插入  操作 满足 填充 条件******");
            setFieldValByName("name", "远爸爸insert", metaObject);//设置填充字段 and value
        }
    }

    @Override
    /*
     * 修改操作自动填充
     * */
    public void updateFill(MetaObject metaObject) {
        Object filedValue = getFieldValByName("name", metaObject);
        if (filedValue == null) {
            System.out.println("*****修改  操作 满足 填充 条件******");
            setFieldValByName("name", "远爸爸up", metaObject);//设置填充字段 and value
        }
    }

}
