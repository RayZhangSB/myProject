package com.zhang.ssm.service.impl;

import com.zhang.ssm.mapper.AuthGroupMapper;
import com.zhang.ssm.mapper.AuthOpreatorMapper;
import com.zhang.ssm.pojo.AuthGroup;
import com.zhang.ssm.pojo.AuthOpreator;
import com.zhang.ssm.pojo.User;
import com.zhang.ssm.service.RealMonitorDataService;
import com.zhang.ssm.utils.AuthUtil;
import com.zhang.ssm.utils.JsonUtil;
import com.zhang.ssm.utils.StringUtil;
import com.zhang.ssm.wrapperPojo.MonitorsHolder;
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
    private AuthGroupMapper authGroupMapper;
    @Autowired
    private AuthOpreatorMapper authOpreatorMapper;
    @Autowired
    private MonitorsHolder monitors;


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

    public String getScope(final User user) {
        AuthGroup authGroup = authGroupMapper.selectByPrimaryKey(user.getUserWorkgroup());
        String limitDevs = authGroup.getLimitContent();//查询限制查看的监视器
        AuthOpreator authOpreator = authOpreatorMapper.selectByPrimaryKey(user.getUserPosition());
        ArrayList<Integer> auth = AuthUtil.parseAuthCode(authOpreator.getUserAuthority());//查询权限码
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
            monitors.setMonitors(limitDevs);
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
