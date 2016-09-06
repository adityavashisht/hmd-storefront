package com.halalmeatdepot.domain.design;

/**
 * Created by vashishta on 9/6/16.
 */
public class DownActivity extends Activity {

    private String name;
    private boolean signal;

    public boolean isSignal() {
        return signal;
    }

    public void setSignal(boolean signal) {
        this.signal = signal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
