package com.example.manageinfomationoffoodanddrink;

import java.util.List;

public class ParentModelClass {
    String tittle;
    List<ChildModelClass> childModelClassList;

    public ParentModelClass(String tittle, List<ChildModelClass> childModelClassList) {
        this.tittle =tittle;
        this.childModelClassList= childModelClassList;
    }
}
