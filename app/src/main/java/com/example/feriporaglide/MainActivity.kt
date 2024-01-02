package com.example.feriporaglide

import BlackWhiteTransformation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.MemoryCategory
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageUrl = "https://upload.wikimedia.org/wikipedia/commons/2/2c/Rotating_earth_%28large%29.gif" //https://i.imgur.com/tGbaZCY.jpg
        val thumbnailUrl = "https://i.imgur.com/tGbaZCY.jpg"
        val secondthumbnailUrl = "https://upload.wikimedia.org/wikipedia/commons/f/fc/Maribor_%2815%29_%285468849812%29.jpg"



        // NALAGANJE S PLACEHOLDERJEM IN UPORABA TRANZICIJ IN TRANSFORMACIJ
        val imageView1: ImageView = findViewById(R.id.imageView)
        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            //TRANSFORMACIJE:
            //.apply(RequestOptions().centerCrop()) //center crop osredotoči sliko na sredino in ohrani razmerje stranic slike
            //.apply(RequestOptions().fitCenterTransform()) //fitCenter podobno vendar ni nujno da bo zapolnil ves imageView
            //.apply(RequestOptions().centerInsideTransform())//slike ne poveča, če je manjša od ImageView.
            .apply(RequestOptions().transform(BlackWhiteTransformation()))
            //TRANZICIJE:
            //.transition(DrawableTransitionOptions.withCrossFade()) //crossfade transition
            .transition(DrawableTransitionOptions.withCrossFade(500)) //crossfade transition s parametrom kako dolgo raja 500ms
            //podobno kot pri transformacijah lahko tudi pri transicijah naredimo svoje

            .into(imageView1)

        // THUMBNAIL in OVERRIDE
        val imageView2: ImageView = findViewById(R.id.imageView2)
        Glide.with(this)
            .load(imageUrl)
            .thumbnail(Glide.with(this).load(thumbnailUrl))// razlikuje se od placeholderja v tem da je namejena da se naloži ,ajša različica slike ki jo želimo prikazati placholder
            //.thumbnail(Glide.with(this).load(secondthumbnailUrl)) //lahko jih tudi več uporabimo vendar to ni praksa
            .override(800, 800)
            .into(imageView2)


        //CIRCLECROP TRANSFORMATION
        val imageView3: ImageView = findViewById(R.id.imageView3)
        Glide.with(this)
            .load(imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(imageView3)



        //CACHING IN MEMORY MANAGEMENT
        val imageView5: ImageView = findViewById(R.id.imageView5)
        Glide.with(this)
            .load(imageUrl)
            .skipMemoryCache(true) // skipamo memory cache, ki se privzeto avtomatsko naredi
            //če bi želeli da se samo iz catha nalaga pa uporabimo metodo .onlyRetrieveFromCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE) // ne uporabljamo nalaganje iz diska, ker nalaganje slike iz interneta in jo potem shranjevanje na disk ni smiselno
            //če bi želeli da se slika shrani na disk, bi uporabili DiskCacheStrategy.ALL

            .override(800, 800)
            .into(imageView5)

        //Pri globalnem nastavljanju Memory Cache morammo biti zelo previdni
        Glide.get(this).setMemoryCategory(MemoryCategory.LOW) //ročno nastavimo zmanjšanje količine pomnilnika, ki ga Glide uporablja za predpomnjenje slik... s tem se hitrost aplikacije poveča
        //ko končamo je priporočljivo da nastavimo nazaj na normalno
        Glide.get(this).setMemoryCategory(MemoryCategory.NORMAL)
    }
}
