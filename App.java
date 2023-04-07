package usedCar;

public class App {
//	fhObj.fileLoad("adatok/hasznalt_autok.txt");
	public static void main(String[] args) {
		Task tObj = new Task();
		FileHandler fhObj = new FileHandler();
		System.out.println("A, feladat - Írjuk ki az összetartozó adatokat egymás mellé, sorokat egymás alá: ");
		tObj.allDataDisplay();
		System.out.println();
		
		System.out.println("B, feladat - Hány db autó szerepel a nyilvántartásban?: ");
		tObj.howManyCarsAreOnTheRegister();
		System.out.println();
		
		System.out.print("C, feladat - A benzin-es autók átlagára: ");
		System.out.print(tObj.WhatIsTheAveragePriceOfGasolineCars());
		System.out.println();
		
		System.out.print("D, feladat - Ennyi kilométert tettek meg átlagosan a dízelautók: ");
		System.out.println(tObj.HowManyKilometersDidDieselCarsAverage());
		System.out.println();
		
		System.out.println("E, feladat - Van –e hibrid autó a nyilvántartásban (csak addig fusson a ciklus, amíg meg nem találja): ");
		tObj.IsThereAhybridCarOnTheRegister();
		
		System.out.println("F, feladat - Az azonosító tartalmazza a gépjármű gyártási évét is,\nazonban néhány rekordnál sajnos hibásan lett rögzítve!:");
		tObj.identifierIncludesTheYearOfManufacture();
		System.out.println();
		
		System.out.println("G, feladat - Új autó érkezik a kereskedésbe, kérjuk be az adatait, majd írjuk be az DFW11771-2017-as\r\n azonosítóval rendelkező autó utáni sorba!: ");
		tObj.dataFromUser();
		System.out.println();

		System.out.println("H, feladat - Írjuk ki a legidősebb és legfiatalabb gépjármű adatait!: ");
		tObj.writeDownTheOldestAndYoungestVehicle();
		System.out.println();
		
		System.out.println("I, feladat - Készítsünk statisztikát, amely megjeleníti melyik évjáratú autóból hány db van!: ");
		System.out.println(tObj.CreateStatisticsThatShowYouHowManyVintageCarsThereAre());
		System.out.println();
		
		System.out.println("J, feladat - Készítsünk statisztikát, amely megjeleníti melyik márkából hány db van!: ");
		System.out.println(tObj.createStatisticsThatShowHowManyBrandYouHave());
		System.out.println();
		
		System.out.println("K, feladat - Írjuk ki a dízeleket egy külön fájlba dizel.txt néven: ");
		fhObj.writeTheDieselsInAseparateFile();
		
		
		
		

	}

}










