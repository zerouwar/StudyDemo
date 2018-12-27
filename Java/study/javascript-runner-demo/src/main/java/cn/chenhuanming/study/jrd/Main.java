package cn.chenhuanming.study.jrd;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.*;
import java.util.Arrays;

/**
 * @author chenhuanming
 * Created at 2018/6/7
 */
public class Main {
    public static void main(String[] args) throws Exception {
        V8 v8 = V8.createV8Runtime();
        int r = v8.executeIntegerScript("const a = i => i + 1\n" +
                "a(2)");

        System.out.println(r);

        JavaCallback callback = new JavaCallback() {
            @Override
            public Object invoke(V8Object receiver, V8Array parameters) {
                if(parameters.length()>0){
                    return "args = " + parameters.toString();
                }else{
                    return "no args";
                }
            }
        };

        v8.registerJavaMethod(callback,"args");
        String result = v8.executeStringScript("args(1,2,3,4)");
        System.out.println(result);
    }
}
