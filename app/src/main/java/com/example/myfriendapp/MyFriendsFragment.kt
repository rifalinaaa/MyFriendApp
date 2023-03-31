package com.example.myfriendapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyFriendsFragment : Fragment() {
    private var fabAddFriend: FloatingActionButton? = null
    private var listMyFriends: RecyclerView? = null
    lateinit var listTeman : MutableList<MyFriend>

    companion object {
        fun newInstance(): MyFriendsFragment {
            return MyFriendsFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container:
    ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.my_friends_fragment,
            container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState:
    Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    private fun initView() {
        fabAddFriend = activity?.findViewById(R.id.fabAddFriend)
//listMyFriends = activity?.findViewById((R.id.listMyFriends))
        fabAddFriend?.setOnClickListener { (activity as
                MainActivity).tampilMyFriendsAddFragment() }

        simulasiDataTeman()
        tampilTeman()
    }
    override fun onDestroy() {
        super.onDestroy()
    }
    private fun simulasiDataTeman() {
        listTeman = ArrayList()
        listTeman.add(MyFriend("Muhammad", "Laki-laki",
            "ade@gmail.com", "085719004268", "Bandung"))
        listTeman.add(MyFriend("Al Harits", "Laki-laki",
            "rifaldi@gmail.com", "081213416171", "Bandung"))
    }
    private fun tampilTeman() {
        listMyFriends?.layoutManager = LinearLayoutManager(activity)
        listMyFriends?.adapter = MyFriendAdapter(requireActivity(),
            listTeman as ArrayList<MyFriend>
        )
    }
}