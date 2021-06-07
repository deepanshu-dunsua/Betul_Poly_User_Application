package com.example.betulpolyuserapplication.ebook

import android.os.AsyncTask
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.betulpolyuserapplication.R
import com.github.barteksc.pdfviewer.PDFView
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class PdfViewerActivity : AppCompatActivity() {

    //variable declearation
    private lateinit var url: String
    private lateinit var pdfView: PDFView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer)

        //action Bbar
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title = "Pdf Viewwere"

        // get data in ebook adapteer
        url = intent.getStringExtra("pdfUrl")

        //find element
        pdfView = findViewById(R.id.pdfView)
        progressBar=findViewById(R.id.progressBar)

        //async task perform work background and publish datat ui
        PdfDownload(pdfView).execute(url)

    }


     inner class PdfDownload(val pdfView: PDFView) : AsyncTask<String, Unit, InputStream>() {

        //overid methid
        override fun doInBackground(vararg params: String?): InputStream {
            var inputStream: InputStream? = null

            try {
                val url = URL(params[0])
                val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
                if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                    inputStream = BufferedInputStream(urlConnection.inputStream)
                }else
                {
                    println("ERROR ${urlConnection.responseCode}")
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }

            return inputStream!!
        }

        override fun onPostExecute(result: InputStream?) {
            pdfView.fromStream(result).load()
        }

    }
}