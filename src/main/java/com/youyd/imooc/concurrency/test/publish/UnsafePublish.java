package com.youyd.imooc.concurrency.test.publish;

import com.youyd.imooc.concurrency.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
class UnsafePublish {
    private String[] states={"a","b","c"};

    public String[] getStates(){
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish=new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0]="d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

    }
}
