package me.aronne.app.api;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TokenUtil {

    public static String getTokenCount(String text) {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        try {
//            engine.eval(Files.readString(Paths.get("src/main/resources/js/encoder.js")));
            engine.eval(Files.newBufferedReader(Paths.get("src/main/resources/js/encoder.js"), StandardCharsets.UTF_8));
            Invocable invocable = (Invocable) engine;
            return (String) invocable.invokeFunction("encode", text);
        } catch (Exception e) {
            e.printStackTrace();
            return "its broken";
        }
    }

//    // read script file
//    engine.eval(Files.newBufferedReader(Paths.get("C:/Scripts/Jsfunctions.js"), StandardCharsets.UTF_8));
//
//    Invocable inv = (Invocable) engine;
//    // call function from script file
//    inv.invokeFunction("yourFunction", "param");
}
