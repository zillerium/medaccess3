package com.example.medaccess3;

import android.os.AsyncTask;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class PrescriptionData extends AsyncTask<Integer, Void, Void> {
    public String data="";
    String dataParsed=""; // comment
    String ownerJO = "";

    String joText = "";
    String joImage = "";
    int thisTokenId=0;
    //  String ipfsText = joText.getString();

    @Override
    protected Void doInBackground(Integer... parms) {
        try {
            URL url;
            //JSONObject urlParameters = new JSONObject();
            //urlParameters.put("tokenId", 123);
            int tokenId = parms[0].intValue();
            thisTokenId=tokenId;


            String urlParameters = "{\n" + "\"tokenId\":" +tokenId+"\r\n}";

            url = new URL("http://142.93.36.96:3000/api/ping");
           // url = new URL("https://api.todaqfinance.net/files/e124eb86ff56fd6c2693bc0cbc529ddb88216d60130d8f305eb87f44fd9b66c0");

        //   https://infinite-castle-46361.herokuapp.com/aliceall

         // url = new URL("https://infinite-castle-46361.herokuapp.com/aliceall");

            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            //  httpURLConnection.setRequestProperty("Content-Type",
            //        "application/raw");

           httpURLConnection.setRequestProperty("Content-Type", "application/json");

          //  httpURLConnection.setRequestProperty("Content-Type", "text/plain; charset=utf-8");

            //  httpURLConnection.setRequestProperty("Content-Length", "" +
            //         Integer.toString(urlParameters.toString().getBytes().length));
            httpURLConnection.setRequestProperty("Content-Language", "en-US");


            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
String input = "test";
         //   OutputStream out = new BufferedOutputStream(httpURLConnection.getOutputStream());
          //  writeStream(out);
            OutputStream wr =
                      httpURLConnection.getOutputStream();
//            wr.writeBytes(URLEncoder.encode(urlParameters.toString(),"UTF-8"));
           //   wr.write(urlParameters.getBytes());
               wr.flush();
                wr.close();


            int status = httpURLConnection.getResponseCode();

            InputStream inputStream=httpURLConnection.getInputStream();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line = bufferedReader.readLine();
                while (!TextUtils.isEmpty(line)) {
                    data += line;
                    line = bufferedReader.readLine();
                }




                JSONObject JO = new JSONObject(data);
               ownerJO = JO.getString("data");
             //   String date = JO.getJSONObject("payload").getString("date");
             //  Gson gson = new Gson();
               // JsonObject js = gson.fromJson(bufferedReader, JsonObject.class)

int h=103;
                //   "data": [
             //   {
             //       "type": "file",
              //          "id": "e124eb86ff56fd6c2693bc0cbc529ddb88216d60130d8f305eb87f44fd9b66c0",
              //          "attributes": {
              //      "payload": {
              //          "id": "1a3c1e04-ab62-4c44-b4a3-873f5d50c07d",
              //                  "date": "9 March 2019",
               //                 "type": "diagnosis",
               //                 "dosage": "1 tablet per day",
                //                "treatment": "Atovaquone plus proguanil",
                //                "description": "malaria",
                //                "prescription": "30 tablets"


               //JSON.parse(ownerJO);
            //    JSONArray ipfsJA = JO.getJSONArray("ipfsdata");
            //    joText = ipfsJA.getString(0);
            //    joImage = ipfsJA.getString(1);
                //  String ipfsText = joText.getString();
                int j=1;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        String displayData = "Processing TokenId - " + data + "\n" +
                "Owner - " + ownerJO + "\n";
        //    "Text - " + joText + "\n" +
        //    "image - " + joImage;
        MainActivity.tv.setText(displayData);
        //    MainActivity.tvIpfsTextUrl.setText(joText);




        int g=1;

    }
}