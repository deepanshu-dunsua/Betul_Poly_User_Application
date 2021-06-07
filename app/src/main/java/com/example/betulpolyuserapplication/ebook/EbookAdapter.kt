package com.example.betulpolyuserapplication.ebook

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.betulpolyuserapplication.R

class EbookAdapter : RecyclerView.Adapter<EbookAdapter.EbookViewHolder> {

    private lateinit var context: Context
    private lateinit var list: ArrayList<EbookData>

    constructor()


    constructor(context: Context, list: ArrayList<EbookData>) : super() {
        this.context = context
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EbookViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout, parent, false)
        return EbookViewHolder(view)
    }

    // binding data
    override fun onBindViewHolder(holder: EbookViewHolder, position: Int) {

        // get ist postion on variable and call aganin and again
        val currentPdf=list[position]

        // get and set data to my view
        holder.ebookName.text = currentPdf.title

        //download pdf view in other activity
        holder.itemView.setOnClickListener {
//            Toast.makeText(context!!, "${currentPdf.name}", Toast.LENGTH_SHORT).show()
            val intent=Intent(context!!,PdfViewerActivity::class.java)
            intent.putExtra("pdfUrl",currentPdf.url)
            context.startActivity(intent)

        }

        //ebook download url code on firbase
        holder.ebookDownloadUrl.setOnClickListener {
//            Toast.makeText(context!!, "Download..", Toast.LENGTH_SHORT).show()
            val intent=Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(currentPdf.url))
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class EbookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // variable decleare
        val ebookName = itemView.findViewById<TextView>(R.id.ebookName) as TextView
        val ebookDownloadUrl = itemView.findViewById<ImageView>(R.id.ebookDownload) as ImageView

    }

}