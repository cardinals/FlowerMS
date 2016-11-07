package cn.coselding.flowerms.model;

import cn.coselding.flowerms.utils.Global;

/**
 * Created by 宇强 on 2016/8/15 0015.
 */
public class SpringTest implements Cloneable {

    private Object object = new Object();
    private int i;

    public SpringTest() {
    }

    public SpringTest(Object object, int i) {
        this.object = object;
        this.i = i;
    }

    public SpringTest clone() throws CloneNotSupportedException {
        super.clone();
        return new SpringTest(new Object(), i);
    }

    @Override
    public String toString() {
        return "SpringTest{" +
                "object=" + object +
                ", i=" + i +
                '}';
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
