/***
  Copyright (c) 2008-2012 CommonsWare, LLC
  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain	a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
  by applicable law or agreed to in writing, software distributed under the
  License is distributed on an "AS IS" BASIS,	WITHOUT	WARRANTIES OR CONDITIONS
  OF ANY KIND, either express or implied. See the License for the specific
  language governing permissions and limitations under the License.
	
  From _The Busy Coder's Guide to Android Development_
    http://commonsware.com/Android
*/

package com.commonsware.android.downmgr;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class DownloadDemo extends SherlockFragmentActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                                .detectAll()
                                .penaltyLog()
                                .build());
    
      if (savedInstanceState == null) {
        getSupportFragmentManager().beginTransaction()
                                   .add(android.R.id.content,
                                        new DownloadFragment()).commit();
      }
  }

  public void viewLog() {
    startActivity(new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS));
  }
}
