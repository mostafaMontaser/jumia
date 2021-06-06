package com.code.jumia.util.parsing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;


public class ParsingHelper {

    private static Gson gson;

    public static Gson getGson() {
        if (gson == null) {
            final GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(CharSequence.class, new CharSequenceDeserializer());
            gson = gsonBuilder.create();
        }
        return gson;
    }

    public static <T> T jsonParsing(String string, Class<T> tClass) {
        try {
            return getGson().fromJson(string, tClass);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

//    public static <T> T xmlParsing(String string, Class<T> tClass, String tag) {
//        T object = null;
//        Serializer serializer = new Persister();
//        try {
//            object = serializer.read(tClass, string);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.e(tag, "Error in parse XML class");
//        }
//        return object;
//    }
//
    static class CharSequenceDeserializer implements JsonDeserializer<CharSequence> {
        @Override
        public CharSequence deserialize(JsonElement element, Type type,
                                        JsonDeserializationContext context) throws JsonParseException {
            return (element.getAsString());
        }
    }
}