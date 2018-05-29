package com.zhang.ssm.service.impl;

import com.zhang.ssm.mapper.AuthGroupMapper;
import com.zhang.ssm.mapper.AuthOpreatorMapper;
import com.zhang.ssm.pojo.AuthGroup;
import com.zhang.ssm.pojo.AuthOpreator;
import com.zhang.ssm.pojo.User;
import com.zhang.ssm.service.RealMonitorDataService;
import com.zhang.ssm.utils.AuthUtil;
import com.zhang.ssm.utils.JsonUtil;
import com.zhang.ssm.wrapperPojo.ResponseResult;
import com.zhang.ssm.wrapperPojo.SimulationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    /*
    获取对应权限的数据
     */
    public String getRealMonitorData(final User user) {
        AuthGroup authGroup = authGroupMapper.selectByPrimaryKey(user.getUserWorkgroup());
        String limitContent = authGroup.getLimitContent();
        AuthOpreator authOpreator = authOpreatorMapper.selectByPrimaryKey(user.getUserPosition());
        int[] auth = AuthUtil.parseAuthCode(authOpreator.getUserAuthority());
        ResponseResult responseResult = ResponseResult.ok();
        boolean isAllowedRead = false;
        for (int i : auth) {
            if (i == READABLE || i == UPDATABLE) {
                isAllowedRead = true;
                break;
            }
        }
//        if(!isAllowedRead){
//            responseResult.setCode(2);
//            responseResult.setMsg("无读取权限");
//            return "";
//        }
//        //提取
//        String[] monitors = limitContent.split("-");
//        //从相应监视器提取最新数据，这里使用模拟数据
//        for(String monitor: monitors){
//            data.put(monitor, SimulationData.genRandomData());
//        }


        responseResult.setData(SimulationData.genRandomData());

        String res = JsonUtil.objectToJson(responseResult);
        return res;
    }
}
