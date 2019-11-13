package com.oliverstudio.roomconverterdemo.data.db.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.oliverstudio.roomconverterdemo.data.models.User;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class UsersConverterWithCompressing {

    private Gson mGson = new Gson();

    @TypeConverter
    public byte[] usersToString(List<User> followers) {
        Type type = new TypeToken<List<User>>() {}.getType();
        String jsonAsString = mGson.toJson(followers, type);

        try {
            return compress(jsonAsString);
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    @TypeConverter
    public List<User> stringToUsers(byte[] byteArray) {
        Type type = new TypeToken<List<User>>() {}.getType();
        String decompressed = "";

        try {
            decompressed = decompress(byteArray);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mGson.fromJson(decompressed, type);
    }

    private byte[] compress(String data) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length());
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        gzip.write(data.getBytes());
        gzip.close();
        byte[] compressed = bos.toByteArray();
        bos.close();
        return compressed;
    }

    private String decompress(byte[] compressed) throws IOException {
        ByteArrayInputStream bis;
        bis = new ByteArrayInputStream(compressed);
        GZIPInputStream gis;
        gis = new GZIPInputStream(bis);
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
        StringBuilder sb;
        sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        gis.close();
        bis.close();
        return sb.toString();
    }

}