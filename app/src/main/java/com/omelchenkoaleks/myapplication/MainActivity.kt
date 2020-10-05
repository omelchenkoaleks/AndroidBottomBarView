package com.omelchenkoaleks.myapplication

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.skydoves.androidbottombar.AndroidBottomBarView
import com.skydoves.androidbottombar.BottomMenuItem
import com.skydoves.androidbottombar.OnBottomMenuInitializedListener
import com.skydoves.androidbottombar.OnMenuItemSelectedListener

class MainActivity : AppCompatActivity() {

    private lateinit var mAndroidBottomBarView: AndroidBottomBarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAndroidBottomBarView = findViewById(R.id.bottom_bar)

        setupMenu()
    }

    private fun setupMenu() {
        val bottomMenuItemList = mutableListOf<BottomMenuItem>()

        bottomMenuItemList.add(createMenuWithBadge("Home", "New", R.drawable.ic_home))
        bottomMenuItemList.add(createMenu("Favorites", R.drawable.ic_favorite))
        bottomMenuItemList.add(createMenu("Search", R.drawable.ic_search))
        bottomMenuItemList.add(createMenuWithBadge("Friend", "99+", R.drawable.ic_person_add))

        // Add to menu
        mAndroidBottomBarView.addBottomMenuItems(bottomMenuItemList)

        // Init menu
        mAndroidBottomBarView.setOnBottomMenuInitializedListener {
            OnBottomMenuInitializedListener {
                mAndroidBottomBarView.showBadge(0)
                mAndroidBottomBarView.showBadge(3)
            }
        }

        // Event
        mAndroidBottomBarView.setOnMenuItemSelectedListener(OnMenuItemSelectedListener { index, bottomMenuItem, fromUser ->
            if (fromUser) {
                mAndroidBottomBarView.dismissBadge(index)
                Toast.makeText(this, "${bottomMenuItem.titleForm.title}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun createMenu(title: String, resource: Int): BottomMenuItem {
        return BottomMenuItem(this)
            .setTitle(title)
            .setTitleColorRes(android.R.color.black)
            .setTitleActiveColorRes(android.R.color.holo_red_dark)
            .setIcon(resource)
            .setIconSize(30)
            .setIconColorRes(android.R.color.black)
            .setIconActiveColorRes(android.R.color.holo_red_dark)
            .build()
    }

    private fun createMenuWithBadge(title: String, badge: String, resource: Int): BottomMenuItem {
        return BottomMenuItem(this)
            .setTitle(title)
            .setTitleColorRes(android.R.color.black)
            .setTitleActiveColorRes(android.R.color.holo_red_dark)
            .setIcon(resource)
            .setIconSize(30)
            .setIconColorRes(android.R.color.black)
            .setIconActiveColorRes(android.R.color.holo_red_dark)
            .setBadgeText(badge)
            .setBadgeTextSize(9f)
            .setBadgeTextColorRes(android.R.color.white)
            .setBadgeColorRes(R.color.badge)
            .setBadgeStyle(Typeface.BOLD)
            .setBadgePadding(6)
            .setBadgeMargin(4)
            .setBadgeRadius(6)
            .build()
    }
}