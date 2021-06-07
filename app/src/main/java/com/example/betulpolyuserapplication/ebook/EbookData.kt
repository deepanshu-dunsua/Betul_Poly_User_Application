package com.example.betulpolyuserapplication.ebook

class EbookData {

        internal lateinit var title:String
        internal lateinit var url:String

    constructor()
    constructor(title: String , url: String) {
        this.title = title
        this.url = url
    }


}