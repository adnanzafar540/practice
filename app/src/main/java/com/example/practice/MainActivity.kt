package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  mainViewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel=ViewModelProvider(this,MainViewModelFactory(10)).get(MainViewModel::class.java)
        if (this::mainViewModel.isInitialized){
            Log.d("Initialize", "onCreate: ")
        }
        setText()
       // lifecycle.addObserver(observer())
      //  Log.d("MainActivity", "onCreate: ")
        //CreationMode: In creation mode always Activity methods called first .
        //Destruction mode :In destruction mode always Observer methods called first.
        //donot Hold refrences in view model
        //For instance agr koi api call ki ha tu jab rotation ho gi dobara oncreate
    // call ho ga aur dobara call bhajy gi
    // lekin view model se in sab cheezain nhe ho i call nhe bhajy gi
        //View model Life cycle aware hoty ha hummy btana parta ha kis activity ky lehaz se kam karna
//        View model factory uses when we need to put argument n view model object
    //        we need this because we have no option to pass parameter to view model object
    //        because we make this object from view model factory ..
    //        View mode factory allows us to pass argument in viewmodel objech
    }



    private fun setText() {
        tv_main.text=mainViewModel.counterAddition.toString()
    }

    fun increment(view: View) {
        mainViewModel.increment()
        setText()
    }
}