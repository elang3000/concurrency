package com.youyd.imooc.concurrency.test.publish;

import com.youyd.imooc.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
@NotThreadSafe
public class Escape {
    private int thisCanBeEscape=0;

    public Escape(){

    }

    private class InnerClass{
        public InnerClass(){
          System.out.println("{}"+Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
