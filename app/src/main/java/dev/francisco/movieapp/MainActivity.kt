package dev.francisco.movieapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {

    private lateinit var iv1:ImageView
    private lateinit var iv2:ImageView
    private lateinit var iv3:ImageView
    private lateinit var iv4:ImageView
    private lateinit var iv5:ImageView


    private lateinit var viewPager2: ViewPager2



    private lateinit var bottomBar: AnimatedBottomBar
    private var recyclerView : RecyclerView? = null
    private var recyclerViewMovieAdapter : RecyclerViewMovieAdapter? = null
    private var movieList = mutableListOf<Movies>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager2=findViewById(R.id.view_page2)
        iv1=findViewById(R.id.iv1)
        iv2=findViewById(R.id.iv2)
        iv3=findViewById(R.id.iv3)
        iv4=findViewById(R.id.iv4)
        iv5=findViewById(R.id.iv5)

        val images = listOf(R.drawable.bluebeetle4kppp,R.drawable.granturismoppp,R.drawable
            .creatorppp,R.drawable.transformersppp,R.drawable.megan)

        val adapter=ViewPagerAdapter(images)
        viewPager2.adapter=adapter

         viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
             override fun onPageScrolled(
                 position: Int,
                 positionOffset: Float,
                 positionOffsetPixels: Int,
             ) {
                 changeColor()
                 super.onPageScrolled(position, positionOffset, positionOffsetPixels)
             }

             override fun onPageSelected(position: Int) {
                 super.onPageSelected(position)
             }

             override fun onPageScrollStateChanged(state: Int) {
                 super.onPageScrollStateChanged(state)
                 changeColor()
             }

         })




        bottomBar= findViewById(R.id.bottom_bar)
        recyclerView = findViewById(R.id.rvMovieLists)

        replaceFragment(FilmesFragment())


        bottomBar.setOnTabSelectListener(object :AnimatedBottomBar.OnTabSelectListener{
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab,
            ) {

                when(newIndex){

                    0->{
                        replaceFragment(FilmesFragment())

                    }

                    1->{
                        replaceFragment(PipocaFragment())

                    }


                    2->{
                        replaceFragment(IngressosFragment())

                    }

                }
            }

        })




        movieList = ArrayList()

        recyclerView = findViewById<View>(R.id.rvMovieLists) as RecyclerView
        recyclerViewMovieAdapter = RecyclerViewMovieAdapter(this@MainActivity,movieList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this
        ,2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = recyclerViewMovieAdapter
        prepareMovieListData()
    }

    private fun prepareMovieListData() {
        var movies = Movies("Devotion", R.drawable.devotion)
        movieList.add(movies)
        movies = Movies("Black Adam", R.drawable.blackadam)
        movieList.add(movies)
        movies = Movies("Blue Beetle", R.drawable.bluebeetle)
        movieList.add(movies)
        movies = Movies("Creed", R.drawable.creed)
        movieList.add(movies)
        movies = Movies("Enola Holmes", R.drawable.enolaholmes)
        movieList.add(movies)
        movies = Movies("Equalizer", R.drawable.equalizer)
        movieList.add(movies)
        movies = Movies("Extraction 2", R.drawable.extractiontwo)
        movieList.add(movies)
        movies = Movies("Fast x", R.drawable.fastx)
        movieList.add(movies)
        movies = Movies("Gran Turismo", R.drawable.granturismo)
        movieList.add(movies)
        movies = Movies("Mario Bross", R.drawable.mariobros)
        movieList.add(movies)
        movies = Movies("John Wick", R.drawable.johnwik)
        movieList.add(movies)
        movies = Movies("Muzzle", R.drawable.muzzle)
        movieList.add(movies)
        movies = Movies("Spider Verse", R.drawable.spiderverse)
        movieList.add(movies)
        movies = Movies("Transforms", R.drawable.transforms)
        movieList.add(movies)
        movies = Movies("Wakanda Forever", R.drawable.wakandaforever)
        movieList.add(movies)
        movies = Movies("Woman King", R.drawable.womanking)
        movieList.add(movies)

        recyclerViewMovieAdapter!!.notifyDataSetChanged()




    }

    fun replaceFragment(fragment: Fragment){

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
    }

    fun changeColor()
    {
        when(viewPager2.currentItem)
        {
            0->
            {
              iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
                iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv4.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv5.setBackgroundColor(applicationContext.resources.getColor(R.color.black))

            }
            1->
            {
                iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
                iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv4.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv5.setBackgroundColor(applicationContext.resources.getColor(R.color.black))

            }
            2->
            {
                iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
                iv4.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv5.setBackgroundColor(applicationContext.resources.getColor(R.color.black))

            }
            3->
            {
                iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv4.setBackgroundColor(applicationContext.resources.getColor(R.color.white))
                iv5.setBackgroundColor(applicationContext.resources.getColor(R.color.black))

            }
            4->
            {
                iv1.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv2.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv3.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv4.setBackgroundColor(applicationContext.resources.getColor(R.color.black))
                iv5.setBackgroundColor(applicationContext.resources.getColor(R.color.white))

            }


        }
    }
}