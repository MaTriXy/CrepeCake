package net.idik.crepecake.sample.aspect;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;

import net.idik.crepecake.annotation.Aspect;
import net.idik.crepecake.api.InvocationHandler;
import net.idik.crepecake.sample.MainActivity;
import net.idik.crepecake.sample.OActivity;

/**
 * Created by linshuaibin on 2017/12/28.
 */


@Aspect(MainActivity.class)
//@Aspect(OActivity.class)
public class ActivityAspect {

    protected void onCreate(InvocationHandler invocationHandler, Bundle savedInstanceState) {
        System.out.println("⇢ onCreate");
        long startTime = System.currentTimeMillis();
        invocationHandler.invoke(savedInstanceState);
        System.out.println(String.format("⇠ onCreate [%dms]", System.currentTimeMillis() - startTime));
    }

    protected void onStart(InvocationHandler invocationHandler) {
        System.out.println("onStart-------------------------");
        invocationHandler.invoke();
    }

    protected void onStop(InvocationHandler invocationHandler) {
        System.out.println("onStop-------------------------");
        invocationHandler.invoke();
    }

    public android.support.v7.app.ActionBar getSupportActionBar(InvocationHandler invocationHandler) {
        ActionBar bar = (ActionBar) invocationHandler.invoke();
        System.out.println("getActionBar---------------------------" + bar.toString());
        return bar;
    }

    private static boolean getHome(InvocationHandler invocationHandler, int o, float a, char b, long d, boolean e, byte f) {
        return (boolean) invocationHandler.invoke(o, a, b, d, e, f);
    }


}
