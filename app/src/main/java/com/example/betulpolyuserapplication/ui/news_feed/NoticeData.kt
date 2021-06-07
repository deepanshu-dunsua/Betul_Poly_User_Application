package com.example.betulpolyuserapplication.ui.news_feed


class NoticeData {
    var title: String? = null
    var image: kotlin.String? = null
    var date: kotlin.String? = null
    var time: kotlin.String? = null
    var key: kotlin.String? = null

    constructor()
    constructor(title: String?, image: String?, date: String?, time: String?, key: String?) {
        this.title = title
        this.image = image
        this.date = date
        this.time = time
        this.key = key
    }




}

// this class get upload notie data and communicate to upload notice data to send firbasse ..