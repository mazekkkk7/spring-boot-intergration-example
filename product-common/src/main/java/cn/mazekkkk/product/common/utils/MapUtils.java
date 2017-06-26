package cn.mazekkkk.product.common.utils;

import java.util.*;

/**
 * Created by maze on 17/6/23.
 */
public class MapUtils {

    /**
     * Map集合 转换成按照Key正序排列的list集合
     * @param parameterMap 参数集合
     * @return
     */
    public static List sortKeyAsc(Map parameterMap){
        List<Map.Entry<String,String[]>> list = new ArrayList<Map.Entry<String, String[]>>(parameterMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, String[]>>() {
            @Override
            public int compare(Map.Entry<String, String[]> o1, Map.Entry<String, String[]> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        return list;
    }

}

