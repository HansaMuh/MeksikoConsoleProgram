package MeksikoConsole;

import java.util.Comparator;

public class ViewMenu
{

	public ViewMenu()
	{
	}

	public void ViewDatabase()
	{
		Main.Database.sort(Comparator.comparing(karyawan -> karyawan.Nama));
		
		System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
		System.out.printf("|%-4s|%-17s|%-30s|%-15s|%-14s|%-13s|\n", "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
		System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");

		Karyawan target;
		for (int I1 = 0; I1 < Main.Database.size(); I1++)
		{
			target = Main.Database.get(I1);
			System.out.printf("|%4s|%17s|%30s|%15s|%14s|%13d|\n", (I1 + 1),  target.Kode, target.Nama, target.Kelamin, target.Jabatan, target.Gaji);
		}
		
		System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
	}
	
}
