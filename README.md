# KNJIŽNICA GLIDE 📱

### Zakaj? 🤔
#### &emsp; Učinkovitost pri nalaganju slik: 🚀
&emsp;&emsp; Glide optimizira nalaganje slik iz različnih virov, kot so internet, lokalni pomnilnik itd.
#### &emsp; Predpomnjenje: 💾
&emsp;&emsp; Glide ima zmogljiv sistem predpomnjenja, ki zmanjšuje porabo podatkov in izboljšuje zmogljivost.
#### &emsp;Prilagodljivost: 🔧
&emsp;&emsp; Omogoča prilagajanje velikosti slik, obrezovanje, transformacije in druge možnosti za prilagajanje prikaza slik.
#### &emsp; Podpora za GIF: 🎞️
&emsp;&emsp; Glide omogoča enostavno nalaganje in prikazovanje GIF-ov.

### Prednosti in slabosti? ⚖️
#### &emsp; Prednosti: 👍
&emsp;&emsp; Enostavna integracija in uporaba.

&emsp;&emsp; Dobro dokumentirana in široko podprta s skupnostjo.

&emsp;&emsp; Učinkovito upravljanje pomnilnika in predpomnjenja.
&emsp;&emsp; 
#### &emsp;Slabosti: 👎
&emsp;&emsp; Za samo preprosto nalaganje slik imamo bolj primerne knjižnice kot je Picasso.

&emsp;&emsp; kompatibilnost s starejšimi android verzijami

### Zakaj izbrati Glide namesto Picasso?
#### Upravljenje pomninika in predpomnenje slik:
&emsp;&emsp; Glide je zasnovan tako, da bolj učinkovito upravlja s pomnilnikom in baterijo, še posebej pri nalaganju slik v seznamih ali mrežah, kar lahko pomeni boljšo zmogljivost in manjšo porabo baterije.

&emsp;&emsp;ponuja naprednejše možnosti za predpomnjenje, vključno z možnostjo izbire med diskovnim predpomnjenjem, predpomnjenjem v pomnilniku in predpomnjenjem samo za izvorne slike.

#### Podpora za GiF
&emsp;&emsp; Glide ima vgrajeno podporo za nalaganje in prikazovanje GIF-ov ter video predogledov, kar je funkcija, ki v Picasso ni na voljo brez dodatnih prilagoditev.

#### Transofrmacije in obdelava slik
&emsp;&emsp;  Glide omogoča več vgrajenih možnosti za prilagajanje in transformacijo slik, kot je spreminjanje velikosti, obrezovanje in barvne transformacije


### Licenca? Število uporabnikov? 📜
&emsp;&emsp; BSD licenca. Dovoljena brezplačna uporaba za privatno uporabo kot tudi za komercialne namene. 🆓

&emsp;&emsp; Ena izmed najbolj priljubljenih knjižnic za obdelavo slik v Android ekosistemu. 🌍

### Vzdrževanje projekta (št. razvijalcev, zadnjo popravek…)? 👨‍💻
&emsp;&emsp; zadnja verzija(v4.16.0) je prišla ven 21. avgusta 2023. 🆕

&emsp;&emsp; Število razvijalcev: 146. 👥

&emsp;&emsp; Okoli 40 tisoč uporabnikov.


### Kako začeti? 🚀
#### &emsp; Dodajanje v projekt:
&emsp;&emsp; Za vključitev Glide v vaš Android projekt, dodajte naslednjo odvisnost v vaš `build.gradle` datoteko:
```
repositories {
  google()
  mavenCentral()
}

dependencies {
  implementation 'com.github.bumptech.glide:glide:4.16.0'
}
```

### UPORABA:
```

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

```

