# Drugi zadatak
---

Drugi zadatak je vezan u višenitno programmiranje. U mapi **LockCodeBlockRunnable** nalazi se java projekt s rješenjem problema punjenja dviju lista na različite načine. Kako ćete moći i vidjeti višenitnost je realizirana kreiranjem dvaju poslova koji implemenitraju sučelje Runnable. 

- Prvi posao PopulateListJob1 &rarr; u sebi ima implementiranu sinkronizaciju metoda koje dijele dvije niti s tim poslom
- Drugi posao PupulateListJob2 &rarr; u sebi ima implementiranu sinkronizaciju blokova koda putem zaključavanja objekta u kodu (u oba slučaja su liste)

Drugi način je vremenski isplativiji iz razloga što sinkronizacija metoda stavlja u red čekanja drugu nit sve dok ne oslobodi ključ, tj. dok ne završi zadatak. To u konkretnom primjeru znači da kada jedna nit započne izvršavati metodu za popunjavanje prve liste druga nit treba čekati iako bi za to vrijeme mogla popunjavati drugu listu. Osnovni razlog je što u klasi **PopulateListJob1** metoda **run()** pokreće dvije druge metode **populateLst1()** i **populateLst2()** pa će u sinkronizaciji metoda populateLst1() dobiti log ključ objekta PopulateListJob1 čime će onemogučiti drugu metodu da radi iako bi logički mogla budući da popunjava drugu, nezavisnu listu list2. Prema tome, želimo omogučiti da jedna metoda popunjava jednu listu, a druga drugu iz razloga što su nezavisne. To se postiže sinkronizacijom blokova koda na način da se sinkronizira po jednom objektu koji je svojstven jednom bloku i po drugom koji je svojstven drugom bloku:

```JAVA
private void populateLst1() {
		synchronized (list1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.list1.add(random.nextInt(100));
		}
	}

	private void populateLst2() {

		synchronized (list2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			this.list2.add(random.nextInt(100));
		}
	}
```
> metoda klase Thread join() osigurava da nit završi svoju aktivnost

U ovom primjeru smo se poslužili objektima list1 i list2, a prema potrebi možete kreirati i vlastite, različite objekte ukoliko niste sigurni za koji objekt bi se vezali. U **PopulateListJob2** imamo željenu situaciju što je vidljivo iz gornjeg koda &rarr; kada se zaključa kod s listom 1 tada je raspoloživ ključ objekta lista 2 pa ga može dohvatiti druga nit koja bi inače čekala. Klasa **WorkerMainThread** nije ništa drugo do klasični način popunjavanja samo jednom niti koji smo već upoznali ranije. 
Vaš zadatak je sljedeći:

1. Pokrenite program nekoliko puta i razmotrite dobivene rezultate, a također promijenite željeni broj elemenata lista (npr. 100, 500, 1000)
2. Napraviti petlju u glavnom programu da se cijeli kod izvrši više puta (recimo 50, uz broj elemenata liste 500) i izmjeriti prosječno vrijeme za sva tri slučaja (worker1, worker2 i worker3) &rarr; konzolni prikaz treba prikazivati ta tri vremena. Naziv projekta je **LockModified_1**.

Prisjetite se da smo na predavanju u želji za direktnom primjenom petlje s jednom niti dobili pogrešu (iznimku) sličnu sljedećoj iznimci:
```JAVA 
Exception in thread "main" java.lang.IllegalThreadStateException
	at java.base/java.lang.Thread.start(Thread.java:794)
	at WorkerSynchBlocks.doJob(WorkerSynchBlocks.java:22)
	at App.main(App.java:17)
```
Što nam označava nedozvoljeno stanje niti koju ponovno pokreće sljedeći korak petlje što direktno nije moguće. Životni vijek niti je takav da treba završiti svoju aktivnost "prirodno". To znači da trebate osigurati da svaki korak petlje kreira potpuno novu nit.

3. Izbrišite rezerviranu riječ synchronized u obje metode unutar **PopulateListJob1** kako bi metode stavili u nesinkronizirano stanje &rarr; što u tom slučaju uočavate &rarr; odgovor postavite u datoteci odgovori.txt koja će se nalaziti u istoj mapi java projekta kao i rješenje sljedećeg zadatka
4. Realizirajte isti program na način da se cijeli kod nalazi u klasi App, a niti trebate realizirati proširenjem klase Thread umjesto implemenitranjem Runnable sučelja. Naziv projekta treba biti **LockAllinOne**.

> Rješenja zadataka su prihvatljiva do 18/12/2018 do 23.45h :), a java kod projekta treba se nalaziti u mapi PROJECTS_codes

Poveznica na java projekt koji će vam poslužiti kao polazna točka u ovom projektu je [LockCodeObjectsRunnable](https://1drv.ms/u/s!AoqC7HN-YzkM7wlhahIHSctZOI9o). Preuzeti projekt treba također biti u ovom dijeljenom repozitoriju.
