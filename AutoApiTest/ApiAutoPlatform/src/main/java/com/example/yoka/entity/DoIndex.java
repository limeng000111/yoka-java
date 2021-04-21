package com.example.yoka.entity;

import java.util.List;

/**
 * @author:jack
 * @date 2021/4/19 14:47
 * @des:todo
 */
public class DoIndex {
    private int requestIndex;
    private int controllerIndex;
    private List<AssertResult> assertResultList;

    public int getRequestIndex() {
        return requestIndex;
    }

    public void setRequestIndex(int requestIndex) {
        this.requestIndex = requestIndex;
    }

    public int getControllerIndex() {
        return controllerIndex;
    }

    public void setControllerIndex(int controllerIndex) {
        this.controllerIndex = controllerIndex;
    }

    public List<AssertResult> getAssertResultList() {
        return assertResultList;
    }

    public void setAssertResultList(List<AssertResult> assertResultList) {
        this.assertResultList = assertResultList;
    }
}
