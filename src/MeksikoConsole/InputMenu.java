package MeksikoConsole;

import java.util.*;
import java.util.stream.*;

public class InputMenu 
{
	
	public Scanner DataScanner;
	
	public InputMenu()
	{
		Initialize();
	}
	
	public void Initialize()
	{
		DataScanner = new Scanner(System.in).useDelimiter("\n");
	}
	
	public void ScanData()
	{
		String targetName = "[ERROR]", targetGender = "[ERROR]", targetRole = "[ERROR]";
		String employeeCode = "";
		
		// Input Name
		while (targetName == "[ERROR]")
		{
			targetName = InputName();
		}

		// Input Gender
		while (targetGender == "[ERROR]")
		{
			targetGender = InputGender();
		}
		
		// Input Role
		while (targetRole == "[ERROR]")
		{
			targetRole = InputRole();
		}
		
		while ((employeeCode == "") || (CompareCode(employeeCode)))
		{
			employeeCode = GenerateCode();
		}
		
		Karyawan targetKaryawan = new Karyawan(employeeCode, targetName, targetGender, targetRole);
		Main.Database.add(targetKaryawan);
		System.out.printf("Berhasil menambahkan karyawan dengan kode %s\n", employeeCode);
		
		IncreaseSalaryOnNumber();
	}
	
	public String InputName()
	{
		System.out.printf("Input nama karyawan [Panjang >= 3 huruf]: ");
		String target = DataScanner.next();
		if (target.length() < 3 && target != "0")
		{
			System.out.printf("Nama yang dimasukkan memiliki panjang lebih kecil dari 3 huruf\n");
			return "[ERROR]";
		}
		return target;
	}
	
	public String InputGender()
	{
		System.out.printf("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
		String target = DataScanner.next();
		switch (target)
		{
			case "Laki-laki":
			case "Perempuan":
			case "0":
				return target;
			default:
				System.out.printf("Jenis kelamin yang dimasukkan tidak sesuai dengan kata-kata kunci yang diminta\n");
				return "[ERROR]";
		}
	}
	
	public String InputRole()
	{
		System.out.printf("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
		String target = DataScanner.next();
		switch (target)
		{
			case "Manager":
			case "Supervisor":
			case "Admin":
			case "0":
				return target;
			default:
				System.out.printf("Jabatan yang dimasukkan tidak sesuai dengan kata-kata kunci yang diminta\n");
				return "[ERROR]";
		}
	}
	
	public String GenerateCode()
	{
		Random random = new Random();
		String target = "";
		
		for (int I1 = 0; I1 < 2; I1++)
		{
			target += (char)(random.nextInt(26) + 'A');
		}
		target += "-" + String.format("%04d", random.nextInt(9999));
		
		return target;
	}
	
	public boolean CompareCode(String target)
	{
		boolean exists = false;
		for (int I1 = 0; I1 < Main.Database.size(); I1++)
		{
			if (Main.Database.get(I1).Kode == target)
			{
				exists = true;
				break;
			}
		}
		return exists;
	}
	
	public void IncreaseSalaryOnNumber()
	{
		List<Karyawan> targetList = new ArrayList<Karyawan>();
		double bonusPercentage = 0.0;
		for (int I1 = 0; I1 < 3; I1++)
		{
			switch (I1)
			{
				case 0:
					bonusPercentage = 0.1;
					targetList = Main.Database.stream().filter(target -> "Manager".compareTo(target.Jabatan) == 0 && target.Gaji != 8800000).collect(Collectors.toList());
					break;
				case 1:
					bonusPercentage = 0.075;
					targetList = Main.Database.stream().filter(target -> "Supervisor".compareTo(target.Jabatan) == 0 && target.Gaji != 6450000).collect(Collectors.toList());
					break;
				case 2:
					bonusPercentage = 0.05;
					targetList = Main.Database.stream().filter(target -> "Admin".compareTo(target.Jabatan) == 0 && target.Gaji != 4200000).collect(Collectors.toList());
					break;
			}
			
			if (targetList.size() >= 3)
			{
				Karyawan targetKaryawan, mainKaryawan;
				int wantedSize = targetList.size() - (targetList.size() % 3);
				
				System.out.printf("Bonus sebesar %.1f%% telah diberikan kepada karyawan dengan kode ", (bonusPercentage * 100));
				for (int I2 = 0; I2 < wantedSize; I2++)
				{
					targetKaryawan = targetList.get(I2);
					
					for (int I3 = 0; I3 < Main.Database.size(); I3++)
					{
						mainKaryawan = Main.Database.get(I3);
						if (targetKaryawan.Kode == mainKaryawan.Kode && targetKaryawan.Gaji != (targetKaryawan.Gaji + (targetKaryawan.Gaji * bonusPercentage)))
						{
							mainKaryawan.Gaji += (targetKaryawan.Gaji * bonusPercentage);
							System.out.printf("%s%s", targetKaryawan.Kode, (I2 != (wantedSize - 1) ? ", " : "\n"));
							break;
						}
					}
				}
			}
			
		}
		
	}
	
}
