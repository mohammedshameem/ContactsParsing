package com.mohammed.shameem.contactsparsing.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.mohammed.shameem.contactsparsing.R;
import com.mohammed.shameem.contactsparsing.controller.UserDetailsAdapter;
import com.mohammed.shameem.contactsparsing.holder.UserHolder;

import java.io.ByteArrayInputStream;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView lvUserList;
    List<UserHolder> userHolder_Object;
    String URL_TO_PARSE = "http://jsonplaceholder.typicode.com/users";
    final Gson gson = new Gson();
    final AsyncHttpClient client = new AsyncHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvUserList = (ListView) findViewById(R.id.contactList);
        client.get(MainActivity.this, URL_TO_PARSE, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String jsonresponse = String.valueOf(new ByteArrayInputStream(responseBody));
                //jsonresponse.toString();
                /*jsonresponse = jsonresponse.substring(2);
                jsonresponse = jsonresponse.substring(0, jsonresponse.length() - 2);*/
                UserHolder[] userHolder = gson.fromJson(jsonresponse, UserHolder[].class);
                for (UserHolder uh : userHolder_Object) {
                    userHolder_Object.add(uh);
                }

                lvUserList.setAdapter(new UserDetailsAdapter(MainActivity.this, userHolder_Object));

             /*   Gson gson = new Gson();
                String jsonOutput = "Your JSON String";
                Type listType = new TypeToken>(){}.getType();
                List posts = (List) gson.fromJson(jsonOutput, listType);
*/
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
