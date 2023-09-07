package com.wen.xgr;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.smartloli.util.JSqlUtils;

import java.util.List;

public class SqlExceutor {

    public static void main(String[] args) {
        JSONObject tabSchema = new JSONObject();
        tabSchema.put("ID","integer");

        JSONArray datasets = JSON.parseArray("[{\"id\":1}]");

        String tabName = "DUAL";
        String sql = "select 1 from DUAL where 'null' like 'null'";
        try{
            String result = JSqlUtils.query(tabSchema, tabName, datasets, sql);
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
