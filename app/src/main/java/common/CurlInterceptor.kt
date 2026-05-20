package common

import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer
import java.io.IOException

class CurlInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val curlCmd = StringBuilder("curl -X ${request.method}")

        val headers = request.headers
        for (i in 0 until headers.size) {
            curlCmd.append(" -H \"${headers.name(i)}: ${headers.value(i)}\"")
        }

        request.body?.let { body ->
            try {
                val buffer = Buffer()
                body.writeTo(buffer)

                // Use clone to avoid exhausting the buffer if needed
                val charset = body.contentType()?.charset(Charsets.UTF_8) ?: Charsets.UTF_8
                curlCmd.append(" --data '${buffer.readString(charset)}'")
            } catch (e: IOException) {
                curlCmd.append(" --data '[error parsing body]'")
            }
        }

        curlCmd.append(" \"${request.url}\"")

        // Log using a proper tag for Logcat
        android.util.Log.d("CurlInterceptor", curlCmd.toString())

        return chain.proceed(request)
    }
}
