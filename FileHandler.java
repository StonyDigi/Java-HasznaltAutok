package usedCar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
	public List<usedCarStorage> fileLoader(String fileName) {
		List<usedCarStorage> usedCars = new ArrayList<usedCarStorage>();
		String filepath = "adatok/dízel.txt";
		String header;
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("adatok/hasznalt_autok.txt"), "UTF-8"));
			header = br.readLine();
			while (br.ready()) {
				String line = br.readLine();
				String[] lineDatas = line.split("\t");
				
				usedCarStorage newUsedCarsObj = new usedCarStorage(
						lineDatas[0],
						lineDatas[1],
						lineDatas[2],
						Integer.parseInt(lineDatas[3]),
						Integer.parseInt(lineDatas[4]),
						Integer.parseInt(lineDatas[5]),
						Integer.parseInt(lineDatas[6]),
						Integer.parseInt(lineDatas[7]),
						lineDatas[8]);
				usedCars.add(newUsedCarsObj);
			}
			br.close();
			System.out.println("Successfully added a new car in register...");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usedCars;	
	}
	public  void writeTheDieselsInAseparateFile() {
		List<usedCarStorage> usedCars = new ArrayList<usedCarStorage>();
		File fileObj = new File("adatok/dízel_uj.txt");
			try {
				FileWriter fw = new FileWriter(fileObj,Charset.forName("UTF-8"), false);
				for (usedCarStorage item : usedCars) {
					if(item.getFuel().equals("dízel")) {
						fw.write(item.getId().toString());
						fw.write("\t");
						fw.write(item.getBrand().toString());
						fw.write("\t");
						fw.write(item.getType().toString());
						fw.write("\t");
						fw.write(item.getEngineVolume().toString());
						fw.write("\t");
						fw.write(item.getNumberOfPersonsTransported().toString());
						fw.write("\t");
						fw.write(item.getBrand().toString());
						fw.write("\t");
						fw.write(item.getVintage().toString());
						fw.write("\t");
						fw.write(item.getPrice().toString());
						fw.write("\t");
						fw.write(item.getKilometer().toString());
						fw.write("\t");
						fw.write(item.getFuel().toString());	
					}	
				}
				fw.close();	
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Létrejött a file adatok/dízel_uj.txt elérési úton...");
	}

	}	