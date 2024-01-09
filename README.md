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
kompatibilnost s starejšimi android verzijami

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
