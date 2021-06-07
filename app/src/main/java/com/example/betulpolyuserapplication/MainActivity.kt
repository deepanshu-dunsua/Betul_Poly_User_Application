package com.example.betulpolyuserapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.betulpolyuserapplication.developer.DeveloperActivity
import com.example.betulpolyuserapplication.ebook.EbookActivity
import com.example.betulpolyuserapplication.ui.about_us.AboutUsFragment
import com.example.betulpolyuserapplication.ui.faculity.FaculityFragment
import com.example.betulpolyuserapplication.ui.gallery.GalleryFragment
import com.example.betulpolyuserapplication.ui.home.HomeFragment
import com.example.betulpolyuserapplication.ui.news_feed.NewsFeedFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // fragment initalization
    private var homeFragment = HomeFragment()
    private var newsFeedFragment = NewsFeedFragment()
    private var faculityFragment = FaculityFragment()
    private var galleryFragment = GalleryFragment()
    private var aboutUsFragment = AboutUsFragment()


    // data bind
    private lateinit var bottomn_nav: BottomNavigationView

    private val TAG = "Permission"
    private val REQUEST_RECORD_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))

//navigtion item on clik event
        navigation_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_navigation_video_lecture -> {
//                    Toast.makeText(this, "video clik", Toast.LENGTH_SHORT).show()
                    val urlString: String = "https://youtube.com/channel/UCl2qhpF-PdgpxuXWTschqDQ"
                    gotoUrl(urlString)
                }
                R.id.ic_navigation_ebook -> {
//                    Toast.makeText(this, "theme clik ...", Toast.LENGTH_SHORT).show()
                    ebookIntent()//fuction  calling
                }
                // theme ->to change cpvid info
                R.id.ic_navigation_theme -> {
//                    Toast.makeText(this, "theme clik ...", Toast.LENGTH_SHORT).show()
                    val urlString: String = "https://www.cowin.gov.in"
                    gotoUrl(urlString)
                }
                R.id.ic_navigation_website -> {
//                    Toast.makeText(this, "webiste", Toast.LENGTH_SHORT).show()
                    val urlString: String = "https://www.rgpvdiploma.in"
                    gotoUrl(urlString)
                }
                R.id.ic_navigation_share -> {
//                    Toast.makeText(this, "share clik", Toast.LENGTH_SHORT).show()
                    shareIntent()
                }
                R.id.ic_rateus -> {
//                    Toast.makeText(this, "rete us clik", Toast.LENGTH_SHORT).show()
                    rateUsIntent()
                }
                R.id.ic_developer -> {
//                    Toast.makeText(this, "develpoer clik", Toast.LENGTH_SHORT).show()
                    developerIntent()
                }
            }
            true
        }

        val drawerToggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // bottom navigation code here
        replaceFragment(homeFragment)
        bottomn_nav = bottom_navigation
        bottomn_nav.setOnNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_news -> replaceFragment(newsFeedFragment)
                R.id.ic_faculity -> replaceFragment(faculityFragment)
                R.id.ic_gallery -> replaceFragment(galleryFragment)
                R.id.ic_aboutus -> replaceFragment(aboutUsFragment)

            }

            true
        }


        //set permisssion method calling
        setPermission()




    }

    //  checkpermission funcation like storage audieo ,video
    fun setPermission() {
        // ask permission
        val permission = ContextCompat.checkSelfPermission(
            this,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
        if (permission != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission Denied..", Toast.LENGTH_SHORT).show()
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                android.Manifest.permission.INTERNET
            )
        ) {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Permission to access the Externnal Storage is required for this app to store data and Images")
            builder.setTitle("Permission Required")
            builder.setPositiveButton("ok") {

                    dialog, which ->
                Log.d(TAG, "cliked")
            }
            val dialog = builder.create()
            dialog.show()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                REQUEST_RECORD_CODE
            )

        }

    }


    // check permission on method  override ..
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_RECORD_CODE -> {
                if (grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Log.d(TAG,"Permission has been denied by user")

                } else {
                    Log.d(TAG,"Permission has been granted by user")

                }
            }
        }

    }


    // thias method oprn url in my appp
    private fun gotoUrl(url: String) {
        val uri: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    // developer intent open developer activity
    private fun developerIntent() {
        val intent = Intent(this@MainActivity, DeveloperActivity::class.java)
        startActivity(intent)
    }

    // rate us intent  btn onclik event
    private fun rateUsIntent() {
        val uri: Uri =
            Uri.parse("https://play.google.com/store/apps/details?id=${applicationContext.packageName}")
        val i = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(i)
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this@MainActivity, "Unable to open \n ${e.message}", Toast.LENGTH_SHORT)
                .show()
        }

    }


    // naviagtion share funcation share btn onclik event
    private fun shareIntent() {
        try {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Betul Poly ")
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "https://play.google.com/store/apps/details?id=${applicationContext.packageName}"
            )
            startActivity(Intent.createChooser(intent, "Share with us"))
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this@MainActivity, "Unable to share this app ..", Toast.LENGTH_SHORT)
                .show()
        }
    }


    //     this fucation  method intent go to onclik ebook activity
    private fun ebookIntent() {
        val intent = Intent(this@MainActivity, EbookActivity::class.java)
        startActivity(intent)
    }


    // mobile back btn press and -> exit to app
    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else if (bottomn_nav.selectedItemId == R.id.ic_home) {
            super.onBackPressed()
            finish()//exit app

        } else {
            bottomn_nav.selectedItemId = R.id.ic_home

        }
//        else {
//            super.onBackPressed()
//        }
//

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when (item.itemId) {
            android.R.id.home -> {
                drawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // replacement fragment method
    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transcation = supportFragmentManager.beginTransaction()
            transcation.replace(R.id.hostfragment_container, fragment)
            transcation.commit()
        }
    }


}

