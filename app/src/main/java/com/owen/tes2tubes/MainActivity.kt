package com.owen.tes2tubes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.owen.tes2tubes.fragments.AkunFragment
import com.owen.tes2tubes.fragments.BerandaFragment
import com.owen.tes2tubes.fragments.BookmarkFragment
import com.owen.tes2tubes.fragments.PesananFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val berandaFragment=BerandaFragment()
        val pesananFragment=PesananFragment()
        val bookmarkFragment=BookmarkFragment()
        val akunFragment=AkunFragment()

        setCurrentFragment(BookmarkFragment())

        val bottom_navigation : BottomNavigationView = findViewById(R.id.bottom_navigation)

            bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_beranda->setCurrentFragment(berandaFragment)
                R.id.ic_pesanan->setCurrentFragment(pesananFragment)
                R.id.ic_bookmark->setCurrentFragment(bookmarkFragment)
                R.id.ic_akun->setCurrentFragment(akunFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}