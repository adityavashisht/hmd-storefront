package com.halalmeatdepot.domain.design.tpsc;

import java.util.Date;

/**
 * Created by vashishta on 9/6/16.
 */
public class Activity {

    private Long id;
    private Date createDate;
    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}