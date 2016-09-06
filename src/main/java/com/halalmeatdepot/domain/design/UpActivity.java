package com.halalmeatdepot.domain.design;

import java.util.Date;

/**
 * Created by vashishta on 9/6/16.
 */
public class UpActivity extends Activity {

    private String name;
    private Date selectDate;

    public Date getSelectDate() {
        return selectDate;
    }

    public void setSelectDate(Date selectDate) {
        this.selectDate = selectDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
