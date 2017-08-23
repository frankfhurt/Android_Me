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

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.GridView

import com.example.android.android_me.R
import com.example.android.android_me.data.AndroidImageAssets


// This fragment displays all of the AndroidMe images in one large list
// The list appears as a grid of images
// Mandatory empty constructor
class MasterListFragment : Fragment() {

    var mCallback: OnImageClickListener? = null

    interface OnImageClickListener {
        fun onImageSelected(position: Int)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        try {
            mCallback = context as OnImageClickListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + " must implement OnImageClickListner")
        }
    }

    // Inflates the GridView of all AndroidMe images
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_master_list, container, false)

        // Get a reference to the GridView in the fragment_master_list xml layout file
        val gridView = rootView.findViewById(R.id.images_grid_view) as GridView

        // Create the adapter
        // This adapter takes in the context and an ArrayList of ALL the image resources to display
        val mAdapter = MasterListAdapter(context, AndroidImageAssets.all)

        // Set the adapter on the GridView
        gridView.adapter = mAdapter

        gridView.setOnItemClickListener { adapterView: AdapterView<*>, view: View, position: Int, l: Long ->
            mCallback?.onImageSelected(position)
        }

        // Return the root view
        return rootView
    }

}
