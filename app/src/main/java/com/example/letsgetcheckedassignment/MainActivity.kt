package com.example.letsgetcheckedassignment

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var progerssProgressDialog: ProgressDialog;
    var dataList : MutableList<DataModel> = ArrayList()
    lateinit var recyclerView: RecyclerView
     lateinit var adapter: DataAdpter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)

        //setting up the adapter
        recyclerView.adapter= DataAdpter(dataList,this){ data: DataModel, position: Int ->
            Log.e("MyActivity", "Clicked on item  ${data.capital} at position $position")
//            val ft = getSupportFragmentManager().beginTransaction()
//            val newFragment = PopupFragment.newInstance("pass content here")
//            newFragment.show(ft, "dialog")

            showDialog(data.subregion!!, data.population!!,data.area!!)

        }

        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)





        progerssProgressDialog=ProgressDialog(this)
        progerssProgressDialog.setTitle("Loading")
        progerssProgressDialog.setCancelable(false)
        progerssProgressDialog.show()
        getData()

    }

    private fun showDialog(subregion: String,population: Int, area:Double) {
        val ft = getSupportFragmentManager().beginTransaction()
        Log.v("MainActivity",""+subregion+" "+population+" "+area)
        val newFragment = PopupFragment.newInstance(subregion,population,area)
        newFragment.show(ft, "dialog")
    }

    private fun getData() {
        val call: Call<List<DataModel>> = ApiClient.getClient.getData()
        call.enqueue(object : Callback<List<DataModel>> {

            override fun onResponse(call: Call<List<DataModel>>?, response: Response<List<DataModel>>?) {
                progerssProgressDialog.dismiss()
                Log.v("Data",""+response!!.body()!!);
                dataList.addAll(response!!.body()!!)
                recyclerView.adapter?.notifyDataSetChanged()

            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
                progerssProgressDialog.dismiss()
            }

        })
    }

    override fun onPause() {
        super.onPause()
        progerssProgressDialog.dismiss();

    }
}
