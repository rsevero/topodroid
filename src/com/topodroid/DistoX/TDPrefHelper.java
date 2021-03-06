/* @file TDPrefHelper.java
 *
 * @author marco corvi
 * @date aug 2018
 *
 * @brief TopoDroid options helper
 * --------------------------------------------------------
 *  Copyright This software is distributed under GPL-3.0 or later
 *  See the file COPYING.
 * --------------------------------------------------------
 */
package com.topodroid.DistoX;

// import android.util.Log;

import android.preference.PreferenceManager;
import android.content.SharedPreferences;
// import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
// import android.content.SharedPreferences.Editor;
import android.content.Context;

class TDPrefHelper
{
  private SharedPreferences mPrefs;
  // private Context mContext;
  // private TopoDroidApp mApp;

  TDPrefHelper( Context ctx /*, TopoDroidApp app */ )
  {
    // mContext = ctx;
    // mApp   = app;
    mPrefs = PreferenceManager.getDefaultSharedPreferences( ctx );
  }

  SharedPreferences getSharedPrefs() { return mPrefs; }
  // TopoDroidApp      getApp() { return mApp; }

  // boolean has( String name )
  // {
  // }

  String getString( String name, String def_value )    { return mPrefs.getString( name, def_value ); }
  boolean getBoolean( String name, boolean def_value ) { return mPrefs.getBoolean( name, def_value ); }

  void update( String name, String value )
  {
    // Log.v("DistoXPref", "TDPrefHelper set pref " + name + " " + value );
    SharedPreferences.Editor editor = mPrefs.edit();
    editor.putString( name, value );
    TDandroid.applyEditor( editor );
  }

  void update( String name1, String value1, String name2, String value2 )
  {
    // Log.v("DistoXPref", "TDPrefHelper set pref " + name1 + " " + value1 + "   " + name2 + " " + value2 );
    SharedPreferences.Editor editor = mPrefs.edit();
    editor.putString( name1, value1 );
    editor.putString( name2, value2 );
    TDandroid.applyEditor( editor );
  }

  void update( String name1, String value1, String name2, String value2, String name3, String value3 )
  {
    // Log.v("DistoXPref", "TDPrefHelper set pref " + name1 + " " + value1 + "   " + name2 + " " + value2 + "   " + name3 + " " + value3 );
    SharedPreferences.Editor editor = mPrefs.edit();
    editor.putString( name1, value1 );
    editor.putString( name2, value2 );
    editor.putString( name3, value3 );
    TDandroid.applyEditor( editor );
  }

  // unused
  // void update( String[] name, String[] value )
  // {
  //   Log.v("DistoX-PREF", "TDPrefHelper set pref " + name[0] + " " + value[0] + " ... ");
  //   SharedPreferences.Editor editor = mPrefs.edit();
  //   for ( int k = 0; k < name.length; ++k ) {
  //     editor.putString( name[k], value[k] );
  //   }
  //   TDandroid.applyEditor( editor );
  // }

  void update( String name, boolean value )
  {
    // Log.v("DistoXPref", "TDPrefHelper set b-pref " + name + " " + value );
    SharedPreferences.Editor editor = mPrefs.edit();
    editor.putBoolean( name, value );
    TDandroid.applyEditor( editor );
  }

  void update( String name, long value )
  {
    // Log.v("DistoXPref", "TDPrefHelper set l-pref " + name + " " + value );
    SharedPreferences.Editor editor = mPrefs.edit();
    editor.putLong( name, value );
    TDandroid.applyEditor( editor );
  }

  // =============================================================

  
}
