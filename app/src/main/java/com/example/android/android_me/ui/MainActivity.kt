/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.example.android.android_me.R

import com.example.android.android_me.R.id.*

// This activity is responsible for displaying the master list of all images
class MainActivity : AppCompatActivity(), MasterListFragment.OnImageClickListener {

    var headIndex: Int = 0
    var bodyIndex: Int = 0
    var legIndex: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onImageSelected(position: Int) {
        Toast.makeText(this, "Position clicked = $position", Toast.LENGTH_SHORT).show()

        val bodyPartNumber = position / 12

        val listIndex = position - 12 * bodyPartNumber

        when (bodyPartNumber) {
            0 -> headIndex = listIndex
            1 -> bodyIndex = listIndex
            2 -> legIndex = listIndex
        }

        val b = Bundle()
        b.putInt("headIndex", headIndex)
        b.putInt("bodyIndex", bodyIndex)
        b.putInt("legIndex", legIndex)

        val intent: Intent = Intent(this, AndroidMeActivity::class.java)
        intent.putExtras(b)

        val nextButton: Button = findViewById(next_button) as Button
    }

}
