package com.example.nic;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestHandler extends AsyncTask<String , String, String> {
    public String output;
    public static int key = 0;
    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL("https://97uddyc9vk.execute-api.us-east-1.amazonaws.com/tset/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type","application/json");
            httpURLConnection.setRequestProperty("Accept","application/json");
            Writer writer = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream()));
            if(Home.key.equals("insert"))
            {
                JSONObject data = new JSONObject();
                data.put("action", Home.key);
                data.put("CaseNo",strings[0]);
                data.put("CaseDetails",strings[1]);
                data.put("HearingDate",strings[2]);
                data.put("CaseStatus",strings[3]);
                writer.write(data.toString());
                writer.close();
                InputStream ir = httpURLConnection.getInputStream();
                BufferedReader input =  new BufferedReader(new InputStreamReader(ir));
                output = input.readLine();
               // Log.e("Output", "out :"+output);

            }
            else if(Home.key.equals("fetch"))
            {
                JSONObject data = new JSONObject();
                data.put("action", Home.key);
                data.put("CaseNo",strings[0]);
                writer.write(data.toString());
                writer.close();
                InputStream ir = httpURLConnection.getInputStream();
                BufferedReader input =  new BufferedReader(new InputStreamReader(ir));
                String line = " ";
                while(line != null)
                {
                    line = input.readLine();
                    output = output+line;
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(output.equals("\"0\""))
        {
            Toast.makeText(Admin_Home.adminHome,"Data Successfully Stored",Toast.LENGTH_LONG).show();
            ((Admin_Home) Admin_Home.adminClose).finish();
        }
        else
        {
            User_Home.caseNumber.setText(output);
        }
    }
}
