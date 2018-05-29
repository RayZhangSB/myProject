package com.zhang.ssm.wrapperPojo;

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
    private String name;

    private Date datetime;
    private Integer val;

    private SimulationData(String name, Date datetime, Integer val) {
        this.name = name;
        this.datetime = datetime;
        this.val = val;
    }

    private SimulationData(Date datetime, Integer val) {
        this("随机", datetime, val);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return new SimulationData(new Date(), RandomUtils.nextInt(100));
    }


    public static SimulationData build(String name, Date datetime, Integer val) {
        return new SimulationData(name, datetime, val);
    }

}
