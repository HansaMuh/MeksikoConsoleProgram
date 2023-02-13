package MeksikoSoftware;

public class ViewMenu 
{

	public ViewMenu()
	{
	}

	public void ViewDatabase()
	{
		Karyawan target;

		SortDatabase();
		
		System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
		System.out.printf("|%-4s|%-17s|%-30s|%-15s|%-14s|%-13s|\n", "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
		System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
		
		for (int I1 = 0; I1 < Main.Database.size(); I1++)
		{
			target = Main.Database.get(I1);
			System.out.printf("|%-4s|%-17s|%-30s|%-15s|%-14s|%-13ld|\n", (I1 + 1),  target.Kode, target.Nama, target.Kelamin, target.Jabatan, target.Gaji);
		}
		
		System.out.printf("|----|-----------------|------------------------------|---------------|--------------|-------------|\n");
	}
	
	public void SortDatabase()
	{
		Karyawan target, secondTarget, tempTarget;
		
		for (int I1 = 0; I1 < Main.Database.size() - 1; I1++)
		{
			for (int I2 = I1 + 1; I2 < Main.Database.size(); I2++)
			{
				target = Main.Database.get(I1);
				secondTarget = Main.Database.get(I2);
				if (target.Nama.compareTo(secondTarget.Nama) > 0)
				{
					tempTarget = target;
					target = secondTarget;
					secondTarget = tempTarget;
				}
			}
		}
	}
	
}
