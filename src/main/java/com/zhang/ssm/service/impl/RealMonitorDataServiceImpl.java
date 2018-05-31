package com.zhang.ssm.service.impl;

import com.zhang.ssm.holder.AuthCodeHolder;
import com.zhang.ssm.holder.MonitorsScopeHolder;
import com.zhang.ssm.service.RealMonitorDataService;
import com.zhang.ssm.utils.AuthUtil;
import com.zhang.ssm.utils.JsonUtil;
import com.zhang.ssm.utils.StringUtil;
import com.zhang.ssm.wrapperPojo.ResponseResult;
import com.zhang.ssm.wrapperPojo.SimulationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RealMonitorDataServiceImpl
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/28 20:22
 * @Version 1.0
 **/
@Service
public class RealMonitorDataServiceImpl implements RealMonitorDataService {


    @Autowired
    private MonitorsScopeHolder monitors;
    @Autowired
    private AuthCodeHolder authCodeHolder;


    /*
    获取对应权限的数据
     */
    public String getRealMonitorData() {
        Map<String, Object> data = new HashMap<String, Object>();
        ResponseResult responseResult = ResponseResult.ok();
        String contentScope = monitors.getMonitors();
        if (StringUtil.isEmpty(contentScope)) {
            responseResult.setCode(7);
            responseResult.setMsg("There is no content available within the permissions");
        } else {
            String[] names = contentScope.split("-");
            for (String name : names) {
                data.put(name, SimulationData.genRandomData());
            }
            responseResult.setData(data);

        }
        return JsonUtil.objectToJson(responseResult);
    }

    public String getScope() {
        Integer authCode = authCodeHolder.getAuthCode();
        ArrayList<Integer> auth = AuthUtil.parseAuthCode(authCode);//解析权限码
        ResponseResult responseResult = ResponseResult.ok();
        //验证读取权限
        boolean isAllowedRead = false;
        for (int i : auth) {
            if (i == READABLE) {
                isAllowedRead = true;
                break;
            }
        }
        if (!isAllowedRead) {
            responseResult.setCode(2);
            responseResult.setMsg("No read permission");

        } else {
            String limitDevs = monitors.getMonitors();
            Map<String, Object> map = new HashMap<String, Object>();
            String[] limits = StringUtil.splitString(limitDevs, "-");
            for (String limit : limits) {
                map.put(limit, "");
            }
            responseResult.setData(map);
            limitDevs = null;
        }
        return JsonUtil.objectToJson(responseResult);
    }
}
