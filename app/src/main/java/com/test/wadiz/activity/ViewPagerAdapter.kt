package com.test.wadiz.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * Created on 2022-09-01
 */
class ViewPagerAdapter(
    private val fragmentManager : FragmentManager,
    private val lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    private val fragments = mutableListOf<Fragment>()

    fun addFragment(fragment : Fragment) {
        fragments.add(fragment)
        notifyItemInserted(fragments.size - 1)
    }
}