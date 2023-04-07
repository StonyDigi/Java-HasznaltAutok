package usedCar;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Task {
	List<usedCarStorage> usedCars = new FileHandler().fileLoader("adatok/hasznalt_autok.txt");
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void allDataDisplay() {
		for (usedCarStorage item : usedCars) {
			System.out.println(item.toString());
			
		}
	}
	public void howManyCarsAreOnTheRegister() {
	System.out.println(usedCars.size());
			}
	public double WhatIsTheAveragePriceOfGasolineCars() {
		int db = 0;
		double osszeg = 0.0;
		
		for (usedCarStorage item : usedCars) {
			if(item.getFuel().equalsIgnoreCase("benzin")) {
				db++;
				osszeg += item.getPrice();
			}	
		}
		return Math.round(osszeg/db);	
	}
	public double HowManyKilometersDidDieselCarsAverage() {
		int db = 0;
		double osszeg = 0.0;
		
		for (usedCarStorage item : usedCars) {
			if(item.getFuel().equalsIgnoreCase("d�zel")) {
				db++;
				osszeg += item.getKilometer();
			}	
		}
		return Math.round(osszeg/db);	
	}
	public void IsThereAhybridCarOnTheRegister() {
		for (usedCarStorage item : usedCars) {
			if (item.getFuel().equalsIgnoreCase("hibrid")) {
				System.out.print(item.getId());
				System.out.print("\t");
				System.out.print(item.getBrand());
				System.out.print("\t");
				System.out.print(item.getType());
				System.out.print("\t");
				System.out.print(item.getFuel());
				System.out.println();
			}	
		}
	}	
	public void identifierIncludesTheYearOfManufacture() {
			for (usedCarStorage item : usedCars) {
				if(!item.getId().contains(item.getVintage().toString())) {
					System.out.print(item.getId());
					System.out.print("\t");
					System.out.print(item.getBrand());
					System.out.print("\t");
					System.out.print(item.getType());
					System.out.print("\t");
					System.out.print(item.getFuel());
					System.out.println();	
				}
	
			}	
		}
	public void writeDownTheOldestAndYoungestVehicle() {
		System.out.println("A legid�sebb aut�k adatai: ");
		int oldest = usedCars.get(0).getVintage();
		
		for (int i = 0; i < usedCars.size(); i++) {
			if(usedCars.get(i).getVintage() < oldest) {
				oldest = usedCars.get(i).getVintage();
			}
		}
		for (usedCarStorage item : usedCars) {
			if(item.getVintage() == oldest) {
				System.out.println(item.toString());	
			}	
		}
		System.out.println("Legfiatalabb aut�k adatai: ");
		int latest = usedCars.get(0).getVintage();
		for (int i = 0; i < usedCars.size(); i++) {
			if(usedCars.get(i).getVintage()> latest) {
				latest = usedCars.get(i).getVintage();	
		}
	}
		for (usedCarStorage item : usedCars) {
			if(item.getVintage() == latest) {
				System.out.println(item.toString());
			}
			
		}
	}
	public Map<Integer, Integer> CreateStatisticsThatShowYouHowManyVintageCarsThereAre() {
//		�n �gy jegyeztem meg, hogy el�sz�r egy halmazt(TreeSet) kell k�sz�teni, ahol egyszer fognak szerepelni az elemek

//		ut�na bej�rom ezt a halmazt egy k�ls� ciklussal, �s ind�tok egy bels� ciklust, ami az eredeti list�n v�gig megy �s
		//ahol a halmaz eleme megegyezik a list elem�vel, ott oper�lok
		
		Set<Integer> years = new TreeSet<Integer>(); //1.
		for (int i = 0; i < usedCars.size(); i++) {//2.
			years.add(usedCars.get(i).getVintage());//3. itt egyszer szerepelnek az elemek	
		}
		Map<Integer, Integer> carsByYear = new TreeMap<Integer, Integer>();
		for (Integer item : years) {
			int value = 0;
			for (usedCarStorage ucitem : usedCars) {
				if(ucitem.getVintage().equals(item)) { //ahol a halmaz eleme megegyezik a list elem�vel, ott oper�lok
					value++;// itt n�velem az egyszer szerepl� �vj�ratokhoz a countert, sz�ml�l�t
				}	
			}
			carsByYear.put(item, value);
			}
		return carsByYear;	
	}
	public Map<String, Integer> createStatisticsThatShowHowManyBrandYouHave() {
		Set<String> typesOfCar = new TreeSet<String>();
		for (usedCarStorage item : usedCars) {
			typesOfCar.add(item.getBrand());		
		}
		Map<String, Integer> carsByType = new TreeMap<String, Integer>();
		for (String item : typesOfCar) {
			int value = 0;
			for (usedCarStorage ucitem : usedCars) {
				if(ucitem.getBrand().equalsIgnoreCase(item)) {
					value++;
				}
			}
			carsByType.put(item, value);
		}
		return carsByType;
		
	}
	public void getDiesel() {
		for (usedCarStorage item : usedCars) {
			if(item.getFuel().equals("d�zel")) {
				System.out.println(item.toString());
			}
		}	
	}
		public void dataFromUser() {
		 String id;
		 String brand;
		 String type;
		 Integer engineVolume;
		 Integer numberOfPersonsTransported;
		 Integer vintage;
		 Integer price;
		 Integer kilometer;
		 String fuel;
		try {
			
			System.out.println("K�rem adja meg az aut� azonos�t�j�t: ");
			 id = br.readLine();
			System.out.println("K�rem adja meg az aut� m�rk�j�t: ");
			 brand = br.readLine();
			System.out.println("K�rem adja meg az aut� tipus�t: ");
			 type = br.readLine();
			System.out.println("K�rem adja meg az aut� motor-t�rfogat�t: ");
			 engineVolume = Integer.parseInt(br.readLine());
			System.out.println("K�rem adja meg az aut� maximum sz�ll�that� szem�lyek sz�m�t: ");
			 numberOfPersonsTransported = Integer.parseInt(br.readLine());
			System.out.println("K�rem adja meg az aut� �vj�rat�t: ");
			 vintage = Integer.parseInt(br.readLine());
			System.out.println("K�rem adja meg az aut� �r�t: ");
			 price = Integer.parseInt(br.readLine());
			System.out.println("K�rem adja meg, hogy az aut� h�ny km-t futott: ");
			 kilometer = Integer.parseInt(br.readLine());
			System.out.println("K�rem adja meg az aut� �zemanyag�t: ");
			 fuel = br.readLine();
			usedCarStorage newUsedCarsObj = new usedCarStorage(id, brand, type, engineVolume, numberOfPersonsTransported, vintage, price, kilometer, fuel);
			FileOutputStream fs = new FileOutputStream("adatok/d�zel.txt", false);
			OutputStreamWriter out = new OutputStreamWriter(fs, "UTF-8");
//			String[] header = {"azonos�t�", "M�rka", "tipus", "motor_t�rfogat", "sz�ll�that�_szem�lyek", "�vj�rat", "�r", "kil�m�ter" };
			int index = usedCars.size();
			usedCars.add(8,newUsedCarsObj);
			for (int i = 0; i < usedCars.size(); i++) {
				if(usedCars.get(i).getId().equalsIgnoreCase("DFW11771-2017")) {
				index = i;
				i = usedCars.size();
				for (usedCarStorage item : usedCars) {
					out.write(String.valueOf(item.getId()));
					out.write("\t");
					out.write(String.valueOf(item.getBrand()));
					out.write("\t");
					out.write(String.valueOf(item.getType()));
					out.write("\t");
					out.write(String.valueOf(item.getEngineVolume()));
					out.write("\t");
					out.write(String.valueOf(item.getNumberOfPersonsTransported()));
					out.write("\t");
					out.write(String.valueOf(item.getVintage()));
					out.write("\t");
					out.write(String.valueOf(item.getPrice()));
					out.write("\t");
					out.write(String.valueOf(item.getKilometer()));
					out.write("\t");
					out.write(String.valueOf(item.getFuel()));
					out.write("\n");
				}
			}	
		}
			out.close();
			fs.close();
		} catch (IOException e) {
			System.out.println("sorry an I / O (device) error has occurred, please try again later...");
//         	e.printStackTrace();		
		}	
  }
}

		
			

				
		
	
		
	
	

	


