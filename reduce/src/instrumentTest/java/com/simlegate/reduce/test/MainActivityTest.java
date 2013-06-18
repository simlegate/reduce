package com.simlegate.reduce.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import static android.test.ViewAsserts.assertOnScreen;

import com.simlegate.reduce.MainActivity;

  public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
                                                                        //^Activity to test

      private MainActivity mMainActivity;
      private TextView mHelloWorldTextView;

      // Be careful about letting the IDE create the constructor.  As of this writing,
      // it creates a constructor that's compiles cleanly but doesn't run any tests
      public MainActivityTest() {
          super(MainActivity.class);
      }

      protected void setUp() throws Exception {
          super.setUp();

          mMainActivity = getActivity();
          //mHelloWorldTextView = (TextView) mMainActivity.findViewById(R.id.hello_world_text_view);
      }

      // Methods whose names are prefixed with test will automatically be run
      public void testTextView() {
          assertOnScreen(mMainActivity.getWindow().getDecorView(), mHelloWorldTextView);
      }
  }