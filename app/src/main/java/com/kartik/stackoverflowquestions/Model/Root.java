package com.kartik.stackoverflowquestions.Model;

import java.util.List;

public class Root {
    public List<MyListData> getItems() {
        return this.items; }
    public void setItems(List<MyListData> items) {
        this.items = items; }
    List<MyListData> items;
}
