package com.example.estatapi

import android.os.AsyncTask
import android.os.Build
import androidx.annotation.RequiresApi
import org.json.JSONException
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class ApiTask(): AsyncTask<String, String, String?>(){
    lateinit var iCallbackTask: ICallbackTask

    @RequiresApi(Build.VERSION_CODES.N)
    override fun doInBackground(vararg params: String?): String? {
        // ここでAPIを叩く
        var connection: HttpURLConnection? = null
        var reader: BufferedReader? = null
        val buffer: StringBuffer

        try {
            // param[0]にはAPIのURI(String)を入れる
            // AsynkTask<...>の一つめがStringなのはURIをStringで指定するから
            val url = URL(params[0])
            connection = url.openConnection() as HttpURLConnection
            connection.connect()


            // 取得した文字をbufferに
            val stream = connection.inputStream
            reader = BufferedReader(InputStreamReader(stream))
            buffer = StringBuffer()
            var line: String?
            while (true) {
                line = reader.readLine()
                if (line == null) {
                    break
                }
                buffer.append(line)
                //Log.d("CHECK", buffer.toString())
            }

            // 先ほどbufferに入れた、取得した文字列
            return buffer.toString()

            // ここから下は、接続エラーとかJSONのエラーとかで失敗した時にエラーを処理するため。
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        // 接続を切断
        finally {
            connection?.disconnect()
            try {
                reader?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return null
    }


    // 返ってきたデータをビューに反映させる処理はonPostExecuteに書く。
    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        if(result == null) return

        iCallbackTask.callback(result)
    }

    fun setOnCallback(iCallbackTask: ICallbackTask) {
        this.iCallbackTask = iCallbackTask
    }

    interface ICallbackTask {
        fun callback(result: String)
    }
}