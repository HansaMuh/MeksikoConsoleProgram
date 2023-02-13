package MeksikoSoftware;

public class UpdateMenu 
{

	public UpdateMenu()
	{
	}
	
	public void InputUpdate()
	{
		Main.MainView.ViewDatabase();
		System.out.printf("Input nomor urutan karyawan yang ingin diperbarui: ");
		int targetIndex = Main.MainInput.DataScanner.nextInt();
		
		if (Main.Database.get(targetIndex - 1) != null)
		{
			System.out.printf("Input data sesuai yang diminta. Jika data yang diminta tidak ingin terubah, isikanlah dengan \"0\".\n");
			UpdateData(targetIndex - 1);
		}
		else
		{
			System.out.printf("Gagal menemukan karyawan dengan nomor urutan tersebut\n");
		}
	}
	
	public void UpdateData(int targetIndex)
	{
		String targetName = "[ERROR]", targetGender = "[ERROR]", targetRole = "[ERROR]";
		
		// Input Name
		while (targetName == "[ERROR]" && targetName != "0")
		{
			targetName = Main.MainInput.InputName();
		}

		// Input Gender
		while (targetGender == "[ERROR]" && targetGender != "0")
		{
			targetGender = Main.MainInput.InputGender();
		}
		
		// Input Role
		while (targetRole == "[ERROR]" && targetRole != "0")
		{
			targetRole = Main.MainInput.InputRole();
		}
		
		Karyawan targetKaryawan = Main.Database.get(targetIndex);
		targetKaryawan.Nama = targetName != "0" ? targetName : targetKaryawan.Nama;
		targetKaryawan.Kelamin = targetGender != "0" ? targetGender : targetKaryawan.Kelamin;
		targetKaryawan.Jabatan = targetRole != "0" ? targetRole : targetKaryawan.Jabatan;
		
		System.out.printf("Berhasil membarui karyawan dengan kode %s\n", targetKaryawan.Kode);
	}
	
}
