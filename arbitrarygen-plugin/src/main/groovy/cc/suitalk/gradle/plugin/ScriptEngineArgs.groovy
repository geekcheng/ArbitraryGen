package cc.suitalk.gradle.plugin

import groovy.json.JsonBuilder
//import org.gradle.internal.impldep.com.google.gson.JsonObject

class ScriptEngineArgs implements Serializable {

    boolean enable;
    String[] format;
    String src;
    String dest;
    String coreLibs;
    String templateLibs;

    public ScriptEngineArgs() {
        enable = true;
        format = new String[0];
        src = "";
        dest = "";
        coreLibs = "";
        templateLibs = "";
    }

    public String getName() {
        return "scriptEngine"
    }
//
//    public JsonObject toJson() {
//        JsonObject json = new JsonObject();
//        json.addProperty("enable", enable);
//        json.addProperty("format", format);
//        json.addProperty("src", src);
//        json.addProperty("dest", dest);
//        json.addProperty("coreLibs", coreLibs);
//        json.addProperty("templateLibs", templateLibs);
//        return json;
//    }
//
//    public JsonBuilder toJsonBuilder() {
//        JsonBuilder builder = new JsonBuilder();
////        builder {
////            enable: enable
////            format: format
////            src: src
////            dest: dest
////            coreLibs: coreLibs
////            templateLibs: templateLibs
////        }
//
//        builder.enable enable
//        builder.format format
//        builder.src src
//        builder.dest dest
//        builder.coreLibs coreLibs
//        builder.templateLibs templateLibs
//
//        return builder;
//    }
}