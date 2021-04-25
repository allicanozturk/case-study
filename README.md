# case-study
Bilet satış sistemi

Postman collection projedeki collection klasörü altında bulunmaktadır. Collection daki sıra ile istekleri atabilirsiniz. 
Havaalanı oluşturmadan rota oluşturulamaz, rota ve havayolu şirketi oluşturmadan uçuş oluşturulamaz , uçuş oluşturmadan bilet oluşturulamaz, bilet oluşturmadan ödeme yapılamaz. Sıra ile ilgili istekler tetiklenirse  eğer veritabanından statülerde elle değiştirilmediyse validasyonları geçer ve işlemler yapılabilir. 

Havaalanı yada Havayolu şirketi eklerken aynı kısa koda ait iki tane kayıt eklenemez. Varolmayan kaynaklar ile yada statüsü uygun olmayan kaynaklarla işlem yapılırsada yine 400 alınacaktır.  



Eksiklikler 

Zaman kısıtından dolayı bazı özellikleri tam yetiştiremedim. Eksik özellikler aşağıdaki gibidir.

1) Çoklu bilet satışı yok
2) Gidiş dönüş bilet satışı yok
3) Arama işlemlerinde sayfalama yok
