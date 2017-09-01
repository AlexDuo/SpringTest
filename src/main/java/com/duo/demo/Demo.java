package com.duo.demo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @Author DuoZhang
 * @Date UTC 2017/8/31 13:22
 * @ProjectName SpringTest
 * @PackageName com.duo.demo
 */
/*这是一个测试实体类
声明试题中应有的变量类型
然后对各个变量声明Get 和 Set 方法
* */
/*我在此处添加了多行注释*/
public class Demo {
    private int id;
    private String name;
    private Date createTime;
    /*如果现在的需求是我们不想返回 remarks 我们可以通过设置@JsonField中的serialize 属性来进行实现
    serialize 是否需要序列化属性
    * */
    @JSONField(serialize = false)
    private String remarks;




    @JSONField(format = "yyyy-MM-dd HH:mm")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
