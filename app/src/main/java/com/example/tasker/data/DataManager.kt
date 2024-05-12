package com.example.tasker.data

import com.example.tasker.data.db.DbHelper
import com.example.tasker.data.network.ApiHelper
import com.example.tasker.data.prefs.PreferencesHelper


interface DataManager : ApiHelper, DbHelper, PreferencesHelper {
}