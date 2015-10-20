package com.tylerjroach.materialdesignexample.adapter;

/**
 * Created by tylerjroach on 10/17/15.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tylerjroach.materialdesignexample.ui.ContactsFragment;
import com.tylerjroach.materialdesignexample.ui.MessagesFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

  public final int MESSAGES_FRAGMENT = 0;
  public final int CONTACTS_FRAGMENT = 1;

  public SectionsPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public Fragment getItem(int position) {

    Fragment pagerFragment = null;
    switch (position) {
      case MESSAGES_FRAGMENT:
        pagerFragment = MessagesFragment.newInstance();
        break;

      case CONTACTS_FRAGMENT:
        pagerFragment = ContactsFragment.newInstance();
        break;
    }
    return pagerFragment;
  }

  @Override public int getCount() {
    // Show 3 total pages.
    return 2;
  }

  @Override public CharSequence getPageTitle(int position) {
    switch (position) {
      case 0:
        return "Messages";
      case 1:
        return "Contacts";
    }
    return null;
  }
}