package com.cj.backfragment.ui.main

import android.R.attr.fragment
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.cj.backfragment.R
import com.cj.backfragment.adapter.AdapterPager
import com.cj.backfragment.fragment.chatfm.ChatFragment
import com.cj.backfragment.fragment.homefm.HomeFragment
import com.cj.backfragment.fragment.homefm.base.BaseHomeFragment
import com.cj.backfragment.fragment.newfm.NewFragment
import com.google.android.material.navigation.NavigationView
import com.uits.baseproject.base.BaseContainerFragment
import com.uits.baseproject.base.BaseFragment
import com.uits.baseproject.base.OnCurrentFragmentListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    OnCurrentFragmentListener {

    private var mActionBarDrawerToggle: ActionBarDrawerToggle? = null
    private lateinit var mToastExit: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTab()
        initNav()
        mToastExit = Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT)
    }

    private fun initNav() {
        setSupportActionBar(mToolbar)
        mToolbar.setTitle("Home")
        mNavigationView.setNavigationItemSelectedListener(this)
        mActionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            mDrawerLayout,
            mToolbar,
            R.string.open,
            R.string.close
        )
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle!!)
        mActionBarDrawerToggle!!.isDrawerIndicatorEnabled = true
        mActionBarDrawerToggle!!.syncState()

    }

    private fun initTab() {
        var mAdapterPager = AdapterPager(supportFragmentManager)
        mAdapterPager.addData(BaseHomeFragment(), "Home")
        mAdapterPager.addData(ChatFragment(), "Chat")
        mAdapterPager.addData(NewFragment(), "New")
        mViewPager.adapter = mAdapterPager
        mViewPager.offscreenPageLimit = 3
        mTabLayout.setupWithViewPager(mViewPager)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemHome -> {
                Toast.makeText(this, "Home", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.itemNew -> {
                Toast.makeText(this, "New", Toast.LENGTH_LONG).show()
                return true
            }
        }
        return false
    }

    override fun onBackFragment() {
//        val fragment: BaseContainerFragment = getCurrentFragment() as BaseContainerFragment
//        if (!fragment.popFragment()) {
//            val isExit: Boolean = mToastExit.getView()!!.isShown()
//            if (!isExit) {
//                mToastExit.show()
//            } else {
//                super.onBackPressed()
//            }
//        }
    }

    fun getCurrentFragment(): BaseFragment? {
        return supportFragmentManager.findFragmentById(R.id.mFrameContainer) as BaseFragment?
    }

    override fun onCurrentFragment(fragment: Fragment) {
        if (fragment is HomeFragment) {

        } else{
//            supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24)
        }
    }

    override fun onBackPressed() {
        val fm: FragmentManager = supportFragmentManager
        for (frag in fm.getFragments()) {
            if (frag.isVisible && mViewPager.currentItem == 0) {
                val childFm: FragmentManager = frag.childFragmentManager
                if (childFm.getBackStackEntryCount() > 0) {
                    childFm.popBackStack()
                    return
                }
            }
        }
        super.onBackPressed()
    }
}