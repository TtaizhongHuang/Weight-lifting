package se329.com.weight_lifting;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by valbi_000 on 3/22/2016.
 */
public class NetworkManager {
    private static final String TAG = "NetworkManager";
    private static NetworkManager instance = null;
    private static final String prefixURL = "http://10.0.2.2/workoutFold/";

    //for Volley API
    public RequestQueue requestQueue;

    /*
        Submit a context and a string for the constructor
        @param toCall is the string.php you want to call.
        Used later for URL
     */
    public NetworkManager(Context context, final String toCall, final String toQuery) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public static synchronized NetworkManager getInstance(Context context) {
        if (null == instance)
            instance = new NetworkManager(context, "notused.php", "notused.php");
        return instance;
    }

    //this is so you don't need to pass context each time
    public static synchronized NetworkManager getInstance() {
        if (null == instance) {
            throw new IllegalStateException(NetworkManager.class.getSimpleName() +
                    " is not initialized, call getInstance(...) first");
        }
        return instance;
    }

    /*
        Constructor used to create a network connection
        @param param1
            A string used to submit data type for the POST requirement

        @param listener
            A listener used to do x apon response from the request.
     */
    public void asyncronousCall(String callphp, final Map<String, String> queryParams, final ServerResponseListener<String> listener) {

        String url = prefixURL + callphp;
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG + ": ", "somePostRequest Response : " + response.toString());

                        if (null != response.toString())
                            listener.getResult(response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (null != error.networkResponse) {
                            Log.d(TAG + ": ", "Error Response code: " + error.networkResponse.statusCode);

                        }
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                /*
                Use this format for the entering for param1 as a string.
                "{\"email\":\"" + "springn@iastate.edu" + "\",\"password\":\"" + nick + "\"}");
                 */

                return queryParams;
            }
        };
//        request.getCacheKey();
        requestQueue.add(request);
    }

    public void syncronousCall(String callphp, final Map<String, String> queryParams, final ServerResponseListener<String> listener) {
        final Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (null != error.networkResponse) {
                    Log.d(TAG + ": ", "Error Response code: " + error.networkResponse.statusCode);

                }
            }
        };
        final RequestFuture<String> future = RequestFuture.newFuture();
        String url = prefixURL + callphp;
        StringRequest request = new StringRequest(Request.Method.POST, url, future
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.d(TAG + ": ", "somePostRequest Response : " + response.toString());
//
//                        if(null != response) {
//
//                        }
//                    }
//                }
                , errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                /*
                Use this format for the entering for param1 as a string.
                "{\"email\":\"" + "springn@iastate.edu" + "\",\"password\":\"" + nick + "\"}");
                 */

                return queryParams;
            }
        };
//        request.getCacheKey();
        requestQueue.add(request);
        try {
            listener.getResult(future.get(10, TimeUnit.SECONDS));
        } catch (Exception e) {
            errorListener.onErrorResponse(new VolleyError(e));
        }
    }
}

