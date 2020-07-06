package com.rei.sdet.homework;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Utils {
  public static Map<String, String> getDictionaryFromService(String uri) {
    Gson gson = new Gson();
    Map<String, String> dictionay = new HashMap<String, String>();
    HttpResponse httpresponse;

    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpget = new HttpGet(uri);

    try {
      httpresponse = httpclient.execute(httpget);
      InputStream a = httpresponse.getEntity().getContent();

      Reader reader = new InputStreamReader(a, "UTF-8");

      Definition[] definitions = gson.fromJson(reader, Definition[].class);
      dictionay =
          Arrays.stream(definitions)
              .collect(Collectors.toMap(Definition::getWord, Definition::getDefinition));
    } catch (IOException e) {
      e.printStackTrace();
    } catch (UnsupportedOperationException e) {
      e.printStackTrace();
    } catch (JsonSyntaxException e) {
      e.printStackTrace();
    } catch (JsonIOException e) {
      e.printStackTrace();
    }
    return dictionay;
  }

  public static Map<String, String> getDictionaryFromFile(String filename) {
    Gson gson = new Gson();
    Map<String, String> dictionay = new HashMap<String, String>();

    try {
      FileReader reader = new FileReader(filename);
      Definition[] definitions = gson.fromJson(reader, Definition[].class);
      dictionay =
          Arrays.stream(definitions)
              .collect(Collectors.toMap(Definition::getWord, Definition::getDefinition));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return dictionay;
  }
}
