package com.zhang.ssm.wrapperPojo;

import com.zhang.ssm.utils.DateUtil;
import org.apache.commons.lang.math.RandomUtils;

import java.util.Date;

/**
 * @ClassName SimulationData
 * @Description:
 * @Author Raymond Zhang
 * @Date 2018/5/28 21:38
 * @Version 1.0
 **/
public class SimulationData {


    private Date datetime;
    private Integer val;

    private SimulationData(Date datetime, Integer val) {
        this.datetime = datetime;
        this.val = val;
    }



    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public static SimulationData genRandomData() {
        return new SimulationData(DateUtil.genFormatDate(new Date()), RandomUtils.nextInt(100));
    }


    public static SimulationData build(Date datetime, Integer val) {
        return new SimulationData(datetime, val);
    }

}
