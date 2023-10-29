package com.example.loginsignupauth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.widget.ImageView



class MainActivity : AppCompatActivity() {

    data class YourResponseClass(
        val strings: List<String>
    )
    data class RecommendationsResponse(val recommendations: List<String>)



    fun sendPostRequest(userName:String, password:String) {

        var reqParam = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8")
        reqParam += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8")
        val mURL = URL("<Your API Link>")

        with(mURL.openConnection() as HttpURLConnection) {
            // optional default is GET
            requestMethod = "POST"

            val wr = OutputStreamWriter(getOutputStream());
            wr.write(reqParam);
            wr.flush();

            println("URL : $url")
            println("Response Code : $responseCode")

            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()

                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }
                println("Response : $response")
            }
        }
    }
    interface ApiService {
        @POST("/recommend")
        fun postRecommendation(@Body body: Map<String, String>): Call<ResponseBody>

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BASE_URL = "https://atharvagupta.pythonanywhere.com";


        val text1: EditText = findViewById(R.id.editTextText)
        val text2: EditText = findViewById(R.id.editTextText2)
        val text3: EditText = findViewById(R.id.editTextText3)

        val loginbtn: Button = findViewById(R.id.button2)

        val apiService = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


        loginbtn.setOnClickListener {
            loginbtn.text = "Damn"
            Log.d("MainActivity", "Requesting URL: $BASE_URL")


            val str1 = text1.text.toString()
            val str2 = text2.text.toString()
            val str3 = text3.text.toString()
            val body = mapOf(
                "user-budget" to "$str1",
                "user-month" to "$str2",
                "user-input" to "$str3"
            )

            apiService.postRecommendation(body).enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful) {
                        val responseString = response.body()?.string()


                        if (responseString != null) {
                            Log.d("Success", responseString)

                            val json = JSONObject(responseString)

                            val string1 = json.getJSONArray("recommendations").get(0) as String
                            val string2 = json.getJSONArray("recommendations").get(1) as String
                            val string3 = json.getJSONArray("recommendations").get(3) as String
                            val string4 = json.getJSONArray("recommendations").get(4) as String
                            val string5 = json.getJSONArray("recommendations").get(6) as String
                            val string6 = json.getJSONArray("recommendations").get(7) as String


                            Log.d("Strings", string1)

                            val intent = Intent(this@MainActivity, RecommendedActivity::class.java)
                            intent.putExtra("string1", string1)
                            intent.putExtra("string2", string2)
                            intent.putExtra("string3", string3)
                            intent.putExtra("string4", string4)
                            intent.putExtra("string5", string5)
                            intent.putExtra("string6", string6)
                            startActivity(intent)
                            finish()

                        } else {
                            // Handle the case where the response body is null
                            Log.d("Success", "Response body is null")
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.d("Fail", t.message.toString())

                }
            })
        }
    }
}

