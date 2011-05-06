package com.taobao.api.internal.mapping;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.taobao.api.Constants;
import com.taobao.api.ApiException;
import com.taobao.api.TaobaoResponse;
import com.taobao.api.internal.util.StringUtils;

/**
 * 转换工具类。
 *
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public class Converters {
    public static boolean isCheckJsonType = false; //是否对json返回的数据类型进行校验，默认不校验。给内部测试json返回时用的开关。规则：返回的"基本"类型只有String,Long,Boolean,Date,采取严格校验方式，如果类型不匹配，报错
    private static List<String> baseField = new ArrayList<String>();

    static {
        baseField.add("errorCode");
        baseField.add("msg");
        baseField.add("subCode");
        baseField.add("subMsg");
        baseField.add("body");
        baseField.add("params");
        baseField.add("class");
        baseField.add("success");
        baseField.add("apiMethodName");
    }

    private Converters() {
    }

    /**
     * 使用指定 的读取器去转换字符串为对象。
     *
     * @param <T>    领域泛型
     * @param clazz  领域类型
     * @param reader 读取器
     * @return 领域对象
     * @throws TopException
     */
    public static <T> T convert(Class<T> clazz, Reader reader) throws ApiException {
        T rsp = null;

        try {
            rsp = clazz.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor pd : pds) {
                Method method = pd.getWriteMethod();
                String itemName = pd.getName();
                String listName = null;

                if ("class".equals(itemName)) {
                    continue;//class是关键字无论在Response还是数据结构中，此字段都被忽略
                }
                if (baseField.contains(itemName) && TaobaoResponse.class.isAssignableFrom(clazz)) {//只有TaobaoResponse的子类不允许出现关键字
                    continue; // ignore class field
                }
                Field field = clazz.getDeclaredField(itemName);

                ApiField jsonField = field.getAnnotation(ApiField.class);
                if (jsonField != null) {
                    String alias = jsonField.value();
                    if (!StringUtils.isEmpty(alias)) {
                        itemName = alias; // use annotation name
                    }
                }

                if (!reader.hasReturnField(itemName)) {
                    ApiListField jsonListField = field.getAnnotation(ApiListField.class);
                    if (jsonListField != null) {
                        listName = jsonListField.value();
                        if (jsonField == null)
                            itemName = listName.substring(0, listName.length() - 1);
                    }
                    if (listName == null || !reader.hasReturnField(listName)) {
                        continue; // ignore non-return field
                    }
                }

                Class<?> typeClass = field.getType();
                //目前
                if (String.class.isAssignableFrom(typeClass)) {
                    Object value = reader.getPrimitiveObject(itemName);
                    if (value instanceof String) {
                        method.invoke(rsp, value.toString());
                    } else {
                        if (isCheckJsonType) {
                            throw new ApiException("the type of " + itemName + " is not String");
                        } else {
                            method.invoke(rsp, value.toString());
                        }
                    }

                } else if (Long.class.isAssignableFrom(typeClass)) {
                    Object value = reader.getPrimitiveObject(itemName);
                    if (value instanceof Long) {
                        method.invoke(rsp, (Long) value);
                    } else {
                        if (isCheckJsonType) {
                            throw new ApiException("the type of " + itemName + " is not number(Long)");
                        } else {
                            method.invoke(rsp, Long.valueOf(value.toString()));
                        }
                    }
                } else if (Integer.class.isAssignableFrom(typeClass)) {
                    Object value = reader.getPrimitiveObject(itemName);
                    if (value instanceof Integer) {
                        method.invoke(rsp, (Integer) value);
                    } else {
                        method.invoke(rsp, Integer.valueOf(value.toString()));
                    }
                } else if (Boolean.class.isAssignableFrom(typeClass)) {
                    Object value = reader.getPrimitiveObject(itemName);
                    if (value instanceof Boolean) {
                        method.invoke(rsp, (Boolean) value);
                    } else {
                        if (isCheckJsonType) {
                            throw new ApiException("the type of " + itemName + " is not Boolean");
                        } else {
                            method.invoke(rsp, Boolean.valueOf(value.toString()));
                        }
                    }
                } else if (Double.class.isAssignableFrom(typeClass)) {
                    Object value = reader.getPrimitiveObject(itemName);
                    if (value instanceof Double) {
                        method.invoke(rsp, (Double) value);
                    } else {
                        method.invoke(rsp, Double.valueOf(value.toString()));
                    }
                } else if (Number.class.isAssignableFrom(typeClass)) {
                    Object value = reader.getPrimitiveObject(itemName);
                    if (value instanceof Number) {
                        method.invoke(rsp, (Number) value);
                    } else {
                        method.invoke(rsp, DecimalFormat.getInstance().parse(value.toString()));
                    }
                } else if (Date.class.isAssignableFrom(typeClass)) {
                    DateFormat format = new SimpleDateFormat(Constants.DATE_TIME_FORMAT);
                    format.setTimeZone(Constants.TOP_TIMEZONE);
                    Object value = reader.getPrimitiveObject(itemName);
                    if (value instanceof String) {
                        method.invoke(rsp, format.parse(value.toString()));
                    }
                } else if (List.class.isAssignableFrom(typeClass)) {
                    Type fieldType = field.getGenericType();
                    if (fieldType instanceof ParameterizedType) {
                        ParameterizedType paramType = (ParameterizedType) fieldType;
                        Type[] genericTypes = paramType.getActualTypeArguments();
                        if (genericTypes != null && genericTypes.length > 0) {
                            if (genericTypes[0] instanceof Class<?>) {
                                Class<?> subType = (Class<?>) genericTypes[0];
                                List<?> listObjs = reader.getListObjects(listName, itemName, subType);
                                if (listObjs != null) {
                                    method.invoke(rsp, listObjs);
                                }
                            }
                        }
                    }
                } else {
                    Object obj = reader.getObject(itemName, typeClass);
                    if (obj != null) {
                        method.invoke(rsp, obj);
                    }
                }
            }
        } catch (Exception e) {
            throw new ApiException(e);
        }

        return rsp;
    }
}
